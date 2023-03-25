import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class MAIN {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Minecraft");
        GUIPanel panel = new GUIPanel();

        frame.setSize(600, 430);
        frame.setLocation(20, 20);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //get gfx and trigger on close
                panel.getGfx().onClose();
            }
        });
    }
}