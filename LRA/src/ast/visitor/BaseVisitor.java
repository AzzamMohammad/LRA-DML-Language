package ast.visitor;


import ast.visitor.nodes.*;
import ast.visitor.nodes.html.*;
import ast.visitor.nodes.html.in.Select;
import ast.visitor.nodes.html.out.*;
import ast.visitor.nodes.html.in.*;
import ast.visitor.nodes.html.link.*;
import ast.visitor.nodes.html.out.List;
import ast.visitor.nodes.php.*;
import gen.HTMLParser;

import gen.HTMLParserBaseVisitor;
import symbol_table.*;
import symbol_table.elements.*;
import symbol_table.elements.PHP.*;

import java.util.*;

public class BaseVisitor extends HTMLParserBaseVisitor {
    int index_php = 0;
    int index_html = 0;
    public static Scope SymbolTable = null;
    @Override
    public Programs visitPrograms(HTMLParser.ProgramsContext ctx) {
        Programs programs = new Programs();
        ArrayList<HtmlPages> htmlPagesArrayList = new ArrayList<>();
        ArrayList<Php_pages> phpPagesArrayList = new ArrayList<>();
        /////////////////////////////////////////////
        ScopeRoot Root = new ScopeRoot();
        SymbolTable = Root;
        HTMLScope htmlScope = new HTMLScope();
        htmlScope.setFatherScope(Root);
        PHPScope phpScope = new PHPScope();
        phpScope.setFatherScope(Root);
        Root.AddRootChild(htmlScope,phpScope);
        HTMLPageScope htmlPageScope;
        PHPPageScope phpPageScope;


        for (int i = 0; i < ctx.htmlPages().size(); i++) {
            htmlPageScope = new HTMLPageScope();
            htmlPageScope.setFatherScope(htmlScope);
            htmlPagesArrayList.add(visitHtmlPages(ctx.htmlPages(i),htmlPageScope));
            htmlScope.AddChild(htmlPageScope);
        }

        for (int i = 0; i < ctx.phpPages().size(); i++) {
            phpPageScope = new PHPPageScope();
            phpPageScope.setFatherScope(phpScope);
            phpPagesArrayList.add(visitPhpPages(ctx.phpPages(i),phpPageScope));
            phpScope.AddChild(phpPageScope);
        }
        programs.setHtml_arrayList(htmlPagesArrayList);
        programs.setPhp_arrayList(phpPagesArrayList);

        return programs;
    }

