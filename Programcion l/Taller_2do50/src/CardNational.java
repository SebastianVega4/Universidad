public class CardNational extends Card {

    public double VALUE_MINUTE = 20;//valor del minuto
    private Operator operator; //Operador de la tarjeta

    public CardNational(String number, Operator operator) {
        //el número al que
        //se asocia la tarjeta
        super(number);
        //objeto Operator
        this.operator = operator;
    }

    //Operator getOperator
    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
