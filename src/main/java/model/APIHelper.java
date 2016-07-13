package model;

import retrofit.RequestInterceptor;

/**
 * Created by Vladimir on 13.07.2016.
 */
public class APIHelper {
    public static final String TOKEN_KEY = "X-Token";

    public static final String API_VERSION_FOR_REQUEST = "apiv2_9";

    public static final String DEV_API_URL = "http://apidev.filmgrail.com/";

    public static String BASE_URL = DEV_API_URL + API_VERSION_FOR_REQUEST;

    public static final String PICTURE_PATH = BASE_URL + "/User/GetPhoto/";

    public static final String PICTURE_PATH_SMALL = BASE_URL + "/User/GetSmallPhoto/";

    public static final String API_CHECK_HEADER_KEY = "API-Version";

    public static final String API_VERSION = "2.9";

    public static String authToken = "";

    public static final RequestInterceptor HEADER = new RequestInterceptor() {
        public void intercept(RequestFacade request) {
            request.addHeader(API_CHECK_HEADER_KEY, API_VERSION);
            request.addHeader("Locale", "en");
        }
    };

}
