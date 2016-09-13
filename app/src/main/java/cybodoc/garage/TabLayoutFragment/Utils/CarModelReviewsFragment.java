package cybodoc.garage.TabLayoutFragment.Utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cybodoc.carpurchase.R;
import cybodoc.garage.Api.UserApi;


/**
 * Created by pratheesh on 10-09-2016.
 */
public class CarModelReviewsFragment extends Fragment {
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
        TextView pros,cons,body,whatsnew,safety;
        pros=(TextView)getView().findViewById(R.id.pros);
        cons=(TextView)getView().findViewById(R.id.cons);
        body=(TextView)getView().findViewById(R.id.body);
        whatsnew=(TextView)getView().findViewById(R.id.whatsnew);
        safety=(TextView)getView().findViewById(R.id.safety);

        UserApi userApi=new UserApi(getContext());
        userApi.ListCarReviews(getView());




    }
}
