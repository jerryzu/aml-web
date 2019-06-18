package lab.crazyspark.aml;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.crazyspark.broker.BeanBroker;

@WebServlet("/expexcel")
public class ExpExcelServlet extends HttpServlet {

    private static final long serialVersionUID = -8602967406959219081L;

    public ExpExcelServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置响应的编码格式为UTF-8编码，否则发生中文乱码现象
        response.setContentType("text/html;charset=UTF-8");
        // 1.获得请求方式
        List<String> strList = new ArrayList<String>();
        String filepath = request.getSession().getServletContext().getRealPath("/download/") + "aml.xlsx";
        BeanBroker.Exp2Excel(filepath, strList);
        request.setAttribute("strList", strList);
        request.getRequestDispatcher("/WEB-INF/ftl/expexcel.ftl").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}