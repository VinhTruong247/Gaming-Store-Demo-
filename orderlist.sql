create table orderlist 
(
orderid int identity(1,1) not null primary key,
product_id int  foreign key references products(product_id) ,
userid int foreign key references users(user_id),
cost int ,
issuedate date
)