package cybodoc.garage.ModelClass;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pratheesh on 11-09-2016.
 */
public class Year
{
    @SerializedName("id")
    public int id;

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }
@SerializedName("year")
    public int year;
}
