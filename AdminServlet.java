// import java.io.IOException;

// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import java.io.PrintWriter;
// import java.sql.*;



// public class AdminServlet extends HttpServlet {
// 	public void doPost(HttpServletRequest req, HttpServletResponse resp)
// 			throws ServletException, IOException {
// 				PrintWriter pw=resp.getWriter();
// 				char dq=(char)34;
// 				String choice=req.getParameter("name");
// 				ResultSet resultset =null;
// 				// pw.println("<style> html,body{ margin: 0; padding: 0; width: 100%; height: 100%; display: flex; background-image: url('https://static.vecteezy.com/system/resources/previews/002/188/833/non_2x/chat-wallpaper-social-media-message-background-copy-space-for-a-text-vector.jpg'); background-repeat: no-repeat; background-size: 100% 100%; background-attachment: fixed; } table{ width:90%; max-width: 550px; min-width: 350px; margin: auto; border: 1px solid black; text-align: center; background-color:#00ADB5; color:#EEEEEE; padding: 10px; border-spacing: 10px; } td,th{ border-top:1px solid black ; border-bottom: 1px solid black;} </style>");
//                 // pw.println("<!DOCTYPE html> <html lang=en> <head> <meta charset='UTF-8'> <meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1.0'> <title>Animation</title><style> html,body{ margin: 0; padding: 0; width: 100%; height: 100%; display: flex;font-size:20px; } table{ width:90%; max-width: 550px; min-width: 350px;margin: auto; border: 1px solid black; text-align: center; background-color:#00ADB5; color:#EEEEEE; padding: 10px; border-spacing: 10px; } td,th{ border-top:1px solid black ; border-bottom: 1px solid black;width: 550px;} th{ border: 1px solid } td{ border: 1px solid; transform: translate(-1000%); transition: 2s; } #loadgif img{ width:150px; height: 150px; margin: auto; border-radius: 10px; } #loadgif{ width: 100%; height: 100%; display: flex; margin:0; padding: 0; background-color:#a6bc6845; } </style> <body><script> let elementindex=0; function gettable(){ return document.querySelectorAll('td'); } function test(){ let arrayofelement=gettable(); let ele=arrayofelement[elementindex]; console.log(ele); if(arrayofelement.length>elementindex){ ele.style.transform='translate(0%)'; elementindex++; } else{ clearInterval(myintervel); } } setTimeout(()=>{document.querySelector('table').style.display='block'; },1485); const myintervel=setInterval(test,1499) </script></html>");
// 				pw.println("<!DOCTYPE html> <html lang=en> <head> <meta charset='UTF-8'> <meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1.0'> <title>Animation</title><style> html,body{ margin: 0; padding: 0; width: 100%; height: 100%; display: flex;font-size:20px; } table{ width:90%; max-width: 550px; min-width: 350px;margin: auto; border: 1px solid black; text-align: center; background-color:#00ADB5; color:#EEEEEE; padding: 10px; border-spacing: 10px; } td,th{ border-top:1px solid black ; border-bottom: 1px solid black;width: 550px;} th{ border: 1px solid } td{ border: 1px solid; transform: translate(-1000%); transition: 2s; } #loadgif img{ width:150px; height: 150px; margin: auto; border-radius: 10px; } #loadgif{ width: 100%; height: 100%; display: flex; margin:0; padding: 0; background-color:#a6bc6845; } </style> <body><script> let elementindex=0; function gettable(){ return document.querySelectorAll('td'); } function test(){ let arrayofelement=gettable(); let ele=arrayofelement[elementindex]; console.log(ele); if(arrayofelement.length>elementindex){ ele.style.transform='translate(0%)'; elementindex++; document.getElementsByTagName('table').style.height='calc(height+50)px' } else{ clearInterval(myintervel); } } setTimeout(()=>{document.querySelector('table').style.display='block'; },1485); const myintervel=setInterval(test,1499) </script></html>");
// 				try{
// 					Class.forName("com.mysql.jdbc.Driver").newInstance();
// 									Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/faculty?characterEncoding=utf8","sqluser", "password");
// 									pw.print("<table width=25% border=1>");


// 						   Statement statement = connection.createStatement() ;
					
// 						   resultset =statement.executeQuery("select * from mk where faculty_name="+dq+choice+dq ) ;
// 						   while(resultset.next()){ 
// 							pw.println("<tr>");
// 							pw.print("<td>"+resultset.getString(2)+"<br></td></tr>");


// 						   }
					
// // if (choice.equals("Prathika_san")){
// // 	pw.println("hello");
// // }
// 		// resp.setContentType("text/html");
//         // resp.sendRedirect("http://localhost:8080/toolsUpload/");
		

// 	}
// 	catch(Exception e){
// 		pw.println(e);
// 	}

// }
// }
import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

import java.io.PrintWriter;
import java.security.spec.KeySpec;
import java.sql.*;



