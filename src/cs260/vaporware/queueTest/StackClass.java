package cs260.vaporware.queueTest;

import java.util.Stack;

/**
 * Created by Code on 6/29/14.
 */
public class StackClass {
    private QueueClass theStack;
    public StackClass() {
        theStack = new QueueClass();
    }
    public StackClass(int n) {//this is a little unneeded, with the auto expanding code
        theStack = new QueueClass(n);
    }
    public void push(int newInt) {
        theStack.insertLeft(newInt);
    }
    public int pop() {
        return theStack.removeLeft();
    }
    public int peek() {
        int temp = theStack.removeLeft();
        theStack.insertLeft(temp);
        return temp;
    }
}


//change this to an inherited class
    //composition will be easier
    /*
public class StackClass {
    private int[] array;
    private int location = 0;
    private int arraySize;
    private static final int SIZE=100;

    public StackClass() {
        array=new int[SIZE];
        arraySize=SIZE;
    }
    public StackClass(int room) {
        array = new int[room];
        arraySize = room;
    }

    public void push(int number) {
        if (location == arraySize) arrayDouble();
        array[location++]=number;

    }

    public int pop() {
        if (location==0) return 0;//or throw exception
        return array[--location];
    }

    public int peek() {
        if (location==0) return 0;//exception
        return array[location-1];
    }

    private void arrayDouble() {
        int newArraySize = arraySize * 2;
        int[] tempArray = new int[newArraySize];
        for (int i = arraySize; i >0; i--) {
            tempArray[i] = pop();
        }
        array=tempArray;
    }
}*/