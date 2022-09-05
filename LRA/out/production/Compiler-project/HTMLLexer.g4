lexer grammar  HTMLLexer;

PHP_PAGE
    :'CONTROLLER' -> pushMode(CONTOLLER)
    ;
HTML_PAGE
    :'PAGE' -> pushMode(PAGE)
    ;
WHITESPACQ : [ \t\r\n]+ -> skip ;
//TODO HTML LEXER ................
// TODO RIDA

mode PAGE;

WHITESPAC : [ \t\r\n]+ -> skip ;

BODY_KEY : 'start body' -> pushMode(BODY) ;
EXTENDS : 'extends';
COMMA_EXTENDS : ',' ;
OPEN_CURLY_BRACKET
    :'{'
    ;

CLOSE_CURLY_BRACKET
    :'}' -> popMode
    ;

PAGE_NAME
    : PAGE_NameStartChar PAGE_NameChar*
    ;

fragment
DIGIT
    : [0-9]
    ;
fragment
PAGE_NameChar
    : PAGE_NameStartChar
    | '-'
    | '_'
    | '.'
    | DIGIT
    | '\u00B7'
    | '\u0300'..'\u036F'
    | '\u203F'..'\u2040'
    ;

fragment
PAGE_NameStartChar
    : [:a-zA-Z]
    | '\u2070'..'\u218F'
    | '\u2C00'..'\u2FEF'
    | '\u3001'..'\uD7FF'
    | '\uF900'..'\uFDCF'
    | '\uFDF0'..'\uFFFD'
    ;
///////////////////

mode BODY;
WHITESPAC2 : [ \t\r\n]+ -> skip ; // Don't modify this -_-
OUT_KEY : 'out' -> pushMode(OUT); // this is the syntex of out,in,link ....
IN_KEY : 'in' -> pushMode(IN);
LINK_KEY: 'link' -> pushMode(LINK);
FORM_KEY : 'start form' -> pushMode(FORM_MODE);
END_BODY_KEY : 'end body' -> popMode;

mode FORM_MODE;
WHITESPAC_FORM : [ \t\r\n]+ -> skip ;
OUT_KEY_FORM : 'out' -> pushMode(OUT);
IN_KEY_FORM : 'in' -> pushMode(IN);
LINK_KEY_FORM: 'link' -> pushMode(LINK);
END_FORM_KEY : 'end form' -> popMode;


mode OUT;
WHITESPAC5 : [ \t\r\n]+ -> skip ;
DOUBLE_DOT : ':' ;
BIGTEXT : 'BigText' -> pushMode(OUT_BIGTEXT);
IMG : 'Img' -> pushMode(OUT_IMG);
TEXT : 'Text' -> pushMode(OUT_TEXT);
LIST : 'List' -> pushMode(OUT_LIST);




mode OUT_BIGTEXT;

WHITESPAC1 : [ \t\r\n]+ -> skip ;
OPEN_BRACKET : '(' ;
CLOSE_BRACKET : ')'->popMode,popMode ;
ATTRIBUTE_SCALE : 'scale' -> pushMode(SCALE);
ATTRIBUTE_TITLE : 'title'  -> pushMode(ANY_TEXT);
COMMA : ',' ;

mode SCALE;
DOUBLE_DOT1 : ':' ;
WHITESPAC3 : [ \t\r\n]+ -> skip ;
NUMBER_SCALE : [1-6]-> popMode;


