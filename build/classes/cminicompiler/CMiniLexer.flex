package cminicompiler;

import java_cup.runtime.*;
import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java.io.Reader;
import java_cup.sym;

%%
%public 
%class CMiniLexer
%unicode
%int
%cup
%standalone
%line
%column
%eofval{
    if(stComment!=0)
            System.out.println("Comment started at line " + commentLine + " is not finished");
    return new Symbol(sym.EOF, yyline, yycolumn);
%eofval}
%eofclose
%{
    int stComment = 0;
    int commentLine;
    StringBuffer string = new StringBuffer();

    private Symbol symbol(String name, int sym) {
            System.out.println("name: " + name + " sym: " + sym);
            return new Symbol(sym, yyline, yycolumn);
    }

    private Symbol symbol(String name, int sym, Object val) {
            System.out.println("name: " + name + " sym: " + sym + " val: " + val);
            return new Symbol(sym, yyline, yycolumn, val);
    }

    private void error(String message) {
            System.err.println("Lexical Error at line "+(yyline+1)+", column "+(yycolumn+1)+" : "+message);
    }
%}

letter = [a-zA-Z]
digit = [0-9]
space = (" "|"\t"|"\n")+

integer = {digit}+
boolean = "true"|"false"

id = {letter}({letter}|{digit}|[_])*

palabraACA ={letter}*aca{letter}*
palabraABA ={letter}*aba{letter}*

%state COMMENT

%%
<YYINITIAL>{
    "/*"                { commentLine = yyline+1; stComment++; yybegin(COMMENT); }
    {palabraACA}	{ System.out.println("ACA: "+yytext()); }
    {palabraABA}	{ System.out.println("ABA: "+yytext()); }
    {space}       {}
    .               {}
}

<COMMENT>{
    "/*"    { stComment++; }
    "*/"    { stComment--; if(stComment==0) yybegin(YYINITIAL); }
    [^]     { }
}

