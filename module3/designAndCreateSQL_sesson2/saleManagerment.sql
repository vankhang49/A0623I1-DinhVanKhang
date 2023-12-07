create database saleManagerment;
use saleManagerment;

create table customers(
cusId int not null auto_increment unique,
cusName varchar(30),
cusAge datetime,
primary key(cusId)
);
create table oder(
oderId int not null auto_increment unique,
oderDate datetime,
proName varchar(50),
amount int check(amount > 1),
oderTotalPrice double,
cusId int,
primary key(oderId),
foreign key(cusId) references customers(cusId)
);
create table product(
proId int not null auto_increment unique,
proName varchar(50),
proPrice double,
primary key(proId)
);
create table oderDetail(
oderId int,
proId int,
odQTY varchar(50),
primary key(oderId, proId),
foreign key(oderId) references oder(oderId),
foreign key(proId) references product(proId)
);