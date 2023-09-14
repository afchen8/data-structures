import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        // creating a LinkedList
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("lizzy mcalpine");
        staff.addLast("jeremy zucker");
        staff.addLast("noah kahan");
        staff.addLast("chelsea cutler");

        // The list is currently: LJNC

        /*
         * the listIterator method creates a new list iterator
         * positioned at the head of the list
         */
        ListIterator<String> iterator = staff.listIterator(); // |LJNC
        // class "L"                          method "l"

        /* advances the iterator to the next element in the linked list */
        iterator.next(); // L|JNC

        /* returns the element the iterator is passing */
        String name = iterator.next(); // LJ|NC
        System.out.println(name); // printing the element PASSED
        System.out.println("expected: jeremy zucker");

        /* add method inserts element at iterator position
         * iterator positioned after added element
         */
        iterator.add("olivia rodrigo"); // LJO|NC
        iterator.add("taylor swift"); // LJOT|NC

        /* remove method removes element returned by last call
         * to next or previous - don' specify
         * can only be called once after calling next or previous
         * CAN'T be called after calling add
         */
        iterator.next(); // LJOTN|C
        iterator.remove(); // will remove last called element aka noah kahan

        System.out.println(staff);
        System.out.println("Expected: lizzy mcalpine, jeremy zucker, olivia rodrigo, taylor swift, chelsea cutler");




    }
}
