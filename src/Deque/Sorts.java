package Deque;

public class Sorts {
    public static Deque<Integer> sortD(Deque<Integer> deque) {
        if (!deque.isEmpty() || deque.size() != 1) {
            Deque<Object> packOne = new Deque<>();
            Deque<Object> packTwo = new Deque<>();
            Integer temp;
            boolean isPackOne = true;
            boolean wasSort = true;
            packOne.pushRight(deque.peekLeft());
            for (int i = deque.size(); i > 1; i--) {
                temp = deque.popLeft();
                if (temp <= deque.peekLeft() && isPackOne) {
                    packOne.pushRight(deque.peekLeft());
                } else if (temp > deque.peekLeft() && isPackOne) {
                    packTwo.pushRight(deque.peekLeft());
                    isPackOne = false;
                    wasSort = false;
                    packOne.pushRight(';');
                } else if (temp <= deque.peekLeft() && !isPackOne) {
                    packTwo.pushRight(deque.peekLeft());
                } else if (temp > deque.peekLeft() && !isPackOne) {
                    packOne.pushRight(deque.peekLeft());
                    isPackOne = true;
                    packTwo.pushRight(';');
                }
            }
            deque.popLeft();
            if (!wasSort) {
                if (!packOne.peekRight().equals(';')) {
                    packOne.pushRight(';');
                } else {
                    packTwo.pushRight(';');
                }
            }
                while (!packOne.isEmpty() && !packTwo.isEmpty()) {
                    if (!packOne.peekLeft().equals(';') && !packTwo.peekLeft().equals(';')) {
                        if ((Integer) packOne.peekLeft() <= (Integer) packTwo.peekLeft()) {
                            deque.pushRight((Integer) packOne.popLeft());
                        } else {
                            deque.pushRight((Integer) packTwo.popLeft());
                        }
                    } else if (packOne.peekLeft().equals(';') && !packTwo.peekLeft().equals(';')) {
                        deque.pushRight((Integer) packTwo.popLeft());
                    } else if (packTwo.peekLeft().equals(';') && !packOne.peekLeft().equals(';')) {
                        deque.pushRight((Integer) packOne.popLeft());
                    } else if (packOne.peekLeft().equals(';') && packTwo.peekLeft().equals(';')){
                        packOne.popLeft();
                        packTwo.popLeft();
                    }
                }
                if (packOne.isEmpty() && !packTwo.isEmpty()){
                    while (!packTwo.isEmpty()){
                        if (!packTwo.peekLeft().equals(';')){
                            deque.pushRight((Integer) packTwo.popLeft());
                        } else if(packTwo.peekLeft().equals(';')){
                            packTwo.popLeft();
                        }
                    }
                } else if (!packOne.isEmpty() && packTwo.isEmpty()){
                    while (!packOne.isEmpty()){
                        if (!packOne.peekLeft().equals(';')){
                            deque.pushRight((Integer) packOne.popLeft());
                        } else if(packOne.peekLeft().equals(';')){
                            packOne.popLeft();
                        }
                    }
                }
                if (!wasSort)
                deque = sortD(deque);
        }
        return deque;
    }
}
