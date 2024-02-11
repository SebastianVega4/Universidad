package View;

import Logic.FriendsNumbers;
import Logic.ThreadFriends;

public class Main {
    public static void main(String[] args) {
        Long timeStart = System.currentTimeMillis();
        /*FriendsNumbers friendsNumbers = new FriendsNumbers(1, 60000);
        Map<Integer, Integer> friends = friendsNumbers.getFriends();
        for (Map.Entry<Integer, Integer> entry : friends.entrySet()) {
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }*/

        FriendsNumbers fn1 = new FriendsNumbers(10,2000);
        FriendsNumbers fn2 = new FriendsNumbers(10,2000);
        FriendsNumbers fn3 = new FriendsNumbers(10,2000);

        ThreadFriends th1 = new ThreadFriends(fn1);
        ThreadFriends th2 = new ThreadFriends(fn2);
        ThreadFriends th3 = new ThreadFriends(fn3);

        Thread thr1 = new Thread(th1);
        Thread thr2 = new Thread(th2);
        Thread thr3 = new Thread(th3);

        thr1.start();
        thr2.start();
        thr3.start();

        try {
            thr1.join();
            thr2.join();
            thr3.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(System.currentTimeMillis()-timeStart);
    }
}