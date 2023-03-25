import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PanelPix extends JPanel {

   private DisplayPix display;

   private ScoreboardPix scoreboard;
   private static final String[] btns = new String[] {
         "Zero Blue", "Negate", "Grayscale", "Sepia Tone", "Blur",
         "Posterize", "Color Splash", "Mirror Left-Right", "Mirror Up-Down",
         "Flip Left-Right", "Flip Up-Down", "Pixelate", "Sunsetize",
         "Remove Red-Eye", "Edge Detector", "Encode", "Decode", "Chromakey", "Shuffle"
      };

   public PanelPix() {
      setLayout(new BorderLayout());
      scoreboard = new ScoreboardPix();
      add(scoreboard, BorderLayout.NORTH);
      JPanel east = new JPanel();
      east.setLayout(new GridLayout(btns.length, 1));
      for (String btn : btns) {
         JButton tmp = new JButton(btn);
         tmp.addActionListener(new Listener_btn());
         east.add(tmp);
      }
      add(east, BorderLayout.EAST);
      //
      // center
      //
      display = new DisplayPix();
      display.addMouseListener(new Mouse());

      display.addKeyListener(new Key());
      display.setFocusable(true);
      add(display, BorderLayout.CENTER);
      //
      // south
      //
      JPanel south = new JPanel();
      south.setLayout(new FlowLayout());
      JButton restore = new JButton("Restore Original Image");
      restore.addActionListener(new Listener_restore());
      south.add(restore);
      JButton openimg = new JButton("Open an Image File");
      openimg.addActionListener(new Listener_openimg());
      south.add(openimg);
      JButton undo = new JButton("Undo");
      undo.addActionListener(new Listener_undo());
      south.add(undo);
      add(south, BorderLayout.SOUTH);
   }

   //
   /**********************************************************************/
   //
   // pixel operation listener

   private class Listener_btn implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         display.action(e.getActionCommand());
         update(display.getXval(), display.getYval());
      }
   }
   private class Listener_undo implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         display.undo();
         update(display.getXval(), display.getYval());
      }
   }
   // ----------> add more Listeners here <-----------

   //
   /**********************************************************************/
   //
   private class Listener_restore implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         display.resetImage();
         update(display.getXval(), display.getYval());
      }
   }

   private class Listener_openimg implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if (display.openImage()) {
            update(display.getXval(), display.getYval());
         }
      }
   }

   private class Mouse extends MouseAdapter {
      public void mouseClicked(MouseEvent e) {
         update(e.getX(), e.getY());
      }
   }

   private class Key extends KeyAdapter {
      public void keyPressed(KeyEvent e) {
         switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
               display.up();
               break;
            case KeyEvent.VK_DOWN:
               display.down();
               break;
            case KeyEvent.VK_LEFT:
               display.left();
               break;
            case KeyEvent.VK_RIGHT:
               display.right();
               break;
         }
         //
         update(display.getXval(), display.getYval());
      }
   }

   private void update(int x, int y) {
      int rgb = display.getRGB(x, y);
      //
      display.update(x, y);
      scoreboard.update(display.getCol(), display.getRow(), rgb);
      //
      display.repaint();
      //
      display.requestFocus();
   }
}
//
// end of file
//