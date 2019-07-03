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

./shutdown.sh
cp /app/work/aml/web/target/web.war /app/tomcat/webapps/
rm -rf ../logs/*
./startup.sh
tail -f ../logs/catalina.out 

copy
/app/work/aml/web/src/main/java/c3p0-config.xml
/app/work/aml/web/src/main/java/log4j2.properties
to
/app/work/aml/web/target/web.war

/app/tomcat/bin/shutdown.sh
ps -ef | grep /app/tomcat | awk '{print $2}' | xargs kill -9
cp /app/work/aml/web/target/web.war /app/tomcat/webapps/
rm -rf ../logs/*
./startup.sh
tail -f ../logs/catalina.out 


在build节点加入一下语句使包正确的导入

   <resources>
            <resource>
                <directory>${project.basedir}/lib</directory>
                <targetPath>BOOT-INF/lib/</targetPath>
                        <includes>
                           <include>**/*.jar</include>
                        </includes>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <targetPath>BOOT-INF/classes/</targetPath>
            </resource>
</resources>

mvn package -f "/app/work/aml/auditing/pom.xml"
cp /app/work/aml/auditing/target/auditing-1.0-SNAPSHOT.jar /app/work/aml/web/src/main/webapp/WEB-INF/lib/
mvn package -f "/app/work/aml/web/pom.xml"

[jerry@j 下载]$ ll *.jar
-rw-rw-r--. 1 jerry jerry   18402 7月   3 16:08 eigenbase-properties-1.1.4.jar
-rw-rw-r--. 1 jerry jerry   65958 7月   3 16:16 eigenbase-resgen-1.3.6.jar
-rw-rw-r--. 1 jerry jerry  107048 1月   9 2014 eigenbase-xom-1.3.4.jar
-rw-rw-r--. 1 jerry jerry 3545890 7月   3 15:04 mondrian-3.14.0.0-12.jar
-rw-rw-r--. 1 jerry jerry    1156 5月  20 09:52 ojdbc-14.jar

mvn install:install-file -Dfile=eigenbase-xom-1.3.4.jar -DgroupId=eigenbase -DartifactId=eigenbase-xom -Dversion=1.3.4  -Dpackaging=jar
mvn install:install-file -Dfile=eigenbase-properties-1.1.4.jar -DgroupId=eigenbase -DartifactId=eigenbase-properties -Dversion=1.1.4  -Dpackaging=jar
mvn install:install-file -Dfile=eigenbase-resgen-1.3.6.jar -DgroupId=eigenbase -DartifactId=eigenbase-resgen -Dversion=1.3.6  -Dpackaging=jar