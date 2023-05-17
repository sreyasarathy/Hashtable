// --== CS400 Project One File Header ==--
// Name: Sreya Sarathy
// CSL Username: ssarathy
// Email: sarathy2@wisc.edu
// Lecture #: Prof Florian MWF 3:30 pm to 4:20 pm
// Notes to Grader: <any optional extra notes to your grader>

import java.io.FileNotFoundException;
import java.util.List;

public interface CHSearchBackendInterface {
    // public CHSearchBackendInterface(HashtableWithDuplicateKeysInterface<String,PostInterface> hashtable, PostReaderInterface postReader);
    public void loadData(String filename) throws FileNotFoundException;
    public List<String> findPostsByTitleWords(String words);
    public List<String> findPostsByBodyWords(String words);
    public List<String> findPostsByTitleOrBodyWords(String words);
    public String getStatisticsString();
}