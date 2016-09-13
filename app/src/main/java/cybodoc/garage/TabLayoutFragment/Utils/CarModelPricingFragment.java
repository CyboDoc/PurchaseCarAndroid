package cybodoc.garage.TabLayoutFragment.Utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cybodoc.carpurchase.R;
import cybodoc.garage.Api.UserApi;


/**
 * Created by pratheesh on 10-09-2016.
 */
public class CarModelPricingFragment extends Fragment {
    public CarModelPricingFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.car_model_pricing_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        callApi();
    }
    private void callApi() {
        UserApi userApi = new UserApi(getContext());
        userApi.getPriceDetails( getView());
    }
}
