import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JFileChooser;
import java.io.*;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.image.BufferedImage;
// These are help set-up the framework when we start making the assignment and adding to the code
public class MainFrame extends JFrame  implements ActionListener {
    private ArrayList<Exercise> exercises;
    private JMenuItem miLogin;
    private JMenuItem miLogout;
    private ExerciseDetailPanel edp;
    private JButton btnAddExericse;
    public  void setupMenu(){
        JMenuBar mbar = new JMenuBar();
        setJMenuBar(mbar);
        JMenu mnuFile = new JMenu("File"); // The file is where you can store your information
        mbar.add(mnuFile);
        miLogin = new JMenuItem("Log in");
        miLogin.addActionListener(this);
        miLogout = new JMenuItem("Log out");
        JMenuItem miSave = new JMenuItem("Save");
        JMenuItem miExit = new JMenuItem("Exit");
        mnuFile.add(miLogin);
        mnuFile.add(miLogout);
        miLogout.addActionListener(this);
        mnuFile.add(miSave);
        miSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                File f;
                if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    f = chooser.getSelectedFile();
                    if (ExerciseWriter.writeToFile(f,exercises)) {
                        JOptionPane.showMessageDialog(null,"Circles were saved.");
                    } else {
                        JOptionPane.showMessageDialog(null,"Could not save the circles.");
                    }
                }
            }
        });
        mnuFile.add(miExit);
        miExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JMenu mnuHelp = new JMenu("Help");
        mbar.add(mnuHelp);
        JMenuItem miAbout = new JMenuItem("About");
        miAbout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"App App GUI Version CPSC 245000");
            }
        });
        mnuHelp.add(miAbout);
    }
    public void setupGUI() {
        setBounds(100,100,500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Exercise");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        edp = new ExerciseDetailPanel();
        SummaryPanel sumPan = new SummaryPanel();
        c.add(edp,BorderLayout.WEST);
        c.add(sumPan,BorderLayout.EAST);
        JPanel panSouth = new JPanel();
        btnAddExericse = new JButton("Add Exercise");
        AbstractButton btnAddExercise;
        btnAddExercise.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // This statement allows the action to be perfomed with exercise trackerV2.0 to set up the comments with the setup
                double x=0,y=0,radius=0, totalArea;
                ArrayList<String> errors = new ArrayList<String>();
                try {
                    x = edp.getXVal();
                } catch (Exception ex) {
                    errors.add("The x value must be numeric.");
                }
                try {
                    y = edp.getYVal();
                } catch (Exception ex) {
                    errors.add("The y value must be numeric.");
                }
                try {
                    radius = edp.getRadius();
                } catch (Exception ex) {
                    errors.add("The radius must be numeric.");
                }
                String comment = edp.getComment();
                String errorMessage = "";
                if (errors.size() > 0) {
                    for (String error: errors) {
                        errorMessage = errorMessage + error + " ";
                    }
                    JOptionPane.showMessageDialog(null,"These errors occurred: " + errorMessage);
                } else {
                    Exercise c = new Exercise(x,y,radius,comment);
                    Exercise.add(e);
                    sumPan.updateList();
                    edp.clearEntries();
                    totalArea = Exercise.getTotalArea(Exercise);
                    sumPan.setSummaryLabel(String.format("Total area = %.2f",totalArea));
                    repaint();    // refreshes the frame's appearance
                }
            }
        });
        panSouth.setLayout(new FlowLayout());
        panSouth.add(btnAddExercise);
        c.add(panSouth,BorderLayout.SOUTH);
        setupMenu();
        enableEntries(false); // disables all the entries at the start
    }
    public MainFrame(ArrayList<Exercise> circles) {
        this.exercises = exercises;
        setupGUI();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }   
}
