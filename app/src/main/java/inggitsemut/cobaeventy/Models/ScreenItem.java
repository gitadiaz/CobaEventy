package inggitsemut.cobaeventy.Models;

public class ScreenItem {
    String title, description;
    int imgIntro;

    public ScreenItem(String title, String description, int imgIntro) {
        this.title = title;
        this.description = description;
        this.imgIntro = imgIntro;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImgIntro() {
        return imgIntro;
    }

    public void setImgIntro(int imgIntro) {
        this.imgIntro = imgIntro;
    }
}
