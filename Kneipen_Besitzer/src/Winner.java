import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;

import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;


public class Winner {

	private JFrame frame;
	private JTextField nummers;
	private JTextField id;
	private static JTextField tnummer;
	private static JTextField tname;
	private static JTable table;
	static Connection con =null;
	private static JTextArea ta;
	private static JLabel lblDatum ;
	private static JLabel kundenr,lblPunkte,lblIdnummer;
	private static JLabel test,lblRang;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {


		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Winner window = new Winner();
					window.frame.setVisible(true);
					tname.setText(Quiz_Verwaltung.tname.getText());
					tnummer.setText(Quiz_Verwaltung.tnummer.getText());


					test.setVisible(false);
					ta.setVisible(false);



				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Winner() {
		initialize();
		frame.setResizable(false);
		con = DataBaseConnector.dbConnectorMariaDB();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 779, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("Spiel_Nummer:");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(12, 26, 129, 16);
		frame.getContentPane().add(label);

		nummers = new JTextField();
		nummers.setText("00000000");
		nummers.setFont(new Font("Tahoma", Font.BOLD, 15));
		nummers.setColumns(10);
		nummers.setBounds(150, 24, 195, 22);
		frame.getContentPane().add(nummers);

		JLabel lblKundennr = new JLabel("ID_Nummer:");
		lblKundennr.setForeground(new Color(0, 0, 255));
		lblKundennr.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKundennr.setBounds(12, 74, 129, 16);
		frame.getContentPane().add(lblKundennr);

		id = new JTextField();
		id.setText("000000000");
		id.setFont(new Font("Tahoma", Font.BOLD, 15));
		id.setColumns(10);
		id.setBounds(150, 72, 195, 22);
		frame.getContentPane().add(id);

		JButton button = new JButton("Suchen");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB_Anfragen.Select_Datum_Spiel(Integer.parseInt(nummers.getText()),lblDatum);
				DB_Anfragen.Select_Info_Kunde_Spiel(Integer.parseInt(nummers.getText()),Integer.parseInt(id.getText()),kundenr,lblPunkte);
				lblIdnummer.setText(id.getText());
				DB_Anfragen.Winner_Punkte(Integer.parseInt(nummers.getText()),test);
				int i = Integer.parseInt(test.getText());/// Max Punkte
				int j = Integer.parseInt(lblPunkte.getText());
				if(j!=i){
					lblRang.setText("Leider nicht gewonnen beim nächsten mal :)");
				}


				if(j==i && j!= 0){
					lblRang.setText("Sie haben gewonnen Herzlichen Glückwunsch !!! :)");
				}

				DB_Anfragen.Quiz_Ergebniss(table,Integer.parseInt(nummers.getText()));


				ta.append("\t Winner: \n\n"+"Spiel_Nr:\t"+nummers.getText()+"\n======================================\n"+"ID_Nummer:\t"+id.getText()+"\n======================================\n"+"Datum:\t"+lblDatum.getText()+"\n======================================\n"+"Erreichte Punkte:\t"+lblPunkte.getText()+"\n\n"+"Beste_Ergebnis:\t"+test.getText()+"\n\n"+
						" \t"+"\n======================================\n"+""+lblRang.getText()+"\n======================================\n");


				try {
					ta.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setForeground(Color.RED);
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.setBounds(598, 131, 153, 31);
		frame.getContentPane().add(button);

		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ta.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrint.setForeground(Color.RED);
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPrint.setBounds(598, 177, 153, 31);
		frame.getContentPane().add(btnPrint);

		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});
		btnExit.setForeground(Color.RED);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBounds(598, 221, 153, 31);
		frame.getContentPane().add(btnExit);

		ta = new JTextArea();
		ta.setEditable(false);
		ta.setBounds(509, 11, 61, 141);
		frame.getContentPane().add(ta);

		JLabel label_1 = new JLabel("Kneipe_Nummer:");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_1.setBounds(583, 13, 168, 16);
		frame.getContentPane().add(label_1);

		tnummer = new JTextField();
		tnummer.setText("310514");
		tnummer.setEditable(false);
		tnummer.setColumns(10);
		tnummer.setBounds(693, 39, 68, 22);
		frame.getContentPane().add(tnummer);

		tname = new JTextField();
		tname.setText("#KneipeXXXY");
		tname.setEditable(false);
		tname.setColumns(10);
		tname.setBounds(593, 39, 93, 22);
		frame.getContentPane().add(tname);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 163, 559, 89);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		lblPunkte = new JLabel("Punkte");
		lblPunkte.setForeground(Color.RED);
		lblPunkte.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPunkte.setBounds(298, 139, 153, 16);
		frame.getContentPane().add(lblPunkte);


		lblIdnummer = new JLabel("ID_Nummer");
		lblIdnummer.setForeground(Color.RED);
		lblIdnummer.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIdnummer.setBounds(12, 103, 129, 16);
		frame.getContentPane().add(lblIdnummer);

		lblDatum = new JLabel("Datum");
		lblDatum.setForeground(Color.RED);
		lblDatum.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDatum.setBounds(12, 139, 225, 16);
		frame.getContentPane().add(lblDatum);

		lblRang = new JLabel("Rang");
		lblRang.setForeground(Color.ORANGE);
		lblRang.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRang.setBounds(357, 64, 404, 37);
		frame.getContentPane().add(lblRang);

		kundenr = new JLabel("Kunden_Nummer");
		kundenr.setForeground(Color.RED);
		kundenr.setFont(new Font("Tahoma", Font.BOLD, 15));
		kundenr.setBounds(287, 103, 129, 16);
		frame.getContentPane().add(kundenr);
		test = new JLabel("0");
		test.setBounds(369, 42, 56, 16);
		frame.getContentPane().add(test);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Haith\\Desktop\\Projekt1\\download Krombacher Hintergrundbild 1024x768-1.jpg"));
		lblNewLabel.setBounds(0, 0, 773, 265);
		frame.getContentPane().add(lblNewLabel);


	}
}
