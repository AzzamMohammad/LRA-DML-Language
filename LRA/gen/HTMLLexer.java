// Generated from E:/�������/����� �������/F1/compiler/Compiler-project/src\HTMLLexer.g4 by ANTLR 4.9.1
package gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HTMLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HTML_COMMENT=1, HTML_CONDITIONAL_COMMENT=2, XML=3, CDATA=4, DTD=5, SCRIPTLET=6, 
		SEA_WS=7, SCRIPT_OPEN=8, STYLE_OPEN=9, TAG_OPEN=10, HTML_TEXT=11, NG_ATTRBIUTE=12, 
		SINGLE_QOUTE=13, NGFOR=14, ID=15, IN=16, TAG_CLOSE=17, TAG_SLASH_CLOSE=18, 
		TAG_SLASH=19, TAG_EQUALS=20, TAG_NAME=21, TAG_WHITESPACE=22, SCRIPT_BODY=23, 
		SCRIPT_SHORT_BODY=24, STYLE_BODY=25, STYLE_SHORT_BODY=26, ATTVALUE_VALUE=27, 
		ATTRIBUTE=28;
	public static final int
		TAG=1, SCRIPT=2, STYLE=3, ATTVALUE=4;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "TAG", "SCRIPT", "STYLE", "ATTVALUE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"HTML_COMMENT", "HTML_CONDITIONAL_COMMENT", "XML", "CDATA", "DTD", "SCRIPTLET", 
			"SEA_WS", "SCRIPT_OPEN", "STYLE_OPEN", "TAG_OPEN", "HTML_TEXT", "NG_ATTRBIUTE", 
			"SINGLE_QOUTE", "NGFOR", "ID", "IN", "TAG_CLOSE", "TAG_SLASH_CLOSE", 
			"TAG_SLASH", "TAG_EQUALS", "TAG_NAME", "TAG_WHITESPACE", "HEXDIGIT", 
			"DIGIT", "TAG_NameChar", "TAG_NameStartChar", "SCRIPT_BODY", "SCRIPT_SHORT_BODY", 
			"STYLE_BODY", "STYLE_SHORT_BODY", "ATTVALUE_VALUE", "ATTRIBUTE", "ATTCHARS", 
			"ATTCHAR", "HEXCHARS", "DECCHARS", "DOUBLE_QUOTE_STRING", "SINGLE_QUOTE_STRING"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "'<'", null, 
			"'!'", "'''", "'ng-for'", "'x'", "'in'", "'>'", "'/>'", "'/'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "HTML_COMMENT", "HTML_CONDITIONAL_COMMENT", "XML", "CDATA", "DTD", 
			"SCRIPTLET", "SEA_WS", "SCRIPT_OPEN", "STYLE_OPEN", "TAG_OPEN", "HTML_TEXT", 
			"NG_ATTRBIUTE", "SINGLE_QOUTE", "NGFOR", "ID", "IN", "TAG_CLOSE", "TAG_SLASH_CLOSE", 
			"TAG_SLASH", "TAG_EQUALS", "TAG_NAME", "TAG_WHITESPACE", "SCRIPT_BODY", 
			"SCRIPT_SHORT_BODY", "STYLE_BODY", "STYLE_SHORT_BODY", "ATTVALUE_VALUE", 
			"ATTRIBUTE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public HTMLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "HTMLLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\36\u0197\b\1\b\1"+
		"\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\7\2Z\n\2\f\2\16\2]\13\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\7\3h\n\3\f\3\16\3k\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\7\4w\n\4\f\4\16\4z\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\7\5\u0089\n\5\f\5\16\5\u008c\13\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\7\6\u0096\n\6\f\6\16\6\u0099\13\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7\u00a1"+
		"\n\7\f\7\16\7\u00a4\13\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00ac\n\7\f\7\16"+
		"\7\u00af\13\7\3\7\3\7\5\7\u00b3\n\7\3\b\3\b\5\b\u00b7\n\b\3\b\6\b\u00ba"+
		"\n\b\r\b\16\b\u00bb\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00c7\n\t"+
		"\f\t\16\t\u00ca\13\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7"+
		"\n\u00d8\n\n\f\n\16\n\u00db\13\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\f\6\f\u00e6\n\f\r\f\16\f\u00e7\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\7\26\u010b\n\26"+
		"\f\26\16\26\u010e\13\26\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3"+
		"\32\3\32\3\32\5\32\u011c\n\32\3\33\5\33\u011f\n\33\3\34\7\34\u0122\n\34"+
		"\f\34\16\34\u0125\13\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\35\7\35\u0134\n\35\f\35\16\35\u0137\13\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\3\36\7\36\u0140\n\36\f\36\16\36\u0143\13\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\7\37\u0151\n\37"+
		"\f\37\16\37\u0154\13\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \7 \u015d\n \f"+
		" \16 \u0160\13 \3 \3 \3 \3 \3!\3!\3!\3!\3!\5!\u016b\n!\3\"\6\"\u016e\n"+
		"\"\r\"\16\"\u016f\3\"\5\"\u0173\n\"\3#\5#\u0176\n#\3$\3$\6$\u017a\n$\r"+
		"$\16$\u017b\3%\6%\u017f\n%\r%\16%\u0180\3%\5%\u0184\n%\3&\3&\7&\u0188"+
		"\n&\f&\16&\u018b\13&\3&\3&\3\'\3\'\7\'\u0191\n\'\f\'\16\'\u0194\13\'\3"+
		"\'\3\'\17[ix\u008a\u0097\u00a2\u00ad\u00c8\u00d9\u0123\u0135\u0141\u0152"+
		"\2(\7\3\t\4\13\5\r\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35\16\37\17!"+
		"\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63\2\65\2\67\29\2;\31=\32?\33A"+
		"\34C\35E\36G\2I\2K\2M\2O\2Q\2\7\2\3\4\5\6\r\4\2\13\13\"\"\3\2>>\5\2\13"+
		"\f\17\17\"\"\5\2\62;CHch\3\2\62;\4\2/\60aa\5\2\u00b9\u00b9\u0302\u0371"+
		"\u2041\u2042\n\2<<C\\c|\u2072\u2191\u2c02\u2ff1\u3003\ud801\uf902\ufdd1"+
		"\ufdf2\uffff\t\2%%-=??AAC\\aac|\4\2$$>>\4\2))>>\2\u01aa\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2"+
		"\3\37\3\2\2\2\3!\3\2\2\2\3#\3\2\2\2\3%\3\2\2\2\3\'\3\2\2\2\3)\3\2\2\2"+
		"\3+\3\2\2\2\3-\3\2\2\2\3/\3\2\2\2\3\61\3\2\2\2\4;\3\2\2\2\4=\3\2\2\2\5"+
		"?\3\2\2\2\5A\3\2\2\2\6C\3\2\2\2\6E\3\2\2\2\7S\3\2\2\2\tb\3\2\2\2\13o\3"+
		"\2\2\2\r}\3\2\2\2\17\u0091\3\2\2\2\21\u00b2\3\2\2\2\23\u00b9\3\2\2\2\25"+
		"\u00bd\3\2\2\2\27\u00cf\3\2\2\2\31\u00e0\3\2\2\2\33\u00e5\3\2\2\2\35\u00e9"+
		"\3\2\2\2\37\u00eb\3\2\2\2!\u00ed\3\2\2\2#\u00f4\3\2\2\2%\u00f6\3\2\2\2"+
		"\'\u00f9\3\2\2\2)\u00fd\3\2\2\2+\u0102\3\2\2\2-\u0104\3\2\2\2/\u0108\3"+
		"\2\2\2\61\u010f\3\2\2\2\63\u0113\3\2\2\2\65\u0115\3\2\2\2\67\u011b\3\2"+
		"\2\29\u011e\3\2\2\2;\u0123\3\2\2\2=\u0135\3\2\2\2?\u0141\3\2\2\2A\u0152"+
		"\3\2\2\2C\u015e\3\2\2\2E\u016a\3\2\2\2G\u016d\3\2\2\2I\u0175\3\2\2\2K"+
		"\u0177\3\2\2\2M\u017e\3\2\2\2O\u0185\3\2\2\2Q\u018e\3\2\2\2ST\7>\2\2T"+
		"U\7#\2\2UV\7/\2\2VW\7/\2\2W[\3\2\2\2XZ\13\2\2\2YX\3\2\2\2Z]\3\2\2\2[\\"+
		"\3\2\2\2[Y\3\2\2\2\\^\3\2\2\2][\3\2\2\2^_\7/\2\2_`\7/\2\2`a\7@\2\2a\b"+
		"\3\2\2\2bc\7>\2\2cd\7#\2\2de\7]\2\2ei\3\2\2\2fh\13\2\2\2gf\3\2\2\2hk\3"+
		"\2\2\2ij\3\2\2\2ig\3\2\2\2jl\3\2\2\2ki\3\2\2\2lm\7_\2\2mn\7@\2\2n\n\3"+
		"\2\2\2op\7>\2\2pq\7A\2\2qr\7z\2\2rs\7o\2\2st\7n\2\2tx\3\2\2\2uw\13\2\2"+
		"\2vu\3\2\2\2wz\3\2\2\2xy\3\2\2\2xv\3\2\2\2y{\3\2\2\2zx\3\2\2\2{|\7@\2"+
		"\2|\f\3\2\2\2}~\7>\2\2~\177\7#\2\2\177\u0080\7]\2\2\u0080\u0081\7E\2\2"+
		"\u0081\u0082\7F\2\2\u0082\u0083\7C\2\2\u0083\u0084\7V\2\2\u0084\u0085"+
		"\7C\2\2\u0085\u0086\7]\2\2\u0086\u008a\3\2\2\2\u0087\u0089\13\2\2\2\u0088"+
		"\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u008b\3\2\2\2\u008a\u0088\3\2"+
		"\2\2\u008b\u008d\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008e\7_\2\2\u008e"+
		"\u008f\7_\2\2\u008f\u0090\7@\2\2\u0090\16\3\2\2\2\u0091\u0092\7>\2\2\u0092"+
		"\u0093\7#\2\2\u0093\u0097\3\2\2\2\u0094\u0096\13\2\2\2\u0095\u0094\3\2"+
		"\2\2\u0096\u0099\3\2\2\2\u0097\u0098\3\2\2\2\u0097\u0095\3\2\2\2\u0098"+
		"\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b\7@\2\2\u009b\20\3\2\2\2"+
		"\u009c\u009d\7>\2\2\u009d\u009e\7A\2\2\u009e\u00a2\3\2\2\2\u009f\u00a1"+
		"\13\2\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a3\3\2\2\2"+
		"\u00a2\u00a0\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a6"+
		"\7A\2\2\u00a6\u00b3\7@\2\2\u00a7\u00a8\7>\2\2\u00a8\u00a9\7\'\2\2\u00a9"+
		"\u00ad\3\2\2\2\u00aa\u00ac\13\2\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00af\3"+
		"\2\2\2\u00ad\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00b0\3\2\2\2\u00af"+
		"\u00ad\3\2\2\2\u00b0\u00b1\7\'\2\2\u00b1\u00b3\7@\2\2\u00b2\u009c\3\2"+
		"\2\2\u00b2\u00a7\3\2\2\2\u00b3\22\3\2\2\2\u00b4\u00ba\t\2\2\2\u00b5\u00b7"+
		"\7\17\2\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2"+
		"\u00b8\u00ba\7\f\2\2\u00b9\u00b4\3\2\2\2\u00b9\u00b6\3\2\2\2\u00ba\u00bb"+
		"\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\24\3\2\2\2\u00bd"+
		"\u00be\7>\2\2\u00be\u00bf\7u\2\2\u00bf\u00c0\7e\2\2\u00c0\u00c1\7t\2\2"+
		"\u00c1\u00c2\7k\2\2\u00c2\u00c3\7r\2\2\u00c3\u00c4\7v\2\2\u00c4\u00c8"+
		"\3\2\2\2\u00c5\u00c7\13\2\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00ca\3\2\2\2"+
		"\u00c8\u00c9\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00c8"+
		"\3\2\2\2\u00cb\u00cc\7@\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\b\t\2\2\u00ce"+
		"\26\3\2\2\2\u00cf\u00d0\7>\2\2\u00d0\u00d1\7u\2\2\u00d1\u00d2\7v\2\2\u00d2"+
		"\u00d3\7{\2\2\u00d3\u00d4\7n\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d9\3\2\2"+
		"\2\u00d6\u00d8\13\2\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9"+
		"\u00da\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00dc\3\2\2\2\u00db\u00d9\3\2"+
		"\2\2\u00dc\u00dd\7@\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\b\n\3\2\u00df"+
		"\30\3\2\2\2\u00e0\u00e1\7>\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\b\13\4"+
		"\2\u00e3\32\3\2\2\2\u00e4\u00e6\n\3\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00e7"+
		"\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\34\3\2\2\2\u00e9"+
		"\u00ea\7#\2\2\u00ea\36\3\2\2\2\u00eb\u00ec\7)\2\2\u00ec \3\2\2\2\u00ed"+
		"\u00ee\7p\2\2\u00ee\u00ef\7i\2\2\u00ef\u00f0\7/\2\2\u00f0\u00f1\7h\2\2"+
		"\u00f1\u00f2\7q\2\2\u00f2\u00f3\7t\2\2\u00f3\"\3\2\2\2\u00f4\u00f5\7z"+
		"\2\2\u00f5$\3\2\2\2\u00f6\u00f7\7k\2\2\u00f7\u00f8\7p\2\2\u00f8&\3\2\2"+
		"\2\u00f9\u00fa\7@\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\b\22\5\2\u00fc("+
		"\3\2\2\2\u00fd\u00fe\7\61\2\2\u00fe\u00ff\7@\2\2\u00ff\u0100\3\2\2\2\u0100"+
		"\u0101\b\23\5\2\u0101*\3\2\2\2\u0102\u0103\7\61\2\2\u0103,\3\2\2\2\u0104"+
		"\u0105\7?\2\2\u0105\u0106\3\2\2\2\u0106\u0107\b\25\6\2\u0107.\3\2\2\2"+
		"\u0108\u010c\59\33\2\u0109\u010b\5\67\32\2\u010a\u0109\3\2\2\2\u010b\u010e"+
		"\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\60\3\2\2\2\u010e"+
		"\u010c\3\2\2\2\u010f\u0110\t\4\2\2\u0110\u0111\3\2\2\2\u0111\u0112\b\27"+
		"\7\2\u0112\62\3\2\2\2\u0113\u0114\t\5\2\2\u0114\64\3\2\2\2\u0115\u0116"+
		"\t\6\2\2\u0116\66\3\2\2\2\u0117\u011c\59\33\2\u0118\u011c\t\7\2\2\u0119"+
		"\u011c\5\65\31\2\u011a\u011c\t\b\2\2\u011b\u0117\3\2\2\2\u011b\u0118\3"+
		"\2\2\2\u011b\u0119\3\2\2\2\u011b\u011a\3\2\2\2\u011c8\3\2\2\2\u011d\u011f"+
		"\t\t\2\2\u011e\u011d\3\2\2\2\u011f:\3\2\2\2\u0120\u0122\13\2\2\2\u0121"+
		"\u0120\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0124\3\2\2\2\u0123\u0121\3\2"+
		"\2\2\u0124\u0126\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0127\7>\2\2\u0127"+
		"\u0128\7\61\2\2\u0128\u0129\7u\2\2\u0129\u012a\7e\2\2\u012a\u012b\7t\2"+
		"\2\u012b\u012c\7k\2\2\u012c\u012d\7r\2\2\u012d\u012e\7v\2\2\u012e\u012f"+
		"\7@\2\2\u012f\u0130\3\2\2\2\u0130\u0131\b\34\5\2\u0131<\3\2\2\2\u0132"+
		"\u0134\13\2\2\2\u0133\u0132\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0136\3"+
		"\2\2\2\u0135\u0133\3\2\2\2\u0136\u0138\3\2\2\2\u0137\u0135\3\2\2\2\u0138"+
		"\u0139\7>\2\2\u0139\u013a\7\61\2\2\u013a\u013b\7@\2\2\u013b\u013c\3\2"+
		"\2\2\u013c\u013d\b\35\5\2\u013d>\3\2\2\2\u013e\u0140\13\2\2\2\u013f\u013e"+
		"\3\2\2\2\u0140\u0143\3\2\2\2\u0141\u0142\3\2\2\2\u0141\u013f\3\2\2\2\u0142"+
		"\u0144\3\2\2\2\u0143\u0141\3\2\2\2\u0144\u0145\7>\2\2\u0145\u0146\7\61"+
		"\2\2\u0146\u0147\7u\2\2\u0147\u0148\7v\2\2\u0148\u0149\7{\2\2\u0149\u014a"+
		"\7n\2\2\u014a\u014b\7g\2\2\u014b\u014c\7@\2\2\u014c\u014d\3\2\2\2\u014d"+
		"\u014e\b\36\5\2\u014e@\3\2\2\2\u014f\u0151\13\2\2\2\u0150\u014f\3\2\2"+
		"\2\u0151\u0154\3\2\2\2\u0152\u0153\3\2\2\2\u0152\u0150\3\2\2\2\u0153\u0155"+
		"\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u0156\7>\2\2\u0156\u0157\7\61\2\2\u0157"+
		"\u0158\7@\2\2\u0158\u0159\3\2\2\2\u0159\u015a\b\37\5\2\u015aB\3\2\2\2"+
		"\u015b\u015d\7\"\2\2\u015c\u015b\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c"+
		"\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0161\3\2\2\2\u0160\u015e\3\2\2\2\u0161"+
		"\u0162\5E!\2\u0162\u0163\3\2\2\2\u0163\u0164\b \5\2\u0164D\3\2\2\2\u0165"+
		"\u016b\5O&\2\u0166\u016b\5Q\'\2\u0167\u016b\5G\"\2\u0168\u016b\5K$\2\u0169"+
		"\u016b\5M%\2\u016a\u0165\3\2\2\2\u016a\u0166\3\2\2\2\u016a\u0167\3\2\2"+
		"\2\u016a\u0168\3\2\2\2\u016a\u0169\3\2\2\2\u016bF\3\2\2\2\u016c\u016e"+
		"\5I#\2\u016d\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u016d\3\2\2\2\u016f"+
		"\u0170\3\2\2\2\u0170\u0172\3\2\2\2\u0171\u0173\7\"\2\2\u0172\u0171\3\2"+
		"\2\2\u0172\u0173\3\2\2\2\u0173H\3\2\2\2\u0174\u0176\t\n\2\2\u0175\u0174"+
		"\3\2\2\2\u0176J\3\2\2\2\u0177\u0179\7%\2\2\u0178\u017a\t\5\2\2\u0179\u0178"+
		"\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c"+
		"L\3\2\2\2\u017d\u017f\t\6\2\2\u017e\u017d\3\2\2\2\u017f\u0180\3\2\2\2"+
		"\u0180\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0183\3\2\2\2\u0182\u0184"+
		"\7\'\2\2\u0183\u0182\3\2\2\2\u0183\u0184\3\2\2\2\u0184N\3\2\2\2\u0185"+
		"\u0189\7$\2\2\u0186\u0188\n\13\2\2\u0187\u0186\3\2\2\2\u0188\u018b\3\2"+
		"\2\2\u0189\u0187\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018c\3\2\2\2\u018b"+
		"\u0189\3\2\2\2\u018c\u018d\7$\2\2\u018dP\3\2\2\2\u018e\u0192\7)\2\2\u018f"+
		"\u0191\n\f\2\2\u0190\u018f\3\2\2\2\u0191\u0194\3\2\2\2\u0192\u0190\3\2"+
		"\2\2\u0192\u0193\3\2\2\2\u0193\u0195\3\2\2\2\u0194\u0192\3\2\2\2\u0195"+
		"\u0196\7)\2\2\u0196R\3\2\2\2&\2\3\4\5\6[ix\u008a\u0097\u00a2\u00ad\u00b2"+
		"\u00b6\u00b9\u00bb\u00c8\u00d9\u00e7\u010c\u011b\u011e\u0123\u0135\u0141"+
		"\u0152\u015e\u016a\u016f\u0172\u0175\u017b\u0180\u0183\u0189\u0192\b\7"+
		"\4\2\7\5\2\7\3\2\6\2\2\7\6\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}