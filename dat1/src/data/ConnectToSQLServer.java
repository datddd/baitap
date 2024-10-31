package data;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource; // Thêm import cho SQLServerDataSource
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectToSQLServer {
    private static SQLServerDataSource ds;

    static {
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("123456789");
        ds.setServerName("DESKTOP-2U87JGK\\MAY1");
        ds.setPortNumber(1433);
        ds.setDatabaseName("QuanLyVeXemPhim");
        ds.setTrustServerCertificate(true); // Trust server certificate
    }

    public static Connection getConnection() {
    try {
        return ds.getConnection(); // Trả về kết nối
    } catch (SQLException e) {
        throw new RuntimeException("Không thể kết nối đến cơ sở dữ liệu", e); // Ném lại ngoại lệ dưới dạng RuntimeException
    }
}

    public static void main(String[] args) {
        try (Connection con = getConnection()) {
            if (con != null) {
                System.out.println("Kết nối với SQL thành công!");
                System.out.println(con.getCatalog());
            } else {
                System.out.println("Không thể kết nối với SQL.");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra thông tin lỗi nếu có vấn đề
        }
    }
}
