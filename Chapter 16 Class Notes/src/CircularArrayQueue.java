import java.util.NoSuchElementException;

/**
    An implementation of a queue as a circular array.
*/
public class CircularArrayQueue
{
    private Object[] elements;
    private int head; // locations in the array are changing
    private int tail; // data is technically staying in place but just getting overwritten

    private int currentSize; 
    // keeping track of how many things are actually in the queue
    // size of the ARRAY is not necessarily size of the QUEUE

    /**
        Constructs an empty queue.
    */
    public CircularArrayQueue()
    {
        final int INITIAL_SIZE = 5; // constant
        this.elements = new Object[INITIAL_SIZE];
        this.head = 0;
        this.tail = 0;
        this.currentSize = 0;
    }


    /**
        Checks whether this queue is empty.
        @return true if this queue is empty
    */
    public boolean empty()
    {
        return (this.currentSize == 0); // how many elements are currently in the queue
    }


    /**
        Adds an element to the tail of this queue.
        @param newElement the element to add
    */
    public void add(Object element)
    {
        this.growIfNecessary();
        
        this.currentSize++;
        this.elements[this.tail] = element;
        this.tail++;
        this.tail %= this.elements.length; // if divisible by length (so at the end) then will be set to 0
    }


    /**
        Removes an element from the head of this queue.
        @return the removed element
    */
    public Object remove()
    {
        if (this.empty())
        {
            throw new NoSuchElementException();
        }

        this.currentSize--; // as you're removing the size decreases
        Object element = this.elements[this.head]; // removing from the head
        this.head = (this.head+1) % this.elements.length; // same steps as add above but in one line

        return element;
    }


    /**
        Grows the element array if the current size equals the capacity.
    */
    private void growIfNecessary()
    {
        if(this.currentSize == this.elements.length)
        {
            Object[] newElements = new Object[2 * this.elements.length];
            for(int i = 0; i < this.elements.length; i++)
            {
                newElements[i] = this.elements[(head + i) % this.elements.length];
            }
            this.elements = newElements;
            this.head = 0;
            this.tail = this.currentSize;
        }
    }




}//CircularArrayQueue
