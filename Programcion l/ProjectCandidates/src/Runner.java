import Logic.Candidate;
import Logic.Municipality;
import Logic.Vote;

import javax.swing.*;

public class Runner {
    public static void main(String[] args) {
        String[] options = {"Ingresar datos", "SALIR"};
        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione accion a relizar", "ELECCIONES",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        switch (seleccion) {
            case 0 -> menuPrincipal();
            case 1 -> System.exit(0);
        }
    }







    private static void menuPrincipal() {
        int nCanditates = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero de candidatos"));
        int nMunicipalitys = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero de Municipios"));
        Vote elecciones = new Vote(nCanditates, nMunicipalitys);

        for (int i = 0; i < nCanditates; i++) {
            String[] namesCandidates = {"Pedro", "Sofia", "Katheryne", "Julian", "Sebastian", "Johan", "Camilo", "Derly", "Adriana", "Jessica"};
            int Select = JOptionPane.showOptionDialog(null, "Seleccione el Nombre del candidato #" + (i + 1), "VOTACIONES",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, namesCandidates, namesCandidates[0]);
            Candidate canditate = new Candidate(namesCandidates[Select]);
            elecciones.addCandidates(canditate);
        }

        for (int j = 0; j < nMunicipalitys; j++) {
            String[] namesMunicipality = {"Paipa", "Duitama", "Sogamoso", "Tunja", "Tibasosa", "Bogota", "Aguazul", "Chiquinquira"};
            int Select = JOptionPane.showOptionDialog(null, "Seleccione el Municipio #" + (j + 1), "VOTACIONES",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, namesMunicipality, namesMunicipality[0]);
            Municipality municipality = new Municipality(namesMunicipality[Select]);
            elecciones.addMunicipalitys(municipality);
        }
        int nRango = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el Rango del numero aleatorio"));
        elecciones.fileVotes(nRango);//RANGO ALEATORIO
        Object seleccion;
        do {
            String[] options = {"Total por candidatos", "Total por Municipios", "Total de votos", "Candidato Ganador", "Ver resultados de un candidato", "Votos ordenados Desendentemente", "SALIR"};
            seleccion = JOptionPane.showInputDialog(null, "Seleccione accion a relizar", "ELECCIONES",
                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            System.out.println(seleccion);
            if ("Total por candidatos".equals(seleccion)) {
                JOptionPane.showMessageDialog(null, "Total por candidatos" + "\n" + elecciones.gettotalvotesCandidate());

            } else if ("Total por Municipios".equals(seleccion)) {
                JOptionPane.showMessageDialog(null, "Total por Municipios" + "\n" + elecciones.gettotalvotesMunicipality());

            } else if ("Total de votos".equals(seleccion)) {
                JOptionPane.showMessageDialog(null, "Total de votos:  " + elecciones.totalVotes());

            } else if ("Candidato Ganador".equals(seleccion)) {
                JOptionPane.showMessageDialog(null, "Candidato Ganador" + "\n" + elecciones.winCandidate().getNameCandidate());

            } else if ("Ver resultados de un candidato".equals(seleccion)) {
                int selecc = JOptionPane.showOptionDialog(null, "Seleccione accion a relizar", "ELECCIONES",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, elecciones.getCandidates(), elecciones.getCandidates()[0]);
                JOptionPane.showMessageDialog(null, "Maximo" + "\n" + elecciones.maxCandidate(selecc));
                JOptionPane.showMessageDialog(null, "Minimo" + "\n" + elecciones.minCandidate(selecc));
                JOptionPane.showMessageDialog(null, "Promedio" + "\n" + elecciones.promCandidate(selecc));

            } else if ("Votos ordenados Desendentemente".equals(seleccion)) {
                JOptionPane.showMessageDialog(null, "Ordenados Desendentemente" + "\n" + elecciones.getDesendet());

            } else if ("SALIR".equals(seleccion) || "null".equals(seleccion)) {
                System.exit(0);
            }
        } while (true);

    }

}