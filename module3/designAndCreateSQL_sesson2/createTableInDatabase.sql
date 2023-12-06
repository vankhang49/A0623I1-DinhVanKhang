create database TestScoreManagerment;
use TestScoreManagerment;

create table students(
stuId varchar(20) primary key,
stuName varchar(45),
dob DateTime,
className varchar(20),
gender varchar(10)
);
create table subjects (
subId varchar(20) primary key,
subName varchar(50)
);
create table teachers(
teacherId varchar(20) primary key,
teacherName varchar(45),
phoneNumber varchar(10)
);
create table scoresBoard(
stuId varchar(20),
subId varchar(20),
score int,
testDay datetime,
primary key (stuId, subId),
foreign key (stuId) references students(stuId),
foreign key (subId) references subjects(subId)
);
alter table subjects add teacherId varchar(20);
alter table subjects add constraint fk_teacherId foreign key(teacherId) references teachers(teacherId);
