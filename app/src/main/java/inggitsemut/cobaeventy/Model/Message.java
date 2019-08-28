package inggitsemut.cobaeventy.Model;

public class Message {
    String photo;
    String person;
    String message;

    public Message(String photo, String person, String message) {
        this.photo = photo;
        this.person = person;
        this.message = message;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
