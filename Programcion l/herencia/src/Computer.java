import java.awt.*;

public class Computer implements ActionsFigure{
    private String issn;
    private String tradeMark;
    private double value;

    public Computer(String issn, String tradeMark, double value) {
        this.issn = issn;
        this.tradeMark = tradeMark;
        this.value = value;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "issn='" + issn + '\'' +
                ", tradeMark='" + tradeMark + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public void drawFigure(Graphics graphics) {
        System.out.println("Se debe pintar el Computador");
    }

    @Override
    public double calcArea() {
        return 0.0;
    }
}
