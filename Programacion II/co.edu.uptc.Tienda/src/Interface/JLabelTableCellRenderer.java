package Interface;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class JLabelTableCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Si estamos en la columna 4, y el valor es un ImageIcon
        if (value instanceof ImageIcon) {
            // Crear un JLabel y establecer el ImageIcon en �l
            JLabel label = new JLabel((ImageIcon) value);

            // Centrar el ImageIcon dentro de la celda
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);

            // Devolver el JLabel
            return label;
        } else {
            // Si no estamos en la columna 4 o el valor no es un ImageIcon,
            // usar el comportamiento predeterminado del renderizador

            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }

}
