/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatornotesmaker;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Dan
 */
public class Menu {
    
    String[] mySource; //All of the text related to this menu
    String myTitle; //Menu Title
    Menu[] mySubheadings; //Everything below this Menu (Text/Menus)
    int myLevel; //This is number of hyphens in the title.
    ArrayList<Integer> mySubheadingLocations; //Locations of Subheadings
    int myLabel; // label number in calculator

    public Menu(String[] source, int label) {
        myLabel = label;
        myLevel = source[0].lastIndexOf("-") + 1;
        myTitle = source[0].replace("-", "");
        mySource = source;
        determineSubheadingLocations();
        if (mySubheadingLocations.size() > 0) {
            mySubheadings = createAllSubheadings();
        }
        //If there are no subheadings...The toString method will only return text
    }
    
    public void determineSubheadingLocations() {
        mySubheadingLocations = new ArrayList<>();
        if (mySource.length > 1) {
            for (int i = 1; i < mySource.length; i++) {
                if ((mySource[i].lastIndexOf("-")) == myLevel) {
                    //^^IF(The current line has one more hyphen than the title){It is a subheading}
                    mySubheadingLocations.add(i);
                }
            }
        }
    }
    /*
     determinedSubheadings = new Menu[mySubheadingLocations.size()];
     if ((mySource[i].lastIndexOf("-")) == myLevel) {
     //^^IF(The current line has one more hyphen than the title){It is a subheading} 
     determinedSubheadings[j] = createSubheading(i);
     j++;
     }
     */
    
    public Menu[] createAllSubheadings() {
        //Big mamba
        Menu[] determinedSubheadings;
        determinedSubheadings = new Menu[mySubheadingLocations.size()];
        for (int i = 0; i < mySubheadingLocations.size(); i++) {
            determinedSubheadings[i] = createSubheading(i);
        }
        return determinedSubheadings;
    }
    
    public Menu createSubheading(int relativeLocation) {

        ///try catch for final sub

        //relativeLocation is which # subheading it is
        //newSource is everything between sub1 and sub2 including sub1 (b/c title)
        int actualLocation = mySubheadingLocations.get(relativeLocation);
        String[] newSource;
        if (relativeLocation == mySubheadingLocations.size() - 1) {
            newSource = new String[mySource.length - actualLocation];
        } else {
            newSource = new String[mySubheadingLocations.get(relativeLocation + 1) - actualLocation];
        }
        
        int counter = 0;
        for (int i = actualLocation; i < newSource.length + actualLocation; i++) {
            newSource[counter] = mySource[i];
            counter++;
        }
        return new Menu(newSource, actualLocation + myLabel);
    }
    
    public String getTitle() {
        return myTitle;
    }
    
    public int getLabel() {
        return myLabel;
    }
    
    public String convertText(String firstInput) {
        String[] input = firstInput.split(" ");
        ArrayList<String> outputs = new ArrayList();
        String current = input[0];
        for (int i = 1; i < input.length + 1; i++) {
            try {
                if (fits(current, input[i])) {
                    if (current.length() > 0 && current.charAt(0) == ' ') {
                        current = current.substring(1, current.length());
                    }
                    current += " " + input[i];
                } else {
                    outputs.add(current);
                    current = "";
                    i--;
                }
            } catch (Exception e) {
                outputs.add(current);
            }
        }
        String finaloutput = "";
        for (int i = 0; i < outputs.size(); i++) {
            if (i == outputs.size() - 1) {
                finaloutput += ("::Pause " + '"');
            } else if (i > 0 && i % 6 == 0) {
                finaloutput += ("::Pause " + '"');
            } else {
                finaloutput += ("::Disp " + '"');
            }
            finaloutput += (outputs.get(i) + '"' + "\n");
        }
        return finaloutput;
    }
    
    public boolean fits(String first, String second) {
        if (first.length() + second.length() + 1 <= 16) {
            return true;
        } else {
            return false;
        }
    }
    
    public String toString() {
        //:Menu("KIN/DYNAMICS","Overview",15,"Units",16,"Formulas",17,"Laws",18,"Situations",2)
        // Each subheading: ----- ,"Overview",15 ------
        String outputString = "";

        //FIRST LINE (MENU)
        String[] outputs;
        try {
            if (mySubheadings.length > 1) {
                outputs = new String[mySubheadings.length + 2];
            } else {
                outputs = new String[2];
            }
            outputs[0] = "Lbl " + myLabel;
        } catch (Exception e) {
            outputs = new String[2];
        }
        outputs[0] = "Lbl " + myLabel;
       try{
            if (mySubheadings.length > 1) {
                //Create Menu Heading
                outputs[1] = "Menu(\"" + myTitle + "\"";
                for (int i = 0; i < mySubheadingLocations.size(); i++) {
                    outputs[1] += (",\"" + mySubheadings[i].getTitle() + "\"," + mySubheadings[i].getLabel());
                }
                outputs[1] += (")");
                //Add Subheadings
                for (int i = 2; i < mySubheadings.length + 2; i++) {
                    outputs[i] = mySubheadings[i - 2].toString();
                }
                
                
                
                
            } else if(mySubheadings.length==1){
                //If it's text just text
                outputs[1] = convertText(mySubheadings[0].getTitle())+"Stop\n";
            }
       }catch(Exception e){
        //If it's text just text
           
                //outputs[1] = convertText(mySubheadings[0].getTitle())+"Stop\n";
       }
        
        try {
            for (int i = 0; i < mySubheadings.length + 2; i++) {
                outputString += ("\n" + outputs[i]);
            }
        } catch (Exception e) {
            //for (int i = 0; i < 2; i++) {
               // outputString += ("\n" + outputs[i]);
           // }

        }
        
        //System.out.println(Arrays.toString(outputs));
        
        return outputString;
    }
}
