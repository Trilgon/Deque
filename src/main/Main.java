package main;

import deque.Deque;
import deque.Sorts;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите целые числа для дека (введите символ 's' в конце, чтобы закончить ввод)");
        Deque<Integer> deque = new Deque<>();
        Scanner in = new Scanner(System.in);
        String next;
        while (in.hasNext()) {
            next = in.next();
            if (next.equals("s")) {
                break;
            }
            deque.pushRight(Integer.parseInt(next));
        }
        Sorts.sortD(deque);
        System.out.println("Отсортированный дек:");
        for (int i = deque.size(); i > 0; i--){
            System.out.print(deque.popLeft() + " ");
        }
    }
}
