/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-08-26 02:50:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>TopMenu</title>\r\n");
      out.write("\r\n");
      out.write("\t<LINK href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/blue/top.css\" type=text/css rel=stylesheet>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t\t#messageArea{\r\n");
      out.write("\t\t\tcolor: white;\r\n");
      out.write("\t\t\tfont-size: 14px;\r\n");
      out.write("\t\t\tfont-weight: bold;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body CLASS=PageBody leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"Head1\">\r\n");
      out.write("\t\t<div id=\"Logo\">\r\n");
      out.write("        \t<iframe name=\"autoRefashion\" src=\"\" width=\"0\" height=\"0\"></iframe>\r\n");
      out.write("\t\t\t<a id=\"msgLink\" href=\"javascript:void(0)\"></a>\r\n");
      out.write("            <font color=\"#0000CC\" style=\"color:#F1F9FE; font-size:28px; font-family:Arial Black, Arial\">HuiYun OA</font> \r\n");
      out.write("\t\t\t<!--<img border=\"0\" src=\"css/blue/images/logo.png\" />-->\r\n");
      out.write("        </div>\r\n");
      out.write("\t\t<div id=\"Head1Right\">\r\n");
      out.write("\t\t\t<div id=\"Head1Right_UserName\">\r\n");
      out.write("                <img border=\"0\" width=\"13\" height=\"14\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/images/top/user.gif\" /> 您好，<b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</b>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"Head1Right_UserDept\"></div>\r\n");
      out.write("\t\t\t<div id=\"Head1Right_UserSetup\">\r\n");
      out.write("            \t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/userAction/page/logout?preffix=userAction\">\r\n");
      out.write("            \t\t<img border=\"0\" width=\"13\" height=\"14\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/blue/images/top/logout.gif\"/>\r\n");
      out.write("            \t\t 退出系统\r\n");
      out.write("                </a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"Head1Right_Time\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("    \r\n");
      out.write("    <div id=\"Head2\">\r\n");
      out.write("        <div id=\"Head2_Awoke\">\r\n");
      out.write("            <ul id=\"AwokeNum\">\r\n");
      out.write("                <li><a target=\"desktop\" href=\"javascript:void(0)\"><img border=\"0\" width=\"11\" height=\"13\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/images/top/msg.gif\" /> 消息<span id=\"msg\"></span></a></li>\r\n");
      out.write("                <li class=\"Line\"></li>\r\n");
      out.write("                <li><a target=\"desktop\" href=\"javascript:void(0)\"><img border=\"0\" width=\"16\" height=\"11\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/images/top/mail.gif\" /> 邮件<span id=\"mail\"></span></a></li>\r\n");
      out.write("                <li class=\"Line\"></li>\r\n");
      out.write("                \r\n");
      out.write("                <!-- 是否有待审批文档的提示1 -->\r\n");
      out.write("                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/formFlowAction_myTaskList.action\" target=\"right\">\r\n");
      out.write("                \t\t<img border=\"0\" width=\"12\" height=\"14\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/images/top/wait.gif\" /> \r\n");
      out.write("                \t\t待办事项（<span id=\"wait\" class=\"taskListSize\">0</span>）\r\n");
      out.write("                \t</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"Line\"></li>\r\n");
      out.write("                \r\n");
      out.write("                <!-- 是否有待审批文档的提示2 -->\r\n");
      out.write("                <li id=\"messageArea\"></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}