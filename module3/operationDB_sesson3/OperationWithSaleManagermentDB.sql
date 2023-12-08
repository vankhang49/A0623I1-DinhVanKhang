use saleManagerment;

insert into customers(cusName, cusAge) values('Minh Quan', 10), ('Ngoc Oanh', 20), ('Hong Na', 50);
insert into oder(oderDate, cusId) values('2006-3-21', 1), ('2006-3-23', 2), ('2006-3-16', 1);

insert into product (proName, proPrice)
values ('May Giat', 3), ('Tu Lanh', 5), ('Dieu Hoa', 7), ('Quat', 1), ('Bep Dien', 2);

insert into oderDetail(oderId, proId, odQTY)
values (1, 1, 3), (1, 3, 7), (1, 4, 2), (2, 1, 1), (3, 1, 8), (2, 5, 4), (2, 3, 3);

select oder.oderId, oder.oderDate, oder.oderTotalPrice from oder;

select customers.cusName, product.proName from customers
join oder on customers.cusId = oder.cusId
join oderDetail on oder.oderId = oderDetail.oderId
join product on oderDetail.proId = product.proId;

select customers.cusName from customers
where customers.cusId not in (select oder.cusId from oder);

select oder.oderId, oder.oderDate as saleDate, sum(oderDetail.odQTY * product.proPrice) as totalPrice
from oder
join oderDetail on oder.oderId = oderDetail.oderId
join product on oderDetail.proId = product.proId
group by oderDetail.oderId, oder.oderDate;

