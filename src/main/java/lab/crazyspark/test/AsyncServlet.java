package lab.crazyspark.test;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AsyncServlet
 * 
 * 支持异步处理的Servlet 页面中隐藏的iframe通过访问此Servlet来建立HTTP长连接 从而后台能实时的推送javascript代码给页面调用
 * 
 */
@WebServlet(urlPatterns = "/Async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    private static final long serialVersionUID = 822178713133426493L;
    private final static int DEFAULT_TIME_OUT = 10 * 60 * 1000;

    // @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        final AsyncContext actx = req.startAsync();
        actx.setTimeout(DEFAULT_TIME_OUT);
        actx.addListener(new AsyncListener() {

            public void onComplete(AsyncEvent arg0) throws IOException {
                ClientComet.getInstance().removeAsyncContext(actx);
                System.out.println("AsyncListener-->onComplete");
            }

            public void onError(AsyncEvent arg0) throws IOException {
                ClientComet.getInstance().removeAsyncContext(actx);
                System.out.println("AsyncListener-->onError");
            }

            public void onStartAsync(AsyncEvent arg0) throws IOException {
                System.out.println("AsyncListener-->onStartAsync");
            }

            public void onTimeout(AsyncEvent arg0) throws IOException {
                ClientComet.getInstance().removeAsyncContext(actx);
                System.out.println("AsyncListener-->onTimeout");
            }

        });
        ClientComet.getInstance().addAsyncContext(actx);
    }
}
