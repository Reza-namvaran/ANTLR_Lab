parser grammar CustomParser;
options { tokenVocab=CustomLexer; }

p: s EOF ;
// Statements
s    : a SEMI | a SEMI s ;

// Assignment
a  : ID EQ e ;

// Expressions
e
    : e OP            // unary op
    | LPAREN e RPAREN
    | ID
    ;
