package calculatornotesmaker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Dan
 */
public class CalculatorNotesMaker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File code = new File("FILE_PATH.txt");
        String[] mainInputLines = parseInput(code);
        System.out.println((new Menu(mainInputLines,0).toString().replace("Lbl 0","ClrHome")));
    }

    public static String[] parseInput(File text) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            Scanner scanny = new Scanner(text);

            while (scanny.hasNextLine()) {
                lines.add(scanny.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String [] parsedLines = new String[lines.size()];
        for(int i = 0;i<lines.size();i++){
        parsedLines[i]=lines.get(i);
        }
        
        return parsedLines;
    }

    

    
}
