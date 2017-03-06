import java.sql.*;

public class JavaSqlDemo {

    public static void main(String[] args) {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/mysql";
        String user = "root";
        String password = "123456";

        try {
            // 加载驱动程序
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            if(!conn.isClosed()){
                System.out.println("Succeeded connecting to the Database!");
            }

            Statement statement = conn.createStatement();
            String sql = "select * from help_category";
            ResultSet rs = statement.executeQuery(sql);
            System.out.println(rs);
            rs.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
