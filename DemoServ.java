import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.security.MessageDigest;


public class DemoServ extends HttpServlet{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
String name1=req.getParameter("name");
String name=name1.replace(" ","_");
String password=req.getParameter("password");
String mail=req.getParameter("mail");
char dq=(char)34;
try{
MessageDigest md = MessageDigest.getInstance("SHA-256");
md.update(password.getBytes());
byte[] digest = md.digest();   
StringBuffer hexString = new StringBuffer();
for (int i = 0;i<digest.length;i++) {
    hexString.append(Integer.toHexString(0xFF & digest[i]));
 }
 password=hexString.toString();


}
catch(Exception e){
  pw.print(e);
}


try{
    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/faculty?characterEncoding=utf8","sqluser", "password");
                    Statement statement = connection.createStatement() ;
                    statement.executeUpdate("insert into mk values('"+name+"','Thank you for spending time to listen')");
                    statement.executeUpdate("insert into password values('"+name+"','"+password+"','"+mail+"')");
                    
}
catch(Exception e){
System.out.println(e);
}
pw.println("<body style='margin:0px;padding:0px;height:100vh;width:100vw,display:flex;align-items:center;justify-content:center;'><h1 style='font-size:3em;margin-top:45vh;display:flex;align-items:center;justify-content:center;'>New user  "+name+"  has been added sucessfully</h1><center><button style='font-size:20px;padding:10px;color:white;background-color: black;border-radius:10px;margin:0px;height:50px;width:100px,display:flex;align-items:center;justify-content:center;' id='button' onclick="+dq+"history.go(-2)"+dq+">Login?</button></center></body>");
}}
