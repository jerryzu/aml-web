开启Tomcat

开启一个页面A先访问http://localhost:8080/CometTest/Comet.jsp

再打开一个新的页面B访问http://localhost:8080/CometTest/Test

此时能够看到A的内容不断的增加

PS:若想让onload函数不失效可以把对iframe的src的赋值操作放在onload中，而一开始src为空