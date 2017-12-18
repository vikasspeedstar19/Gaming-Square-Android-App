package gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mzelzoghbi.zgallery.ZGallery;
import com.mzelzoghbi.zgallery.entities.ZColor;
import com.squareup.picasso.Picasso;

import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfo;
import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfoVolleyData.GamingSquareGameScreenshotsVolleyData;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHelper.GamingSquareHelper;
import gamingsquare.vtune.com.gamingsquare.R;

/**
 * Created by Vicky on 8/23/2017.
 */

public class GamingSquareGameScreenshotsAdapter extends RecyclerView.Adapter{

    private GamingSquareGameInfo ct;
    private GamingSquareGameScreenshotsVolleyData gamingSquareGameScreenshotsVolleyData;

    public GamingSquareGameScreenshotsAdapter(Context ct, GamingSquareGameScreenshotsVolleyData gamingSquareGameScreenshotsVolleyData) {
        this.ct = (GamingSquareGameInfo) ct;
        this.gamingSquareGameScreenshotsVolleyData = gamingSquareGameScreenshotsVolleyData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_gaming_square_screenshots, parent, false);
        RecViewHolder rvh = new RecViewHolder(v);
        return rvh;
    }

    public void gamingSquareAddGameScreenshotsListData(){
        notifyItemInserted(gamingSquareGameScreenshotsVolleyData.getListSize());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecViewHolder rvh = (RecViewHolder) holder;

        Picasso.with(ct)
                .load(new GamingSquareHelper().GAMING_SQAURE_IMG_BASE_URL+gamingSquareGameScreenshotsVolleyData.getListItem(position).getGameScreenshots())
                .placeholder(R.drawable.exclusives)   // optional
                .error(R.mipmap.ic_launcher)      // optional
                .resize(300, 300)                        // optional
                .into(rvh.gamingSquareGameScreenshots);

    }

    @Override
    public int getItemCount() {
        return gamingSquareGameScreenshotsVolleyData.getListSize();
    }

    public class RecViewHolder extends RecyclerView.ViewHolder {

        ImageView gamingSquareGameScreenshots;

        public RecViewHolder(View itemView) {
            super(itemView);
            gamingSquareGameScreenshots = (ImageView) itemView.findViewById(R.id.gamingSquareGameScreenshots);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ZGallery.with(ct, gamingSquareGameScreenshotsVolleyData.getGameScreenshots())
                            .setToolbarTitleColor(ZColor.WHITE) // toolbar title color
                            .setGalleryBackgroundColor(ZColor.WHITE) // activity background color
                            .setToolbarColorResId(R.color.colorPrimary) // toolbar color
                            .setTitle("Zak Gallery") // toolbar title
                            .show();

                }
            });

        }
    }
}
