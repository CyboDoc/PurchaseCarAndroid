package cybodoc.garage.ModelClass;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pratheesh on 12-09-2016.
 */
public class StyleModel
{
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
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
}
