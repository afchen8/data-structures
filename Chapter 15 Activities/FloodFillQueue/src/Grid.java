. . .
public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    Stack<Pair> fillStack = new Stack<>();

    // set the values = 0
    for (int a = 0; a < SIZE; a++)
    {
        for (int b = 0; b < SIZE: b++)
            pixels[a][b] = 0;
    }

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        // starting with given row and column
        int num = 1;
        fillStack.push(new Pair (row, column));

        int rows, cols;

        while(fillStack.size() != 0) // while still has things in it
            {
                Pair starting = fillStack.pop(); // always takes the top item

                if (pixels[rows][cols] == 0) // isn't filled
                {
                    // updates the value of pixels with whatever the count currently is
                    pixels[rows][cols] = num;
                    // increments the count
                    num++;
                    
                    // need to add neighboring cells to top of stack
                    // not the top row, so can subtract 1 to the rows to go above (north)
                    
                    if (starting.getRow() > 0)
                        fillStack.push(new Pair(rows-1, cols));

                    // not the left most column, so can subtract 1 from the cols to go west
                    
                    if (starting.getCol() > 0)
                        fillStack.push(new Pair(rows, cols-1));
                    
                    // not the bottom row, so can add 1 to the rows to go below (south)
                    
                    if (starting.getRow() < SIZE -1)
                        fillStack.push(new Pair(rows+1, cols));

                    // not the right most column, so can add 1 to the cols to go east
                    
                    if (starting.getCol() < SIZE - 1)
                        fillStack.push(new Pair(rows, cols-1));

                }
            }
        
        System.out.println(toString());
        
    }

    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%3d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
