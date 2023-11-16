import java.util.List;
import java.util.ArrayList;

/**
    A tree in which each node has an arbitrary number of children.
*/
public class Tree
{
    
    static class Node
    {
        public Object data;
        public List<Node> children;

        /**
            Computes the size of the subtree whose root is this node.
            @return the number of nodes in the subtree
        */
        // SPECIFIC TO THIS NODE
        public int size()
        {
            int sum = 1; // there's one node right now - the root
            for (Node child: this.children)
            {
                sum += child.size();
            }
            return sum;
        }
    }

    private Node root;

    /**
        Constructs a tree with one node and no children.
        @param rootData the data for the root
    */
    public Tree(Object rootData)
    {
        this.root = new Node();
        this.root.data = rootData; // the object parameter
        this.root.children = new ArrayList<>(); 
        // array list should be fine for most cases
    }

    /**
        Adds a subtree as the last child of the root.
    */
    public void addSubtree(Tree subtree)
    {
        this.root.children.add(subtree.root);
        // everything in the subtree.root is going to be added
        // as the last element of the children ArrayList
    }

    /**
        Computes the size of this tree.
        @return the number of nodes in the tree
    */
    public int size() 
    {
        return (this.root.size());
        // there's alr a size method within node
        // if you do with the root node, returns size of entire tree
    }


    // Additional methods will be added in later sections.

    /*
     * a visitor whose "visit" method is called for each visited node
     * during a tree traversal
     * --> can calculate sums and averages quickly
     */
    public interface Visitor
    {
        // the visit method is called for each visited node
        // @param data is the data of the node being visited
        void visit(Object data);
        // interface so not actually implementing anything

        // can get the visitor to do different things w traversing

        /*
         * traverse this tree in preorder
         * @param v: the visitor to be invoked at each node
         */
        public void preorder (Visitor v)
        {
            Tree preorder(this.root, v); // takes the v parameter
        }

        /*
         * helper method
         * traverse the tree with a given root in preorder
         * @param n: the root of the tree to traverse
         * @param v: the visitor
         */
        private static void preorder(Node n, Visitor v)
        {
            if (n==null)
                return; // done
            
                v.visit(n.data); // calling another method in this interface
                // we don't know what visit is doing yet, haven't implemented

                for(Node child: n.children)
                {
                    Tree.preorder(child, v); // recursive
                }
        }



    }
}
