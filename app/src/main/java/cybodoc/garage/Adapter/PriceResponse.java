package cybodoc.garage.Adapter;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pratheesh on 13-09-2016.
 */
public class PriceResponse {
    @SerializedName("value")
    public String value;

    public String getValue() {
        return value;
    }
}
