import java.awt.event.*;
import java.io.File;
import java.util.Scanner;

import javax.swing.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.awt.*;
import java.awt.image.BufferedImage;

public class basicCalculator 
{
   public static void main(String[] args) 
   { 
      JFrame frame = new JFrame("        Basic Calculator!");
      frame.setSize(400, 700);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new basicCalcPanel());
      frame.setVisible(true);
   }

}

class basicCalcPanel extends JPanel 
{
   JLabel number;  //These are fields so that the action listeners can access them.
   JLabel history;
   JLabel one; //for the history
   JLabel two;
   JLabel three;
   JLabel four; 
   JLabel five;
   JLabel six;
   JLabel blank;
   double num;
   double numberAlpha;
   double numberBeta;
   JLabel westLabel;
   JLabel eastLabel;
   boolean add;
   boolean subtract;
   boolean multiply;
   boolean divide;
   boolean negative;
   String temp;
   String h1 = "No input";
   String h2 = "No input";
   String h3 = "No input";
   String h4 = "No input";
   String h5 = "No input";
   String h6 = "No input";
   String[] History = new String[]{h1,h2,h3,h4,h5,h6};
   String operation = " ";

  
   
   public basicCalcPanel() 
   {
      graphicsPanel gfx; 
        
      setLayout(new BorderLayout());
      
      
      //Create a title and add it to the north region of the BorderLayout.
      //This is not a field because it never needs to be modified.
      JLabel title = new JLabel("Basic Calculator");
      title.setFont(new Font("Serif", Font.BOLD, 20));
      title.setHorizontalAlignment(SwingConstants.CENTER);
      add(title, BorderLayout.NORTH);
      
   
    
      //Initialize fields storing a number and a JLabel that we'll edit in the future.
      //NOTE THAT "num" AND "number" ARE ONLY ACCESSED, NOT DECLARED!
      //If you have a field, re-declaring that field (ie, writing "JLabel number" again)
      //makes a new local reference with the same name, IGNORING your field.
        //Automatically adds to the center region if no second arg is given.
      num = 0;
      number = new JLabel("" + num);
      number.setFont(new Font("Serif", Font.BOLD, 80));
      number.setHorizontalAlignment(SwingConstants.CENTER);
      add(number);
///////SUBPANELS
      JPanel southSubpanel = new JPanel();
      JButton enter = new JButton("Enter");
      enter.addActionListener(new enterListener());
      southSubpanel.add(enter);
      add(southSubpanel, BorderLayout.SOUTH);
      
      JPanel northSubpanel = new JPanel();
      northSubpanel.setLayout(new GridLayout(1,3));
      JLabel history = new JLabel("History");
      northSubpanel.add(history);
      JButton home = new JButton("home");
      northSubpanel.add(home);
      add(northSubpanel, BorderLayout.NORTH);
      
     JPanel westSubpanel = new JPanel();
     westSubpanel.setLayout(new GridLayout(7, 2));
     try
     {
     Scanner infile = new Scanner( new File("history.txt") );
     int numItems = Integer.parseInt(infile.nextLine());
     for(int i = 1; i <= numItems; i++)
    {
        temp = infile.nextLine();
        if(i == 1)
        {
            JLabel one = new JLabel( "     " + temp);
            westSubpanel.add(one);
        }
        else if(i == 2)
        {
            JLabel two = new JLabel( "     " + temp);
            westSubpanel.add(two);
        }
        else if(i == 3)
        {
            JLabel three = new JLabel( "     " + temp);
            westSubpanel.add(three);
        }
        else if(i == 4)
        {
            JLabel four = new JLabel( "     " + temp);
            westSubpanel.add(four);
        }
        else if(i == 5)
        {
            JLabel five = new JLabel( "     " + temp);
            westSubpanel.add(five);
        }
        else if(i == 6)
        {
            JLabel six = new JLabel( "     " + temp);
            westSubpanel.add(six);
        }

    }
     }
    catch (NoSuchElementException ex) 
    {
            System.out.println("An error occurred...");
            ex.printStackTrace();
    }
    catch (FileNotFoundException ex)
    {
        System.out.println("An error occurred.");
        ex.printStackTrace();
    }
      JLabel blank = new JLabel("               ");
      westSubpanel.add(blank);
      add(westSubpanel, BorderLayout.WEST);
      
      JPanel eastSubpanel = new JPanel();
      eastSubpanel.setLayout(new GridLayout(4, 1));
      JButton add = new JButton("+");
      add.addActionListener(new AddListener());
      eastSubpanel.add(add); 
      JButton subtract = new JButton("-");
      subtract.addActionListener(new SubtractListener());
      eastSubpanel.add(subtract); 
      JButton multiply = new JButton("x");
      multiply.addActionListener(new MultiplyListener());
      eastSubpanel.add(multiply); 
      JButton divide = new JButton("/");
      divide.addActionListener(new DivideListener());
      eastSubpanel.add(divide); 
      add(eastSubpanel, BorderLayout.EAST);  //Add the SUBPANEL to the PANEL

    JPanel centerSubpanel = new JPanel();
    centerSubpanel.setLayout(new GridLayout(4, 1));
    JPanel oneCenter = new JPanel();
    num = 0;
    number = new JLabel("" + num);
    number.setFont(new Font("Serif", Font.BOLD, 80));
    number.setHorizontalAlignment(SwingConstants.CENTER);
    oneCenter.add(number);
    centerSubpanel.add(oneCenter);
    JPanel twoCenter = new JPanel();
    twoCenter.setLayout(new GridLayout(1, 4));
    JButton one = new JButton("1");
    one.addActionListener(new oneListener());
    twoCenter.add(one);
    JButton two = new JButton("2");
    two.addActionListener(new twoListener());
    twoCenter.add(two);
    JButton three = new JButton("3");
    three.addActionListener(new threeListener());
    twoCenter.add(three);
    JButton four = new JButton("4");
    four.addActionListener(new fourListener());
    twoCenter.add(four);
    centerSubpanel.add(twoCenter);

    JPanel threeCenter = new JPanel();
    threeCenter.setLayout(new GridLayout(1, 4));
    JButton five = new JButton("5");
    five.addActionListener(new fiveListener());
    threeCenter.add(five);
    JButton six = new JButton("6");
    six.addActionListener(new sixListener());
    threeCenter.add(six);
    JButton seven = new JButton("7");
    seven.addActionListener(new sevenListener());
    threeCenter.add(seven);
    JButton eight = new JButton("8");
    eight.addActionListener(new eightListener());
    threeCenter.add(eight);
    centerSubpanel.add(threeCenter);
    add(centerSubpanel, BorderLayout.CENTER);

    JPanel fourCenter = new JPanel();
    fourCenter.setLayout(new GridLayout(1, 4));   
    JButton clear = new JButton("C");
    clear.addActionListener(new clearListener());
    northSubpanel.add(clear);
    //decimal.addActionListener(new decimalListener());
    fourCenter.add(clear);
    JButton nine = new JButton("9");
    nine.addActionListener(new nineListener());
    fourCenter.add(nine);
    JButton zero = new JButton("0");
    zero.addActionListener(new zeroListener());
    fourCenter.add(zero);
    JButton negative = new JButton("( - )");
    negative.addActionListener(new negativeListener());
    fourCenter.add(negative);
    centerSubpanel.add(fourCenter);

    
}
class graphicsPanel extends JPanel
   {
    private BufferedImage myImage;
    private Graphics myBuffer;
    private  Color BACKGROUND = new Color(204, 204, 204);
    
