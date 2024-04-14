grammar CSV;

program: (header NEWLINE) (row NEWLINE)* EOF;

header:
    line
;
row:
    line
;
line:
    (ID ',')* ID
;
NEWLINE: '\r'? '\n';
ID: [a-zA-Z0-9];
ERROR: . ;