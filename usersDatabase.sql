CREATE TABLE user_roles(
	id int primary key,
	role varchar(20) not null unique
)

insert into user_roles(id,role) values
(1,'ADMIN'),
(2,'CUSTOMER')

CREATE TABLE users (
	role_id int not null default 2,
	user_id int IDENTITY(1,1) NOT NULL,
	user_username VARCHAR(50) NOT NULL,
	user_email VARCHAR(50) NOT NULL,
	user_password CHAR(64) NOT NULL,
	user_fullName NVARCHAR(50) NOT NULL,
	user_address NVARCHAR(50),
	user_active bit default 1 not null,
	UNIQUE(user_userName,user_email),
	PRIMARY KEY (role_id,user_id),
	constraint fk_roles_users foreign key (role_id) references user_roles(id)
)

SET IDENTITY_INSERT dbo.users ON 
INSERT INTO dbo.users(role_id,user_id,user_username,user_email,user_password,user_fullName) VALUES 
(1,1,'B1422','thai@gmail.com', '6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'Administrator'),
(2,1,'test','test@gmail.com',  '6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'Thai'),
(2,2,'Dummy','lmao@gmail.com', '6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'Test')

SET IDENTITY_INSERT dbo.users OFF

select * from users u inner join user_roles r on u.role_id=r.id
