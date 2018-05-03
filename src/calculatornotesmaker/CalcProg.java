package calculatornotesmaker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CalcProg {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("FILE_PATH.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<Character> valid = new ArrayList<Character>();
        String v = " . , ^ ( ) { } [ ] ! + - * / < > = :";
        for (int i = 0; i < v.length(); i++) {
            if (v.charAt(i) != ' ') {
                valid.add(v.charAt(i));
            }
        }
        int line = 0;
        while (scanner.hasNext()) {
            line++;
            String temp = scanner.nextLine();
            int count = 0;
            for (int i = 0; i < temp.length(); i++) {
                if (i > temp.length()) {
                    break;
                }
                if (!(Character.isLetterOrDigit(temp.charAt(i)) || temp.charAt(i) == ' ' || valid.contains(temp.charAt(i)) || (int)temp.charAt(i) == '~')) {
                    System.out.println("Invalid char " + temp.charAt(i) + " on line " + line);
                }
                if (temp.charAt(i) != ' ' && temp.charAt(i) != '~') {
                    count++;
                } else {
                    count = 0;
                }
                if (count >= 16) {
                    while (i < temp.length() && temp.charAt(i) != ' ') {
                        i++;
                        count++;
                    }
                    System.out.println("Line: " + line + ", String: " + temp.substring(i - count + 1, i));
                    count = 0;
                }
            }
        }
        System.out.println("Finished scanning file. If no errors displayed, file is acceptable.");
    }
}
