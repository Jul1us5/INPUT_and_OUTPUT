
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;

/**
 *
 * @author Juliius
 */
public class Input_and_Output {

    public static void main(String[] args) throws FileNotFoundException, IOException {

            // Get a file
        try (FileInputStream file_in = new FileInputStream("/Users/evuncik/Desktop/JAVA/INPUT_and_OUTPUT/src/pirmas.txt");
                Reader r = new InputStreamReader(file_in, "UTF-8");) {

            // Read a file
            System.out.print("Read: ");
            int x = 0;
            while ((x = r.read()) != -1) {
                char c = (char) x;
                System.out.print(c);
            }

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
