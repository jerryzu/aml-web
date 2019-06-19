package lab.crazyspark.aml;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.crazyspark.broker.Event;
import lab.crazyspark.broker.Notifier;
import lab.crazyspark.broker.Target;

@WebServlet("/sync")
public class SyncServlet extends HttpServlet implements Event {
    private static final long serialVersionUID = 1L;
    private PrintWriter out;

    public SyncServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        Notifier notifier = new Notifier();
        notifier.regist(this);
        Target.setNotifier(notifier);
        Target.done();
        // response.resetBuffer();清除输出
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