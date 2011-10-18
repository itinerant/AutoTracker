-- view for automation that has run but is not mapped to a test case
create view unmapped_automation_vw as
select distinct r.method method, r.project
from results r

left join methods m
on r.method = m.method

where r.method is not null 
and r.method  != ''
and m.method is null;

-- view for test cases that have automation with no results in database
create view unexecuted_automation_vw as
select distinct m.method, m.test_id, r.project
from methods m

left join results r
on r.method = m.method

left join test_cases t
on m.test_id = t.test_id

where m.method is not null 
and m.method  != ''
and r.method is null
and t.deleted = 'false'
