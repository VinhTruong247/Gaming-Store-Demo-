CREATE TABLE [users](
	[user_id] [int] IDENTITY(1,1) PRIMARY KEY,
	[user_userName] [varchar](50) NOT NULL,
	[user_email] [varchar](50) NOT NULL,
	[user_password] [char](64) NOT NULL,
	[user_fullName] [nvarchar](50) NOT NULL,
	[user_role] [varchar](20) NOT NULL
)

SET IDENTITY_INSERT [dbo].[users] ON 
INSERT [dbo].[users] ([user_id], [user_userName], [user_email], [user_password], [user_fullName], [user_role]) VALUES 
(1,'B1422','thai@gmail.com', '6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'Administrator', 'ADMIN'),
(2,'test','test@gmail.com',  '6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'Thai', 'USER')

SET IDENTITY_INSERT [dbo].[users] OFF
