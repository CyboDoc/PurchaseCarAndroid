package cybodoc.garage.ModelClass;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pratheesh on 11-09-2016.
 */
public class Make  {
        @SerializedName("id")
        public int id;

    public int getId() {
        return id;
    }

    public List<Model> getModels() {
        return models;
    }

    public String getName() {
        return name;
    }

    public String getNiceName() {
        return niceName;
    }
@SerializedName("name")
    public String name;
    @SerializedName("niceName")
        public String niceName;
    @SerializedName("models")
        public List<Model> models;

}
