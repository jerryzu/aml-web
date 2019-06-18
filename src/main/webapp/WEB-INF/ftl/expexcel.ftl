<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">  
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" dir="ltr">  
<head>  
 <title>test!</title>  
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>  
</head>  
<body>
    <div>  
    遍历List中的元素  
    strList:<br/>  
    <#list strList as strValue >  
    <#if strValue_index == 0>  
        ${strValue} is first element  
    <#elseif !strValue_has_next>  
        ${strValue} is last element  
    <#else>  
        ${strValue}  
    </#if>  
    <br />  
    </#list>  
    <hr/>   
    </div>
    <#include "foot.html">  
</body>     
</html>