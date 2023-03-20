create table user_payment(
OrderID int foreign key references orderlist(OrderID) not null,
username varchar(50) foreign key references users(user_username) not null,
email varchar(50) not null,
user_address varchar(max)
)
