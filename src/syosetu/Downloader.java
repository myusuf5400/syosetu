/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syosetu;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

/**
 *
 * @author doll
 */
public class Downloader {

    private String url;
    private boolean novel18;

    public Downloader(String url) {
        this.url = url;
    }

    public Response doDownload() {
        
        checkNovel();
        
        Connection connection = Jsoup.connect(url);

        Response response = null;

        if (novel18) {
            try {
                response = connection.cookie("over18", "yes").execute();
            } catch (IOException ex) {
                Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                response = connection.execute();
            } catch (IOException ex) {
                Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return response;
    }

    public void checkNovel() {
        if (url.contains("http://novel18")) {
            novel18 = true;
        } else {
            novel18 = false;
        }
    }
}
