package rocks.zipcode.ItsyBitsy;

public class ItsyBitsyQueue<T> extends ItsyBitsyList<T> {
    
/**
 * Next, we're going to build a queue which is complementary to stacks. The
 * difference is that this time you remove items from the start of the queue
 * rather than the end. Removing the oldest items rather than the most recent.
 *
 * Again, because this limits the amount of functionality, there are many
 * different ways of implementing it. A good way might be to use a linked list
 * which we will see later.
 */


    /**
     * Our queue is using an ItsyBitsyList rather than memory.
     */
  
    public ItsyBitsyQueue(T clazz) {
        super(clazz);
    }
  
    /**
     * Similar to stacks we're going to define two functions for adding and
     * removing items from the queue. The first is "enqueue".
     *
     * This will push values to the end of the list.
     */
  
    public void enqueue(T value) {
        this.push(value);
    }
  
    /**
     * Next is "dequeue", instead of removing the item from the end of the list,
     * we're going to remove it from the start.
     */
  
    public T dequeue() {
      // Don't do anything if we don't have any items.
      if (this.length == 0) return null;
  
      // Shift the first item off the start of the list and return the value.
      this.length--;
      return (T) this.shift();
    }
  
    /**
     * Same as stacks we're going to define a "peek" function for getting the next
     * value without removing it from the queue.
     */
  
     public T peek() {
      return (T) this.memory[0];
    }
  
}

/**
 * The important thing to note here is that because we used a list to back our
 * queue it inherits the performance of "shift" which is linear O(N) "OKAY."
 *
 * Later we'll see linked lists that will allow us to implement a much faster
 * Queue.
 */
