package lab.crazyspark.aml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.crazyspark.bean.Company;
import lab.crazyspark.broker.BeanBroker;

/**
 * Servlet implementation class demo
 */
@WebServlet("/validator")
public class ValidatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ValidatorServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置响应的编码格式为UTF-8编码，否则发生中文乱码现象
        response.setContentType("text/html;charset=UTF-8");
        // 1.获得请求方式
        List<String> strList = new ArrayList<String>();
        if (BeanBroker.Table(Company.class, strList)) {
            BeanBroker.Check(Company.class, strList);
        }

        request.setAttribute("strList", strList);
        request.getRequestDispatcher("/WEB-INF/ftl/validator.ftl").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}