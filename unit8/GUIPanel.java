import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class GUIPanel extends JPanel {
    TrianglePanel gfx;
    JTextField r;
    JTextField g;
    JTextField b;
    JTextField height;
    JTextField width;

    public GUIPanel() {
     
        setLayout(new BorderLayout());
        JLabel title = new JLabel("The moving triangle!");
        title.setFont(new Font("Serif", Font.BOLD, 20));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);
        JPanel west = new JPanel();
        west.setLayout(new GridLayout(5, 3));
        r = new JTextField("0", 3);
        g = new JTextField("0", 3);
        b = new JTextField("0", 3);
        height = new JTextField("0", 3);
        width = new JTextField("0", 3);
        west.add(new JLabel());
        west.add(new Label("Red:"));
        west.add(r);
        west.add(new JLabel());
        west.add(new Label("Green:"));
        west.add(g);
        west.add(new JLabel());
        west.add(new Label("Blue:"));
        west.add(b);
        west.add(new JLabel());
        west.add(new Label("Height:"));
        west.add(height);
        west.add(new JLabel());
        west.add(new Label("Width:"));
        west.add(width);
        add(west, BorderLayout.WEST);
        JPanel east=new JPanel();
        east.setLayout(new GridLayout(5,3));
        JButton btn0=new JButton("^");
        btn0.addActionListener(new arrow_clicked());
        JButton btn1=new JButton("<");
        btn1.addActionListener(new arrow_clicked());
        JButton btn2=new JButton(">");
        btn2.addActionListener(new arrow_clicked());
        JButton btn3=new JButton("v");
        btn3.addActionListener(new arrow_clicked());
        east.add(new JLabel());
        east.add(new JLabel());
        east.add(new JLabel());
        east.add(new JLabel());
        east.add(btn0);
        east.add(new JLabel());
        east.add(btn1);
        east.add(new JLabel());
        east.add(btn2);
        east.add(new JLabel());
        east.add(btn3);
        east.add(new JLabel());
        east.add(new JLabel());
        add(east,BorderLayout.EAST);
        gfx = new TrianglePanel();  //Put the graphics panel in the center
        gfx.addKeyListener(new Key());;
        gfx.setFocusable(true);
        add(gfx);
        JPanel south=new JPanel();
        JButton btnz=new JButton("Generate a new Triangle!");
        btnz.addActionListener(new gen_clicked());
        south.add(btnz);
        add(south,BorderLayout.SOUTH);
    }
    private class arrow_clicked implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand()) {
                case "^":
                    gfx.up();
                    break;
                case "<":
                    gfx.left();
                    break;
                case ">":
                    gfx.right();
                    break;
                case "v":
                    gfx.down();
                    break;
            }
            gfx.repaint();
        }
    }
    public class Key extends KeyAdapter  {
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                  gfx.up();
                  break;
                case KeyEvent.VK_LEFT:
                  gfx.left();
                  break;
               case KeyEvent.VK_RIGHT:
                    gfx.right();
                    break;
               case KeyEvent.VK_DOWN:
                  gfx.down();
                  break;
                default:
                    return;
             
            }
        }

    }
    private class gen_clicked implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            gfx.newTriangle(Integer.parseInt(r.getText()),Integer.parseInt(g.getText()),Integer.parseInt(b.getText()),Integer.parseInt(height.getText()),Integer.parseInt(width.getText()));
        }
    }
}

