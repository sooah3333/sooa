drop table user1 purge;

create table user1(
	user_id varchar2(20) primary key,
	user_pwd varchar2(20),
	user_name varchar2(20)
);

select * from USER1;

insert into user1 values('hong', '1111', 'hongkildong');
insert into user1 values('lee', '2222', 'leesoonshin');






