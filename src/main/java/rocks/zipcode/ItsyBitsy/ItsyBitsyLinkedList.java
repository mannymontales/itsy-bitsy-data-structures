package rocks.zipcode.ItsyBitsy;

/**
* Next we're going to see how a graph-like structure can help optimize ordered
* lists of data.
*
* Linked lists are a very common data structure that is often used to
* implement other data structures because of its ability to efficiently add
* items to the start, middle, and end.
*
* The basic idea of a linked list is similar to a graph. You have nodes that
* point to other nodes. They look sorta like this:
*
*     1 -> 2 -> 3 -> 4 -> 5
*
* Visualizing them as a JSON-like structure looks like this:
*
*     {
*       value: 1,
*       next: {
*         value: 2,
*         next: {
*           value: 3,
*           next: {...}
*         }
*       }
*     }
*/

public class ItsyBitsyLinkedList<T> {

    // this is the container we use to encapsulate value of type T
    class Node {
        public T value;
        public Node next;

        Node(T v) {
            value = v;
            next = null;
        }
    }

 /**
  * Unlike a graph, a linked list has a single node that starts off the entire
  * chain. This is known as the "head" of the linked list.
  *
  * We're also going to track the length.
  */
    Node head;
    int length = 0;

  ItsyBitsyLinkedList() {
   this.head = null;
   this.length = 0;
    }

 /**
  * First we need a way to retrieve a value in a given position.
  *
  * This works differently than normal lists as we can't just jump to the
  * correct position. Instead, we need to move through the individual nodes.
  */

 public Node get(int position) {
   // Throw an error if position is greater than the length of the LinkedList
   if (position >= this.length) {
     throw new Error("Position outside of list range");
   }

   // Start with the head of the list.
   Node current = this.head;

   // Slide through all of the items using node.next until we reach the
   // specified position.
   for (int index = 0; index < position; index++) {
     current = current.next;
   }

   // Return the node we found.
   return current;
 }

 /**
  * Next we need a way to add nodes to the specified position.
  *
  * We're going for a generic add method that accepts a value and a position.
  */

 public void add(T value, int position) {
   // First create a node to hold our value.
   Node node = new Node(value);

   // We need to have a special case for nodes being inserted at the head.
   // We'll set the "next" field to the current head and then replace it with
   // our new node.
   if (position == 0) {
     node.next = this.head;
     this.head = node;

     // If we're adding a node in any other position we need to splice it in
     // between the current node and the previous node.
   } else {
     // First, find the previous node and the current node.
     Node prev = this.get(position - 1);
     Node current = prev.next;
     // Then insert the new node in between them by setting its "next" field
     // to the current node and updating the previous node's "next" field to
     // the new one.
     node.next = current;
     prev.next = node;
   }

   // Finally just increment the length.
   this.length++;
 }

 /**
  * The last method we need is a remove method. We're just going to look up a
  * node by its position and splice it out of the chain.
  */

 public T remove(int position) {
   // We should not be able to remove from an empty list
   if (this.head == null) {
     throw new Error("Removing from empty list");
   }

   Node removed = null;
   // If we're removing the first node we simply need to set the head to the
   // next node in the chain
   if (position == 0) {
    removed = this.head;
    this.head = this.head.next;

     // For any other position, we need to look up the previous node and set it
     // to the node after the current position.
   } else {
     Node prev = this.get(position - 1);
     removed = prev.next;
     prev.next = prev.next.next;
   }

   // Then we just decrement the length.
   this.length--;
   return removed.value;
 }

/**
* ============================================================================
* ,.-'`'-.,.-'`'-.,.-'`'-.,.-'`'-.,.-'`'-.,.-'`'-.,.-'`'-.,.-'`'-.,.-'`'-.,.-'
* ============================================================================
*/

}
