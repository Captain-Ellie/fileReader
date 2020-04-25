package com.company;
import java.io.IOException;
import java.io.*;

public class Main {

    public static void main(String[] args) {

       try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
           System.out.print("Enter the path to your folder: ");
           String dir_path = reader.readLine() + "\\";
           File folder = new File(dir_path);
           File[] listOfFiles = folder.listFiles();
           assert listOfFiles != null;
           int count = listOfFiles.length;
           String[] str_arr = new String[count];
           for (int i = 0; i < count; i++) {
               if (listOfFiles[i].isFile()) {
                   str_arr[i] = dir_path + listOfFiles[i].getName();
               }

               try (BufferedReader scan = new BufferedReader(new FileReader(str_arr[i]))) {
                   int line_count = 0;
                   int words_count = 0;
                   FileReader fileReader = new FileReader(str_arr[i]);
                   LineNumberReader lineNumReader = new LineNumberReader(fileReader);
                   while ((lineNumReader.readLine()) != null) {
                       line_count++;
                       words_count += scan.readLine().split("\\s*(\\s|,|\\.!)\\s*").length;
                   }
                   System.out.println("File: " + str_arr[i] + " - " + line_count + " lines" + " and "
                           + words_count + " words");

               }catch (FileNotFoundException ex) {
                   ex.printStackTrace();
               }
           }
       }catch (IOException ex) {
           ex.printStackTrace();
       }
    }
}
