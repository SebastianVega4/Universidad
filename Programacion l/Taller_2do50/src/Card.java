public class Card implements ActionsCard{
    //Especifica el número asociado a la tarjeta de llamadas
    protected String number;
    protected short minutes;
    protected double residue;
    /**
     *describe el número al que se asocia la tarjeta
     * @param number
     */
    public Card(String number) {
        this.number = number;
        minutes = 0;
        residue = 0;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public short getMinutes() {
        return minutes;
    }

    public double getResidue() {
        return residue;
    }


    @Override
    public double recharge(double recharge) {
        return 0;
    }

    @Override
    public boolean call(short minutes) {
        return false;
    }
}
