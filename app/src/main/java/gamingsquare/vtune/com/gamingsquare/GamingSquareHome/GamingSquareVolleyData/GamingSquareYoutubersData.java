package gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareVolleyData;

import java.util.ArrayList;

import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareDataModel.GamingSquareYoutubersModel;

/**
 * Created by Vikas on 04/03/2017.
 */

public class GamingSquareYoutubersData {

    private GamingSquareYoutubersModel gamingdata[] = new GamingSquareYoutubersModel[] {
            new GamingSquareYoutubersModel("vwx", "vwx", "vwx", "vwx"),
            new GamingSquareYoutubersModel("vwx", "vwx", "vwx", "vwx"),
            new GamingSquareYoutubersModel("vwx", "vwx", "vwx", "vwx"),
            new GamingSquareYoutubersModel("vwx", "vwx", "vwx", "vwx"),
            new GamingSquareYoutubersModel("vwx", "vwx", "vwx", "vwx"),
            new GamingSquareYoutubersModel("vwx", "vwx", "vwx", "vwx"),
            new GamingSquareYoutubersModel("vwx", "vwx", "vwx", "vwx"),
            new GamingSquareYoutubersModel("vwx", "vwx", "vwx", "vwx"),
            new GamingSquareYoutubersModel("vwx", "vwx", "vwx", "vwx"),
            new GamingSquareYoutubersModel("vwx", "vwx", "vwx", "vwx") };

    ArrayList<GamingSquareYoutubersModel> gamingSquareMainAllModels = new ArrayList<GamingSquareYoutubersModel>();

    public int getListSize() {
        return gamingdata.length;
    }

    public GamingSquareYoutubersModel getListItem(int position) {
        return gamingdata[position];
    }
}
