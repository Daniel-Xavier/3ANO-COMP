/**
 * Analisador léxico para expressões simples
 */
package exemplo1;

%%

%class Lexer
%unicode
%debug
%standalone
%line
%column
%type Token

%eofval{ 
return new Token(Tag.EOF);
%eofval}

%eof{
System.out.println("Análise léxica terminada com sucesso!");
%eof}

%{
// Macros
%}
delim	= [\ \t\n]
ws		= {delim}+
letter	= [A-Za-z]
digit	= [0-9]
id		= {letter}({letter}|{digit})*
number	= {digit}+(\.{digit}+)?(E[+-]?{digit}+)?

%%
/* Regras e ações */
{ws}		{ /* ignorar */ }
if			{ return new Token(Tag.IF); }
then		{ return new Token(Tag.THEN); }
else		{ return new Token(Tag.ELSE); }
{id}		{ return new Word(Tag.ID, yytext()); }
{number}	{ return new Num(Double.parseDouble(yytext())); }
"<"			{ return new Token(Tag.RELOP);}
"<="		{ return new Token(Tag.RELOP);}
"="			{ return new Token(Tag.RELOP);}
"<>"		{ return new Token(Tag.RELOP);}
">"			{ return new Token(Tag.RELOP);}
">="		{ return new Token(Tag.RELOP);}
/* Qualquer outro - gerar erro */
.		{ throw new Error("Illegal <" + yytext() + "(" + (int)(yytext().charAt(0)) + ")" + ">"); }
