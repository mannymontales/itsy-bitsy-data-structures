package itsybitsydatastructures.src.main.java.rocks.zipcode.ItsyBitsy;

import java.lang.reflect.Array;

public class ItsyBitsyHashTable<T> {

    /***
     * ===================================================================== ***\
     ** - HASH TABLES --------------------------------------------------------- **
     * ========================================================================= *
     ***/

    /**
     * A hash table is a data structure that's *unordered*. Instead we have "keys"
     * and "values" where we
     * computed an address in memory using the key.
     *
     * The basic idea is that we have keys that are "hashable" (which we'll get to
     * in a second) and can be used to add, access, and remove from memory very
     * efficiently.
     *
     * var hashTable = new HashTable();
     *
     * hashTable.set('myKey', 'myValue');
     * hashTable.get('myKey'); // >> 'myValue'
     */

    private T[] memory;

    private static final int initialCapacity = 1024;

    /**
     * Again we're going to use a plain JavaScript array to represent our memory.
     */

    public ItsyBitsyHashTable(T clazz) {
        this(clazz, initialCapacity);
    }

    public ItsyBitsyHashTable(T clazz, int capacity) {
        memory = (T[]) Array.newInstance(clazz.getClass(), capacity);
    }

    /**
     * In order to store key-value pairs in memory from our hash table we need a
     * way to take the key and turn it into an address. We do this through an
     * operation known as "hashing".
     *
     * Basically it takes a key and serializes it into a unique number for that
     * key.
     *
     * hashKey("abc") => 96354
     * hashKey("xyz") => 119193
     *
     * You have to be careful though, if you had a really big key you don't want
     * to match it to a memory address that does not exist.
     *
     * So the hashing algorithm needs to limit the size, which means that there
     * are a limited number of addresses for an unlimited number of values.
     *
     * The result is that you can end up with collisions. Places where two keys
     * get turned into the same address.
     *
     * Any real-world hash table implementation would have to deal with this,
     * however, we are just going to glaze over it and pretend that doesn't happen.
     */

    /**
     * Let's set up our "hashKey" function.
     *
     * Don't worry about understanding the logic of this function, just know that
     * it accepts a string and outputs a (mostly) unique address that we will use
     * in all of our other functions.
     */

    // public int hashKey(T key) {
    // int hash = 0;
    // for (int index = 0; index < key.length; index++) {
    // // Oh look– magic.
    // let code = key.charCodeAt(index);
    // hash = ((hash << 5) - hash) + code | 0;
    // }
    // return hash;
    // }

    public int hashKey(T keyobj) {
        int objhash = keyobj.hashCode();

        int rightBits = objhash & 0xffff; // Left-most 16 bits
        int leftBits = objhash & 0xffff0000; // Right-most 16 bits

        leftBits = objhash >>> 16; // Shift the left-most 16 bits to a 16-bit value

        return rightBits ^ leftBits; // XOR the left-most and right-most bits
    }

    /**
     * Next, let's define our "get" function so we have a way of accessing values
     * by their key.
     *
     * HashTable access is constant O(1) - "AWESOME!!"
     */

    public T get(T key) {
        // We start by turning our key into an address.
        int address = this.hashKey(key);
        // Then we simply return whatever is at that address.
        return this.memory[address];
    }

    /**
     * We also need a way of adding data before we access it, so we will create
     * a "set" function that inserts values.
     *
     * HashTable setting is constant O(1) - "AWESOME!!"
     */

    public void set(T key, T value) {
        // Again we start by turning the key into an address.
        int address = this.hashKey(key);
        // Then just set the value at that address.
        this.memory[address] = value;
    }

    /**
     * Finally we just need a way to remove items from our hash table.
     *
     * HashTable deletion is constant O(1) - "AWESOME!!"
     */

    public T remove(T key) {
        // As always, we hash the key to get an address.
        int address = this.hashKey(key);
        // Then, if it exists, we `delete` it.
        if (this.memory[address] != null) {
            T removed = this.memory[address];
            this.memory[address] = null;
            return removed;
        }
        return null;
    }

}
