create table employee(
employeeId int,
firstName varchar(20) not null,
lastName varchar(30) not null,
reimbursement numeric(4,2), --numeric(# of digits before the decimal point, digits after the decimal) ex:(1000.00)
foreign key (employeeId) references login(employeeId) on delete cascade 
);

create table login(
employeeId serial primary key not null,
username varchar(20) unique not null,
password varchar(20) not null
);

create table EventForm(
eventId serial primary key not null,
employeeId int,
dateOfEvent date not null,
timeOfEvent time(precision) not null,
eventLocation varchar(30) not null,
description varchar(200) not null,
eventCost numeric(4,2) not null,
gradeFormat 
eventType varchar(30),
justification varchar(200),
hasApprovalEmail boolean,
isApproved boolean, --????
foreign key (employeeId) references login(employeeId) on delete cascade
)

create table GradingFormat(

)

create table EventTypes(

)


drop table employee;
employeeId serial primary key not null,--not a primary key? don't think that would work