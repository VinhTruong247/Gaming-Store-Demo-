create table cart(
user_id int foreign key references users(user_id),
product_id int foreign key references products(product_id) NOT NULL,
quantity int not null,
primary key(user_id,product_id)
)
