import javax.swing.*;

public class Runner {
    public static void main(String[] args) {
        int seleccion = 0;
        for (int i = 0; seleccion == 3; i++) {
            seleccion = JOptionPane.showOptionDialog(null,
                    "¿Que SimCard quiere adquirir?", "Adquirir SimCard",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, new Object[]{"SimCard Nacional", "SimCard Internacional, EXIT"}, null);

            String option = (String) JOptionPane.showInputDialog(null,
                    "Seleccione opcion", "Selector de opciones", JOptionPane.QUESTION_MESSAGE,
                    null, new Object[]{"CLARO", "MOVISTAR", "ETB", "TIGO", "VIRGIN", "WOM"},
                    "EXIT");

            switch (seleccion) {
                case 0:
                    System.out.println("Usted selecciono una SimCard Nacional de un operador " + option);
                    CardNational card[i] = new CardNational("",Operator.valueOf(option));
                    break;
                case 1:
                    System.out.println("Usted selecciono una SimCard InterNacional de un operador " + option);
                    break;
                case 3:
                    break;
                default:
            }
        }
    }
}

