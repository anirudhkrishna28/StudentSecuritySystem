use ani;
create table Student(Roll_Number int,Name_of_Student varchar(50),DOB date,Age int,Father_Name varchar(50),Mother_Name varchar(50),Phone_Number bigint,Bus_Number int,Present_Absent char(10),Participated_Event varchar(100));
insert into Student values(1,'Sri','2003-8-4',19,'Kumar','Anitha',9354769810,27,'P',null);
insert into Student values(2,'Arun','2004-1-4',19,'Raja','Sheela',8354769789,27,'A',null);
insert into Student values(3,'Bharathi','2004-2-7',18,'Ram','Sita',9454769734,28,'A',null);
insert into Student values(4,'Christoper','2003-10-2',19,'Krishna','Rukmani',9283746529,28,'P',null);
insert into Student values(5,'Darwin','2003-7-8',19,'Subramaniyam','Rajeshwari',8238765490,25,null,null);
insert into Student values(6,'Ellen','2003-12-28',18,'Joseph','Mary',7567893456,25,null,null);
insert into Student values(7,'Dharani','2004-3-8',19,'Ramesh','Devi',8765432908,24,null,null);
insert into Student values(8,'Maha','2004-5-25',19,'Govind','Kala',7898654689,24,null,null);

update Student set Participated_Event = null where Roll_Number = 3;

select Name_of_Student from Student where Present_Absent='P';
select Name_of_Student from Student where Present_Absent='A';

select * from Student;