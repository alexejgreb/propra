import java.awt.EventQueue;





import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;

import javax.swing.DefaultComboBoxModel;


public class Auto_Fragen {




	private JFrame frame;
	private static  JTextField tt;
	private static JTextField ff;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTable table;
	private static JTextField s1;
	private static JTextField f1;
	static Connection con =null;
	private static JLabel l1,l2;
	/**
	 * Launch the application.
	 */
	public static void Fragen_Quiz() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Auto_Fragen window = new Auto_Fragen();
					window.frame.setVisible(true);


					tt.setText(Spiel_Starten.tvt.getText());
					s1.setText(Spiel_Starten.t1.getText());
					ff.setText(Spiel_Starten.ff.getText());
					f1.setText(Spiel_Starten.cb.getSelectedItem().toString()+" / "+Spiel_Starten.cc.getSelectedItem().toString());
					l1.setText(Spiel_Starten.cb.getSelectedItem().toString());
					l2.setText(Spiel_Starten.cc.getSelectedItem().toString());
					l1.setVisible(false);
					l2.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Auto_Fragen() {
		initialize();
		frame.setResizable(false);
		con = DataBaseConnector.dbConnectorMariaDB();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 779, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("Kneipe_Nummer:");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label.setBounds(581, 0, 168, 29);
		frame.getContentPane().add(label);

		tt = new JTextField();
		tt.setFont(new Font("Tahoma", Font.BOLD, 13));
		tt.setText("#KneipeXXXY");
		tt.setEditable(false);
		tt.setColumns(10);
		tt.setBounds(581, 31, 93, 22);
		frame.getContentPane().add(tt);

		ff = new JTextField();
		ff.setFont(new Font("Tahoma", Font.BOLD, 13));
		ff.setText("310514");
		ff.setEditable(false);
		ff.setColumns(10);
		ff.setBounds(681, 31, 68, 22);
		frame.getContentPane().add(ff);

		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Default", "POP_Quiz"}));
		comboBox.setBounds(12, 77, 153, 22);
		frame.getContentPane().add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"POP_Quiz", "Defaul"}));
		comboBox_1.setBounds(196, 77, 153, 22);
		frame.getContentPane().add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_2.setEnabled(false);
		comboBox_2.setBounds(375, 77, 153, 22);
		frame.getContentPane().add(comboBox_2);

		txt1 = new JTextField();
		txt1.setFont(new Font("Tahoma", Font.BOLD, 16));
		txt1.setText("0");
		txt1.setBounds(12, 42, 99, 22);
		frame.getContentPane().add(txt1);
		txt1.setColumns(10);

		txt2 = new JTextField();
		txt2.setText("0");
		txt2.setFont(new Font("Tahoma", Font.BOLD, 16));
		txt2.setColumns(10);
		txt2.setBounds(196, 42, 99, 22);
		frame.getContentPane().add(txt2);

		txt3 = new JTextField();
		txt3.setFont(new Font("Tahoma", Font.BOLD, 16));
		txt3.setText("0");
		txt3.setEditable(false);
		txt3.setColumns(10);
		txt3.setBounds(375, 42, 99, 22);
		frame.getContentPane().add(txt3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 143, 562, 97);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnPrint = new JButton("Print");
		btnPrint.setForeground(Color.ORANGE);
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPrint.setBounds(596, 193, 153, 36);
		frame.getContentPane().add(btnPrint);

		JButton btnHinzufgen = new JButton("Hinzufügen");
		btnHinzufgen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {





























			}
		});
		btnHinzufgen.setForeground(Color.ORANGE);
		btnHinzufgen.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHinzufgen.setBounds(596, 67, 153, 50);
		frame.getContentPane().add(btnHinzufgen);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});
		btnExit.setForeground(Color.ORANGE);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBounds(596, 130, 153, 50);
		frame.getContentPane().add(btnExit);

		JComboBox DefaultF = new JComboBox();
		DefaultF.setBounds(97, 112, 68, 22);
		frame.getContentPane().add(DefaultF);

		JComboBox POPF = new JComboBox();
		POPF.setBounds(281, 112, 68, 22);
		frame.getContentPane().add(POPF);

		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(460, 112, 68, 22);
		frame.getContentPane().add(comboBox_5);

		JLabel lblSpielnummer = new JLabel("Spiel_Nummer:");
		lblSpielnummer.setForeground(Color.RED);
		lblSpielnummer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblSpielnummer.setBounds(12, 10, 153, 22);
		frame.getContentPane().add(lblSpielnummer);

		JLabel lblFragenrunden = new JLabel("Fragen/Runden");
		lblFragenrunden.setForeground(Color.RED);
		lblFragenrunden.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblFragenrunden.setBounds(321, 10, 145, 22);
		frame.getContentPane().add(lblFragenrunden);

		s1 = new JTextField();
		s1.setEditable(false);
		s1.setFont(new Font("Tahoma", Font.BOLD, 16));
		s1.setColumns(10);
		s1.setBounds(169, 11, 99, 22);
		frame.getContentPane().add(s1);

		f1 = new JTextField();
		f1.setEditable(false);
		f1.setFont(new Font("Tahoma", Font.BOLD, 16));
		f1.setColumns(10);
		f1.setBounds(470, 11, 99, 22);
		frame.getContentPane().add(f1);

		l1 = new JLabel("");
		l1.setBounds(493, 34, 29, 16);
		frame.getContentPane().add(l1);

		l2 = new JLabel("");
		l2.setBounds(503, 48, 22, 16);
		frame.getContentPane().add(l2);
	}
}
