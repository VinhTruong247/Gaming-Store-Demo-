
create table orderlist (
orderid int identity(1,1) not null primary key,
product_id int  foreign key references products(product_id) ,
user_id int foreign key references users(user_id),
cost int ,
issuedate date
)


create table cart(
user_id int foreign key references users(user_id),
product_id int foreign key references products(product_id) NOT NULL,
quantity int not null,
primary key(user_id,product_id)
)

create table user_payment(
orderid int foreign key references orderlist(orderid) not null,
user_id int foreign key references users(user_id) not null,
payment_type varchar(50) not null
)
