@SuppressWarnings("CheckReturnValue")
public class Execute extends SuffixCalculatorBaseVisitor<Double> {

   @Override public Double visitProgram(SuffixCalculatorParser.ProgramContext ctx) {
      Double res = null;   
      return visitChildren(ctx);
      //return res;
   }

   @Override public Double visitStat(SuffixCalculatorParser.StatContext ctx) {
      Double res = 0.0;

      if(ctx.expr() == null){
         return null;
      }
      res = visit(ctx.expr());

      if(res == null){
         System.out.println("Expressão inválida");
         
      }else{
         System.out.println(res);
      }
      
      return res;
   }

   @Override public Double visitExprNumber(SuffixCalculatorParser.ExprNumberContext ctx) {
      // Double res = null;
      return Double.parseDouble(ctx.Number().getText());
      //return res;
   }

   @Override public Double visitExprSuffix(SuffixCalculatorParser.ExprSuffixContext ctx) {
      Double res = null;

      Double a = visit(ctx.expr(0));

      Double b = visit(ctx.expr(1));

      String op = ctx.op.getText();

      switch (op) {
         case "+":
            res = a + b;
            break;
         case "-":
            res = a - b;
            break;
         case "*":
            res = a * b;
            break;
         case "/":
            res = a / b;
            break;
         default:
            System.out.println("Operador inválido");
      }
      
      
      return res;
   }
}
