/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syosetu;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author doll
 */
public class Syosetu {

    private static ArrayList<Chapter> chapters = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        getListChapter("http://novel18.syosetu.com/n8383bs");

//        Sender sender = new Sender();
//        sender.doSender();
        for (Chapter chapter : chapters) {
            try {
                //            System.out.println(chapter.toString());
                chapter.doWrite();
            } catch (IOException ex) {
                Logger.getLogger(Syosetu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void getListChapter(String url) {
        Downloader download = new Downloader(url);

        Document document = null;
        try {
            document = (Document) download.doDownload().parse();
        } catch (IOException ex) {
            Logger.getLogger(Syosetu.class.getName()).log(Level.SEVERE, null, ex);
        }

        Elements elements = document.select("dl.novel_sublist2");
        for (Element element : elements) {
            Chapter chapter = new Chapter();
            chapter.setTitle(element.select("a").text());
            chapter.setLink(element.select("a").attr("abs:href"));
            chapter.setDate(parseDate(element.select("dt").text()));
            chapter.setText(getChapter(element.select("a").attr("abs:href")));
            chapters.add(chapter);
        }

    }

    public static String getChapter(String url) {
        Downloader download = new Downloader(url);

        Document document = null;
        try {
            document = (Document) download.doDownload().parse();
        } catch (IOException ex) {
            Logger.getLogger(Syosetu.class.getName()).log(Level.SEVERE, null, ex);
        }

        Elements elements = document.getElementsByClass("novel_view");
        return elements.toString();
    }

    public static String parseDate(String date) {
        date = date.replaceAll("[^0-9 ]", "");

        return date;
    }

}
