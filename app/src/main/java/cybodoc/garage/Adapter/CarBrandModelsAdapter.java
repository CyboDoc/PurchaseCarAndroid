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
import cybodoc.garage.Activity.CarModelDescriptionActivity;
import cybodoc.garage.ModelClass.Model;



public class CarBrandModelsAdapter extends RecyclerView.Adapter<CarBrandModelsAdapter.DetailsViewHolder> {

    public List<Model> models;
    public int rowLayout;

    public Context context;

    public CarBrandModelsAdapter(List<Model> models, int rowLayout, Context context) {
        this.models =models;
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
        holder.brandName.setText(models.get(position).getId());

//        Picasso.with(context)
//                .load("http://" + events.get(position).getLink())
//                .placeholder(R.drawable.logo)
//                .error(R.drawable.logo)
//                .resize(150, 150)
//                .into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                Intent intent= new Intent(v.getContext(),CarModelDescriptionActivity.class);
                intent.putExtra("ModelId", models.get(position).getId());
//                intent.putExtra("NoOfModels",makes.get(position).getModels().size());
//                intent.putExtra("BrandName",makes.get(position).getName());
                v.getContext().startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return models.size();
    }


    public static class DetailsViewHolder extends RecyclerView.ViewHolder {

        private TextView brandName;
        public DetailsViewHolder(View itemview) {
            super(itemview);
            brandName = (TextView) itemview.findViewById(R.id.brand_name);

        }
    }
}

