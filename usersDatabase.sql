CREATE TABLE users (
	user_role VARCHAR(50) NOT NULL,
	user_id int IDENTITY(1,1) NOT NULL,
	user_username VARCHAR(50) NOT NULL,
	user_email VARCHAR(50) NOT NULL,
	user_password CHAR(64) NOT NULL,
	user_fullName NVARCHAR(50) NOT NULL,
	UNIQUE(user_userName),
	PRIMARY KEY (user_role,user_id)
)

SET IDENTITY_INSERT dbo.users ON 
INSERT INTO dbo.users(user_role,user_id,user_username,user_email,user_password,user_fullName) VALUES 
('ADMIN',1,'B1422','thai@gmail.com', '6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'Administrator'),
('CUSTOMER',1,'test','test@gmail.com',  '6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'Thai'),
('Customer',2,'Dummy','lmao@gmail.com', '6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'Test')

SET IDENTITY_INSERT dbo.users OFF
