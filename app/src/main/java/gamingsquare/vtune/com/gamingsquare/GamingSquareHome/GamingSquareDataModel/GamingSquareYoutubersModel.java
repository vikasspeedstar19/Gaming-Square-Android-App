package gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareDataModel;

/**
 * Created by Vikas on 05/03/2017.
 */

public class GamingSquareYoutubersModel {
    String youtuber_id, youtuber_name, youtuber_subscribers, youtuber_image;


    public GamingSquareYoutubersModel(String youtuber_id, String youtuber_name, String youtuber_subscribers, String youtuber_image) {
        this.youtuber_id = youtuber_id;
        this.youtuber_name = youtuber_name;
        this.youtuber_subscribers = youtuber_subscribers;
        this.youtuber_image = youtuber_image;
    }

    public String getYoutuber_id() {
        return youtuber_id;
    }

    public void setYoutuber_id(String youtuber_id) {
        this.youtuber_id = youtuber_id;
    }

    public String getYoutuber_image() {
        return youtuber_image;
    }

    public void setYoutuber_image(String youtuber_image) {
        this.youtuber_image = youtuber_image;
    }

    public String getYoutuber_name() {
        return youtuber_name;
    }

    public void setYoutuber_name(String youtuber_name) {
        this.youtuber_name = youtuber_name;
    }

    public String getYoutuber_subscribers() {
        return youtuber_subscribers;
    }

    public void setYoutuber_subscribers(String youtuber_subscribers) {
        this.youtuber_subscribers = youtuber_subscribers;
    }
}
