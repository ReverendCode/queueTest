package cs260.vaporware.queueTest;

import java.util.EmptyStackException;

public class Main {

    public static void main(String[] args) {
        //test driver for QueueClass
        //Note: this is copied liberally from the queueTest.cpp file, and adjusted for Java
	QueueClass initialTest = new QueueClass(10);
        System.out.print("\nAdd left, get left: ");
        initialTest.insertLeft(1);
        initialTest.insertLeft(2);
        initialTest.insertLeft(3);
        System.out.print("Should be '3, 2, 1: ");
        System.out.print(initialTest.removeLeft() + " ");
        System.out.print(initialTest.removeLeft()+" ");
        System.out.print(initialTest.removeLeft()+" ");
        try {
            System.out.print("\nGet left from empty queue: " + initialTest.removeLeft());
        }catch (EmptyStackException e){
            System.err.println("Stack returned: "+e.getMessage());
        }
        System.out.println("\nNext, add right, get right:");
        initialTest.insertRight(6);
        initialTest.insertRight(7);
        initialTest.insertRight(8);
        System.out.print("Returns 8 7 6: ");
        System.out.print(initialTest.removeRight() + " ");
        System.out.print(initialTest.removeRight()+" ");
        System.out.print(initialTest.removeRight()+" ");
        try{
        System.out.print("\nGet right from empty queue: "+initialTest.removeRight());
        }catch (EmptyStackException e){
            System.err.println("Stack returned: "+e.getMessage());
        }
        QueueClass lifo = new QueueClass(9);
        System.out.println("\nNow add left, get right to show LIFO:");
        lifo.insertLeft(1);
        lifo.insertLeft(2);
        lifo.insertLeft(3);
        System.out.print(lifo.removeRight() + " ");
        System.out.print(lifo.removeRight() + " ");
        System.out.print(lifo.removeRight()+" ");

        System.out.print("\nAnd add right, get left:\n");
        lifo.insertRight(6);
        lifo.insertRight(7);
        lifo.insertRight(8);
        System.out.print(lifo.removeLeft() + " ");
        System.out.print(lifo.removeLeft()+" ");
        System.out.print(lifo.removeLeft()+" ");

        System.out.print("\nShow proper array expansion:\n");
        QueueClass expand = new QueueClass(2);
        expand.insertLeft(1);
        expand.insertLeft(2);
        expand.insertLeft(3);
        System.out.print("\nCreate an array with size 2, add 3 elements: "+expand.listQueue());

        //Here the assignment doesn't match up with the given driver.
        //this is coded to test the function outlined in the assignment
        System.out.print("\n\nFinish QueueClass test with list function\nShould show 34 33 43 47:\n");
        initialTest.insertLeft(33);
        initialTest.insertRight(43);
        initialTest.insertLeft(34);
        initialTest.insertRight(47);
        System.out.print(initialTest.listQueue());

        //test StackClass
        StackClass stack = new StackClass(1);
        stack.push(6);
        stack.push(7);
        System.out.print("\nTesting stack:\n");
        System.out.print("Peek at the top, should be 7: "+stack.peek());
        System.out.print("\nPop it off, still 7: "+stack.pop());
        System.out.print("\nPop again, should be 6: "+stack.pop());
        try {
            System.out.print("\nTest the now empty stack: "+stack.pop());
        }catch (EmptyStackException e){
            System.err.println("Stack returned: "+e.getMessage());
        }

        //test Priority Queue
        PriorityQ testDouble = new PriorityQ(2);
        testDouble.insertInt(1);
        testDouble.insertInt(2);//the array is actually doubled here
        testDouble.insertInt(3);
        System.out.print("\nCreate 2 element array, add 3 elements:\n"+testDouble.showArray());
        for (int i=1;i<20;i++) testDouble.insertInt(i);
        System.out.print("\nAdd some more numbers to the array: "+ testDouble.showArray());
        String outputString = "";
        for (int j=0;j<4;j++) outputString += testDouble.getLargest()+" ";
        System.out.print("\nNow pull the 4 largest integers: "+outputString);
        PriorityQ emptyArray = new PriorityQ();
        try {
            System.out.print("\nTest empty Queue, should return 0: "+emptyArray.getLargest());
        }catch (EmptyStackException e){
            System.err.println("Stack returned: "+e.getMessage());
        }
    }
}
