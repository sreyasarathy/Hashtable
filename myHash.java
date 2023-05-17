// --== CS400 Project One File Header ==--
// Name: Sreya Sarathy
// CSL Username: ssarathy
// Email: sarathy2@wisc.edu
// Lecture #: Prof Florian MWF 3:30 pm to 4:20 pm
// Notes to Grader: <any optional extra notes to your grader>

class myHash  <KeyType, ValueType> {
    private KeyType key; //defining the KeyType parameter
    private ValueType value; //defining the keyValue parameter

    public myHash(KeyType k, ValueType v){
        key = k; //initializing key
        value = v; //initializing value
    }

    // setters for setKey and setValue
    // getters for getKey and getValue
    public KeyType getKey(){
        return key;
    }

    public void setKey(KeyType key){
        this.key = key;
    }

    public ValueType getValue(){
        return value;
    }

    public void setValue(ValueType value){
        this.value = value;
    }
}