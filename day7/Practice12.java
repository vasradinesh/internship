//Program to iterate through all elements in a linked list starting at the specified position.

import java.util.*;

public class Practice12 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        ListIterator<String> it = list.listIterator(2);

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
