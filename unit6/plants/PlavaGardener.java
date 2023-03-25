import java.util.Scanner;
import java.util.stream.Stream;
import java.io.File; // Import the File class
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

public class PlavaGardener {
   public static double money;
   public static Scanner in;
   public static Plant[] plants;

   public static void reportAllStatus() {
      for (int i = 0; i < plants.length; i++) {
         if (plants[i] != null) {
            System.out.println("In plot number " + i + ":");
            plants[i].statusReport();
            System.out.println();
         }
      }
      if (plotNum() == 0) {
         System.out.println("You don't have any plants!  Buy some at the store!");
      }
   }

   public static void waterAllPlants() {
      System.out.println(
            "Most plants need somewhere between 0 and 2 tablespoons of water per day per 10 inches of height.");
      System.out.println("Plava plants might be unpredictable, though!");
      System.out.println("For each plant below, give a decimal value of tablespoons of water to give per day.");
      for (int i = 0; i < plants.length; i++) {
         if (plants[i] != null) {
            if (!plants[i].isAlive()) {
               System.out.println("For plot number " + i + ", your " + plants[i] + " is dead!");
               continue;
            }
            double water;
            do {
               System.out.print("For plot number " + i + ", your " + plants[i] + " should get:");
               water = Double.parseDouble(in.nextLine());
            } while (water < 0);
            plants[i].setWater(water);
         }
      }
   }

   public static void sunlightAllPlants() {
      System.out.println("You have three options for the sunlight each plant gets - direct, indirect, or shade.");
      System.out.println(
            "For each plant below, either type what sunlight you'd like it to get, or just type 'x' if you want to leave it where it is.");
      for (int i = 0; i < plants.length; i++) {
         if (plants[i] != null) {
            if (!plants[i].isAlive()) {
               System.out.println("For plot number " + i + ", your " + plants[i] + " is dead!");
               continue;
            }
            System.out.println("For plot number " + i + ", your " + plants[i] + " is currently getting "
                  + plants[i].getSunlight() + ".");
            System.out.print("Type a different option to change, or any key to keep as is: ");
            String inpt = in.nextLine();
            plants[i].setSunlight(inpt);
         }
      }
   }

   public static void growAllPlants() {
      for (Plant plant : plants) {
         if (plant != null) {
            plant.grow();
         }
      }
      parasiticGrowth();
   }

   private static void parasiticGrowth() {
      for (int i = 0; i < plants.length; i++) {
         if (plants[i]!=null && plants[i].toString().equals("PlavaParasite")) {
            if (i == 0) {
               if (plants[i + 1] != null)
                  plants[i + 1] = new PlavaParasite();
            } else if (i == plants.length - 1) {
               if (plants[i - 1] != null)
                  plants[i - 1] = new PlavaParasite();
            } else {
               if (plants[i - 1] != null)
                  plants[i - 1] = new PlavaParasite();
               if (plants[i + 1] != null)
                  plants[i + 1] = new PlavaParasite();
            }
         }
      }
   }

   public static Plant goShopping() {
      if (plotNum() == 10) {
         System.out.println("Uh oh, all your plots are full.");
         return null;
      }
      System.out.println("Welcome to the Plava plant store!");
      System.out.println("I currently have two options for sale.");
      System.out.println("1) Plava Rose -- $2");
      System.out.println("2) Plava DMNSH -- $3");
      System.out.println("3) Plava Parasite -- $4");
      System.out.println("4) Plava Cactus -- $5");
      System.out.println("5) Plava Expo -- $10");
      System.out.println("6) Plava OW -- $12");
      System.out.println("You currently have $" + money + ".");
      System.out.print("What would you like to buy (type the number of the option you choose or 0 to buy nothing)? ");
      String inpt = in.nextLine();
      int choice = Integer.parseInt(inpt);
      switch (choice) {
         case 1:
            if (money >= 2) {
               money -= 2;
               return new PlavaRose();
            }
         case 2:
            if (money >= 3) {
               money -= 3;
               return new PlavaDMNSH();
            }
         case 3:
            if (money >= 4) {
               money -= 4;
               return new PlavaParasite();
            }
         case 4:
            if (money >= 5) {
               money -= 5;
               return new PlavaCactus();
            }
         case 5:
            if (money >= 10) {
               money -= 10;
               return new PlavaExpo();
            }
         case 6:
            if (money >= 12) {
               money -= 12;
               return new PlavaOW();
            }
         case default:
            System.out.println("You don't have enough money for that!");
            return null;
      }
   }

   public static void gameLoop() {
      while (true) {
         System.out.println();
         System.out.println("You can choose any of the following options:");
         System.out.println("1) Check on the status of your plants");
         System.out.println("2) Decide how much to water each plant this week");
         System.out.println("3) Decide how much sunlight to give each plant this week");
         System.out.println("4) Wait a week to see how your plants grow/don't grow");
         System.out.println("5) Buy a new plant from the store");
         System.out.println("6) Throw away a plant that you own");
         System.out.println("7) Cut a flower off of one of your plants and sell it");
         System.out.println("8) Apply fertilizer to one of your plants");
         System.out.println("0) Quit the game (your progress will be saved)");
         String inpt;
         do {
            System.out.print("Type the number of your choice: ");
            inpt = in.nextLine();
         } while (!isNum(inpt));
         switch (inpt) {
            case "1":
               reportAllStatus();
               break;
            case "2":
               waterAllPlants();
               break;
            case "3":
               sunlightAllPlants();
               break;
            case "4":
               System.out.println("A week passes.  Check your plant status to see how they did!");
               growAllPlants();
               break;
            case "5":
               Plant temp = goShopping();
               if (temp != null) {
                  for (int i = 0; i < plants.length; i++) {
                     if (plants[i] == null) {
                        plants[i] = temp;
                        System.out.println("Your new plant is in plot #" + i);
                        System.out.println();
                        break;
                     }
                  }
               }
               break;
            case "6":
               System.out.print("Which plot would you like to throw away? ");
               plants[Integer.parseInt(in.nextLine())] = null;
               break;
            case "7":
               trimFlower();
               break;
            case "8":
               fertilizeFlower();
               break;
            case "0":
               saveGame();
               return;
         }
      }
   }

