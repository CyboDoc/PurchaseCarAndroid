package cybodoc.garage.Activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import cybodoc.carpurchase.R;
import cybodoc.garage.Api.UserApi;

public class StylesActivity extends AppCompatActivity {
public Spinner spinner;
    public RecyclerView.LayoutManager layoutManager;
    public RecyclerView recyclerView;
    public Snackbar snackbar;
    public int year;
    public Button Submit;
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
        Submit=(Button)findViewById(R.id.Style_submit);
        recyclerView = (RecyclerView)findViewById(R.id.style_recycler);
        //layoutManager = new LinearLayoutManager(getApplicationContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        year=Integer.parseInt(spinner.getSelectedItem().toString());
        callApi();
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year=Integer.parseInt(spinner.getSelectedItem().toString());
                callApi();
            }
        });
    }
    private void callApi() {
        UserApi userApi = new UserApi(this);
        userApi.ListCarBrandModelStyles(year,recyclerView, R.layout.style_row_layout, getWindow().getDecorView().getRootView());
    }
}