USE [master]
GO
/****** Object:  Database [Library]    Script Date: 7/14/2020 4:37:35 PM ******/
CREATE DATABASE [Library]
 CONTAINMENT = NONE
GO
ALTER DATABASE [Library] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Library].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Library] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Library] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Library] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Library] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Library] SET ARITHABORT OFF 
GO
ALTER DATABASE [Library] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Library] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Library] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Library] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Library] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Library] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Library] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Library] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Library] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Library] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Library] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Library] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Library] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Library] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Library] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Library] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Library] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Library] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Library] SET  MULTI_USER 
GO
ALTER DATABASE [Library] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Library] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Library] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Library] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Library] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Library]
GO
/****** Object:  Table [dbo].[tblBooks]    Script Date: 7/14/2020 4:37:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblBooks](
	[BookID] [nvarchar](50) NOT NULL,
	[Bookname] [nvarchar](50) NOT NULL,
	[Quantity] [int] NOT NULL,
	[Price] [float] NOT NULL,
	[Author] [nvarchar](50) NOT NULL,
	[Status] [bit] NOT NULL,
	[url] [nvarchar](50) NULL,
 CONSTRAINT [PK_tblBooks] PRIMARY KEY CLUSTERED 
(
	[BookID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblOrderDetais]    Script Date: 7/14/2020 4:37:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblOrderDetais](
	[OrderID] [nvarchar](50) NOT NULL,
	[BookID] [nvarchar](50) NOT NULL,
	[Quantity] [int] NOT NULL,
	[Price] [float] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblOrders]    Script Date: 7/14/2020 4:37:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblOrders](
	[OrderID] [nvarchar](50) NOT NULL,
	[UserID] [nvarchar](50) NOT NULL,
	[GetDate] [date] NOT NULL,
	[ReturnDate] [date] NOT NULL,
	[Total] [float] NOT NULL,
 CONSTRAINT [PK_tblOrders] PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblRole]    Script Date: 7/14/2020 4:37:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRole](
	[RoleID] [nvarchar](50) NOT NULL,
	[RoleName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tblRole] PRIMARY KEY CLUSTERED 
(
	[RoleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblUsers]    Script Date: 7/14/2020 4:37:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUsers](
	[UserID] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[Fullname] [nvarchar](50) NOT NULL,
	[Address] [nvarchar](50) NULL,
	[Phone] [nvarchar](50) NULL,
	[RoleID] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tblUsers] PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[tblBooks] ([BookID], [Bookname], [Quantity], [Price], [Author], [Status], [url]) VALUES (N'B1', N'Nếu chỉ còn một ngày để sống', 30, 67500, N'Nicola Yoon', 1, N'C:\Users\ADMIN\Desktop\Assignment\anh1.jpg')
INSERT [dbo].[tblBooks] ([BookID], [Bookname], [Quantity], [Price], [Author], [Status], [url]) VALUES (N'B2', N'Tên của trò chơi là bắt cóc', 30, 61500, N'Higashino Keigo', 1, N'C:\Users\ADMIN\Desktop\Assignment\anh2.jpg')
INSERT [dbo].[tblBooks] ([BookID], [Bookname], [Quantity], [Price], [Author], [Status], [url]) VALUES (N'B3', N'Trò chuyện với ác quỷ', 30, 107000, N'Mitsuro Sato', 1, N'C:\Users\ADMIN\Desktop\Assignment\anh3.jpg')
INSERT [dbo].[tblRole] ([RoleID], [RoleName]) VALUES (N'AD', N'Admin')
INSERT [dbo].[tblRole] ([RoleID], [RoleName]) VALUES (N'US', N'User')
INSERT [dbo].[tblUsers] ([UserID], [Password], [Fullname], [Address], [Phone], [RoleID]) VALUES (N'admin', N'1', N'admin', N'admin', N'0123456789', N'AD')
INSERT [dbo].[tblUsers] ([UserID], [Password], [Fullname], [Address], [Phone], [RoleID]) VALUES (N'user', N'1', N'user', N'user', N'0123456789', N'US')
INSERT [dbo].[tblUsers] ([UserID], [Password], [Fullname], [Address], [Phone], [RoleID]) VALUES (N'user2', N'123', N'user2', N'user2', N'1234567890', N'US')
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_tblRole]    Script Date: 7/14/2020 4:37:35 PM ******/
CREATE NONCLUSTERED INDEX [IX_tblRole] ON [dbo].[tblRole]
(
	[RoleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[tblOrderDetais]  WITH CHECK ADD  CONSTRAINT [FK_tblOrderDetais_tblBooks] FOREIGN KEY([BookID])
REFERENCES [dbo].[tblBooks] ([BookID])
GO
ALTER TABLE [dbo].[tblOrderDetais] CHECK CONSTRAINT [FK_tblOrderDetais_tblBooks]
GO
ALTER TABLE [dbo].[tblOrderDetais]  WITH CHECK ADD  CONSTRAINT [FK_tblOrderDetais_tblOrders] FOREIGN KEY([OrderID])
REFERENCES [dbo].[tblOrders] ([OrderID])
GO
ALTER TABLE [dbo].[tblOrderDetais] CHECK CONSTRAINT [FK_tblOrderDetais_tblOrders]
GO
ALTER TABLE [dbo].[tblOrders]  WITH CHECK ADD  CONSTRAINT [FK_tblOrders_tblUsers] FOREIGN KEY([UserID])
REFERENCES [dbo].[tblUsers] ([UserID])
GO
ALTER TABLE [dbo].[tblOrders] CHECK CONSTRAINT [FK_tblOrders_tblUsers]
GO
ALTER TABLE [dbo].[tblUsers]  WITH CHECK ADD  CONSTRAINT [FK_tblUsers_tblRole] FOREIGN KEY([RoleID])
REFERENCES [dbo].[tblRole] ([RoleID])
GO
ALTER TABLE [dbo].[tblUsers] CHECK CONSTRAINT [FK_tblUsers_tblRole]
GO
USE [master]
GO
ALTER DATABASE [Library] SET  READ_WRITE 
GO
