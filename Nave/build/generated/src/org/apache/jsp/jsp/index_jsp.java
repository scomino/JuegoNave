package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\t<head>\n");
      out.write("\t\t<meta charset=\"UTF-8\">\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;\">\n");
      out.write("\t\t<title>Lunar Landing in HTML5</title>\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\t\t<script src=\"js/jquery-3.1.1.min.js\"></script>\n");
      out.write("\t\t<script src=\"js/lunar.js\"></script>\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("            <form id=\"registrarse\" >\n");
      out.write("                <input type=\"text\" id=\"fullname\" value=\"ooooooh yes\" />\n");
      out.write("                <input type=\"submit\" value=\"Registrarse\" />\n");
      out.write("            </form>\n");
      out.write("\t\t<div id=\"state\">\n");
      out.write("\t\t\t<div class=\"container\">\n");
      out.write("\t\t\t\t<h1></h1>\n");
      out.write("\t\t\t\t<h2 ></h2>\n");
      out.write("\t\t\t\t<div class=\"ads\">google ads</div>\n");
      out.write("\t\t\t\t<a href=\"#\" onclick=\"reset();\">Play again</a>\n");
      out.write("                                <form action=\"SPuntuacion\" method=\"post\"><input type=\"submit\" value=\"Puntuaciones\" /></form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div id=\"game\">\n");
      out.write("\t\t\t<div id=\"gauge\"><div></div></div>\n");
      out.write("\t\t\t<div id=\"ship\"></div>\n");
      out.write("\t\t\t<div id=\"explode\"></div>\n");
      out.write("\t\t\t<div id=\"moon\">\n");
      out.write("\t\t\t\t<div id=\"landing-pad\"><div id=\"ms\">-</div></div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!--<script>\n");
      out.write("\t\t\t(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\n");
      out.write("\t\t\t(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\n");
      out.write("\t\t\tm=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\n");
      out.write("\t\t\t})(window,document,'script','https://www.google-analytics.com/analytics.js','ga');\n");
      out.write("\t\t\tga('create', 'UA-41665373-8', 'auto');\n");
      out.write("\t\t\tga('send', 'pageview');\n");
      out.write("\t\t</script>-->\n");
      out.write("                \n");
      out.write("\t</body>\n");
      out.write("</html>\n");
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
