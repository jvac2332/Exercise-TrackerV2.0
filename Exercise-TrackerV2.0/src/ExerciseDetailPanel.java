import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
// The imports help with running with the code and for it run 
public class ExerciseDetailPanel extends JPanel {
    private JTextField txtX;
    private JTextField txtY;
    private JTextField txtRadius;
    private JTextArea tarComment; 
    /* The private statements help run the structure and comments */
    public void setupGUI() {
        setLayout(new BorderLayout());
        JPanel panNorth = new JPanel();
        panNorth.setLayout(new GridLayout(3,2));
        panNorth.add(new JLabel("X Coord"));
        txtX = new JTextField(5);
        panNorth.add(txtX);
        panNorth.add(new JLabel("Y Coord"));
        txtY = new JTextField(5);
        panNorth.add(txtY);
        panNorth.add(new JLabel("Radius"));
        txtRadius = new JTextField(5);
        panNorth.add(txtRadius);
        add(panNorth,BorderLayout.NORTH);
        JPanel panComment = new JPanel();
        panComment.setLayout(new BorderLayout());
        panComment.add(new JLabel("Comment"), BorderLayout.NORTH);
        tarComment = new JTextArea(5,10);
        panComment.add(tarComment,BorderLayout.CENTER);
        add(panComment,BorderLayout.CENTER);
        // The statement help set up how the box of the program and how much each line should be 
    }
    public ExerciseDetailPanel() {
        setupGUI();
    }
    public double getXVal() {
        return Double.parseDouble(txtX.getText());
    }
    public double getYVal() {
        return Double.parseDouble(txtY.getText());
    }
    public double getRadius() {
        return Double.parseDouble(txtRadius.getText());
    }
    public String getComment() {
        return tarComment.getText();
    }
    public void clearEntries() {
        txtX.setText("");
        txtY.setText("");
        txtRadius.setText("");
        tarComment.setText("");
    }
    public void enableEntries(boolean enabledYN) {
        txtX.setEnabled(enabledYN);
        txtY.setEnabled(enabledYN);
        txtRadius.setEnabled(enabledYN);
        tarComment.setEnabled(enabledYN);
    }
}

