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
boolean = "true"|"false"

id = {letter}({letter}|{digit}|[_])*

constchar = "'"{letter}"'"|"'"(" ")"'"
conststr = "\""({letter}|{space})*"\""

arthmexpSUM = ("+")|("-")
arthmexpMULT = ("*")|("/")
boolexp = ("<")|(">")|("<=")|(">=")|("!=")|("==")                

%state COMMENT
%state LINECOMMENT
%state STRING

%%
<YYINITIAL>{
    "/*"                { commentLine = yyline+1; stComment++; yybegin(COMMENT); }
    "*/"                { System.out.println("Utilizó */ sin abrirlo"); }
    "//"                { yybegin(LINECOMMENT); }
    "int"               { System.out.println("Se econtró: int"); }
    "int*"              { System.out.println("Se econtró: int*"); }
    "char"              { System.out.println("Se econtró: char"); }
    "char*"             { System.out.println("Se econtró: char*"); }
    "boolean"           { System.out.println("Se econtró: boolean"); }
    {conststr}          { System.out.println("conststr: "+ yytext()); }
    {constchar}         { System.out.println("constchar: "+ yytext()); }
    "void"              { System.out.println("Se econtró: void"); }
    "printf"            { System.out.println("printf"); }
    "scanf"             { System.out.println("scanf"); }
    {arthmexpSUM}       { System.out.println("Arithmetic expresion for SUM: "+yytext()); }
    {arthmexpMULT}      { System.out.println("Arithmetic expresion for MULTIPLICATION: "+yytext()); }
    {boolexp}           { System.out.println("Boolean Expresion: "+yytext()); }
    ";"                 { System.out.println("Se econtró: ;"); }
    ","                 { System.out.println("Se econtró: ,"); }
    "."                 { System.out.println("Se econtró: ."); }
    "("                 { System.out.println("Se econtró: )"); }
    ")"                 { System.out.println("Se econtró: ("); }
    "{"                 { System.out.println("Se econtró: {"); }
    "}"                 { System.out.println("Se econtró: }"); }
    "["                 { System.out.println("Se econtró: ["); }
    "]"                 { System.out.println("Se econtró: ]"); }
    "#"                 { System.out.println("Se econtró: #"); }
    "||"                { System.out.println("Se econtró: ||"); }
    "&&"                { System.out.println("Se econtró: &&"); }
    "for"               { System.out.println("TYPE Se econtró: for"); }
    "while"             { System.out.println("TYPE Se econtró: while"); }
    "do"                { System.out.println("TYPE Se econtró: do"); }
    "if"                { System.out.println("TYPE EXPR Se econtró: if"); }
    "else"              { System.out.println("TYPE EXPR Se econtró: else"); }
    "define"            { System.out.println("Se econtró: define"); }
    "include"           { System.out.println("Se econtró: include"); }
    "return"            { System.out.println("Se econtró: return"); }
    "break"             { System.out.println("Se econtró: break"); }
    "NULL"              { System.out.println("NULL Se econtró: NULL"); }
    "null"              { System.out.println("NULL Se econtró: null"); }
    {boolean}           { System.out.println("TRUE|FALSE Se econtró: "+yytext()); }
    {id}                { System.out.println("ID: "+yytext()); }
    {integer}           { System.out.println("INTEGER: "+yytext()); }
    {space}             { }
    .                   { System.out.println("No se reconoce el simbolo: "+yytext()); }
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
                                       System.out.println("String literal: "+ string.toString()); }
      [^\n\r\"\\]+                   { string.append( yytext() ); }
      \\t                            { string.append('\t'); }
      \\n                            { string.append('\n'); }
      \\r                            { string.append('\r'); }
      \\\"                           { string.append('\"'); }
      \\                             { string.append('\\'); }
 }