
//
// Torbert, 24 July 2013
//
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;
import java.util.ArrayList;
//
public class DisplayPix extends JPanel {
   private PixelOperations pix = new PixelOperations();

   private ImageIcon i = new ImageIcon("images/sprites.png");
   private ImageIcon message = new ImageIcon("images/msg.jpg"); // for encoder/decoder
   private ImageIcon moon = new ImageIcon("images/moon-surface.jpg"); // for chromakey

   private BufferedImage img = new BufferedImage(1600, 1200, BufferedImage.TYPE_INT_RGB);
  
   private Graphics buf = img.getGraphics();

   private boolean clicked = false;
   private ArrayList<Color[][]> stack=new ArrayList<Color[][]>();
   private int x, y;

   public DisplayPix() {
      int w = img.getWidth();
      int h = img.getHeight();
      //
      buf.drawImage(i.getImage(), 0, 0, w, h, null);
   }

   public int getXval() // not getX !
   {
      return x;
   }

   public int getYval() // not getY !
   {
      return y;
   }

   public int getRow() {
      return y * img.getHeight() / getHeight();
   }

   public int getCol() {
      return x * img.getWidth() / getWidth();
   }

   public int getRGB(int x, int y) {
      int xpos = x * img.getWidth() / getWidth();
      int ypos = y * img.getHeight() / getHeight();
      //
      return img.getRGB(xpos, ypos);
   }

   public void update(int xval, int yval) {
      clicked = true;
      //
      x = xval;
      y = yval;
   }

   //
   /**********************************************************************/
   //
   // pixel operations
   //
   public void action(String arr) {
      stack.add(pix.getArray(img));
      Color[][] tmp = pix.getArray(img);
      switch (arr) {
         case "Zero Blue":
            pix.zeroBlue(tmp);
            break;
         case "Negate":
            pix.negate(tmp);
            break;
         case "Grayscale":
            pix.grayScale(tmp);
            break;
         case "Sepia Tone":
            pix.sepia(tmp);
            break;
         case "Blur":
            pix.blur(tmp);
            break;
         case "Pixelate":
            pix.pixelate(tmp);
            break;
         case "Mirror Left-Right":
            pix.mirrorLR(tmp);
            break;
         case "Posterize":
            pix.posterize(tmp);
            break;
         case "Color Splash":
            pix.splash(tmp);
            break;
         case "Mirror Up-Down":
            pix.mirrorUD(tmp);
            break;
         case "Flip Left-Right":
            pix.flipLR(tmp);
            break;
         case "Flip Up-Down":
            pix.flipUD(tmp);
            break;
         case "Sunsetize":
            pix.sunsetize(tmp);
            break;
         case "Remove Red-Eye":
            pix.redeye(tmp);
            break;
         case "Edge Detector":
            pix.detect(tmp);
            break;
         case "Encode":
            buf.drawImage(message.getImage(), 0, 0, img.getWidth(), img.getHeight(), null);
            pix.encode(tmp,pix.getArray(img));
            break;
         case "Decode":
            pix.decode(tmp);
            break;
         case "Chromakey":
            buf.drawImage(moon.getImage(), 0, 0, img.getWidth(), img.getHeight(), null);
            pix.chromakey(tmp,pix.getArray(img));
            break;   
         case "Shuffle":
            pix.shuffle(tmp);
            break;       
      }
      pix.setImage(img, tmp);
   }
   public void undo() {
      if (stack.size()==0) return;
      pix.setImage(img, stack.get(stack.size()-1));
      stack.remove(stack.size()-1);
   }
   //
   // ------> enter your methods below <-----------

   /**********************************************************************/
   //
   public void resetImage() {
      int w = img.getWidth();
      int h = img.getHeight();
      //
      buf.drawImage(i.getImage(), 0, 0, w, h, null);
   }

   public boolean openImage() {
      int w = img.getWidth();
      int h = img.getHeight();
      //
      JFileChooser fc = new JFileChooser("images");
      fc.showOpenDialog(null);
      File f = fc.getSelectedFile();
      //
      try {
         i = new ImageIcon("images/" + f.getName());
      } catch (Exception e) {
         return false;
      }
      buf.drawImage(i.getImage(), 0, 0, w, h, null);
      //
      return true;
   }

   public void up() {
      y = y == 0 ? y : y - 1;
   }

   public void down() {
      y = y == getHeight() - 1 ? y : y + 1;
   }

   public void left() {
      x = x == 0 ? x : x - 1;
   }

   public void right() {
      x = x == getWidth() - 1 ? x : x + 1;
   }

   public void paintComponent(Graphics g) {
      g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
      //
      if (clicked) {
         g.setColor(Color.black);
         g.drawLine(x - 5, y - 1, x + 5, y - 1);
         g.drawLine(x - 5, y + 1, x + 5, y + 1);
         g.drawLine(x - 1, y - 5, x - 1, y + 5);
         g.drawLine(x + 1, y - 5, x + 1, y + 5);
         //
         g.setColor(Color.yellow);
         g.drawLine(x - 5, y, x - 1, y);
         g.drawLine(x + 1, y, x + 5, y);
         g.drawLine(x, y - 5, x, y - 1);
         g.drawLine(x, y + 1, x, y + 5);
      }

   }
}
//
// end of file
//