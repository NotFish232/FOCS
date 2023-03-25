public class PlavaOW implements Plant{
      //Fields
   private int height;
   private int blooms;
   private int stage;
   private String sunlight;
   private double lastWater;
   private final int value = 1;
   private int fertilizer=1;
   //Constructors
   public int getStage() {
      return stage;
   }
   public PlavaOW()
   {
      height = 2;
      blooms = 0;
      stage = 100;
      sunlight = "shade";
      lastWater = 0;
   }
   public PlavaOW(int customHeight, int customBlooms, int customStage, String customSunlight, double customLastWater)
   {
      height = customHeight;
      blooms = customBlooms;
      stage = customStage;
      sunlight = customSunlight;
      lastWater = customLastWater;
   }
   
   //Accessors & modifiers
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
      return value*stage;
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
      lastWater = tablespoons;
   }

   //Instance methods
   public void grow() {
      if(stage >= 0) {
         if(sunlight.equals("direct") || lastWater>0) {
           stage=-1;
         }
         else {
            height++;
            stage--;
         }
         blooms += 10*fertilizer;
      }
      else blooms=0;
      if (fertilizer>1) fertilizer--;
   }
   public int trim() {
      if(blooms > 0) {
         blooms--;
         stage-=10;
         if (stage<0) {
             stage=-1;
             blooms=0;
         }
         return 1;
      }
      return 0;

   }
   public void statusReport() {
      if(stage == -1)
         System.out.println("Your Plava OW is dead!");
      else {
         System.out.println("Your Plava OW is " + height + " inches tall.");
         System.out.println("It has " + blooms + " flowers.");
         if(stage == 0) {
            System.out.println("Your Plava OW is a depressing looking nub.");
         }
         else if(stage == 1) {
            System.out.println("Your Plava OW has split off a second stem and looks healthier.");
         }
         else if(stage == 2) {
            System.out.println("Your Plava OW has buds.");
         }
         else {
            System.out.println("Your Plava OW is blooming!");
         }
      }
   }
   public boolean isAlive()
   {
      return stage >= 0;
   }
   public String toString()
   {
      return "PlavaOW";
   }
   public void fertilize() {
      fertilizer+=5;
   }
}
