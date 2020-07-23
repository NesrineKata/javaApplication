drop table Utilisateur cascade constraint;
drop table question cascade constraint;
 create table utilisateur (User_name varchar(20) Primary key ,MotPasse varchar (20),nom varchar(25),prenom varchar(25),Date_Naiss varchar(12) ,sexe varchar(10));
create table Question(qutNum number  primary key ,qut varchar(300),reponse varchar(300));


