package gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareGamesAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import com.squareup.picasso.Picasso;

import gamingsquare.vtune.com.gamingsquare.GamingSquareGameInfo.GamingSquareGameInfo;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHelper.GamingSquareHelper;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareHome;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareVolleyData.GamingSquareExclusivesPCData;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareVolleyData.GamingSquareExclusivesPSData;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareVolleyData.GamingSquareExclusivesXBOXData;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareVolleyData.GamingSquareMainData;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareVolleyData.GamingSquareTop100Data;
import gamingsquare.vtune.com.gamingsquare.GamingSquareHome.GamingSquareVolleyData.GamingSquareYoutubersData;
import gamingsquare.vtune.com.gamingsquare.R;

/**
 * Created by Vikas on 01/03/2017.
 */

public class GamingSquareRecViewAdapter extends RecyclerView.Adapter {

    private GamingSquareHome ct;
    private GamingSquareHelper gamingSquareHelper = new GamingSquareHelper();
    private String identity = "";
    private GamingSquareMainData gamingSquareMainData;
    private GamingSquareTop100Data gamingSquareTop100Data;
    private GamingSquareExclusivesPCData gamingSquareExclusivesPCData;
    private GamingSquareExclusivesPSData gamingSquareExclusivesPSData;
    private GamingSquareExclusivesXBOXData gamingSquareExclusivesXBOXData;
    private GamingSquareYoutubersData gamingSquareYoutubersData;

    public GamingSquareRecViewAdapter(Context ct, GamingSquareMainData gamingSquareMainData, String identity) {
        this.ct = (GamingSquareHome) ct;
        this.gamingSquareMainData = gamingSquareMainData;
        this.identity = identity;
    }

    public GamingSquareRecViewAdapter(Context ct, GamingSquareTop100Data gamingSquareTop100Data, String identity){
        this.ct = (GamingSquareHome) ct;
        this.gamingSquareTop100Data = gamingSquareTop100Data;
        this.identity = identity;
    }

    public GamingSquareRecViewAdapter(Context ct, GamingSquareExclusivesPCData gamingSquareExclusivesPCData, String identity){
        this.ct = (GamingSquareHome) ct;
        this.gamingSquareExclusivesPCData = gamingSquareExclusivesPCData;
        this.identity = identity;
    }

    public GamingSquareRecViewAdapter(Context ct, GamingSquareExclusivesXBOXData gamingSquareExclusivesXBOXData, String identity){
        this.ct = (GamingSquareHome) ct;
        this.gamingSquareExclusivesXBOXData = gamingSquareExclusivesXBOXData;
        this.identity = identity;
    }

    public GamingSquareRecViewAdapter(Context ct, GamingSquareExclusivesPSData gamingSquareExclusivesPSData, String identity){
        this.ct = (GamingSquareHome) ct;
        this.gamingSquareExclusivesPSData = gamingSquareExclusivesPSData;
        this.identity = identity;
    }

