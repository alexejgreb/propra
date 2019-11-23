package UILayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class UIRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JTextField textFieldUserMail;
	private JPasswordField passwordFieldUserPw;
	private JPasswordField passwordFieldUserPwRepeat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIRegistration frame = new UIRegistration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UIRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("192px"),
				ColumnSpec.decode("49px:grow"),},
			new RowSpec[] {
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblAnmelden = new JLabel("Anmelden");
		contentPane.add(lblAnmelden, "2, 2, left, top");
		
		JLabel LabelUserName = new JLabel("Benutzername");
		contentPane.add(LabelUserName, "1, 4, right, default");
		
		textFieldUserName = new JTextField();
		contentPane.add(textFieldUserName, "2, 4, fill, default");
		textFieldUserName.setColumns(10);
		
		JLabel LabelUserMail = new JLabel("E-Mail Adresse");
		contentPane.add(LabelUserMail, "1, 6, right, default");
		
		textFieldUserMail = new JTextField();
		contentPane.add(textFieldUserMail, "2, 6, fill, default");
		textFieldUserMail.setColumns(10);
		
		JLabel LabelUserPw = new JLabel("Passwort");
		contentPane.add(LabelUserPw, "1, 8, right, default");
		
		passwordFieldUserPw = new JPasswordField();
		contentPane.add(passwordFieldUserPw, "2, 8, fill, default");
		
		JLabel LabelUserPwRepeat = new JLabel("Passwort wiederholen");
		contentPane.add(LabelUserPwRepeat, "1, 10, right, default");
		
		passwordFieldUserPwRepeat = new JPasswordField();
		contentPane.add(passwordFieldUserPwRepeat, "2, 10, fill, default");
		
		JButton ButtonRegistration = new JButton("Anmelden");
		contentPane.add(ButtonRegistration, "2, 18");
	}

}
