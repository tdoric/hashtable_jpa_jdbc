DROP TABLE IF EXISTS student;
create table student
(
   UUID integer auto_increment,
   name varchar(25) not null,
   grade integer not null,
   primary key(UUID)
);
