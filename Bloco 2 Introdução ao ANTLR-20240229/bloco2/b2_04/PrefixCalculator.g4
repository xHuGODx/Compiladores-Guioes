grammar PrefixCalculator;
program:
    stat* EOF
    ;
stat:
    expr? NEWLINE
    ;
expr:
     op=('*'|'/'|'+'|'-') expr expr #ExprSuffix
    | Number                        #ExprNumber
    ;
Number: [0-9]+('.'[0-9]+)?;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;