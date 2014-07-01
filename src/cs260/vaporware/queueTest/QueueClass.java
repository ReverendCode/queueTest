package cs260.vaporware.queueTest;

/**
 * Created by Code on 6/26/14.
 */
public class QueueClass {
    private static final int DEFAULT_ARRAY = 100;
    private int[] array;
    private int leftSide=0;//these should point to the next available spot in the array
    private int rightSide=1;
    private int arraySize = DEFAULT_ARRAY;


    public QueueClass() {
        array = new int[DEFAULT_ARRAY];
    }
    public QueueClass(int n){
        array = new int[n];
        arraySize = n;
    }
    public void insertLeft(int insert) {
        if (isFull()) arrayDouble();
        array[leftSide--] = insert;
        if (leftSide<0) leftSide=arraySize-1;


    }
    public void insertRight(int insert) {
        if (isFull()) arrayDouble();
        array[rightSide++] = insert;
        if (rightSide == arraySize) rightSide=0;

    }
    public int removeLeft() {
        if (isEmpty()) return 0;
        //leftSide++;
        if (++leftSide == arraySize) leftSide=0;
        return array[leftSide];
    }
    public int removeRight() {
        if (isEmpty()) return 0;
        if (--rightSide < 0) rightSide = arraySize-1;
        return array[rightSide];
    }
    public boolean isEmpty() {
        if (leftSide+1==rightSide) return true;//if they are back to back, there is no space between them
        return false;
    }
    public boolean isFull() {
        if (rightSide == leftSide) return true;//when the right passes the left, the array is full
        return false;
    }

    private void arrayDouble() {
        int newArraySize = arraySize * 2;
        int[] tempArray = new int[newArraySize];
        for (int i=1;i<arraySize;i++) {
            tempArray[i] = removeLeft();
        }
        array = tempArray;
        leftSide=0;
        rightSide=arraySize;
        arraySize=newArraySize;

    }

    public String listQueue() {
    String accumList="";
    int addUp = 0;
        if (isEmpty()) return accumList;

        for (int i = leftSide+1; i != rightSide; i++) {
            if (i==arraySize) i=0;//wraparound code
            accumList += array[i] + " ";
            if (++addUp==10) {
                accumList += "\n";
                addUp =0;
            }

        }

    return accumList;
    }

}
