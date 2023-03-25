import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DisplayPanel extends JPanel {
	private static final Color SKY = new Color(170, 255, 255);
	private static final int SPRITEWIDTH = 1600; // sprites are 1600, 16 x 16, so 100px x 100px blocks
	private static final int SPRITEHEIGHT = 1600; // sprites are 1600, 16 x 16, so 100px x 100px blocks
	private static final int SPRITEFRAME = 100;
	private static final int DISPLAYFRAME = 80;
	private static final int HEIGHT = 100;
	private static final int WIDTH = 1000;
	private static final int DISPLAYHEIGHT = 8;
	private static final int DISPLAYWIDTH = 16;
	private static final int playerX = (int) ((DISPLAYWIDTH - 1) / 2);
	private static final int playerY = (int) ((DISPLAYHEIGHT - 1) / 2);
	private static final int LEFT = 1, RIGHT = 2, UP = 3, DOWN = 4;
	private BufferedImage img, sptImg;
	private Graphics buf, sptBuf;
	private ImageIcon i = new ImageIcon("img/sprites.png");
	private Block[][] board; // 500 x 100
	private double x, y;
	private int selectX = 0, selectY = 0;
	private Timer t, st;
	private boolean w = false;
	private boolean s = false;
	private boolean space = false;
	private int facing = RIGHT;
	private Hotbar hotbar;

	public DisplayPanel(Hotbar hotbar) {
		this.hotbar = hotbar; // sets hotbar

		// set img and buf of sprites
		sptImg = new BufferedImage(SPRITEWIDTH, SPRITEHEIGHT, BufferedImage.TYPE_INT_RGB);
		sptBuf = sptImg.getGraphics();
		sptBuf.drawImage(i.getImage(), 0, 0, sptImg.getWidth(), sptImg.getHeight(), null);

		// display is 1200 x 560, each block is 80 x 80, so 15 blocks by 7 blocks
		img = new BufferedImage(DISPLAYWIDTH * DISPLAYFRAME, DISPLAYHEIGHT * DISPLAYFRAME,
				BufferedImage.TYPE_INT_RGB);
		buf = img.getGraphics();
		board = new Block[HEIGHT][WIDTH];

		Scanner reader = new Scanner(System.in);
		System.out.print("Enter L to load the previous game save, or R to generate a new board: ");
		String n = reader.nextLine();
		reader.close();

		if (n.toLowerCase().equals("r")) { // if r generate new board
			generateTerrain();
			x = 500; // spawnpoint
			y = 10;
		} else { // else read board from file
			readBoard(); // reads spawnpoint
		}

		t = new Timer(10, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				animate();
			}
		});
		t.start(); // start animation

	}

	public void paintComponent(Graphics g) {
		for (int i = -1; i < DISPLAYWIDTH + 1; i++) {
			for (int j = -1; j < DISPLAYHEIGHT + 1; j++) {
				// prints a one block border on each side to account for decimal x and y values
				paintBlock((int) ((i - x % 1) * DISPLAYFRAME),
						(int) ((j - y % 1) * DISPLAYFRAME), board[j + (int) y - playerY][i + (int) x - playerX]);

			}
		}

		paintPlayer();

		buf.setColor(Color.BLACK);
		buf.drawRect((int) ((selectX - x % 1) * DISPLAYFRAME), (int) ((selectY - y % 1) * DISPLAYFRAME),
				DISPLAYFRAME,
				DISPLAYFRAME);

		g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), null);

	}

	public void leftClick(int x, int y) {
		// accounts for offset and gets x and y of block clicked
		int _x = (int) ((int) this.x - playerX + (x + this.x % 1 * DISPLAYFRAME) / DISPLAYFRAME);
		int _y = (int) ((int) this.y - playerY + (y + this.y % 1 * DISPLAYFRAME) / DISPLAYFRAME);
		if (!(equal(_y, _x, "Air") || equal(_y, _x, "Bedrock"))) {
			// if not air and not bedrock, switch to air, and add block to hotbar
			hotbar.addBlock(board[_y][_x]);
			board[_y][_x] = new Air();
		}

		select(x, y);
	}

	public void rightClick(int x, int y) {
		int _x = (int) ((int) this.x - playerX + (x + this.x % 1 * DISPLAYFRAME) / DISPLAYFRAME);
		int _y = (int) ((int) this.y - playerY + (y + this.y % 1 * DISPLAYFRAME) / DISPLAYFRAME);
		if (equal(_y, _x, "Air") && hotbar.placeable()) {
			try {
				board[_y][_x] = (Block) Class.forName(hotbar.getSelected()).getDeclaredConstructor().newInstance();
				hotbar.removeBlock(hotbar.getSelected());
			} catch (Exception e) {

			}
		}

		select(x, y);
	}

	private void gravity() {
		if (y < HEIGHT - DISPLAYHEIGHT + playerY) { // triggers every animation
			int block = getBlock(); // get block gets closest block that is not permeable under player
			if (block <= y) { //
				return; // if block is higher than current y return
			}
			if (Math.abs(block - y) <= 0.2) {
				y = block;
			} else {
				y += 0.2;
			}

		}
	}

	private boolean rand(int num) {
		return rnd(Math.random() * num, DOWN) == 0;
	}

	public void select(int x, int y) {
		selectX = rnd((x + this.x % 1 * DISPLAYFRAME) / DISPLAYFRAME, DOWN);
		selectY = rnd((y + this.y % 1 * DISPLAYFRAME) / DISPLAYFRAME, DOWN);
	}

	private boolean equal(int row, int col, String name) {
		return board[row][col].toString().equals(name);
	}

	private int getBlock() {
		// Player is height 2, x and y coord is top left of player so when you find a
		// block you return 2 higher to place player
		// similarly start searching 2 lower, and assume player isn't on a block already
		if (isInt(x)) {
			for (int row = (int) y + 2; row < HEIGHT; row++) {
				if (!board[row][(int) x].permeable())
					return row - 2;
			}
		} else {
			for (int row = (int) y + 2; row < HEIGHT; row++) {
				if (!board[row][rnd(x, DOWN)].permeable() || !board[row][rnd(x, UP)].permeable())
					return row - 2;
			}
		}
		return -1;
	}

	public int rnd(double num, int dir) {
		return (int) (dir == UP ? Math.ceil(num) : Math.floor(num));
	}

	private boolean directionClear(int direction) {
		switch (direction) {
			case LEFT:
				if (x == playerX + 2) {
					return false;
				}
				if (isInt(y)) {
					return board[(int) y][rnd(x, UP) - 1].permeable()
							&& board[(int) y + 1][rnd(x, UP) - 1].permeable();
				} else {
					return board[rnd(y, UP) - 1][rnd(x, UP) - 1].permeable()
							&& board[rnd(y, UP)][rnd(x, UP) - 1].permeable()
							&& board[rnd(y, UP) + 1][rnd(x, UP) - 1].permeable();
				}
			case RIGHT:
				if (x == WIDTH - DISPLAYWIDTH + playerX - 1) {
					return false;
				}
				if (isInt(y)) {
					return board[(int) y][(int) x + 1].permeable()
							&& board[(int) y + 1][(int) x + 1].permeable();
				} else {
					return board[(int) y][(int) x + 1].permeable()
							&& board[(int) y + 1][(int) x + 1].permeable()
							&& board[(int) y + 2][(int) x + 1].permeable();
				}
			case UP:
				if (y == 0) {
					return false;
				}
				if (isInt(x)) {
					return board[rnd(y, UP) - 1][(int) x].permeable();
				} else {
					return board[rnd(y, UP) - 1][(int) x].permeable() && board[rnd(y, UP) - 1][(int) x + 1].permeable();
				}

			case DOWN:
				if (y == WIDTH - DISPLAYWIDTH) {
					return false;
				}
				if (isInt(x)) {
					return board[(int) y + 1][(int) x].permeable();

				} else {
					return board[(int) y + 1][(int) x].permeable() && board[(int) y + 1][(int) x + 1].permeable();
				}
			default:
				return false;
		}
	}

	public void w(boolean clicked) {
		w = clicked;

	}

	public void s(boolean clicked) {
		s = clicked;

	}

	public void space(boolean clicked) {
		space = clicked;

	}

	private boolean isInt(double num) {
		return (int) num == num;
	}

	private void animate() {
		if (w) {
			facing = RIGHT;
			if (directionClear(RIGHT)) {
				x += 0.2;
			}
		}
		if (s) {
			facing = LEFT;
			if (directionClear(LEFT)) {
				x -= 0.2;
			}
		}
		if (space && y == getBlock() && st == null) {
			st = new Timer(5, new ActionListener() {
				int i = 0;

				public void actionPerformed(ActionEvent e) {
					if (i > 1 && directionClear(UP)) {
						y -= 0.5;
					}
					i++;
					if (i == 10) {
						st.stop();
						st = null;
					}
				}
			});
			st.start();
		}
		gravity();

		x = Math.round(10 * x) / 10.0;
		y = Math.round(10 * y) / 10.0;

		repaint();
	}

	private void saveBoard() {
		try {
			FileWriter writer = new FileWriter("board.txt");
			for (Block[] row : board) {
				for (Block block : row) {
					writer.write(block.toString() + " ");
				}
				writer.write("\n");
			}
			writer.write(String.format("%f\n%f", x, y)); // x and y coord are stored at the end
			for (Tuple items : hotbar.getHotbar()) {
				writer.write("\n" + items.count + " " + items.msg);
			}
			writer.close();
		} catch (IOException e) {
			return;
		}
	}

	private void readBoard() {
		try {
			Scanner reader = new Scanner(new File("board.txt"));
			for (int i = 0; i < HEIGHT; i++) {
				String[] line = reader.nextLine().split(" ");
				for (int j = 0; j < WIDTH; j++) {
					board[i][j] = (Block) Class.forName(line[j]).getDeclaredConstructor().newInstance();
				}
			}

			x = Double.parseDouble(reader.nextLine());
			y = Double.parseDouble(reader.nextLine());

			Tuple[] showing = new Tuple[8];
			for (int i = 0; i < 8; i++) {
				String[] line = reader.nextLine().split(" ");
				showing[i] = new Tuple(null, line.length == 2 ? line[1] : "", Integer.parseInt(line[0]));

			}
			hotbar.set(showing);

			reader.close();
		} catch (FileNotFoundException e) {
			generateTerrain();
			return;

		} catch (Exception e) {
			return;
		}

	}

	private void paintBlock(int x, int y, Block block) {
		if (block.toString().equals("Air")) {
			buf.setColor(SKY);
			buf.fillRect(x, y, DISPLAYFRAME, DISPLAYFRAME);
		} else {

			buf.drawImage(sptImg.getSubimage(block.x() * SPRITEFRAME,
					block.y() * SPRITEFRAME, SPRITEFRAME,
					SPRITEFRAME),
					x, y, DISPLAYFRAME,
					DISPLAYFRAME, null);
		}
	}

	private void paintPlayer() {
		int startX = playerX * DISPLAYFRAME;
		int startY = playerY * DISPLAYFRAME;

		/// head
		buf.setColor(Color.YELLOW);
		buf.fillRect(startX, startY + 45, DISPLAYFRAME, 35);
		buf.setColor(Color.BLACK);
		buf.fillRect(startX, startY, DISPLAYFRAME, 45);
		if (facing == RIGHT) {
			buf.fillRect(startX, startY + 45, 30, 20);
			buf.fillRect(startX + 30, startY + 45, 10, 10);
			buf.fillRect(startX + 75, startY + 45, 5, 5);
		} else {
			buf.fillRect(startX + 50, startY + 45, 30, 20);
			buf.fillRect(startX + 40, startY + 45, 10, 10);
			buf.fillRect(startX, startY + 45, 5, 5);
		}

		int offset = facing == RIGHT ? 20 : 30; // direction facing, make body angled to that direction

		buf.setColor(Color.CYAN);
		buf.fillRect(startX + offset, startY + 80, 35, 10);

		buf.setColor(Color.YELLOW);
		buf.fillRect(startX + offset, startY + 90, 35, 30);

		buf.setColor(Color.BLUE);
		buf.fillRect(startX + offset, startY + 120, 35, 35);

		buf.setColor(Color.GRAY);
		buf.fillRect(startX + offset, startY + 155, 35, 5);
	}

	private void generateTerrain() {
		int grassPos = 30;
		int tree = 10;
		int grove = 0;
		int currentTree = (int) (4 * Math.random());
		for (int col = 0; col < WIDTH; col++) {
			int dirtCount = (int) (4 + 2 * Math.random()); // rand number between 4 and 5
			int rand = (int) (5 * Math.random());
			tree = Math.max(0, tree - 1);
			if (grassPos < 10 || rand == 0) {
				grassPos++;
			} else if (grassPos > 40 || rand == 1) {
				grassPos--;
			}
			for (int row = 0; row < HEIGHT; row++) {
				if (row == grassPos) {
					board[grassPos][col] = new Grass();
				} else if (row == HEIGHT - 5) {
					board[row][col] = new Bedrock();
				} else if (row >= HEIGHT - 4 || row < grassPos) {
					board[row][col] = new Air();
				} else if (row > grassPos && row < grassPos + dirtCount) {
					board[row][col] = new Dirt();
				} else { // stone
					if (row > 60 && rand(75)) {
						board[row][col] = new Diamond_Ore();
					} else if (row > 50 && rand(40)) {
						board[row][col] = new Gold_Ore();
					} else if (row > 80 && rand(30)) {
						board[row][col] = new Redstone_Ore();
					} else if (row > 45 && rand(30)) {
						board[row][col] = new Iron_Ore();
					} else if (row < 75 && rand(20)) {
						board[row][col] = new Coal_Ore();
					} else {
						board[row][col] = new Stone();
					}
				}
			}
			if (tree == 0) {
				if (grove == 0 && rand(15)) {
					grove = (int) (5 * Math.random() + 3);
				}
				if (grove > 0) {
					if (rand(5)) {
						tree = 3;
						for (int i = 1; i < (int) (5 + 2 * Math.random()); i++) {
							switch (currentTree) {
								case 0:
									board[grassPos - i][col] = new Spruce();
									break;
								case 1:
									board[grassPos - i][col] = new Birch();
									break;
								default:
									board[grassPos - i][col] = new Oak();
									break;
							}
						}
						grove--;
					}
				} else {
					currentTree = (int) (4 * Math.random());
				}
			}
		}
		for (int col = 0; col < WIDTH - 3; col++) {
			for (int row = 0; row < HEIGHT; row++) {
				if (equal(row, col, "Oak") || equal(row, col, "Spruce") || equal(row, col, "Birch")) {
					board[row - 2][col] = new Leaves();
					board[row - 1][col] = new Leaves();
					board[row - 1][col + 1] = new Leaves();
					board[row - 1][col - 1] = new Leaves();
					if (rand(2)) {
						board[row - 3][col] = new Leaves();
						board[row - 2][col + 1] = new Leaves();
						board[row - 2][col - 1] = new Leaves();
						board[row - 1][col + 2] = new Leaves();
						board[row - 1][col - 2] = new Leaves();
						if (rand(2)) {
							board[row - 3][col + 1] = new Leaves();
							board[row - 3][col - 1] = new Leaves();
							board[row - 2][col + 2] = new Leaves();
							board[row - 2][col - 2] = new Leaves();
						}
					}

					break;
				}
			}
		}

	}

	public void onClose() {
		saveBoard(); // saves board to file
	}
}
