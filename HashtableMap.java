// --== CS400 Project One File Header ==--
// Name: Sreya Sarathy
// CSL Username: ssarathy
// Email: sarathy2@wisc.edu
// Lecture #: Prof Florian MWF 3:30 pm to 4:20 pm
// Notes to Grader: <any optional extra notes to your grader>

import java.util.NoSuchElementException;

/* The class creates a HashtableMap object, uses myHash (a new Hash Node),
/* to handle hash collisions by implementing open addressing with a simple linear probe
 */
public class HashtableMap<KeyType,ValueType> implements MapADT<KeyType, ValueType> {
    private int capacity; // Capacity of the HashtableMap (number of elements in the hashtable)
    private float loadFactor = 0.70f; // Load Factor as specified (70%)
    private int size = 0; // The number of entries in the map
    protected myHash[] tableRepresentation; // Single Dimensional Array Instance Field

    // Initializing the first constructor - HashtableMap -  with the default capacity
    public HashtableMap() {
        capacity = 8; // default capacity as provided in the specification
        tableRepresentation = new myHash[capacity];
    }

    // Initializing the second constructor - HashtableMap -  with parameter capacity
    public HashtableMap(int capacity) {
        this.capacity = capacity;
        tableRepresentation = new myHash[capacity];
    }

    // The following put method adds a new key value pair/ mapping to the collection
    // If the key is null or duplicate of one already stored then
    // @throws IllegalArgumentException - key is a duplicate of one already stored or key is null
    @Override
    public void put(KeyType key, ValueType value) throws IllegalArgumentException {
        // If the key is equal to null.
        if (key == null) {
            throw new IllegalArgumentException("Key is Null");
        }
        // If the key is the duplicate of one already stored.
        int index = hash(key);
        myHash element;
        while ((element = tableRepresentation[index]) != null) {
            if (element.getKey().equals(key))
                throw new IllegalArgumentException("Key is a duplicate of one already stored.");
            index = linearProbeFunction(index);
        }
        // To add a new key value pair to the collection.
        if (size >= capacity * loadFactor) {
            clear(); // to clear the old array so the new one can be instantiated
            rehash(capacity * 2);
        }
        tableRepresentation[index] = new myHash<>(key, value);
        size++;

    }

    // The following helper method is known as reshash. It helps dynamically grow the hashtable
    // by doubling its capacity and rehashing, whenever the load factor becomes greater than
    // or equal to 70%
    private void rehash(int newCapacity) {
        myHash[] oldTable = tableRepresentation;
        tableRepresentation = new myHash[newCapacity];
        capacity = newCapacity;
        size = 0;
        for (myHash<KeyType, ValueType> element : oldTable) {
            if (element != null) {
                put(element.getKey(), element.getValue());
            }
        }
    }

    // The following Helper method defines the linear probe function
    // which helps handle Hash Collisions.
    private int linearProbeFunction(int index){
        return (index +1) % capacity;
    }

    // The containsKey method checks whether a key maps to a value within this collection
    // @return true if get key equals to key
    // @return false if not the case
    @Override
    public boolean containsKey (KeyType key) {
        int index = hash(key);
        myHash element;
        while ((element = tableRepresentation[index]) != null) {
            if (element.getKey().equals(key))
                return true;
            index = linearProbeFunction(index);
        }
        return false;
    }

    // The Get method retrieve the specific value that a key maps to
    // @return element's value
    // @throws NoSuchElementException when key is not stored in the collection
    @Override
    public ValueType get (KeyType key) throws NoSuchElementException {
        int index = hash(key);
        myHash element;
        while((element = tableRepresentation[index]) != null) {
            if (element.getKey().equals(key))
                return (ValueType) element.getValue();
            index = linearProbeFunction(index);
        }
        throw new NoSuchElementException("Key is not stored in this collection");
    }

    // remove the mapping for a given key from this collection
    // @return oldElement's value
    // @throws NoSuchElementException when key is not stored in this collection
    @Override
    public ValueType remove (KeyType key) throws NoSuchElementException {
        int index = hash(key);
        myHash element;
        myHash oldElement;
        while((element = tableRepresentation[index]) != null) {
            if (element.getKey().equals(key)) {
                oldElement = element;
                tableRepresentation[index] = null;
                rehash(capacity);
                return (ValueType) oldElement.getValue();
            }
            index = linearProbeFunction(index);
        }
        throw new NoSuchElementException("Key is not stored in this collection");
    }

    // The private hash function helper method provides the formula
    private int hash (KeyType key){
        return Math.abs(key.hashCode()) % capacity;
    }

    // The private getLoadFactor helps calculate the load factor
    // Load Factor >= 70%
    private float getLoadFactor() {
        return (float) (size) / (float) (capacity);
    }
    // The clear method removes all key value pairs from this collection
    @Override
    public void clear () {
        tableRepresentation = new myHash[capacity];
        size = 0;
    }

    // The getSize method retrieves the number of keys stored within the collection.
    // @return size
    public int getSize () {
        return size;
    }

    // The getCapacity method retrieve this collection's capacity
    // capacity as in the size of its underlying array
    // @return capacity
    @Override
    public int getCapacity () {
        return capacity;
    }
}


