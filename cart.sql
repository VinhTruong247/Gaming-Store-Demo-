create table cart(
userid int foreign key references users(user_userid),
product_id int foreign key references products(product_id) NOT NULL,
primary key(userid,product_id)
)