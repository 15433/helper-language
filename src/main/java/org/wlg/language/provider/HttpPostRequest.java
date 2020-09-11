package org.wlg.language.provider;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * post 请求
 * @author 11838
 */
public class HttpPostRequest {
    private static final Logger logger = LoggerFactory.getLogger(HttpPostRequest.class);

    /**
     * post 请求 map装填
     *
     * @param url
     * @param reqContent
     * @return
     * @throws IOException
     */
    public static String doPostStr(String url, Map<String, String> reqContent) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            //装填参数
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            if (reqContent != null) {
                for (Map.Entry<String, String> entry : reqContent.entrySet()) {
                    nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
            }
            //设置参数到请求对象中
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));

            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity, "UTF-8");
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return null;
    }
}
