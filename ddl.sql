truncate table tb_company;
truncate table tb_ins_bo;
truncate table tb_ins_fav_cst;
truncate table tb_ins_gpol;
truncate table tb_ins_pers;
truncate table tb_ins_rchg;
truncate table tb_ins_rcla;
truncate table tb_ins_renewal;
truncate table tb_ins_risk;
truncate table tb_ins_risk_new;
truncate table tb_ins_rpay;
truncate table tb_ins_rpol;
truncate table tb_ins_rsur;
truncate table tb_ins_rtype;
truncate table tb_ins_unit;
truncate table tb_lar_report;
truncate table tb_sus_report;

select concat('select count(1) rec, ''', table_name, ''' as tablename from ', table_name, ' union all ')
from information_schema.tables
where table_Name like 'tb%'

select count(1) rec, 'tb_company' as tablename from tb_company union all 
select count(1) rec, 'tb_ins_bo' as tablename from tb_ins_bo union all 
select count(1) rec, 'tb_ins_fav_cst' as tablename from tb_ins_fav_cst union all 
select count(1) rec, 'tb_ins_gpol' as tablename from tb_ins_gpol union all 
select count(1) rec, 'tb_ins_pers' as tablename from tb_ins_pers union all 
select count(1) rec, 'tb_ins_rchg' as tablename from tb_ins_rchg union all 
select count(1) rec, 'tb_ins_rcla' as tablename from tb_ins_rcla union all 
select count(1) rec, 'tb_ins_renewal' as tablename from tb_ins_renewal union all 
select count(1) rec, 'tb_ins_risk' as tablename from tb_ins_risk union all 
select count(1) rec, 'tb_ins_risk_new' as tablename from tb_ins_risk_new union all 
select count(1) rec, 'tb_ins_rpay' as tablename from tb_ins_rpay union all 
select count(1) rec, 'tb_ins_rpol' as tablename from tb_ins_rpol union all 
select count(1) rec, 'tb_ins_rsur' as tablename from tb_ins_rsur union all 
select count(1) rec, 'tb_ins_rtype' as tablename from tb_ins_rtype union all 
select count(1) rec, 'tb_ins_unit' as tablename from tb_ins_unit union all 
select count(1) rec, 'tb_lar_report' as tablename from tb_lar_report union all 
select count(1) rec, 'tb_sus_report' as tablename from tb_sus_report