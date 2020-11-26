package Deque;

import java.util.NoSuchElementException;

public class Deque<Item> {
    long size = 0; //размер дека
    Node<Item> right = null;
    Node<Item> left = null;

    //добавление элемента в левый конец дека (в конец очереди)
    public void pushLeft(Item element) {
        Node<Item> anotherNode = new Node<>(element);
        if (size != 0) {
            anotherNode.next = left;
            left.previous = anotherNode;
        } else {
            right = anotherNode;
        }
        left = anotherNode;
        size++;
    }

    //добавление элемента в правый конец дека (в начало очереди)
    public void pushRight(Item element) {
        Node<Item> anotherNode = new Node<>(element);
        if (size != 0) {
            anotherNode.previous = right;
            right.next = anotherNode;
        } else {
            left = anotherNode;
        }
        right = anotherNode;
        size++;
    }

    //извлечение крайнего слева элемента дека (из конца очереди)
    public Item popLeft() {
        if (size != 0) {
            final Item data = left.data;
            final Node<Item> next = left.next;
            left.data = null;
            left.next = null;
            left = next;
            if (next != null)
                next.previous = null;
            else
                right = null;
            size--;
            return data;
        }
        throw new NoSuchElementException();
    }

    //извленчение крайнего справа элемента дека (из начала очереди)
    public Item popRight() {
        if (size != 0) {
            final Item data = right.data;
            final Node<Item> next = right.next;
            right.data = null;
            right.next = null;
            right = next;
            if (next != null)
                next.previous = null;
            else
                left = null;
            size--;
            return data;
        }
        throw new NoSuchElementException();
    }

    //просмотр крайнего слева элемента дека (из конца очереди)
    public Item peekLeft() {
        if (size != 0) {
            return left.data;
        }
        throw new NoSuchElementException();
    }

    //просмотр крайнего справа элемента дека (из начала очереди)
    public Item peekRight() {
        if (size != 0) {
            return  right.data;
        }
        throw new NoSuchElementException();
    }

    //проверка не пуст ли дек
    public boolean isEmpty() {
        return size == 0;
    }

    //очистка дека от элеметов
    public void clear() {
        for (Node<Item> node = left; node != null;){
            Node<Item> next = node.next;
            node.data = null;
            node.previous = null;
            node.next = null;
            node = next;
            size--;
        }
        left = null;
        right = null;
    }

    public long size() {
        return size;
    }

    private class Node<Item> {
        Item data;
        Node<Item> previous = null;
        Node<Item> next = null;

        public Node(Item data) {
            this.data = data;
        }
    }
}
