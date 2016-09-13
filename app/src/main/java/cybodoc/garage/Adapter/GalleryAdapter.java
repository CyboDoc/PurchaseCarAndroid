package cybodoc.garage.Adapter;

/**
 * Created by pratheesh on 13-09-2016.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import cybodoc.carpurchase.R;
import cybodoc.garage.ModelClass.GalleryResponse;


public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.DetailsViewHolder> {

    public List<GalleryResponse> images;
    public int rowLayout;

    public Context context;

    public GalleryAdapter(List<GalleryResponse> images, int rowLayout, Context context) {
        this.images =images;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public DetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        //    BeaconViewHolder beaconViewHolder = new BeaconViewHolder(view);
        return new DetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailsViewHolder holder, final int position) {

       Picasso.with(context)
               .load("https://media.ed.edmunds-media.com" + images.get(position).getPhotoSrcs().get(2))
                .resize(800, 800)
                .into(holder.imageView);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SharedPreference.setModelNiceName(context, models.get(position).getNiceName());
//                Intent intent = new Intent(v.getContext(), StylesActivity.class);
////                intent.putExtra("NoOfModels",makes.get(position).getModels().size());
////                intent.putExtra("BrandName",makes.get(position).getName());
//                v.getContext().startActivity(intent);
//
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return images.size();
    }


    public static class DetailsViewHolder extends RecyclerView.ViewHolder {

        private TextView imageTitle;
        public ImageView imageView;
        public DetailsViewHolder(View itemview) {
            super(itemview);
imageView=(ImageView)itemview.findViewById(R.id.gallery_image);
        }
    }
}
