create database studentsManagerment;
use studentsManagerment;
create table classes(
classId int not null auto_increment,
className varchar(60) not null,
startDate datetime not null,
statuses bit,
primary key(classId)
);
create table students(
stuId int not null auto_increment,
stuName varchar(30) not null,
address varchar(50),
phoneNumber varchar(20),
statuses bit,
classId int not null,
primary key(stuId),
foreign key(classId) references classes(classId)
);
create table subjects(
subId int not null auto_increment,
subName varchar(30) not null,
credit tinyint not null default 1 check(credit >=1),
statuses bit default 1,
primary key(subId)
);
create table marks(
markId int not null auto_increment,
subId int not null,
stuId int not null,
mark float default 0 check(mark between 0 and 100),
examTimes tinyint default 1,
primary key(markId),
foreign key(subId) references subjects(subId),
foreign key(stuId) references students(stuId)
);
