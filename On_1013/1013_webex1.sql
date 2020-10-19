# 100번 직원은 어떤 부서?
# employees --> department_id, departments --> department_name --> 어떤게 연결??
select employees.employee_id, employees.email, employees.department_id, departments.department_name
from employees , departments
where employees.department_id= departments.department_id and employees.employee_id  =100;

select e.employee_id, e.email, e.department_id, d.department_name
from employees e, departments d
where e.department_id= d.department_id and e.employee_id  =100; # oracle, mysql.

# ansi sql  --> 어떤 데이터베이스에서든 다 되는형태
select e.employee_id, e.email, e.department_id, d.department_name
from employees e join departments d on e.department_id= d.department_id
where  e.employee_id  =100; # ansi style

select e.employee_id, e.email, e.department_id, d.department_name
from employees e join departments d using (department_id)
where  e.employee_id  =100; # ansi style - using: 어차피 join에 사용할 컬럼이 같다면..

# 1996년도에 입사한 직원들의 업무와 email는?
select e.email, e.hire_date, j.job_title
from employees e join jobs j using(job_id)
where year(e.hire_date)=1996
order by 3;

# 부서별로 메니저에게 이메일을 보내려고 한다. 부서명과 메니저의 이메일은?
select d.department_name, e.email
from departments d join employees e on d.manager_id=e.employee_id; # inner join: 모든 테이블에 데이터가 있을 경우만 출력

# outer join: 데이터가 없더라도 출력해주세요. 부서장이 없다면 admin이라고 써주세요.
select d.department_name, ifnull(e.email, 'admin') '메니저 연락처'
from departments d left join employees e on d.manager_id=e.employee_id; 

# self join: 멘토에게 뭔가 상담받고 싶다. 내 이메일과 멘토의 이메일을 찾아보자. 
-- 나(e)가 manager라고 부르는 사람 m 은 manager 테이블에서는 그냥 직원이다.
select e.email 'from', ifnull(m.email, '114') 'to'
from employees e left join employees m on(e.manager_id = m.employee_id);

# SKING을 맨토로 삼고 있는 사람들, 그 사람들은 어떤 업무를 하는 사람들일까?
# step 1: sking을 멘토로 삼고 있는 직원들?
select e.email, m.email, j.job_title
from employees e join employees m  on e.manager_id = m.employee_id
				 join jobs j on e.job_id=j.job_id
where m.email = 'SKING';

# 직원번호 100번인 직원의 이메일, 부서명, 도시명, 국가명, 지역명을 출력해보자.
select e.employee_id, e.email, d.department_name, l.city, c.country_name, r.region_name
from employees e join departments d using(department_id)
                 join locations l using(location_id)
                 join countries c using(country_id)
                 join regions r using(region_id)
where e.employee_id=100;



select count(*) from departments;
