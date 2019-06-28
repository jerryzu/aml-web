package lab.crazyspark.test;

import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TestServlet
 * 
 * 访问此Servlet能够给ClientComet的mesgQueue添加对象
 * 
 */
@WebServlet(urlPatterns = "/Test")
public class TestServlet extends HttpServlet {

    private static final long serialVersionUID = -7817902387051107187L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        int times = 5;
        while (--times >= 0) {
            try {
                Thread.sleep(5000);
                ClientComet.getInstance()
                        .callClient(new Javascript("append(" + "\'" + new Date().toGMTString() + "\'" + ")"));
                System.out.println("TestServlet-->callClient");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}