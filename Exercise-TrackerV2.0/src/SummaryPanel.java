import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.util.ArrayList;
// These imports help set the code up with the with how we conclude the summary of our exercise.
public class SummaryPanel extends JPanel {
    private ArrayList<Exercise> exercises;
    public void setExercises(ArrayList<Exercise> exercises){
        this.exercises = exercises;
    }
    private JTextArea tarSummary;
    private JLabel lblSummary;
    public void setupGUI() {
        setLayout(new BorderLayout());
        lblSummary = new JLabel("Exercise Summary");
        add(lblSummary,BorderLayout.NORTH);
        tarSummary = new JTextArea(10,30);
        tarSummary.setEditable(false);
        add(tarSummary,BorderLayout.CENTER);
        // The statement is letting us know that once we make a comment we say whats we did and how it was
    }
    public void setSummaryLabel(String text) {
        lblSummary.setText(text);
    }
    public SummaryPanel() {
        setExercises(exercises);
        setupGUI();
    }
    public void updateList() {
        tarSummary.setText("");
        String text = "";
        for (Exercise c : exercises) {
            text = text + c + "\n";
        }
        tarSummary.setText(text);
        // lets us what to update on the exercise size stuff an how to start texting/
    }
}

