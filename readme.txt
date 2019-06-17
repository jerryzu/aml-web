mvn archetype:generate
cd web/
code .

创建好的JavaWeb项目中目前只有src/main/resources目录，因此还需要手动添加src/main/java、src/test/java、src/test/resources
编辑pom.xml加入jetty插件(用于运行本地应用服务器)：

<finalName>my-WebApp</finalName>下添加
<pluginManagement>
<!--配置Jetty--> 
<plugins>
<plugin>
<groupId>org.mortbay.jetty</groupId>
<artifactId>maven-jetty-plugin</artifactId>
</plugin>
</plugins>
</pluginManagement>

接着我们就可以将创建好的JavaWeb导入Eclipse中进行update maven project，更新依赖jar
<dependency>
<groupId>javax.servlet</groupId>
<artifactId>servlet-api</artifactId>
<version>2.5</version>
<scope>provided</scope>
</dependency>

使用Maven打包发布Web项目：
C:\Users\Administrator\my-WebApp>mvn package
运行jetty，监听本地的8080端口
C:\Users\Administrator\my-WebApp>mvn jetty:run
浏览器访问http://127.0.0.1/my-WebApp

./shutdown.sh 
rm -rf ../logs/*
./startup.sh 
tail -f ../logs/catalina.out 

