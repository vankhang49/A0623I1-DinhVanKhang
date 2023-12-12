use classicmodels;

delimiter //
create procedure findAllCustomers()
begin
	select * from customers;
end //
delimiter ;

call findAllCustomers();

delimiter //
drop procedure if exists `findAllCustomers` //
create procedure findAllCustomers()
begin
select * from customers where customerNumber = 175;
end //
delimiter ;

call findAllCustomers();