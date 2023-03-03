CREATE TABLE [users](
	[Id] [int] IDENTITY(1,1) PRIMARY KEY,
	[Email] [varchar](50) NOT NULL,
	[Password] [char](64) NOT NULL,
	[FullName] [nvarchar](50) NOT NULL,
	[Role] [varchar](20) NOT NULL
)

SET IDENTITY_INSERT [dbo].[users] ON 
INSERT [dbo].[users] ([id], [email], [password], [fullName], [role]) VALUES 
(1, 'thai@gmail.com', '6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'Administrator', 'ADMIN'),
(2, 'test@gmail.com',  '6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'Thai', 'USER')

SET IDENTITY_INSERT [dbo].[users] OFF
