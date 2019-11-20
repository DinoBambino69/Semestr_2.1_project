package Database;

public class Post {
    private int id;
    private String photo, text;

    public Post(int id, String photo, String text) {
        this.id = id;
        this.photo = photo;
        this.text = text;
    }

    public Post() {

    }

    public int getId() {
        return id;
    }

    public String getPhoto() {
        return photo;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", photo='" + photo + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
