import edu.fcps.karel2.Display;
public class PictoBotDemo
{  
   public static void main(String[] args)
   {
      Display.openWorld("maps/PictoBot11.map");  //Test on picto1.map, picto2.map, and picto3.map
      Display.setSize(10,10);
      Display.setSpeed(10);      
      //picto pollock = new picto();  //Only a default constructor
     PictoBot pollock=new PictoBot();
      pollock.rotate();
      
      //Test all three maps given above.
      //Aside from changing the map, don't modify this file.
      //(Though, if you want to see the maps before you start coding, you can comment out the PictoBot lines so you can do that.)
      //If your PictoBot rotates each pictograph 90 degrees, you win!
   }
}