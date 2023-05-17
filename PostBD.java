// --== CS400 Project One File Header ==--
// Name: Sreya Sarathy
// CSL Username: ssarathy
// Email: sarathy2@wisc.edu
// Lecture #: Prof Florian MWF 3:30 pm to 4:20 pm
// Notes to Grader: <any optional extra notes to your grader>

public class PostBD implements PostInterface{
    private String title; //Initializing the string "title"
    private String url; //Initializing the string "url"
    private String body; //Initializing the string "body"


    //The below methods are all getter methods so they return the variable itself
    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public String getBody() {
        return this.body;
    }
}
