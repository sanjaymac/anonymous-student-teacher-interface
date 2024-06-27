import java.sql.*;
import java.util.*;
public class trial{
    public static void main(String args[]){
        char dq=(char)34;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
                            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/faculty?characterEncoding=utf8","sqluser", "password");
                            Statement statement = connection.createStatement() ;
                            String cmd="select * from password where faculty="+dq+"Prathika_san"+dq;
                            ResultSet rs=statement.executeQuery(cmd);
                            while(rs.next()){
                            System.out.println(rs.getString(2));
    }}
    catch(Exception e){
        System.out.println(e);
    }
}
}