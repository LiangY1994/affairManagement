CREATE database db_affaireManagement;
USE db_affaireManagement;

create table employee(
	employeeID int not null primary key,
	employeeName string not null,
	isLead bool not null
);

create table message(
	messageID int not null primary key,
	messageDate date not null,
	messageContent varchar(100) not null,
	employee.employeeID not null
);

create table reply(
	replyID int not null primary key,
	replyDate date not null,
	replyContent varchar(50) not null,
	employee.employeeID not null,
	message.messageID not null
);

create table critism(
	critismID int not null primary key,
	critismDate date not null,
	critismContent varchar(50) not null,
	employee.employeeID not null,
	message.messageID not null
);