package main;

import deque.Deque;
import deque.Sorts;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printSortedDeque(Sorts.sortD(keyboardIn()));
    }
    //метод для создания дека с клавиатуры
    public static Deque<Integer> keyboardIn(){
        System.out.println("Введите целые числа для дека (введите символ 's' в конце, чтобы закончить ввод)");
        Deque<Integer> deque = new Deque<>();
        //создание объекта класса Scanner для считывания консольного ввода
        Scanner in = new Scanner(System.in);
        //объявление переменной для ввода
        String next;
        //создание цикла выполняющегося, пока есть ввод
        while (in.hasNext()) {
            //ввод нового значения
            next = in.next();
            //сравнение введённого значения с символом прекращения ввода
            if (next.equals("s")) {
                //прекращение ввода, в случае появление символа преращения
                break;
            }
            //добавление введённого значение преобразованного в Integer
            deque.pushRight(Integer.parseInt(next));
        }
        //возврат введённого дека
        return deque;
    }
    //метод для создания дека заполненного случайными числами
    public static Deque<Integer> randomIn(int elementsQuantity){
        //создание экземпляра класса Random для создания случайных чисел
        Random rnd = new Random();
        //создание дека
        Deque<Integer> deque = new Deque<>();
        //цикл по количеству элементов
        for (int i = 0; i < elementsQuantity; i++){
            //заполнение дека случайными числами в интервале: [0 ; 101)
            deque.pushRight(rnd.nextInt(101));
        }
        //возврат дека заполненного случайными числами
        return deque;
    }
    //метод выводящий на эран консоли отсортированный дек
    public static void printSortedDeque(Deque<Integer> deque){
        System.out.println("Отсортированный дек:");
        for (int i = deque.size(); i > 0; i--){
            System.out.print(deque.popLeft() + " ");
        }
    }
}
