package UILayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class UIGame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIGame frame = new UIGame();
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
	public UIGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JProgressBar progressBar = new JProgressBar();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.insets = new Insets(0, 0, 5, 0);
		gbc_progressBar.gridx = 2;
		gbc_progressBar.gridy = 0;
		contentPane.add(progressBar, gbc_progressBar);
		
		JLabel lblQuestion = new JLabel("Frage");
		GridBagConstraints gbc_lblQuestion = new GridBagConstraints();
		gbc_lblQuestion.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuestion.gridx = 1;
		gbc_lblQuestion.gridy = 1;
		contentPane.add(lblQuestion, gbc_lblQuestion);
		
		JButton jButtonAnswer1 = new JButton("Antwort1");
		GridBagConstraints gbc_ButtonAnswer1 = new GridBagConstraints();
		gbc_ButtonAnswer1.insets = new Insets(0, 0, 5, 5);
		gbc_ButtonAnswer1.gridx = 0;
		gbc_ButtonAnswer1.gridy = 4;
		contentPane.add(jButtonAnswer1, gbc_ButtonAnswer1);
		
		JButton jButtonAnswer2 = new JButton("Antwort2");
		jButtonAnswer2.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_jButtonAnswer2 = new GridBagConstraints();
		gbc_jButtonAnswer2.insets = new Insets(0, 0, 5, 0);
		gbc_jButtonAnswer2.gridx = 2;
		gbc_jButtonAnswer2.gridy = 4;
		contentPane.add(jButtonAnswer2, gbc_jButtonAnswer2);
		
		JButton jButtonAnswer3 = new JButton("Antwort3");
		GridBagConstraints gbc_jButtonAnswer3 = new GridBagConstraints();
		gbc_jButtonAnswer3.insets = new Insets(0, 0, 0, 5);
		gbc_jButtonAnswer3.gridx = 0;
		gbc_jButtonAnswer3.gridy = 5;
		contentPane.add(jButtonAnswer3, gbc_jButtonAnswer3);
		
		JButton jButtonAnswer4 = new JButton("Antwort4");
		GridBagConstraints gbc_jButtonAnswer4 = new GridBagConstraints();
		gbc_jButtonAnswer4.gridx = 2;
		gbc_jButtonAnswer4.gridy = 5;
		contentPane.add(jButtonAnswer4, gbc_jButtonAnswer4);
	}
}
