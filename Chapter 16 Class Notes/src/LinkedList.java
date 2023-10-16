import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList
{
    /** first refers to the first node in this list
     * if the list is empty, first is null
     * each node has properties to DATA and NEXT - these are the variables we made in the static class
     */
    private Node first;

    /**
        Constructs an empty linked list.
    */
    public LinkedList()
    {
        this.first = null;
    }

    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */
    public Object getFirst()
    {
        if (this.first == null)
        {
            throw new NoSuchElementException();
        }
        return this.first.data;
        // return the data in the node, not the node itself
    }


    /**
        Removes the first element in the linked list.
        @return the removed element
    */
    public Object removeFirst()
    {
        if (this.first == null)
        {
            throw new NoSuchElementException();
        }
        Object element = this.first.data;
        this.first = this.first.next; // assigns it to the next node

        return element; // returns the data of the first element
    }



    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */
    public void addFirst(Object element)
    {
        if (this.first == null)
        {
            throw new NoSuchElementException();
        }
        
        Node newNode = new Node();
        // set two properties
        newNode.data = element;
        newNode.next = this.first;

        // still a bit confused on this
        this.first = newNode;
    }





    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */





    // Class Node
    // miller question - why is it static?
    // more of a design choice, it doesn't need to access anything in LinkedLists
    static class Node
    {
        public Object data;
        public Node next;
    }


    class LinkedListIterator implements ListIterator
    {
        private Node position; // what node the iterator is currently at
        private Node previous; // keep track of the previous node
        private boolean isAfterNext; // certain iterator rules

        /**
            Constructs an iterator that points to the front
            of the linked list.
        */
        public LinkedListIterator()
        {
            position = null;
            previous = null;
            isAfterNext = false;
        }

        /**
            Moves the iterator past the next element.
            @return the traversed element
        */
        public Object next()
        {
            previous = position; // moves forward
            isAfterNext = true; // yes there is something after next

            if (position == null) // when the iterator is FIRST CREATED
            {
                position = first;
            }
            else
            {
                position = position.next; // moves forward
            }
        }




        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */


        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */






        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */







        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */




    }//LinkedListIterator
}//LinkedList
