create view last_assignment_vw as select test_id, max(a.id) max_id from assignments a group by test_id;
create view last_manual_result_vw as select test_id, max(r.id) max_id from results r group by test_id;
create view last_auto_result_vw as select method, max(r.id) max_id from results r group by method;
create view last_priority_vw as select test_id, max(p.id) max_id from priorities p group by test_id;
create view last_status_vw as select test_id, max(s.id) max_id from statuses s group by test_id;
create view single_auto_test_vw as select test_id, method from methods m group by test_id;
