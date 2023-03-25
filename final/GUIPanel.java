import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIPanel extends JPanel {
    private DisplayPanel gfx;
    private Hotbar hotbar;
    public GUIPanel() {
        setLayout(new BorderLayout());
        hotbar = new Hotbar();
        add(hotbar, BorderLayout.SOUTH);

        gfx = new DisplayPanel(hotbar);
        add(gfx, BorderLayout.CENTER);

        setFocusable(true);
        addKeyListener(new KeyListener());
        gfx.addMouseListener(new mouse());
        gfx.addMouseMotionListener(new MouseMoveListener());
        requestFocus();

    }

    public class MouseMoveListener implements MouseMotionListener {
        public void mouseDragged(MouseEvent e) {
            if (e.getModifiersEx() == 1024) { // left
                gfx.leftClick(e.getX(), e.getY());
            }
            if (e.getModifiersEx() == 4096) { // right
                gfx.rightClick(e.getX(), e.getY());
            }

        }

        public void mouseMoved(MouseEvent e) {
            gfx.select(e.getX(), e.getY());

        }
    }

    public class mouse implements MouseListener {
        public void mouseExited(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                gfx.leftClick(e.getX(), e.getY());
            }
            if (e.getButton() == MouseEvent.BUTTON3) {
                gfx.rightClick(e.getX(), e.getY());
            }

        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }
    }

    public class moveMoveListener implements MouseWheelListener {
        public void mouseWheelMoved(MouseWheelEvent e) {
        }
    }

    public class KeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_LEFT:
                    hotbar.move(-1);
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_RIGHT:
                    hotbar.move(1);
                    break;
                case KeyEvent.VK_W:
                case KeyEvent.VK_D:
                    gfx.w(true);
                    break;
                case KeyEvent.VK_S:
                case KeyEvent.VK_A:
                    gfx.s(true);
                    break;
                case KeyEvent.VK_SPACE:
                    gfx.space(true);
                    break;
                default:
                    return;

            }
            gfx.repaint();
        }

        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                case KeyEvent.VK_D:
                    gfx.w(false);
                    break;
                case KeyEvent.VK_S:
                case KeyEvent.VK_A:
                    gfx.s(false);
                    break;
                case KeyEvent.VK_SPACE:
                    gfx.space(false);
                    break;
                default:
                    return;

            }
            gfx.repaint();
        }

    }

    public DisplayPanel getGfx() {
        return gfx;
    }
}
