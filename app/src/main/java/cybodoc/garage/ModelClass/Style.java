package cybodoc.garage.ModelClass;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pratheesh on 12-09-2016.
 */
public class Style

{
    public StyleMake getMake() {
        return make;
    }

    public StyleModel getModel() {
        return model;
    }

    public String getName() {
        return name;
    }

    public Submodel getSubmodel() {
        return submodel;
    }

    public String getTrim() {
        return trim;
    }

    public Year getYear() {
        return year;
    }

    @SerializedName("make")
    public StyleMake make;

    public int getId() {
        return id;
    }

    @SerializedName("model")
    public StyleModel model;
    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("year")
    public Year year;
    @SerializedName("submodel")
    public Submodel submodel;
    @SerializedName("trim")
    public String trim;
}