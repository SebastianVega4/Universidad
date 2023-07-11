package co.edu.uptc.logic;

public class GameRamdom implements Juego{
private int num;
    public GameRamdom() {
        Random random = new Random();
        num = random.nextInt(100+ 1) + 1;
    }

    @Override
    public String iniciar() {
        return "El juego a iniciado";

    }

    @Override
    public String jugar() {
        do {
            numA = Integer.parseInt(JOptionPane.showInputDialog("Dijite el numero a divinar"));
            numeroIN++;
                if (numA > num) {
                    JOptionPane.showMessageDialog(null, "El numero es Menor a " + numA);
                }
                if (numA < num) {
                    JOptionPane.showMessageDialog(null, "El numero es Mayor a " + numA);
                }
                if (numA == num) {
                    JOptionPane.showMessageDialog(null, "Adivinaste \n " + "Usted realizo " + numeroIN + " intendos");
                }
            }
        } while (numA != num);
    }

    @Override
    public String finalizar() {
        return "Gracias por jugar";
    }


}
