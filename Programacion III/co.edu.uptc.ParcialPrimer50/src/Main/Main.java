package Main;

import Logic.Digit;
import Logic.ListCircled;

public class Main {
    public static void main(String[] args) {
        ListCircled list = new ListCircled();
        list.addNodeFirst( new Digit(2));
        list.addNodeFirst( new Digit(3));
        list.addNodeLast( new Digit(6));
        list.addNodeLast( new Digit(1));
        list.addNodeFirst( new Digit(5));
        list.addNodeFirst( new Digit(9));
        list.addNodeLast( new Digit(9));

        System.out.println(list.findNode(9).getInfo().getDigit());
        System.out.println(list.getLinked().get(0).getDigit());

        list.jumping(list.findNode(5),1).getInfo().getDigit();
        System.out.println(list.jumping(list.findNode(9),4).getInfo().getDigit());
        list.jumping(list.findNode(3),10).getInfo().getDigit();
        list.jumping(list.findNode(2),3).getInfo().getDigit();
        list.jumping(list.findNode(6),7).getInfo().getDigit();


        System.out.println(list.getLinked().size() +" fsfas");
    }
}