package Logic;

public class Candidate {
    private final String nameCandidate;

    /**
     * @param nameCandidate Constructor que recibe en nombre del Candidate
     */
    public Candidate(String nameCandidate) {
        this.nameCandidate = nameCandidate;
    }

    /**
     * @return Retorna el nombre del candidate
     */
    public String getNameCandidate() {
        return nameCandidate;
    }
}
