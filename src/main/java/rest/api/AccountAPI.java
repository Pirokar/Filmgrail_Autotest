package rest.api;

import model.APIHelper;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Header;

/**
 * Created by Vladimir on 13.07.2016.
 */
public interface AccountAPI {
    @GET("/Account/GetGenresPreferencesForSelect")
    void getOnboardingGenres(
            @Header(APIHelper.TOKEN_KEY) String token,
            Callback<String[]> callback
    );
}
