CREATE TABLE Tickets(
  ID INT PRIMARY KEY IDENTITY(1,1), 
  NGAY DATE,
  GIO TIME,
  MAGHE NVARCHAR(20),
  MAPHONG NVARCHAR(20),
  TENPHIM NVARCHAR(50),
  GIOCHIEU TIME
);
GO;
CREATE TABLE DangNhap (
    ID INT PRIMARY KEY IDENTITY(1,1), -- ID tự động tăng
    TenDangNhap NVARCHAR(50) NOT NULL, -- Tên đăng nhập
    MatKhau NVARCHAR(50) NOT NULL, -- Mật khẩu
    VaiTro NVARCHAR(20) NOT NULL, -- Vai trò của người dùng (user, admin, etc.)
    Email NVARCHAR(100), -- Địa chỉ email
    SDT NVARCHAR(15) -- Số điện thoại
);
GO

INSERT INTO DangNhap (TenDangNhap, MatKhau, VaiTro, Email, SDT)
VALUES ('admin', 'admin123', 'admin', 'admin@example.com', '0123456789'),
       ('user1', 'password1', 'user', 'user1@example.com', '0987654321'),
       ('user2', 'password2', 'user', 'user2@example.com', '0112233445'),
       ('user3', 'password3', 'user', 'user3@example.com', '0223344556'),
       ('user4', 'password4', 'user', 'user4@example.com', '0334455667');
GO

create default def_day
as getdate();
GO;
exec sp_bindefault 'def_day','Tickets.NGAY'

CREATE DEFAULT def_time AS CAST(GETDATE() AS TIME);
EXEC sp_bindefault 'def_time', 'Tickets.GIO';
GO;
CREATE TABLE NGUOIDUNG(
	ID INT PRIMARY KEY , 
    TenDangNhap NVARCHAR(50) NOT NULL, -- Tên đăng nhập
    MatKhau NVARCHAR(50) NOT NULL, -- Mật khẩu
    HoTen NVARCHAR(50) ,
    Email NVARCHAR(100), -- Địa chỉ email
    SDT NVARCHAR(15), -- Số điện thoại
	FOREIGN KEY(ID) REFERENCES DangNhap(ID)
)
MERGE NguoiDung AS target
USING DangNhap AS source
ON target.ID = source.ID
WHEN MATCHED THEN 
    UPDATE SET 
        target.TenDangNhap = source.TenDangNhap,
        target.MatKhau = source.MatKhau,
        target.Email = source.Email,
        target.SDT = source.SDT
WHEN NOT MATCHED BY TARGET THEN
    INSERT (ID, TenDangNhap, MatKhau, Email, SDT)
    VALUES (source.ID, source.TenDangNhap, source.MatKhau, source.Email, source.SDT)
WHEN NOT MATCHED BY SOURCE THEN
    DELETE;
ALTER TABLE NguoiDung
ADD CONSTRAINT DF_NguoiDung_HoTen DEFAULT 'nguoidung' FOR HoTen;




