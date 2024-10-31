package data;

public class user {
    private String id;
    private String tendn; 
    private String mk;    
    private String ten;  
    private String email;
    private String sdt;  

    // Constructor mặc định
    public user(){};

    
    public user(String id, String tendn, String mk, String ten, String email, String sdt) {
        this.id = id;
        this.tendn = tendn;
        this.mk = mk;
        this.ten = ten;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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
}
