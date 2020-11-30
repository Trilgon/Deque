package Main;

import Deque.Deque;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        System.out.println(deque.size());
        Integer test1 = 2;
        Integer test2 = 1;
        deque.pushRight(test1);
        deque.pushRight(test2);
        Object[] test = deque.toArray();
        for (Object var: test) {
            System.out.println(var);
        }
    }
}
