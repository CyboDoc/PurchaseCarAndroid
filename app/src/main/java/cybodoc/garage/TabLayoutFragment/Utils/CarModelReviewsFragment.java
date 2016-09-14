package cybodoc.garage.TabLayoutFragment.Utils;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cybodoc.carpurchase.R;
import cybodoc.garage.Api.UserApi;
import cybodoc.garage.Utils.utils;


/**
 * Created by pratheesh on 10-09-2016.
 */
public class CarModelReviewsFragment extends Fragment {
    public Snackbar snackbar;
    public CarModelReviewsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.car_model_reviews_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

      checkConnection(getContext(),view.getRootView().findViewById(R.id.coordinate_description));




    }

    private void callApi() {
        UserApi userApi=new UserApi(getContext());
        userApi.ListCarReviews(getView());
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
