public class PostDW implements PostInterface {

    private String title;
    private String url;
    private String body;

    /**
     * Instantiation of new post objects requires the following data:
     *
     * @param title describing the post's content
     * @param url   of publicly accessible redit post containing this title and body
     * @param body  of text ellaborating on the topic of title
     */
    public PostDW(String title, String url, String body) {
        this.title = title;
        this.url = url;
        this.body = body;
    }

    public String getTitle() { // post's accessor method for title
        return title;
    }

    public String getUrl() { // post's accessor method for url
        return url;
    }

    public String getBody() { // post's accessor method for body
        return body;
    }

}
