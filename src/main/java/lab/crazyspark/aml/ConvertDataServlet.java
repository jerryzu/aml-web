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

@WebServlet("/convertdata")
public class ConvertDataServlet extends HttpServlet implements Event {

    private static final long serialVersionUID = 4060058406125225949L;
    private PrintWriter out;

    public ConvertDataServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        Notifier notifier = new Notifier();
        notifier.regist(this);
        BeanBroker.setNotifier(notifier);
        BeanBroker.ConvertData();
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