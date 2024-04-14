@SuppressWarnings("CheckReturnValue")
public class Execute extends HelloBaseVisitor<String> {

   @Override public String visitRules(HelloParser.RulesContext ctx) {
      String res = null;
      System.out.println("benfica");
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitGreetings(HelloParser.GreetingsContext ctx) {
      String res = null;
      String nome = "";
      for (int i = 0; i < ctx.ID().size(); i++) {
         nome += ctx.ID(i).getText() + " ";
      }
      System.out.println("Olá " + nome + "!");
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitFarewell(HelloParser.FarewellContext ctx) {
      String res = null;
      String nome = "";
      for (int i = 0; i < ctx.ID().size(); i++) {
         nome += ctx.ID(i).getText() + " ";
      }
      System.out.println("Adeus " + nome + "!");
      return visitChildren(ctx);
      //return res;
   }
}
