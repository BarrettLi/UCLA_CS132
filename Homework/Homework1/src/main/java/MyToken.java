import java.util.*;
import java.lang.*;

public class MyToken { 
    private static ArrayList<String> terminalSymbols = new ArrayList<String>();

    MyToken(){
        // {, }, System.out.println, (, ), ;, if, else, while, true, false, ! 
        terminalSymbols.add("{");
        terminalSymbols.add("}");
        terminalSymbols.add("System.out.println");
        terminalSymbols.add("(");
        terminalSymbols.add(")");
        terminalSymbols.add(";");
        terminalSymbols.add("if");
        terminalSymbols.add("else");
        terminalSymbols.add("while");
        terminalSymbols.add("true");
        terminalSymbols.add("false");
        terminalSymbols.add("!");
    }

    public static ArrayList<String> tokenize(Scanner in){
        ArrayList<String> tokens = new ArrayList<String>();

        while(in.hasNext()){
            String token = in.next();
            Boolean valid = false;

            for(int i=1; i <= token.length(); i++){
                // System.out.println(token.substring(0, i));
                if(terminalSymbols.contains(token.substring(0, i))){// token contains valid symbol
                    
                    if(i == token.length()){ // full token is scanned
                        tokens.add(token);
                        valid = true;
                    }
                    else{ // token has another part left
                        tokens.add(token.substring(0, i));
                        token = token.substring(i);
                        i = 0;
                    }
                }
            }

            if(!valid){
                System.out.println("Parse error");
                in.close();
                System.exit(1);
            }
        }

        // tokens.add("$");
        return tokens;
    }
}
