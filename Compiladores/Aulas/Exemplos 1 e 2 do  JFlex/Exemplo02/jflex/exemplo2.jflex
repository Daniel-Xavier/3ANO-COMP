/**
 * Analisador léxico para tags
 */
package exemplo2;

%%

%class Lexer
%unicode
%type Token
%eofval{
return new Token(Tag.EOF);
%eofval}
%line
%column
%eof{
System.out.println("Análise léxica terminada com sucesso!");
%eof}

%{
	private StringBuffer buffer = new StringBuffer();
%}


delim   = [\ \t\n]
ws      = {delim}+

%xstate PAR
%xstate END

%%
<YYINITIAL> {
	"<p>" 	{ yybegin(PAR); buffer.setLength(0);}
	{ws}  	{ }
	.   	{ }
}
<PAR> {
	"</p>"		{ yybegin(YYINITIAL); 
				  return new Word(Tag.PAR_TEXT, buffer.toString()); }
	.|{delim}	{ buffer.append(yytext()); }
}

