use studentsManagerment;

select * from subjects where credit = (select max(credit) from subjects);
select s.*, max(mark) as 'highest test score' from subjects s join marks m on s.subId = m.subId group by subId
having max(mark) >= all(select max(mark) from marks group by marks.subId);

select s.*, avg(mark) as 'average of subject' from students s join marks m on s.stuId = m.stuId
group by stuId, stuName order by 'average of subject' desc;
