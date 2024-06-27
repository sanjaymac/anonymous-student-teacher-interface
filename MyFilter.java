import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.security.MessageDigest;

public class MyFilter implements Filter{




	public void init(FilterConfig arg0) throws ServletException {}
	
	public void doFilter(ServletRequest req, ServletResponse resp,
		FilterChain chain) throws IOException, ServletException {
		PrintWriter pw=resp.getWriter();
		String rhsPass=req.getParameter("password");
		String lhsPass="";
		String choice=req.getParameter("name");
		String addUser=req.getParameter("add");
		char dq=(char)34;
		try{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(rhsPass.getBytes());
			byte[] digest = md.digest();   
			StringBuffer hexString = new StringBuffer();
			for (int i = 0;i<digest.length;i++) {
				hexString.append(Integer.toHexString(0xFF & digest[i]));
			 }
			 rhsPass=hexString.toString();
			
			
			}
			catch(Exception e){
			  pw.print(e);
			}
		try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
                            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/faculty?characterEncoding=utf8","sqluser", "password");
                            Statement statement = connection.createStatement() ;
                            String cmd="select * from password where faculty="+dq+choice+dq;
                            ResultSet rs=statement.executeQuery(cmd);
                            while(rs.next()){
                            lhsPass=(rs.getString(2));
    }}
    catch(Exception e){
        System.out.println(e);
    }
	if(rhsPass.equals(lhsPass)){
		chain.doFilter(req, resp);

	}
	if(rhsPass.equals(lhsPass)==false || addUser.equals("Add new user?") && rhsPass.equals(lhsPass)==false){
		String co="<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'><meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1.0'><title>Document</title></head><style>*{box-sizing:border-box;padding:0px;margin:0px}body{color:rgba(255,255,255,0.8);background-image: url('https://static.vecteezy.com/system/resources/previews/002/188/833/non_2x/chat-wallpaper-social-media-message-background-copy-space-for-a-text-vector.jpg');background-size: 100% 100%;width:100vw;height:100vh;display:flex;flex-direction:column;align-items:center;justify-content:center}#errorbox{text-align:center}#button{margin:20px;padding:10px 20px}</style><body><div id='errorbox'><h1>incorrect password</h1><center><button id='button' onclick="+dq+"history.go(-1)"+dq+">retry?</button></center></html>";
        pw.println(co);
	}



	if(addUser.equals("Add new user?") && rhsPass.equals(lhsPass)==true){
		HttpServletResponse httpResponse = (HttpServletResponse) resp;
			httpResponse .sendRedirect("http://localhost:8080/addUser/");
			return;
	}

		
		

		
		
		
		
	}
	public void destroy() {}

	

}
