use classicmodels;

call findAllCustomers();

--IN

delimiter //
create procedure getCusById(in cusNum int(11))
begin
select * from customers where customerNumber = cusNum;
end //
delimiter ;

call getCusById(175);

--OUT

delimiter //
create procedure getCustomersCountByCity(in in_city varchar(50), out total int)
begin
select count(customerNumber) into total from customers where city = in_city;
end //
delimiter ;

call getCustomersCountByCity('Lyon', @total);
select @total;

--INOUT

delimiter //
create procedure setCounter(inout counter int, in inc int)
begin
	set counter = counter + inc;
end //
delimiter ;

set @counter = 1;
call SetCounter(@counter, 1);
call SetCounter(@counter, 1);
call SetCounter(@counter, 5);
select @counter;

