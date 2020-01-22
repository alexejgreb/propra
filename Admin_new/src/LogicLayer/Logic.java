package LogicLayer;

import DataLayer.Bar;
import DataLayer.DataBase;

import javax.swing.*;
import java.awt.*;

public class Logic {
    //DataBase
    DataBase db = new DataBase();
    //Add Bar
    //                                                                                              streetAndHN = Straße und Hausnummer
    public boolean addBar(String barNumber, String barName, String preName, String sureName, String telefoneNumber, String streetAndHN, String city, String postCode, String eMail, String password){
        //ToDo:boolean einbinden um detaliertere Fehlerausgabe zu ermöglichen!
        boolean booleanBarNumber=false,booleanBarName=false,booleanPreName=false,booleanSureName=false, booleanTelefoneNumber =false,booleanStreetAndHN=false,booleanCity=false,booleanPostCode=false,booleanEMail=false,booleanPassword=false;
        boolean statusDB=false;
        boolean error=false;
        int intBarNumber=0, intTelefoneNumber=0, intPostCode=0, intPassword=0;
        // Prüfen ob Variabeln leer sind

        if (barNumber.isEmpty()) {
            error=true;
        }
        else{
            try {
                intBarNumber = Integer.valueOf(barNumber);
                booleanBarNumber=true;
            } catch (Exception e) {
                error=true;
                // e.printStackTrace();
            }
        }

        if (barName.isEmpty()){
            error=true;
        }else{
            booleanBarName=true;
        }

        if (preName.isEmpty()){
            error=true;
        }
        else{
            booleanPreName=true;
        }

        if (sureName.isEmpty()){
            error=true;
        }else{
            booleanSureName=true;
        }

        if (telefoneNumber.isEmpty()){
            error=true;
        }
        else{
            try{
                intTelefoneNumber= Integer.valueOf(telefoneNumber);
                booleanTelefoneNumber =true;
            } catch (NumberFormatException e) {
                error=true;
                JOptionPane.showMessageDialog(null,"Die Telefonnummer enthält nicht erlaubte Zeichen!");
                // e.printStackTrace();
            }
        }

        if (streetAndHN.isEmpty()){
            error=true;
        }
        else{
            booleanStreetAndHN=true;
        }

        if (city.isEmpty()){
            error=true;
        }else{
            booleanCity=true;
        }

        if (postCode.isEmpty()){
            error=true;
        }
        else{
            try{
                intPostCode = Integer.valueOf(postCode);
                booleanPostCode=true;
        }
            catch (Exception e) {
                error=true;
                JOptionPane.showMessageDialog(null,"Die Postleitzahl enthält nicht erlaubte Zeichen!");
                // e.printStackTrace();
            }
        }

        if (eMail.isEmpty()){
            error=true;
        }else{
            booleanEMail=true;
        }

        if (password.isEmpty()){
            error=true;
        }else{
            try{
                intPassword = Integer.valueOf(password);
                booleanPassword=true;
            } catch (Exception e) {
                error=true;
                JOptionPane.showMessageDialog(null,"Das Passwort darf nur aus Zahlen bestehen!");
                // e.printStackTrace();
            }
        }

        // staus prüfen
        /*if (booleanBarNumber||booleanBarName||booleanPreName||booleanSureName||booleanTelefoneNUmber||booleanStreetAndHN||booleanCity||booleanPostCode||booleanEMail||booleanPassword==false){
            JOptionPane.showMessageDialog(null,"Bitte prüfen Sie noch mal Ihre Angaben!");
        }
        */
        if (error==true){
            JOptionPane.showMessageDialog(null,"Bitte prüfen Sie noch mal Ihre Angaben!");
        }
        else{
            try{
                statusDB=db.insertBar(intBarNumber,sureName,preName,streetAndHN,city,intPostCode,intTelefoneNumber,eMail,barName,intPassword);
                if (statusDB == true){
                    JOptionPane.showMessageDialog(null,"Bar wurde hinzugefügt!");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Fehler beim hinzufügen!");
                }
            } catch (Exception e) {
            }
        }
        return error;
    }

    public boolean addNewAdmin(String user,String password,int master){
        int id = db.getNewAdminID();
        boolean error=false;
        boolean status=false;

        //prüfen ob Strings leer sind
        if (user.isEmpty()){
            error=true;
        }
        if (password.isEmpty()){
            error=true;
        }

        //
        if (error == false){
            db.insertNewAdmin(id,user,password,master);
            JOptionPane.showMessageDialog(null,"Hinzufügen erfolgreich");
            status=true;
        }
        else{
            JOptionPane.showMessageDialog(null,"Bitte überprüfen Sie ihre eingaben!");
        }
        return status;
    }

