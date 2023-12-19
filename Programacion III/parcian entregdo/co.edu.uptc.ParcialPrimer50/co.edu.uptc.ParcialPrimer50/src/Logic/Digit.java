package Logic;

public class Digit {
    private int digit;
    private boolean visited;

    public Digit (int digit) {
        this.digit = digit;
    }

    public int getDigit() {
        return digit;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }
}