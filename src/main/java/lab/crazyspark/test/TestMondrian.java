package lab.crazyspark.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.olap4j.Cell;
import org.olap4j.CellSet;
import org.olap4j.OlapConnection;
import org.olap4j.OlapStatement;
import org.olap4j.Position;
import org.olap4j.metadata.Member;

public class TestMondrian {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 获取连接
        // Class.forName("org.olap4j.driver.xmla.XmlaOlap4jDriver");
        // Connection connection =
        // DriverManager.getConnection("jdbc:xmla:Server=http://localhost:8083/mondrianweb/xmla");
        // OlapConnection olapConnection = connection.unwrap(OlapConnection.class);

        Class.forName("mondrian.olap4j.MondrianOlap4jDriver");
        Connection conn = DriverManager.getConnection(
                // URL协议
                "jdbc:mondrian:"
                        // 连接数据源的JDBC连接
                        + "Jdbc='jdbc:mysql://localhost:3306/mondrian?user=root&password=gemini&useUnicode=true&characterEncoding=utf8';"
                        // 数据模型文件
                        + "Catalog=file:/app/work/aml/web/company.xml;"
                        // 连接数据源用到的驱动
                        // + "JdbcDrivers=com.mysql.cj.jdbc.Driver;"
                        );
        OlapConnection olapConn = conn.unwrap(OlapConnection.class);
        System.out.println(olapConn);

        OlapStatement statement = olapConn.createStatement();
        String mdx = "select {[Measures].[numb],[Measures].[averpri],[Measures].[totalsale]} on columns,{([protype].[allpro],[cusgender].[allgender])} on rows from [sales]";
        // 获取查询结果
        CellSet cs = statement.executeOlapQuery(mdx);

        // 处理返回数据
        if (cs.getAxes().size() > 1) {
            for (Position row : cs.getAxes().get(1)) {
                for (Position column : cs.getAxes().get(0)) {
                    for (Member member : row.getMembers()) {
                        System.out.println("rows:" + member.getUniqueName());
                    }
                    for (Member member : column.getMembers()) {
                        System.out.println("columns:" + member.getUniqueName());
                    }
                    final Cell cell = cs.getCell(column, row);
                    System.out.println("values:" + cell.getValue());
                    System.out.println();
                }
            }
        } else {
            for (Position column : cs.getAxes().get(0)) {
                for (Member member : column.getMembers()) {
                    System.out.println("columns:" + member.getUniqueName());
                }
                Cell cell = cs.getCell(column);
                System.out.print("values:" + cell.getValue());
                System.out.println();
            }
        }
    }
}