package cybodoc.garage.Api;

/**
 * Created by pratheesh on 11-09-2016.
 */


import cybodoc.garage.ModelClass.CarBrands;
import cybodoc.garage.ModelClass.Make;
import cybodoc.garage.ModelClass.StyleModelRootClass;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by pratheesh on 28-08-2016.
 */
public interface WebService {
   // /api/vehicle/v2/audi/a4/1996/styles?fmt=json&api_key=svddd53q99xzb75uetqf7dbh
    @GET("/api/vehicle/v2/makes")
    Call<CarBrands> getCarBrands(@Query("state") String state, @Query("view") String view, @Query("fmt") String fmt, @Query("api_key") String key);
    @GET("/api/vehicle/v2/{id}")
    Call<Make> getCarBrandModels(@Path("id") String niceName, @Query("state") String state, @Query("view") String view, @Query("fmt") String fmt, @Query("api_key") String key);
    @GET("/api/vehicle/v2/{make}/{model}/{year}/styles")
    Call<StyleModelRootClass> getCarModelStyles(@Path("make") String make,@Path("model") String model,@Path("year") int year, @Query("fmt") String fmt, @Query("api_key") String key);
}

