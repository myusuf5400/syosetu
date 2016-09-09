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
import org.jsoup.Jsoup;

/**
 *
 * @author doll
 */
public class Sender {
    public void doSender(){
        try {
//            String token;
            
            Connection connection = Jsoup.connect("http://localhost/postNovel");
            
//            token = connection.ignoreContentType(true).execute().body().replaceAll("\"", "");
//            
            System.out.println(connection.data("pesan","Hallo").method(Connection.Method.POST).execute().parse());
        } catch (IOException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
