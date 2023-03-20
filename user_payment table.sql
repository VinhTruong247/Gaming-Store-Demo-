create table user_payment(
orderid int foreign key references orderlist(orderid) not null,
userid int foreign key references users(user_id) not null,
email varchar(50) not null,
user_address varchar(max)
)
