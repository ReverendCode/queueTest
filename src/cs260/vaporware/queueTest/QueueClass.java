package cs260.vaporware.queueTest;

/**
 * Created by Code on 6/26/14.
 */
public class QueueClass {
    private static final int DEFAULT_ARRAY = 100;
    private int[] array;
    private int leftSide=0;//these should point to the next available spot in the array
    private int rightSide=0;
    private int arraySize = DEFAULT_ARRAY;
    private int count = 0;


    public QueueClass() {
        array = new int[DEFAULT_ARRAY];
    }
    public QueueClass(int n){
        array = new int[n];
        arraySize = n;
    }
    public void insertLeft(int insert) {
        if (leftSide<0) leftSide=arraySize-1;
        if (isFull()) arrayDouble();
        array[leftSide--] = insert;
        count++;

    }
    public void insertRight(int insert) {
        if (rightSide==arraySize-1) rightSide=-1;

        array[++rightSide] = insert;
        count++;
    }
    public int removeLeft() {
        if (isEmpty()) return 0;
        //leftSide++;
        if (++leftSide == arraySize) leftSide=0;
        count--;
        return array[leftSide];
    }
    public int removeRight() {
        if (rightSide < 0) rightSide = arraySize-1;
        if (isEmpty()) return 0;
        count--;
        return array[rightSide--];
    }
    public boolean isEmpty() {
        if (count==0) return true;
        return false;
    }
    public boolean isFull() {
        if (count==arraySize) return true;
        return false;
    }

    private void arrayDouble() {
        int newArraySize = arraySize * 2;
        int[] tempArray = new int[newArraySize];
        for (int i=0;i<arraySize;i++) {
            tempArray[i] = removeLeft();
        }
        count=arraySize;
        array = tempArray;
        leftSide=newArraySize-1;
        rightSide=arraySize-1;
        arraySize=newArraySize;

    }

    public String listQueue() {
    String accumList="";
    int addUp = 0;
        if (isEmpty()) return accumList;

        for (int i = leftSide+1; i != rightSide+1; i++) {//check edge cases
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
