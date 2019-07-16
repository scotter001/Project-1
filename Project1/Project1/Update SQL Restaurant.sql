
-- BÀN NGỒI
-- Lấy Tất Cả Thông Tin Từ Bảng Sản Phẩm
select * from BanNgoi 
-- Lấy Tất Cả Thông Tin Từ Bảng Sản Phẩm Với IDSanPham = 3
select * from BanNgoi where MaBan = 1
-- Lấy Tất Cả Thông Tin Sản Phẩm Có TenSP chứa Chữa abc
select * from BanNgoi where SoBan like N'%e%'
-- Sữa Tất cả thông tin của sản phẩm có IDSP = 3
update BanNgoi set SoBan = N'Bàn Số 1' ,TrangThai = N'Trống' , GhiChu = N'null' where MaBan = 1
-- xóa sản phẩm có IDSP = 3
delete from BanNgoi where MaBan = 1
-- thêm 1 sản phẩm  mới
insert into BanNgoi values(N'Ban 2',N'Trống',N'null')

--THỰC ĐƠN

-- Lấy Tất Cả Thông Tin Từ Bảng Sản Phẩm
select * from ThucDon 
-- Lấy Tất Cả Thông Tin Từ Bảng Sản Phẩm Với IDSanPham = 3
select * from ThucDon where MaMon = 1
-- Lấy Tất Cả Thông Tin Sản Phẩm Có TenSP chứa Chữa abc
select * from ThucDon where MaMon like N'%e%'
-- Sữa Tất cả thông tin của sản phẩm có IDSP = 3
update ThucDon set TenMon = N'Cơm Chiên Trứng' ,GiaTien = 20000 , GhiChu = N'null' where MaMon = 2
-- xóa sản phẩm có IDSP = 3
delete from ThucDon where MaMon = 1
-- thêm 1 sản phẩm  mới
insert into ThucDon values(N'Gạo Luộc',10000,N'null')

--SẢN PHẨM 

-- Lấy Tất Cả Thông Tin Từ Bảng Sản Phẩm
select * from SanPham
-- Lấy Tất Cả Thông Tin Từ Bảng Sản Phẩm Với IDSanPham = 3
select * from SanPham where MaSP = 1
-- Lấy Tất Cả Thông Tin Sản Phẩm Có TenSP chứa Chữa abc
select * from SanPham where TenSP like N'%e%'
-- Sữa Tất cả thông tin của sản phẩm có IDSP = 3
update SanPham set TenSP = N'Thuốc Ngựa Nâu' ,MaLoaiSP = 2 ,SoLuong = 2, DonViTinh = N'Gói' ,Gia = 8000 , GhiChu = N'null' where MaSP = 1
-- xóa sản phẩm có IDSP = 3
delete from SanPham where MaSP = 1
-- thêm 1 sản phẩm  mới
insert into SanPham values(N'Thuốc',N'Trốn',N'null'

select * from LoaiSanPham
select * from SanPham

insert into LoaiSanPham values(N'Thuốc Lá',N'null' ,1)






 