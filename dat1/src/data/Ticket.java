package data;

public class Ticket {
    private int id;
    private String date; // NGAY
    private String time; // GIO
    private String seat; // MA GHE
    private String roomName; // TEN PHON
    private String movieName; // TEN PHIM
    private String showTime; // GIO CHIEU

    public Ticket() {
        // Mặc định
    }

    // Constructor đầy đủ tham số
    public Ticket(int id, String seat, String roomName, String movieName, String showTime) {
        this.id = id;
        this.seat = seat;
        this.roomName = roomName;
        this.movieName = movieName;
        this.showTime = showTime;
    }

    // Getter và Setter cho từng thuộc tính
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
