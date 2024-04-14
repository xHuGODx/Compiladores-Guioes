import java.io.FileNotFoundException;
import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.HashMap;
import java.util.Scanner;

public class numberTranslationMain {
   public static void main(String[] args) {
      String num = "";
      String text = "";
      try {
         // create a CharStream that reads from standard input:
         CharStream input = CharStreams.fromFileName(args[0]);
         // create a lexer that feeds off of input CharStream:
         numberTranslationLexer lexer = new numberTranslationLexer(input);
         // create a buffer of tokens pulled from the lexer:
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         // create a parser that feeds off the tokens buffer:
         numberTranslationParser parser = new numberTranslationParser(tokens);
         // replace error listener:
         //parser.removeErrorListeners(); // remove ConsoleErrorListener
         //parser.addErrorListener(new ErrorHandlingListener());
         // begin parsing at script rule:
         ParseTree tree = parser.script();
         if (parser.getNumberOfSyntaxErrors() == 0) {
            // print LISP-style tree:
            // System.out.println(tree.toStringTree(parser));
            ParseTreeWalker walker = new ParseTreeWalker();
            Translator listener0 = new Translator();
            walker.walk(listener0, tree);
            //
            //
            HashMap <String, String> translator = listener0.getTranslations();
            Scanner input_sc = new Scanner(System.in);
            String res = "";
            while (input_sc.hasNextLine()){
               String sentence = input_sc.nextLine();
               Scanner input_line = new Scanner(sentence);
               res = "";
               while (input_line.hasNext()){
                  String current = input_line.next();
                  res += (translator.containsKey(current)) ? translator.get(current) : current;
                  res += " ";
               }
               System.out.println(sentence + " -> " + res);
            }
            
         }
      }
      catch(IOException e) {
         e.printStackTrace();
         System.exit(1);
      }
      catch(RecognitionException e) {
         e.printStackTrace();
         System.exit(1);
      }
   }
}