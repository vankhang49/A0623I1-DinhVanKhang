create database materialTradingModel;
use materialTradingModel;

create table supplier(
code_supplier varchar(30) not null unique,
name_supplier varchar(50),
address varchar(100),
primary key(code_supplier)
);
create table sup_phoneNumber(
code_supplier varchar(30),
phoneNumber varchar(15) unique,
primary key(code_supplier, phoneNumber),
foreign key(code_supplier) references supplier(code_supplier)
);
create table oder(
code_oder varchar(20) not null unique,
oderDate date not null,
code_supplier varchar(30),
primary key(code_oder),
foreign key(code_supplier) references supplier(code_supplier)
);
create table deliveryNotes(
code_dn varchar(20) not null unique,
dnDate date not null,
primary key(code_dn)
);
create table importCoupon(
code_ic varchar(20) not null unique,
icDate date not null,
primary key(code_ic)
);
create table provider(
code_provider varchar(20) not null unique,
providerName varchar(50),
primary key(code_provider)
);
create table oder_provider(
code_provider varchar(20),
code_oder varchar(20),
primary key(code_provider, code_oder),
foreign key(code_oder) references oder(code_oder),
foreign key(code_provider) references provider(code_provider)
);
create table deli_supp(
code_dn varchar(20),
code_provider varchar(20),
deliveryOrder varchar(30),
amount int check(amount > 1),
primary key(code_dn, code_provider),
foreign key(code_dn) references deliveryNotes(code_dn),
foreign key(code_provider) references provider(code_provider)
);
create table ic_supp(
code_ic varchar(20),
code_provider varchar(20),
importOrder varchar(30),
amount int check(amount > 1),
primary key(code_ic, code_provider),
foreign key(code_ic) references importCoupon(code_ic),
foreign key(code_provider) references provider(code_provider)
);