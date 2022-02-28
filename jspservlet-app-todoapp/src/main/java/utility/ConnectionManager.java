package utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
public class ConnectionManager
{
   public static Connection getConnection(){
       Connection con=null;
       try
       {
          Class.forName("com.mysql.cj.jd.bc.Driver");
          con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","examly");
          return con;
       }  
       catch(Exception e)
       {
           e.printStackTrace();
        }
      return con; 
   }   
  public static void printException(SQLException ex) {
    for (Throwable e: ex) {
        if (e instanceof SQLException) {
            e.printStackTrace(System.err);
            System.err.println("SQLState: " + ((SQLException) e).getSQLState());
            System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
            System.err.println("Message: " + e.getMessage());
            Throwable t = ex.getCause();
             while (t != null) {
               System.out.println("Cause: " + t);
               t = t.getCause();
             }
         }
      }
   }
   public static Date getSQLDate(LocalDate date) {
      return java.sql.Date.valueOf(date);
  }

  public static LocalDate getUtilDate(Date sqlDate) {
      return sqlDate.toLocalDate();
  }
}   