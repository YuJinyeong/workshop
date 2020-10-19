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

# View : 조회 결과로 구성되는 가상의 테이블
create view empinfo
as
select e.employee_id, e.email, d.department_name, l.city, c.country_name, r.region_name
from employees e join departments d using(department_id)
                 join locations l using(location_id)
                 join countries c using(country_id)
                 join regions r using(region_id);

# view의 사용 --> 그냥 테이블처럼
select * from empinfo;
select * from empinfo where employee_id=100;

# sub query
# 직원번호 100번인 사람의 부서명?
# 그런데 부서명을 알려면 먼저 필요한 것은? 부서 번호
select department_id from employees where employee_id=100;

select department_name
from departments
where department_id=(select department_id from employees where employee_id=100);
# 현재 사용되고 있는 곳? where 리턴 - 하나의 행


# 60번 부서의 직원 급여 email와 평균 급여를 출력하자.
select avg(salary) from employees where department_id=60; # 5760원
select email, salary, avg(salary) from employees where department_id=60;

select email, salary, (select avg(salary) from employees where department_id=60) '부서평균'
from employees where department_id=60;


select * from employees where department_id=60;# 5명

create table emp_copy
select * from employees;

select * from emp_copy;
update emp_copy set salary =(select avg(salary) from employees);
# Error Code: 1093. You can't specify target table 'emp_copy' for update in FROM clause
update emp_copy set salary =(select avg(salary) from emp_copy);

#1. emp와 dept Table을 JOIN하여 이름, 급여, 부서명을 검색하세요.
select e.ename, e.SAL, d.DNAME
from emp e join dept d on e.deptno=d.deptno;

#2. 이름이 ‘KING’인 사원의 부서명을 검색하세요.
select e.ename, d.dname
from emp e join dept d on e.deptno=d.deptno
where e.ename='KING';

#3. emp Table에 있는 모든 사원의 이름, 부서번호, 부서명, 급여를 출력 하라.
select e.ENAME, e.DEPTNO, d.DNAME, e.SAL
from emp e left join dept d using(deptno);

# 4. emp Table에 있는 empno와 mgr을 이용하여 서로의 관계를 다음과 같이 출력되도록 쿼리를작성하세요. 
#    ‘SCOTT의 매니저는 JONES이다’
select concat(e.ename, '의 메니저는 ',m.ename,'이다') '정보'
from emp e join emp m on e.mgr=m.empno;

#5. 'SCOTT'의 직무와 같은 사람의 이름, 부서명, 급여, 직무를 검색하세요.
# 5-1스콧의 직무는 뭐지??
select job from emp where ename='scott';
# 5-2 5-1을 이용해서 전체 쿼리 완성
select e.ename, e.sal, e.job, d.dname
from emp e join dept d on e.deptno=d.deptno
where e.job = (select job from emp where ename='scott');

#6. 'SCOTT’가 속해 있는 부서의 모든 사람의 사원번호, 이름, 입사일, 급여를 검색하세요.
# query 1 - scott이 속한 부서는?
select deptno
                from emp
                where ename = "Scott";
# query 2 - 전체 쿼리 작성
select empno, ename, hiredate, sal
from emp
where deptno = (select deptno
                from emp
                where ename = "Scott");

#7. 전체 사원의 평균급여보다 급여가 많은 사원의 사원번호, 이름,부서명, 입사일, 지역, 급여를 검색하세요.
# sub query
select avg(sal) from emp;
# main query
select empno, ename, dname, hiredate, loc, sal
from emp left join dept using (deptno)
where sal > (select avg(sal) from emp);


#8. 30번 부서에서 일하는 사람들과 같은 일을 하는 사원의 사원번호, 이름, 부서명,지역, 급여를 급여가 많은 순으로 검색하세요.
# sub query - 30번 부서에 사람들은 어떤 일을 할까?
select distinct job from emp where deptno=30;
# main query
select e.empno, e.ename, d.dname, d.loc, e.sal
from emp e join dept d using(deptno)
where e.job in (select distinct job from emp where deptno=30);


#9. 10번 부서 중에서 30번 부서에는 없는 업무를 하는 사원의 사원번호, 이름, 부서명, 입사일, 지역을 검색하세요.
select e.empno, e.ename, d.dname, d.loc, e.sal
from emp e join dept d using(deptno)
where e.job not in (select distinct job from emp where deptno=30) and e.deptno=10;

#10. ‘KING’이나 ‘JAMES'의 급여와 같은 사원의 사원번호, 이름,급여를 검색하세요.
select distinct sal from emp where ename in ('king','james');

select empno, ename, sal
from emp
where sal in (select distinct sal from emp where ename in ('king','james'));

#11. 급여가 30번 부서의 최고 급여보다 높은 사원의 사원번호,이름, 급여를 검색하세요.
select empno, ename, sal
from emp
where sal > (select max(sal)
				from emp
				where deptno = 30
);

#12. 이름 검색을 보다 빠르게 수행하기 위해 emp 테이블 ename에 인덱스를 생성하시오.
create index eidx on emp(ename);
# 기본적으로 인덱스가 생성되는 것들: primary key, unique

#13. 이름이 'ALLEN'인 사원의 입사연도가 같은 사원들의 이름과 급여를 출력하세요.
# sub query
select year(hiredate)
                  from emp
                  where ename = "Allen";
# main query
select ename, sal
from emp
where year(hiredate) = (select year(hiredate)
                  from emp
                  where ename = "Allen");