package org.apache.jsp.WEB_002dINF.views.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import utils.Utils;

public final class product_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items_end;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_varStatus_var_items_end = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_varStatus_var_items_end.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div style=\"display: flex; flex-wrap: wrap; align-content: center; justify-content: center\">\r\n");
      out.write("    <h1>hi</h1>\r\n");
      out.write("    ");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items_end.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
      _jspx_th_c_forEach_0.setParent(null);
      _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${list}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
      _jspx_th_c_forEach_0.setVar("product");
      _jspx_th_c_forEach_0.setVarStatus("loop");
      _jspx_th_c_forEach_0.setEnd(10);
      int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
      try {
        int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
        if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                                        <!-- Single -->\r\n");
            out.write("                                        <div class=\"product-single\">\r\n");
            out.write("                                            <div class=\"sale-badge\">\r\n");
            out.write("                                                <span>sale</span>\r\n");
            out.write("                                            </div>\r\n");
            out.write("                                            <div class=\"product-thumbnail\">\r\n");
            out.write("                                                <a href=\"product-details.html\"\r\n");
            out.write("                                                    ><img\r\n");
            out.write("                                                        src=\"https://bizweb.dktcdn.net/100/416/452/products/dell-9570-1.jpg?v=1612512400560\"\r\n");
            out.write("                                                        alt=\"product\"\r\n");
            out.write("                                                /></a>\r\n");
            out.write("                                                <div\r\n");
            out.write("                                                    class=\"product-thumbnail-overly\"\r\n");
            out.write("                                                >\r\n");
            out.write("                                                    <ul>\r\n");
            out.write("                                                        <li>\r\n");
            out.write("                                                            <a href=\"cart.html\"\r\n");
            out.write("                                                                ><i\r\n");
            out.write("                                                                    class=\"fas fa-shopping-cart\"\r\n");
            out.write("                                                                ></i\r\n");
            out.write("                                                            ></a>\r\n");
            out.write("                                                        </li>\r\n");
            out.write("                                                        <li>\r\n");
            out.write("                                                            <a href=\"wishlist.html\"\r\n");
            out.write("                                                                ><i\r\n");
            out.write("                                                                    class=\"far fa-heart\"\r\n");
            out.write("                                                                ></i\r\n");
            out.write("                                                            ></a>\r\n");
            out.write("                                                        </li>\r\n");
            out.write("                                                        <li>\r\n");
            out.write("                                                            <a href=\"#\"\r\n");
            out.write("                                                                ><i\r\n");
            out.write("                                                                    class=\"far fa-eye\"\r\n");
            out.write("                                                                ></i\r\n");
            out.write("                                                            ></a>\r\n");
            out.write("                                                        </li>\r\n");
            out.write("                                                    </ul>\r\n");
            out.write("                                                </div>\r\n");
            out.write("                                            </div>\r\n");
            out.write("                                            <div class=\"product-content\">\r\n");
            out.write("                                                <h4>\r\n");
            out.write("                                                    <a href=\"product-details.html\"\r\n");
            out.write("                                                        >");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.productName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</a\r\n");
            out.write("                                                    >\r\n");
            out.write("                                                </h4>\r\n");
            out.write("                                                <div class=\"pricing\">\r\n");
            out.write("                                                    <span\r\n");
            out.write("                                                        >$ ");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write(" <del>$");
            out.print( Utils.getRandomNumber() );
            out.write("</del></span\r\n");
            out.write("                                                    >\r\n");
            out.write("                                                </div>\r\n");
            out.write("                                            </div>\r\n");
            out.write("                                        </div>\r\n");
            out.write("                                    ");
            int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_forEach_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_forEach_0.doFinally();
        _jspx_tagPool_c_forEach_varStatus_var_items_end.reuse(_jspx_th_c_forEach_0);
      }
      out.write("\r\n");
      out.write("</div>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
