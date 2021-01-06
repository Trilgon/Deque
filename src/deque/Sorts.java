package deque;

public class Sorts {
    //метод сортирующий дек естественным двухпутевым слиянием
    public static Deque<Integer> sortD(Deque<Integer> deque) {
        //проверка не пуст ли дек и не находится ли в нём только один элемент
        if (!deque.isEmpty() && deque.size() != 1) {
            //создание первого вспомогательного дека объектов
            Deque<Object> packOne = new Deque<>();
            //создание второго вспомогательного дека объектов
            Deque<Object> packTwo = new Deque<>();
            //объявление переменной для запоминания значения извлечённого элемента дека
            Integer temp;
            //метка позволяющая понять какой сейчас используется вспомогательный дек (далее "пак", для краткости)
            boolean isPackOne = true;
            //метка поволяющая определить когда дек отсортирован
            boolean wasSort = true;
            //добавление в packOne такого же элемента, как и в основном деке
            packOne.pushRight(deque.peekLeft());
            for (int i = deque.size(); i > 1; i--) {
                //присвоение переменной temp левого извлечённого значения дека
                temp = deque.popLeft();
                //сравнение переменной temp с новым значением дека, а также проверка какой сейчас используется пак
                if (temp <= deque.peekLeft() && isPackOne) {
                    //в первый пак добавляется значение дека (без его извлечения, так как оно происходит в начале цикла)
                    packOne.pushRight(deque.peekLeft());
                } else if (temp > deque.peekLeft() && isPackOne) {
                    //если сейчас используется первый пак, но temp больше нового значения дека,то
                    //добавляем это значение во второй пак
                    packTwo.pushRight(deque.peekLeft());
                    //на следующий итерации мы уже будем использовать PackTwo
                    isPackOne = false;
                    //дек не был отсортирован
                    wasSort = false;
                    //добавление разделителя серий в первый пак
                    packOne.pushRight(';');
                } else if (temp <= deque.peekLeft() && !isPackOne) {
                    //если сейчас используется второй пак и temp меньше нового значения дека, то
                    //добавляем новое значение во второй пак
                    packTwo.pushRight(deque.peekLeft());
                } else if (temp > deque.peekLeft() && !isPackOne) {
                    //если сейчас используется второй пак и temp больше нового значения дека, то
                    //добавляем новое значение в первый пак
                    packOne.pushRight(deque.peekLeft());
                    //на следующий итерации мы уже будем использовать PackOne
                    isPackOne = true;
                    //добавление разделителя серий во второй пак
                    packTwo.pushRight(';');
                }
            }
            //извлекаем элемент из основного дека (это нужно сделать,
            //так как извлечение обычно происходит в начале новый итерациии, но цикл уже кончился)
            deque.popLeft();
            //проверка не был ли отсортирован дек
            if (!wasSort) {
                //проверка наличия раздилителя серий в конце первого пака
                if (!packOne.peekRight().equals(';')) {
                    //добавление, если его нет
                    packOne.pushRight(';');
                } else {
                    //если разделитель есть в первом паке, то значит его нет во втором,
                    //поэому добавляем его во второй пак
                    packTwo.pushRight(';');
                }
            }
                //цикл ввыполняющийся, пока оба пака не будут пусты
                while (!packOne.isEmpty() && !packTwo.isEmpty()) {
                    //проверка есть ли сейчас в одном из паков разделитель серий
                    //ПРИМЕЧАНИЕ: здесь и даллее под "сейчас" имеется в виду "в следующим элементе"
                    if (!packOne.peekLeft().equals(';') && !packTwo.peekLeft().equals(';')) {
                        //если нет, то проверка какой из элементов меньше
                        if ((Integer) packOne.peekLeft() <= (Integer) packTwo.peekLeft()) {
                            //если первый меньше, то первый извлекается в дек
                            deque.pushRight((Integer) packOne.popLeft());
                        } else {
                            //если второй меньше, то второй извлекается в дек
                            deque.pushRight((Integer) packTwo.popLeft());
                        }
                    } else if (packOne.peekLeft().equals(';') && !packTwo.peekLeft().equals(';')) {
                        //если разделитель находится в первом паке, то
                        //извлекаем в дек элемент из второго пака
                        deque.pushRight((Integer) packTwo.popLeft());
                    } else if (packTwo.peekLeft().equals(';') && !packOne.peekLeft().equals(';')) {
                        //если разделитель находится во втором паке, то
                        //извлекаем в дек элемент из первого пака
                        deque.pushRight((Integer) packOne.popLeft());
                    } else if (packOne.peekLeft().equals(';') && packTwo.peekLeft().equals(';')){
                        //если разделитель находится в обоих паках, то
                        //извлекаем элемент из первого пака
                        packOne.popLeft();
                        //и ивзлекаем элемент из второго пака
                        packTwo.popLeft();
                    }
                }
                //проверка пуст ли первый пак и не пуст ли второй
                if (packOne.isEmpty() && !packTwo.isEmpty()){
                    //если да, то создаём цикл выполняющийся, пока второй пак не станет пустым
                    while (!packTwo.isEmpty()){
                        //проверка не находится ли сейчас во втором паке разделитель серий
                        if (!packTwo.peekLeft().equals(';')){
                            //если нет, то добавляем элемент из второго пака в дек
                            deque.pushRight((Integer) packTwo.popLeft());
                        } else if(packTwo.peekLeft().equals(';')){
                            //если во втором паке сейчас есть разделитель, то
                            //извлекаем элемент из второго пака
                            packTwo.popLeft();
                        }
                    }
                } else if (!packOne.isEmpty() && packTwo.isEmpty()){
                    //если первый пак не пуст, а второй пуст, то
                    //создаём цикл  выполняющийся, пока первый пак не будет пуст
                    while (!packOne.isEmpty()){
                        //проверка не находится ли сейчас во первом паке разделитель серий
                        if (!packOne.peekLeft().equals(';')){
                            //если нет, то добавляем элемент из первого пака в дек
                            deque.pushRight((Integer) packOne.popLeft());
                        } else if(packOne.peekLeft().equals(';')){
                            //если во первом паке сейчас есть разделитель, то
                            //извлекаем элемент из первого пака
                            packOne.popLeft();
                        }
                    }
                }
                //проверка не был ли отсортирован дек
                //if (!wasSort) сомневаюсь, что это нужно
                //рекурсивный возов метода сортировки и присвоение деку результата этого вызова
                deque = sortD(deque);
        }
        //возврат отсортированного дека
        return deque;
    }
}
