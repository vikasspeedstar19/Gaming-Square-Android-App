package gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoDataModel;

import org.json.JSONArray;

/**
 * Created by Vikas on 07/06/2017.
 */

public class GamingSquareExtraModel {
    JSONArray dlclist, platformlist;

    public GamingSquareExtraModel(JSONArray dlclist, JSONArray platformlist) {
        this.dlclist = dlclist;
        this.platformlist = platformlist;
    }

    public JSONArray getDlclist() {
        return dlclist;
    }

    public void setDlclist(JSONArray dlclist) {
        this.dlclist = dlclist;
    }

    public JSONArray getPlatformlist() {
        return platformlist;
    }

    public void setPlatformlist(JSONArray platformlist) {
        this.platformlist = platformlist;
    }
}
