package Main;

import Deque.Deque;
import Deque.Sorts;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        Integer test1 = 2;
        Integer test2 = 1;
        Integer test3 = 9;
        deque.pushRight(test1);
        deque.pushRight(test2);
        deque.pushRight(test3);
        Sorts.sortD(deque);
        for (int i = 3; i > 0; i--){
            System.out.print(deque.popLeft());
            System.out.print(' ');
        }
    }
}
