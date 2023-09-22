import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * A program that implements the sieve of Eratosthenes.
 * Implement the sieve of Eratosthenes: a method for computing prime numbers known to the ancient Greeks. 
 * This method will compute all prime numbers up to n. Choose an n. 
 * First insert all numbers from 2 to n into a set. 
 * Then erase all multiples of 2 (except 2); that is, 4, 6, 8, 10, 12, . . . . Erase all multiples of 3; that is, 6, 9, 12, 15, .... Go up to n. 
 * Then print the set. Implement your solution in the Sieve class. 
 * Test with at least the values: 50, 100, 150.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Sieve.runner();

    }
        
    public static void runner()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();

        Set <Integer> numbers = new HashSet<>();
        
        // all numbers from 2 to n in a set
        for (Integer i = 2; i <= n; i++)
        {
            numbers.add(i);
        }

        Iterator <Integer> iterator = numbers.iterator();

        // erases all non prime numbers
        while (iterator.hasNext())
        {
            int j = iterator.next();
            for (int k = 2; k<n; k++)
            {
                if (j % k == 0 && j != k)
                {
                    iterator.remove();
                    break;
                }
            }
        }

        System.out.println(numbers);
    }
}