   private static void fertilizeFlower() {
      System.out.println("Fertilizer costs $50 and will increase the production of your plant.");
      System.out.print("Which plant would you like to fertilize?");
      Plant plant = plants[Integer.parseInt(in.nextLine())];
      if (plant != null) {
         if (money >= 50) {
            plant.fertilize();
            money -= 50;
         } else {
            System.out.println("You don't have enough money for that!");
         }
      }
   }

   private static void trimFlower() {
      System.out.print("Which plant would you like to cut a flower off?");
      Plant plant = plants[Integer.parseInt(in.nextLine())];
      if (plant != null) {
         if (plant.trim() == 1) {
            if (plant.toString().equals("PlavaParasite")) {
               System.out.println("Flower trimmed successfully, and sold for $" + plant.getValue()*parasiteCount() + ".");
               money += plant.getValue()*parasiteCount();
            } else {
            System.out.println("Flower trimmed successfully, and sold for $" + plant.getValue() + ".");
            money += plant.getValue();
            }
         } else {
            System.out.println("Uh oh, this plant has no flowers.");
         }
      } else {
         System.out.println("Uh oh, there is no plant in this plot.");
      }

   }
   private static int parasiteCount() {
      int count=0;
      for (Plant plant:plants) {
         if (plant!=null && plant.toString().equals("PlavaParasite")) count++;
      }
      return count;
   }
   private static boolean isNum(String str) {
      try {
         Integer.parseInt(str);
         return true;
      } catch (NumberFormatException e) {
         return false;
      }
   }

   private static long plotNum() {
      return Stream.of(plants).filter(n -> n != null).count();
   }

   private static void saveGame() {
      try {
         File file = new File("save.txt");
         file.createNewFile();
         FileWriter w = new FileWriter("save.txt");
         w.write(String.valueOf(money) + "\n");
         for (Plant plant : plants) {
            if (plant != null) {
               w.write(plant.toString() + " " + String.valueOf(plant.getHeight()) + " "
                     + String.valueOf(plant.getBlooms()) + " " + String.valueOf(plant.getStage()) + " shade 0\n");
            } else
               w.write("null\n");
         }
         w.close();
      } catch (IOException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
      }
   }

   private static void loadSave() {
      try {
         Scanner reader = new Scanner(new File("save.txt"));
         money = Double.valueOf(reader.nextLine());
         for (int i = 0; i < plants.length; i++) {
            String[] tmp = reader.nextLine().split(" ");
            switch (tmp[0]) {
               case "PlavaCactus":
                  plants[i] = new PlavaCactus(Integer.valueOf(tmp[1]), Integer.valueOf(tmp[2]), Integer.valueOf(tmp[3]),
                        tmp[4], Double.valueOf(tmp[5]));
                  break;
               case "PlavaDMNSH":
                  plants[i] = new PlavaDMNSH(Integer.valueOf(tmp[1]), Integer.valueOf(tmp[2]), Integer.valueOf(tmp[3]),
                        tmp[4], Double.valueOf(tmp[5]));
                  break;
               case "PlavaExpo":
                  plants[i] = new PlavaExpo(Integer.valueOf(tmp[1]), Integer.valueOf(tmp[2]), Integer.valueOf(tmp[3]),
                        tmp[4], Double.valueOf(tmp[5]));
                  break;
               case "PlavaOW":
                  plants[i] = new PlavaOW(Integer.valueOf(tmp[1]), Integer.valueOf(tmp[2]), Integer.valueOf(tmp[3]),
                        tmp[4], Double.valueOf(tmp[5]));
                  break;
               case "PlavaRose":
                  plants[i] = new PlavaRose(Integer.valueOf(tmp[1]), Integer.valueOf(tmp[2]), Integer.valueOf(tmp[3]),
                        tmp[4], Double.valueOf(tmp[5]));
                  break;
               case "PlavaParasite":
                  plants[i] = new PlavaParasite(Integer.valueOf(tmp[1]), Integer.valueOf(tmp[2]),
                        Integer.valueOf(tmp[3]), tmp[4], Double.valueOf(tmp[5]));
                  break;
            }
         }
         reader.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
         System.exit(1);
      }
   }

   public static void main(String[] args) {
      // 7) Over the next three lines, the variable types are NOT given. Why?
      in = new Scanner(System.in);
      String inpt;
      plants = new Plant[10];
      money = 10;
      do {
         System.out.print("Load saved game (s), or play new game (n)");
         inpt = in.nextLine().toLowerCase();
      } while (!(inpt.equals("s") || inpt.equals("n")));
      if (inpt.equals("s") && new File("save.txt").exists()) {
         loadSave();
      }
      gameLoop();
   }
}