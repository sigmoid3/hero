package io.chario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.StandardSocketOptions;
import java.nio.charset.StandardCharsets;

/**
 * @Author: sandro
 * @Create: 2019-09-26
 * @Description:
 **/
public class CharIo {
    public static void main(String[] args) {
        try {
            InputStream in = System.in;
            InputStreamReader inputStreamReader = new InputStreamReader(in, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            if (line != null) {
                System.out.println(line);
            }
            inputStreamReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            OutputStream out = System.out;
            //OutputStream outputStream = new FileOutputStream("test.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            String str = "nihao\r\n你好";
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
