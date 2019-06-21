<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List</title>
    <script type="text/javascript"  src="/js/jquery-1.11.3.min.js"></script>
    <#--<script type="text/javascript"  src="/js/del.js"></script>-->
    <script>
        function del(id){
            alert(id);
            $.post(
                "/del", //调用的方法
                {"id" : id}, //传递参数，
                function(data){
                    if(data){
                        alert("删除成功")
                    }else{
                        alert("删除失败")
                    }
                },
                "json"
            );
        }
    </script>
</head>
<body>
    <table>
        <tr>
            <th>序号</th>
            <th>姓名</th>
            <th>年龄</th>
        </tr>
        <#list deptList as dept>
            <tr>
                <td>${dept_index}</td>
                <td>${dept.name}</td>
                <td>${dept.desc}</td>
            </tr>
            <tr>
                <td>
                    <a href="/update/${dept.id}">修改</a>
                </td>
                <td>
                    <button onclick="del('${dept.id}')">删除</button>
                </td>
            </tr>
        </#list>
    </table>
</body>
</html>