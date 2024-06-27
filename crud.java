import java.util.Scanner;
import java.sql.*;
public class crud{

    public static void main(String args[])
    {
        Scanner read=new Scanner(System.in);
        System.out.println("enter command:\ni)create database|---i)Create table\n\t\t |---ii)drop table\nii)Read database|---i)describe table\n\t       |---ii)view table\nii)Update database|i)insert\niii)delete database/tables");
      System.out.print("ex:create->creates database ,update->updates database\nenter command:");
        String choice= read.nextLine();
        switch(choice){
            case "create":
            System.out.println("enter user name");
            String user=read.nextLine();
            System.out.println("enter password");
            String pass=read.nextLine();
            try
         
            {
                Class.forName("com.mysql.jdbc.Driver");

                Connection connectionObject=DriverManager.getConnection("jdbc:mysql://localhost:3306/", user, pass);
                Statement statementObject=connectionObject.createStatement();
                System.out.println("enter database name");
                String dataBaseName=read.next();
                String dataBaseName2="create database "+dataBaseName;
                statementObject.executeUpdate(dataBaseName2);
                System.out.println("database created");
                System.out.println("create new table?  Y/n");
                String choice1=read.next();
                if (choice1.equals("y")|| choice1.equals("Y"))
                {
                    String commandString="";
                    String tempDataType="";
                    String tempColumnName="";
                    System.out.println("enter the name of the table");
                    String tableName=read.next();
                    System.out.println("enter the number of columns");
                    int columnSize=read.nextInt();
                    commandString="create table "+tableName+" (";
                    for(int i=0;i<columnSize;i++ ){
                        System.out.println("enter column"+i+" name");
                        tempColumnName=read.next();
                        commandString+=" "+tempColumnName;
                        System.out.println("enter column"+i+" datatype");
                        tempDataType=read.next();
                        commandString+=" "+tempDataType+"(255),";
                    


                    }
                    int strlen=commandString.length();

                    StringBuffer commandString1=new StringBuffer(commandString);
                    commandString1.deleteCharAt(strlen-1);
                    String commandString2=commandString1.toString();
                    commandString2+=")";
                    System.out.println(commandString2);
                    Connection connectionObject2=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dataBaseName, user, pass);
                    Statement statementObject2=connectionObject2.createStatement();

                    statementObject2.executeUpdate(commandString2);

                }
                if(choice1.equals("n")|| choice1.equals("N")){
                    Connection connectionObject2=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dataBaseName, user, pass);
                    Statement statementObject2=connectionObject2.createStatement();
                    System.out.println("enter the name of an existing table");
                    String tableName=read.next();
                    System.out.println("enter one of the following commands:\ni)view\nii)describe\niii)drop");
                    String tableChoice=read.next();
                    switch(tableChoice){
                        case "view":
 
                        ResultSet rs=statementObject2.executeQuery("select*from "+tableName);
                while(rs.next()){
                    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(3));
                }
                connectionObject.close();
                break;


                    }


                }
               
            }
            catch(Exception e){
                System.out.println(e);
            }

            break;
            case "read":          
            System.out.println("enter user name");
            String user1=read.nextLine();
            System.out.println("enter password");
            String pass1=read.nextLine();
            System.out.println("enter database to use");
            String dataBaseName2=read.next();
            try{
                Connection connectionObject2=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dataBaseName2, user1, pass1);
                    Statement statementObject2=connectionObject2.createStatement();
                    System.out.println("enter the name of an existing table");
                    String tableNamee=read.next();   
                    System.out.println("enter one of the following commands:\ni)view\nii)describe\niii)drop");
                    String tableChoice=read.next();
                    switch(tableChoice){
                        case "view":
 
                        ResultSet rs=statementObject2.executeQuery("select*from "+tableNamee);
                while(rs.next()){
                    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(3));
                }
                connectionObject2.close();
                break;
                case "describe":
                ResultSet rsd=statementObject2.executeQuery("describe "+tableNamee);
                System.out.println("Field   Type     Null");
                while(rsd.next()){  
                    System.out.println(rsd.getString(1)+" "+rsd.getString(2)+" "+rsd.getString(3));
                }
                connectionObject2.close();
              

                    }


            }
            catch(Exception e){
                System.out.println(e);
            }
            break;
            case "update":
                System.out.println("enter user name");
            String user2=read.nextLine();
            System.out.println("enter password");
            String pass2=read.nextLine();
            System.out.println("enter database to use");
            String dataBaseName3=read.next();
            try{
                Connection connectionObject3=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dataBaseName3, user2, pass2);
                    Statement statementObject2=connectionObject3.createStatement();
                    System.out.println("enter the name of an existing table");
            String tableName3=read.next(); 
            String commandString3="insert into "+tableName3+" (";
            System.out.println("enter the number of columns");
            int columnSize2=read.nextInt();
            String tempColumnName="";
            for(int i=0;i<columnSize2;i++)
            {
                System.out.println("enter column"+i+" name");
                commandString3+=read.next()+",";


            }
            int strlen=commandString3.length();

            StringBuffer commandString4=new StringBuffer(commandString3);
                    commandString4.deleteCharAt(strlen-1);
                    String commandString5=commandString4.toString()+") values (";
                    for(int i=0;i<columnSize2;i++)
                    {
                        System.out.println("enter column"+i+" values");
                        commandString5+="'"+read.next()+"'"+",";
        
        
                    }
                    StringBuffer commandString9=new StringBuffer(commandString5);
                    int strlen2=commandString5.length();
                    commandString9.deleteCharAt(strlen2-1);
                     commandString5=commandString9.toString()+")";
                    
            System.out.println(commandString5);
            statementObject2.executeUpdate(commandString5);


            }
            catch(Exception e){
                System.out.println(e);
            }
            break;
            case "delete":
            System.out.println("enter user name");
            String user3=read.nextLine();
            System.out.println("enter password");
            String pass3=read.nextLine();
            System.out.println("enter database to use");
            String dataBaseName6=read.next();
            System.out.println("database/table?");
            String deleteChoice=read.next();
            if(deleteChoice.equals("database")){
                try{
                    Connection connectionObject4=DriverManager.getConnection("jdbc:mysql://localhost:3306/", user3, pass3);
                    Statement statementObject7=connectionObject4.createStatement();
      {		      
         String deleteCommand = "drop database"+" "+dataBaseName6;
         statementObject7.executeUpdate(deleteCommand);
         System.out.println("database deleted");   	  
      }
     }
      catch (Exception e) {
         System.out.println(e);
      } 
            }
            if(deleteChoice.equals("table")){
                System.out.println("enter the name of the table");
                String deleteTableName=read.next();
                try{
                    Connection connectionObject4=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dataBaseName6, user3, pass3);
                    Statement statementObject7=connectionObject4.createStatement();
      {		      
         String deleteCommand = "drop table"+" "+deleteTableName;
         statementObject7.executeUpdate(deleteCommand);
         System.out.println("table deleted");   	  
      }
     }
      catch (Exception e) {
         System.out.println(e);
      } 
            }
            
            




        }
    }
}