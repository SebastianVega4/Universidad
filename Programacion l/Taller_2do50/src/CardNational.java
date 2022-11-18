public class CardNational extends Card implements ActionsCard{

    public static double VALUE_MINUTE = 20;//valor del minuto
    private Operator operator; //Operador de la tarjeta
    /**
     *describe el número al que se asocia la tarjeta
     * @param number
     * operador emun seleccionado
     * @param operator
     */
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

    @Override
    public double recharge(double recharge) {
        return super.recharge(recharge);
    }

    @Override
    public boolean call(short minutes) {
        return super.call(minutes);
    }
}
