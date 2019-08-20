package inggitsemut.cobaeventy.Model;

public class Menu {

    private String Title;
    private int image;

    public Menu(){

    }

    public Menu(String title, int image) {
        Title = title;
        this.image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
