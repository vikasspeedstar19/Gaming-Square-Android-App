package gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoDataModel;

import org.json.JSONArray;

/**
 * Created by Vikas on 17/06/2017.
 */

public class GamingSquareGameDLCInfoModel {
    String game_dlc_id, game_dlc_name, game_dlc_info, game_dlc_story;

    JSONArray game_dlc_ratings;

    public GamingSquareGameDLCInfoModel(String game_dlc_id, String game_dlc_name, String game_dlc_info, String game_dlc_story, JSONArray game_dlc_ratings) {
        this.game_dlc_id = game_dlc_id;
        this.game_dlc_name = game_dlc_name;
        this.game_dlc_info = game_dlc_info;
        this.game_dlc_story = game_dlc_story;
        this.game_dlc_ratings = game_dlc_ratings;
    }

    public String getGame_dlc_id() {
        return game_dlc_id;
    }

    public void setGame_dlc_id(String game_dlc_id) {
        this.game_dlc_id = game_dlc_id;
    }

    public String getGame_dlc_name() {
        return game_dlc_name;
    }

    public void setGame_dlc_name(String game_dlc_name) {
        this.game_dlc_name = game_dlc_name;
    }

    public String getGame_dlc_info() {
        return game_dlc_info;
    }

    public void setGame_dlc_info(String game_dlc_info) {
        this.game_dlc_info = game_dlc_info;
    }

    public String getGame_dlc_story() {
        return game_dlc_story;
    }

    public void setGame_dlc_story(String game_dlc_story) {
        this.game_dlc_story = game_dlc_story;
    }

    public JSONArray getGame_dlc_ratings() {
        return game_dlc_ratings;
    }

    public void setGame_dlc_ratings(JSONArray game_dlc_ratings) {
        this.game_dlc_ratings = game_dlc_ratings;
    }
}
