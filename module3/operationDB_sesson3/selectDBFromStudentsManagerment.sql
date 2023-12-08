use studentsManagerment;

select * from students where stuName like 'h%';
select * from classes where month(startDate) = 12;
select * from subjects where credit between 3 and 5;

set sql_safe_updates = 0;
update students set classId = 2 where stuName = 'Hung';
set sql_safe_updates = 1;

select students.stuName, subjects.subName, marks.mark
from students join marks on students.stuId = marks.stuId join subjects on marks.subId = subjects.subId
order by mark desc, stuName asc;