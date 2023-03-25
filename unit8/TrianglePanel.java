import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class TrianglePanel extends JPanel {
   public static final int FRAME = 400;
   private static final Color BACKGROUND = new Color(204, 204, 204);
   private BufferedImage myImage;
   private Graphics myBuffer;
   private Triangle triangle;

   public TrianglePanel() {
      myImage = new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME, FRAME);
      triangle = new Triangle(new int[] { 100, 200, 300 }, new int[] { 300, 150, 300 },
            new Color(230, 120, 20));
      repaint();
   }

   public void paintComponent(Graphics g) // Required method to paint to the screen
   {
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, getWidth(), getHeight());
      myBuffer.setColor(triangle.color);
      myBuffer.fillPolygon(triangle.x, triangle.y, 3);
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null); // Draw the buffered image we've stored as a field
      requestFocus();
   }

   public void up() {
      triangle = triangle.minY() == 0 ? triangle
            : new Triangle(triangle.x, new int[] { triangle.y[0] - 1, triangle.y[1] - 1, triangle.y[2] - 1 },
                  triangle.color);
      repaint();
   }

   public void left() {
      triangle = triangle.minX() == 0 ? triangle
            : new Triangle(new int[] { triangle.x[0] - 1, triangle.x[1] - 1, triangle.x[2] - 1 }, triangle.y,
                  triangle.color);
      repaint();
   }

   public void right() {
      triangle = triangle.maxX() == getHeight() - 1 ? triangle
            : new Triangle(new int[] { triangle.x[0] + 1, triangle.x[1] + 1, triangle.x[2] + 1 }, triangle.y,
                  triangle.color);
      repaint();
   }

   public void down() {
      triangle = triangle.maxY() == getHeight() - 1 ? triangle
            : new Triangle(triangle.x, new int[] { triangle.y[0] + 1, triangle.y[1] + 1, triangle.y[2] + 1 },
                  triangle.color);
      repaint();
   }

   public void newTriangle(int r, int g, int b, int height, int width) {
      triangle = new Triangle(new int[] { 200 - (int) (width / 2), 200, (int) (200 + width / 2) },
            new int[] { 150 + height, 150, 150 + height },
            new Color(r,g,b));
      repaint();
   }

}
