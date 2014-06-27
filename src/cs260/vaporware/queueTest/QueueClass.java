package cs260.vaporware.queueTest;

/**
 * Created by Code on 6/26/14.
 */
public class QueueClass {
    private static final int DEFAULT_ARRAY = 100;
    private int[] array;
    private int leftSide=0;
    private int rightSide=0;
    private int lastItem = DEFAULT_ARRAY;


    public QueueClass() {
        array = new int[DEFAULT_ARRAY];
    }
    public QueueClass(int n){
        array = new int[n];
        lastItem = n;
    }
    public boolean insertLeft(int insert) {
        return true;
    }
    public boolean insertRight(int insert) {
        return true;
    }
    public int removeLeft() {
        return 0;
    }
    public int removeRight() {
        return 0;
    }
    public boolean isEmpty() {
        return false;
    }
    public boolean isFull() {
        return false;
    }


}
