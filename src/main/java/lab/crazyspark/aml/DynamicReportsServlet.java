package lab.crazyspark.aml;

/**
DynamicJasper-5.0.4-bundle解压之后里面有5个DynamicJasper的.jar文件；
jasperreports-6.3.0-project的压缩包里面的jasperreports-6.3.0.jar；
dynamicreports-4.1.1-project-with-dependencies里面的\lib路径里面的commons-collections-3.2.2.jar;
commons-digester-2.1.jar;commons-lang3-3.1.jar;commons-logging-1.1.1.jar；itext-2.1.7.js5.jar
 */
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
// import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
// import net.sf.dynamicreports.report.builder.DynamicReports;
// import net.sf.dynamicreports.report.builder.column.Columns;
// import net.sf.dynamicreports.report.builder.component.Components;
// import net.sf.dynamicreports.report.builder.datatype.DataTypes;
// import net.sf.dynamicreports.report.builder.style.StyleBuilder;
// import net.sf.dynamicreports.report.constant.HorizontalAlignment;
// import net.sf.dynamicreports.report.constant.PageType;
// import net.sf.dynamicreports.report.exception.DRException;
// import com.lowagie.text.pdf.BaseFont;

import com.lowagie.text.pdf.BaseFont;

import lab.crazyspark.broker.Notifier;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.exception.DRException;

@WebServlet("/dynamicreport")
public class DynamicReportsServlet  extends HttpServlet   {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;

	public DynamicReportsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置响应的编码格式为UTF-8编码，否则发生中文乱码现象
		response.setContentType("text/html;charset=UTF-8");
		out = response.getWriter();
		// Notifier notifier = new Notifier();
		// notifier.regist(this);
		// buildReport.setNotifier(notifier);
		String filepath = request.getSession().getServletContext().getRealPath("/download/") + "aml.pdf";
		// buildReport.Exp2Excel(filepath);
		buildReport(null, null, filepath);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void buildReport(Connection conn, String sqlString, String filepath) {
		JasperReportBuilder report = DynamicReports.report();
		StyleBuilder boldStl = DynamicReports.stl.style().bold();
		StyleBuilder boldCenteredStl = DynamicReports.stl.style(boldStl)
				.setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
		;
		StyleBuilder titleStl = DynamicReports.stl.style(boldCenteredStl).setFontSize(16);
		StyleBuilder columnTitleStl = DynamicReports.stl.style(boldCenteredStl)
				.setBorder(DynamicReports.stl.pen1Point()).setBackgroundColor(Color.LIGHT_GRAY);// 设置列名栏的背景颜色为灰色

		StyleBuilder fontStyleBuilder = DynamicReports.stl.style().setPadding(2).setPdfFontName("STSong-Light")
				.setPdfEncoding("UniGB-UCS2-H").setPdfEmbedded(BaseFont.NOT_EMBEDDED);

		columnTitleStl.setPdfFontName("STSong-Light").setPdfEncoding("UniGB-UCS2-H")
				.setPdfEmbedded(BaseFont.NOT_EMBEDDED);

		titleStl.setPdfFontName("STSong-Light").setPdfEncoding("UniGB-UCS2-H").setPdfEmbedded(BaseFont.NOT_EMBEDDED);

		report.setPageFormat(PageType.A5); // 设置每一页的格式

		report.columns(
				Columns.column("操作日期", "OperateTime", DataTypes.stringType())
						.setHorizontalTextAlignment(HorizontalTextAlignment.CENTER),
				Columns.column("用户姓名", "CustomerName", DataTypes.stringType())
						.setHorizontalTextAlignment(HorizontalTextAlignment.CENTER),
				Columns.column("扣钱", "Deductmoney", DataTypes.stringType())
						.setHorizontalTextAlignment(HorizontalTextAlignment.CENTER),
				Columns.column("存钱", "Savemoney", DataTypes.stringType())
						.setHorizontalTextAlignment(HorizontalTextAlignment.CENTER),
				Columns.column("用户ID", "CustomerID", DataTypes.stringType())
						.setHorizontalTextAlignment(HorizontalTextAlignment.CENTER),
				Columns.column("余额", "CustomerMoney", DataTypes.stringType())
						.setHorizontalTextAlignment(HorizontalTextAlignment.CENTER))
				.setColumnStyle(fontStyleBuilder) // 查询的数据的字体格式
				.setColumnTitleStyle(columnTitleStl) // 设置列名的风格
				.setHighlightDetailEvenRows(true) // 偶数行高亮显示
				.title(Components.text("客户消费单").setStyle(titleStl))// 标题
				.pageFooter(Components.pageXofY().setStyle(boldCenteredStl))// 页角
		// .setDataSource("SELECT * FROM ReportMessage WHERE OperateTimeCustomerID = '"
		// + sqlString + "'", conn)
		;// 数据源
		try {
			// 显示报表
			report.show(false); // 关闭预览窗口后不退出程序
			try {
				FileOutputStream fileOutputStream = new FileOutputStream(filepath);// 构建一个pdf存放的输出位置
				report.toPdf(fileOutputStream);// 打印的pdf地址
				try {
					fileOutputStream.flush(); // 保证pdf输出完毕
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	public void processEvent(String EventInfo) {
		out.println(String.format("%s%s", EventInfo, "<br>"));
		out.flush();
		System.out.println(String.format("%s", EventInfo));
	}
}