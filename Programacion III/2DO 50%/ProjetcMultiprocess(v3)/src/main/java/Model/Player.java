package Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Player {
    private String name;
    private String country;
    private String region;
    private int numberGamePlayer;
    private int numberGames;
    private int pointsToComplete;
    private Dice diceOne;
    private Dice diceTwo;
    private int waitingTime;
    private boolean flag = true;
    private String currentTime;
    private int points;
    private int coins;
    long startTime;
    long endTime;
    long time;

    public Player(String name, String country, String region, int numberGames, int pointsToComplete) {
        this.name = name;
        this.country = country;
        this.region = region;
        this.numberGames = numberGames;
        this.pointsToComplete = pointsToComplete;
    }

    public void rollDice(){
        diceOne = new Dice((int) (Math.random() * 6) + 1);
        diceTwo = new Dice((int) (Math.random() * 6) + 1);
    }

    public void calculateHour(){
        TimeZone timeZone = TimeZone.getTimeZone(region);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(timeZone);
        currentTime = sdf.format(new Date());
    }

    public void calculateWaitingTime(){
        waitingTime = (int) (Math.random() * 5000) + 1000;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setNumberGames(int numberGames) {
        this.numberGames = numberGames;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public int getNumberGames() {
        return numberGames;
    }

    public int getPointsToComplete() {
        return pointsToComplete;
    }

    public Dice getDiceOne() {
        return diceOne;
    }

    public Dice getDiceTwo() {
        return diceTwo;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public int getPoints() {
        return points;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void time() {
         time = endTime - startTime;
    }

    public long getTime() {
        return time;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getNumberGamePlayer() {
        return numberGamePlayer;
    }

    public void setNumberGamePlayer(int numberGamePlayer) {
        this.numberGamePlayer = numberGamePlayer;
    }

    public void uploadGame() {
        flag = true;
        points = 0;
        diceOne.setNumber(0);
        diceTwo.setNumber(0);
    }
}
