package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOuser {

    // Phương thức để thêm người dùng
    public void addUser(user user) {
        String sqlInsert = "INSERT INTO NGUOIDUNG (TENDANGNHAP, MATKHAU, HOTEN, EMAIL, SDT) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConnectToSQLServer.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert)) {

            // Thiết lập các tham số cho câu truy vấn
            preparedStatement.setString(1, user.getTendn());
            preparedStatement.setString(2, user.getMk());
            preparedStatement.setString(3, user.getTen());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getSdt());

            preparedStatement.executeUpdate();
            System.out.println("Thêm người dùng thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm người dùng: " + e.getMessage());
        }
    }

    // Phương thức để lấy danh sách người dùng
    public List<user> getUser() {
        List<user> users = new ArrayList<>();
        String sql = "SELECT * FROM NGUOIDUNG";

        try (Connection connection = ConnectToSQLServer.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                user user = new user();  // Dùng constructor không tham số
                user.setId(resultSet.getString("ID"));
                user.setTendn(resultSet.getString("TENDANGNHAP"));
                user.setMk(resultSet.getString("MATKHAU"));
                user.setTen(resultSet.getString("HOTEN"));
                user.setEmail(resultSet.getString("EMAIL"));
                user.setSdt(resultSet.getString("SDT"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi lấy danh sách người dùng: " + e.getMessage());
        }

        return users;
    }

    // Phương thức để xóa người dùng
    public void deleteUser(int userId) {
        String sql = "DELETE FROM NGUOIDUNG WHERE ID = ?";
        try (Connection connection = ConnectToSQLServer.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
            System.out.println("Xóa người dùng thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi xóa người dùng: " + e.getMessage());
        }
    }

    // Phương thức để cập nhật người dùng
    public void updateUser(user user) {
        String sql = "UPDATE NGUOIDUNG SET TENDANGNHAP = ?, MATKHAU = ?, HOTEN = ?, EMAIL = ?, SDT = ? WHERE ID = ?";

        try (Connection connection = ConnectToSQLServer.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, user.getTendn());
            preparedStatement.setString(2, user.getMk());
            preparedStatement.setString(3, user.getTen());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getSdt());
            preparedStatement.setString(6, user.getId());

            preparedStatement.executeUpdate();
            System.out.println("Cập nhật người dùng thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi cập nhật người dùng: " + e.getMessage());
        }
    }

    public user getUserById(int id) {
        user result = null;
        String query = "SELECT * FROM NGUOIDUNG WHERE ID = ?";

        try (Connection connection = ConnectToSQLServer.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                result = new user();
                result.setId(rs.getString("id"));
                result.setTendn(rs.getString("tendangnhap"));
                result.setMk(rs.getString("matkhau"));
                result.setTen(rs.getString("hoten"));
                result.setEmail(rs.getString("email"));
                result.setSdt(rs.getString("sdt"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<user> searchUserByCharacter(String character) {
        List<user> resultList = new ArrayList<>();
        String query = "SELECT * FROM NGUOIDUNG WHERE TENDANGNHAP LIKE ? OR MATKHAU LIKE ? OR HOTEN LIKE ? OR EMAIL LIKE ? OR SDT LIKE ?";

        try (Connection connection = ConnectToSQLServer.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Thiết lập các giá trị cho các tham số LIKE
            preparedStatement.setString(1, "%" + character + "%");
            preparedStatement.setString(2, "%" + character + "%");
            preparedStatement.setString(3, "%" + character + "%");
            preparedStatement.setString(4, "%" + character + "%");
            preparedStatement.setString(5, "%" + character + "%");

            ResultSet rs = preparedStatement.executeQuery();

            // Lặp qua kết quả và thêm vào danh sách kết quả
            while (rs.next()) {
                user u = new user();
                u.setId(rs.getString("id"));
                u.setTendn(rs.getString("tendangnhap"));
                u.setMk(rs.getString("matkhau"));
                u.setTen(rs.getString("hoten"));
                u.setEmail(rs.getString("email"));
                u.setSdt(rs.getString("sdt"));
                resultList.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public List<user> searchUser(String searchText) {
        List<user> resultList = new ArrayList<>();

        try {
            // Kiểm tra nếu searchText là số, nếu đúng thì tìm theo ID
            if (searchText.matches("\\d+")) {
                int id = Integer.parseInt(searchText);
                user u = getUserById(id);
                if (u != null) {
                    resultList.add(u);
                }
            }

            // Tìm theo tên đăng nhập hoặc các trường khác có liên quan
            resultList.addAll(searchUserByCharacter(searchText));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultList;
    }

}
