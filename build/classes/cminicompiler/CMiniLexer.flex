package cminicompiler;

import java_cup.runtime.*;
import java_cup.*;
import java.io.IOException;;

%% 
%class CMiniLexer
%unicode
%int
%cup
%char
%line
%column
%caseless

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
boolToF = "0" | "1"

id = {letter}({letter}|{digit}|[_])*

constchar = "'"{letter}"'"|"'"(" ")"'"

arthmexpSUM = ("+")|("-")
arthmexpMULT = ("*")|("/")
boolexp = ("<")|(">")|("<=")|(">=")|("!=")|("==")
 

null = "null"|"NULL"          

%state COMMENT
%state LINECOMMENT
%state STRING

%%

<YYINITIAL>{
    \"			        { string.setLength(0); string.append(yytext()); yybegin(STRING); }    
    "/*"                { commentLine = yyline+1; stComment++; yybegin(COMMENT); }
    "*/"                { System.out.println("Utilizó */ sin abrirlo"); }
    "//"                { yybegin(LINECOMMENT); }
    "boolean"           { return symbol("boolean", sym.BOOLEAN); }
    "void"              { return symbol("void", sym.VOID); }
    "main"              { return symbol("main", sym.MAIN); }
    "printf"            { return symbol("printf", sym.PRINTF); }
    "scanf"             { return symbol("scanf", sym.SCANF); }
    ";"                 { return symbol("program", sym.SEMICOLON); }
    ","                 { return symbol("program", sym.COMMA); }
    "("                 { return symbol("program", sym.LEFTPRNTH); }
    ")"                 { return symbol("program", sym.RIGHTPRNTH); }
    "{"                 { return symbol("program", sym.LEFTCBRAC); }
    "}"                 { return symbol("program", sym.RIGHTCBRAC); }
    "*"                 { return symbol("program", sym.ASTERISK); }
    "="                 { return symbol(sym.EQUALS); }
    "&"                 { return symbol(sym.AMPERSAND); }
    "%d"                { return symbol(sym.DECIMALINT); }
    "%c"                { return symbol(sym.SINGLECHAR); }
    "||"                { return symbol(sym.OR); }
    "&&"                { return symbol(sym.AND); }
    "for"               { return symbol(sym.FOR); }
    "while"             { return symbol(sym.WHILE); }
    "if"                { return symbol(sym.IF); }
    "else"              { return symbol(sym.ELSE); }
    "return"            { return symbol(sym.RETURN); }
    "break"             { return symbol(sym.BREAK); }
    "int"               { return symbol(sym.INT,yytext()); }
    "char"              { return symbol(sym.CHAR,yytext()); }
    {arthmexpSUM}       { return symbol(sym.ARTHMEXPSUM,yytext()); }
    {arthmexpMULT}      { return symbol(sym.ARTHMEXPMULT,yytext()); }
    {boolexp}           { return symbol(sym.BOOLEXP,yytext()); }
    {null}              { return symbol(sym.NULL, yytext()); }
    {boolToF}           { return symbol(sym.BOOLTOF, yytext()); }
    {constchar}         { return symbol(sym.CONSTCHAR,yytext()); }
    {integer}		    { return symbol(sym.INTEGER, yytext()); }
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
                                       return symbol(sym.CONSTSTR, string.toString()); }
      [^\n\r\"\\]+                   { string.append( yytext() ); }
      \\t                            { string.append('\t'); }
      \\n                            { string.append('\n'); }
      \\r                            { string.append('\r'); }
      \\\"                           { string.append('\"'); }
      \\                             { string.append('\\'); }
 }