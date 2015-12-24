drop table account purge;

create table account(
	id varchar2(20) primary key,
	pwd varchar2(20),
	name varchar2(20)
);

insert into account values('hongkd', '1234', '홍길동');
insert into account values('leess', '1234', '이순신');
insert into account values('kangkc', '1234', '강감찬');

select * from account;


