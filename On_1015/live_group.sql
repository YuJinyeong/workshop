-- 그룹함수
-- 급여의 총합, 커미션의 총합
select sum(salary) 급여총합, sum(salary * commission_pct) 커미션총합
from employees;

-- 평균급여 (소수 2자리까지 표현)
select round(avg(salary), 2) 평균급여
from employees;

-- 사원수
select count(employee_id) 사원수
from employees;

-- 사원이 근무하는 부서의 개수, 커미션을 받는 사원수
select count(department_id) 부서수, count(commission_pct) 커미션받는사원수
from employees;

select count(distinct department_id) 부서수
from employees;

select count(employee_id) 
from employees
where commission_pct is not null;

-- 80번 부서에서 근무하는 사원중 최고급여, 최저급여
select max(salary) 최고급여, min(salary) 최저급여
from employees
where department_id = 80;

-- 부서 번호, 부서별 급여의 총합, 평균급여
select department_id, sum(salary), avg(salary)
from employees;

select department_id, sum(salary), avg(salary)
from employees
group by department_id
order by department_id;


-- 각 부서별 최고 급여와 최저 급여
select department_id, max(salary), min(salary)
from employees
group by department_id;

-- 각 부서별 최고 급여를 받는 사원의 부서번호, 사번, 이름, 급여. 
-- join 이용
select a.department_id, e.employee_id, e.first_name, a.smax
from employees e join (
					   select department_id, max(salary) as smax
					   from employees
					   group by department_id
                       ) a
on e.department_id = a.department_id
and e.salary = a.smax;

-- 다중열 subquery 이용
select department_id, employee_id, first_name, salary
from employees
where (department_id, salary) in ( select department_id, max(salary)
								   from employees
                                   group by department_id)
order by department_id;


-- having
-- 부서별 평균 급여가 7000이상인 부서 번호, 평균 급여
select department_id, avg(salary)
from employees
where avg(salary) > 7000
group by department_id;


select department_id, avg(salary)
from employees
group by department_id
having avg(salary) > 7000;

-- 40, 50, 60번 부서에서 근무하는 사원들중 job_id별 급여 합이 50000보다 큰 job_id와 평균 급여
-- 평균급여를 내림차순으로 정렬
select job_id, avg(salary)
from employees
where department_id in (40, 50, 80)
group by job_id
having sum(salary) > 50000
order by avg(salary) desc;

-- 부서별 평균 급여가 20번 부서의 평균 급여보다 큰 부서의 부서번호, 평균 급여
select department_id, avg(salary)
from employees
group by department_id
having avg(salary) > (
					  select avg(salary) 
					  from employees 
					  where department_id = 20
					  )
order by avg(salary) desc;


-- SET
select *
from employees
union
select *
from departments;


select employee_id, first_name, salary
from employees
where department_id in (10, 90, 110)


select employee_id, first_name, salary
from employees
where salary > (
				select sum(salary)
				from employees
                where department_id = 70
                );

                
select employee_id, first_name, salary
from employees
where department_id in (10, 90, 110)
union
select employee_id, first_name, salary
from employees
where salary > (
				select sum(salary)
				from employees
                where department_id = 70
                );

select a.*
from (
		select employee_id, first_name, salary
		from employees
		where department_id in (10, 90, 110)
		union all
		select employee_id, first_name, salary
		from employees
		where salary > (
						select sum(salary)
						from employees
						where department_id = 70
						)
	) a
order by a.employee_id;

