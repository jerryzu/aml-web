package lab.crazyspark.aml;

import freemarker.ext.servlet.FreemarkerServlet;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns = { "*.ftl" }, // 需要定义Freemarker解析的页面后缀类型
        asyncSupported = false, loadOnStartup = 0, name = "templateController", displayName = "TemplateController", initParams = {
                @WebInitParam(name = "TemplatePath", value = "/"), @WebInitParam(name = "NoCache", value = "true"), // 定义是否缓存
                @WebInitParam(name = "ContentType", value = "text/html; charset=UTF-8"), // 定义内容类型
                @WebInitParam(name = "template_update_delay", value = "0"), // 开发环境中可设置为0
                @WebInitParam(name = "default_encoding", value = "UTF-8"),
                @WebInitParam(name = "number_format", value = "0.##########") })
public class TemplateController extends FreemarkerServlet {
    private static final long serialVersionUID = 8714019900490761087L;
}