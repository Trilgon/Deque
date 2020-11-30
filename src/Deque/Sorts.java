package Deque;

public class Sorts {
    public  Deque<Integer> sortD(Deque<Integer> deque){
        if (!deque.isEmpty() || deque.size() != 1){
            Deque<Integer> packOne = new Deque<Integer>();
            Deque<Integer> packTwo = new Deque<Integer>();
            Integer temp;
            for (int i = 0; i < deque.size(); i++){
                temp = deque.popLeft();
                if (temp <= deque.peekLeft()){
                    packOne.pushRight(temp);
                    packOne.pushRight(deque.popLeft());
                } else {
                    packOne.pushRight(temp);
                    packTwo.pushRight(deque.popLeft());
                }
            }
        }
        return deque;
    }
}
