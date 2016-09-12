package cybodoc.garage.ModelClass;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pratheesh on 11-09-2016.
 */
public class Model
{
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Year> getYears() {
        return years;
    }

    public String getNiceName() {
        return niceName;
    }
@SerializedName("id")
    public String id;
    @SerializedName("name")
    public String name;
    @SerializedName("niceName")
    public String niceName;
    @SerializedName("years")
    public List<Year> years;
}

