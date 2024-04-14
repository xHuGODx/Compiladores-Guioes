grammar Calculator;

program:
    stat* EOF;
stat:
    expr? NEWLINE               #StatExpr
    | assignment? NEWLINE       #StatAssignment
    ;

assignment: ID '=' expr
    ;

expr:
      '-' expr                      #UnitaryMinus  
    | '+' expr                      #UnitaryPlus    
    | expr op=('*'|'/'|'%') expr    #ExprMulDivMod
    | expr op=('+'|'-') expr        #ExprAddSub
    | Integer                       #ExprInteger
    | '(' expr ')'                  #ExprParent
    | ID                            #ExprID
    ;
Integer: [0-9]+;
ID: [a-zA-Z_]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;
