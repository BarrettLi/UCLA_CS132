import java.util.*;
import java.lang.*;

public class Grammer{
    private static ArrayList<String> tokens;
    private static String token;

    Grammer(ArrayList<String> tokens){
        this.tokens = tokens;
        this.token = next_token();
    }

    private static String next_token(){
        if(tokens.isEmpty()){
            return null;
        }
        return tokens.remove(0);
    }

    // private static void error(){
    //     System.out.println("Parse error");
    //     System.exit(0);
    // }

    private static Boolean eat(String a){
        // System.out.println("try to eat " + a + "...");
        if(token.equals(a)){
            // System.out.println("eat successfully!");
            token = next_token();
            return true;
        }else{
            // error();
            return false;
        }
    }

    public static Boolean S(){
        // System.out.println("S...");
        switch(token){
            case "{": return (eat("{") && L() && eat("}")); //break;
            case "System.out.println": return (eat("System.out.println") && eat("(") && E() && eat(")") && eat(";")); //break;
            case "if": return (eat("if") && eat("(") && E() && eat(")") && S() && eat("else") && S()); //break;
            case "while": return (eat("while") && eat("(") && E() && eat(")") && S());
        }
        // System.out.println("S is done ...");
        // eat("$");

        // System.out.println("Program parsed successfully");
        return false;
    }

    public static Boolean L(){
        // System.out.println("L...");
        switch(token){
            case "{":
            case "System.out.println":
            case "if":
            case "while": return (S() && L()); //break;
            default: return true;
        }
    }

    public static Boolean E(){
        // System.out.println("E...");
        switch(token){
            case "true": return eat("true"); //break;
            case "false": return eat("false"); //break;
            case "!": return (eat("!") && E()); //break;
        }
        return false;
    }

    public static Boolean isTokenLeft(){
        return !tokens.isEmpty();
    }
}