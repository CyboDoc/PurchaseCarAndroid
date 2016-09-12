package cybodoc.garage.ModelClass;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pratheesh on 12-09-2016.
 */
public class StyleModelRootClass {
    public int getStylesCount() {
        return stylesCount;
    }

    public List<Style> getStyles() {
        return styles;
    }

    @SerializedName("styles")
    public List<Style> styles;
    @SerializedName("stylesCount")
    public int stylesCount;
}
