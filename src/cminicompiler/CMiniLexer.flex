package cminicompiler;

import java_cup.runtime.*;
import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java.io.Reader;

%%
%public 
%class CMiniLexer
%unicode
%int
%cup
%standalone
%line
%column

%state COMMENT

letter = [a-zA-Z]
digit = [0-9]
space = (" "|"\t")+

integer = {digit}+
boolean = "true"|"false"

id = {letter}({letter}|{digit}|[_])*
%%
<YYINITIAL>{
}

<COMMENT>{
}