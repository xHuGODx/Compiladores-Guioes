import java.util.HashMap;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
@SuppressWarnings("CheckReturnValue")

public class Translator extends numberTranslationBaseListener {
   HashMap<String, String> traducoes; 
   Translator(){
      traducoes = new HashMap<String, String>();
   }

   @Override public void exitTranslation(numberTranslationParser.TranslationContext ctx) {
      traducoes.put(ctx.STRING().getText(), ctx.NUMBER().getText());
   }

   public HashMap<String, String> getTranslations(){
      return traducoes;
   }
}
