package rocks.zipcode.ItsyBitsy;

import java.util.ArrayList;

public class ItsyBitsyGraph<T> {
    
/**
 * From this point forward we're going to start dealing with data structures
 * where the values of the data structure reference one another.
 *
 *    +- Data Structure ---------------------------------------+
 *    |  +- Item A ---------------+ +- Item B ---------------+ |
 *    |  | Value: 1               | | Value: 2               | |
 *    |  | Reference to: (Item B) | | Reference to: (Item A) | |
 *    |  +------------------------+ +------------------------+ |
 *    +--------------------------------------------------------+
 *
 * The values inside the data structure become their own mini data structures
 * in that they contain a value along with additional information including
 * references to other items within the overall data structure.
 *
 * You'll see what I mean by this in a second.
 */

/*** ===================================================================== ***\
 ** - GRAPHS -------------------------------------------------------------- **
 * ========================================================================= *
 *                                                                           *
 *   |                                 RICK ASTLEY'S NEVER GONNA...          *
 *   |       +-+                                                             *
 *   |  +-+  |-|                          [^] - GIVE YOU UP                  *
 *   |  |^|  |-|                 +-+      [-] - LET YOU DOWN                 *
 *   |  |^|  |-|       +-+       |*|      [/] - RUN AROUND AND DESERT YOU    *
 *   |  |^|  |-|  +-+  |\|       |*|      [\] - MAKE YOU CRY                 *
 *   |  |^|  |-|  |/|  |\|  +-+  |*|      [.] - SAY GOODBYE                  *
 *   |  |^|  |-|  |/|  |\|  |.|  |*|      [*] - TELL A LIE AND HURT YOU      *
 *   |  |^|  |-|  |/|  |\|  |.|  |*|                                         *
 *   +--------------------------------                                       *
 **                                                                         **
\*** ===================================================================== ***/

/**
 * Contrary to the ascii art above, a graph is not a visual chart of some sort.
 *
 * Instead imagine it like this:
 *
 *     A –→ B ←–––– C → D ↔ E
 *     ↑    ↕     ↙ ↑     ↘
 *     F –→ G → H ← I ––––→ J
 *          ↓     ↘ ↑
 *          K       L
 *
 * We have a bunch of "nodes" (A, B, C, D, ...) that are connected with lines.
 *
 * These nodes are going to look like this:
 *
 *     Node {
 *       value: ...,
 *       lines: [(Node), (Node), ...]
 *     }
 *
 * The entire graph will look like this:
 *
 *     Graph {
 *       nodes: [
 *         Node {...},
 *         Node {...},
 *         ...
 *       ]
 *     }
 */

    class Node {
        public T value;
        public ArrayList<Node> lines;

        Node(T v) {
            value = v;
            lines = new ArrayList<>();
        }
    }
    /**
     * We'll hold onto all of our nodes in a regular Java ArrayList. Not
     * because there is any particular order to the nodes but because we need a
     * way to store references to everything.
     */
    ArrayList<Node> nodes;
  
    public ItsyBitsyGraph() {
      this.nodes = new ArrayList<>();
    }
  
    /**
     * We can start to add values to our graph by creating nodes without any
     * lines.
     */
  
    public void addNode(T value) {
        this.nodes.add(new Node(value));
    }
  
    /**
     * Next we need to be able to lookup nodes in the graph. Most of the time
     * you'd have another data structure on top of a graph in order to make
     * searching faster.
     *
     * But for our case, we're simply going to search through all of the nodes to find
     * the one with the matching value. This is a slower option, but it works for
     * now.
     */
  
    public Node find(T value) {
      for (Node n : this.nodes) {
        if (n.value == value) { return n; }
      }
      return null;
    }
  
    /**
     * Next we can connect two nodes by making a "line" from one to the other.
     */
  
    public void addLine(T startValue, T endValue) {
      // Find the nodes for each value.
      Node startNode = this.find(startValue);
      Node endNode = this.find(endValue);
  
      // Freak out if we didn't find one or the other.
      if (startNode == null || endNode == null) {
        throw new Error("Both nodes need to exist");
      }
  
      // And add a reference to the endNode from the startNode.
      startNode.lines.add(endNode);
    }
  
  
}

/**
 * Finally you can use a graph like this:
 *
 *     Graph graph = new Graph();
 *     graph.addNode(1);
 *     graph.addNode(2);
 *     graph.addLine(1, 2);
 *     Node two = graph.find(1).lines[0];
 *
 * This might seem like a lot of work to do very little, but it's actually a
 * quite powerful pattern, especially for finding sanity in complex programs.
 *
 * They do this by optimizing for the connections between data rather than
 * operating on the data itself. Once you have one node in the graph, it's
 * extremely simple to find all the related items in the graph.
 *
 * Tons of things can be represented this way, users with friends, the 800
 * transitive dependencies in a node_modules folder, the internet itself is a
 * graph of webpages connected together by links.
 */
