package lab.crazyspark.aml;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.crazyspark.broker.BeanBroker;
import lab.crazyspark.broker.Event;
import lab.crazyspark.broker.Notifier;

@WebServlet("/expexcel")
public class ExpExcelServlet extends HttpServlet  implements Event{

    private static final long serialVersionUID = -8602967406959219081L;
    private PrintWriter out; 

    public ExpExcelServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置响应的编码格式为UTF-8编码，否则发生中文乱码现象
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        Notifier notifier = new Notifier();
        notifier.regist(this);
        BeanBroker.setNotifier(notifier);
        // 1.获得请求方式
        String filepath = request.getSession().getServletContext().getRealPath("/download/") + "aml.xlsx";
        BeanBroker.Exp2Excel(filepath);
        // request.setAttribute("strList", strList);
        // request.getRequestDispatcher("/WEB-INF/ftl/expexcel.ftl").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void processEvent(String EventInfo) {
        out.println(String.format("%s%s", EventInfo, "<br>"));
        out.flush();
        System.out.println(String.format("%s", EventInfo));
    }
}