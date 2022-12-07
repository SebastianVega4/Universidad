import javax.swing.*;
import java.util.Arrays;
public class ServiceCard {

    //el tamaño del arreglo para el almacenamiento y
    //gestión de los objetos del sistemas
    private Card[] cards;
    private int size;

    //Permite instanciar el objeto de gestión, inicializa el tamaño del arreglo en
    //un valor, según la decisión del programador. Dimensiona el arreglo de
    //objetos
    public ServiceCard() {
        this(10);
    }
    /**
     *Dimencion del arreglo
     * @param dimension
     */
    public ServiceCard(int dimension) {
        cards = new Card[dimension];
        size = 0;
    }

    private void ensureCapacity(int min) {
        if (min > cards.length) {
            int newCapacity = cards.length + (cards.length / 2);
            cards = Arrays.copyOf(cards, newCapacity);
        }
    }

    //indicar que el objeto o el número buscado no se encuentra asociado
    //a una tarjeta
    //String,
    //retorna un objeto o
    //un valor null

    /**
     *numero de tarjeta que se desea encontrar
     * @param number
     */
    public Card findCard(String number) {
        for (int i = 0; i < cards.length; i++) {
            if (number == cards[i].getNumber()) {
                return null;
            } else {
                return cards[i];
            }
        }
        return null;
    }
    /**
     *targeta a añadir
     * @param card
     */
    //Recibe un Objeto Card, retorna un valor boolean
    public boolean addCard(Card card) {
        if (findCard(card.getNumber()) != null) {
            ensureCapacity(size + 1);
            cards[size++] = card;
            return true;
        } else {
            return false;

        }
    }
    /**
     *valor de recarga
     * @param recharge
     */
    //permite realizar una recarga a una tarjeta
    public Card recharge(String number, double recharge) {
        if (findCard(number) == null) {
            JOptionPane.showInputDialog("fracaso de la recarga");
        } else if (recharge < 0) {
            JOptionPane.showInputDialog("fracaso de la recarga");
        } else {
            JOptionPane.showInputDialog("Exito de la recarga");

        }
        return null;

    }
    /**
     *minutos que va a durar la llamada
     * @param minutes
     */
    //permite realizar una llamada,
    public boolean call(String number, short minutes) {
        if (findCard(number) == null) {
            JOptionPane.showInputDialog("fracaso de la llamada");
        }/* else if (findCard().getResidue() < findCard().getMinutes()) {
            JOptionPane.showInputDialog("fracaso de la llamada");
        }*/else if (minutes < 0) {
            JOptionPane.showInputDialog("fracaso de la llamada");
        }else {
            JOptionPane.showInputDialog("Exito de la llamada");
        }
        return false;
    }

    //Retorna un clon del arreglo de objetos de la tarjeta
    public Card[] getCard() {
        return cards.clone();
    }
    /**
     *
     * Numero de tarjeta a eliminar
     * @param number
     */
    //eliminar una tarjeta del sistema, retorna la tarjeta eliminada.
    public Card deleteCard(String number) {
        /*if (findCard(number) >= 0 && findCard(number) < cards.length) {
            String removed = cards[findCard(number)];
            cards[findCard(number)] = null;
            for (int i = findCard(number); i <= size; i++) {
                cards[i] = cards[i + 1];
            }
            size--;
            return removed;
        }*/
        return null;
    }

}
