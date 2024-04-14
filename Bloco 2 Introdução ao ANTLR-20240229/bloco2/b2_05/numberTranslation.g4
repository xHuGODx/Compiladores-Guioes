grammar numberTranslation ;
script : 
    translation* EOF ; 
translation: 
    (NUMBER' - 'STRING)? NEWLINE ;

NEWLINE : '\n' ;
STRING : [a-zA-Z]+ ;
NUMBER : [0-9]+ ;
