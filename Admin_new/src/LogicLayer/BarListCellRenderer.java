package LogicLayer;

import DataLayer.Bar;

import javax.swing.*;
import java.awt.*;

public class BarListCellRenderer extends JLabel implements ListCellRenderer {

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
        Bar bar = (Bar) value;

        this.setText(bar.getBarName());

        this.setOpaque(true);

        return this;
    }
}
