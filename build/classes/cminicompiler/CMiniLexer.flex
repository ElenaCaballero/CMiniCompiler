package cminicompiler;

import java_cup.runtime.*;
import java.io.Reader;
import java_cup.sym;

%%
%public 
%class CMiniLexer
%unicode
%int
%cup
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
            return new Symbol(sym, yyline, yycolumn);
    }

    private Symbol symbol(String name, int sym, Object val) {
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
boolToF = 0|1

id = {letter}({letter}|{digit}|[_])*

constchar = "'"{letter}"'"|"'"(" ")"'"

arthmexpSUM = ("+")|("-")
arthmexpMULT = ("*")|("/")
boolexp = ("<")|(">")|("<=")|(">=")|("!=")|("==")

int = "int"|"int*"|"int *"
char = "char"|"char*"|"char *"    

null = "null"|"NULL"             

%state COMMENT
%state LINECOMMENT
%state STRING

%%
<YYINITIAL>{
    \"			{ string.setLength(0); string.append( yytext() ); yybegin(STRING); }    
    "/*"                { commentLine = yyline+1; stComment++; yybegin(COMMENT); }
    "*/"                { System.out.println("Utilizó */ sin abrirlo"); }
    "//"                { yybegin(LINECOMMENT); }
    {int}               { return symbol("int",sym.INT,yytext()); }
    {char}              { return symbol("char",sym.CHAR,yytext()); }
    "boolean"           { return symbol("boolean",sym.BOOLEAN); }
    {constchar}         { return symbol("constchar",sym.CONSTCHAR,yytext()); }
    "void"              { return symbol("void",sym.VOID); }
    "printf"            { return symbol("printf",sym.PRINTF); }
    "scanf"             { return symbol("scanf",sym.SCANF); }
    {arthmexpSUM}       { return symbol("arthmexpSUM",sym.ARTHMEXPSUM,yytext()); }
    {arthmexpMULT}      { return symbol("arthmexpMULT",sym.ARTHMEXPMULT,yytext()); }
    {boolexp}           { return symbol("boolexp",sym.BOOLEXP,yytext()); }
    ";"                 { return symbol(";",sym.SEMICOLON); }
    ":"                 { return symbol(":",sym.COLON); }
    ","                 { return symbol(",",sym.COMMA); }
    "."                 { return symbol(".",sym.DOT); }
    "("                 { return symbol("(",sym.LEFTPRNTH); }
    ")"                 { return symbol(")",sym.RIGTHPRNTH); }
    "{"                 { return symbol("{",sym.LEFTCBRAC); }
    "}"                 { return symbol("}",sym.RIGHTCBRAC); }
    "["                 { return symbol("[",sym.LEFTBRAK); }
    "]"                 { return symbol("]",sym.RIGHTBRAK); }
    "#"                 { return symbol("#",sym.NUMERAL); }
    "||"                { return symbol("||",sym.OR); }
    "&&"                { return symbol("&&",sym.AND); }
    "for"               { return symbol("for",sym.FOR); }
    "while"             { return symbol("while",sym.WHILE); }
    "do"                { return symbol("do",sym.DO); }
    "if"                { return symbol("if",sym.IF); }
    "else"              { return symbol("else",sym.ELSE); }
    "define"            { return symbol("define",sym.DEFINE); }
    "include"           { return symbol("include",sym.INCLUDE); }
    "return"            { return symbol("return",sym.RETURN); }
    "break"             { return symbol("break",sym.BREAK); }
    {null}              { return symbol("null",sym.NULL,yytext()); }
    {boolToF}           { return symbol("boolToF",sym.BOOLTOF,yytext()); }
    {id}                { return symbol("id",sym.ID,yytext()); }
    {space}             { }
    .                   { System.out.println("ERROR! No se reconoce el simbolo: "+yytext()); }
}

<COMMENT>{
    "*/"    { stComment--; if(stComment==0) yybegin(YYINITIAL); }
    [^]     { }
}

<LINECOMMENT>{
    "\n"    {yybegin(YYINITIAL);}
    [^]     { }
}

<STRING> {
      \"                             { yybegin(YYINITIAL);
                                       return symbol(sym.STRING_LITERAL,string.toString()); }
      [^\n\r\"\\]+                   { string.append( yytext() ); }
      \\t                            { string.append('\t'); }
      \\n                            { string.append('\n'); }
      \\r                            { string.append('\r'); }
      \\\"                           { string.append('\"'); }
      \\                             { string.append('\\'); }
 }