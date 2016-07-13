package controllers;

import model.APIHelper;
import rest.repo.AccountRepo;
import retrofit.Callback;

/**
 * Created by Vladimir on 13.07.2016.
 */
public class GetGenresController {
    Callback<String[]> callback;

    public GetGenresController(Callback<String[]> callback) {
        this.callback = callback;
    }

    public void execute() {
        new AccountRepo().getGenresPreferencesForSelect(APIHelper.authToken, callback);
    }
}
