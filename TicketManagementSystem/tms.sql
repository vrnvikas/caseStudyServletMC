Create table ticket_category(ticket_category_id varchar2(5) primary key,ticket_category_name varchar2(50));
insert into ticket_category values('tc001',’software installation');
insert into ticket_category values('tc002','mailbox creation');
insert into ticket_category values('tc003','network issues');

Create table ticket_logs(ticketNo number primary key, ticket_category_Id varchar2(5) references ticket_category(ticket_category_id),
 ticket_description varchar2(50), ticket_priority varchar2(10),  ticket_status  varchar2(10) ,   itimd_comments varchar2(50));

CREATE SEQUENCE ticket_SEQ start with 1000;
