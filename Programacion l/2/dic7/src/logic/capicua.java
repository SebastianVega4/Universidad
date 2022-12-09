package logic;

public class capicua {
    /**
     * cadena donde se guardara los caracteres ingresados por el usuario
     */
    private final String cadena;

    /**
     * @param cadena ingreada por el usuario (constructor)
     */
    public capicua(String cadena) {
        this.cadena = cadena;
    }

    /**
     * calcula y retorna si es o no capicua
     */
    public void getCapicua() {
        boolean validate = true;
        char k, m;
        int j = cadena.length();
        for (int i = 0; i < cadena.length(); i++) {
            k = cadena.charAt(i);
            m = cadena.charAt(j - 1);
            if (k != m) {
                validate = false;
            }
            j--;
        }
        if (validate) {
            System.out.println(cadena + ": SI es capicua");
        } else {
            System.out.println(cadena + ":  NO es capicua");
        }
    }
}

