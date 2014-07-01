package cs260.vaporware.queueTest;

/**
 * Created by Code on 6/30/14.
 */
public class PriorityQ {
    private int[] priority;
    private int index = 0;
    private int arraySize;
    private static final int SIZE=100;
    public PriorityQ() {
        priority = new int[SIZE];
    }
    public PriorityQ(int n) {
        arraySize=n;
        priority = new int[arraySize];
    }
    public boolean isEmpty() {
        if (index==0) return true;
        return false;
    }
    public boolean isFull() {
        if (index==arraySize) return true;
        return false;
    }

    public void insertInt(int newInt) {//O(1)
        if (isFull()) arrayDouble();
        priority[index++] = newInt;
    }
    public int getLargest() {//O(n)
        if (isEmpty()) return 0;//change to throw exception
        int bigId=0;
        for (int i=1;i<index;i++) {
            if (priority[i]>priority[bigId]) bigId=i;
        }
        int biggest = priority[bigId];
        unsortDelete(bigId);
        return biggest;
    }
    private void arrayDouble() {
        int newArraySize = arraySize * 2;
        int[] tempArray = new int[newArraySize];
        for (int i=0;i<arraySize;i++) {
            tempArray[i] = priority[i];
        }
        priority = tempArray;
        index=arraySize;
        arraySize=newArraySize;

    }
    private void unsortDelete(int position) {
        priority[position]=priority[--index];
    }
    public String showArray() {//debug method
        String output="";
        for (int i =0;i<index;i++) {
          output += priority[i]+" ";
        }
        return output;
    }
}
