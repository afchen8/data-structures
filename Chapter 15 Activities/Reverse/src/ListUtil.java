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
        int listsize = strings.size();
       
        ListIterator<String> iterator1 = strings.listIterator();
        ListIterator<String> iterator2 = strings.listIterator();

        for (int j = 0; j < listsize; j++)
        {
            iterator2.next();       
        }

        for (int i = 0; i<(listsize/2); i++)
        {
            String item = iterator1.next();  
            String item2 = iterator2.previous();
            iterator1.set(item2);
            iterator2.set(item);
            System.out.println("hit");
        }
    }
}