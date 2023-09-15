import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        ListIterator<String> iterator = strings.listIterator();
        int num = 2;

        while(iterator.hasNext())
        {
            String item = iterator.next();
            iterator.remove();
            strings.addFirst(item);
            System.out.println("hit");
            }
        }
}
}