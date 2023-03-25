public interface Plant
{
   public int getHeight();
   public int getBlooms();
   public String getSunlight();
   public double getValue();
   public int getStage();
   public void setSunlight(String newSun);
   public void setWater(double tablespoons);
   public void grow();
   public int trim();
   public void statusReport();
   public boolean isAlive();
   public void fertilize();
   //8) Why doesn't this interface need toString() defined?
}