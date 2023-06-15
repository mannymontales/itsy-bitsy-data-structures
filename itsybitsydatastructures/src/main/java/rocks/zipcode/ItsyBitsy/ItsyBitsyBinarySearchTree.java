package itsybitsydatastructures.src.main.java.rocks.zipcode.ItsyBitsy;

import java.util.ArrayList;

public class ItsyBitsyBinarySearchTree<T extends Comparable<T>> {
    
  /*** ===================================================================== ***\
   ** - BINARY SEARCH TREES ------------------------------------------------- **
   * ========================================================================= *
  /*** ===================================================================== ***/
  
  /**
   * Binary search trees are a fairly common form of tree for their ability to
   * efficiently access, search, insert, and delete values all while keeping them
   * in a sorted order.
   *
   * Imagine taking a sequence of numbers:
   *
   *     1  2  3  4  5  6  7
   *
   * And turning it into a tree starting from the center.
   *
   *              4
   *           /     \
   *        2           6
   *      /   \       /   \
   *     1     3     5     7
   *    -^--^--^--^--^--^--^-
   *     1  2  3  4  5  6  7
   *
   * This is how a binary tree works. Each node can have two children:
   *
   *     - Left: Less than parent node's value.
   *     - Right: Greater than parent node's value.
   *
   * > Note: In order to make this work all values must be unique in the tree.
   *
   * This makes the traversal to find a value very efficient. Say we're trying to
   * find the number 5 in our tree:
   *
   *             (4)         <--- 5 > 4, so move right.
   *           /     \
   *        2         (6)    <--- 5 < 6, so move left.
   *      /   \       /   \
   *     1     3    (5)    7 <--- We've reached 5!
   *
   * Notice how we only had to do 3 checks to reach the number 5. If we were to
   * expand this tree to 1000 items. We'd go:
   *
   *   500 -> 250 -> 125 -> 62 -> 31 -> 15 -> 7 -> 3 -> 4 -> 5
   *
   * Only 10 checks for 1000 items!
   *
   * The other important thing about binary search trees is that they are similar
   * to linked lists in the sense that you only need to update the immediately
   * surrounding items when adding or removing a value.
   */
  
  

   class Node {
    public T value;
    public Node left;
    public Node right;

    Node(T v) {
        value = v;
        left = null;
        right= null;
    }
    }

    private Node root;


    /**
     * Same as the previous Tree, we need to have a "root" of the binary search
     * tree.
     */
  
     ItsyBitsyBinarySearchTree() {
      this.root = null;
    }
  
    /**
     * In order to test if the value exists in the tree, we first need to search
     * through the tree.
     */
  
    public Boolean contains(T value) {
      // We start at the root.
      Node current = this.root;
  
      // We're going to keep running as long as we have another node to visit.
      // If we reach a `left` or `right` that is `null` then this loop ends.
      while (current != null) {
  
        // If the value is greater than the current.value we move to the right
        if (value.compareTo(current.value) > 0) {
          current = current.right;
  
          // If the value is less than the current.value we move to the left.
        } else if (value.compareTo(current.value) < 0) {
          current = current.left;
  
          // Otherwise we must be equal values and we return true.
        } else {
          return true;
        }
      }
  
      // If we haven't matched anything then we return false.
      return false;
    }
  
    /**
     * In order to add items to this tree we are going to do the same traversal
     * as before, bouncing between left and right nodes depending on them being
     * less than or greater than the value we're adding.
     *
     * However, this time when we reach a `left` or `right` that is `null` we're
     * going to add a new node in that position.
     */
  
    public void add(T value) {
      // First let's setup our node.
      Node node = new Node(value);
  
      // Special case for when there isn't any root node and we just need to add
      // one.
      if (this.root == null) {
        this.root = node;
        return;
      }
  
      // We start at the root.
      Node current = this.root;
  
      // We're going to loop until we've either added our item or discovered it
      // already exists in the tree.
      while (true) {
  
        // If the value is greater than the current.value we move to the right.
        if (value.compareTo(current.value) > 0) {
  
          // If `right` does not exist, set it to our node, and stop traversing.
          if (current.right != null) {
            current.right = node;
            break;
          }
  
          // Otherwise just move on to the right node.
          current = current.right;
  
          // If the value is less than the current.value we move to the left.
        } else if (value.compareTo(current.value) > 0) {
  
          // If `left` does not exist, set it to our node, and stop traversing.
          if (current.left != null) {
            current.left = node;
            break;
          }
  
          // Otherwise just move on to the left node.
          current = current.left;
  
          // If the number isn't less than or greater, then it must be the same and
          // we don't do anything.
        } else {
          break;
        }
      }
    }
}
  
  
    
  /**
   * I know that was probably a bit dense, but hopefully it gave you a good
   * amount of knowledge. If you enjoyed it, would you mind giving the repo a
   * star and follow me on twitter (@thejameskyle)?
   *
   * You can also check out my other code walkthrough, "The Super Tiny Compiler"
   *       here ------> https://github.com/thejameskyle/the-super-tiny-compiler
   */

