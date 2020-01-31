package LogicLayer;

import DataLayer.Bar;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.Vector;

public class JTableModell extends JLabel implements TableModel {

    private Vector bars =new Vector();
    private Vector listeners = new Vector();
    public void addBarsToTable(Bar bar){
        int index=bars.size();
        bars.add(bar);

        TableModelEvent e = new TableModelEvent( this, index, index,
                TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT );


        for( int i = 0, n = listeners.size(); i<n; i++ ){
            ((TableModelListener)listeners.get( i )).tableChanged( e );
        }
    }
    @Override
    public int getRowCount() {
        return bars.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch( columnIndex ){
            case 0: return "ID";
            case 1: return "Barname";
            case 2: return "Stadt";
            case 3: return "Postleitzahl";
            case 4: return "Straße und Hausnummer";
            case 5: return "Nachname";
            case 6: return "Vorname";
            case 7: return "EMail";
            case 8: return "Aktiv";
            default: return null;
        }
    }

    @Override
    // Der Wert der Zelle (rowIndex, columnIndex)
    public Object getValueAt(int rowIndex, int columnIndex) {
        Bar bar = (Bar) bars.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return bar.getId();
            case 1:
                return bar.getBarName();
            case 2:
                return bar.getCity();
            case 3:
                return bar.getPost();
            case 4:
                return bar.getStreet();
            case 5:
                return bar.getSurename();
            case 6:
                return bar.getFirstname();
            case 7:
                return bar.getMail();
            case 8:
                return bar.getNote();
            default:
                return null;
        }
    }

    public Class getColumnClass(int columnIndex) {
        switch( columnIndex ){
            case 0: return String.class;
            case 1: return String.class;
            case 2: return String.class;
            case 3: return String.class;
            case 4: return String.class;
            case 5: return String.class;
            case 6: return String.class;
            case 7: return String.class;
            case 8: return String.class;
            default: return null;
        }
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override //ignorieren!
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
