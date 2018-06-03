package com.example;

import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.SqlJetTransactionMode;
import org.tmatesoft.sqljet.core.table.ISqlJetCursor;
import org.tmatesoft.sqljet.core.table.ISqlJetTable;
import org.tmatesoft.sqljet.core.table.SqlJetDb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import sun.rmi.runtime.Log;

public class MyClass {

    public static void main(String [ ] args) throws SqlJetException, IOException {

        File dbFile = new File("mydb");
        dbFile.delete();
        SqlJetDb db = SqlJetDb.open(dbFile, true);
      //took out a lot..

   //     db.createTable("CREATE TABLE IF NOT EXISTS Bible(Book VARCHAR,Chapter VARCHAR,Verse VARCHAR,Text VARCHAR);");
//        db.beginTransaction(SqlJetTransactionMode.WRITE);

        InputStream instream = null;

        try {

          //dont know about this
          //  ISqlJetTable table = db.getTable("Bible");

            //table.insert("Prochaskova", "Elena", "third","fourth");

            //instream = new FileInputStream("myfilename.txt");
            instream = new FileInputStream("E:\\Google Drive\\Programming\\Av7 Bible App\\AV7x");

            InputStreamReader inputreader = new InputStreamReader(instream);
            BufferedReader buffreader = new BufferedReader(inputreader);

            FileOutputStream fos = new FileOutputStream("E:\\Google Drive\\Programming\\Av7 Bible App\\AV7xoutput");

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            String line;
            String book = "";
            String chapter = "";
            String verse = "";
            String text = "";
          //  String bookOrder = "1";

            //Write Field names
            bw.write("Book|Chapter|Verse|Text|BookOrder");
            bw.newLine();
            // read every line of the file into the line-variable, on line at the time
         while ((line = buffreader.readLine()) != null)
        {

                //handle apostrophe in Bible text
                if (line != null && line.contains("'")) {
                    line = line.replace("'", "\\'");
                }

            System.out.println("Line: "+line);

                book = line.substring(2, line.indexOf("-"));
                chapter = line.substring(line.indexOf("-") + 1, line.indexOf(":"));
                verse = line.substring(line.indexOf(":") + 1, line.indexOf(" "));
                text = line.substring(line.indexOf(" ")+1, line.length());

              /*  System.out.println(book);
                System.out.println(chapter);
                System.out.println(verse);
                System.out.println(text);
                */

                //mydatabase.execSQL("INSERT INTO Bible VALUES('" + book + "','" + chapter + "','" + verse + "','" + text + "');");
               // table.insert(book, chapter, verse, text);0
            if(verse.equals("00")){
                verse = "";
                text = "<h1>"+text+"</h1>";
            }
            else if(verse.substring(0,1).equals("0")) {
                //verse = "<div id='verseNumber'>"+verse.substring(1,verse.length()) + "</div>";
                verse = verse.substring(1,verse.length());
            }

            //Add Chapter Title Styling
            if(text.contains("Chapter")){
              //  text = "<h1>"+text+"</h1>";
            }

            if(text.contains("[")) {
               text = text.replace("[", "<span class=\"T2\">");
              text = text.replace("]", "</span>");
            }

            if(text.contains("\\")) {

                text = text.replace("\\", "");
            }

            if(text.contains("+")) {
              text =  text.replace("+","<sup>+</sup>");
            }



          //  bw.write(book+"|"+chapter+"|"+verse+"|"+text+"|"+bookOrder);
            bw.write(book+"|"+chapter+"|"+verse+"|"+text);
            bw.newLine();
            }
            instream.close();
            bw.close();

//            ISqlJetCursor cursor = table.open();
  //          printRecords(cursor);

        }
        finally {    db.commit();  }






        /*
        //////////////////////////////////////////////////////////////////////////////////////



        InputStream instream = null;
        try {
// open the file for reading
            //instream = new FileInputStream("myfilename.txt");
            instream = this.getAssets().open("Database/AV7x");

// if file the available for reading
            if (instream != null) {
                // prepare the file for reading
                InputStreamReader inputreader = new InputStreamReader(instream);
                BufferedReader buffreader = new BufferedReader(inputreader);

                String line;

                // read every line of the file into the line-variable, on line at the time
                do {
                    line = buffreader.readLine();
                    //handle apostrophe in Bible text
                    line = line.replace("'", "''");

                    book = line.substring(2, line.indexOf("-"));
                    chapter = line.substring(line.indexOf("-") + 1, line.indexOf(":"));
                    verse = line.substring(line.indexOf(":") + 1, line.indexOf(" "));
                    text = line.substring(line.indexOf(" "), line.length() - 1);

                    Log.i("info1234", chapter);
                    Log.i("info1234", verse);
                    Log.i("info1234", text);

                    mydatabase.execSQL("INSERT INTO Bible VALUES('" + book + "','" + chapter + "','" + verse + "','" + text + "');");
                } while (line != null);
                instream.close();
            }
        } catch (Exception ex) {
            // print stack trace.
        }
*/
    }

    private static void printRecords(ISqlJetCursor cursor) throws SqlJetException {
        try {
            if (!cursor.eof()) {
                do {
                    System.out.println("Row: " +cursor.getRowId() + " : " + cursor.getString("Book") + " " + cursor.getString("Chapter")  + " " + cursor.getString("Verse")  + " " + cursor.getString("Text") );
                } while (cursor.next());
            }
        } finally {
            cursor.close();
        }
    }
}
