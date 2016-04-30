
/**
 * Заполнить массив ArrayList значениями от 0 до 10.000.000.
 * Выполнять это должны 10 потоков.
 * Значения должны идти от 0 до 10.000.000;
 */

import java.util.ArrayList;
import java.util.List;

public class ClassThread{
    public static void main(String[] args) throws InterruptedException{
        List<MyThread> threads = new ArrayList<>();

        for(int i=0 ; i<10;i++){
            threads.add(new MyThread(i));
        }
        for (MyThread my : threads){
            my.start();

        }

        for (MyThread j : threads){
            try{
                j.join();
            }catch(InterruptedException e){
                System.out.println("mamamia");
            }
        }
        List<Integer> list  = new ArrayList<>();
        for(MyThread p : threads){
            list.addAll(Array.getINTEGERS());
        }

        System.out.println("size--"+list.size());

    }
}

class Array{
    public static final ArrayList<Integer> INTEGERS  = new ArrayList<>();

    public static ArrayList<Integer> getINTEGERS() {
        return INTEGERS;
    }
}

class Counter {
    public static final int counter=1000000;

}

class MyThread extends Thread{

    private int position;
    MyThread(int start){
        this.position = start;
    }
    @Override
    public void run() {
        for (int i = position *Counter.counter; i<Counter.counter; i++){
            Array.INTEGERS.add(i);
        }
        // System.out.println(Thread.currentThread().getName() + " " + Counter.counter);
    }
}
