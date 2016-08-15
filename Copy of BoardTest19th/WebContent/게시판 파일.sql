
select * from t86_board;
select * from tab;

select * from t86_member;

drop table t86_member;

create table t86_member (
	member_no number primary key,
	member_id varchar2(100) not null,
	member_pass varchar2(100) not null
);

drop sequence s86_member_no;
create sequence s86_member_no;

insert into t86_member
values (s86_member_no.nextVal, 'admin', 'admin');
insert into t86_member
values (s86_member_no.nextVal, 'a', '1');

create table t86_board_file (
	file_no number primary key,
	no number(6) not null,
	ori_file_name varchar2(200) not null,
	real_file_name varchar2(200) not null,
	file_path varchar2(100) not null,
	file_size number not null
);

create sequence s86_board_file_no;





create table t86_board_comment (
	comment_no number primary key,
	no number(6) not null,
	writer varchar2(30) not null,
	content varchar2(500) not null,
	reg_date date default sysdate
);

create sequence s86_board_comment_no;