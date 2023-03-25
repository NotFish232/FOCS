import javax.swing.*;
import java.awt.*;

public class Hotbar extends JPanel {
    private Tuple[] showing = new Tuple[8];
    private int selected = 0;

    public Hotbar() {
        setLayout(new GridLayout(1, 9));
        for (int i = 0; i < 8; i++) {
            showing[i] = new Tuple(new JLabel(""), "", 0);
            showing[i].label.setHorizontalAlignment(JLabel.RIGHT);
            add(showing[i].label);
        }
        add(new JLabel());
        display();
    }

    public void set(Tuple[] showing) {
        for (int i = 0; i < 8; i++) {
            if (showing[i].count == 0)
                continue;
            this.showing[i].msg = showing[i].msg;
            this.showing[i].count = showing[i].count;
        }
        display();
    }

    public void addBlock(Block block) {
        for (int i = 0; i < 8; i++) {
            if (showing[i].msg.equals("")) {
                showing[i].msg = block.toString();
            }
            if (showing[i].msg.equals(block.toString())) {
                showing[i].count++;
                break;
            }
        }
        display();
    }

    public void removeBlock(String name) {
        for (int i = 0; i < 8; i++) {
            if (showing[i].msg.equals(name)) {
                showing[i].count--;
                if (showing[i].count == 0) {
                    showing[i].msg = "";
                }
                break;
            }
        }
        display();

    }

    private void display() {
        for (int i = 0; i < 8; i++) {
            if (!showing[i].msg.equals("")) {
                showing[i].label.setText("" + showing[i].count + " - " + showing[i].msg.replace("_", " "));
            } else {
                showing[i].label.setText("[  *  ]");
            }
            if (selected == i) {
                showing[i].label.setText(">> " + showing[i].label.getText());
            }
        }
    }

    public void move(int num) {
        selected += num;
        if (selected == -1) {
            selected = 0;
        }
        if (selected == 8) {
            selected = 7;
        }
        display();
    }

    public String getSelected() {
        return showing[selected].msg;

    }

    public boolean placeable() {
        return showing[selected].msg != "";
    }

    public Tuple[] getHotbar() {
        return showing;
    }
}
