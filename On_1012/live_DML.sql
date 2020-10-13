create database dbtest
default character set utf8mb3 collate utf8mb3_general_ci;

create database dbtest
default character set utf8mb4 collate utf8mb4_general_ci;

alter database dbtest
default character set utf8mb4 collate utf8mb4_general_ci;

drop database dbtest;

use ssafydb;

create table ssafy_member (
	idx			int 		not null auto_increment,
	userid		varchar(16)	not null,
	username	varchar(20),
	userpwd		varchar(16),
	emailid		varchar(20),
	emaildomain	varchar(50),
	joindate	timestamp	not null default current_timestamp,
	primary key (idx)
) ENGINE=InnoDB default CHARSET=utf8;

insert into ssafy_member (userid, username, userpwd, emailid, emaildomain, joindate)
values ('kimssafy', '김싸피', '1234', 'kimssafy', 'ssafy.com', now());

insert into ssafy_member (username, userid , userpwd, joindate)
values ('김싸피', 'kimssafy', '1234', now());

insert into ssafy_member (username, userid , userpwd, joindate)
values 
	('김싸피', 'kimssafy', '1234', now()), 
	('박싸피', 'parkssafy', '9876', now());

update ssafy_member
set userpwd = 9876, emaildomain = 'ssafy.co.kr'
where userid = 'kimssafy';

delete from ssafy_member
where userid = 'kimssafy';