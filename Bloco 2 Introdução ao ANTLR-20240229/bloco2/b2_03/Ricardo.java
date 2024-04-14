@SuppressWarnings("CheckReturnValue")
public class Ricardo extends CalculatorBaseVisitor<Long> {

   @Override public Long visitProgram(CalculatorParser.ProgramContext ctx) {
      Long res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Long visitStat(CalculatorParser.StatContext ctx) {
      Long res = null;
      if (ctx.expr() != null) {
         res = visit(ctx.expr());
      }
      if (res == null) {
         return null;
   
      }
      else {
         System.out.println(res);
      }
      return visitChildren(ctx);
      //return res;
   }

   @Override public Long visitExprMulDivMod(CalculatorParser.ExprMulDivModContext ctx) {
      Long res = null;
      Long left = visit(ctx.expr(0));
      Long right = visit(ctx.expr(1));
      if (ctx.op.getText().equals("*")) {
         return left * right;
      }
      else if (ctx.op.getText().equals("/")) {
         return left / right;
      }
      return left % right;
      //return visitChildren(ctx);
      //return res;
   }

   @Override public Long visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      Long res = null;
      Long left = visit(ctx.expr(0));
      Long right = visit(ctx.expr(1));
      String op = ctx.op.getText();
      if (op.equals("+")) {
         return left + right;
      }
      return left - right;
      //return visitChildren(ctx);
      //return res;
   }

   @Override public Long visitExprParent(CalculatorParser.ExprParentContext ctx) {
      Long res = visit(ctx.expr());
      return res;
      //return res;
   }

   @Override public Long visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      Long res = null;
      return Long.parseLong(ctx.Integer().getText());
      //return res;
   }
}
