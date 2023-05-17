// --== CS400 Project One File Header ==--
// Name: Sreya Sarathy
// CSL Username: ssarathy
// Email: sarathy2@wisc.edu
// Lecture #: Prof Florian MWF 3:30 pm to 4:20 pm
// Notes to Grader: <any optional extra notes to your grader>

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostReaderBD implements PostReaderInterface {
    @Override
    public List<PostInterface> readPostsFromFile(String filename) throws FileNotFoundException {
        List<PostInterface> list = new ArrayList<PostInterface>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // parse the line and create a new Post object
                // add the Post object to the list
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Warning!! Error: The file does not exist");
        }
        return list;
    }
}

