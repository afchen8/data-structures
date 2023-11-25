/**
 *   A program that demonstrates the LinkedList class
 */
public class ListDemo
{
    public static void main(String[] args)
    {
        LinkedList students = new LinkedList();
        students.addFirst("Preston");
        students.addFirst("Emma");
        students.addFirst("William");
        students.addFirst("Addison");

        System.out.println(students);

        // creating iterator to go through list
        ListIterator iterator = students.listIterator();
        // ListIterator is the class, listIterator is the method

        iterator.next();
        iterator.add("Hyder");
        iterator.next();
        iterator.remove();
        
    }
}
