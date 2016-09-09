/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syosetu;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author doll
 */
public class Chapter {

    private String title;
    private String link;
    private String date;
    private String text;
    private boolean download;

    public Chapter() {
        download = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDownload() {
        return download;
    }

    public void setDownload(boolean download) {
        this.download = download;
    }

    @Override
    public String toString() {
        return "Chapter{" + "title=" + title + ", link=" + link + ", date=" + date + ", text=" + text + ", download=" + download + '}';
    }

    public void doWrite() throws IOException {
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(getTitle()+".txt"), "utf-8"));
            {
                writer.write(getText().replaceAll("\\<[^>]*>","")
);

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Chapter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(Chapter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
