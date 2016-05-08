CREATE database db_affairemanagement;
USE db_affairemanagement;

create table tb_employee(
	employeeID int not null primary key,
	employeeName varchar(20) not null,
	isLead bool not null
);
create table tb_message(
	messageID int not null primary key,
	messageDate date not null,
	messageContent varchar(100) not null,
	employee.employeeID not null
);
