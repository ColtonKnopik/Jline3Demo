import javax.lang.model.util.SimpleElementVisitor6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Auto {

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        SimpleAutoComplete autoComplete = new SimpleAutoComplete(getOptions());
        System.out.println("Auto Complete Test");
        String answer = "";

        while(!answer.equals("quit")){
            answer = autoComplete.readInputWithAutocomplete();
            System.out.println("You typed: " + answer);
        }
    }

    public static List<String> getOptions(){
        return Arrays.asList("Sauron", "Aragorn", "Frodo", "Arwen", "Gandalf", "Legolas", "Galadriel");
    }
}
