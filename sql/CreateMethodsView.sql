create view methods_vw as
select m.test_id, group_concat(m.method separator '|') methods 
from methods m 
group by test_id