package cminicompiler;

import java_cup.runtime.*;
import java_cup.*;
import java.io.IOException;;


%% 
%class CMiniLexer
%unicode
%int
%cup

%{
    int stComment = 0;
    int commentLine;
    StringBuffer string = new StringBuffer();

    private Symbol symbol(int sym) {
            return new Symbol(sym, yyline, yycolumn);
    }

    private Symbol symbol(int sym, Object val) {
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
boolToF = "0" | "1"

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
    \"			{ string.setLength(0); string.append(yytext()); yybegin(STRING); }    
    "/*"                { commentLine = yyline+1; stComment++; yybegin(COMMENT); }
    "*/"                { System.out.println("Utilizó */ sin abrirlo"); }
    "//"                { yybegin(LINECOMMENT); }
    {int}               { return symbol(sym.INT,yytext()); }
    {char}              { return symbol(sym.CHAR,yytext()); }
    "boolean"           { return symbol(sym.BOOLEAN); }
    {constchar}         { return symbol(sym.CONSTCHAR,yytext()); }
    "void"              { return symbol(sym.VOID); }
    "printf"            { return symbol(sym.PRINTF); }
    "scanf"             { return symbol(sym.SCANF); }
    {arthmexpSUM}       { return symbol(sym.ARTHMEXPSUM,yytext()); }
    {arthmexpMULT}      { return symbol(sym.ARTHMEXPMULT,yytext()); }
    {boolexp}           { return symbol(sym.BOOLEXP,yytext()); }
    ";"                 { return symbol(sym.SEMICOLON); }
    ":"                 { return symbol(sym.COLON); }
    ","                 { return symbol(sym.COMMA); }
    "."                 { return symbol(sym.DOT); }
    "("                 { return symbol(sym.LEFTPRNTH); }
    ")"                 { return symbol(sym.RIGTHPRNTH); }
    "{"                 { return symbol(sym.LEFTCBRAC); }
    "}"                 { return symbol(sym.RIGHTCBRAC); }
    "["                 { return symbol(sym.LEFTBRAK); }
    "]"                 { return symbol(sym.RIGHTBRAK); }
    "#"                 { return symbol(sym.NUMERAL); }
    "%d"                { return symbol(sym.DECIMALINT);}
    "%c"                { return symbol(sym.SINGLECHAR);}
    "||"                { return symbol(sym.OR); }
    "&&"                { return symbol(sym.AND); }
    "for"               { return symbol(sym.FOR); }
    "while"             { return symbol(sym.WHILE); }
    "do"                { return symbol(sym.DO); }
    "if"                { return symbol(sym.IF); }
    "else"              { return symbol(sym.ELSE); }
    "define"            { return symbol(sym.DEFINE); }
    "include"           { return symbol(sym.INCLUDE); }
    "return"            { return symbol(sym.RETURN); }
    "break"             { return symbol(sym.BREAK); }
    {null}              { return symbol(sym.NULL, yytext()); }
    {boolToF}           { return symbol(sym.BOOLTOF, yytext()); }
    {letter}		{ return symbol(sym.CHAR_CONST, yytext()); }
    {integer}		{ return symbol(sym.INT_CONST, yytext()); }
    {id}                { return symbol(sym.ID, yytext()); }
    {space}             { }
    .                   { error("Illegal character <"+ yytext()+"> @ Line " + (yyline+1)); }
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
      \"                             { string.append( yytext() ); 
                                       yybegin(YYINITIAL);
                                       return symbol(sym.STRING_LITERAL, string.toString()); }
      [^\n\r\"\\]+                   { string.append( yytext() ); }
      \\t                            { string.append('\t'); }
      \\n                            { string.append('\n'); }
      \\r                            { string.append('\r'); }
      \\\"                           { string.append('\"'); }
      \\                             { string.append('\\'); }
 }