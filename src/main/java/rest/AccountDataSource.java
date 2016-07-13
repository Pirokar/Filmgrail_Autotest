package rest;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import retrofit.Callback;
import retrofit.mime.TypedFile;

/**
 * Created by Vladimir on 13.07.2016.
 */
public interface AccountDataSource {
    void getGenresPreferencesForSelect(String token, Callback<String[]> callback);
}