    public GamingSquareRecViewAdapter(Context ct, GamingSquareYoutubersData gamingSquareYoutubersData, String identity){
        this.ct = (GamingSquareHome) ct;
        this.gamingSquareYoutubersData = gamingSquareYoutubersData;
        this.identity = identity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(identity.equals(gamingSquareHelper.GAMING_SQUARE_MAIN_ALL_PC)){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gaming_square_card_view_all, parent, false);
            RecViewHolder rvh = new RecViewHolder(v,identity);
            return rvh;
        }
        else if(identity.equals(gamingSquareHelper.GAMING_SQAURE_TOP_100)){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_gaming_square_cardview_top100, parent, false);
            RecViewHolder rvh = new RecViewHolder(v,identity);
            return rvh;
        }
        else if(identity.equals(gamingSquareHelper.GAMING_SQAURE_EXCLUSIVES_PC) || identity.equals(gamingSquareHelper.GAMING_SQAURE_EXCLUSIVES_PS) || identity.equals(gamingSquareHelper.GAMING_SQAURE_EXCLUSIVES_XBOX) ){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_gaming_square_exclusives, parent, false);
            RecViewHolder rvh = new RecViewHolder(v,identity);
            return rvh;
        }
        else{
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_gaming_square_youtubers, parent, false);
            RecViewHolder rvh = new RecViewHolder(v,identity);
            return rvh;
        }

    }

    public void gamingSquareAddMainListData(){
        notifyItemInserted(gamingSquareMainData.getListSize());
    }
    public void gamingSquareAddTop100ListData(){
        notifyItemInserted(gamingSquareTop100Data.getListSize());
    }
    public void gamingSquareAddExclusivePCListData(){
        notifyItemInserted(gamingSquareExclusivesPCData.getListSize());
    }
    public void gamingSquareAddExclusivePSListData(){
        notifyItemInserted(gamingSquareExclusivesPSData.getListSize());
    }
    public void gamingSquareAddExclusiveXBOXListData(){
        notifyItemInserted(gamingSquareExclusivesXBOXData.getListSize());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecViewHolder rvh = (RecViewHolder) holder;

        if(identity.equals(gamingSquareHelper.GAMING_SQUARE_MAIN_ALL_PC)){
            rvh.game_name.setText(gamingSquareMainData.getListItem(position).getGame_Name());
            rvh.game_publisher.setText(gamingSquareMainData.getListItem(position).getPublisher());
            rvh.game_rating.setRating(gamingSquareMainData.getListItem(position).getMain_List_Rating()/20.0f);
            Picasso.with(ct)
                    .load(new GamingSquareHelper().GAMING_SQAURE_IMG_BASE_URL+gamingSquareMainData.getListItem(position).getGame_Img())
                    .placeholder(R.drawable.exclusives)   // optional
                    .error(R.mipmap.ic_launcher)      // optional
                    .resize(300, 300)                        // optional
                    //  .rotate(90)
                    .into(rvh.game_img);
        }

        else if(identity.equals(gamingSquareHelper.GAMING_SQAURE_TOP_100)){
            rvh.game_name.setText(gamingSquareTop100Data.getListItem(position).getGame_Name());
            rvh.game_publisher.setText(gamingSquareTop100Data.getListItem(position).getPublisher());
            rvh.game_rating.setRating(gamingSquareTop100Data.getListItem(position).getMain_List_Rating()/20.0f);
            Picasso.with(ct)
                    .load(new GamingSquareHelper().GAMING_SQAURE_IMG_BASE_URL+gamingSquareTop100Data.getListItem(position).getGame_Img())
                    .placeholder(R.drawable.exclusives)   // optional
                    .error(R.mipmap.ic_launcher)      // optional
                    .resize(300, 300)                        // optional
                    //  .rotate(90)
                    .into(rvh.game_img);
        }
        else if(identity.equals(gamingSquareHelper.GAMING_SQAURE_EXCLUSIVES_PC)){
            rvh.game_name.setText(gamingSquareExclusivesPCData.getListItem(position).getGame_Name());
            rvh.game_publisher.setText(gamingSquareExclusivesPCData.getListItem(position).getPublisher());
            rvh.game_rating.setRating(gamingSquareExclusivesPCData.getListItem(position).getMain_List_Rating()/20.0f);
            Picasso.with(ct)
                    .load(new GamingSquareHelper().GAMING_SQAURE_IMG_BASE_URL+gamingSquareExclusivesPCData.getListItem(position).getGame_Img())
                    .placeholder(R.drawable.exclusives)   // optional
                    .error(R.mipmap.ic_launcher)      // optional
                    .resize(300, 300)                        // optional
                    //  .rotate(90)
                    .into(rvh.game_img);
        }
        else if(identity.equals(gamingSquareHelper.GAMING_SQAURE_EXCLUSIVES_PS)){
            rvh.game_name.setText(gamingSquareExclusivesPSData.getListItem(position).getGame_Name());
            rvh.game_publisher.setText(gamingSquareExclusivesPSData.getListItem(position).getPublisher());
            rvh.game_rating.setRating(gamingSquareExclusivesPSData.getListItem(position).getMain_List_Rating()/20.0f);
            Picasso.with(ct)
                    .load(new GamingSquareHelper().GAMING_SQAURE_IMG_BASE_URL+gamingSquareExclusivesPSData.getListItem(position).getGame_Img())
                    .placeholder(R.drawable.exclusives)   // optional
                    .error(R.mipmap.ic_launcher)      // optional
                    .resize(300, 300)                        // optional
                    //  .rotate(90)
                    .into(rvh.game_img);
        }
        else if(identity.equals(gamingSquareHelper.GAMING_SQAURE_EXCLUSIVES_XBOX)){
            rvh.game_name.setText(gamingSquareExclusivesXBOXData.getListItem(position).getGame_Name());
            rvh.game_publisher.setText(gamingSquareExclusivesXBOXData.getListItem(position).getPublisher());
            rvh.game_rating.setRating(gamingSquareExclusivesXBOXData.getListItem(position).getMain_List_Rating()/20.0f);
            Picasso.with(ct)
                    .load(new GamingSquareHelper().GAMING_SQAURE_IMG_BASE_URL+gamingSquareExclusivesXBOXData.getListItem(position).getGame_Img())
                    .placeholder(R.drawable.exclusives)   // optional
                    .error(R.mipmap.ic_launcher)      // optional
                    .resize(300, 300)                        // optional
                    //  .rotate(90)
                    .into(rvh.game_img);
        }
        else if(identity.equals(gamingSquareHelper.GAMING_SQAURE_YOUTUBERS)){
            rvh.youtuber_name.setText(gamingSquareYoutubersData.getListItem(position).getYoutuber_name());
            rvh.youtuber_subscribers.setText(gamingSquareYoutubersData.getListItem(position).getYoutuber_subscribers());

        }
    }



    @Override
    public int getItemCount() {

        if(identity.equals(gamingSquareHelper.GAMING_SQUARE_MAIN_ALL_PC)){
            return gamingSquareMainData.getListSize();
        }
        else if(identity.equals(gamingSquareHelper.GAMING_SQAURE_TOP_100)){
            return gamingSquareTop100Data.getListSize();
        }
        else if(identity.equals(gamingSquareHelper.GAMING_SQAURE_EXCLUSIVES_PC)){
            return gamingSquareExclusivesPCData.getListSize();
        }
        else if(identity.equals(gamingSquareHelper.GAMING_SQAURE_EXCLUSIVES_PS)){
            return gamingSquareExclusivesPSData.getListSize();
        }
        else if(identity.equals(gamingSquareHelper.GAMING_SQAURE_EXCLUSIVES_XBOX)){
            return gamingSquareExclusivesXBOXData.getListSize();
        }
        else if(identity.equals(gamingSquareHelper.GAMING_SQAURE_YOUTUBERS)){
            return gamingSquareYoutubersData.getListSize();
        }
        else{
            return 0;
        }
    }

    public class RecViewHolder extends RecyclerView.ViewHolder{
        private TextView game_name, game_publisher,youtuber_name, youtuber_subscribers;
        private SimpleRatingBar game_rating;
        private ImageView game_img,youtuber_img;
        private String click_identity;
        public RecViewHolder(View itemView, String identity) {
            super(itemView);
            click_identity = identity;
            if(identity.equals(gamingSquareHelper.GAMING_SQUARE_MAIN_ALL_PC) || identity.equals(gamingSquareHelper.GAMING_SQUARE_MAIN_ALL_PS) || identity.equals(gamingSquareHelper.GAMING_SQUARE_MAIN_ALL_XBOX)) {
                game_name = (TextView) itemView.findViewById(R.id.main_list_game_name);
                game_rating = (SimpleRatingBar) itemView.findViewById(R.id.main_list_game_rating);
                game_publisher = (TextView) itemView.findViewById(R.id.main_list_game_publisher);
                game_img = (ImageView) itemView.findViewById(R.id.main_list_game_img);
            }
            else if(identity.equals(gamingSquareHelper.GAMING_SQAURE_TOP_100)){
                game_name = (TextView)itemView.findViewById(R.id.top_100_game_name);
                game_rating = (SimpleRatingBar)itemView.findViewById(R.id.top_100_game_rating);
                game_publisher = (TextView)itemView.findViewById(R.id.top_100_game_publisher);
                game_img = (ImageView)itemView.findViewById(R.id.top_100_game_img);
            }
            else if(identity.equals(gamingSquareHelper.GAMING_SQAURE_EXCLUSIVES_PC) || identity.equals(gamingSquareHelper.GAMING_SQAURE_EXCLUSIVES_PS) || identity.equals(gamingSquareHelper.GAMING_SQAURE_EXCLUSIVES_XBOX)){
                game_name = (TextView)itemView.findViewById(R.id.exclusives_game_name);
                game_img = (ImageView) itemView.findViewById(R.id.exclusives_game_img);
                game_publisher = (TextView)itemView.findViewById(R.id.exclusives_game_publisher);
                game_rating = (SimpleRatingBar) itemView.findViewById(R.id.exclusives_game_rating);
            }
            else if(identity.equals(gamingSquareHelper.GAMING_SQAURE_YOUTUBERS)){
                youtuber_name = (TextView) itemView.findViewById(R.id.youtubers_name);
                youtuber_img = (ImageView) itemView.findViewById(R.id.youtubers_img);
                youtuber_subscribers = (TextView)itemView.findViewById(R.id.youtubers_subscribers);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ct, GamingSquareGameInfo.class);
                    if(click_identity.equals(gamingSquareHelper.GAMING_SQUARE_MAIN_ALL_PC)){
                        String game_id = gamingSquareMainData.getListItem(getAdapterPosition()).getGame_Id();
                        String game_name = gamingSquareMainData.getListItem(getAdapterPosition()).getGame_Name();
                        intent.putExtra(gamingSquareHelper.GAMING_SQAURE_GAME_INFO_GAME_ID,game_id);
                        intent.putExtra(gamingSquareHelper.GAMING_SQUARE_GAME_NAME,game_name);
                        // Toast.makeText(ct, game_id, Toast.LENGTH_SHORT).show();
                    }
                    else if(click_identity.equals(gamingSquareHelper.GAMING_SQAURE_TOP_100)){
                        String game_id = gamingSquareTop100Data.getListItem(getAdapterPosition()).getGame_Id();
                        String game_name = gamingSquareTop100Data.getListItem(getAdapterPosition()).getGame_Name();
                        intent.putExtra(gamingSquareHelper.GAMING_SQAURE_GAME_INFO_GAME_ID,game_id);
                        intent.putExtra(gamingSquareHelper.GAMING_SQUARE_GAME_NAME,game_name);
                        // Toast.makeText(ct, game_id, Toast.LENGTH_SHORT).show();
                    }
                    else if(click_identity.equals(gamingSquareHelper.GAMING_SQAURE_EXCLUSIVES_PC)){
                        String game_id = gamingSquareExclusivesPCData.getListItem(getAdapterPosition()).getGame_Id();
                        String game_name = gamingSquareExclusivesPCData.getListItem(getAdapterPosition()).getGame_Name();
                        intent.putExtra(gamingSquareHelper.GAMING_SQAURE_GAME_INFO_GAME_ID,game_id);
                        intent.putExtra(gamingSquareHelper.GAMING_SQUARE_GAME_NAME,game_name);
                        // Toast.makeText(ct, game_id, Toast.LENGTH_SHORT).show();
                    }
                    else if(click_identity.equals(gamingSquareHelper.GAMING_SQAURE_EXCLUSIVES_PS)){
                        String game_id = gamingSquareExclusivesPSData.getListItem(getAdapterPosition()).getGame_Id();
                        String game_name = gamingSquareExclusivesPSData.getListItem(getAdapterPosition()).getGame_Name();
                        intent.putExtra(gamingSquareHelper.GAMING_SQAURE_GAME_INFO_GAME_ID,game_id);
                        intent.putExtra(gamingSquareHelper.GAMING_SQUARE_GAME_NAME,game_name);
                        // Toast.makeText(ct, game_id, Toast.LENGTH_SHORT).show();
                    }
                    else if(click_identity.equals(gamingSquareHelper.GAMING_SQAURE_EXCLUSIVES_XBOX)) {
                        String game_id = gamingSquareExclusivesXBOXData.getListItem(getAdapterPosition()).getGame_Id();
                        String game_name = gamingSquareExclusivesXBOXData.getListItem(getAdapterPosition()).getGame_Name();
                        intent.putExtra(gamingSquareHelper.GAMING_SQAURE_GAME_INFO_GAME_ID,game_id);
                        intent.putExtra(gamingSquareHelper.GAMING_SQUARE_GAME_NAME,game_name);
                        // Toast.makeText(ct, game_id, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        String game_id = gamingSquareYoutubersData.getListItem(getAdapterPosition()).getYoutuber_id();
                        String game_name = gamingSquareYoutubersData.getListItem(getAdapterPosition()).getYoutuber_name();
                        intent.putExtra(gamingSquareHelper.GAMING_SQAURE_GAME_INFO_GAME_ID,game_id);
                        intent.putExtra(gamingSquareHelper.GAMING_SQUARE_GAME_NAME,game_name);
                        // Toast.makeText(ct, game_id, Toast.LENGTH_SHORT).show();
                    }
                    ct.startActivity(intent);
                }
            });
        }
    }
}

