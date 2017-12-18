package gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoDataModel;


/**
 * Created by Vikas on 15/05/2017.
 */

public class GamingSquareGameRatingModel {
    
    public String ratingName;
    public int ratingValue;

    public GamingSquareGameRatingModel(String ratingName, int ratingValue) {
        this.ratingName = ratingName;
        this.ratingValue = ratingValue;
    }

    public String getRatingName() {
        return ratingName;
    }

    public void setRatingName(String ratingName) {
        this.ratingName = ratingName;
    }

    public int getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(int ratingValue) {
        this.ratingValue = ratingValue;
    }
}