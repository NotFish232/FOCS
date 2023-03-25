import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Lab8GREEN2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI with BorderLayout");
        frame.setSize(800, 425);
        frame.setLocation(20, 20);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new pnl());
        frame.setVisible(true);
    }
    
}
class pnl extends JPanel {
    JTextField inLeft;
    JTextField inRight;
    JLabel result;
    public pnl() {
        setLayout(new BorderLayout());  //Rows then columns
        JLabel title=new JLabel("Lab 8-GREEN-02!");
        title.setFont(new Font("Serif", Font.BOLD, 20));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);
        result=new JLabel("0.0");
        result.setFont(new Font("Serif",Font.BOLD,50));
        result.setHorizontalAlignment(JLabel.CENTER);
        add(result,BorderLayout.CENTER);
        JPanel westSubpanel = new JPanel();
        westSubpanel.setLayout(new GridLayout(2, 1));
        JLabel label1 = new JLabel("Enter a number:");
        label1.setVerticalAlignment(JLabel.BOTTOM);
        westSubpanel.add(label1);  //Add the button TO THE SUBPANEL
        inLeft=new JTextField("0",25);
        westSubpanel.add(inLeft);  //Add the button TO THE SUBPANEL
        add(westSubpanel, BorderLayout.WEST);  //Add the SUBPANEL to the PANEL
        
        JPanel eastSubpanel = new JPanel();
        eastSubpanel.setLayout(new GridLayout(2, 1));
        JLabel label2 = new JLabel("Enter a number:");
        label2.setVerticalAlignment(JLabel.BOTTOM);
        eastSubpanel.add(label2);  //Add the button TO THE SUBPANEL
        inRight=new JTextField("0",25);
        eastSubpanel.add(inRight);  //Add the button TO THE SUBPANEL
        add(eastSubpanel, BorderLayout.EAST);  //Add the SUBPANEL to the PANEL
        JPanel southSubpanel=new JPanel();
        southSubpanel.setLayout(new GridLayout(1,4));
        JButton add=new JButton("Add");
        JButton subtract=new JButton("Subtract");
        JButton multiply=new JButton("Multiply");
        JButton divide=new JButton("Divide");
        add.addActionListener(new AddClicked());
        subtract.addActionListener(new SubtractClicked());
        multiply.addActionListener(new MultiplyClicked());
        divide.addActionListener(new DivideClicked());
        southSubpanel.add(add);
        southSubpanel.add(subtract);
        southSubpanel.add(multiply);
        southSubpanel.add(divide);
        add(southSubpanel,BorderLayout.SOUTH);
    }
    private Double[] getVal() {
        return new Double[] {Double.parseDouble(inLeft.getText()),Double.parseDouble(inRight.getText())};
    }
    private class AddClicked implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Double[] vals=getVal();
            result.setText(""+(vals[0]+vals[1]));
        }
    }
    private class SubtractClicked implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Double[] vals=getVal();
            result.setText(""+(vals[0]-vals[1]));
        }
    }
    private class MultiplyClicked implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Double[] vals=getVal();
            result.setText(""+(vals[0]*vals[1]));
        }
    }
    private class DivideClicked implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Double[] vals=getVal();
            result.setText(""+(vals[0]/vals[1]));
        }
    }
}
