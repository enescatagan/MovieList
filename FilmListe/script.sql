USE [master]
GO
/****** Object:  Database [mbp106_filmListele]    Script Date: 6/4/2022 19:12:49 ******/
CREATE DATABASE [mbp106_filmListele]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'mbp106_filmListele', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\mbp106_filmListele.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'mbp106_filmListele_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\mbp106_filmListele_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [mbp106_filmListele] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [mbp106_filmListele].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [mbp106_filmListele] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [mbp106_filmListele] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [mbp106_filmListele] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [mbp106_filmListele] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [mbp106_filmListele] SET ARITHABORT OFF 
GO
ALTER DATABASE [mbp106_filmListele] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [mbp106_filmListele] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [mbp106_filmListele] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [mbp106_filmListele] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [mbp106_filmListele] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [mbp106_filmListele] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [mbp106_filmListele] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [mbp106_filmListele] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [mbp106_filmListele] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [mbp106_filmListele] SET  DISABLE_BROKER 
GO
ALTER DATABASE [mbp106_filmListele] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [mbp106_filmListele] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [mbp106_filmListele] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [mbp106_filmListele] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [mbp106_filmListele] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [mbp106_filmListele] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [mbp106_filmListele] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [mbp106_filmListele] SET RECOVERY FULL 
GO
ALTER DATABASE [mbp106_filmListele] SET  MULTI_USER 
GO
ALTER DATABASE [mbp106_filmListele] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [mbp106_filmListele] SET DB_CHAINING OFF 
GO
ALTER DATABASE [mbp106_filmListele] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [mbp106_filmListele] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [mbp106_filmListele] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [mbp106_filmListele] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'mbp106_filmListele', N'ON'
GO
ALTER DATABASE [mbp106_filmListele] SET QUERY_STORE = OFF
GO
USE [mbp106_filmListele]
GO
/****** Object:  Table [dbo].[izledigim_filmler]    Script Date: 6/4/2022 19:12:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[izledigim_filmler](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[filmAdi] [nvarchar](200) NOT NULL,
	[yonetmen] [nvarchar](200) NULL,
	[tur] [varchar](50) NOT NULL,
	[yil] [int] NOT NULL,
	[uzunluk] [int] NULL,
	[puan] [float] NULL,
 CONSTRAINT [PK_izledigim_filmler] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[izleyecegim_filmler]    Script Date: 6/4/2022 19:12:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[izleyecegim_filmler](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[filmAdi] [nvarchar](200) NOT NULL,
	[yonetmen] [nvarchar](200) NULL,
	[tur] [varchar](50) NOT NULL,
	[yil] [int] NOT NULL,
	[uzunluk] [int] NULL,
	[puan] [float] NULL,
 CONSTRAINT [PK_izleyecegim_filmler] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[izledigim_filmler] ON 

INSERT [dbo].[izledigim_filmler] ([id], [filmAdi], [yonetmen], [tur], [yil], [uzunluk], [puan]) VALUES (1, N'Interstellar', N'Christopher Nolan', N'Bilim-Kurgu', 2014, 169, 8.6)
INSERT [dbo].[izledigim_filmler] ([id], [filmAdi], [yonetmen], [tur], [yil], [uzunluk], [puan]) VALUES (2, N'Léon', N'Luc Besson', N'Suç', 1994, 110, 8.5)
INSERT [dbo].[izledigim_filmler] ([id], [filmAdi], [yonetmen], [tur], [yil], [uzunluk], [puan]) VALUES (3, N'V for Vendetta', N'James McTeigue', N'Aksiyon', 2005, 132, 8.2)
INSERT [dbo].[izledigim_filmler] ([id], [filmAdi], [yonetmen], [tur], [yil], [uzunluk], [puan]) VALUES (4, N'Amélie', N'Jean-Pierre Jeunet', N'Komedi', 2001, 122, 8.3)
INSERT [dbo].[izledigim_filmler] ([id], [filmAdi], [yonetmen], [tur], [yil], [uzunluk], [puan]) VALUES (5, N'Lost in Translation', N'Sofia Coppola', N'Dram', 2003, 102, 7.7)
INSERT [dbo].[izledigim_filmler] ([id], [filmAdi], [yonetmen], [tur], [yil], [uzunluk], [puan]) VALUES (6, N'Scott Pilgrim vs. the World', N'Edgar Wright', N'Komedi', 2010, 112, 7.5)
INSERT [dbo].[izledigim_filmler] ([id], [filmAdi], [yonetmen], [tur], [yil], [uzunluk], [puan]) VALUES (7, N'The Cabin in the Woods', N'Drew Goddard', N'Korku', 2011, 95, 7)
INSERT [dbo].[izledigim_filmler] ([id], [filmAdi], [yonetmen], [tur], [yil], [uzunluk], [puan]) VALUES (8, N'Bruce Almighty', N'Tom Shadyac', N'Komedi', 2003, 101, 6.7)
SET IDENTITY_INSERT [dbo].[izledigim_filmler] OFF
GO
SET IDENTITY_INSERT [dbo].[izleyecegim_filmler] ON 

INSERT [dbo].[izleyecegim_filmler] ([id], [filmAdi], [yonetmen], [tur], [yil], [uzunluk], [puan]) VALUES (1, N'Doctor Strange in the Multiverse of Madness', N'Scott Derrickson', N'Macera', 2022, 126, 7.3)
INSERT [dbo].[izleyecegim_filmler] ([id], [filmAdi], [yonetmen], [tur], [yil], [uzunluk], [puan]) VALUES (2, N'Uncharted', N'Seth Gordon', N'Macera', 2022, 116, 6.4)
INSERT [dbo].[izleyecegim_filmler] ([id], [filmAdi], [yonetmen], [tur], [yil], [uzunluk], [puan]) VALUES (3, N'Blade Runner 2049', N'Denis Villeneuve', N'Aksiyon', 2017, 164, 8)
INSERT [dbo].[izleyecegim_filmler] ([id], [filmAdi], [yonetmen], [tur], [yil], [uzunluk], [puan]) VALUES (4, N'Moon', N'Duncan Jones', N'Bilim-Kurgu', 2009, 97, 7.8)
INSERT [dbo].[izleyecegim_filmler] ([id], [filmAdi], [yonetmen], [tur], [yil], [uzunluk], [puan]) VALUES (5, N'Boyhood', N'Richard Linklater', N'Dram', 2014, 165, 7.9)
INSERT [dbo].[izleyecegim_filmler] ([id], [filmAdi], [yonetmen], [tur], [yil], [uzunluk], [puan]) VALUES (6, N'Soul', N'Pete Docter', N'Animasyon', 2020, 100, 8)
INSERT [dbo].[izleyecegim_filmler] ([id], [filmAdi], [yonetmen], [tur], [yil], [uzunluk], [puan]) VALUES (7, N'The Man from U.N.C.L.E.', N'Guy Ritchie', N'Komedi', 2015, 116, 7.2)
INSERT [dbo].[izleyecegim_filmler] ([id], [filmAdi], [yonetmen], [tur], [yil], [uzunluk], [puan]) VALUES (8, N'Manchester by the Sea', N'Kenneth Lonergan', N'Dram', 2016, 137, 7.8)
INSERT [dbo].[izleyecegim_filmler] ([id], [filmAdi], [yonetmen], [tur], [yil], [uzunluk], [puan]) VALUES (9, N'La La Land', N'Damien Chazelle', N'Romantik', 2016, 128, 8)
SET IDENTITY_INSERT [dbo].[izleyecegim_filmler] OFF
GO
USE [master]
GO
ALTER DATABASE [mbp106_filmListele] SET  READ_WRITE 
GO
