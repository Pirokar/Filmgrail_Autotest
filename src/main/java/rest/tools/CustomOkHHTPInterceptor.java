package rest.tools;

import model.APIHelper;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Vladimir on 13.07.2016.
 */
public class CustomOkHHTPInterceptor {
    private static final int CONNECT_TIMEOUT_MILLIS = 15000;
    private static final int READ_TIMEOUT_MILLIS = 15000;
    private static final int WRITE_TIMEOUT_MILLIS = 15000;

    public static OkHttpClient getCustomOKHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .writeTimeout(WRITE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .readTimeout(READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .addInterceptor(new Interceptor() {

                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        Request request = chain.request();
                        Request requestWithUserAgent = request.newBuilder()
                                .header("User-Agent", getAppInfo())
                                .build();

                        return chain.proceed(requestWithUserAgent);
                    }
                })
                .build();
    }

    private static String getAppInfo() {
        return "Filmgrail" + ", Api version: " + APIHelper.API_VERSION + " (" + "Autotest" + "; " +
                "Android version: " + "Autotest"
                + ", App version: " + "Autotest" + ").";
    }
}
