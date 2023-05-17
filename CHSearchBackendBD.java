// --== CS400 Project One File Header ==--
// Name: Sreya Sarathy
// CSL Username: ssarathy
// Email: sarathy2@wisc.edu
// Lecture #: Prof Florian MWF 3:30 pm to 4:20 pm
// Notes to Grader: <any optional extra notes to your grader>

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CHSearchBackendBD implements CHSearchBackendInterface {
    // Defining the variables which are of different interface types
    public HashtableWithDuplicateKeysInterface<String, PostInterface> hashtable;
    public PostReaderInterface postReader;

    // Initializing the constructor provided in the specification
    public CHSearchBackendBD(HashtableWithDuplicateKeysInterface<String, PostInterface> hashtable,
                             PostReaderInterface postReader) {
        this.hashtable = hashtable;
        this.postReader = postReader;
    }

    // Defining the private helper methods used in this class


    /** RegularCase is a private helper method to change the case type
     * from regular to lower case
     * @param word
     * @return word - in lower case
     */
    private String regularCase(String word) {
        // converting everything to lower case to ensure that it is easy to find the respective word
        return word.toLowerCase();
    }

    /** PunctuationRemoval is a private helper method to remove the punctuation from the word
     * to ensure that the word is understood regardless
     * @param word
     * @return word - without punctuation
     */
    private String punctuationRemoval(String word) {
        return word.replaceAll("[^a-zA-Z0-9]", "");
    }


    /** WordsFromString is a private helper method to retrive the words from a string
     * @param body
     * @return word - from the string
     */
    private String[] wordsFromString(String body) {
        String[] words = body.split("\\s+");
        for (int a = 0; a < words.length; a++) {
            words[a] = punctuationRemoval(words[a]);
        }
        return words;
    }

    /** PostTitlesFromTable is a private helper method which is used to return the titles of the PostInterface Object
     * and initializes an array while also iterating through the words present in it.
     * @param samePosts
     * @return titleName - the title
     */

    private List<String> postTitlesFromTable(List<PostInterface> samePosts) {
        List<String> titleName = new ArrayList<>();
        for (PostInterface postEntry : samePosts) {
            titleName.add(postEntry.getTitle());
        }
        return titleName;
    }


    /** The loadData method loads data from a given file, processes the data, and then adds the data to a hash table.
     * @param filename
     * @throws FileNotFoundException - if the hash table does
     * // not contain the words in the title or body of any post
     */
    public void loadData(String filename) throws FileNotFoundException {
        // If the table does not contain the word then a new FileNotFoundException must be thrown with the
        // error message: the word is not present in title or body!
        if (!hashtable.containsKey(filename))
            throw new FileNotFoundException("Error: The word is not present in the title or body!!");

        // To load the respective data
        List<PostInterface> postType = postReader.readPostsFromFile(filename);
        for (PostInterface postEntry : postType) {
            String[] body = wordsFromString(postEntry.getBody()); // to load the data from the body
            String[] title = wordsFromString(postEntry.getTitle()); // to load the data from the title
            String[] url = wordsFromString(postEntry.getUrl()); // to load the data from the url

            // To loop through the words in body
            for (String bodyWord : body) {
                String key = "BODY:" + regularCase(bodyWord);
                hashtable.putOne(key, postEntry); // to add content to the end of the existing list
            }

            // To loop through the words in the title
            for (String titleWord : title) {
                String key = "TITLE:" + regularCase(titleWord);
                hashtable.putOne(key, postEntry); // to add content to the end of the existing list
            }

            // To loop through the words in the url
            for (String urlWord : url) {
                String key = "URL:" + regularCase(urlWord);
                hashtable.putOne(key, postEntry); // to add content to the end of the existing list
            }
        }
    }


    /** The findPostsByTitleWords performs a search operation to find the desired word from
     * the title of the post. If any posts are found then they are added to the samePosts list.
     * @param words
     * @return postTitlesFromTable - returns a list of titles.
     */
    @Override
    public List<String> findPostsByTitleWords(String words) {
        String[] searchingForWords = wordsFromString(words); // Array of String Objects
        List<PostInterface> samePosts = new ArrayList<>(); // to hold a list of objects that implement the interface

        // To find the word through the table
        for (String word : searchingForWords) {
            String key = "TITLE:" + regularCase(word);
            List<PostInterface> postType = hashtable.get(key);

            // if the word exists then add it to the list
            if (postType != null) {
                samePosts.addAll(postType);
            }
        }
        return postTitlesFromTable(samePosts);
    }


    /** The findPostsByBodyWords performs a search operation to find the desired word from
     * the body of the post. If any posts are found then they are added to the samePosts list.
     * @param words
     * @return postTitlesFromTable - returns a list of titles
     */
    @Override
    public List<String> findPostsByBodyWords(String words) {
        String[] searchingForWords = wordsFromString(words); // Array of String Objects
        List<PostInterface> samePosts = new ArrayList<>(); // to hold a list of objects that implement the interface

        // To find the word through the table
        for (String word : searchingForWords) {
            String key = "BODY:" + regularCase(word);
            List<PostInterface> postType = hashtable.get(key);

            // if the word exists then add it to the list
            if (postType != null) {
                samePosts.addAll(postType);
            }
        }
        return postTitlesFromTable(samePosts);
    }


    /** The findPostsByTitleOrBodyWords performs a search operation to find the desired
     * word from the body of the post or the title of the post.
     * If any of the posts are found then they are added to the samePosts list.
     * @param words
     * @return samePosts - list of posts regardless of title or body
     */
    public List<String> findPostsByTitleOrBodyWords(String words) {
        List<String> samePosts = new ArrayList<>(); // initializing an empty list

        // Checking byTitleWords
        List<String> postsByTitle = findPostsByTitleWords(words);
        if (postsByTitle != null) {
            samePosts.addAll(postsByTitle); // postsByBody is added if not null
        }

        //Checking byBodyWords
        List<String> postsByBody = findPostsByBodyWords(words);
        if (postsByBody != null) {
            samePosts.addAll(postsByBody); // postsByBody is added if not null
        }
        return samePosts;
    }

    /** The getStatisticsString uses the getNumberofValues from the HashtableWithDuplicateKeysInterface
     * to return a statement with the number of posts for the said word.
     * @return - statement with the numberOfPosts
     */
    @Override
    public String getStatisticsString() {
        int numberOfPosts = hashtable.getNumberOfValues(); // to find the number of values in the table
        return "The number of posts are: " + numberOfPosts;
    }
}






