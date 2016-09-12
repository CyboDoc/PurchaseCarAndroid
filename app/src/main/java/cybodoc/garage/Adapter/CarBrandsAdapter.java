package cybodoc.garage.Adapter;

/**
 * Created by pratheesh on 11-09-2016.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cybodoc.carpurchase.R;
import cybodoc.garage.Activity.CarBrandModelsActivity;
import cybodoc.garage.ModelClass.Make;



public class CarBrandsAdapter extends RecyclerView.Adapter<CarBrandsAdapter.DetailsViewHolder> {

    public List<Make> makes;
    public int rowLayout;

    public Context context;

    public CarBrandsAdapter(List<Make> makes, int rowLayout, Context context) {
        this.makes =makes;
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
        holder.brandName.setText(makes.get(position).getName());

//        Picasso.with(context)
//                .load("http://" + events.get(position).getLink())
//                .placeholder(R.drawable.logo)
//                .error(R.drawable.logo)
//                .resize(150, 150)
//                .into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(v.getContext(),CarBrandModelsActivity.class);
                intent.putExtra("BrandNiceName",makes.get(position).getNiceName());
                intent.putExtra("NoOfModels",makes.get(position).getModels().size());
                intent.putExtra("BrandName",makes.get(position).getName());
                v.getContext().startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return makes.size();
    }


    public static class DetailsViewHolder extends RecyclerView.ViewHolder {

        private TextView brandName;
        public DetailsViewHolder(View itemview) {
            super(itemview);
            brandName = (TextView) itemview.findViewById(R.id.brand_name);

        }
    }
}




