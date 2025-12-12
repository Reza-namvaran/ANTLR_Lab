lexer grammar CustomLexer;

// Tokens
ID      : [a-zA-Z]+ ;
OP      : '++' | '--' ;
EQ      : '=' ;
SEMI    : ';' ;
LPAREN  : '(' ;
RPAREN  : ')' ;

// Whitespace
WS      : [ \t\r\n]+ -> skip ;
    