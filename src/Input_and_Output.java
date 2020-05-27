
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Juliius
 */
public class Input_and_Output {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        // Get a file
        try (FileInputStream file_in = new FileInputStream("/Users/evuncik/Desktop/JAVA/INPUT_and_OUTPUT/src/pirmas.txt");
                Reader r = new InputStreamReader(file_in, "UTF-8");
                BufferedReader br = new BufferedReader(r);) {

            // Read a file
            System.out.print("Read: ");
            int x = 0;

            String s = null;
            while ((s = br.readLine()) != null) {

                System.out.print(s);
                System.out.println();
            }
        }

        // In and Out files
        try (InputStream in = new FileInputStream("/Users/evuncik/Desktop/JAVA/INPUT_and_OUTPUT/src/pirmas.txt");
                OutputStream out = new FileOutputStream("/Users/evuncik/Desktop/JAVA/INPUT_and_OUTPUT/src/antras.txt");
                Writer w = new OutputStreamWriter(out, "UTF-8");
                BufferedWriter bw = new BufferedWriter(w);) {

            // Copy from pirmas.txt to antras.txt
            int length;
            byte[] bytes = new byte[1024];

            while ((length = in.read(bytes)) != -1) {

                out.write(bytes, 0, length);

            }

        }
        // Create ArrayList
        ArrayList list = new ArrayList();

        try (BufferedReader r = new BufferedReader(new FileReader("/Users/evuncik/Desktop/JAVA/INPUT_and_OUTPUT/src/pirmas.txt"))) {
            StringBuffer sb = new StringBuffer();
            while (r.ready()) {
                char c = (char) r.read();
                if (c == ' ') {
                    list.add(sb.toString());
                    sb = new StringBuffer();
                } else {
                    sb.append(c);
                }
            }
            // Put single words to ArrayList
            if (sb.length() > 0) {
                list.add(sb.toString());
            }
        }

        System.out.println("-----");
        System.out.println("Copying: complete");

        // Sort index by length in ArrayList
        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return 1;
                } else {
                    return o2.compareTo(o1);
                }
            }
        });

        // Push ArrayList to trecias.txt | output stream
        try (FileWriter writer = new FileWriter("/Users/evuncik/Desktop/JAVA/INPUT_and_OUTPUT/src/trecias.txt");) {
            for (Object str : list) {
                writer.write(str + System.lineSeparator());
            }
        }
    }
}
