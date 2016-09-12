package cybodoc.garage.ModelClass;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pratheesh on 12-09-2016.
 */
public class Submodel
{
    public String getBody() {
        return body;
    }

    public String getModelName() {
        return modelName;
    }

    public String getNiceName() {
        return niceName;
    }

    @SerializedName("body")
    public String body;
    @SerializedName("modelName")
    public String modelName;
    @SerializedName("niceName")
    public String niceName;
}
