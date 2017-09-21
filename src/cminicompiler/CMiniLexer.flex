package cminicompiler;

import java_cup.runtime.*;
import java_cup.*;
import java.io.IOException;;
import java_cup.runtime.Symbol;

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
            return new Symbol(sym, yyline, yycolumn, name);
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
    \"			{ string.setLength(0); string.append(yytext()); yybegin(STRING); }    
    "/*"                { commentLine = yyline+1; stComment++; yybegin(COMMENT); }
    "*/"                { System.out.println("Utilizó */ sin abrirlo"); }
    "//"                { yybegin(LINECOMMENT); }
    "boolean"           { return symbol("boolean", sym.BOOLEAN); }
    "void"              { return symbol("void", sym.VOID); }
    "main"              { return symbol("main", sym.MAIN); }
    "printf"            { return symbol("printf", sym.PRINTF); }
    "scanf"             { return symbol("scanf", sym.SCANF); }
    ";"                 { return symbol(";", sym.SEMICOLON); }
    ","                 { return symbol(",", sym.COMMA); }
    "("                 { return symbol("(", sym.LEFTPRNTH); }
    ")"                 { return symbol(")", sym.RIGHTPRNTH, "hola"); }
    "{"                 { return symbol("{", sym.LEFTCBRAC); }
    "}"                 { return symbol("}", sym.RIGHTCBRAC); }
    "*"                 { return symbol("*", sym.ASTERISK); }
    "/"                 { return symbol("*", sym.DIVIDE); }
    "="                 { return symbol("=", sym.EQUALS); }
    "&"                 { return symbol("&", sym.AMPERSAND); }
    "%d"                { return symbol("%d", sym.DECIMALINT); }
    "%c"                { return symbol("%c", sym.SINGLECHAR); }
    "||"                { return symbol("||", sym.OR); }
    "&&"                { return symbol("&&", sym.AND); }
    "for"               { return symbol("for", sym.FOR); }
    "while"             { return symbol("while", sym.WHILE); }
    "if"                { return symbol("if", sym.IF); }
    "else"              { return symbol("else", sym.ELSE); }
    "return"            { return symbol("return", sym.RETURN); }
    "break"             { return symbol("break", sym.BREAK); }
    "int"               { return symbol("int", sym.INT); }
    "char"              { return symbol("char", sym.CHAR); }
    {arthmexpSUM}       { return symbol("arthmExpSUM", sym.ARTHMEXPSUM,yytext()); }
    {boolexp}           { return symbol("boolexp", sym.BOOLEXP,yytext()); }
    {null}              { return symbol("null", sym.NULL, yytext()); }
    {boolToF}           { return symbol("boolToF", sym.BOOLTOF, yytext()); }
    {constchar}         { return symbol("constchar", sym.CONSTCHAR,yytext()); }
    {integer}		{ return symbol("integer", sym.INTEGER, yytext()); }
    {id}                { return symbol("id", sym.ID, yytext()); }
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
                                       return symbol("conststr", sym.CONSTSTR, string.toString()); }
      [^\n\r\"\\]+                   { string.append( yytext() ); }
      \\t                            { string.append('\t'); }
      \\n                            { string.append('\n'); }
      \\r                            { string.append('\r'); }
      \\\"                           { string.append('\"'); }
      \\                             { string.append('\\'); }
 }