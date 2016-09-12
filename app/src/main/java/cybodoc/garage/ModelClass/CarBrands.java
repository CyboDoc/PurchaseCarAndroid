package cybodoc.garage.ModelClass;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pratheesh on 11-09-2016.
 */
public class CarBrands {
    @SerializedName("makes")
    public List<Make> makes;
    @SerializedName("makesCount")
    public int makesCount;
    public List<Make> getMakes() {
        return makes;
    }

    public int getMakesCount() {
        return makesCount;
    }
}
