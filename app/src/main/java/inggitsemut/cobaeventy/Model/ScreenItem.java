package inggitsemut.cobaeventy.Model;

public class ScreenItem {
//    @Expose
//    @SerializedName("data")
//    private List<DataEntity> data;
//    @Expose
//    @SerializedName("error")
//    private boolean error;
//    @Expose
//    @SerializedName("message")
//    private String message;
//
//    public List<DataEntity> getData() {
//        return data;
//    }
//
//    public void setData(List<DataEntity> data) {
//        this.data = data;
//    }
//
//    public boolean getError() {
//        return error;
//    }
//
//    public void setError(boolean error) {
//        this.error = error;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public static class DataEntity {
//        @Expose
//        @SerializedName("Activation")
//        private String activation;
//        @Expose
//        @SerializedName("updated_at")
//        private String updatedAt;
//        @Expose
//        @SerializedName("created_at")
//        private String createdAt;
//        @Expose
//        @SerializedName("splash_bg_color")
//        private String splashBgColor;
//        @Expose
//        @SerializedName("splash_image")
//        private String splashImage;
//        @Expose
//        @SerializedName("splash_desc")
//        private String splashDesc;
//        @Expose
//        @SerializedName("splash_title")
//        private String splashTitle;
//        @Expose
//        @SerializedName("event_code")
//        private String eventCode;
//        @Expose
//        @SerializedName("id")
//        private int id;
//
//        public String getActivation() {
//            return activation;
//        }
//
//        public void setActivation(String activation) {
//            this.activation = activation;
//        }
//
//        public String getUpdatedAt() {
//            return updatedAt;
//        }
//
//        public void setUpdatedAt(String updatedAt) {
//            this.updatedAt = updatedAt;
//        }
//
//        public String getCreatedAt() {
//            return createdAt;
//        }
//
//        public void setCreatedAt(String createdAt) {
//            this.createdAt = createdAt;
//        }
//
//        public String getSplashBgColor() {
//            return splashBgColor;
//        }
//
//        public void setSplashBgColor(String splashBgColor) {
//            this.splashBgColor = splashBgColor;
//        }
//
//        public String getSplashImage() {
//            return splashImage;
//        }
//
//        public void setSplashImage(String splashImage) {
//            this.splashImage = splashImage;
//        }
//
//        public String getSplashDesc() {
//            return splashDesc;
//        }
//
//        public void setSplashDesc(String splashDesc) {
//            this.splashDesc = splashDesc;
//        }
//
//        public String getSplashTitle() {
//            return splashTitle;
//        }
//
//        public void setSplashTitle(String splashTitle) {
//            this.splashTitle = splashTitle;
//        }
//
//        public String getEventCode() {
//            return eventCode;
//        }
//
//        public void setEventCode(String eventCode) {
//            this.eventCode = eventCode;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//    }


    private String splash_title, splash_desc, splash_image;

    public ScreenItem(String splash_title, String splash_desc, String splash_image) {
        this.splash_title = splash_title;
        this.splash_desc = splash_desc;
        this.splash_image = splash_image;
    }

    public String getSplash_title() {
        return splash_title;
    }

    public void setSplash_title(String splash_title) {
        this.splash_title = splash_title;
    }

    public String getSplash_desc() {
        return splash_desc;
    }

    public void setSplash_desc(String splash_desc) {
        this.splash_desc = splash_desc;
    }

    public String getSplash_image() {
        return splash_image;
    }

    public void setSplash_image(String splash_image) {
        this.splash_image = splash_image;
    }
}
