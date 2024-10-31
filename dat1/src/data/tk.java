package data;

public class tk {
    private String id;
    private String tendn; // tên đăng nhập
    private String mk;    // mật khẩu
    private String role;  // vai trò
    private String email;
    private String sdt;   // số điện thoại

    // Constructor mặc định
    public tk() {}

    // Constructor đầy đủ tham số
    public tk(String id, String tendn, String mk, String role, String email, String sdt) {
        this.id = id;
        this.tendn = tendn;
        this.mk = mk;
        this.role = role;
        this.email = email;
        this.sdt = sdt;
    }

    // Getter và Setter cho tất cả các thuộc tính

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTendn() {
        return tendn;
    }

    public void setTendn(String tendn) {
        this.tendn = tendn;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    // Phương thức để in thông tin người dùng (nếu cần)
    @Override
    public String toString() {
        return "User{" + 
               "id='" + id + '\'' + 
               ", tendn='" + tendn + '\'' + 
               ", mk='" + mk + '\'' + 
               ", role='" + role + '\'' + 
               ", email='" + email + '\'' + 
               ", sdt='" + sdt + '\'' + 
               '}';
    }
}
