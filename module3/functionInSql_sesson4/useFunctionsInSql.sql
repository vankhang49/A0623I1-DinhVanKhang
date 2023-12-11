use studentsManagerment;

select address, count(stuId) as 'number of students' from students group by address;
select s.stuId, s.stuName, avg(mark) from students s join marks m on s.stuId = m.stuId
group by s.stuId, s.stuName;

select s.stuId, s.stuName, avg(mark) from students s join marks m on s.stuId = m.stuId
group by s.stuId, s.stuName having avg(mark) > 15;

select s.stuId, s.stuName, avg(mark) from students s join marks m on s.stuId = m.stuId
group by s.stuId, s.stuName having avg(mark) >= all(select avg(mark) from marks group by marks.stuId);