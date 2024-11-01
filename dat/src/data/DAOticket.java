package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOticket {
    // Phương thức để thêm vé
    public void addTicket(Ticket ticket) {
        String sqlInsert = "INSERT INTO Tickets ( MAGHE, MAPHONG, TENPHIM, GIOCHIEU) VALUES ( ?, ?, ?, ?)";

        try (Connection connection = ConnectToSQLServer.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert)) {

            // Thiết lập các tham số cho câu truy vấn
         
            preparedStatement.setString(1, ticket.getSeat());
            preparedStatement.setString(2, ticket.getRoomName());
            preparedStatement.setString(3, ticket.getMovieName());
            preparedStatement.setString(4, ticket.getShowTime());

            preparedStatement.executeUpdate();
            System.out.println("Thêm vé thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm vé: " + e.getMessage());
        }
    }

    // Phương thức để lấy danh sách vé
    public List<Ticket> getTickets() {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM Tickets";

        try (Connection connection = ConnectToSQLServer.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
            Ticket ticket = new Ticket();  // Dùng constructor không tham số
            ticket.setId(resultSet.getInt("ID"));
            ticket.setDate(resultSet.getString("NGAY"));
            ticket.setTime(resultSet.getString("GIO"));
            ticket.setSeat(resultSet.getString("MAGHE"));
            ticket.setRoomName(resultSet.getString("MAPHONG"));
            ticket.setMovieName(resultSet.getString("TENPHIM"));
            ticket.setShowTime(resultSet.getString("GIOCHIEU"));

            tickets.add(ticket);
}
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi lấy danh sách vé: " + e.getMessage());
        }

        return tickets;
    }

    // Phương thức để xóa vé
    public void deleteTicket(int ticketId) {
        String sql = "DELETE FROM Tickets WHERE ID = ?";
        try (Connection connection = ConnectToSQLServer.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, ticketId);
            preparedStatement.executeUpdate();
            System.out.println("Xóa vé thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi xóa vé: " + e.getMessage());
        }
    }

    // Phương thức để cập nhật vé
    public void updateTicket(Ticket ticket) {
        String sql = "UPDATE Tickets SET NGAY = ?, GIO = ?, MAGHE = ?, MAPHONG = ?, TENPHIM = ?, GIOCHIEU = ? WHERE ID = ?";

        try (Connection connection = ConnectToSQLServer.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, ticket.getDate());
            preparedStatement.setString(2, ticket.getTime());
            preparedStatement.setString(3, ticket.getSeat());
            preparedStatement.setString(4, ticket.getRoomName());
            preparedStatement.setString(5, ticket.getMovieName());
            preparedStatement.setString(6, ticket.getShowTime());
            preparedStatement.setInt(7, ticket.getId()); // Thiết lập ID của vé cần sửa

            preparedStatement.executeUpdate();
            System.out.println("Cập nhật vé thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi cập nhật vé: " + e.getMessage());
        }
    }
}
