package com.company;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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

            Scanner scan = new Scanner(new FileInputStream(str_arr[i]));
            int line_count = 0;
            int words_count = 0;
            while (scan.hasNextLine()) {
                line_count++;
                String[] array = scan.nextLine().split("\\s*(\\s|,|\\.!)\\s*");
                words_count = words_count + array.length;
            }

            System.out.println("File: " + str_arr[i] + " - " + line_count + " lines" + " and " + words_count + " words");

            scan.close();
        }
        reader.close();
    }
}
