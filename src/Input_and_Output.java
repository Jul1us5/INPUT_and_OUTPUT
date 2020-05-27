
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

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
            ArrayList list = new ArrayList();
            int x = 0;
            
            String s = null;
            while ((s = br.readLine()) != null) {
                if(s == "a") {
                    break;
                }
                
                System.out.print(s);
                list.add(s);
            }
            

            System.out.println();

            System.out.println();
            System.out.println(list);
            System.out.println();
        }

        // In and Out files
        try (InputStream in = new FileInputStream("/Users/evuncik/Desktop/JAVA/INPUT_and_OUTPUT/src/pirmas.txt");
                OutputStream out = new FileOutputStream("/Users/evuncik/Desktop/JAVA/INPUT_and_OUTPUT/src/antras.txt")) {

            // Copy from pirmas.txt to antras.txt
            int length;
            byte[] bytes = new byte[1024];

            while ((length = in.read(bytes)) != -1) {

                out.write(bytes, 0, length);
            }
        }

        System.out.println("-----");
        System.out.println("Copying: complete");

    }

}
