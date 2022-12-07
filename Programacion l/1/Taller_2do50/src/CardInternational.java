public class CardInternational extends Card implements ActionsCard{

    private static double VALUE_MINUTE = 35;
    //porcentaje de descuento que se aplica para las tarjetas
    //interncionales
    private float percentageDiscount;

    /**
     *describe el número al que se asocia la tarjeta
     * @param number
     * porcentaje de descuento
     * @param percentageDiscount
     */
    public CardInternational(String number, float percentageDiscount) {
        super(number);//número al que se asocia la tarjeta
        this.percentageDiscount = percentageDiscount;//porcentaje de descuento
    }

    public float getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(float percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
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
