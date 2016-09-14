package cybodoc.garage.TabLayoutFragment.Utils;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cybodoc.carpurchase.R;
import cybodoc.garage.Api.UserApi;
import cybodoc.garage.Utils.utils;


/**
 * Created by pratheesh on 10-09-2016.
 */
public class CarModelSpecsDetailsFragment extends Fragment {
    public RecyclerView.LayoutManager layoutManager;
    public RecyclerView recyclerView;
    public Snackbar snackbar;
    public CarModelSpecsDetailsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.car_model_specs_details_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView)getView().findViewById(R.id.recycler_specs);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        checkConnection(getContext(), view.getRootView().findViewById(R.id.coordinate_description));
    }
    private void callApi() {
        UserApi userApi = new UserApi(getContext());
        userApi.getSpecDetails(recyclerView, R.layout.specs_row_layout, getView());
    }
    private void checkConnection(final Context context,final View view) {
        if(utils.checkConnectivity(context)) {
            callApi();
        }
        else
        {
            snackbar=utils.showSnackBar(view);
            snackbar.setAction("Try Again", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkConnection(context,view);

                }
            }).show();
        }
    }
}
