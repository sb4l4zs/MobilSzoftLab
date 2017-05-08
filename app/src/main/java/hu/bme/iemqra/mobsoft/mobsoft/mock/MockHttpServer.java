package hu.bme.iemqra.mobsoft.mobsoft.mock;

/**
 * Created by mobsoft on 2017. 05. 08..
 */

import hu.bme.iemqra.mobsoft.mobsoft.mock.interceptors.MockInterceptor;
import okhttp3.Request;
import okhttp3.Response;

public class MockHttpServer {
    public static Response call(Request request) {
        MockInterceptor mockInterceptor = new MockInterceptor();
        return mockInterceptor.process(request);
    }
}
