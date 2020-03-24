/* JFlex Scanner for CUP example. */
package parser;
import java_cup.runtime.*;
import java.util.Hashtable;
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
id = [A-Za-z][A-Za-z0-9]*
%%
";"         { return symbol(sym.SEMI); }
"="         { return symbol(sym.ATTRIB); }
"+"         { return symbol(sym.PLUS); }
"-"         { return symbol(sym.MINUS); }
"("         { return symbol(sym.LPAREN); }
")"         { return symbol(sym.RPAREN); }
{number}    { return symbol(sym.NUMBER, new Integer(yytext()) ); }
"print"     { return symbol(sym.PRINT); }
{id}        { 
                return symbol(sym.ID, yytext());
            }
{ws}        { /* ignore */ }
.           { throw new Error("Illegal character <"+ yytext() + "> at (" +
                 yyline + "," + yycolumn +")" ); }
