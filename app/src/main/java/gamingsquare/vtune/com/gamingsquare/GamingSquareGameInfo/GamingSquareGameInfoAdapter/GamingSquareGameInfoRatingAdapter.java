package gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoAdapter;

/**
 * Created by Vikas on 02/06/2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfo;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoVolleyData.GamingSquareGameRatingVolleyData;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHelper.GamingSquareHelper;
import gamingsquare.vtune.com.gamingsquare.R;

/**
 * Created by Vikas on 01/03/2017.
 */

public class GamingSquareGameInfoRatingAdapter extends RecyclerView.Adapter {

    private GamingSquareGameInfo ct;
    private GamingSquareHelper gamingSquareHelper = new GamingSquareHelper();
    private GamingSquareGameRatingVolleyData gamingSquareGameRatingVolleyData;

    public GamingSquareGameInfoRatingAdapter(Context ct, GamingSquareGameRatingVolleyData gamingSquareGameRatingVolleyData) {
        this.ct = (GamingSquareGameInfo) ct;
        this.gamingSquareGameRatingVolleyData = gamingSquareGameRatingVolleyData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_game_info_rating, parent, false);
        RecViewHolder rvh = new RecViewHolder(v);
        return rvh;
    }

    public void gamingSquareAddGameRatingListData(){
        notifyItemInserted(gamingSquareGameRatingVolleyData.getListSize());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecViewHolder rvh = (RecViewHolder) holder;
        rvh.ratingName.setText(gamingSquareGameRatingVolleyData.getListItem(position).getRatingName());
        rvh.ratingValue.setText(""+gamingSquareGameRatingVolleyData.getListItem(position).getRatingValue());
        rvh.ratingBar.setRating(gamingSquareGameRatingVolleyData.getListItem(position).getRatingValue()/20.0f);
    }

    @Override
    public int getItemCount() {
        return gamingSquareGameRatingVolleyData.getListSize();
    }

    public class RecViewHolder extends RecyclerView.ViewHolder {

        TextView ratingName, ratingValue;

        SimpleRatingBar ratingBar;

        public RecViewHolder(View itemView) {
            super(itemView);

            ratingName = (TextView) itemView.findViewById(R.id.ratingName);
            ratingBar = (SimpleRatingBar) itemView.findViewById(R.id.ratingBar);
            ratingValue = (TextView) itemView.findViewById(R.id.ratingValue);
        }
    }
}