package cybodoc.garage.Activity;

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

public class CarBrandModelsActivity extends AppCompatActivity {
    public RecyclerView.LayoutManager layoutManager;
    public RecyclerView recyclerView;
    public Snackbar snackbar;
    public String brandNiceName,brandName;
    public int noOfModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_brand_models);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        brandNiceName=getIntent().getExtras().getString("BrandNiceName");
        brandName=getIntent().getExtras().getString("BrandName");
        noOfModels=getIntent().getExtras().getInt("NoOfModels");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText(brandName + " MODELS" + "(" + String.valueOf(noOfModels) + ")");
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Roboto-Bold.ttf");
        mTitle.setTypeface(custom_font);
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        recyclerView = (RecyclerView)findViewById(R.id.recycler_brands_models);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
       callApi();
    }

    private void callApi() {
        UserApi userApi = new UserApi(this);
        userApi.ListCarBrandModels(brandNiceName, recyclerView, R.layout.brands_row_layout,getWindow().getDecorView().getRootView().findViewById(R.id.coordinate_car_brand_models));
    }

}
