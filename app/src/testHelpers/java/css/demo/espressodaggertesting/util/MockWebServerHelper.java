package css.demo.espressodaggertesting.util;

import java.io.IOException;

import css.demo.espressodaggertesting.MyApplication;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

public class MockWebServerHelper {

    public MockWebServer initMockWebServer() throws IOException {
        MockWebServer mockWebServer = new MockWebServer();
        mockWebServer.start();
        setBaseUrlToMockWebServer(mockWebServer);
        return mockWebServer;
    }

    /**
     * Change Retrofit's base url to the Mock Web Server provides us.
     */
    private void setBaseUrlToMockWebServer(MockWebServer mockWebServer) {
        MyApplication.component().baseUrlInterceptor().setBaseUrl((mockWebServer.url("").toString()));
    }

    public void enqueueErrorResponseForMockWebServer(MockWebServer mockWebServer, int restErrorCode) {
        mockWebServer.enqueue(new MockResponse().setStatus("HTTP/1.1 " + restErrorCode + " Boom!"));
    }

/*
    public void enqueueJsonResponseFromFileForMockWebServer(MockWebServer mockWebServer, String fileName) throws IOException {
        mockWebServer.enqueue(new MockResponse().setBody(loadJson(fileName)));
    }
*/

/*
    private String loadJson(String dummyJsonFileName) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(dummyJsonFileName);
        StringBuilder builder = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String line;
        while ((line = in.readLine()) != null) {
            builder.append(line);
        }
        in.close();
        return builder.toString();
    }

*/
}