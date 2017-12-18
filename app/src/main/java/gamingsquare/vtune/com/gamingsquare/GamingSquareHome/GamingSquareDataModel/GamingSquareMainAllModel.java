package gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareDataModel;

/**
 * Created by Vikas on 01/03/2017.
 */

public class GamingSquareMainAllModel {
    private String Game_Id, Game_Name, Publisher, Game_Img;
    private int Main_List_Rating;

    public GamingSquareMainAllModel() {

    }

    public GamingSquareMainAllModel(String game_Id, String game_Name, String publisher, int main_List_Rating, String Game_Img) {
        Game_Id = game_Id;
        Game_Name = game_Name;
        Publisher = publisher;
        Main_List_Rating = main_List_Rating;
        this.Game_Img = Game_Img;
    }

    public String getGame_Img() {
        return Game_Img;
    }

    public void setGame_Img(String game_Img) {
        Game_Img = game_Img;
    }

    public String getGame_Id() {
        return Game_Id;
    }

    public void setGame_Id(String game_Id) {
        Game_Id = game_Id;
    }

    public String getGame_Name() {
        return Game_Name;
    }

    public void setGame_Name(String game_Name) {
        Game_Name = game_Name;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public int getMain_List_Rating() {
        return Main_List_Rating;
    }

    public void setMain_List_Rating(int main_List_Rating) {
        Main_List_Rating = main_List_Rating;
    }

}
