public class CardInternational extends Card {

    private final double VALUE_MINUTE = 35;
    //porcentaje de descuento que se aplica para las tarjetas
    //interncionales
    private float percentageDiscount;

    public CardInternational(String number/*,String */, float percentageDiscount) {
        super(number);//número al que se asocia la tarjeta
        this.percentageDiscount = percentageDiscount;//porcentaje de descuento
    }

    public float getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(float percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }
    /*
    public double getVALUE_MINUTE() {
        return VALUE_MINUTE;
    }
    public void setVALUE_MINUTE(double VALUE_MINUTE) {
        this.VALUE_MINUTE = VALUE_MINUTE;
    }*/


}
