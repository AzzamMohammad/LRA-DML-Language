// Generated from C:/Users/AZZAM/Desktop/My_Compiler/src\HTMLParser.g4 by ANTLR 4.10.1
package gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import symbol_table.FormScope;
import symbol_table.HTMLPageScope;
import symbol_table.PHPPageScope;
import symbol_table.Scope;
import symbol_table.elements.*;
import symbol_table.elements.PHP.GoPhpScope;
import symbol_table.elements.PHP.IfPhpScope;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HTMLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HTMLParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HTMLParser#programs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograms(HTMLParser.ProgramsContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#phpPages}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhpPages(HTMLParser.PhpPagesContext ctx, PHPPageScope phpPageScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#contoller_pages}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContoller_pages(HTMLParser.Contoller_pagesContext ctx,PHPPageScope phpPageScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#controller_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitController_element(HTMLParser.Controller_elementContext ctx,PHPPageScope phpPageScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#if_php}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_php(HTMLParser.If_phpContext ctx, IfPhpScope ifPhpScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#inv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInv(HTMLParser.InvContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#go}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGo(HTMLParser.GoContext ctx, GoPhpScope goPhpScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable(HTMLParser.TableContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#htmlPages}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlPages(HTMLParser.HtmlPagesContext ctx, HTMLPageScope htmlPageScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#pages}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPages(HTMLParser.PagesContext ctx,HTMLPageScope htmlPageScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(HTMLParser.BodyContext ctx,HTMLPageScope htmlPageScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(HTMLParser.ElementContext ctx,HTMLPageScope htmlPageScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm(HTMLParser.FormContext ctx, FormScope formScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#out}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOut(HTMLParser.OutContext ctx, Scope htmlPageScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#mustache}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMustache(HTMLParser.MustacheContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#bigText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBigText(HTMLParser.BigTextContext ctx,Scope htmlPageScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#attribute_bigText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute_bigText(HTMLParser.Attribute_bigTextContext ctx, BigTextScope bigTextScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#img}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImg(HTMLParser.ImgContext ctx,Scope htmlPageScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#attribute_img}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute_img(HTMLParser.Attribute_imgContext ctx,ImageScope imageScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(HTMLParser.TextContext ctx,Scope htmlPageScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#attribute_text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute_text(HTMLParser.Attribute_textContext ctx,TextScope textScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(HTMLParser.ListContext ctx,Scope htmlPageScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#attribute_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute_list(HTMLParser.Attribute_listContext ctx,ListHtmlScope listHtmlScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#link}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLink(HTMLParser.LinkContext ctx,Scope htmlPageScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#buttonLink}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitButtonLink(HTMLParser.ButtonLinkContext ctx,Scope htmlPageScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#attribute_buttonLink}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute_buttonLink(HTMLParser.Attribute_buttonLinkContext ctx, ButtonLinkScope buttonLinkScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#simpleLink}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleLink(HTMLParser.SimpleLinkContext ctx,Scope htmlPageScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#attribute_simpleLink}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute_simpleLink(HTMLParser.Attribute_simpleLinkContext ctx, SimpleLinkScope simpleLinkScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#in}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn(HTMLParser.InContext ctx,Scope htmlPageScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(HTMLParser.FieldContext ctx,Scope htmlPageScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#select}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect(HTMLParser.SelectContext ctx,Scope htmlPageScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#attribute_field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute_field(HTMLParser.Attribute_fieldContext ctx,FieldScope fieldScope);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#attribute_select}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute_select(HTMLParser.Attribute_selectContext ctx, SelectScope selectScope);
}