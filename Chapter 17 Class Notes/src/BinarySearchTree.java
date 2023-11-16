/**
    This class implements a binary search tree whose
    nodes hold objects that implement the Comparable
    interface.
*/
public class BinarySearchTree
{   
    private Node root;

    /**
        Constructs an empty tree.
    */
    public BinarySearchTree()
    {   
        this.root = null;
    }
    
    /**
        Inserts a new node into the tree.
        @param obj the object to insert
    */
    public void add(Comparable obj) 
    {   
        Node newNode = new Node();
        newNode.data = obj;
        newNode.left = null;
        newNode.right = null;

        if (this.root == null)
        {
            this.root = newNode; // newNode becomes the root
        }
        else
        {
            this.root.addNode(newNode);
            // will go down the tree starting from the root, trying to figure out where to place newNode
        }
    }

    /**
        Tries to find an object in the tree.
        @param obj the object to find
        @return true if the object is contained in the tree
    */
    public boolean find(Comparable obj)
    {
        Node current = this.root;
        // im tireD
        while (current != null)
        {
            int diff = obj.compareTo(current.data);
            if (diff == 0)
                return true; // found it
            else if (diff < 0)
            {
                current = current.left;
                else
                {
                    current = current.right;
                }
            }
        }
        
        return false;
    }
    
    /**
        Tries to remove an object from the tree. Does nothing
        if the object is not contained in the tree.
        @param obj the object to remove
    */
    public void remove(Comparable obj)
    {
        Node toBeRemoved = this.root;
        Node parent = null;
        boolean found = false;

        // try to find the object removed

        while (!found && toBeRemoved != null)
        {
            // if toBeRemoved is null that means reached child
            int diff = obj.compareTo(toBeRemoved.data);

            if (diff == 0)
                found = true; // the same thing
            else 
            {
                // always need to keep track of parent
                parent = toBeRemoved;
                if (diff < 0)
                    toBeRemoved = toBeRemoved.left;
                else   
                    toBeRemoved = toBeRemoved.right;
            }
        }
        if (!found)
                return;

        // case 1 and 2 - one child is null
        if (toBeRemoved.left == null || toBeRemoved.right == null)
        {
            Node newChild;

            if (toBeRemoved.left = null)
            {
                newChild = toBeRemoved.right;
            }
            else
                newChild = toBeRemoved.left;
            
            if (parent == null)
                this.root = newChild;
            
                else if (parent.left = toBeRemoved)
                {
                    parent.left = newChild;
                }
                else 
                    parent.right = newChild;

                return;
        }

        // Case 3 (node to be removed alr has two children)
        // so, find the least element of the right stree

        Node leastParent = toBeRemoved;
        Node least = toBeRemoved.right;

        while (least.left != null)
        {
            leastParent = least;
            least = least.left;
        }

        // OMG SO SLEEPY

        // move the data
        toBeRemoved.data = least.data;

        // unlink the least child
        if (leastParent == toBeRemoved)
            leastParent.right = least.right;
        else 
            leastParent.left = least.left;
    }
    
    /**
        Prints the contents of the tree in sorted order.
    */
    public void print()
    {   
        print(this.root);
        System.out.println();
    }   

    /**
        Prints a node and all of its descendants in sorted order.
        @param parent the root of the subtree to print
    */
    private static void print(Node parent)
    {   
        if (parent == null)
            return; // doesn't print anything

        // first printing the left subtree
        print(parent.left);

        // print the parent itself
        System.out.println(parent.data+"");

        // next printing the right subtree
        print(parent.right);
    }

    /**
        A node of a tree stores a data item and references
        to the left and right child nodes.
    */
    static class Node
    {   
        public Comparable data;
        // BINARY SEARCH TREE MUST BE MADE OF COMPARABLE OBJECTS
        // why is time so fast and so slow
        public Node left;
        public Node right;

        /**
            Inserts a new node as a descendant of this node.
            @param newNode the node to insert
        */
        public void addNode(Node newNode)
        {   
            int diff = newNode.data.compareTo(data);
            // if compareTo < 0, newNode is to the left
            // if compareTo > 0, newNode is to the right

            if (diff < 0)
            {
                if (left == null)
                    left = newNode; // easily setting left to newNode
                else
                    left.addNode(newNode); // recursively calls
            }

            else if (diff > 0)
            {
                if (right == null)
                    right = newNode;
                else
                    right.addNode(newNode);
            }
            
            // if diff = 0, then just don't add the value
        }
    }
}



