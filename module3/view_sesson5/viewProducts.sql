create database demo;

use demo;

create table products(
id int auto_increment,
productCode varchar(30),
productName varchar(30),
productPrice double,
productAmount int,
productDescription text,
productStatus varchar(20),
primary key(id)
);


insert into products(productCode, productName, productPrice, productAmount, productDescription, productStatus)
values ('L101', 'Laptop ABC', 999.99, 500, 'High-performance laptop', 'Available'),
('L102', 'Macbook Pro M1', 1999.99, 273, 'High-performance laptop', 'Available'),
('P101', 'Smartphone XYZ', 499.99, 0, 'Feature-rich smartphone', 'Sold Out'),
('P102', 'Iphone 15', 999.99, 999, 'Feature-rich smartphone', 'Available'),
('I101', 'Tablet 123', 299.99, 32, 'Compact tablet', 'Available');

select* from products;
explain select * from products;

create unique index index_produceCode on products(productCode);
create index index_info_proNamePrice on products(productName, productPrice);
select * from products;
explain select * from products where productCode = 'P102';
explain select * from products where productName = 'Iphone 15' and productPrice between 500 and 2000;

create view products_view as select productCode, productName, productPrice, productStatus from products;
select * from products_view;

delimiter //
create procedure productInfo()
begin
	select * from products;
end //
delimiter ;

call productInfo();

delimiter //
create procedure insertProduct(
in i_productCode varchar(30),
in i_productName varchar(30),
in i_productPrice double,
in i_productAmount int,
in i_productDescription text,
in i_productStatus varchar(20))
begin
	insert into products(productCode, productName, productPrice, productAmount, productDescription, productStatus)
	values(i_productCode, i_productName, i_productPrice, i_productAmount, i_productDescription, i_productStatus);
 end //
 delimiter ;
 
 call insertProduct('I102', 'Samsung Galaxy Tab S8 Ultra', 1199.99, 102, 'Compact tablet', 'Available');
 select * from products;
 
 
delimiter //
create procedure updateProduct(
in in_id int,
in i_productCode varchar(30),
in i_productName varchar(30),
in i_productPrice double,
in i_productAmount int,
in i_productDescription text,
in i_productStatus varchar(20))
begin
	update products set
    productCode = i_productCode,
    productName = i_productName,
    productPrice = i_productPrice,
    productAmount = i_productAmount,
	productDescription = i_productDescription,
	productStatus = i_productStatus
    where id = in_id;
 end //
 delimiter ;
 
call updateProduct(5, 'I01', 'Tablet 123', 299.99, 0, 'Compact tablet', 'Sold Out');
select * from products;


delimiter //
create procedure deleteProduct(
in in_id int)
begin
	delete from products where id = in_id;
 end //
 delimiter ;

call insertProduct('W101', 'Apple Watch Ultra', 299.99, 300, 'Smart watch', 'Available');
select * from products;

call deleteProduct(5);
select * from products;
update products set id = 5 where id = 6;
update products set id = 6 where id = 7;
select * from products;

 
 

