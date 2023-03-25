
//
// Torbert, 24 July 2013
//
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
public class PixelOperations {
   public Color[][] getArray(BufferedImage img) {
      Color[][] arr;
      //
      int numcols = img.getWidth();
      int numrows = img.getHeight();
      //
      arr = new Color[numrows][numcols];
      //
      for (int j = 0; j < arr.length; j++) {
         for (int k = 0; k < arr[0].length; k++) {
            int rgb = img.getRGB(k, j);
            //
            arr[j][k] = new Color(rgb);
         }
      }
      //
      return arr;
   }

   public void setImage(BufferedImage img, Color[][] arr) {
      for (int j = 0; j < arr.length; j++) {
         for (int k = 0; k < arr[0].length; k++) {
            Color tmp = arr[j][k];
            //
            int rgb = tmp.getRGB();
            //
            img.setRGB(k, j, rgb);
         }
      }
   }

   //
   /**********************************************************************/
   //
   // pixel operations
   //
   public void zeroBlue(Color[][] arr) {
      for (int j = 0; j < arr.length; j++) {
         for (int k = 0; k < arr[0].length; k++) {
            Color tmp = arr[j][k];
            arr[j][k] = new Color(tmp.getRed(), tmp.getGreen(), 0);
         }
      }
   }

   public void negate(Color[][] arr) {
      for (int j = 0; j < arr.length; j++) {
         for (int k = 0; k < arr[0].length; k++) {
            Color tmp = arr[j][k];
            arr[j][k] = new Color(255 - tmp.getRed(), 255 - tmp.getGreen(), 255 - tmp.getBlue());
         }
      }
   }

   public void grayScale(Color[][] arr) {
      for (int j = 0; j < arr.length; j++) {
         for (int k = 0; k < arr[0].length; k++) {
            Color tmp = arr[j][k];
            int avg = (int) (0.3 * tmp.getRed() + 0.59 * tmp.getGreen() + 0.11 * tmp.getBlue());
            arr[j][k] = new Color(avg, avg, avg);
         }
      }
   }

   public void sepia(Color[][] arr) {
      for (int j = 0; j < arr.length; j++) {
         for (int k = 0; k < arr[0].length; k++) {
            Color tmp = arr[j][k];
            int red = (int) (0.393 * tmp.getRed() + 0.769 * tmp.getGreen() + 0.189 * tmp.getBlue());
            int green = (int) (0.349 * tmp.getRed() + 0.686 * tmp.getGreen() + 0.168 * tmp.getBlue());
            int blue = (int) (0.272 * tmp.getRed() + 0.534 * tmp.getGreen() + 0.131 * tmp.getBlue());
            arr[j][k] = new Color(red > 255 ? 255 : red, green > 255 ? 255 : green, blue > 255 ? 255 : blue);
         }
      }
   }

   public void blur(Color[][] arr) {
      for (int j = 0; j < arr.length; j++) {
         for (int k = 0; k < arr[0].length; k++) {
            Color tmp = arr[j][k];
            ArrayList<Color> values = new ArrayList<Color>();
            values.add(tmp);
            if (j > 0)
               values.add(arr[j - 1][k]);
            if (k > 0)
               values.add(arr[j][k - 1]);
            if (j < arr.length - 1)
               values.add(arr[j + 1][k]);
            if (k < arr[0].length - 1)
               values.add(arr[j][k + 1]);
            int red = 0;
            int green = 0;
            int blue = 0;
            for (Color color : values) {
               red += color.getRed();
               green += color.getGreen();
               blue += color.getBlue();
            }
            arr[j][k] = new Color((int) (red / values.size()), (int) (green / values.size()),
                  (int) (blue / values.size()));
         }
      }
   }

   public void pixelate(Color[][] arr) {
      for (int j = 0; j < arr.length; j += 10) {
         for (int k = 0; k < arr[0].length; k += 10) {
            Color tmp = arr[j][k];
            for (int l = 0; l < 10; l++) {
               for (int p = 0; p < 10; p++) {
                  arr[l + j][p + k] = tmp;
               }
            }
         }
      }
   }

   public void mirrorLR(Color[][] arr) {
      for (int j = 0; j < arr.length; j++) {
         for (int k = 0; k < arr[0].length / 2; k++) {
            arr[j][arr[0].length - 1 - k] = arr[j][k];
         }
      }
   }

   public void posterize(Color[][] arr) {
      for (int j = 0; j < arr.length; j++) {
         for (int k = 0; k < arr[0].length; k++) {
            Color tmp = arr[j][k];
            arr[j][k] = new Color(tmp.getRed() > 150 ? 200 : tmp.getRed() < 100 ? 50 : 125,
                  tmp.getGreen() > 150 ? 200 : tmp.getGreen() < 100 ? 50 : 125,
                  tmp.getBlue() > 150 ? 200 : tmp.getBlue() < 100 ? 50 : 125);
         }
      }
   }

   public void splash(Color[][] arr) {
      for (int j = 0; j < arr.length; j++) {
         for (int k = 0; k < arr[0].length; k++) {
            Color tmp = arr[j][k];
            int avg = (int) (0.3 * tmp.getRed() + 0.59 * tmp.getGreen() + 0.11 * tmp.getBlue());
            arr[j][k] = tmp.getRed() > tmp.getGreen() + tmp.getBlue() ? tmp : new Color(avg, avg, avg);
         }
      }
   }

