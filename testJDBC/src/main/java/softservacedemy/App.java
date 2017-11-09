package softservacedemy;


import java.sql.*;

public class App
{
    public static void main( String[] args )
    {
        final String URL = "jdbc:mysql://localhost:3306/testdb";
        final String USER ="root";
        final String PASS="7445215";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL,USER,PASS);
           Statement stm = con.createStatement();
           // stm.execute("INSERT INTO user(userName)VALUE ('Petro')");

          /* PreparedStatement pstm = con.prepareStatement("INSERT  INTO user (userName) VALUE (?)");
           pstm.setString(1,"Dmytro");
           pstm.execute();*/
          /*CallableStatement cstm = con.prepareCall("{call proc(?)}");
          cstm.setString(1,"Roman");
          cstm.execute();*/

          ResultSet resultSet = stm.executeQuery("SELECT * FROM user");

          while (resultSet.next()){
              System.out.println(resultSet.getString("userName"));
          }




            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
