package Logic;

import java.util.HashMap;
import java.util.Map;

public class FriendsNumbers {
    private int numberOne;
    private int numberTwo;


    public FriendsNumbers(int numberOne, int numberTwo) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }

    public void setNumberOne(int numberOne) {
        this.numberOne = numberOne;
    }
    public int getNumberOne() {
        return numberOne;
    }

    public void setNumberTwo(int numberTwo) {
        this.numberTwo = numberTwo;
    }

    public int getNumberTwo() {
        return numberTwo;
    }

    private int getSumDivizors(int number){
        int sumDivisor =  0;
        for (int i =  1; i <= number /  2; i++) {
            if (number % i ==  0) {
                sumDivisor += i;
            }
        }
        return sumDivisor;
    }

    public Map<Integer, Integer> getFriends(){
        Map<Integer, Integer> numFriend = new HashMap<>();
        for (int i = numberOne; i <= numberTwo; i++) {
            if (i == getSumDivizors(getSumDivizors(i)) && i!= getSumDivizors(i) ) {
                if (!numFriend.containsKey(i) && !numFriend.containsKey(getSumDivizors(i))) {
                    numFriend.put(i, getSumDivizors(i));
                }
            }
        }
        return numFriend;
    }
}