   public void mirrorUD(Color[][] arr) {
      for (int j = 0; j < arr.length / 2; j++) {
         for (int k = 0; k < arr[0].length; k++) {
            arr[arr.length - 1 - j][k] = arr[j][k];
         }
      }
   }

   private static Color[][] swap(Color[][] arr, int x1, int y1, int x2, int y2) {
      Color tmp = arr[x1][y1];
      arr[x1][y1] = arr[x2][y2];
      arr[x2][y2] = tmp;
      return arr;
   }

   public void flipUD(Color[][] arr) {
      for (int j = 0; j < arr.length / 2; j++) {
         for (int k = 0; k < arr[0].length; k++) {
            arr = swap(arr, j, k, arr.length - 1 - j, k);
         }
      }
   }

   public void flipLR(Color[][] arr) {
      for (int j = 0; j < arr.length; j++) {
         for (int k = 0; k < arr[0].length / 2; k++) {
            arr = swap(arr, j, k, j, arr[0].length - 1 - k);
         }
      }
   }

   public void sunsetize(Color[][] arr) {
      for (int j = 0; j < arr.length; j++) {
         for (int k = 0; k < arr[0].length; k++) {
            Color tmp = arr[j][k];
            arr[j][k] = new Color(tmp.getRed(), (int) (0.8 * tmp.getGreen()), (int) (0.8 * tmp.getBlue()));
         }
      }
   }

   public void redeye(Color[][] arr) {
      for (int j = 425; j < 475; j++) {
         for (int k = 670; k < 1000; k++) {
            Color tmp = arr[j][k];
            if (k > 722 && k < 940)
               continue;
            arr[j][k] = (tmp.getRed() > 120 && tmp.getGreen() < 100 && tmp.getBlue() < 100)
                  || (tmp.getRed() > 200 && tmp.getGreen() + tmp.getBlue() < 100)
                        ? new Color(0, tmp.getGreen(), tmp.getBlue())
                        : tmp;
         }
      }
   }
   public void detect(Color[][] arr) {
      for (int j = 1; j < arr.length-1; j++) {
         for (int k = 1; k < arr[0].length-1; k++) {
            Color tmp = arr[j][k];
            int[] neighbors=new int[] {avg(arr[j - 1][k]),avg(arr[j][k - 1]),avg(arr[j + 1][k]),avg(arr[j][k + 1])};
            for (int color : neighbors) {
               if (Math.abs(color-avg(tmp))<20) {
                  arr[j][k]=new Color(0);
                  break;
               }
               
            }
            if (!arr[j][k].equals(new Color(0))) arr[j][k]=new Color(255,255,255);
         }
      }
   }
   private int avg(Color tmp) {
      return (int) (0.3 * tmp.getRed() + 0.59 * tmp.getGreen() + 0.11 * tmp.getBlue());
   }
   public void encode(Color[][] arr,Color[][] msg) {
      for (int j=0;j<arr.length;j++) {
         for (int k=0;k<arr[0].length;k++) {
            Color tmp=arr[j][k];
            if (msg[j][k].getRed()<10 && msg[j][k].getGreen()<10 && msg[j][k].getBlue()<10 ) {
               if (tmp.getRed()%2==0) {
                     arr[j][k]=new Color(tmp.getRed()==255?254:tmp.getRed()+1,tmp.getGreen(),tmp.getBlue());
               } 
            } else {
               if (tmp.getRed()%2==1)  {
                  arr[j][k]=new Color(tmp.getRed()==255?254:tmp.getRed()+1,tmp.getGreen(),tmp.getBlue());
               }
            }
         }
      }
   }
   public void decode(Color[][] arr) {
      for (int j=0;j<arr.length;j++) {
         for (int k=0;k<arr[0].length;k++) {
            Color tmp=arr[j][k];
            if (tmp.getRed()%2==1) {
               arr[j][k]=new Color(0,0,0);
            } else {
               arr[j][k]=new Color(255,255,255);
            }
         }
      }
   }
   public void chromakey(Color[][] arr,Color[][] bckgrnd) {
      for (int j=0;j<arr.length;j++) {
         for (int k=0;k<arr[0].length;k++) {
            if (arr[j][k].getRed()<20 && arr[j][k].getGreen()<50) {
               arr[j][k]=bckgrnd[j][k];
            }
         }
      }
   }
   public void shuffle(Color[][] arr) {
      ArrayList<int[]> indice=new ArrayList<int[]>();
      ArrayList<int[]> indice1=new ArrayList<int[]>();
      for (int j=0;j<arr.length;j+=100) {
         for (int k=0;k<arr[0].length;k+=100) {
            indice.add(new int[]{j,k});
            indice1.add(new int[]{j,k});
         }
      }
      Collections.shuffle(indice);
      for (int i=0;i<indice.size();i++) {
         for (int j=0;j<100;j++) {
            for (int k=0;k<100;k++) {
               arr=swap(arr,indice.get(i)[0]+j,indice.get(i)[1]+k,indice1.get(i)[0]+j,indice1.get(i)[1]+k);
            }
         }
      }
   }
  
}
//
// end of file
//