package inggitsemut.cobaeventy.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class JWTToken {

    @Expose
    @SerializedName("id")
    private int id;
    @Expose
    @SerializedName("token")
    private String token;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
