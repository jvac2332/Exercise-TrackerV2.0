import java.util.ArrayList;

public class App {

    private static final ArrayList<Exercise> Exercise = null;

    public static void main(String[] args) throws Exception {
        ArrayList<Exercise> exercises = new ArrayList<Exercise>(); 
        MainFrame frame = new MainFrame(Exercise);
        frame.setVisible(true);
    }
}