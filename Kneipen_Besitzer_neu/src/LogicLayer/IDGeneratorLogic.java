package LogicLayer;

import DataLayer.DataBaseConnector;

import javax.swing.*;
import java.sql.PreparedStatement;

public class IDGeneratorLogic {

    public void generate(){
        con = DataBaseConnector.dbConnector();

        try {
            String sql = "insert into Teilnehmer_Spiel (Spiel_NR,ID_Nummer)values (?,?)";
            PreparedStatement pst1 = con.prepareStatement(sql);
            pst1.setString(1, CB1.getSelectedItem().toString());
            pst1.setString(2, lblNewLabel.getText());


            pst1.execute();
            JOptionPane.showMessageDialog(null, "ist erfolgreich zum Spiel  hinzugefügt");

            String sql2 = "insert into Kunde_Spiel (Kunden_Nr,Spiel_Nr,ID_Nummer)values (?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql2);
            pst.setString(1, t1.getText());
            pst.setString(2, CB1.getSelectedItem().toString());
            pst.setString(3, lblNewLabel.getText());


            pst.execute();
            JOptionPane.showMessageDialog(null, "Für den Spiel '" + CB1.getSelectedItem().toString() + "' erfolgreich angemeldet ");


            ta.append("\t Anmeldung_Spiel: \n\n" + "Spiel_Nr: " + CB1.getSelectedItem().toString() + "\n======================================\n" + "Kunden_Nummer:" + t1.getText() + "\n\n" + "Kunden_name:" + l1.getText() + "\n======================================\n" + "Kunden_Vorname:" + l2.getText() + "\n\n" + "Zugang_Daten :\t" + lblNewLabel.getText() + "\n\n" +
                    " \t" + " \n======================================\n" + " \n======================================\n" + " \n Wichtig!! Die Zugangsnummer aufbewahren\n");


        } catch (Exception e11) {
            //e11.printStackTrace();
            JOptionPane.showMessageDialog(null, e11);
        }
				/*
				try{
					String sql2 = "insert into Kunde_Spiel (Kunden_Nr,Spiel_Nr,ID_Nummer)values (?,?,?)";
					PreparedStatement pst=con.prepareStatement(sql2);
					pst.setString(1, t1.getText());
					pst.setString(2, CB1.getSelectedItem().toString());
					pst.setString(3, lblNewLabel.getText());



					pst.execute();
					JOptionPane.showMessageDialog(null,"Für den Spiel '"+CB1.getSelectedItem().toString()+"' erfolgreich angemeldet ");



					ta.append("\t Anmeldung_Spiel: \n\n"+"Spiel_Nr: "+CB1.getSelectedItem().toString()+"\n======================================\n"+"Kunden_Nummer:"+t1.getText()+"\n\n"+"Kunden_name:"+l1.getText()+"\n======================================\n"+"Kunden_Vorname:"+l2.getText()+"\n\n"+"Zugang_Daten :\t"+lblNewLabel.getText()+"\n\n"+
							" \t"+" \n======================================\n"+" \n======================================\n"+" \n Wichtig!! Die Zugangsnummer aufbewahren\n");




						}
						catch(Exception e111){
							//e111.printStackTrace();
							JOptionPane.showMessageDialog(null,e111);
						}


				*/
    }
    }
}
