package com.lzf;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.servlet.*;
import java.sql.*;
@WebServlet(name = "viewmessage", urlPatterns = {"/viewmessage"})
public class Viewmessage extends HttpServlet {
    private Connection conn;
    public Viewmessage() {
        try{
           conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/message","root","6003");
         }catch(Exception e){
             System.err.println(e.toString());
         }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Collection ret=new ArrayList();
       try{
           PreparedStatement stm=conn.prepareStatement("select * from message");
           ResultSet res = stm.executeQuery();
               while(res.next()){
                   int id=res.getInt("idmessage");
                   String na=res.getString("name");
                   String tl=res.getString("title");
                   String em=res.getString("email");
                   String co=res.getString("content");
                   Messagedata message=new Messagedata();
                   message.setIdmessage(id);
                   message.setName(na);
                   message.setTitle(tl);
                   message.setEmail(em);
                   message.setContent(co);
                   ret.add(message);
               }
               res.close();
               stm.close();
           request.setAttribute("message", ret);
           RequestDispatcher re=request.getRequestDispatcher("viewmessage.jsp");
            re.forward(request, response);   
       }catch(Exception e){
           e.printStackTrace();
       }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doGet(request,response);
    }
}