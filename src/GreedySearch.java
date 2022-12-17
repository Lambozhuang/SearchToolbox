import java.util.*;

/**
 * This is where you implement the Greedy Search algorithm.
 * It currently has a Depth-First search implementation.
 * 
 * @author 
 */
public class GreedySearch extends SearchMethod
{
    /**
     * Initializes a new Greedy search.
     */
    public GreedySearch()
    {
        //Must be called to reset all variables and
        //data structures needed for the search.
        init();
    }
    
    /**
     * Finds a path from start to end node.
     * 
     * @return True when the search is ready, false if not ready.
     */
    public boolean step()
    {
        //Visit (expand) the best node in the open list
        Node n = getNextToVisit();
        map.setLinkAsVisited(n);
        //Move the visited node to the closed list
        closed.add(n);
        //Increase the visited counter
        noVisited++;

        //Check if we are finished = current node equals end node
        if (n.equals(end))
        {
            //Goal node reached!
            path = reconstructPath(n);
            return true;
        }
        else
        {
            //Not finished yet. Keep iterating.

            //Find the nodes that are connected to the current node n
            Vector<Node> connected = getConnectedNodes(n);
            for (Node c:connected)
            {
                //If a node is not in the open or closed lists, add it
                //to the open list
                if (!isInOpenOrClosed(c))
                {
                    //Set the parent reference
                    c.parent = n;
                    //Add first in the open list (LIFO)
                    open.add(0, c);
                }
            }
        }
       
        return false;
    }
    
    /**
     * Returns the best node in the open list. This is where you implement
     * logic for finding the best node in the open list.
     * 
     * @return The best node in the open list
     */
    private Node getNextToVisit()
    {
        //Pick first node...
        Node bestNode = open.elementAt(0);
        
        return bestNode;
    }
}
