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
    
    private Hashtable<String, Integer> reservedWords = new Hashtable<>();
    {
        reservedWords.put("sin", sym.SIN);
        reservedWords.put("cos", sym.COS);
        reservedWords.put("exp", sym.EXP);
    }
%}

ws = [ \t\f\r\n]
number = [0-9]+|[0-9]*\.[0-9]+([eE][-+]?[0-9]+)?
id = [A-Za-z][A-Za-z0-9]*
%%
";"         { return symbol(sym.SEMI); }
"="         { return symbol(sym.ATTRIB); }
"+"         { return symbol(sym.PLUS); }
"-"         { return symbol(sym.MINUS); }
"*"         { return symbol(sym.TIMES); }
"/"         { return symbol(sym.DIVIDE); }
"%"         { return symbol(sym.MOD); }
"("         { return symbol(sym.LPAREN); }
")"         { return symbol(sym.RPAREN); }
{number}    { return symbol(sym.NUMBER, new Double(yytext()) ); }
{id}        { 
                String id = yytext();
                if (reservedWords.containsKey(id)) {
                    return symbol(reservedWords.get(id));
                } else {
                    return symbol(sym.ID, yytext());
                } 
            }
{ws}        { /* ignore */ }
.           { return symbol(sym.ERROR, yytext()); }
