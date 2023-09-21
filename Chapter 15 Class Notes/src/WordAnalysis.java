import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program checks which words in a file are not present in a dictionary.
*/
public class WordAnalysis
{
    public static void main(String[] args)
        throws FileNotFoundException
    {
        // read the dictionary and novel
        Set<String> dictionaryWords = readWords("Chapter 15 Class Notes/src/words"); // make sure to format files this way
        Set<String> novelWords = readWords("Chapter 15 Class Notes/src/throughTheLookingGlass.txt");

        // print all the words from the novel not in the dictionary
        for (String word: novelWords)
        {
            if(!dictionaryWords.contains(word))
            {
                System.out.println(word);
            }
        }

        // print the number of unique words in the novel
        System.out.println("There are " + novelWords.size() + " unique words in the novel.");

        // print the number of unique words with greater than three letters
        Iterator<String> iterator = novelWords.iterator();
        while (iterator.hasNext())
        {
            if (iterator.next().length() <= 3)
            {
                iterator.remove(); // apparently this doesn't produce a concurrent modification exception bc its using the iterator and not the list/set itself to add or remove?
            }
        }
        System.out.println("There are " + novelWords.size() + " words with more than three letters in the novel.");
    }

    /**
     * Reads all words from a file.
     *
     * @param filename the name of the file
     * @return a set with all lowercased words in the file. Here, a
     * word is a sequence of upper- and lowercase letters.
    */
    public static Set<String> readWords(String filename)
        throws FileNotFoundException
    {
        Set<String> words = new HashSet<>();
        // helpful thing to do w files - System.out.println(System.getProperty("user.dir"));
        Scanner in = new Scanner(new File(filename), "UTF-8");

        // use any characters other than letters as delimeters
        in.useDelimiter("[^a-zA-Z]+"); // any character = ^ symbol, we're not looking for a-z and we're looking for as many as possible
        // using things like spaces,  punctuation to separate words

        while(in.hasNext())
        {
            words.add(in.next().toLowerCase()); // adding words to our set (duplicates are ignored!)
        }

        return words;
    }
}
