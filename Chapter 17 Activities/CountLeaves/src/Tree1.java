import java.util.List;
import java.util.ArrayList;
/**
    A tree in which each node has an arbitrary number of children.
    Modify the Tree class from Section 16.1 (below) to add
    a method that counts the number of leaves in the tree.
*/
public class Tree1
{
    private Node root;

    class Node
    {
        public Object data;
        public List<Node> children;

        /**
            Computes the size of the subtree whose root is this node.
            @return the number of nodes in the subtree
        */
        public int size()
        {
            int sum = 0;
            for (Node child : children) { sum = sum + child.size(); }
            return 1 + sum;
        }
    }

    /**
        Constructs an empty tree.
    */
    public Tree1()
    {
        root = null;
    }

    /**
        Constructs a tree with one node and no children.
        @param rootData the data for the root
    */
    public Tree1(Object rootData)
    {
        root = new Node();
        root.data = rootData;
        root.children = new ArrayList<>();
    }

    /**
        Adds a subtree as the last child of the root.
    */
    public void addSubtree(Tree1 subtree)
    {
        root.children.add(subtree.root);
    }

    /**
        Computes the size of this tree.
        @return the number of nodes in the tree
    */
    public int size()
    {
        if (root == null) { return 0; }
        else { return root.size(); }
    }

    public int countLeaves()
    {
        return countLeavesHelper(root);
    }

    public static int countLeavesHelper(Node node)
    {
        int count = 0;
        if (node.children.size() == 0)
        {
            count++;
        }
        else
        {
            for (Node child : node.children)
            {
                count += countLeavesHelper(child);
            }
        }
        return count;
    }

    
}
