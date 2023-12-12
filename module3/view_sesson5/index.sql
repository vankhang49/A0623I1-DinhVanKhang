use classicmodels;

select * from customers where customerName = 'Land of Toys Inc.';

alter table customers add index idx_customerName(customerName);
explain select * from customers where customerName = 'Land of Toys Inc.';

alter table customers add index idx_full_name(contactFirstName, contactLastName);
explain select * from customers where contactFirstName = 'Jean' and contactLastName = 'King';

alter table customers drop index idx_full_name;