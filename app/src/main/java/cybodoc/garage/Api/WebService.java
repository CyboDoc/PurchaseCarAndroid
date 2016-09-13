package cybodoc.garage.Api;

/**
 * Created by pratheesh on 11-09-2016.
 */


import java.util.List;

import cybodoc.garage.Adapter.PriceResponse;
import cybodoc.garage.ModelClass.CarBrands;
import cybodoc.garage.ModelClass.GalleryResponse;
import cybodoc.garage.ModelClass.Make;
import cybodoc.garage.ModelClass.SpecsResponse;
import cybodoc.garage.ModelClass.StyleModelRootClass;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by pratheesh on 28-08-2016.
 */
public interface WebService {
//    https://api.edmunds.com/v1/api/tco/newtotalcashpricebystyleidandzip/101426944/90019?fmt=json&api_key={api key}

    @GET("/api/vehicle/v2/makes")
    Call<CarBrands> getCarBrands(@Query("state") String state, @Query("view") String view, @Query("fmt") String fmt, @Query("api_key") String key);

    @GET("/api/vehicle/v2/{id}")
    Call<Make> getCarBrandModels(@Path("id") String niceName, @Query("state") String state, @Query("view") String view, @Query("fmt") String fmt, @Query("api_key") String key);

    @GET("/api/vehicle/v2/{make}/{model}/{year}/styles")
    Call<StyleModelRootClass> getCarModelStyles(@Path("make") String make, @Path("model") String model, @Path("year") int year, @Query("fmt") String fmt, @Query("api_key") String key);

    @GET("/v1/api/vehiclephoto/service/findphotosbystyleid")
    Call<List<GalleryResponse>> getImages(@Query("styleId") int styleId, @Query("fmt") String fmt, @Query("api_key") String key);

    @GET("/v1/api/tco/newtotalcashpricebystyleidandzip/{styleId}/90019")
    Call<PriceResponse> getPrice(@Path("styleId")int styleId,@Query("fmt") String fmt, @Query("api_key") String key);
    @GET("/api/vehicle/v2/styles/{styleId}/engines")
    Call<SpecsResponse> getSpecsDetails(@Path("styleId")int styleId, @Query("fmt") String fmt, @Query("api_key") String key);
}

