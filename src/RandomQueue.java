import java.util.ArrayList;

public class RandomQueue<E> {
    private ArrayList<E> randomQueue;

    public RandomQueue(){
        randomQueue = new ArrayList<>();
    }

    public void add(E e){
        randomQueue.add(e);
    }
    public int size(){
        return randomQueue.size();
    }

    public boolean isEmpty(){
        return randomQueue.isEmpty();
    }

    public E remove(){
        if(randomQueue.size() == 0){
            throw new IllegalArgumentException("randomQueue don't have element!");
        }

        int randomIndex = (int)(Math.random()*randomQueue.size());
        E element = randomQueue.get(randomIndex);
        randomQueue.set(randomIndex,randomQueue.get(randomQueue.size()-1));

        return element;
    }

}
