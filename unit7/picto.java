import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
public class picto extends Athlete
{
//fields
private int count = 0;

//constructor
public picto()
{
   super(1, 1, Display.EAST, 0);
}

public int howMany()
{
int num = 0;
   while(nextToABeeper())
   {
      num = num + 1;
      move();
   }
   turnAround();
   for(int i=0; i<num; i++)
   {
      move();
   }
   turnAround();
   return num;
}
public void rotate()
{
  columnTwo();
   turnRight();
   move();
    System.out.println("done2");
columnThree();
   turnRight();
   move();
    System.out.println("done3");
columnFour();
   turnRight();
   move();
    System.out.println("done4");

   
}
public void columnOne()
{
   int X = 1;
   int Y = 1;
   int newY = 0;
   turnLeft();
   int num = howMany();

   while(nextToABeeper() && count < num)
      {
         pickBeeper();
         int newX = Y;
         if(X == 2)
         {
            newY = 3;
         }
         else if(X == 3)
         {
            newY = 2;
         }
         else if(X == 1)
         {
            newY = 4;
         }
         else if(X == 4)
         {
            newY = 1;
         }
         if(Y != 1)
         {
            turnAround();
            for(int i=0; i<Y-1; i++)
            {
               move();
               
            }
            turnAround();
         }
         for(int i=0; i<newY-1; i++)
            {
               move();
             


            }
         turnRight();
         for(int i=0; i<newX-1; i++)
            {
               move();
            }
         putBeeper();
         turnAround();
         Y = Y + 1;
         for(int i=0; i<newX-1; i++)
            {
               move();
            }
         turnLeft();
         for(int i=0; i<newY-1; i++)
            {
               move();
            }
         turnAround();
       
         count = count + 1;
         for(int i=0; i<Y-1; i++)
            {
               move();
            }   
            
   }
   turnAround();
   for(int i=0; i<Y-1; i++)
   {
      move();
   }  
   turnAround();
   }

public void columnTwo()
{
count = 0;
int X = 2;
   int Y = 1;
   int newY = 0;
   turnLeft();
   int num = howMany();
  
   while(nextToABeeper() && count < num)
      {
         pickBeeper();
         int newX = Y;
         if(X == 2)
         {
            newY = 3;
         }
         else if(X == 3)
         {
            newY = 2;
         }
         else if(X == 1)
         {
            newY = 4;
         }
         else if(X == 4)
         {
            newY = 1;
         }
         if(Y != 1)
         {
            turnAround();
            for(int i=0; i<Y-1; i++)
            {
               move();
               
            }
            turnAround();
         }
         turnLeft();
         for(int i=0; i<X-1; i++)
         {
            move();
         }
         turnRight();
         for(int i=0; i<newY-1; i++)
            {
               move();
             


            }
         turnRight();
         for(int i=0; i<newX-1; i++)
            {
               move();
            }
         putBeeper();
         turnAround();
         Y = Y + 1;
         for(int i=0; i<newX-1; i++)
            {
               move();
            }
         turnLeft();
         for(int i=0; i<newY-1; i++)
            {
               move();
            }
         turnAround();
        
         count = count + 1;
         for(int i=0; i<Y-1; i++)
            {
               move();
            }   
            
   }
   turnAround();
   for(int i=0; i<Y-1; i++)
   {
      move();
   }  
   turnAround();
   turnRight();
   for(int i=0; i<X-1; i++)
   {
      move();
   }
   turnLeft();

   


}

public void columnThree()
{
count = 0;
int X = 3;
   int Y = 1;
   int newY = 0;
   turnLeft();
   int num = howMany();
  System.out.println(num);
   while(nextToABeeper() && count < num)
      {
         pickBeeper();
         int newX = Y;
         if(X == 2)
         {
            newY = 3;
         }
         else if(X == 3)
         {
            newY = 2;
         }
         else if(X == 1)
         {
            newY = 4;
         }
         else if(X == 4)
         {
            newY = 1;
         }
         System.out.print("check1");
         if(Y != 1)
         {
            turnAround();
            for(int i=0; i<Y-1; i++)
            {
               move();
               
            }
            turnAround();
            System.out.print("check2");
         }
         System.out.print("check3");
        
         turnLeft();
         for(int i=0; i<X-1; i++)
         {
            move();
         }
         turnRight();
System.out.print("check4");
         for(int i=0; i<newY-1; i++)
            {
               move();
             


            }
            System.out.print("check5");
         turnRight();
         for(int i=0; i<newX-1; i++)
            {
               move();
            }
         putBeeper();
         turnAround();
         System.out.print(count);
         System.out.print("check6")       ;
         Y = Y + 1;
         for(int i=0; i<newX-1; i++)
            {
               move();
            }
            System.out.print("check7");
         turnLeft();
         System.out.print("check8");
         for(int i=0; i<newY-1; i++)
            {
               move();
            }
            System.out.print("check9");
         turnAround();
        System.out.print("check10");
         count = count + 1;
         turnAround();
         turnLeft();
         for(int i=0; i<Y; i++)
            {
               move();
            }  
            turnLeft(); 
           System.out.print("check11"); 
           
   }
   turnAround();
   turnLeft();
   System.out.print("check12");
   for(int i=0; i<Y-1; i++)
   {
      move();
   }  
   System.out.print("check13");
   turnAround();
   turnLeft();
   System.out.print("check14");
   turnRight();
   for(int i=0; i<X-1; i++)
   {
      move();
   }
   turnLeft();


}

public void columnFour()
{
count=0;
int X = 4;
   int Y = 1;
   int newY = 0;
   turnLeft();
   int num = howMany();
  
   while(nextToABeeper() && count < num)
      {
         pickBeeper();
         int newX = Y;
         if(X == 2)
         {
            newY = 3;
         }
         else if(X == 3)
         {
            newY = 2;
         }
         else if(X == 1)
         {
            newY = 4;
         }
         else if(X == 4)
         {
            newY = 1;
         }
         if(Y != 1)
         {
            turnAround();
            for(int i=0; i<Y-1; i++)
            {
               move();
               
            }
            turnAround();
         }
         for(int i=0; i<newY-1; i++)
            {
               move();
             


            }
         turnRight();
         for(int i=0; i<newX-1; i++)
            {
               move();
            }
         putBeeper();
         turnAround();
         Y = Y + 1;
         for(int i=0; i<newX-1; i++)
            {
               move();
            }
         turnLeft();
         for(int i=0; i<newY-1; i++)
            {
               move();
            }
         turnAround();
     
         count = count + 1;
         for(int i=0; i<Y-1; i++)
            {
               move();
            }   
            
   }
   turnAround();
   for(int i=0; i<Y-1; i++)
   {
      move();
   }  
   turnAround();
   

}



}