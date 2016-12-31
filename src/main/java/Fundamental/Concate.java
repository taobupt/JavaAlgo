package Fundamental;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Created by Tao on 12/31/2016.
 */
public class Concate {

    final int buffersize = 1024;

    public Concate() {

    }

    public void concate(String[] filenames, String desFileName) {

        try {
            OutputStream out = new FileOutputStream(desFileName);
            final byte[] buffer = new byte[buffersize];
            int numberRead = 0;
            for (String filename : filenames) {
                InputStream in = new FileInputStream(filename);
                while ((numberRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, numberRead);
                }
                out.write(System.getProperty("line.separator").getBytes());
                in.close();

            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //as for the plain text you can use character stream
    public void concatePlainText(String[] filenames, String desFileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(desFileName));
            //StringBuffer buffer=new StringBuffer();
            for (String filename : filenames) {
                BufferedReader reader = new BufferedReader(new FileReader(filename));
                String str;
                while ((str = reader.readLine()) != null) {
                    //      buffer.append(str);
                    writer.write(str);
                    writer.newLine();
                }
                reader.close();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
