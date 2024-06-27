<%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>

<HTML>
<HEAD>
    <TITLE>motta kadidhasi</TITLE>
</HEAD>
<style>
        *{
        margin:0px;
        padding:0px;
        }
        body{
            height: 100vh;
            width: 100vw;
            display: flex;
            justify-content: center;
            align-items: center;
            background-image: url('https://static.vecteezy.com/system/resources/previews/002/188/833/non_2x/chat-wallpaper-social-media-message-background-copy-space-for-a-text-vector.jpg');
            background-size: 100% 100%;
            color:black;
        }
        #div{
            height: 45vh;
            width: 30vw;
            display: flex;
            flex-direction: column;      
            justify-content: space-between;      
            background-blend-mode: darken;
            box-shadow: 20px 20px 50px 15px black;
            justify-content: space-evenly;
            align-items: center;
        }
        input[type=submit]{
             padding:10px 20px;
             color:white;
             background-color: black;
             border-radius:10px;
        }
        input[type=password],input[type=text]{
            padding:10px 20px;
            border-radius:10px; 
            
        }
        select{
         height:50px;
         padding:10px;
         /* background-color: rgb(88, 243, 204); */
         background-color:rgba(68,209,255,0.7);
         font-family: "Lucida Console", "Courier New", monospace;
        font-size: 20px;
        border-radius: 30px;
         

       }
       
    </style>
    <body>
<form action="filter" method="post">
    <div id="div">


<%
    try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/faculty?characterEncoding=utf8","sqluser", "password");


       Statement statement = connection.createStatement() ;

       resultset =statement.executeQuery("select distinct faculty_name from mk") ;

%>

<center>
    <h1>My Students call me by:</h1><br>
        <select name="name" >
        <%  while(resultset.next()){ %>
            <option value=<%= resultset.getString(1)%>><%= resultset.getString(1)%></option>
        <% } %>
        </select>
        <br>
        <br>
        <br>
        <div id="sp">
        <input id="ad_p"type="password" name="password"placeholder="Enter your password..."><br>
        <br>
        <input id="pass" type="checkbox" onclick="viewpass()">&nbsp;&nbsp;&nbsp;Show Password
        </div>
        <br>
        <br>
        <br>
        <div>
        <input type="submit" value="login"><br><br>(or)<br><br>
        <input type="submit" value="Add new user?" name="add" >  
    </div>
    </div>
</form>     

</center>
</body>

<%
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>
<script>
    function viewpass(){
    var x = document.getElementById("ad_p");
    if (x.type === "password") {
      x.type = "text";
    } else {
      x.type = "password";
    }
  }
</script>
</BODY>
</HTML>