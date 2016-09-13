package cybodoc.garage.ModelClass;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pratheesh on 13-09-2016.
 */
public class GalleryResponse {
    @SerializedName("subType")
    public String subType;

    public List<String> getPhotoSrcs() {
        return photoSrcs;
    }

    public String getSubType() {
        return subType;
    }

    @SerializedName("photoSrcs")

    public List<String> photoSrcs;
}
