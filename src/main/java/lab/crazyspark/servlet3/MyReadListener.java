package lab.crazyspark.servlet3;

import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class MyReadListener implements ReadListener {
    private ServletInputStream inputStream;
    private AsyncContext asyncContext;

    public MyReadListener(ServletInputStream input, AsyncContext context) {
        this.inputStream = input;
        this.asyncContext = context;
    }
    
    @Override
    public void onDataAvailable() throws IOException {
        System.out.println("数据可用时触发执行");
    }
    
    @Override
    public void onAllDataRead() throws IOException {
        try {
            PrintWriter out = asyncContext.getResponse().getWriter();
            out.write("数据读完了");
            Thread.sleep(3000);// 暂停5秒，模拟耗时处理数据
            out.write("数据读完了");
            out.flush();
            System.out.println("数据读完了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void onError(Throwable t) {
        System.out.println("数据 出错");
        t.printStackTrace();
    }
}