public class PlavaRose implements Plant
{
   //Fields
   private int height;
   private int blooms;
   private int stage;
   private String sunlight;
   private double lastWater;
   private final int value = 5;  //9) What do you think is going on here?  What is "final"?  (Feel free to Google!)  Why is this value set outside the constructor?
   private int fertilizer=1;
   //Constructors

   public PlavaRose()
   {
      height = 10;
      blooms = 0;
      stage = 0;
      sunlight = "shade";
      lastWater = 0;
   }
   public void fertilize() {
      fertilizer+=5;
   }
   public PlavaRose(int customHeight, int customBlooms, int customStage, String customSunlight, double customLastWater)
   {
      height = customHeight;
      blooms = customBlooms;
      stage = customStage;
      sunlight = customSunlight;
      lastWater = customLastWater;
   }
   
   //Accessors & modifiers
   //10) Several accessors and modifiers are missing - why?
   public int getStage() {
      return stage;
   }
   public int getHeight()
   {
      return height;
   }
   public int getBlooms()
   {
      return blooms;
   }
   public String getSunlight()
   {
      return sunlight;
   }
   public double getValue()
   {
      return value;
   }
   public void setSunlight(String newSun)
   {
      switch (newSun.toLowerCase()) {
         case "shade":
         case "indirect":
         case "direct":
            sunlight=newSun;
            break;
      }
   }
   public void setWater(double tablespoons)
   {
      //11) This isn't a very good modifier method.  Why?
      lastWater = tablespoons;
   }

   //Instance methods
   public void grow()
   {
      //12) Put into your own words: what does a Plava Rose need to bloom?
      if(stage >= 0)
      {
         if(sunlight.equals("direct"))
         {
            if(lastWater > 1.2 * height / 10 && lastWater < 2.0 * height / 10)
            {
               stage ++;
               height += 5;
            }
         }
         if(sunlight.equals("shade"))
         {
            stage --;
            height -= 5;
         }
      }
      if(stage >= 3)
      {
         stage = 3;
         blooms += fertilizer;
      }
      if (fertilizer>1) fertilizer--;
   }
   public int trim()
   {
      if(blooms > 0)
      {
         blooms--;
         return 1;
      }
      return 0;
   }
   public void statusReport()
   {
      if(stage == -1)
         System.out.println("Your Plava Rose is dead!");
      else
      {
         System.out.println("Your Plava Rose is " + height + " inches tall.");
         System.out.println("It has " + blooms + " flowers.");
         if(stage == 0)
         {
            System.out.println("Your Plava Rose looks like a bare stalk.");
         }
         else if(stage == 1)
         {
            System.out.println("Your Plava Rose has grown a few leaves.");
         }
         else if(stage == 2)
         {
            System.out.println("Your Plava Rose has a few flower buds.");
         }
         else
         {
            System.out.println("Your Plava Rose is blooming!");
         }
      }
   }
   public boolean isAlive()
   {
      return !(stage==-1);
   }
   public String toString()
   {
      return "PlavaRose";
   }
}