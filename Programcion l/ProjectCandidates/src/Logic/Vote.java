package Logic;

import java.util.Arrays;

public class Vote {
    int[][] votations;
    Municipality[] municipalitys;
    Candidate[] candidates;

    public Vote(int columns, int rows) {
        votations = new int[rows][columns];
        municipalitys = new Municipality[rows];
        candidates = new Candidate[columns];
    }

    //Rellenar matriz de votos aleatorios
    //correcto
    public void fileVotes(int RANGE) {
        for (var i = 0; i < votations.length; i++) {
            for (var j = 0; j < votations[i].length; j++) {
                votations[i][j] = (int) (Math.random() * RANGE + 1);
            }
        }
        System.out.println(Arrays.deepToString(votations));
    }

    //añadir candidatos
    public void addCandidates(Candidate candidate) {
        for (var i = 0; i < candidates.length; i++) {
            if (candidates[i] == null) {
                candidates[i] = candidate;
                break;
            }
        }
    }

    //añadir Municipios
    public void addMunicipalitys(Municipality municipality) {
        for (var i = 0; i < municipalitys.length; i++) {
            if (municipalitys[i] == null) {
                municipalitys[i] = municipality;
                break;
            }
        }
    }

    //calcula el candidato ganador y retorna el objeto candidato
    public Candidate winCandidate() {
        int[] aux = totalVotesCandidate();
        var win = 0;
        var pos = 0;
        for (int i = 0; i < totalVotesCandidate().length; i++) {
            if (aux[i] > win) {
                win = aux[i];
                pos = i;
            }
        }
        System.out.println(candidates[pos].getNameCandidate());
        return candidates[pos];
    }

    //total de votos por Municipios guardado en un array
    public int[] totalVotesMunicipality() {
        int[] totalVotes = new int[votations.length];

        for (var i = 0; i < votations.length; i++) {
            int sum = 0;
            for (var j = 0; j < votations[i].length; j++) {
                sum += votations[i][j];
            }
            totalVotes[i] = sum;
        }
        return totalVotes;
    }

    //total de votos por candidatos guardado en un array
    public int[] totalVotesCandidate() {
        int[] totalVotes = new int[votations[0].length];
        for (var i = 0; i < votations[0].length; i++) {
            int sum = 0;
            for (int[] votation : votations) {
                sum += votation[i];
            }
            totalVotes[i] = sum;
        }
        return totalVotes;
    }

    //total de votos en general
    public int totalVotes() {
        int total = 0;
        int[] aux = totalVotesMunicipality();
        for (int j : aux) {
            total += j;
        }
        System.out.println(total);
        return total;
    }

    public String maxCandidate(int candidate) {
        System.out.println(Arrays.deepToString(votations));
        var max = 0;
        var auxinter = 0;
        for (var i = 0; i < municipalitys.length; i++) {
            if (votations[i][candidate] > max) {
                auxinter = i;
                max = votations[i][candidate];
            }
        }
        String impr = "";
        impr = "" + impr + "     " + municipalitys[auxinter].getNameMunicipy();
        impr = "" + impr + "     " + max + "\n";
        System.out.println(impr);
        return impr;
    }

    public String minCandidate(int candidate) {
        var min = votations[0][candidate];
        var auxinter = 0;
        for (var i = 0; i < municipalitys.length; i++) {
            if (votations[i][candidate] < min) {
                auxinter = i;
                min = votations[i][candidate];
            }
        }
        String impr = "";
        impr = "" + impr + "     " + municipalitys[auxinter].getNameMunicipy();
        impr = "" + impr + "     " + min + "\n";
        System.out.println(impr);
        return impr;
    }

    public double promCandidate(int candidate) {
        var prom = totalVotesCandidate()[candidate];
        prom = prom / totalVotesMunicipality().length;
        System.out.println("Promedio " + prom);
        return prom;
    }

    public String[] getCandidates() {
        String[] candidatess = new String[totalVotesCandidate().length];
        for (int j = 0; j < totalVotesCandidate().length; j++) {
            candidatess[j] = candidates[j].getNameCandidate();
        }
        return candidatess;
    }

    public String[][] ordSelDesc() {
        int[] votess = totalVotesCandidate();
        String[] candidatess;
        candidatess = getCandidates();
        String[][] order;
        //iteramos sobre los elementos del arreglo
        for (int i = 0; i < totalVotesCandidate().length - 1; i++) {
            int max = i;
            //buscamos el mayor número
            for (int j = i + 1; j < totalVotesCandidate().length; j++) {
                if (votess[j] > votess[max]) {
                    max = j;    //encontramos el mayor número
                }
            }
            if (i != max) {
                //permutamos los valores
                int aux = votess[i];
                String auxcan = candidatess[i];
                votess[i] = votess[max];
                candidatess[i] = candidatess[max];
                votess[max] = aux;
                candidatess[max] = auxcan;
            }
        }
        order = new String[2][candidatess.length];
        for (int k = 0; k < candidatess.length; k++) {
            //assign el nombre de los candidatos
            order[0][k] = candidatess[k];
            //assign los votantes
            order[1][k] = String.valueOf(votess[k]);
        }
        return order;
    }

    public String gettotalvotesCandidate() {
        totalVotesCandidate();
        String impr = "";
        for (var j = 0; j < candidates.length; j++) {
            impr = "" + impr + "     " + candidates[j].getNameCandidate();
            impr = "" + impr + "     " + totalVotesCandidate()[j] + "\n";
        }
        System.out.println(impr);
        return impr;
    }

    public String gettotalvotesMunicipality() {
        totalVotesMunicipality();
        String impr = "";
        for (var j = 0; j < municipalitys.length; j++) {
            impr = "" + impr + "     " + municipalitys[j].getNameMunicipy();
            impr = "" + impr + "     " + totalVotesMunicipality()[j] + "\n";
        }
        System.out.println(impr);
        return impr;
    }

    public String getDesendet() {
        ordSelDesc();
        String impr = "";
        for (var j = 0; j < ordSelDesc()[0].length; j++) {
            impr = "" + impr + "     " + ordSelDesc()[0][j];
            impr = "" + impr + "     " + ordSelDesc()[1][j] + "\n";
        }
        System.out.println(impr);
        return impr;
    }
}