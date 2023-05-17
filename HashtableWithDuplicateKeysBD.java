// --== CS400 Project One File Header ==--
// Name: Sreya Sarathy
// CSL Username: ssarathy
// Email: sarathy2@wisc.edu
// Lecture #: Prof Florian MWF 3:30 pm to 4:20 pm
// Notes to Grader: <any optional extra notes to your grader>

import java.util.NoSuchElementException;

public class HashtableWithDuplicateKeysBD implements HashtableWithDuplicateKeysInterface{
    private int capacity = 0; // Initializing the parameter capacity
    private int size = 0; // Initializing the parameter size
    private int numberOfValues = 0; // Initializing the parameter numberOfValues

    // Initializing the constructor HashtableWithDuplicateKeysBD with parameter capacity
    public HashtableWithDuplicateKeysBD(int capacity){
        this.capacity = capacity;
        myHash[] tableRepresentation = new myHash[capacity];
    }

    // Initializing the constructor HashtableWithDuplicateKeysBD with default parameter
    public HashtableWithDuplicateKeysBD(){
        this.capacity = capacity;
        myHash[] tableRepresentation = new myHash[capacity];
    }
    public void putOne(Object key, Object value) {
    }

    public void removeOne(Object key, Object value) {
    }

    public int getNumberOfValues() {
        return numberOfValues;
    }


    public void put(Object key, Object value) throws IllegalArgumentException {
    }

    public boolean containsKey(Object key) {
        return false;
    }

    public Object get(Object key) throws NoSuchElementException {
        return null;
    }

    public Object remove(Object key) throws NoSuchElementException {
        return null;
    }

    public void clear() {

    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
