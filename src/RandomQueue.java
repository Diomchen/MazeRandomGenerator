import java.util.ArrayList;
import java.util.LinkedList;

public class RandomQueue<E> {
//    private ArrayList<E> randomQueue;
    private LinkedList<E> randomQueue;

    public RandomQueue(){
        randomQueue = new LinkedList<>();
    }

    //初代随机队列---添加函数
//    public void add(E e){
//        randomQueue.add(e);
//    }

    //次代随机队列---添加函数
    public void add(E e){
        if(Math.random() <0.5){
            randomQueue.addFirst(e);
        }
        else{
            randomQueue.addLast(e);
        }
    }

    public int size(){
        return randomQueue.size();
    }

    public boolean isEmpty(){
        return randomQueue.isEmpty();
    }

    //初代随机队列---删除函数
//    public E remove(){
//        if(randomQueue.size() == 0){
//            throw new IllegalArgumentException("randomQueue don't have element!");
//        }
//
//        int randomIndex = (int)(Math.random()*randomQueue.size());
//        E element = randomQueue.get(randomIndex);
//        randomQueue.set(randomIndex,randomQueue.get(randomQueue.size()-1));
//
//        return element;
//    }

    //次代随机队列---删除函数
    public E remove(){
        if(randomQueue.size() == 0){
            throw new IllegalArgumentException("randomQueue don't have element!");
        }
        E element;
        if(Math.random()<0.5){
            element = randomQueue.removeFirst();
        }
        else{
            element = randomQueue.removeLast();
        }
        return element;
    }
}
