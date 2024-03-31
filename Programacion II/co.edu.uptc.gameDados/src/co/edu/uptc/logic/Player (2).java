package co.edu.uptc.logic;

import java.util.Random;

public class Player {

    private String name;
    private int dado1;
    private int dado2;

    public Player(String name) {
        Random random = new Random();
        this.name = name;
        this.dado1 = random.nextInt(6 + 1) + 1;
        this.dado2 = random.nextInt(6 + 1) + 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDado1() {
        return dado1;
    }

    public void setDado1(int dado1) {
        this.dado1 = dado1;
    }

    public int getDado2() {
        return dado2;
    }

    public void setDado2(int dado2) {
        this.dado2 = dado2;
    }
    public int valDados(){
        return this.dado1 + this.dado2;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", dado1=" + dado1 +
                ", dado2=" + dado2 +
                '}';
    }
}
