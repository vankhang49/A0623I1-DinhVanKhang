use studentsmanagerment;

insert into classes values (1, 'A1', '2008-12-20', 1);
insert into classes values (2, 'A2', '2008-12-22', 1);
insert into classes values (3, 'B3', current_date, 0);

insert into students (stuName, address, phoneNumber, Statuses, classId)
values ('Hung', 'Ha Noi', '0912113113', 1, 1);
insert into students (stuName, address, Statuses, classId)
values ('Hoa', 'Hai phong', 1, 1);
insert into students (stuName, address, phoneNumber, Statuses, classId)
values ('Manh', 'HCM', '0123123123', 0, 2);

insert into subjects
values (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
       
insert into marks (subId, stuId, mark, examTimes)
values (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);