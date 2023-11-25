import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/**
 * A program to add, remove, modify or print
 * student names and grades.
*/
public class Gradebook
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        Map<String, String> grades = new HashMap<>();

        boolean done = false;
        while(!done)
        {
            System.out.println("A)dd R)emove M)odify P)rint Q)uit");
            String input = in.next().toUpperCase();
            if (input.equals("Q"))
            {
                done = true;
            } else if (input.equals("A"))
            {
                System.out.println("Enter your name: ");
                String name = in.next();

                System.out.println("Enter your grade: ");
                String letter = in.next();

                grades.put(name, letter);

            } else if (input.equals("R"))
            {
                System.out.println("Enter the name to remove (first letter uppercase): " );
                String remname = in.next();
                grades.remove(remname);

            } else if (input.equals("M"))
            {
                System.out.println("Enter the name to modify (first letter uppercase): " );
                String modname = in.next();
                System.out.println("What is the new grade? ");
                String grade = in.next();

                grades.put(modname, grade);


            } else if (input.equalsIgnoreCase("P"))
            {
                Set<String> keys = grades.keySet();
                for (String key : keys)
                {
                    System.out.println(key + ": " + grades.get(key));
                    // will print out each key and its value
                }
            } else
            {
                done = true;
            }
        }
    }
}
