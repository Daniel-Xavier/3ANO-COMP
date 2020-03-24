/* JFlex Scanner for CUP example. */
package parser;
import java_cup.runtime.*;
%%
%class Scanner
%cup
%unicode
%line
%column
%{
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

ws = [ \t\f\r\n]
number = [0-9]+
%%
";"         { return symbol(sym.SEMI); }
"+"         { return symbol(sym.PLUS); }
"-"         { return symbol(sym.MINUS); }
"*"         { return symbol(sym.TIMES); }
"/"         { return symbol(sym.DIVIDE); }
"%"         { return symbol(sym.MOD); }
"("         { return symbol(sym.LPAREN); }
")"         { return symbol(sym.RPAREN); }
{number}    { return symbol(sym.NUMBER, new Integer(yytext()) ); }
{ws}        { /* ignore */ }
.       { return symbol(sym.ERROR, yytext()); }
