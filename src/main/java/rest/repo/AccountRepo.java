package rest.repo;

import com.jakewharton.retrofit.Ok3Client;
import model.APIHelper;
import rest.AccountDataSource;
import rest.api.AccountAPI;
import rest.tools.CustomOkHHTPInterceptor;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;

/**
 * Created by Vladimir on 13.07.2016.
 * Presents Account repo
 */
public class AccountRepo implements AccountDataSource {
    private AccountAPI API;

    public AccountRepo() {
        API = createAdapter();
    }

    public void getGenresPreferencesForSelect(String token, Callback<String[]> callback) {
        API.getOnboardingGenres(token, callback);
    }

    private AccountAPI createAdapter() {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(APIHelper.BASE_URL)
                .setRequestInterceptor(APIHelper.HEADER)
                .setClient(
                        new Ok3Client(CustomOkHHTPInterceptor.getCustomOKHttpClient()))
                .setLogLevel(RestAdapter.LogLevel.FULL).setLog(new AndroidLog("Retrofit_LOG"))
                .build();

        return adapter.create(AccountAPI.class);
    }
}
