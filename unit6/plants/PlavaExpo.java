public class PlavaExpo implements Plant {
   private int height;
   private int blooms;
   private int stage;
   private String sunlight;
   private double lastWater;
   private int fertilizer=1;
   //Constructors
   public PlavaExpo()
   {
      height = 2;
      blooms = 0;
      stage = 0;
      sunlight = "shade";
      lastWater = 0;
   }
   public PlavaExpo(int customHeight, int customBlooms, int customStage, String customSunlight, double customLastWater)
   {
      height = customHeight;
      blooms = customBlooms;
      stage = customStage;
      sunlight = customSunlight;
      lastWater = customLastWater;
   }
   
   //Accessors & modifiers
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
      return (int)Math.pow(2,stage);
   }
   public void setSunlight(String newSun) {
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
      lastWater = tablespoons;
   }

   //Instance methods
   public void grow() {
      //13) Put into your own words - what does a Plava Cactus need to bloom?
      if(stage >= 0) {
         if(sunlight.equals("direct")) {
            if(lastWater > 0.2 * height / 10 && lastWater < 0.4 * height / 10) {
               height++;
            }
            if (height > stage*10) {
               stage++;
            }
         } else {
            height--;
            if(height == 0) {
               stage = -1;
            }
         }
      }
      if(stage >= 3) {
         blooms += (int)Math.pow(2,stage-3)*fertilizer;
      }
      if (fertilizer>1) fertilizer--;
   }
   public int trim() {
      if(blooms > 0) {
         blooms--;
         return 1;
      }
      return 0;
   }
   public void statusReport()
   {
      if (stage!=-1) System.out.println("Your Plava Expo is " + height + " inches tall.");
      System.out.println("It has " + blooms + " flowers.");
      switch(stage) {
         case -1:
            System.out.println("Your Plava Expo is dead!");
            break;
         case 0:
            System.out.println("Your Plava Expo is a depressing looking nub.");
            break;
         case 1:
            System.out.println("Your Plava Expo has split off a second stem and looks healthier.");
            break;
         case 2:
            System.out.println("Your Plava Expo has buds.");
            break;
         case default:
            System.out.println("Your Plava Expo is blooming!");

      }
     
   }
   public boolean isAlive() {
      return stage >= 0;
   }
   public String toString() {
      return "PlavaExpo";
   }
   public void fertilize() {
      fertilizer+=5;
   }
}
