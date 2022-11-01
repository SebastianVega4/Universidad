public interface ActionsCard {
    //tarjeta nacional, se debe abonar un
    //25% adicional del valor de la recarga
     public abstract double recharge(double recharge);

    //cantidad de minutos
    public abstract boolean call(short minutes);
}
