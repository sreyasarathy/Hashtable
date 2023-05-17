// --== CS400 Project One File Header ==--
// Name: Sreya Sarathy
// CSL Username: ssarathy
// Email: sarathy2@wisc.edu
// Lecture #: Prof Florian MWF 3:30 pm to 4:20 pm
// Notes to Grader: <any optional extra notes to your grader>

import java.util.List;

public interface HashtableWithDuplicateKeysInterface<KeyType, ValueType> extends MapADT<KeyType, List<ValueType>> {
    //public HashtableWithDuplicateKeysInterface(int capacity);
    //public HashtableWithDuplicateKeysInterface();
    public void putOne(KeyType key, ValueType value);
    public void removeOne(KeyType key, ValueType value);
    public int getNumberOfValues();
}