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
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import cybodoc.carpurchase.R;
import cybodoc.garage.Api.UserApi;
import cybodoc.garage.Utils.SharedPreference;
import cybodoc.garage.Utils.utils;

public class StylesActivity extends AppCompatActivity {
public Spinner spinner;
    public RecyclerView.LayoutManager layoutManager;
    public RecyclerView recyclerView;
    public Snackbar snackbar;
    public int year;
    public ImageButton Submit;
    public String ModelId,MakeId;
    public TextView Model,Make;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_styles);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("STYLES");
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Roboto-Bold.ttf");
        mTitle.setTypeface(custom_font);
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        spinner=(Spinner)findViewById(R.id.spinner_year);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_item,R.layout.spinner_layout);
        spinner.setAdapter(adapter);
        adapter.setDropDownViewResource(R.layout.spinner_drop_down_layout);
        Submit=(ImageButton)findViewById(R.id.Style_submit);
        recyclerView = (RecyclerView)findViewById(R.id.style_recycler);
        //layoutManager = new LinearLayoutManager(getApplicationContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        year=Integer.parseInt(spinner.getSelectedItem().toString());
        SharedPreference.setYear(getApplicationContext(),year);
        checkConnection(getApplicationContext(), getWindow().getDecorView().getRootView());
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year = Integer.parseInt(spinner.getSelectedItem().toString());
                SharedPreference.setYear(getApplicationContext(),year);
                callApi();
            }
        });
    }
    private void callApi() {
        UserApi userApi = new UserApi(this);
        userApi.ListCarBrandModelStyles(year,recyclerView, R.layout.style_row_layout, getWindow().getDecorView().getRootView());
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
