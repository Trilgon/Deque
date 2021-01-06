package deque;

import java.util.NoSuchElementException;

public class Deque<Item> {
    //размер дека(по умолчанию = 0)
    private int size = 0;
    //указатель на крайний правый элемент(по умолчанию = null)
    private Node<Item> right = null;
    //указатель на крайний левый элемент(по умолчанию = null)
    private Node<Item> left = null;

    //добавление элемента в левый конец дека (в конец очереди)
    public void pushLeft(Item element) {
        //создание нового экземпляра класса узла
        Node<Item> anotherNode = new Node<>(element);
        //проверка не пуст ли дек
        if (size != 0) {
            anotherNode.next = left;
            left.previous = anotherNode;
        } else {
            //если дек пуст, то добавление нового узла в качестве крайнего правого узла
            right = anotherNode;
        }
        left = anotherNode;
        size++;
    }

    //добавление элемента в правый конец дека (в начало очереди)
    public void pushRight(Item element) {
        //создание нового экземпляра класса узла
        Node<Item> anotherNode = new Node<>(element);
        //проверка не пуст ли дек
        if (size != 0) {
            anotherNode.previous = right;
            right.next = anotherNode;
        } else {
            //если дек пуст, то добавление нового узла в качестве крайнего левого узла
            left = anotherNode;
        }
        right = anotherNode;
        size++;
    }

    //извлечение крайнего слева элемента дека (из конца очереди)
    public Item popLeft() {
        //проверка не пуст ли дек
        if (size != 0) {
            //запоминание значения левого узла
            final Item data = left.data;
            //запоминание узла перед левым узлом
            final Node<Item> next = left.next;
            //удаление значения левого узла
            left.data = null;
            //удаление ссылки на следующий элемент левого узла
            left.next = null;
            //обновление указателя на левого элемент
            left = next;
            //проверка не равен ли новый элемент null
            if (next != null)
                next.previous = null;
            else
                //если новый левый элемент оказался null, то правый элемент тоже становится тоже null
                right = null;
            //декремент размера дека
            size--;
            //возврат значения узла
            return data;
        }
        throw new NoSuchElementException();
    }

    //извлечение крайнего справа элемента дека (из начала очереди)
    public Item popRight() {
        //проверка не пуст ли дек
        if (size != 0) {
            //запоминание значения правого узла
            final Item data = right.data;
            //запоминание узла перед правым узлом
            final Node<Item> previous = right.previous;
            //удаление значения правого узла
            right.data = null;
            //удаление ссылки на следующий элемент правого узла
            right.next = null;
            //обновление указателя на правый элемент
            right = previous;
            //проверка не равен ли новый элемент null
            if (previous != null)
                previous.next = null;
            else
                //если новый правый элемент оказался null, то левый элемент тоже становится тоже null
                left = null;
            //декремент размера дека
            size--;
            //возврат значения узла
            return data;
        }
        //выброс исключения, если дек пуст
        throw new NoSuchElementException();
    }

    //просмотр крайнего слева элемента дека (из конца очереди)
    public Item peekLeft() {
        //проверка не пуст ли дек
        if (size != 0) {
            return left.data;
        }
        //выброс исключения, если дек пуст
        throw new NoSuchElementException();
    }

    //просмотр крайнего справа элемента дека (из начала очереди)
    public Item peekRight() {
        //проверка не пуст ли дек
        if (size != 0) {
            return right.data;
        }
        //выброс исключения, если дек пуст
        throw new NoSuchElementException();
    }

    //проверка не пуст ли дек
    public boolean isEmpty() {
        return size == 0;
    }

    //очистка дека от элеметов
    public void clear() {
        for (Node<Item> node = left; node != null; ) {
            Node<Item> next = node.next;
            node.data = null;
            node.previous = null;
            node.next = null;
            node = next;
            size--;
        }
        //удаление ссылки на левый элемент
        left = null;
        //удаление ссылки на правый элемент
        right = null;
    }
    //преобразование дека в массив
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (Node<Item> node = left; node != null; node = node.next)
            array[i++] = node.data;
        return array;
    }

    public int size() {
        return size;
    }
    //вложенный класс описывающий узел(элемент) дека
    private static class Node<Item> {
        //данные хращиеся в узле
        Item data;
        //ссылка(указатель) на предыдущий узел
        Node<Item> previous = null;
        //ссылка(указатель) на следующий узел
        Node<Item> next = null;
        //конструктор инициализрующий переменную "data"
        public Node(Item data) {
            this.data = data;
        }
    }
}
