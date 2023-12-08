use studentsmanagerment;

select * from students;
select * from students where statuses = true;
select * from subjects where credit < 10;

select s.stuId, s.stuName, c.className
from students s join classes c on s.classId = c.classId;

select s.stuId, s.stuName, c.className
from students s join classes c on s.classId = c.classId
where c.className = 'A1';

select s.stuId, s.stuName, sub.subName, m.mark
from students s join marks m on s.stuId = m.stuId join subjects sub on m.subId = sub.subId;

select s.stuId, s.stuName, sub.subName, m.mark
from students s join marks m on s.stuId = m.stuId join subjects sub on m.subId = sub.subId
where sub.subName = 'CF';