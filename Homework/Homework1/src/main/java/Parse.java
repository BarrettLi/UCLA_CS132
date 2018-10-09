import java.util.*;
import java.lang.*;

public class Parse{
    Parse(){}
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<String> tokens = new MyToken().tokenize(in);

        // System.out.println(tokens);
        Grammer grammer = new Grammer(tokens);
        Boolean parseS = grammer.S();

        if(!parseS || grammer.isTokenLeft()){
            System.out.println("Parse error");
        }else{
            System.out.println("Program parsed successfully");
        }
    }
}