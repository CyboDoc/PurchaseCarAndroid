package cybodoc.garage.Activity;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import cybodoc.carpurchase.R;
import cybodoc.garage.Api.UserApi;
import cybodoc.garage.Utils.utils;

public class ListCarBrandsActivity extends AppCompatActivity {
    public RecyclerView.LayoutManager layoutManager;
    public RecyclerView recyclerView;
    public Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_car_brands);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("CAR BRANDS");
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Roboto-Bold.ttf");
        mTitle.setTypeface(custom_font);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_brands);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
       checkConnection(ListCarBrandsActivity.this, getWindow().getDecorView().getRootView());
callApi();

    }

    private void callApi() {
        UserApi userApi=new UserApi(this);
        userApi.ListCarBrands(recyclerView, R.layout.brands_row_layout,getWindow().getDecorView().getRootView().findViewById(R.id.coordinate_car_brands));
    }

    private void checkConnection(final Context context,final View view) {
        if(utils.checkConnectivity(context)) {
            callApi();
        }
        else
        {
            snackbar= utils.showSnackBar(view);
            snackbar.setAction("Try Again", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkConnection(context,view);

                }
            }).show();
        }
    }

}

