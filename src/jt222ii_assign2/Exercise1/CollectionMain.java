package jt222ii_assign2.Exercise1;

import java.util.Iterator;

/**
 * Created by jonastornfors on 2016-09-13.
 */
public class CollectionMain {
    public static void main (String args[])
    {
        ArrayIntList list = new ArrayIntList();
        System.out.println("ArrayIntList:");
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(6);
        list.add(6);
        System.out.println(list.toString());

        System.out.println("list.addAt(2, 1)");
        list.addAt(2, 1);
        System.out.println(list.toString());
        System.out.println("list.addAt(5, 4)");
        list.addAt(5, 4);
        System.out.println(list.toString());

        System.out.println("list.remove(6)");
        list.remove(6);
        System.out.println(list.toString());
        System.out.println("list.indexOf(123) should return -1: "+ list.indexOf(123));
        System.out.println("list.indexOf(5) should return 4: "+ list.indexOf(5));

        System.out.println();
        System.out.println("ArrayIntStack: ");
        ArrayIntStack stack = new ArrayIntStack();
        System.out.println("stack.push(3)");
        stack.push(3);
        System.out.println("stack.push(2)");
        stack.push(2);
        System.out.println("stack.push(1)");
        stack.push(1);
        System.out.println("Stack: "+stack.toString());
        System.out.println("Removed: "+stack.pop());
        System.out.println("Removed: "+stack.pop());
        System.out.println("Adding 4");
        stack.push(4);
        System.out.println("Stack: "+stack.toString());
    }
}
