package Logic;

import Interface.Contacs;
import java.util.HashMap;
import java.util.Map;

public class AgentContacs {
    private final Map<String, Contacs> contac;
    public AgentContacs() {
        contac = new HashMap<>();
    }

    public void addContacs(String name, String phone) {
        Contacs contacSum = new Contacs(name, phone);
        contac.put(name, contacSum);
    }

    public String modificContacs(String name, String newPhone) {
        if (contac.containsKey(name)) {
            Contacs contacto = contac.get(name);
            contacto.setPhone(newPhone);
        } else {
            return "El contacto no existe en la agenda";
        }
        return "Contacto Modificado";
    }
    public String eraseContac(String name) {
        if (contac.containsKey(name)) {
            contac.remove(name);
        } else {
            return "El contacto no existe en la agenda.";
        }
        return "Contacto Borrado";
    }
    public String findContacForFirstLater(char later) {
        String canden="";
        for (String name : contac.keySet()) {
            if (name.charAt(0) == later ) {
                Contacs contacView = contac.get(name);
                canden = canden +"\n"+ contacView.getName() + ": " + contacView.getPhone();
            }
        }
        if (canden.equals("")){
            return "no se encontro contracto con esa inicial";
        }else {
            return canden;
        }
    }
}