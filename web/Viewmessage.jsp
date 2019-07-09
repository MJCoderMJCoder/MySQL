<%@page contentType="text/html" pageEncoding="UTF-8" import="com.lzf.Messagedata"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <center>查看留言簿</center>
        <table border="1" width="100%" bordercolorlight="#CC99FF" cellpadding="2" bordercolordark="#FFFFFF" cellspacing="0"> 
<tr> 
  <td align="center">ID</td> 
  <td align="center">姓名</td> 
  <td align="center">主题</td> 
  <td align="center">Email</td>
  <td align="center">留言</td>
</tr> 
        <%
        int co=0;
        Collection mess=(Collection)request.getAttribute("message");
        Iterator it=mess.iterator();
        while(it.hasNext()){
            Messagedata mg=(Messagedata)it.next();
        %>
        <tr><!--显示记录--> 
  <td align="center"><%=mg.getIdmessage()%></td> 
  <td align="center"><%=mg.getName()%></td>
  <td align="center"><%=mg.getTitle()%></td>
  <td align="center"><%=mg.getEmail()%></td>
  <td align="center"><%=mg.getContent()%></td>
 </tr> 
        <% co++;
        }
        %>
        </table>
        <p align="center"><a href="message.jsp">我要留言</a></p>
    </cebter>
    </body>
</html>