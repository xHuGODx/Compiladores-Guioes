grammar Hello;
rules : (greetings | farewell)* EOF;
greetings : 'hello' ID+;
farewell : 'bye' ID+;
ID : [a-zA-Z]+;
WS : [ \t\r\n]+ -> skip;