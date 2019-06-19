package lab.crazyspark.aml;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.crazyspark.bean.Company;
import lab.crazyspark.bean.InsBo;
import lab.crazyspark.bean.InsFavCst;
import lab.crazyspark.bean.InsGpol;
import lab.crazyspark.bean.InsPers;
import lab.crazyspark.bean.InsRType;
import lab.crazyspark.bean.InsRchg;
import lab.crazyspark.bean.InsRcla;
import lab.crazyspark.bean.InsRenewal;
import lab.crazyspark.bean.InsRisk;
import lab.crazyspark.bean.InsRiskNew;
import lab.crazyspark.bean.InsRpay;
import lab.crazyspark.bean.InsRpol;
import lab.crazyspark.bean.InsRsur;
import lab.crazyspark.bean.InsUnit;
import lab.crazyspark.bean.LarReport;
import lab.crazyspark.bean.SusReport;
import lab.crazyspark.broker.BeanBroker;
import lab.crazyspark.broker.Event;
import lab.crazyspark.broker.Notifier;

@WebServlet("/validator")
public class ValidatorServlet extends HttpServlet implements Event {
    private static final long serialVersionUID = 1L;
    private PrintWriter out;

    public ValidatorServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        Notifier notifier = new Notifier();
        notifier.regist(this);
        BeanBroker.setNotifier(notifier);
        if (BeanBroker.Table(Company.class)) {
            BeanBroker.Check(Company.class);
        }
        if (BeanBroker.Table(InsRType.class)) {
            BeanBroker.Check(InsRType.class);
        }
        if (BeanBroker.Table(InsPers.class)) {
            BeanBroker.Check(InsPers.class);
        }
        if (BeanBroker.Table(InsUnit.class)) {
            BeanBroker.Check(InsUnit.class);
        }
        if (BeanBroker.Table(InsBo.class)) {
            BeanBroker.Check(InsBo.class);
        }
        if (BeanBroker.Table(InsRpol.class)) {
            BeanBroker.Check(InsRpol.class);
        }
        if (BeanBroker.Table(InsGpol.class)) {
            BeanBroker.Check(InsGpol.class);
        }
        if (BeanBroker.Table(InsFavCst.class)) {
            BeanBroker.Check(InsFavCst.class);
        }
        if (BeanBroker.Table(InsRenewal.class)) {
            BeanBroker.Check(InsRenewal.class);
        }
        if (BeanBroker.Table(InsRsur.class)) {
            BeanBroker.Check(InsRsur.class);
        }
        if (BeanBroker.Table(InsRpay.class)) {
            BeanBroker.Check(InsRpay.class);
        }
        if (BeanBroker.Table(InsRcla.class)) {
            BeanBroker.Check(InsRcla.class);
        }
        if (BeanBroker.Table(InsRchg.class)) {
            BeanBroker.Check(InsRchg.class);
        }
        if (BeanBroker.Table(InsRiskNew.class)) {
            BeanBroker.Check(InsRiskNew.class);
        }
        if (BeanBroker.Table(InsRisk.class)) {
            BeanBroker.Check(InsRisk.class);
        }
        if (BeanBroker.Table(LarReport.class)) {
            BeanBroker.Check(LarReport.class);
        }
        if (BeanBroker.Table(SusReport.class)) {
            BeanBroker.Check(SusReport.class);
        }
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