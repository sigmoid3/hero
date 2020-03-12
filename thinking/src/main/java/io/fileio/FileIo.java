package io.fileio;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @Author: sandro
 * @Create: 2019-09-26
 * @Description:
 **/
public class FileIo {
    public static void main(String[] args) {
        try {
            File fileread = new File("test.txt");
            File filewirte = new File("testB.txt");
            FileReader fileReader = new FileReader(fileread);
            FileWriter fileWriter = new FileWriter(filewirte);
            char[] ch = new char[(int)fileread.length()];
            int len = fileReader.read(ch);
            if (len != -1) {
                fileWriter.write(ch);
            }
            fileReader.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
