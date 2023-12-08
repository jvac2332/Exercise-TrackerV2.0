import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ExerciseWriter {
    private static final Exercise[] Exercise = null;
// Private final exercise helps with my exercise statements to null not to create errors
    public static boolean writeToFile(File f, ArrayList<Exercise> circles) { // The ExerciseWriter is enabling acces to the file piece when running it 
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f))); // It's like  help the  file not to crash
            for (Exercise e : Exercise) {
                pw.println(e);
            }
            pw.close(); // closes the statement
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    
    
}
