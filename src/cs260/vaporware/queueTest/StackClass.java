package cs260.vaporware.queueTest;

import java.util.Stack;

/**
 * Created by Code on 6/29/14.
 * The wording on this assignment was confusing, maybe it is supposed to extend QueueClass?
 * But they perform different kinds of functions, and StackClass works easily as it's own Class
 */
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
}