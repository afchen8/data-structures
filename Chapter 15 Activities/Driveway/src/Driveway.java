import java.util.Stack;
import java.util.Scanner;

/**
 * Class for simulating a driveway and a street, using stacks
 * of cars with license plate numbers as representation.
*/
public class Driveway
{
    /**
      * Stack representing the cars in the driveway.
    */
    private Stack<Integer> driveway;
    /**
      * Stack representing the cars in the street.
    */
    private Stack<Integer> street;

    /**
      * Constructor.
    */
    public Driveway()
    {
        // Complete the constructor
        driveway = new Stack<>;
        street = new Stack<>;


    }

    /**
      * Add the given license plate to the driveway.
      *
      * @param licensePlate number of license plate.
    */
    public void add(int licensePlate)
    {
        driveway.push(licensePlate);


    }

    /**
      * Remove the given license plate from the driveway.
      *
      * @param licensePlate number of license plate.
    */
    public void remove(int licensePlate)
    {
        // puts all the cars from the driveway to the street until reaches license plate
        while (street.push(driveway.pop()) != licensePlate)
            { // that's why there's nothing in here
            }
             street.pop(); // removes the license plate car

        // returns the rest of the cars to the driveway
        while (!street.isEmpty()) // while street still has stuff
            {
            driveway.push(street.pop());
            }

    }

    /**
      * Prints the driveway and street details to the screen.
    */
    public void print()
    {
        System.out.println("In Driveway, starting at first in (one license plate per line):");
        for (int l : driveway) // for loop goes through all ints
            {
                System.out.println(l);
            }

        System.out.println("In Street, starting at first in (one license plate per line):");
        for (int s : street)
            {
                System.out.println(s);
            }

    }
}
