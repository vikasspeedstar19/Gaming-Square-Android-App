package gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoDataModel;

/**
 * Created by Vikas on 07/06/2017.
 */

public class GamingSquareGameRatingDLCModel {
    String dlcid, dlcname;

    public GamingSquareGameRatingDLCModel(String dlcid, String dlcname) {
        this.dlcid = dlcid;
        this.dlcname = dlcname;
    }

    public String getDlcid() {
        return dlcid;
    }

    public void setDlcid(String dlcid) {
        this.dlcid = dlcid;
    }

    public String getDlcname() {
        return dlcname;
    }

    public void setDlcname(String dlcname) {
        this.dlcname = dlcname;
    }

    @Override
    public String toString() {
        return this.dlcname;
    }
}