mode ANY_TEXT;// this is the text ,, use this for any text
WHITESPAC4 : [ \t\r\n]+ -> skip ;
DOUBLE_DOT2 : ':' '"';
DOUBLE_MUSTACHE_OPEN : '{{'->pushMode(MUSTACHE);
ATEXT :  ~["{]+;
DOUBLE_QUT : '"' -> popMode;


mode MUSTACHE;
WHITESPAC_MUSTACHE : [ \t\r\n]+ -> skip ;
MUSTACHE_TEXT
    : MUSTACHE_NameStartChar MUSTACHE_NameChar*
    ;
COMMA_MUSTACHE : ',' ;
fragment
DIGIT_MUSTACHE
    : [0-9]
    ;
fragment
MUSTACHE_NameChar
    : MUSTACHE_NameStartChar
    | '-'
    | '_'
    | DIGIT_MUSTACHE
    ;

fragment
MUSTACHE_NameStartChar
    : [:a-zA-Z]
    ;
DOUBLE_MUSTACHE_CLOSE : '}}'->popMode;



mode OUT_IMG;
WHITESPAC6 : [ \t\r\n]+ -> skip ;
OPEN_BRACKET1 : '(' ;
CLOSE_BRACKE1 : ')'->popMode,popMode ;
ATTRIBUTE_PATH : 'path' -> pushMode(ANY_TEXT);
ATTRIBUTE_ALT_TEXT : 'alt_text' -> pushMode(ANY_TEXT);
COMMA1 : ',' ;

mode OUT_TEXT;
WHITESPAC7 : [ \t\r\n]+ -> skip ;
OPEN_BRACKET2 : '(' ;
CLOSE_BRACKE2 : ')'->popMode,popMode ;
ATTRIBUTE_TYPE : 'type' -> pushMode(TYPE_FOR_TEXT);
ATTRIBUTE_TITLE1 : 'title' -> pushMode(ANY_TEXT);
COMMA2 : ',' ;

mode TYPE_FOR_TEXT;
WHITESPAC8 : [ \t\r\n]+ -> skip ;
DOUBLE_DOT3 : ':' ;
TYPE_TEXT : TYPE -> popMode;
fragment
TYPE
 :'lable'
 |'span'
 |'i'
 |'p'
 |'strong'
 ;


//TODO LANA
mode IN;
WHITESPAC20 : [ \t\r\n]+ -> skip ;
DOUBLE_DOT20 : ':' ;
IN_FIELD : 'field' -> pushMode(FIELD);
IN_SELECT : 'select' -> pushMode(SELECT);

mode FIELD;
WHITESPAC21 : [ \t\r\n]+ -> skip ;
OPEN_BRACKET21 : '(' ;
CLOSE_BRACKET21 : ')'->popMode,popMode ;
ATTRIBUTE_TITLE21 : 'title' -> pushMode(ANY_TEXT);
ATTRIBUTE_TYPE21 : 'type' -> pushMode(TYPE);
ATTRIBUTE_NAME21 : 'name' -> pushMode(ANY_TEXT);
ATTRIBUTE_HINT21 : 'hint' -> pushMode(ANY_TEXT);
ATTRIBUTE_REQUIRED21:'required';
COMMA21 : ',' ;

mode TYPE;
WHITESPAC22 : [ \t\r\n]+ -> skip ;
DOUBLE_DOT22 : ':' ;
TYPE_FIELD : TYPE22 -> popMode;
fragment
TYPE22
 :'submit'
 |'password'
 |'email'
 |'checkbox'
 |'date'
 |'file'
 ;

mode SELECT;
WHITESPAC23 : [ \t\r\n]+ -> skip ;
OPEN_BRACKET23 : '(' ;
CLOSE_BRACKET23 : ')'->popMode,popMode ;
ATTRIBUTE_OPTION23 : 'option' -> pushMode(OPTION);
ATTRIBUTE_NAME23 : 'name' -> pushMode(ANY_TEXT);
COMMA23 : ',' ;

mode OPTION;
WHITESPAC24 : [ \t\r\n]+ -> skip ;
OPEN_BRACKET24 : '(' ;
CLOSE_BRACKET24 : ')'->popMode;
ATTRIBUTE_TITLE24 : 'title' -> pushMode(ANY_TEXT);
ATTRIBUTE_VALUE24 : 'value' -> pushMode(ANY_TEXT);
COMMA24 : ',' ;

//TODO RIDA
mode LINK;
WHITESPAC9 : [ \t\r\n]+ -> skip ;
DOUBLE_DOT4 : ':' ;
LINK_BUTTON : 'buttonLink' -> pushMode(BUTTONLINK);
LINK_SIMPLE : 'simpleLink' -> pushMode(SIMPLELINK);

mode BUTTONLINK;
WHITESPAC10 : [ \t\r\n]+ -> skip ;
OPEN_BRACKET3 : '(' ;
CLOSE_BRACKET3 : ')'->popMode,popMode ;
ATTRIBUTE_HREF : 'href' -> pushMode(ANY_TEXT);
ATTRIBUTE_TEXT : 'text' -> pushMode(ANY_TEXT);
COMMA3 : ',' ;

mode SIMPLELINK;
WHITESPAC11 : [ \t\r\n]+ -> skip ;
OPEN_BRACKET4 : '(' ;
CLOSE_BRACKET4 : ')'->popMode,popMode ;
ATTRIBUTE_HREF1 : 'href' -> pushMode(ANY_TEXT);
ATTRIBUTE_TEXT2 : 'text' -> pushMode(ANY_TEXT);
COMMA4 : ',' ;

mode OUT_LIST;
WHITESPAC12 : [ \t\r\n]+ -> skip ;
OPEN_BRACKET5 : '(' ;
CLOSE_BRACKET5 : ')'->popMode,popMode ;
ATTRIBUTE_OPTION : 'option' -> pushMode(OPTION_LIST);
ATTRIBUTE_NUMBERED : 'numbered' -> pushMode(NUMBERED);
COMMA5 : ',' ;

mode OPTION_LIST;
WHITESPAC13 : [ \t\r\n]+ -> skip ;
OPEN_BRACKET6 : '(' '"'  -> pushMode(ANY_TEXT);
CLOSE_BRACKET6 : ')'->popMode;


mode NUMBERED;
WHITESPAC14 : [ \t\r\n]+ -> skip ;
DOUBLE_DOT5 : ':' ;
NUMBERED_VALUE : TYPE2 -> popMode;
fragment
TYPE2
 :'true'
 |'false'
 ;
//TODO END HTML LEXER ................


//TODO PHP LEXER ................



mode CONTOLLER;
WHITE_SPAC : [ \t\r\n]+ -> skip ;
OPEN_CURLY_BRACKET_CONTROL :'{'-> pushMode(CONTOLLER_BODY) ;
CONTROL : 'control' ;


CONTOLLER_PAGE_NAME
    : CONTOLLER_NameStartChar CONTOLLER_NameChar*
    ;

fragment
DIGIT1
    : [0-9]
    ;
fragment
CONTOLLER_NameChar
    : CONTOLLER_NameStartChar
    | '-'
    | '_'
    | '.'
    | DIGIT1
    | '\u00B7'
    | '\u0300'..'\u036F'
    | '\u203F'..'\u2040'
    ;

fragment
CONTOLLER_NameStartChar
    : [:a-zA-Z]
    | '\u2070'..'\u218F'
    | '\u2C00'..'\u2FEF'
    | '\u3001'..'\uD7FF'
    | '\uF900'..'\uFDCF'
    | '\uFDF0'..'\uFFFD'
    ;

mode CONTOLLER_BODY;
WHITE_SPAC1 : [ \t\r\n]+ -> skip ;

//TODO LAST VERSION
SERVER_NAME : 'server'-> pushMode(ANY_TEXT);
USER_NAME : 'user'-> pushMode(ANY_TEXT);
PASSWORD :'password'-> pushMode(ANY_TEXT);
DB_NAME : 'db_name'-> pushMode(ANY_TEXT);
//TODO

INSERT_TO : 'insert' -> pushMode(INV_MODE);
SELECT_OF : 'select' -> pushMode(INV_MODE);
VALID_IN : 'valid' -> pushMode(INV_MODE);
GO : 'go' -> pushMode(GO_MODE);
IF : 'if' ;
OPEN_BRACKET_IF : '(';
CLOSE_BRACKET_IF : ')';
OPEN_CURLY_BRACKET_IF: '{' -> pushMode(IF_MODE);

COLSE_CURLY_BRACKET_CONTROL: '}'->popMode,popMode;

//TODO
mode IF_MODE;
WHITE_SPAC7 : [ \t\r\n]+ -> skip ;
INSERT_TO_INIF : 'insert' -> pushMode(INV_MODE);
SELECT_OF_INIF : 'select' -> pushMode(INV_MODE);
VALID_IN_INIF : 'valid' -> pushMode(INV_MODE);
GO_INIF: 'go' -> pushMode(GO_MODE);
COLSE_CURLY_BRACKET_IF: '}'->popMode;

//TODO
mode GO_MODE;
WHITE_SPAC6 : [ \t\r\n]+ -> skip ;
OPEN_BRACKET_GO : '(';
ROLE : 'role';
DOUBLE_DOT_GO : ':' ;
GO_VLAUE
    : GO_NameStartChar GO_NameChar*
    ;

fragment
DIGIT6
    : [0-9]
    ;
fragment
GO_NameChar
    : GO_NameStartChar
    | '-'
    | '_'
    | '.'
    | DIGIT6
    ;

fragment
GO_NameStartChar
    : [a-zA-Z]
    ;
CLOSE_BRACKET_GO : ')'->popMode;


//TODO
mode INV_MODE;
WHITE_SPAC5 : [ \t\r\n]+ -> skip ;
OPEN_BRACKET_INV : '(';
COMMA_INV : ',';
INV_VLAUE
    : INV_NameStartChar INV_NameChar*
    ;

fragment
DIGIT5
    : [0-9]
    ;
fragment
INV_NameChar
    : INV_NameStartChar
    | '-'
    | '_'
    | '.'
    | DIGIT5
    | '\u00B7'
    | '\u0300'..'\u036F'
    | '\u203F'..'\u2040'
    ;

fragment
INV_NameStartChar
    : [:a-zA-Z]
    | '\u2070'..'\u218F'
    | '\u2C00'..'\u2FEF'
    | '\u3001'..'\uD7FF'
    | '\uF900'..'\uFDCF'
    | '\uFDF0'..'\uFFFD'
    ;
CLOSE_BRACKET_INV : ')'-> pushMode(TABLE);



mode TABLE;
WHITE_SPAC4 : [ \t\r\n]+ -> skip ;
TABLE_VLAUE
    : TABLE_NameStartChar TABLE_NameChar* ->popMode,popMode
    ;

fragment
DIGIT4
    : [0-9]
    ;
fragment
TABLE_NameChar
    : TABLE_NameStartChar
    | '-'
    | '_'
    | '.'
    | DIGIT4
    | '\u00B7'
    | '\u0300'..'\u036F'
    | '\u203F'..'\u2040'
    ;

fragment
TABLE_NameStartChar
    : [:a-zA-Z]
    | '\u2070'..'\u218F'
    | '\u2C00'..'\u2FEF'
    | '\u3001'..'\uD7FF'
    | '\uF900'..'\uFDCF'
    | '\uFDF0'..'\uFFFD'
    ;