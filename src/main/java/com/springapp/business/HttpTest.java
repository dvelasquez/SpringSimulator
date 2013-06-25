package com.springapp.business;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created with IntelliJ IDEA.
 * User: Noize
 * Date: 25-06-13
 * Time: 12:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class HttpTest {

    public static String htmlReturn() throws URISyntaxException {
        URIBuilder builder = new URIBuilder();
        builder.setScheme("http").setHost("www.google.com").setPath("/search")
                .setParameter("q", "httpclient")
                .setParameter("btnG", "Google Search")
                .setParameter("aq", "f")
                .setParameter("oq", "");
        URI uri = builder.build();
        HttpGet httpget = new HttpGet(uri);
        return String.valueOf(httpget.getURI());
    }

    public static String httpTest() throws IOException, URISyntaxException {
        String returned = null;
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(htmlReturn());
        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        //EntityUtils.consume(entity);
        //Esta linea parsea el contenido a un string.
        String body = IOUtils.toString(entity.getContent(), "UTF-8");
        if (entity != null) {
            InputStream instream = entity.getContent();
            try {
                // do something useful
                returned = instream.toString();
            } finally {
                instream.close();
            }
        }

        return body;
    }

    //TODO: Investigar como hacer un post.

}
