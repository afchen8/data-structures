import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "Chapter 15 Activities/HTMLChecker/src/TagSample1.html";
        Stack<String> openingTags = new Stack<>();
        
        try (Scanner in = new Scanner(new File(filename)))
        {
            in.useDelimiter(" "); // separates by spaces
            while (in.hasNext());
            {
                String value = in.Next();
                if (!value.contains("/")) // puts all the opening tags onto stack first
                {
                    openingTags.push(value);
                }
                else // now comparing the ending tags
                { // value would be the closing tag for the first tag on openingTags
                    if (value.substring(2).equals(openingTags.peek().substring(1))
                        openingTags.pop(); // removes top value so can keep comparing
                    else
                        System.out.println("Error in tags.");
                        break;
                        
                }
            }
        }
                


        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }

    }
}