public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				PrintWriter pw=resp.getWriter();
				char dq=(char)34;
				String choice=req.getParameter("name");
				ResultSet resultset =null;
				// pw.println("<style> html,body{ margin: 0; padding: 0; width: 100%; height: 100%; display: flex; background-image: url('https://static.vecteezy.com/system/resources/previews/002/188/833/non_2x/chat-wallpaper-social-media-message-background-copy-space-for-a-text-vector.jpg'); background-repeat: no-repeat; background-size: 100% 100%; background-attachment: fixed; } table{ width:90%; max-width: 550px; min-width: 350px; margin: auto; border: 1px solid black; text-align: center; background-color:#00ADB5; color:#EEEEEE; padding: 10px; border-spacing: 10px; } td,th{ border-top:1px solid black ; border-bottom: 1px solid black;} </style>");
                // pw.println("<!DOCTYPE html> <html lang=en> <head> <meta charset='UTF-8'> <meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1.0'> <title>Animation</title><style> html,body{ margin: 0; padding: 0; width: 100%; height: 100%; display: flex;font-size:20px; } table{ width:90%; max-width: 550px; min-width: 350px;margin: auto; border: 1px solid black; text-align: center; background-color:#00ADB5; color:#EEEEEE; padding: 10px; border-spacing: 10px; } td,th{ border-top:1px solid black ; border-bottom: 1px solid black;width: 550px;} th{ border: 1px solid } td{ border: 1px solid; transform: translate(-1000%); transition: 2s; } #loadgif img{ width:150px; height: 150px; margin: auto; border-radius: 10px; } #loadgif{ width: 100%; height: 100%; display: flex; margin:0; padding: 0; background-color:#a6bc6845; } </style> <body><script> let elementindex=0; function gettable(){ return document.querySelectorAll('td'); } function test(){ let arrayofelement=gettable(); let ele=arrayofelement[elementindex]; console.log(ele); if(arrayofelement.length>elementindex){ ele.style.transform='translate(0%)'; elementindex++; } else{ clearInterval(myintervel); } } setTimeout(()=>{document.querySelector('table').style.display='block'; },1485); const myintervel=setInterval(test,1499) </script></html>");
				pw.println("<!DOCTYPE html> <html lang=en> <head> <meta charset='UTF-8'> <meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1.0'> <title>Animation</title><style> html,body{ margin: 0; padding: 0; width: 100%; height: 100%; display: flex;font-size:20px; } table{ width:90%; max-width: 550px; min-width: 350px;margin: auto; border: 1px solid black; text-align: center; background-color:#00ADB5; color:#EEEEEE; padding: 10px; border-spacing: 10px; } td,th{ border-top:1px solid black ; border-bottom: 1px solid black;width: 550px;} th{ border: 1px solid } td{ border: 1px solid; transform: translate(-1000%); transition: 2s; } #loadgif img{ width:150px; height: 150px; margin: auto; border-radius: 10px; } #loadgif{ width: 100%; height: 100%; display: flex; margin:0; padding: 0; background-color:#a6bc6845; } </style> <body><script> let elementindex=0; function gettable(){ return document.querySelectorAll('td'); } function test(){ let arrayofelement=gettable(); let ele=arrayofelement[elementindex]; console.log(ele); if(arrayofelement.length>elementindex){ ele.style.transform='translate(0%)'; elementindex++; document.getElementsByTagName('table').style.height='calc(height+50)px' } else{ clearInterval(myintervel); } } setTimeout(()=>{document.querySelector('table').style.display='block'; },1485); const myintervel=setInterval(test,1499) </script></html>");
				try{
					Class.forName("com.mysql.jdbc.Driver");
									Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/faculty?characterEncoding=utf8","sqluser", "password");
									pw.print("<table width=25% border=1>");


						   Statement statement = connection.createStatement() ;
					
						   resultset =statement.executeQuery("select * from mk where faculty_name="+dq+choice+dq ) ;
                           resultset.afterLast();
						   while(resultset.previous()){ 
							pw.println("<tr>");
							pw.print("<td>"+(resultset.getString(2))+"<br></td></tr>");


						   }
					
// if (choice.equals("Prathika_san")){
// 	pw.println("hello");
// }
		// resp.setContentType("text/html");
        // resp.sendRedirect("http://localhost:8080/toolsUpload/");
		

	}
	catch(Exception e){
		pw.println(e);
	}

}
}
class Crypting2 {

    private static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private KeySpec ks;
    private SecretKeyFactory skf;
    private Cipher cipher;
    byte[] arrayBytes;
    private String myEncryptionKey;
    private String myEncryptionScheme;
    SecretKey key;

    public Crypting2() throws Exception {
        myEncryptionKey = "ThisIsSpartaThisIsSparta";
        myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
        arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        ks = new DESedeKeySpec(arrayBytes);
        skf = SecretKeyFactory.getInstance(myEncryptionScheme);
        cipher = Cipher.getInstance(myEncryptionScheme);
        key = skf.generateSecret(ks);
    }


    public String decrypt(String encryptedString) {
        String decryptedText=null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedText = Base64.decodeBase64(encryptedString.getBytes());
            byte[] plainText = cipher.doFinal(encryptedText);
            decryptedText= new String(plainText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedText;
    }




}