    public graphicsPanel()
    {
      myImage =  new BufferedImage( 200, 100, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,200,100);
    }
   }
 public void paintComponent(Graphics g)  //Required method to paint to the screen
    {
      //g.drawImage(myImage, 0, 0, myImage.getWidth(), myImage.getHeight(), null);  
    }

private class negativeListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         negative = true;  
      }
   }
private class AddListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         add = true;  
      }
   }

private class SubtractListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
            subtract = true;   
       }
   }
   
private class MultiplyListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
       
        multiply = true;  
      }
   }
   
private class DivideListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
        //  num = numberAlpha/numberBeta;
        //  number.setText("" + num);  
        divide = true;    
      }
   }
private class clearListener implements ActionListener
{
      public void actionPerformed(ActionEvent e)
      {
        num = 0;
        number.setText("" + num);
        numberAlpha = -1;
        numberBeta = -1; 

      }

}
private class enterListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      { 
        if(add)
        {
        num = numberAlpha + numberBeta;
        operation = " + ";
        }
         else if(subtract)
         {
          num = numberAlpha - numberBeta;
          operation = " - ";
         }
        else if(multiply)
        {
        num = numberAlpha*numberBeta;
        operation = " * ";
        }
        else if(divide)
        {
            num = numberAlpha/numberBeta;
            operation = " / ";
        }
         if(negative)
         {
            num = num * -1;
         }
         number.setText("" + num); 
         h6 = h5;
         h5 = h4;
         h4 = h3;
         h3 = h2;
         h2 = h1;
         h1 = Double. toString(numberAlpha) + operation + Double. toString(numberBeta) + " = " + num;
         System.out.println(h1);
         System.out.println(h2);
         System.out.println(h3);
         System.out.println(h4);
         System.out.println(h5);
         System.out.println(h6);
         File historyFile = new File("history.txt");
    try 
    {
        if (historyFile.createNewFile()) 
        {
           
            FileWriter historyWriter = new FileWriter("history.txt");
            historyWriter.write("6" + "\n");
            historyWriter.write(h1 + "\n");
            historyWriter.write(h2 + "\n");
            historyWriter.write(h3 + "\n");
            historyWriter.write(h4 + "\n");
            historyWriter.write(h5 + "\n");
            historyWriter.write(h6 + "\n");
            historyWriter.close(); 
                
            
            
        } 
        else 
        {
            historyFile.delete();
            FileWriter historyWriter = new FileWriter("history.txt");
            historyWriter.write("6" + "\n");
            historyWriter.write(h1 + "\n");
            historyWriter.write(h2 + "\n");
            historyWriter.write(h3 + "\n");
            historyWriter.write(h4 + "\n");
            historyWriter.write(h5 + "\n");
            historyWriter.write(h6 + "\n");
            historyWriter.close(); 
        }
    }
    catch (IOException ex) 
    {
            System.out.println("An error occurred.");
            ex.printStackTrace();
    }
        System.out.println(historyFile);
         numberAlpha = num;
         numberBeta = -1; 
         add = false;
         subtract = false;
         multiply = false;
         divide = false; 
         negative = false;
        
