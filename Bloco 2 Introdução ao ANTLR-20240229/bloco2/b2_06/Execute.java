import java.util.HashMap;

@SuppressWarnings("CheckReturnValue")
public class Execute extends CalculatorBaseVisitor<Long> {

   private HashMap<String, Long> variables = new HashMap<>();

   @Override public Long visitProgram(CalculatorParser.ProgramContext ctx) {
      Long res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Long visitStatAssignment(CalculatorParser.StatAssignmentContext ctx) {
      Long res = null;
      if (ctx.assignment() != null) {
         res = visit(ctx.assignment());
      }
      if (res == null) {
         return null;
   
      }
      else {
         System.out.println(res);
      }
      return null;
      //return res;
   }

   @Override public Long visitStatExpr(CalculatorParser.StatExprContext ctx) {
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
      return null;
      //return res;
   }

   @Override public Long visitAssignment(CalculatorParser.AssignmentContext ctx) {
      Long res = null;
      String ID = ctx.ID().getText();
      Long value = visit(ctx.expr());
      variables.put(ID, value);
      return value;
      //return res;
   }

   @Override public Long visitExprMulDivMod(CalculatorParser.ExprMulDivModContext ctx) {
      Long res = null;
      Long left = visit(ctx.expr(0));
      Long right = visit(ctx.expr(1));
      if (left == null || right == null) {
         System.out.println("Variable not initialized");
         return null;
      }
      if (ctx.op.getText().equals("*")) {
         return left * right;
      }
      else if (ctx.op.getText().equals("/")) {
         return left / right;
      }
      return left % right;
      //return res;
   }

   @Override public Long visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      Long res = null;
      Long left = visit(ctx.expr(0));
      Long right = visit(ctx.expr(1));
      if (left == null || right == null) {
         System.out.println("Variable not initialized");
         return null;
      }
      String op = ctx.op.getText();
      if (op.equals("+")) {
         return left + right;
      }
      return left - right;
      //return res;
   }

   @Override public Long visitUnitaryPlus(CalculatorParser.UnitaryPlusContext ctx) {
      Long res = visit(ctx.expr());
      return res;
      //return res;
   }

   @Override public Long visitExprParent(CalculatorParser.ExprParentContext ctx) {
      Long res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Long visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      Long res = null;
      return Long.parseLong(ctx.Integer().getText());
      //return res;
   }

   @Override public Long visitExprID(CalculatorParser.ExprIDContext ctx) {
      Long res = variables.get(ctx.ID().getText());
      return res;

      //return res;
   }

   @Override public Long visitUnitaryMinus(CalculatorParser.UnitaryMinusContext ctx) {
      Long res = -visit(ctx.expr());
      return res;
      //return res;
   }
}
