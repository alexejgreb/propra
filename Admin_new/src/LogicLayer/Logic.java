package LogicLayer;

import DataLayer.DataBase;

import javax.swing.*;

public class Logic {
    //DataBase
    DataBase db = new DataBase();
    //Add Bar
    //                                                                                              streetAndHN = Straße und Hausnummer
    public boolean addBar(String barNumber, String barName, String preName, String sureName, String telefoneNumber, String streetAndHN, String city, String postCode, String eMail, String password){
        //ToDo:boolean einbinden um detaliertere Fehlerausgabe zu ermöglichen!
        boolean booleanBarNumber=false,booleanBarName=false,booleanPreName=false,booleanSureName=false, booleanTelefoneNumber =false,booleanStreetAndHN=false,booleanCity=false,booleanPostCode=false,booleanEMail=false,booleanPassword=false;

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
              //  db.insertBar(intBarNumber,sureName,preName,streetAndHN,city,intPostCode,intTelefoneNumber,eMail,barName,intPassword);
                JOptionPane.showMessageDialog(null,"Bar wurde hinzugefügt!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Fehler beim hinzufügen!");
            }
        }
        return error;
    }

    public void addNewAdmin(String user,String password){
        int id = db.getNewAdminID();
        boolean error=false;

        //prüfen ob Strings leer sind
        if (user.isEmpty()){
            error=true;
        }
        if (password.isEmpty()){
            error=true;
        }

        //
        if (error == false){
            db.insertNewAdmin(id,user,password);
        }
        else{
            JOptionPane.showMessageDialog(null,"Bitte überprüfen Sie ihre eingaben!");
        }
    }
}
