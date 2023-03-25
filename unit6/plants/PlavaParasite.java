public class PlavaParasite implements Plant{
    private int height;
    private int blooms;
    private int stage;
    private String sunlight;
    private int fertilizer=1;
    //Constructors
    public PlavaParasite()
    {
       height = 2;
       blooms = 1;
       stage = 0;
       sunlight = "shade";
    }
    public PlavaParasite(int customHeight, int customBlooms, int customStage, String customSunlight, double customLastWater)
    {
       height = customHeight;
       blooms = customBlooms;
       stage = customStage;
       sunlight = customSunlight;
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
       return 3;
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
    public void setWater(double tablespoons) {
       
    }
 
    //Instance methods
    public void grow() {
      blooms+=fertilizer;
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
        System.out.println("Your Plava Parasite is thriving, but then again, that's what parasites always do...");
        System.out.println("It has " + blooms + " flowers.");
        System.out.println("Perhaps putting this plant so close to others is not the best idea...");
      
    }
    public boolean isAlive() {
       return stage >= 0;
    }
    public String toString() {
       return "PlavaParasite";
    }
    public void fertilize() {
       fertilizer+=5;
    }
}
