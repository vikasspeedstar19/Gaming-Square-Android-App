package gamingsquare.vtune.com.gamingsquare.HomeFragmentGamesSearch;

/**
 * Created by Vikas on 04/05/2017.
 */

public class GamingSquareGamesSearchModel {

    String game_id, game_name;

    public GamingSquareGamesSearchModel(String game_id, String game_name) {
        this.game_id = game_id;
        this.game_name = game_name;
    }

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    @Override
    public String toString() {
        return this.game_name;
    }
}
