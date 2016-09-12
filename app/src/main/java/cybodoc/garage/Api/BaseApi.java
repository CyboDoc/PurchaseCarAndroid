package cybodoc.garage.Api;

/**
 * Created by pratheesh on 11-09-2016.
 */

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by user on 4/7/16.
 */
public class BaseApi {

    public Retrofit retrofit;
    public WebService webservice;
    public Context context1;

    public BaseApi(String BASE_URL) {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webservice = retrofit.create(WebService.class);
    }

}