    @Override
    public Php_pages visitPhpPages(HTMLParser.PhpPagesContext ctx,PHPPageScope phpPageScope) {
        Php_pages php_pages = new Php_pages();
        phpPageScope.setRow(ctx.getStart().getLine());
        phpPageScope.setColumn(ctx.getStart().getCharPositionInLine());
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) == ctx.CONTROL())
            {
                php_pages.setController_name(ctx.getChild(i-1).getText());
                phpPageScope.setControllerName(ctx.getChild(i-1).getText());
                php_pages.setControl_page_name(ctx.getChild(i+1).getText());
                phpPageScope.setHtmlPageName(ctx.getChild(i+1).getText());
            }
        }

        php_pages.setController_page(visitContoller_pages(ctx.contoller_pages(),phpPageScope));

        return php_pages;
    }

    @Override
    public Controller_page visitContoller_pages(HTMLParser.Contoller_pagesContext ctx,PHPPageScope phpPageScope) {
        Controller_page controller_page = new Controller_page();
        ArrayList<Php_Element> arrayList= new ArrayList<>();
        for (int i = 0; i < ctx.controller_element().size(); i++) {
            arrayList.add(visitController_element(ctx.controller_element(i),phpPageScope));
        }
        controller_page.setElement_arrayList(arrayList);
        return controller_page;
    }

    @Override
    public Php_Element visitController_element(HTMLParser.Controller_elementContext ctx,PHPPageScope phpPageScope) {
        Php_Element element = new Php_Element();
        element.setLine(ctx.getStart().getLine());
        element.setCol(ctx.getStart().getCharPositionInLine());
        //TODO EDIT
        if (ctx.SERVER_NAME() != null) {
            element.setServer(ctx.ATEXT().getText());
            phpPageScope.setServer(ctx.ATEXT().getText());
        }
        if (ctx.USER_NAME() != null) {
            element.setUser(ctx.ATEXT().getText());
            phpPageScope.setUser(ctx.ATEXT().getText());
        }
        if (ctx.PASSWORD() != null) {
            if (ctx.ATEXT() != null) {
                element.setPassword(ctx.ATEXT().getText());
                phpPageScope.setPassword(ctx.ATEXT().getText());
            }
            else{
                element.setPassword("");
                phpPageScope.setPassword("");
            }

        }
        if (ctx.DB_NAME() != null) {
            element.setDb_name(ctx.ATEXT().getText());
            phpPageScope.setDb_name(ctx.ATEXT().getText());
        }
        //TODO END
        if (ctx.SELECT_OF() != null) {
            ast.visitor.nodes.php.Select select = new ast.visitor.nodes.php.Select();
            SelectPhpScope selectPhpScope = new SelectPhpScope();
            selectPhpScope.setFatherScope(phpPageScope);
            phpPageScope.AddChild(selectPhpScope);
            selectPhpScope.setRow(ctx.getStart().getLine());
            selectPhpScope.setColumn(ctx.getStart().getCharPositionInLine());
            ArrayList<String> InvList = visitInv(ctx.inv());
            select.setFileds(InvList);
            selectPhpScope.setField(InvList);
            Table table ;
            table = visitTable(ctx.table());
            select.setTable_name(table.getTable_name());
            selectPhpScope.setTableName(table.getTable_name());
            element.setSelect(select);
        }
        if (ctx.INSERT_TO() != null) {
            Insert insert = new Insert();
            InsertPhpScope insertPhpScope = new InsertPhpScope();
            insertPhpScope.setFatherScope(phpPageScope);
            phpPageScope.AddChild(insertPhpScope);
            insertPhpScope.setRow(ctx.getStart().getLine());
            insertPhpScope.setColumn(ctx.getStart().getCharPositionInLine());
            ArrayList<String> InvList;
            InvList = visitInv(ctx.inv());
            insert.setFileds(InvList);
            insertPhpScope.setField(InvList);
            Table table;
            table = visitTable(ctx.table());
            insert.setTable_name(table.getTable_name());
            insertPhpScope.setTableName(table.getTable_name());
            element.setInsert(insert);
        }
        if (ctx.VALID_IN() != null && ctx.OPEN_BRACKET_IF() == null) {
            Valid valid = new Valid();
            ValidPhpScope validPhpScope = new ValidPhpScope();
            validPhpScope.setFatherScope(phpPageScope);
            phpPageScope.AddChild(validPhpScope);
            validPhpScope.setRow(ctx.getStart().getLine());
            validPhpScope.setColumn(ctx.getStart().getCharPositionInLine());
            ArrayList<String> InvList;
            InvList = visitInv(ctx.inv());
            valid.setFileds(InvList);
            validPhpScope.setField(InvList);
            Table table;
            table = visitTable(ctx.table());
            valid.setTable_name(table.getTable_name());
            validPhpScope.setTableName(table.getTable_name());
            element.setValid(valid);
        }
        if (ctx.GO() != null) {
            Go go;
            GoPhpScope goPhpScope = new GoPhpScope();
            goPhpScope.setFatherScope(phpPageScope);
            phpPageScope.AddChild(goPhpScope);
            goPhpScope.setRow(ctx.getStart().getLine());
            goPhpScope.setColumn(ctx.getStart().getCharPositionInLine());
            if (ctx.go() != null) {
                go = visitGo(ctx.go(),goPhpScope);
            } else {
                go = new Go();
            }
            goPhpScope.setPageName(ctx.GO_VLAUE().getText());
            go.setPage_name(ctx.GO_VLAUE().getText());
            element.setGo(go);
        }
        if (ctx.IF() != null) {
            If anIf = new If();
            IfPhpScope ifPhpScope = new IfPhpScope();
            ifPhpScope.setFatherScope(phpPageScope);
            phpPageScope.AddChild(ifPhpScope);
            ifPhpScope.setRow(ctx.getStart().getLine());
            ifPhpScope.setColumn(ctx.getStart().getCharPositionInLine());
            Valid valid = new Valid();
            ValidPhpScope validPhpScope = new ValidPhpScope();
            ArrayList<String> InvList;
            InvList = visitInv(ctx.inv());
            valid.setFileds(InvList);
            validPhpScope.setField(InvList);
            valid.setTable_name(ctx.table().TABLE_VLAUE().getText());
            validPhpScope.setTableName(ctx.table().TABLE_VLAUE().getText());
            anIf.setCondition(valid);
            ifPhpScope.setCondition(validPhpScope);
            ArrayList<Php_Element> arrayList = new ArrayList<>();
            for (int i = 0; i < ctx.if_php().size(); i++) {
                arrayList.add(visitIf_php(ctx.if_php(i),ifPhpScope));
            }
            anIf.setBody(arrayList);
            element.setAnIf(anIf);
        }

        return element;
    }

    @Override
    public Php_Element visitIf_php(HTMLParser.If_phpContext ctx,IfPhpScope ifPhpScope) {
        Php_Element php_element = new Php_Element();
        if (ctx.SELECT_OF_INIF() != null) {
            ast.visitor.nodes.php.Select select = new ast.visitor.nodes.php.Select();
            SelectPhpScope selectPhpScope = new SelectPhpScope();
            selectPhpScope.setFatherScope(ifPhpScope);
            ifPhpScope.AddChild(selectPhpScope);
            selectPhpScope.setRow(ctx.getStart().getLine());
            selectPhpScope.setColumn(ctx.getStart().getCharPositionInLine());
            ArrayList<String> InvList = visitInv(ctx.inv());
            select.setFileds(InvList);
            selectPhpScope.setField(InvList);
            Table table;
            table = visitTable(ctx.table());
            select.setTable_name(table.getTable_name());
            selectPhpScope.setTableName(table.getTable_name());
            php_element.setSelect(select);
        }
        if (ctx.INSERT_TO_INIF() != null) {
            Insert insert = new Insert();
            InsertPhpScope insertPhpScope = new InsertPhpScope();
            insertPhpScope.setFatherScope(ifPhpScope);
            ifPhpScope.AddChild(insertPhpScope);
            insertPhpScope.setRow(ctx.getStart().getLine());
            insertPhpScope.setColumn(ctx.getStart().getCharPositionInLine());
            ArrayList<String> InvList;
            InvList = visitInv(ctx.inv());
            insert.setFileds(InvList);
            insertPhpScope.setField(InvList);
            Table table;
            table = visitTable(ctx.table());
            insert.setTable_name(table.getTable_name());
            insertPhpScope.setTableName(table.getTable_name());
            php_element.setInsert(insert);

        }

        if (ctx.GO_INIF() != null) {
            Go go;
            GoPhpScope goPhpScope = new GoPhpScope();
            goPhpScope.setFatherScope(ifPhpScope);
            ifPhpScope.AddChild(goPhpScope);
            goPhpScope.setRow(ctx.getStart().getLine());
            goPhpScope.setColumn(ctx.getStart().getCharPositionInLine());
            if (ctx.go() != null) {
                go = visitGo(ctx.go(),goPhpScope);
            } else {
                go = new Go();
            }
            goPhpScope.setPageName(ctx.GO_VLAUE().getText());
            go.setPage_name(ctx.GO_VLAUE().getText());
            php_element.setGo(go);
        }
        if (ctx.IF() != null) {
            If anIf = new If();
            IfPhpScope ifPhpScopeChild = new IfPhpScope();
            ifPhpScopeChild.setFatherScope(ifPhpScope);
            ifPhpScope.AddChild(ifPhpScope);
            ifPhpScopeChild.setRow(ctx.getStart().getLine());
            ifPhpScopeChild.setColumn(ctx.getStart().getCharPositionInLine());
            Valid valid = new Valid();
            ValidPhpScope validPhpScope = new ValidPhpScope();
            ArrayList<String> InvList;
            InvList = visitInv(ctx.inv());
            valid.setFileds(InvList);
            validPhpScope.setField(InvList);
            valid.setTable_name(ctx.table().TABLE_VLAUE().getText());
            validPhpScope.setTableName(ctx.table().TABLE_VLAUE().getText());
            anIf.setCondition(valid);
            ifPhpScopeChild.setCondition(validPhpScope);
            ArrayList<Php_Element> arrayList = new ArrayList<>();
            for (int i = 0; i < ctx.if_php().size(); i++) {
                arrayList.add(visitIf_php(ctx.if_php(i),ifPhpScopeChild));
            }
            anIf.setBody(arrayList);
            php_element.setAnIf(anIf);
        }
        return php_element;
    }

    @Override
    public ArrayList<String> visitInv(HTMLParser.InvContext ctx) {
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < ctx.INV_VLAUE().size(); i++) {
            arrayList.add(ctx.INV_VLAUE(i).getText());
        }

        return arrayList;
    }

    @Override
    public Go visitGo(HTMLParser.GoContext ctx,GoPhpScope goPhpScope) {
        Go go = new Go();
        ArrayList<String> arrayList = new ArrayList<>();
        if (ctx.ROLE() != null){
            go.setRole_name(ctx.GO_VLAUE(0).getText());
            goPhpScope.setRoleName(ctx.GO_VLAUE(0).getText());
        }

        for (int i = 1; i<ctx.GO_VLAUE().size() ; i++){
            arrayList.add(ctx.GO_VLAUE(i).getText());
        }
        go.setArrayList_field_role(arrayList);
        goPhpScope.setArrayListFieldRole(arrayList);
        return go;
    }

    @Override
    public Table visitTable(HTMLParser.TableContext ctx) {
        Table table = new Table();
        if (ctx.TABLE_VLAUE() != null)
            table.setTable_name(ctx.TABLE_VLAUE().getText());
        return table;
    }

    @Override
    public HtmlPages visitHtmlPages(HTMLParser.HtmlPagesContext ctx,HTMLPageScope htmlPageScope) {
        HtmlPages htmlPages = new HtmlPages();
        ArrayList<String> arrayList = new ArrayList<>();
        htmlPageScope.setRow(ctx.getStart().getLine());
        htmlPageScope.setColumn(ctx.getStart().getCharPositionInLine());
        htmlPageScope.setExtendedRow(ctx.getStart().getLine());
        htmlPageScope.setPageName(ctx.PAGE_NAME(0).getText());
        htmlPages.setPage_name(ctx.PAGE_NAME(0).getText());
        if (ctx.PAGE_NAME().size() > 1)
            for (int i = 1; i < ctx.PAGE_NAME().size(); i++) {
                arrayList.add(ctx.PAGE_NAME(i).getText());
            }
        htmlPages.setPages(visitPages(ctx.pages(),htmlPageScope));
        htmlPageScope.setExtendedPages(arrayList);
        htmlPages.setExtend_pages(arrayList);
        return htmlPages;
    }

    @Override
    public Pages visitPages(HTMLParser.PagesContext ctx,HTMLPageScope htmlPageScope) {
        Pages pages = new Pages();
        if (ctx.BODY_KEY() != null) {
            pages.setBody(visitBody(ctx.body(),htmlPageScope));
        }
        return pages;
    }

    @Override
    public Body visitBody(HTMLParser.BodyContext ctx,HTMLPageScope htmlPageScope) {
        Body body = new Body();
        ArrayList<Element> arrayList = new ArrayList<>();
        for (int i = 0; i < ctx.element().size(); i++) {
            arrayList.add(visitElement(ctx.element(i),htmlPageScope));
        }
        body.setElements(arrayList);
        return body;
    }

    @Override
    public Element visitElement(HTMLParser.ElementContext ctx,HTMLPageScope htmlPageScope) {
        Element element = new Element();
        if (ctx.IN_KEY() != null) {
            element.setIn(visitIn(ctx.in(),htmlPageScope));
        }
        if (ctx.LINK_KEY() != null) {
            element.setLink(visitLink(ctx.link(),htmlPageScope));
        }
        if (ctx.OUT_KEY() != null) {
            element.setOut(visitOut(ctx.out(),htmlPageScope));
        }
        if (ctx.FORM_KEY() != null) {
            FormScope formScope = new FormScope();
            formScope.setFatherScope(htmlPageScope);
            htmlPageScope.AddChild(formScope);
            Form form = new Form();
            ArrayList<Element> arrayList = new ArrayList<>();
            for (int i = 0; i < ctx.form().size(); i++) {
                arrayList.add(visitForm(ctx.form(i),formScope));
            }
            form.setBody(arrayList);
            element.setForm(form);

        }
        return element;
    }

    @Override
    public Element visitForm(HTMLParser.FormContext ctx,FormScope formScope) {
        Element element = new Element();
        if (ctx.IN_KEY_FORM() != null){
            In in;
            in = visitIn(ctx.in(),formScope);
            element.setIn(in);
            element.setLine(ctx.getStart().getLine());
            element.setCol(ctx.getStart().getCharPositionInLine());
        }
        if (ctx.LINK_KEY_FORM() != null){
            Link link;
            link = visitLink(ctx.link(),formScope);
            element.setLink(link);
            element.setLine(ctx.getStart().getLine());
            element.setCol(ctx.getStart().getCharPositionInLine());
        }
        if (ctx.OUT_KEY_FORM() != null){
            Out out;
            out = visitOut(ctx.out(),formScope);
            element.setOut(out);
            element.setLine(ctx.getStart().getLine());
            element.setCol(ctx.getStart().getCharPositionInLine());
        }
        return element;
    }

    @Override
    public Out visitOut(HTMLParser.OutContext ctx,Scope htmlPageScope) {
        Out out = new Out();
        if (ctx.BIGTEXT() != null) {
            out.setBigText(visitBigText(ctx.bigText(),htmlPageScope));
        }

        if (ctx.IMG() != null) {
            out.setImg(visitImg(ctx.img(),htmlPageScope));
        }

        if (ctx.LIST() != null) {
            out.setList(visitList(ctx.list(),htmlPageScope));
        }

        if (ctx.TEXT() != null) {
            out.setTextt(visitText(ctx.text(),htmlPageScope));
        }

        return out;
    }


    @Override
    public ArrayList<String> visitMustache(HTMLParser.MustacheContext ctx) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < ctx.MUSTACHE_TEXT().size(); i++) {
            arrayList.add(ctx.MUSTACHE_TEXT(i).getText());
        }
        return arrayList;
    }

    @Override
    public BigText visitBigText(HTMLParser.BigTextContext ctx,Scope htmlPageScope) {
        BigText bigText;
        BigTextScope bigTextScope = new BigTextScope();
        bigTextScope.setFatherScope(htmlPageScope);
        htmlPageScope.AddChild(bigTextScope);
        bigTextScope.setRow(ctx.getStart().getLine());
        bigTextScope.setColumn(ctx.getStart().getCharPositionInLine());
        bigText = visitAttribute_bigText(ctx.attribute_bigText(),bigTextScope);
        bigText.setLine(ctx.getStart().getLine());
        bigText.setCol(ctx.getStart().getCharPositionInLine());
        return bigText;
    }

    @Override
    public BigText visitAttribute_bigText(HTMLParser.Attribute_bigTextContext ctx,BigTextScope bigTextScope) {
        BigText bigText = new BigText();
        ArrayList<text_or_mustache> arrayList = new ArrayList<>();
        ArrayList<TextMustache> valueArrayListScope = new ArrayList<>();
        if (ctx.ATTRIBUTE_SCALE() != null) {
            bigText.setScale(ctx.NUMBER_SCALE().getText());
            bigTextScope.setScale(ctx.NUMBER_SCALE().getText());
        }
        if (ctx.ATTRIBUTE_TITLE() != null) {
            int atext = 0;
            int mustache = 0;
            for (int i = 0; i < ctx.getChildCount(); i++) {
                if (ctx.getChild(i) == ctx.ATEXT(atext)) {
                    atext++;
                    text_or_mustache text_or_mustache = new text_or_mustache();
                    TextMustache textMustache = new TextMustache();
                    text_or_mustache.setText(ctx.getChild(i).getText());
                    textMustache.setText(ctx.getChild(i).getText());
                    arrayList.add(text_or_mustache);
                    valueArrayListScope.add(textMustache);
                }
                if (ctx.getChild(i) == ctx.mustache(mustache)) {
                    ArrayList<String> arrayList1;
                    arrayList1 = visitMustache(ctx.mustache(mustache));
                    mustache++;
                    for (int j = 0; j < arrayList1.size(); j++) {
                        text_or_mustache text_or_mustache = new text_or_mustache();
                        TextMustache textMustache = new TextMustache();
                        text_or_mustache.setMustache(arrayList1.get(j));
                        textMustache.setMustache(arrayList1.get(j));
                        arrayList.add(text_or_mustache);
                        valueArrayListScope.add(textMustache);
                    }
                }
            }
        }


        bigText.setText_or_mustaches(arrayList);
        bigTextScope.setValue(valueArrayListScope);
        return bigText;
    }

    @Override
    public Img visitImg(HTMLParser.ImgContext ctx,Scope htmlPageScope) {
        Img img;
        ImageScope imageScope = new ImageScope();
        imageScope.setFatherScope(htmlPageScope);
        htmlPageScope.AddChild(imageScope);
        imageScope.setRow(ctx.getStart().getLine());
        imageScope.setColumn(ctx.getStart().getCharPositionInLine());
        img = visitAttribute_img(ctx.attribute_img(),imageScope);
        img.setLine(ctx.getStart().getLine());
        img.setCol(ctx.getStart().getCharPositionInLine());
        return img;
    }

    @Override
    public Img visitAttribute_img(HTMLParser.Attribute_imgContext ctx,ImageScope imageScope) {
        Img img = new Img();
        for (int i = 0; i < ctx.children.size(); i++) {
            if (ctx.children.get(i) == ctx.ATTRIBUTE_PATH())
            {
                img.setPath(ctx.children.get(i+2).getText());
                imageScope.setPath(ctx.children.get(i+2).getText());
            }
            if (ctx.children.get(i) == ctx.ATTRIBUTE_ALT_TEXT())
            {
                img.setAlt_text(ctx.children.get(i+2).getText());
                imageScope.setAlt_text(ctx.children.get(i+2).getText());
            }
        }
        return img;
    }

    @Override
    public Textt visitText(HTMLParser.TextContext ctx,Scope htmlPageScope) {
        Textt text;
        TextScope textScope = new TextScope();
        textScope.setFatherScope(htmlPageScope);
        htmlPageScope.AddChild(textScope);
        textScope.setRow(ctx.getStart().getLine());
        textScope.setColumn(ctx.getStart().getCharPositionInLine());
        text = visitAttribute_text(ctx.attribute_text(),textScope);
        text.setLine(ctx.getStart().getLine());
        text.setCol(ctx.getStart().getCharPositionInLine());
        return text;
    }

    @Override
    public Textt visitAttribute_text(HTMLParser.Attribute_textContext ctx,TextScope textScope) {
        Textt textt = new Textt();
        ArrayList<text_or_mustache> arrayList = new ArrayList<>();
        ArrayList<TextMustache> valueTextScope = new ArrayList<>();
        if (ctx.ATTRIBUTE_TYPE() != null) {
            textt.setType(ctx.TYPE_TEXT().getText());
            textScope.setType(ctx.TYPE_TEXT().getText());
        }
        if (ctx.ATTRIBUTE_TITLE1() != null) {
            int atext = 0;
            int mustache = 0;
            for (int i = 0; i < ctx.getChildCount(); i++) {
                if (ctx.getChild(i) == ctx.ATEXT(atext)) {
                    atext++;
                    text_or_mustache text_or_mustache = new text_or_mustache();
                    TextMustache value = new TextMustache();
                    text_or_mustache.setText(ctx.getChild(i).getText());
                    value.setText(ctx.getChild(i).getText());
                    arrayList.add(text_or_mustache);
                    valueTextScope.add(value);
                }
                if (ctx.getChild(i) == ctx.mustache(mustache)) {
                    ArrayList<String> arrayList1;
                    arrayList1 = visitMustache(ctx.mustache(mustache));
                    mustache++;
                    for (int j = 0; j < arrayList1.size(); j++) {
                        text_or_mustache text_or_mustache = new text_or_mustache();
                        TextMustache value = new TextMustache();
                        text_or_mustache.setMustache(arrayList1.get(j));
                        value.setMustache(arrayList1.get(j));
                        arrayList.add(text_or_mustache);
                        valueTextScope.add(value);
                    }
                }
            }
        }
        textt.setText_or_mustaches(arrayList);
        textScope.setValue(valueTextScope);
        return textt;
    }

    @Override
    public List visitList(HTMLParser.ListContext ctx,Scope htmlPageScope) {
        List list;
        ListHtmlScope listHtmlScope = new ListHtmlScope();
        listHtmlScope.setFatherScope(htmlPageScope);
        htmlPageScope.AddChild(listHtmlScope);
        listHtmlScope.setRow(ctx.getStart().getLine());
        listHtmlScope.setColumn(ctx.getStart().getCharPositionInLine());
        list = visitAttribute_list(ctx.attribute_list(),listHtmlScope);
        list.setLine(ctx.getStart().getLine());
        list.setCol(ctx.getStart().getCharPositionInLine());
        return list;
    }

    @Override
    public List visitAttribute_list(HTMLParser.Attribute_listContext ctx,ListHtmlScope listHtmlScope) {
        List list = new List();
        ArrayList<ArrayList<text_or_mustache>> arrayList_t = new ArrayList<>();
        ArrayList<ArrayList<TextMustache>> optionsArrayListScope = new ArrayList<>();
        int atext = 0;
        int mustache = 0;
        int option = 0;
        if (ctx.ATTRIBUTE_NUMBERED() != null) {
            list.setNumbered(Boolean.parseBoolean(ctx.NUMBERED_VALUE().getText()));
            listHtmlScope.setNumbered(Boolean.parseBoolean(ctx.NUMBERED_VALUE().getText()));
        }

        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) == ctx.ATTRIBUTE_OPTION(option)) {
                int mm = i;
                ArrayList<text_or_mustache> text_or_mustaches = new ArrayList<>();
                ArrayList<TextMustache> OptionScope = new ArrayList<>();
                while (ctx.getChild(mm) != ctx.ATTRIBUTE_OPTION(option + 1)) {
                    if (ctx.getChild(mm) == ctx.ATEXT(atext)) {
                        text_or_mustache text_or_mustache = new text_or_mustache();
                        TextMustache textMustache = new TextMustache();
                        text_or_mustache.setText(ctx.getChild(mm).getText());
                        textMustache.setText(ctx.getChild(mm).getText());
                        text_or_mustaches.add(text_or_mustache);
                        OptionScope.add(textMustache);
                        atext++;
                    }
                    if (ctx.getChild(mm) == ctx.mustache(mustache)) {
                        ArrayList<String> arrayList;
                        arrayList = visitMustache(ctx.mustache(mustache));
                        mustache++;
                        for (int j = 0; j < arrayList.size(); j++) {
                            text_or_mustache text_or_mustache = new text_or_mustache();
                            TextMustache textMustache = new TextMustache();
                            text_or_mustache.setMustache(arrayList.get(j));
                            textMustache.setMustache(arrayList.get(j));
                            text_or_mustaches.add(text_or_mustache);
                            OptionScope.add(textMustache);
                        }
                    }

                    mm++;
                }
                arrayList_t.add(text_or_mustaches);
                optionsArrayListScope.add(OptionScope);
                option++;

            }
        }
        list.setOptios(arrayList_t);
        listHtmlScope.setOption(optionsArrayListScope);
        return list;
    }

    @Override
    public Link visitLink(HTMLParser.LinkContext ctx,Scope htmlPageScope) {
        Link link = new Link();
        if (ctx.LINK_BUTTON() != null) {
            link.setButtonLink(visitButtonLink(ctx.buttonLink(),htmlPageScope));
        }

        if (ctx.LINK_SIMPLE() != null) {
            link.setSimpleLink(visitSimpleLink(ctx.simpleLink(),htmlPageScope));
        }

        return link;
    }

    @Override
    public ButtonLink visitButtonLink(HTMLParser.ButtonLinkContext ctx,Scope htmlPageScope) {
        ButtonLink buttonLink;
        ButtonLinkScope buttonLinkScope = new ButtonLinkScope();
        buttonLinkScope.setFatherScope(htmlPageScope);
        htmlPageScope.AddChild(buttonLinkScope);
        buttonLinkScope.setRow(ctx.getStart().getLine());
        buttonLinkScope.setColumn(ctx.getStart().getCharPositionInLine());
        buttonLink = visitAttribute_buttonLink(ctx.attribute_buttonLink(),buttonLinkScope);
        buttonLink.setLine(ctx.getStart().getLine());
        buttonLink.setCol(ctx.getStart().getCharPositionInLine());
        return buttonLink;
    }

    @Override
    public ButtonLink visitAttribute_buttonLink(HTMLParser.Attribute_buttonLinkContext ctx,ButtonLinkScope buttonLinkScope) {
        ButtonLink buttonLink = new ButtonLink();
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) == ctx.ATTRIBUTE_HREF()) {
                buttonLink.setHref(ctx.getChild(i + 2).getText());
                buttonLinkScope.setHref(ctx.getChild(i + 2).getText());
            }
            if (ctx.getChild(i) == ctx.ATTRIBUTE_TEXT()) {
                buttonLink.setText(ctx.getChild(i + 2).getText());
                buttonLinkScope.setText(ctx.getChild(i + 2).getText());
            }
        }

        return buttonLink;
    }

    @Override
    public SimpleLink visitSimpleLink(HTMLParser.SimpleLinkContext ctx,Scope htmlPageScope) {
        SimpleLink SimpleLink;
        SimpleLinkScope simpleLinkScope = new SimpleLinkScope();
        simpleLinkScope.setFatherScope(htmlPageScope);
        htmlPageScope.AddChild(simpleLinkScope);
        simpleLinkScope.setRow(ctx.getStart().getLine());
        simpleLinkScope.setColumn(ctx.getStart().getCharPositionInLine());
        SimpleLink = visitAttribute_simpleLink(ctx.attribute_simpleLink(),simpleLinkScope);
        SimpleLink.setLine(ctx.getStart().getLine());
        SimpleLink.setCol(ctx.getStart().getCharPositionInLine());
        return SimpleLink;
    }

    @Override
    public SimpleLink visitAttribute_simpleLink(HTMLParser.Attribute_simpleLinkContext ctx,SimpleLinkScope simpleLinkScope) {
        SimpleLink SimpleLink = new SimpleLink();
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) == ctx.ATTRIBUTE_HREF1()) {
                SimpleLink.setHref(ctx.getChild(i + 2).getText());
                simpleLinkScope.setHref(ctx.getChild(i + 2).getText());
            }

            if (ctx.getChild(i) == ctx.ATTRIBUTE_TEXT2()) {
                SimpleLink.setText(ctx.getChild(i + 2).getText());
                simpleLinkScope.setText(ctx.getChild(i + 2).getText());
            }
        }
        return SimpleLink;

    }

    @Override
    public In visitIn(HTMLParser.InContext ctx,Scope htmlPageScope) {
        In in = new In();
        if (ctx.IN_FIELD() != null) {
            in.setField(visitField(ctx.field(),htmlPageScope));
        }

        if (ctx.IN_SELECT() != null) {
            in.setSelect(visitSelect(ctx.select(),htmlPageScope));
        }

        return in;
    }

    @Override
    public Field visitField(HTMLParser.FieldContext ctx,Scope htmlPageScope) {
        FieldScope fieldScope = new FieldScope();
        fieldScope.setFatherScope(htmlPageScope);
        fieldScope.setRow(ctx.getStart().getLine());
        fieldScope.setColumn(ctx.getStart().getCharPositionInLine());
        htmlPageScope.AddChild(fieldScope);
        Field field;
        field = visitAttribute_field(ctx.attribute_field(),fieldScope);
        field.setLine(ctx.getStart().getLine());
        field.setCol(ctx.getStart().getCharPositionInLine());
        return field;
    }

    @Override
    public Select visitSelect(HTMLParser.SelectContext ctx,Scope htmlPageScope) {
        SelectScope selectScope = new SelectScope();
        selectScope.setFatherScope(htmlPageScope);
        selectScope.setRow(ctx.getStart().getLine());
        selectScope.setColumn(ctx.getStart().getCharPositionInLine());
        htmlPageScope.AddChild(selectScope);
        Select select;
        select = visitAttribute_select(ctx.attribute_select(),selectScope);
        select.setLine(ctx.getStart().getLine());
        select.setCol(ctx.getStart().getCharPositionInLine());
        return select;
    }

    @Override
    public Field visitAttribute_field(HTMLParser.Attribute_fieldContext ctx,FieldScope fieldScope) {
        Field field = new Field();
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.children.get(i) == ctx.ATTRIBUTE_HINT21()) {
                field.setHint(ctx.children.get(i + 2).getText());
                fieldScope.setHintScope(ctx.children.get(i + 2).getText());
            }
            if (ctx.children.get(i) == ctx.ATTRIBUTE_TITLE21()) {
                field.setText(ctx.children.get(i + 2).getText());
                fieldScope.setTextScope(ctx.children.get(i + 2).getText());
            }
            if (ctx.children.get(i) == ctx.ATTRIBUTE_TYPE21()) {
                field.setType(ctx.children.get(i + 2).getText());
                fieldScope.setTypeScope(ctx.children.get(i + 2).getText());
            }
            if (ctx.children.get(i) == ctx.ATTRIBUTE_NAME21()) {
                field.setName(ctx.children.get(i + 2).getText());
                fieldScope.setScopeName(ctx.children.get(i + 2).getText());
            }
            if (ctx.children.get(i) == ctx.ATTRIBUTE_REQUIRED21()) {
                field.setRequired(true);
                fieldScope.setRequiredScope(true);
            }
        }

        return field;
    }

    @Override
    public Select visitAttribute_select(HTMLParser.Attribute_selectContext ctx,SelectScope selectScope) {
        Select select = new Select();
        OptionScope optionScope ;
        ArrayList<Option> options = new ArrayList<>();
        int option = 0;
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.children.get(i) == ctx.ATTRIBUTE_NAME23()) {
                select.setName(ctx.children.get(i + 2).getText());
                selectScope.setScopeName(ctx.children.get(i + 2).getText());
            }
            if (ctx.children.get(i) == ctx.ATTRIBUTE_OPTION23(option)) {
                if (ctx.children.get(i + 2) == ctx.ATTRIBUTE_TITLE24(option)) {
                    options.add(new Option(ctx.children.get(i + 4).getText(), ctx.children.get(i + 9).getText()));
                    optionScope = new OptionScope();
                    optionScope.setFatherScope(selectScope);
                    optionScope.setRow(ctx.getStart().getLine());
                    optionScope.setColumn(ctx.getStart().getCharPositionInLine());
                    optionScope.setTitle(ctx.children.get(i + 4).getText());
                    optionScope.setValue(ctx.children.get(i + 9).getText());
                    selectScope.AddChild(optionScope);
                }
                if (ctx.children.get(i + 2) == ctx.ATTRIBUTE_VALUE24(option)) {

                    options.add(new Option(ctx.children.get(i + 9).getText(), ctx.children.get(i + 4).getText()));
                    optionScope = new OptionScope();
                    optionScope.setRow(ctx.getStart().getLine());
                    optionScope.setFatherScope(selectScope);
                    optionScope.setColumn(ctx.getStart().getCharPositionInLine());
                    optionScope.setTitle(ctx.children.get(i + 9).getText());
                    optionScope.setValue(ctx.children.get(i + 4).getText());
                    selectScope.AddChild(optionScope);
                }
                option++;
            }

        }

        select.setOptios(options);
        return select;
    }


}
