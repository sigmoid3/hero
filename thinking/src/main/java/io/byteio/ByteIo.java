package io.byteio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @Author: sandro
 * @Create: 2019-09-26
 * @Description:
 **/
public class ByteIo {
    public static void main(String[] args) throws Exception {
        File f = new File("testW.txt");
        try {
            OutputStream out = new FileOutputStream(f);
            String text = "test,测试";
            byte[] btext = text.getBytes(StandardCharsets.UTF_8);
            out.write(btext);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        InputStream in = new FileInputStream(f);
        byte[] btext = new byte[(int)f.length()];
        for (int i = 0; i < btext.length; i++) {
            btext[i] = (byte)in.read();
        }
        in.close();
        System.out.println(new String(btext));
    }
}
