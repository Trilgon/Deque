package Main;

import Deque.Deque;

public class Main {
    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();
        System.out.println(deque.size());
        String test1 = "test1";
        String test2 = "test2";
        deque.pushRight(test1);
        deque.pushRight(test2);
        System.out.println(deque.size());
        System.out.println(deque.isEmpty());
        System.out.println(deque.peekLeft());
        System.out.println(deque.peekRight());
        deque.clear();
        System.out.println(deque.size());
        System.out.println(deque.isEmpty());
    }
}
