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
}
