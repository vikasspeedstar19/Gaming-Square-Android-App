package gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoDataModel;

import org.json.JSONArray;

/**
 * Created by Vikas on 15/05/2017.
 */

public class GamingSquareGamingInfoModel {
    String imgUrl;
    JSONArray developer;
    JSONArray gameModes;
    JSONArray genre;
    JSONArray playerView;
    JSONArray publisher;
    JSONArray releaseDates;

    public GamingSquareGamingInfoModel(String imgUrl, JSONArray developer, JSONArray gameModes, JSONArray genre, JSONArray playerView, JSONArray publisher, JSONArray releaseDates) {
        this.imgUrl = imgUrl;
        this.developer = developer;
        this.gameModes = gameModes;
        this.genre = genre;
        this.playerView = playerView;
        this.publisher = publisher;
        this.releaseDates = releaseDates;
    }

    public String getImgUrl(){
        return imgUrl;
    }

    public void setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }
    public JSONArray getDeveloper() {
        return developer;
    }

    public void setDeveloper(JSONArray developer) {
        this.developer = developer;
    }

    public JSONArray getGameModes() {
        return gameModes;
    }

    public void setGameModes(JSONArray gameModes) {
        this.gameModes = gameModes;
    }

    public JSONArray getGenre() {
        return genre;
    }

    public void setGenre(JSONArray genre) {
        this.genre = genre;
    }

    public JSONArray getPlayerView() {
        return playerView;
    }

    public void setPlayerView(JSONArray playerView) {
        this.playerView = playerView;
    }

    public JSONArray getPublisher() {
        return publisher;
    }

    public void setPublisher(JSONArray publisher) {
        this.publisher = publisher;
    }

    public JSONArray getReleaseDates() {
        return releaseDates;
    }

    public void setReleaseDates(JSONArray releaseDates) {
        this.releaseDates = releaseDates;
    }
}
