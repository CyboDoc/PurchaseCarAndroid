package cybodoc.garage.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by pratheesh on 12-09-2016.
 */
public class SharedPreference {
    public static String getMakeNiceName(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREFERENCE_KEY, Context.MODE_PRIVATE);
        return sharedPreferences.getString(Constants.MAKE_NICE_NAME, null);
    }
    public static void setMakeNiceName(Context context,String makeNiceName) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREFERENCE_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.MAKE_NICE_NAME,makeNiceName);
        editor.apply();
    }
    public static String getModelNiceName(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREFERENCE_KEY, Context.MODE_PRIVATE);
        return sharedPreferences.getString(Constants.MODEL_NICE_NAME, null);
    }
    public static void setModelNiceName(Context context,String modelNiceName) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREFERENCE_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.MODEL_NICE_NAME, modelNiceName);
        editor.apply();
    }
    public static int getStyleId(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREFERENCE_KEY, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(Constants.STYLE_ID,0);
    }
    public static void setStyleId(Context context,int styleId) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREFERENCE_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.STYLE_ID,styleId);
        editor.apply();
    }
}
