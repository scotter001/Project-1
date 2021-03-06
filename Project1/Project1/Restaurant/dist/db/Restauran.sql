USE [master]
GO
/****** Object:  Database [Restauran]    Script Date: 11/14/2018 10:05:40 AM ******/
CREATE DATABASE [Restauran]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Restauran', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.OPPA\MSSQL\DATA\Restauran.mdf' , SIZE = 16384KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Restauran_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.OPPA\MSSQL\DATA\Restauran_log.ldf' , SIZE = 1280KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Restauran] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Restauran].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Restauran] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Restauran] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Restauran] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Restauran] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Restauran] SET ARITHABORT OFF 
GO
ALTER DATABASE [Restauran] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Restauran] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [Restauran] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Restauran] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Restauran] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Restauran] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Restauran] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Restauran] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Restauran] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Restauran] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Restauran] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Restauran] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Restauran] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Restauran] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Restauran] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Restauran] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Restauran] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Restauran] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Restauran] SET RECOVERY FULL 
GO
ALTER DATABASE [Restauran] SET  MULTI_USER 
GO
ALTER DATABASE [Restauran] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Restauran] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Restauran] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Restauran] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'Restauran', N'ON'
GO
USE [Restauran]
GO
/****** Object:  Table [dbo].[BanNgoi]    Script Date: 11/14/2018 10:05:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BanNgoi](
	[MaBan] [int] IDENTITY(1,1) NOT NULL,
	[SoBan] [nvarchar](30) NOT NULL,
	[TrangThai] [int] NOT NULL,
	[GhiChu] [nvarchar](255) NULL,
 CONSTRAINT [PK_BanNgoi] PRIMARY KEY CLUSTERED 
(
	[MaBan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 11/14/2018 10:05:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaCTHD] [int] IDENTITY(1,1) NOT NULL,
	[MaHD] [int] NOT NULL,
	[MaSP] [int] NOT NULL,
	[SoLuong] [int] NOT NULL,
	[ThanhTien] [money] NOT NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[MaCTHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 11/14/2018 10:05:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHD] [int] IDENTITY(1,1) NOT NULL,
	[SoHoaDon] [varchar](20) NOT NULL,
	[NgayTaoHD] [datetime] NULL,
	[MaNV] [int] NOT NULL,
	[MaBan] [int] NOT NULL,
	[TinhTrang] [nvarchar](50) NOT NULL,
	[TongTien] [money] NOT NULL,
	[MaKH] [int] NOT NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/14/2018 10:05:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [int] IDENTITY(1,1) NOT NULL,
	[TenKH] [nvarchar](50) NOT NULL,
	[DiaChi] [nvarchar](50) NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[DienThoai] [varchar](10) NOT NULL,
	[MaLoaiKH] [int] NOT NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LoaiKhachHang]    Script Date: 11/14/2018 10:05:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiKhachHang](
	[MaLoaiKH] [int] IDENTITY(1,1) NOT NULL,
	[TenLoaiKH] [nvarchar](50) NOT NULL,
	[UuDai] [nvarchar](50) NULL,
 CONSTRAINT [PK_LoaiKhachHang] PRIMARY KEY CLUSTERED 
(
	[MaLoaiKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LoaiNCC]    Script Date: 11/14/2018 10:05:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiNCC](
	[MaLoaiNCC] [int] IDENTITY(1,1) NOT NULL,
	[TenLoaiNCC] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_LoaiNCC] PRIMARY KEY CLUSTERED 
(
	[MaLoaiNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 11/14/2018 10:05:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSanPham](
	[MaLoaiSP] [int] IDENTITY(1,1) NOT NULL,
	[TenLoaiSP] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_LoaiSP] PRIMARY KEY CLUSTERED 
(
	[MaLoaiSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 11/14/2018 10:05:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[MaNCC] [int] IDENTITY(1,1) NOT NULL,
	[TenNCC] [nvarchar](50) NOT NULL,
	[DiaChi] [nvarchar](50) NOT NULL,
	[DienThoai] [varchar](10) NOT NULL,
	[GhiChu] [nvarchar](255) NULL,
	[MaLoaiNCC] [int] NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/14/2018 10:05:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [int] IDENTITY(1,1) NOT NULL,
	[TenNV] [nvarchar](50) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[NgayVaoLam] [date] NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[Luong] [money] NOT NULL,
	[SoCMND] [varchar](9) NOT NULL,
	[DiaChi] [nvarchar](50) NOT NULL,
	[DienThoai] [varchar](10) NOT NULL,
	[MaQuyen] [int] NOT NULL,
	[TenDangNhap] [varchar](50) NOT NULL,
	[MatKhau] [varchar](50) NOT NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PhieuNhap]    Script Date: 11/14/2018 10:05:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhap](
	[MaPhieuNhapKho] [int] IDENTITY(1,1) NOT NULL,
	[MaNCC] [int] NOT NULL,
	[MaNV] [int] NOT NULL,
	[SoLuong] [int] NOT NULL,
	[GiaTien] [money] NOT NULL,
	[NgayNhap] [date] NOT NULL,
	[MaSP] [int] NOT NULL,
	[DonViTinh] [nvarchar](20) NOT NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_PhieuNhapKho] PRIMARY KEY CLUSTERED 
(
	[MaPhieuNhapKho] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Quyen]    Script Date: 11/14/2018 10:05:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Quyen](
	[MaQuyen] [int] IDENTITY(1,1) NOT NULL,
	[TenQuyen] [nvarchar](50) NOT NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_Quyen] PRIMARY KEY CLUSTERED 
(
	[MaQuyen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 11/14/2018 10:05:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSP] [int] IDENTITY(1,1) NOT NULL,
	[TenSP] [nvarchar](50) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[DonViTinh] [nvarchar](20) NOT NULL,
	[Gia] [money] NOT NULL,
	[MaLoaiSP] [int] NOT NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ThongKe]    Script Date: 11/14/2018 10:05:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThongKe](
	[MaThongKe] [int] IDENTITY(1,1) NOT NULL,
	[TongTien] [money] NOT NULL,
	[NgayThongKe] [date] NOT NULL,
	[GhiChu] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_ThongKe] PRIMARY KEY CLUSTERED 
(
	[MaThongKe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[BanNgoi] ON 

INSERT [dbo].[BanNgoi] ([MaBan], [SoBan], [TrangThai], [GhiChu]) VALUES (1026, N'Bàn 1', 1, N'null')
INSERT [dbo].[BanNgoi] ([MaBan], [SoBan], [TrangThai], [GhiChu]) VALUES (1027, N'Bàn 2', 1, N'null')
INSERT [dbo].[BanNgoi] ([MaBan], [SoBan], [TrangThai], [GhiChu]) VALUES (1029, N'Bàn 3', 1, N'null')
INSERT [dbo].[BanNgoi] ([MaBan], [SoBan], [TrangThai], [GhiChu]) VALUES (1030, N'Bàn 4', 1, N'null')
INSERT [dbo].[BanNgoi] ([MaBan], [SoBan], [TrangThai], [GhiChu]) VALUES (1031, N'Bàn 5', 1, N'null')
INSERT [dbo].[BanNgoi] ([MaBan], [SoBan], [TrangThai], [GhiChu]) VALUES (1032, N'Bàn 6', 1, N'null')
INSERT [dbo].[BanNgoi] ([MaBan], [SoBan], [TrangThai], [GhiChu]) VALUES (1033, N'Bàn 7', 1, N'null')
INSERT [dbo].[BanNgoi] ([MaBan], [SoBan], [TrangThai], [GhiChu]) VALUES (1034, N'Bàn 8', 1, N'null')
INSERT [dbo].[BanNgoi] ([MaBan], [SoBan], [TrangThai], [GhiChu]) VALUES (1035, N'Bàn 9', 1, N'null')
INSERT [dbo].[BanNgoi] ([MaBan], [SoBan], [TrangThai], [GhiChu]) VALUES (1036, N'Bàn 10', 1, N'null')
INSERT [dbo].[BanNgoi] ([MaBan], [SoBan], [TrangThai], [GhiChu]) VALUES (1037, N'Bàn 11', 1, N'')
INSERT [dbo].[BanNgoi] ([MaBan], [SoBan], [TrangThai], [GhiChu]) VALUES (1038, N'Bàn 12', 1, N'Null')
INSERT [dbo].[BanNgoi] ([MaBan], [SoBan], [TrangThai], [GhiChu]) VALUES (1039, N'Bàn 13', 1, N'Null')
INSERT [dbo].[BanNgoi] ([MaBan], [SoBan], [TrangThai], [GhiChu]) VALUES (1040, N'Bàn 14', 1, N'Null')
INSERT [dbo].[BanNgoi] ([MaBan], [SoBan], [TrangThai], [GhiChu]) VALUES (1041, N'Bàn 15', 1, N'Null')
INSERT [dbo].[BanNgoi] ([MaBan], [SoBan], [TrangThai], [GhiChu]) VALUES (1042, N'Bàn 16', 1, N'Null')
INSERT [dbo].[BanNgoi] ([MaBan], [SoBan], [TrangThai], [GhiChu]) VALUES (1043, N'Bàn 17', 1, N'Null')
INSERT [dbo].[BanNgoi] ([MaBan], [SoBan], [TrangThai], [GhiChu]) VALUES (1044, N'Bàn 18', 1, N'Null')
INSERT [dbo].[BanNgoi] ([MaBan], [SoBan], [TrangThai], [GhiChu]) VALUES (1045, N'Bàn 19', 1, N'Null')
INSERT [dbo].[BanNgoi] ([MaBan], [SoBan], [TrangThai], [GhiChu]) VALUES (1046, N'Bàn 20', 1, N'Null')
INSERT [dbo].[BanNgoi] ([MaBan], [SoBan], [TrangThai], [GhiChu]) VALUES (1047, N'Bàn 21', 1, N'')
SET IDENTITY_INSERT [dbo].[BanNgoi] OFF
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] ON 

INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [ThanhTien], [GhiChu]) VALUES (1474, 1266, 27, 3, 30000.0000, N'')
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [ThanhTien], [GhiChu]) VALUES (1475, 1266, 35, 1, 120000.0000, N'')
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [ThanhTien], [GhiChu]) VALUES (1476, 1266, 28, 1, 100000.0000, N'')
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [ThanhTien], [GhiChu]) VALUES (1477, 1267, 21, 2, 40000.0000, N'')
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [ThanhTien], [GhiChu]) VALUES (1479, 1268, 26, 1, 15000.0000, N'')
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [ThanhTien], [GhiChu]) VALUES (1480, 1268, 28, 1, 100000.0000, N'')
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] OFF
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([MaHD], [SoHoaDon], [NgayTaoHD], [MaNV], [MaBan], [TinhTrang], [TongTien], [MaKH]) VALUES (1266, N'HD1811312080647', CAST(0x0000A99100000000 AS DateTime), 1, 1036, N'Đã Thanh Toán', 250000.0000, 24)
INSERT [dbo].[HoaDon] ([MaHD], [SoHoaDon], [NgayTaoHD], [MaNV], [MaBan], [TinhTrang], [TongTien], [MaKH]) VALUES (1267, N'HD1811312090139', CAST(0x0000A99200000000 AS DateTime), 1, 1029, N'Đã Thanh Toán', 40000.0000, 24)
INSERT [dbo].[HoaDon] ([MaHD], [SoHoaDon], [NgayTaoHD], [MaNV], [MaBan], [TinhTrang], [TongTien], [MaKH]) VALUES (1268, N'HD1811314093519', CAST(0x0000A99400000000 AS DateTime), 1, 1032, N'Đã Thanh Toán', 115000.0000, 24)
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [GioiTinh], [DienThoai], [MaLoaiKH], [GhiChu]) VALUES (24, N'Khách Mới', N'78 abc', 1, N'0369854625', 3, N'Null')
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
SET IDENTITY_INSERT [dbo].[LoaiKhachHang] ON 

INSERT [dbo].[LoaiKhachHang] ([MaLoaiKH], [TenLoaiKH], [UuDai]) VALUES (1, N'Khách VIP', N'Giảm giá')
INSERT [dbo].[LoaiKhachHang] ([MaLoaiKH], [TenLoaiKH], [UuDai]) VALUES (2, N'Khách Quen', N'Null')
INSERT [dbo].[LoaiKhachHang] ([MaLoaiKH], [TenLoaiKH], [UuDai]) VALUES (3, N'Khách Thường', N'Null')
SET IDENTITY_INSERT [dbo].[LoaiKhachHang] OFF
SET IDENTITY_INSERT [dbo].[LoaiNCC] ON 

INSERT [dbo].[LoaiNCC] ([MaLoaiNCC], [TenLoaiNCC]) VALUES (1, N'Rau')
INSERT [dbo].[LoaiNCC] ([MaLoaiNCC], [TenLoaiNCC]) VALUES (2, N'Thịt')
INSERT [dbo].[LoaiNCC] ([MaLoaiNCC], [TenLoaiNCC]) VALUES (3, N'Bia')
SET IDENTITY_INSERT [dbo].[LoaiNCC] OFF
SET IDENTITY_INSERT [dbo].[LoaiSanPham] ON 

INSERT [dbo].[LoaiSanPham] ([MaLoaiSP], [TenLoaiSP]) VALUES (5, N'Thuốc Lá')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSP], [TenLoaiSP]) VALUES (6, N'Đồ Uống')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSP], [TenLoaiSP]) VALUES (7, N'Món Lẩu')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSP], [TenLoaiSP]) VALUES (8, N'Món Gỏi')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSP], [TenLoaiSP]) VALUES (9, N'Món Nướng')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSP], [TenLoaiSP]) VALUES (10, N'Món Đặc Biệt')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSP], [TenLoaiSP]) VALUES (11, N'Món Xào')
INSERT [dbo].[LoaiSanPham] ([MaLoaiSP], [TenLoaiSP]) VALUES (18, N'Món Chiên')
SET IDENTITY_INSERT [dbo].[LoaiSanPham] OFF
SET IDENTITY_INSERT [dbo].[NhaCungCap] ON 

INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [DienThoai], [GhiChu], [MaLoaiNCC]) VALUES (19, N'Chợ Tân An', N'123 Tất Thành', N'0123456789', N'', 1)
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [DienThoai], [GhiChu], [MaLoaiNCC]) VALUES (20, N'Chợ EaTam', N'250 Lê Duẩn', N'0123456789', N'', 2)
SET IDENTITY_INSERT [dbo].[NhaCungCap] OFF
SET IDENTITY_INSERT [dbo].[NhanVien] ON 

INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [NgayVaoLam], [GioiTinh], [Luong], [SoCMND], [DiaChi], [DienThoai], [MaQuyen], [TenDangNhap], [MatKhau]) VALUES (1, N'Nông Văn Long', CAST(0xED1F0B00 AS Date), CAST(0xB43E0B00 AS Date), 1, 3500000.0000, N'247123123', N'111 Hùng Vương', N'0771231234', 1, N'long', N'123123')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [NgayVaoLam], [GioiTinh], [Luong], [SoCMND], [DiaChi], [DienThoai], [MaQuyen], [TenDangNhap], [MatKhau]) VALUES (2, N'Trương Thanh Ngân', CAST(0xC7220B00 AS Date), CAST(0x393E0B00 AS Date), 0, 5000000.0000, N'247127894', N'78 AmaKhe', N'0771231235', 2, N'ngan', N'123123')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [NgayVaoLam], [GioiTinh], [Luong], [SoCMND], [DiaChi], [DienThoai], [MaQuyen], [TenDangNhap], [MatKhau]) VALUES (3, N'Manager', CAST(0xF0150B00 AS Date), CAST(0xE03D0B00 AS Date), 1, 50000000.0000, N'247123123', N'FPT Software', N'0771231234', 3, N'admin', N'admin')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [NgayVaoLam], [GioiTinh], [Luong], [SoCMND], [DiaChi], [DienThoai], [MaQuyen], [TenDangNhap], [MatKhau]) VALUES (23, N'Tấn Phát', CAST(0x9A220B00 AS Date), CAST(0xB63D0B00 AS Date), 1, 20000.0000, N'24178956', N'30 Ngô Quyền', N'0336845212', 1, N'phat123', N'123123')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [NgaySinh], [NgayVaoLam], [GioiTinh], [Luong], [SoCMND], [DiaChi], [DienThoai], [MaQuyen], [TenDangNhap], [MatKhau]) VALUES (24, N'Khá Bảnh', CAST(0x9A220B00 AS Date), CAST(0xB63D0B00 AS Date), 1, 120000.0000, N'123456789', N'01 Lê Duẩn', N'033456789', 1, N'banhk', N'123123')
SET IDENTITY_INSERT [dbo].[NhanVien] OFF
SET IDENTITY_INSERT [dbo].[PhieuNhap] ON 

INSERT [dbo].[PhieuNhap] ([MaPhieuNhapKho], [MaNCC], [MaNV], [SoLuong], [GiaTien], [NgayNhap], [MaSP], [DonViTinh], [GhiChu]) VALUES (8, 19, 1, 0, 66666666.0000, CAST(0xE73E0B00 AS Date), 2, N'gói', N'Nnull')
SET IDENTITY_INSERT [dbo].[PhieuNhap] OFF
SET IDENTITY_INSERT [dbo].[Quyen] ON 

INSERT [dbo].[Quyen] ([MaQuyen], [TenQuyen], [GhiChu]) VALUES (1, N'Nhân Viên', N'null')
INSERT [dbo].[Quyen] ([MaQuyen], [TenQuyen], [GhiChu]) VALUES (2, N'Thu Ngân', N'null')
INSERT [dbo].[Quyen] ([MaQuyen], [TenQuyen], [GhiChu]) VALUES (3, N'Quản Lý', N'null')
SET IDENTITY_INSERT [dbo].[Quyen] OFF
SET IDENTITY_INSERT [dbo].[SanPham] ON 

INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (2, N'Thuốc Ngựa Nâu', 10000, N'Gói', 7000.0000, 5, N'null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (11, N'Gỏi Ngó Sen Hải Sản', 971, N'Đĩa', 120000.0000, 8, N'null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (16, N'Rau Muống Xào Tỏi', 942, N'Đĩa', 80000.0000, 11, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (18, N'Ba Chỉ Heo Nướng', 986, N'Đĩa', 80000.0000, 9, N'null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (19, N'Ba Chỉ Bò Nướng', 989, N'Đĩa', 80000.0000, 9, N'null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (21, N'Thuốc Mèo', 896, N'Gói', 20000.0000, 5, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (23, N'Lẩu Cá Trê', 10000, N'Nồi', 200000.0000, 7, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (24, N'Lẩu Lươn', 967, N'Nồi', 120000.0000, 7, N'null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (25, N'Bia SG Xanh', 9916, N'Lon', 10000.0000, 6, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (26, N'Bia Tiger Bạc', 9933, N'Lon', 15000.0000, 6, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (27, N'Sting', 9893, N'Lon', 10000.0000, 6, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (28, N'CoCa CoLa', 9954, N'Lon', 100000.0000, 6, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (29, N'Lẩu Gà Lá Giang', 9999, N'Nồi', 200000.0000, 7, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (35, N'Cơm Chiên Dưa Bò ', 10000, N'Đĩa', 120000.0000, 18, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (36, N'Lẩu Vịt', 990, N'Nồi', 200000.0000, 7, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (37, N'Gà Ta Tiềm Thuốc Bắc', 10000, N'Nồi', 300000.0000, 10, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (38, N'Lẩu Hải Sản', 978, N'Nồi', 200000.0000, 7, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (39, N'Lẩu Cá Bớp ', 919, N'Nồi', 200000.0000, 7, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (40, N'Thuốc JET', 9994, N'Gói', 25000.0000, 5, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (41, N'Thuốc Ngựa Trắng', 10000, N'Gói', 20000.0000, 5, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (42, N'Bia SG Trắng', 10000, N'Chai', 12000.0000, 6, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (43, N'Nước Suối', 10000, N'Chai', 8000.0000, 6, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (44, N'Bò Húc', 10000, N'Lon', 12000.0000, 6, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (45, N'Pepsi', 10000, N'Lon', 10000.0000, 6, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (46, N'Bia Heiniken', 9999, N'Lon', 18000.0000, 6, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (47, N'Bia Tiger Nâu', 10000, N'Lon', 12000.0000, 6, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (48, N'Fanta Cam', 10000, N'Lon', 10000.0000, 6, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (49, N'Fanta Nho', 10000, N'Lon', 10000.0000, 6, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (50, N'Lẩu Bò', 10000, N'Nồi', 200000.0000, 7, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (51, N'Lẩu Thái', 10000, N'Nồi', 200000.0000, 7, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (52, N'Lẩu Thập Cẩm', 10000, N'Nồi', 200000.0000, 7, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (53, N'Lẩu Cá Kèo', 10000, N'Nồi', 200000.0000, 7, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (54, N'Lẩu Cá Thác Lác', 10000, N'Nồi', 200000.0000, 7, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (55, N'Lẩu Cá Diêu Hồng', 10000, N'Nồi', 200000.0000, 7, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (56, N'Lẩu Ếch ', 10000, N'Nồi', 200000.0000, 7, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (57, N'Lẩu Bạch Tuộc Satế', 10000, N'Nồi', 200000.0000, 7, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (58, N'Lẩu Gà Ta Ớt Hiểm', 10000, N'Nồi', 200000.0000, 7, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (59, N'Lẩu Cá Hồi Nấu Me', 10000, N'Nồi', 200000.0000, 7, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (60, N'Lẩu Nấm Hải Sản', 10000, N'Nồi', 200000.0000, 7, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (61, N'Lẩu Tôm Chua Cay', 10000, N'Nồi', 200000.0000, 7, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (62, N'Lẩu Ếch Lá Giang', 10000, N'Nồi', 200000.0000, 7, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (63, N'Lẩu Cua', 10000, N'Nồi', 200000.0000, 7, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (64, N'Gỏi Xoài Cá Khô', 10000, N'Đĩa', 80000.0000, 8, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (65, N'Gỏi Cà Đắng Cá Khô', 10000, N'Đĩa', 80000.0000, 8, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (66, N'Gỏi Củ Hủ Dừa Hải Sản', 10000, N'Đĩa', 120000.0000, 8, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (67, N'Gỏi Ngó Sen Tôm Thịt', 10000, N'Đĩa', 80000.0000, 8, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (68, N'Gỏi Bắp Bò', 10000, N'Đĩa', 120000.0000, 8, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (69, N'Gỏi Bò Cay', 10000, N'Đĩa', 80000.0000, 8, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (70, N'Gỏi Mực Thái', 10000, N'Đĩa', 80000.0000, 8, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (71, N'Gói Bao Tử Rau Răm', 10000, N'Đĩa', 80000.0000, 8, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (72, N'Gỏi Đu Đủ Tép Bò', 10000, N'Đĩa', 80000.0000, 8, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (73, N'Gỏi Hải Sản', 1000, N'Đĩa', 80000.0000, 8, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (76, N'Bò Nướng Cục', 1000, N'Đĩa', 80000.0000, 9, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (79, N'Gà Nướng', 1000, N'Con', 100000.0000, 9, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (80, N'Vịt Nướng', 1000, N'Con', 100000.0000, 9, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (81, N'Dê Nướng', 10000, N'Đĩa', 100000.0000, 9, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (82, N'Cá Lóc Nướng', 10000, N'Con', 70000.0000, 9, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (83, N'Cá Trê Nướng ', 1000, N'Con', 70000.0000, 9, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (84, N'Ếch Nướng', 10000, N'Đĩa', 100000.0000, 9, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (85, N'Lươn Nướng', 10000, N'Đĩa', 80000.0000, 9, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (86, N'Mực Nướng Muối Ớt', 10000, N'Đĩa', 80000.0000, 9, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (87, N'Tôm Nướng', 10000, N'Đĩa', 100000.0000, 9, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (88, N'Heo Rừng Hấp Xả Ớt', 10000, N'Nồi', 300000.0000, 10, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (89, N'Cá Lóc Hấp Bầu', 10000, N'Nồi', 300000.0000, 10, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (90, N'Đọt Bí Xào Tỏi', 10000, N'Đĩa', 60000.0000, 11, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (91, N'Mì Xào Bò', 10000, N'Đĩa', 60000.0000, 11, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (92, N'Mì Xào Hải Sản', 1000, N'Đĩa', 60000.0000, 11, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (93, N'Trứng Non Xào Nấm', 1000, N'Đĩa', 60000.0000, 11, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (94, N'Cơm chiên muối ớt', 100, N'Đĩa', 60000.0000, 18, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (95, N'Cơm Chiên Dương Châu', 10000, N'Đĩa', 50000.0000, 18, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (96, N'Gà Chiên Mắm', 10000, N'Đĩa', 90000.0000, 18, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (97, N'Vịt Chiên Mắm', 10000, N'Đĩa', 90000.0000, 18, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (98, N'Tôm Chiên', 10000, N'Đĩa', 90000.0000, 18, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (99, N'Mực Chiên Mắm', 10000, N'Đĩa', 90000.0000, 18, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (100, N'Cá Lóc Chiên', 10000, N'Đĩa', 90000.0000, 18, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (101, N'Lươn Chiên', 10000, N'Đĩa', 90000.0000, 18, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (102, N'Cá Chạch Chiên', 10000, N'Đĩa', 90000.0000, 18, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (103, N'Sườn Heo Chiên', 10000, N'Đĩa', 90000.0000, 18, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (104, N'Cá Kèo Chiên ', 10000, N'Đĩa', 90000.0000, 18, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (105, N'Ếch Chiên Mắm', 10000, N'Đĩa', 90000.0000, 18, N'Null')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonViTinh], [Gia], [MaLoaiSP], [GhiChu]) VALUES (106, N'Thuốc Seven', 4, N'Gói', 10000.0000, 5, N'Null')
SET IDENTITY_INSERT [dbo].[SanPham] OFF
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([MaHD])
REFERENCES [dbo].[HoaDon] ([MaHD])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_SanPham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_SanPham]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_BanNgoi] FOREIGN KEY([MaBan])
REFERENCES [dbo].[BanNgoi] ([MaBan])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_BanNgoi]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD  CONSTRAINT [FK_KhachHang_LoaiKhachHang] FOREIGN KEY([MaLoaiKH])
REFERENCES [dbo].[LoaiKhachHang] ([MaLoaiKH])
GO
ALTER TABLE [dbo].[KhachHang] CHECK CONSTRAINT [FK_KhachHang_LoaiKhachHang]
GO
ALTER TABLE [dbo].[NhaCungCap]  WITH CHECK ADD  CONSTRAINT [FK_NhaCungCap_LoaiNCC] FOREIGN KEY([MaLoaiNCC])
REFERENCES [dbo].[LoaiNCC] ([MaLoaiNCC])
GO
ALTER TABLE [dbo].[NhaCungCap] CHECK CONSTRAINT [FK_NhaCungCap_LoaiNCC]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_Quyen] FOREIGN KEY([MaQuyen])
REFERENCES [dbo].[Quyen] ([MaQuyen])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_Quyen]
GO
ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhap_NhaCungCap] FOREIGN KEY([MaNCC])
REFERENCES [dbo].[NhaCungCap] ([MaNCC])
GO
ALTER TABLE [dbo].[PhieuNhap] CHECK CONSTRAINT [FK_PhieuNhap_NhaCungCap]
GO
ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhap_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[PhieuNhap] CHECK CONSTRAINT [FK_PhieuNhap_NhanVien]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_LoaiSanPham] FOREIGN KEY([MaLoaiSP])
REFERENCES [dbo].[LoaiSanPham] ([MaLoaiSP])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_LoaiSanPham]
GO
USE [master]
GO
ALTER DATABASE [Restauran] SET  READ_WRITE 
GO
