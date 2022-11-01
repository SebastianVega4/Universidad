public class Card implements  ActionsCard{
    //Especifica el número asociado a la tarjeta de llamadas
    protected String number;
    protected short minutes;
    protected double residue;

    public Card(String number) {
        //Recibe un String que describe el número al que se asocia la tarjeta
        this.number = number;
        minutes = 0;
        residue = 0;
    }
    /* esta mal
    public CardPhone(String number){
        this.number = number;
    }*/

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
    public double recharge() {
        return 0;
    }

    @Override
    public boolean call(short minutes) {
        return false;
    }
    /*
    public void setMinutes(short minutes) {
        this.minutes = minutes;
    }
    public void setResidue(double residue) {
        this.residue = residue;
    }*/
}
