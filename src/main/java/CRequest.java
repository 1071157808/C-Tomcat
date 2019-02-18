import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yepeng on 2019/02/18.
 */
public class CRequest {
    private String url;
    private String method;

    public CRequest(InputStream inputStream) throws IOException {
        String httpRequest = "";
        byte[] httpRequestBytes = new byte[1024];
        int length = 0;
        if ((length = inputStream.read(httpRequestBytes)) > 0) {
            httpRequest = new String(httpRequestBytes, 0, length);
        }

        String httpHeader = httpRequest.split("\n")[0];
        url = httpHeader.split("\\s")[1];
        method = httpHeader.split("\\s")[0];
        System.out.println(this);
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }
}
