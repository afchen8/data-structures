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
        System.out.println("Expected: [lizzy mcalpine, jeremy zucker, olivia rodrigo, taylor swift, chelsea cutler]");

        /* set method updates element returned by last call to next or previous */
        iterator.previous(); // LJOT|C
        iterator.set("henry moodie"); // LJOT|M

        /* hasNext method returns true if set has another element
         * used in condition of a while loop
         */
        iterator = staff.listIterator(); // retsets iterator to |LJOTM
        while(iterator.hasNext());
        {
            String = iterator.next();
            if(n.equals("jeremy zucker"))
            { .. 
                iterator.remove();
            }
        }

        /* enhanced for loops work with linked lists */
        for(String n: staff)
        {
            System.out.println(n + " " );
        }
        System.out.println("Expected: [lizzy mcalpine olivia rodrigo taylor swift henry moodie]");

        /* ConcurrentModificationException
         * can't modify a linked list when using an iterator
         * unless you use the iterator to do so
         * but this just removes stuff
         */
        iterator = staff.listIterator(); // resets
        while(iterator.hasNext())
        {
            String n = iterator.next();
            if (n.equals("henry moodie")
                // staff.remove("Diana");
        }


        // 09.15.23


        /*an enhanced for lop AUTOMATICALLY creates an iterator (that's why we don't need to make one) 
         * but this also creates a concurrent modification exception
        */
        for(String n: staff)
            if(n.equals("henry moodie"))
            {
                staff.add("mina okabe")
            }




    }
}
