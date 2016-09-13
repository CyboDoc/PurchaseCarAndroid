package cybodoc.garage.Adapter;

/**
 * Created by pratheesh on 12-09-2016.
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
import cybodoc.garage.ModelClass.Style;
import cybodoc.garage.Utils.SharedPreference;


public class CarStylesAdapter extends RecyclerView.Adapter<CarStylesAdapter.DetailsViewHolder> {

    public List<Style> styles;
    public int rowLayout;

    public Context context;

    public CarStylesAdapter(List<Style> styles, int rowLayout, Context context) {
        this.styles =styles;
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
        holder.modelName.setText(styles.get(position).getSubmodel().getModelName());
        holder.styleName.setText(styles.get(position).getName());
        holder.trim.setText(styles.get(position).getTrim());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                SharedPreference.setStyleId(context, styles.get(position).getId());
                Intent intent= new Intent(v.getContext(),CarModelDescriptionActivity.class);
              intent.putExtra("ModelId",styles.get(position).getSubmodel().getModelName());
//                intent.putExtra("BrandName",makes.get(position).getName());
                v.getContext().startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return styles.size();
    }


    public static class DetailsViewHolder extends RecyclerView.ViewHolder {

        private TextView modelName,styleName,trim;
        public DetailsViewHolder(View itemview) {
            super(itemview);
            modelName = (TextView) itemview.findViewById(R.id.style_model_name);
            styleName = (TextView) itemview.findViewById(R.id.style_name);
            trim= (TextView) itemview.findViewById(R.id.trim_content);


        }
    }
}