     one.setText(h1);
     //super.update(this.getGraphics());
     two.setText(h2);
     three.setText(h3);
     four.setText(h4);
     five.setText(h5);
     six.setText(h6);
        
      }
   }

private class oneListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(numberAlpha == -1)   
         {
             numberAlpha = 1;
         }
         else 
         {
             numberBeta = 1;
         }
      }
   }



private class twoListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(numberAlpha == -1)   
         {
             numberAlpha = 2;
         }
         else 
         {
             numberBeta = 2;
         }
      }
   }
private class threeListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(numberAlpha == -1)   
         {
             numberAlpha = 3;
         }
         else 
         {
             numberBeta = 3;
         }
      }
   }

   private class fourListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(numberAlpha == -1)   
         {
             numberAlpha = 4;
         }
         else 
         {
             numberBeta = 4;
         }
      }
   }

   private class fiveListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(numberAlpha == -1)   
         {
             numberAlpha = 5;
         }
         else 
         {
             numberBeta = 5;
         }
      }
   }
   
   private class sixListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(numberAlpha == -1)   
         {
             numberAlpha = 6;
         }
         else 
         {
             numberBeta = 6;
         }
      }
   }

   private class sevenListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(numberAlpha == -1)   
         {
             numberAlpha = 7;
         }
         else 
         {
             numberBeta = 7;
         }
      }
   }
   
   private class eightListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(numberAlpha == -1)   
         {
             numberAlpha = 8;
         }
         else 
         {
             numberBeta = 8;
         }
      }
   }

   private class nineListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(numberAlpha == -1)   
         {
             numberAlpha = 9;
         }
         else 
         {
             numberBeta = 9;
         }
      }
   }

    private class zeroListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(numberAlpha == -1)   
         {
             numberAlpha = 0;
         }
         else 
         {
             numberBeta = 0;
         }
      }
   }



}