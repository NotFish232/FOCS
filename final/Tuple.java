import javax.swing.JLabel;

public class Tuple {
    public JLabel label;
    public String msg;
    public int count;

    public Tuple(JLabel label, String msg, int count) {
        this.label = label;
        this.msg = msg;
        this.count = count;
    }
}
