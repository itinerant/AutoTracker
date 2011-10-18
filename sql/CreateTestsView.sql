create view tests_vw as
select t.test_id, t.component, t.project, t.category, t.name, t.notes, t.deleted, -- test_cases
m.methods, -- methods
a.assignment, a.timestamp assignment_date, --assignment
p.priority, p.timestamp priority_date, -- priority 
r.result manual_result, r.timestamp manual_result_date, r.build manual_build, r.suite manual_suite, -- manual result
ar.result auto_result, ar.timestamp auto_result_date, ar.build auto_build, ar.suite auto_suite, -- auto result
s.status, s.timestamp status_date -- status

from test_cases t
-- methods
left join methods_vw m
on t.test_id = m.test_id
-- assignment
left join last_assignment_vw av
on t.test_id = av.test_id
left join assignments a
on av.max_id = a.id
-- priority
left join last_priority_vw pv
on t.test_id = pv.test_id
left join priorities p
on pv.max_id = p.id
-- manual execution result
left join last_manual_result_vw rv
on t.test_id = rv.test_id
left join results r
on rv.max_id = r.id
-- auto execution result
left join single_auto_test_vw sav
on t.test_id = sav.test_id
left join last_auto_result_vw lav
on sav.method = lav.method
left join results ar
on lav.max_id = ar.id
-- status
left join last_status_vw sv
on t.test_id = sv.test_id
left join statuses s
on sv.max_id = s.id