# PCStore

This is our project for "Wep application development with Java" (Subject code: PRJ301)

## Authors

-   [Nguyen Duc Bao](https://www.github.com/NDBaoFE)
-   [Nguyen Hoai Phong](https://www.github.com/hideonbush106)
-   [Nguyen Minh Khang](https://www.github.com/ngynmikan)
-   [Bui Hoang Hai](https://www.github.com/walle2405)
-   [Nguyen Trung Tin](https://www.github.com/tinnguyentrung962k)

## Run Locally

Clone the project

```bash
  git clone https://github.com/hideonbush106/PCStore.git
```

Open NetBean IDE (or other Java IDE) to run the project (make sure you have JDK and JDBC installed).

## Database

We use Microsoft SQL Server and JDBC for this project. You can execute this SQL script to create database for PCStore

```SQL
if exists (select * from sysdatabases where name='PCStore')
begin
  raiserror('Dropping existing PCStore database ....',0,1)
  DROP database PCStore
end
GO

raiserror('Creating PCStore database....',0,1)
SET NOCOUNT ON
CREATE DATABASE [PCStore]
GO
USE [PCStore]
GO

CREATE TABLE [dbo].[Account](
	[AccountId] [int] IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[fullname] [nvarchar](50) NOT NULL,
	[password] [char](64) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[role] [varchar](255) NOT NULL,
	[Address] [nvarchar](50) NOT NULL,
	[PhoneNo] [varchar](50) NOT NULL,
)
GO

CREATE TABLE [dbo].[Customer](
	[CustomerId] [int] IDENTITY(1,1) PRIMARY KEY references [Account](AccountId) NOT NULL,
	[fullname] [nvarchar](50) NOT NULL,
	[Address] [nvarchar](50) NOT NULL,
	[PhoneNo] [varchar](50) NOT NULL,
)
GO

CREATE TABLE [dbo].[Employee](
	[EmployeeId] [int] PRIMARY KEY references [Account](AccountId) NOT NULL,
	[EmpName] [nvarchar] (50) NOT NULL,
	[salary] [money] NOT NULL,
	[Address] [nvarchar](50) NOT NULL,
	[PhoneNo] [varchar](50) NOT NULL,
)
GO

CREATE TABLE [dbo].[Brand](
	[BrandId] [int] IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[name] [varchar](50) NOT NULL
)

CREATE TABLE [dbo].[Category](
	[CategoryId] [int] IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[name] [varchar](50) NOT NULL
)
CREATE TABLE [dbo].[Product](
	[ProductId] [int] IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[productName] [varchar](200) NOT NULL,
	[price] [float] NOT NULL,
	[CategoryId] [int] references Category(CategoryId) NOT NULL,
	[BrandId] [int] references Brand(BrandId) NOT NULL,
	[description][nvarchar](4000)
)

CREATE TABLE [dbo].[OrderHeader](
	[OrderHeaderId] [int] IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[date] [datetime] NOT NULL,
	[status] [bit] NOT NULL,
	[CustomerId] [int] references Customer(CustomerId) NOT NULL,
	[EmployeeId] [int] references Employee(EmployeeId) NOT NULL
)
GO

CREATE TABLE [dbo].[OrderDetail](
	[OrderDetailId] [int] IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[OrderHeaderId] [int] references OrderHeader(OrderHeaderId) NOT NULL,
	[ProductId] [int] references Product(ProductId) NOT NULL,
	[quantity] [int] NOT NULL,
	[price] [float] NOT NULL,
)
GO
CREATE TABLE [dbo].[Images](
	[ProductId][int] references Product(ProductId),
	[imageId][varchar] PRIMARY KEY NOT NULL,
)
GO
SET IDENTITY_INSERT [dbo].[Brand] ON

INSERT [dbo].[Brand] ([BrandId], [name]) VALUES (1, N'ASUS')
INSERT [dbo].[Brand] ([BrandId], [name]) VALUES (2, N'Logitech')
INSERT [dbo].[Brand] ([BrandId], [name]) VALUES (3, N'GIGABYTE')
INSERT [dbo].[Brand] ([BrandId], [name]) VALUES (4, N'MSI')
INSERT [dbo].[Brand] ([BrandId], [name]) VALUES (5, N'Razer')
INSERT [dbo].[Brand] ([BrandId], [name]) VALUES (6, N'ACER')
INSERT [dbo].[Brand] ([BrandId], [name]) VALUES (7, N'Corsair')
INSERT [dbo].[Brand] ([BrandId], [name]) VALUES (8, N'DELL')
INSERT [dbo].[Brand] ([BrandId], [name]) VALUES (9, N'Intel')
INSERT [dbo].[Brand] ([BrandId], [name]) VALUES (10, N'AMD')
SET IDENTITY_INSERT [dbo].[Brand] OFF

SET IDENTITY_INSERT [dbo].[Category] ON
INSERT [dbo].[Category] ([CategoryId], [name]) VALUES (1, N'Laptop')
INSERT [dbo].[Category] ([CategoryId], [name]) VALUES (2, N'GPU')
INSERT [dbo].[Category] ([CategoryId], [name]) VALUES (3, N'Headphones')
INSERT [dbo].[Category] ([CategoryId], [name]) VALUES (4, N'RAM')
INSERT [dbo].[Category] ([CategoryId], [name]) VALUES (5, N'Mouse')
INSERT [dbo].[Category] ([CategoryId], [name]) VALUES (6, N'Keyboard')
INSERT [dbo].[Category] ([CategoryId], [name]) VALUES (7, N'Monitor')
INSERT [dbo].[Category] ([CategoryId], [name]) VALUES (8, N'Webcam')
INSERT [dbo].[Category] ([CategoryId], [name]) VALUES (9, N'Motherboard')
INSERT [dbo].[Category] ([CategoryId], [name]) VALUES (10, N'CPU')
SET IDENTITY_INSERT [dbo].[Category] OFF

SET IDENTITY_INSERT [dbo].[Product] ON

INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (1, N'ASUS TUF Gaming GeForce RTX™ 4080 16GB GDDR6X', 1000, 2, 1, N'NVIDIA Ada Lovelace architecture elevated by buffed cooling and power delivery, and backed with an arsenal of rugged reinforcements to cover your six. Lock, load, and dominate with the TUF Gaming GeForce RTX™ 4080.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (2, N'GIGABYTE GeForce RTX­­™ 4070 Ti GAMING OC 12G', 800, 2, 3, N'The WINDFORCE cooling system features three 100mm unique blade fans, alternate spinning, 7 composite copper heat pipes, a vapor chamber directly touches the GPU, 3D active fans and Screen cooling, which together provide high efficiency heat dissipation.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (3, N'Logitech G Pro X Headset', 120, 3, 2, 'Designed with and for pros. Next-gen 7.1 surround sound and PRO-G 50 mm drivers ensure premium gaming audio. Mic sounds amazing with external USB sound card featuring Blue VO!CE broadcast filters.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (4, N'Corsair Vengeance Pro 16GB 3200MHz DDR4', 1000, 4, 7, 'VENGEANCE RGB PRO Series DDR4 overclocked memory lights up your PC with mesmerizing dynamic multi-zone RGB lighting, while delivering the best in DDR4 performance.' )
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (5, N'DELL XPS 15', 1200, 1, 8, 'The XPS 15 is the perfect balance of size and performance to fuel even more intensive creative projects. Create more of what you love with a PC powered by 12th Gen Intel® Core™ processors.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (6, N'MSI B660M-A-DDR4', 160, 9, 4, 'The MSI PRO B660M-A WIFI DDR4 shapes up to be a value-for-money Intel B660 motherboard in the micro ATX form factor.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (7, N'Razer Deathadder V3 Pro', 180, 5, 5, '')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (8, N'Acer Nitro 5', 1000, 1, 6, 'Go full throttle with the Acer Nitro 5 AMD Ryzen™ 6000 Series gaming laptop in either 15 or 17 inch models – whether using it as a laptop for casual gaming or ranking up online.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (9, N'ASUS ROG Zephyrus G14', 1500, 1, 1, 'The brand new 2022 Zephyrus G14 is powered by AMD and Windows 11 out of the box. Featuring new Ryzen™ 9 processors and Radeon™ RX 6800S mobile graphics, this all-AMD powerhouse is ready for any gaming or multitasking you can throw at it.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (10, N'DELL Alienware Area 51M', 2000, 1, 8, 'World most powerful and overclockable gaming laptop with NVIDIA or AMD graphics. Featuring up to 10th Gen Intel® Core™ i9K processors.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (11, N'ASUS TUF GAMING VG249Q1A', 170, 7, 1, 'TUF Gaming VG249Q1A is a 23.8-inch Full HD (1920 x 1080) IPS display with an ultrafast 165Hz refresh rate. Designed for gamers and others seeking immersive gameplay, it offers some serious specs.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (12, N'ASUS ROG Strix G15 G513IE HN246W', 970, 1, 1, 'The powerful Asus ROG Strix G15 G513IE-HN246W Gaming Laptop with up to 8-core AMD Ryzen 7 4000 Series CPU and GeForce RTX GPU helps you handle the most demanding applications and games. Pantone-certified true-to-life color display and Dolby Atmos sound system make it easier than ever to handle your things.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (13, N'Laptop Gaming Gigabyte G5 GE 51VN263SH', 915, 1, 3, 'The Gigabyte G5 GE-51VN263SH Gaming Laptop can combine gaming, entertainment, and work. The powerful 12th Gen Intel Core H processor lets you multi-task with ease. Moreover, it has a screen up to 144Hz, 3 display outputs and Wi-Fi 6 technology to assist you in performing different roles.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (14, N'GIGABYTE Radeon RX 6600 EAGLE 8G', 420, 2, 3, 'Powered by AMD RDNA™ 2 Radeon™ RX 6600')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (15, N'Intel® Core® i9-13900K (Raptor Lake)', 670, 10, 9, 'The time Intel officially announced its 13th generation CPUs is getting closer and closer, and leaked information about them has never been a topic for people to stop talking about them. In the latest information, the performance of Core i9 and Core i5 using Raptor Lake architecture has gradually revealed with amazing performance when Core i9-13900k is up to 10% stronger than Ryzen 9 5950X.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (16, N'GIGABYTE G24F', 200, 7, 3, 'The streamline appearance represents the simplicity of the GIGABYTE gaming series design philosophy, sturdy stand and matte finish built for functional and aesthetic features adding more to the characteristics.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (17, N'Logitech G Pro Wireless', 144, 5, 2, 'Less than 63 grams. Advanced low-latency LIGHTSPEED wireless. Sub-micron precision with HERO 25K sensor. Remove all obstacles with our lightest and fastest PRO mouse ever.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (18, N'Logitech G913 TKL Lightspeed Wireless', 185, 6, 2, 'G913 is a mechanical keyboard especially for those looking for difference. Its price may not be comfortable at all, but what it gives in return is well worth it.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (19, N'Asus ROG Claymore II', 240, 6, 1, 'The ROG Claymore II elite gaming keyboard delivers a host of features designed to give you exciting new ways to play. Create your ideal gaming setup by placing the new detachable numpad on whichever side you prefer; then choose between wired or wireless mode and light it all up with Aura Sync. And once you’re in battle, assume full tactical control with ROG RX Optical Mechanical Switches and customizable hotkeys.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (20, N'Intel Core i7 13700K', 485, 10, 9, 'The Intel Core i7 13700K processor is one of the first high-performance CPUs from Intel Gen 13. Packed with an all-new architecture with enhanced features, the Intel Core i7 13700K will deliver tremendous performance to those Objects that require high performance to balance above-average game tasks, graphics tasks. This is definitely the final deciding factor to make a powerful gaming PC that you should not ignore.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (21, N'ASUS TUF Gaming Radeon RX 6700 XT OC Edition 12GB GDDR6', 1011, 2, 1, 'The TUF GAMING Radeon RX 6700 XT video card display not only has the powerful performance of a high-end card, but is also extremely sturdy when made from metal-hardened cables, super-efficient cooling and other components. parts provide high durability.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (22, N'AMD Ryzen™ 5 7600X Gaming Processor', 249, 10, 10, 'This overclockable processor is built for intense gaming, and comes bundled with a low-profile AMD Wraith Stealth cooler.1')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (23, N'Intel Core i5 12600KF', 300, 10, 9, 'The Intel Core i5 12600KF CPU is Intels 12th generation CPU (Alder Lake). As a premature baby, i5 12600KF is favored based on Socket LGA 1700 and applies a new architecture and has superior features compared to previous generation products. Intel Core i5 12600KF will be a great choice if you want to build the best gaming PC today. With its high multiplier, thread count and clock speed, it will be suitable for high-end devices, streaming services, games or professional software use')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (24, N'AMD Ryzen™ 7 7700X Gaming Processor', 349, 10, 10, 'Leading your team to victory shouldn’t cost a fortune. This processor brings exceptional value, overclocking, and includes the AMD Wraith Prism cooler with RBG LED lighting.1')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (25, N'Logitech BRIO 300', 70, 8, 2, 'A 1080p webcam with auto light correction, noise-reducing mic, and USB-C connectivity.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (26, N'ASUS ROG Strix XG279Q 27Inch IPS 2K 170Hz', 700, 7, 1, 'The ASUS ROG STRIX XG279Q monitor provides users with fast and flexible content reproduction with a newly overclocked 170 Hz working speed, 1 ms response time, and support for Adaptive-Sync / NVIDIA G - SYNC technology. ')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (27, N'Logitech BRIO 500', 700, 7, 1, 'The ASUS ROG STRIX XG279Q monitor provides users with fast and flexible content reproduction with a newly overclocked 170 Hz working speed, 1 ms response time, and support for Adaptive-Sync / NVIDIA G - SYNC technology. ')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (28, N'Razer Viper V2 Pro', 150, 5, 5, 'Ultra-lightweight, Ultra-fast Wireless Esports Mouse')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (29, N'ASUS ROG MAXIMUS Z790 HERO DDR5', 800, 9, 1, 'As the latest mainboard for Intel Gen 13, ASUS ROG MAXIMUS Z790 HERO will definitely own the latest LGA 1700 socket today. Turning this will be a marked upgrade in performance and power for your entire PC Gaming rig. With this socket, you can still equip previous generations of CPUs Intel Gen 12, Pentium Gold and Celeron.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (30, N'Razer BlackWidow V4 Pro - Green Switch', 230, 6, 5, 'Razer™ Green Mechanical Switches (Clicky), Immersive Underglow and Per-Key Lighting, Razer™ Command Dial and 8 Dedicated Macro Keys')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (31, N'Razer Blade 15', 2500, 1, 5, '')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (32, N'GIGABYTE G5 KF', 1100, 1, 3, '5.6" FHD 1920x1080 144Hz, NVIDIA GeForce RTX 4060 Laptop GPU, Intel Core i5-12500H, 8GB DDR4 RAM, 512G SSD, Win11 Home')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (33, N'ASUS ROG STRIX Z790-A GAMING WIFI DDR4', 510, 9, 1, 'ASUS ROG STRIX Z790-A GAMING WIFI DDR4 is the new motherboard of the latest Z790 series from ASUS. Owning a unique design and luxurious color tone, along with top performance from Intel Z790 LGA 1700 ATX chipset with 16 + 1 power stage, support for DDR4 memory, four M.2 slots, overclocking and cooling AI II,...In particular, with Aura Sync RGB lighting that will enliven the camera angle when combined with other PC components.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (34, N'GIGABYTE X670E AORUS XTREME', 760, 9, 3, 'Famous for its quality PC components, GIGABYTE is always the name that users mention when building a PC, among them are models belonging to the AORUS series. Beautiful looks and powerful performance are what make GIGABYTE AORUS famous and with the launch of the X670 chipset, we welcome a new model with the name GIGABYTE X670E AORUS XTREME')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (35, N'MSI MEG Z690 ACE DDR5', 845, 9, 4, 'The motherboard is an indispensable part for an optimal operating system with high performance. MSI MEG Z690 ACE DDR5 is a spectacularly designed MSI mainboard that delivers top-notch performance that any gamer or tech enthusiast cannot ignore.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (36, N'Razer Kraken V3 HyperSense', 155, 3, 5, 'Dive into a new dimension of immersion with the Razer Kraken V3 HyperSense—a PC gaming headset powered by haptic technology. From rumbling explosions to whizzing bullets, with the ability to feel what you hear, the time has come to embrace true multi-sensory gaming.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (37, N'MSI VIGOR GK50 ELITE KAILH BLUE', 90, 6, 4, 'Mechanical switches provide accuracy and endurance, the ergonomic high-low keycap design reduces strain and pain of hands and wrists...')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (38, N'Corsair Virtuoso RGB XT', 280, 3, 7, 'The Corsair Virtuoso RGB Wireless SE was one of the best gaming headsets to come out in 2019, with a premium build and a fantastic microphone. Now the Corsair Virtuoso RGB Wireless XT is here, sporting all the things that made the previous model great, along with Bluetooth connectivity and some new software perks thanks to an updated version of Corsair iCue.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (39, N'Dell Premier Collaboration Keyboard - KB900', 120, 6, 8, 'This is the Worlds first Zoom-certified* rechargeable keyboard, built to transform collaboration, enhance productivity and provide all-day comfort.')
INSERT [dbo].[Product] ([ProductId], [productName], [price], [CategoryId], [BrandId], [description]) VALUES (40, N'Alienware Dual-Mode Wireless Gaming Headset - AW720H', 160, 3, 8, 'Gear up for marathon gaming with a comfort-focused, Dolby Atmos®-enabled, easy-to-charge wireless headset.')
SET IDENTITY_INSERT [dbo].[Product] OFF

SET IDENTITY_INSERT [dbo].[Account] ON
INSERT [dbo].[Account] ([AccountId], [fullname], [password], [email], [role], [Address], [phoneNo]) VALUES
(1, N'Admin','6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'trungtin@gmail.com', 'ROLE_ADMIN', N'Vinhome S3.05', '0983532359'),
(2, N'Nguyen Hoai Phong','6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'hoaiphong@gmail.com', 'ROLE_EMPLOYEE', N'Vinhome S4.05', '0987226259'),
(3, N'Nguyen Minh Khang','6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'minhkhang@gmail.com', 'ROLE_EMPLOYEE', N'Vinhome S2.04', '0987632359'),
(4, N'Bui Hoang Hai','6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'hoanghai@gmail.com', 'ROLE_CUSTOMER', N'Vinhome S3.02', '0987123456'),
(5, N'Nguyen Duc Bao','6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'ducbao@gmail.com', 'ROLE_CUSTOMER', N'Vinhome S3.02', '0987123456')
SET IDENTITY_INSERT [dbo].[Account] OFF

SET IDENTITY_INSERT [dbo].[Customer] ON
INSERT [dbo].[Customer] ([CustomerId], [fullname], [Address], [phoneNo]) VALUES (4, 'Bui Hoang Hai', N'Vinhome S2.05', '0987212359')
INSERT [dbo].[Customer] ([CustomerId], [fullname], [Address], [phoneNo]) VALUES (5, 'Nguyen Duc Bao', N'Vinhome S3.02', '0987123456')
SET IDENTITY_INSERT [dbo].[Customer] OFF

INSERT [dbo].[Employee] ([EmployeeId],[EmpName], [salary], [Address],[PhoneNo])
VALUES
(1,'Nguyen Trung Tin',2000, N'Vinhome S3.05', '0983532359'),
(2,'Nguyen Hoai Phong', 1000, N'Vinhome S4.05', '0987226259'),
(3,'Nguyen Minh Khang', 800, N'Vinhome S2.04', '0987632359')

SET NOCOUNT OFF
raiserror('The PCStore database in now ready for use.',0,1)

```