    public boolean deleteAdmin(String id){
        boolean status=false;
        int tempId=-1;

        if (id.isEmpty()){
            JOptionPane.showMessageDialog(null,"Das ID Feld ist leer!");
        }else{
            try{
                tempId=Integer.valueOf(id);
                db.deleteAdmin(tempId);
                JOptionPane.showMessageDialog(null,"Löschen erfolgreich");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Löschen fehlgschlagen");
            }
        }
        return status;
    }

    public String[] searchAdmin(String id){
        int tempId=-2;
        String[] data = new String[4];

        if(id.isEmpty()){
            JOptionPane.showMessageDialog(null,"Bitte geben Sie eine ID ein zum suchen!");
        }
        else{
            try {
                tempId= Integer.valueOf(id);
                data=db.searchAdmin(tempId);
                } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return data;
    }
    public void editAdmin(int id, String user, String password, int master){
        boolean error=false;
        if (user.isEmpty()){
            JOptionPane.showMessageDialog(null,"Name darf nicht leer sein!");
            error=true;
        }
        if(password.isEmpty()){
            JOptionPane.showMessageDialog(null,"Passwort darf nich leer sein!");
            error=true;
        }
        if (error==false){
            try{
                db.editAdmin(id, user, password, master);
                JOptionPane.showMessageDialog(null,"Änderungen gespeichert!");
            } catch (HeadlessException e) {
                e.printStackTrace();
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"Fehler! \nÄnderungen wurden nicht gespeischert!");
        }
    }

    public boolean deleteBar(String id){
        boolean error =false;
        int tempId=-1;
        if(id.isEmpty()){
            JOptionPane.showMessageDialog(null,"Bitte geben Sie eine ID-Nummer an!");
        }
        else{
            try{
                tempId=Integer.valueOf(id);
                db.deleteBar(tempId);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Die ID enthält unerlaubte Zeichen!");
            }
        }
        return  error;
    }

    public Bar updateBar(Bar bar){
        Bar tempBar= new Bar();
        String test ="";


        return tempBar;
    }

    public void GUI_Edit(JLabel TextInfo,JRadioButton ZeitP,JRadioButton Date,JCheckBox BarNr,JComboBox T1,JComboBox T2, JComboBox M1, JComboBox M2, JComboBox J1, JComboBox J2, JComboBox Bar,JCheckBox Tag1, JCheckBox Tag2, JCheckBox Mo1, JCheckBox Mo2, JCheckBox Ja1, JCheckBox Ja2, JButton Anzeigen,JButton Anull ,int Vermerk)

    {
if(Vermerk==0){
        TextInfo.setVisible(false);
        ZeitP.setVisible(false);
        Date.setVisible(false);
        BarNr.setVisible(false);
        T1.setVisible(false);
        T2.setVisible(false);
        M1.setVisible(false);
        M2.setVisible(false);
        J1.setVisible(false);
        J2.setVisible(false);
        Bar.setVisible(false);
        Tag1.setVisible(false);
        Tag2.setVisible(false);
        Mo1.setVisible(false);
        Mo2.setVisible(false);
        Ja1.setVisible(false);
        Ja2.setVisible(false);
        Anzeigen.setVisible(false);
        Anull.setVisible(false);
    }
    if(Vermerk==1){


        TextInfo.setVisible(true);
        ZeitP.setVisible(true);
        Date.setVisible(true);
        BarNr.setVisible(true);
        T1.setVisible(true);
        T2.setVisible(true);
        M1.setVisible(true);
        M2.setVisible(true);
        J1.setVisible(true);
        J2.setVisible(true);
        Bar.setVisible(true);
        Tag1.setVisible(true);
        Tag2.setVisible(true);
        Mo1.setVisible(true);
        Mo2.setVisible(true);
        Ja1.setVisible(true);
        Ja2.setVisible(true);
        Anzeigen.setVisible(true);
        Anull.setVisible(true);


    }




    }
    public void GUI_Edit0(JLabel TextInfo, JRadioButton Zeit, JRadioButton Date, int Vermerk){

        if(Vermerk==1){

            TextInfo.setVisible(true);
            Zeit.setVisible(true);
            Date.setVisible(true);

        }


    }

}
