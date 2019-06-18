package vn.hungho.androidhometest.app;

import vn.hungho.androidhometest.BuildConfig;
import vn.hungho.androidhometest.network.HttpHelper;


public class AppManager {
    private static HttpHelper httpApi = null;

    synchronized static public HttpHelper http_api() {
        if (httpApi == null) httpApi = new HttpHelper(BuildConfig.API_URL);
        return httpApi;
    }
}
