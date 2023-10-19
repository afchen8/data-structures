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
    public ListIterator listIterator()
    {
        return new LinkedListIterator();
    }





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
            if (!hasNext())
            {
                throw new NoSuchElementException(); // does not have next
            }

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

            return position.data; // the element
        }




        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */
        public boolean hasNext()
        {
            // makes sure there are actually elements in the list
            if (position == null) // nothing in front
            {
                return first != null;
            }
            return position.next != null; // checks if the next position is null
        }


        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */
        public void add(Object element)
        {
            // if iterator is at start of list
            if (position == null)
            {
                addFirst(element);
                position = first;
            }
            else
            {
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                // just setting the new node equal to the element
                position.next = newNode;
                position = newNode;
            }

            isAfterNext = false;
        }






        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */
        public void remove()
        {
            if (!isAfterNext)
            {
                throw new IllegalStateException(); // then can't remove
                // for ex can't remove right after adding (the boolean is set to false)
            }

            if (position == first)
            {
                removeFirst();
                position = null; // nothing there
            }
            else
            {
                previous.next = position.next; // connects the two elements on either side of the deletion
                position = previous; // the iterator will be at the previous node now
            }

            isAfterNext = false; // can't remove two things in a row without calling next
            // if called it again would throw illegal state exception
        }







        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */
        public void set(Object element)
        {
            if (!isAfterNext)
            {
                throw new IllegalStateException();
            }
            position.data = element; // changing the data of the element, setting it

            // set isn't removing or adding anything
            // the nodes aren't moving around so we don't need to set it to false
        }




    }//LinkedListIterator
}//LinkedList
