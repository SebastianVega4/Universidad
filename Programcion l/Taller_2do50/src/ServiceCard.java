public class ServiceCard {
    //el tamaño del arreglo para el almacenamiento y
    //gestión de los objetos del sistemas
    private int size;

    //Permite instanciar el objeto de gestión, inicializa el tamaño del arreglo en
//un valor, según la decisión del programador. Dimensiona el arreglo de
//objetos
    public ServiceCard() {

    }

    //indicar que el objeto o el número buscado no se encuentra asociado
//a una tarjeta
    //String,
//retorna un objeto o
//un valor null
    public Card findCard(String number) {
        return null;

    }

    //Recibe un Objeto Card, retorna un valor boolean
    public boolean addCard(Card Card) {
        return false;

    }

    //permite realizar una recarga a una tarjeta
    public Card recharge(String number, double Recharge) {
        return null;

    }

    //permite realizar una llamada,
    public boolean call(String number, short minutes) {
        return false;
    }

    //Retorna un clon del arreglo de objetos de la tarjeta
    public Card [] getCard() {
        return null;
    }

    //eliminar una tarjeta del sistema, retorna la tarjeta eliminada.
    public Card deleteCard(String number) {
        return null;
    }

}
