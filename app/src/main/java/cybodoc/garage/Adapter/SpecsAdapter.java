package cybodoc.garage.Adapter;

/**
 * Created by pratheesh on 13-09-2016.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cybodoc.carpurchase.R;
import cybodoc.garage.ModelClass.Engine;


public class SpecsAdapter extends RecyclerView.Adapter<SpecsAdapter.DetailsViewHolder> {

    public List<Engine> specs;
    public int rowLayout;

    public Context context;

    public SpecsAdapter(List<Engine> specs, int rowLayout, Context context) {
        this.specs =specs;
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
        holder.compressionType.setText(specs.get(position).getCompressorType());
        holder.compressionRatio.setText(String.valueOf(specs.get(position).getCompressionRatio()));
        holder.equipment.setText(specs.get(position).getEquipmentType());
        holder.cylinder.setText(String.valueOf(specs.get(position).getCylinder()));
        holder.fuelType.setText(specs.get(position).getFuelType());
        holder.horsePower.setText(String.valueOf(specs.get(position).getHorsepower()));
        holder.torque.setText(String.valueOf(specs.get(position).getTorque()));
        holder.type.setText(specs.get(position).getType());




    }

    @Override
    public int getItemCount() {
        return specs.size();
    }


    public static class DetailsViewHolder extends RecyclerView.ViewHolder {

        public TextView equipment,compressionRatio,cylinder,fuelType,horsePower,torque,type,compressionType;
        public DetailsViewHolder(View itemview) {
            super(itemview);
            equipment = (TextView) itemview.findViewById(R.id.equipment_content);
            compressionRatio = (TextView) itemview.findViewById(R.id.compression_ratio_content);
            cylinder = (TextView) itemview.findViewById(R.id.cylinder_content);
            fuelType = (TextView) itemview.findViewById(R.id.fuel_type_content);
            horsePower = (TextView) itemview.findViewById(R.id.horse_power_content);
            torque = (TextView) itemview.findViewById(R.id.torque_content);
            type = (TextView) itemview.findViewById(R.id.type_content);
            compressionType = (TextView) itemview.findViewById(R.id.compressorType_content);











        }
    }
}
