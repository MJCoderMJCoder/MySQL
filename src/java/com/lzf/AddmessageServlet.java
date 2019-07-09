package com.lzf;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
@WebServlet(name = "addmessageServlet", urlPatterns = {"/addmessageServlet"})
public class AddmessageServlet extends HttpServlet {
  private Connection conn;
    public AddmessageServlet() {
         try{
           conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/message","root","6003");
         }catch(Exception e){
             System.err.println(e.toString());
         }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name1=request.getParameter("name");
        String title1=request.getParameter("title");
        String email1=request.getParameter("email");
        String content1=request.getParameter("content");
        if(name1==null) name1="";
        if(title1==null) title1="";
        if(email1==null) email1="";
        if(content1==null) content1="";
        try{
            PreparedStatement stm=conn.prepareStatement("insert into lyinf values(?,?,?,?)");
            stm.setString(1,name1);
            stm.setString(2,title1);
            stm.setString(3,email1);
            stm.setString(4,content1);
           try{
              stm.executeUpdate();
           }catch(Exception e){}
           RequestDispatcher re=request.getRequestDispatcher("viewmessage");
           re.forward(request, response);     
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      doGet(request,response);
    }
}