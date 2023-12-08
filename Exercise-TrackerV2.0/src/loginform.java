import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// The imports help with how to help the statments and to also run to the program.
public class loginform  extends JDialog {
    private boolean loggedIn;
    private String password;
    public void setupGUI() {
        setBounds(300,300,300,300); // This allows the object to be in a certain way and shape
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout()); // That way when you type it doesn't go beyond whatever the bounds are
        JPanel panCenter = new JPanel();
        panCenter.setLayout(new FlowLayout());
        panCenter.add(new JLabel("password: "));
        JPasswordField txtPassword = new JPasswordField(10);
        panCenter.add(txtPassword);
        c.add(panCenter,BorderLayout.CENTER);
        JPanel panSouth = new JPanel();
        JButton btnOK = new JButton("OK");
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredPassword = new String(txtPassword.getPassword());
                if (enteredPassword.equals(password)) {
                    loggedIn = true;
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null,"You entered an incorrect password.");
                    loggedIn = false;
                }
            }
        });
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loggedIn = false;
                setVisible(false);
            }
        });
        panSouth.setLayout(new FlowLayout());
        panSouth.add(btnOK);
        panSouth.add(btnCancel);
        c.add(panSouth,BorderLayout.SOUTH);
    }
    public void LoginForm(JFrame owner, String title, boolean modal) {
        super(owner,title,modal); 
        
        setupGUI();
        password = "Ironmanmk7y2012!!";// The password is what you login to check how caloreis your burned
        loggedIn = false;
    }
    public boolean isLoggedIn() {
        return loggedIn;
    }
    
}
