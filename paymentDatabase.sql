CREATE TABLE sale (
	product_id int primary key,
	sold_quantity int,
	price int,
)

CREATE TABLE orderlist (
	order_id int,
	product_id int,
	primary key(order_id,product_id)
)
