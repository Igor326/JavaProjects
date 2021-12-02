use db2;

create table Users (
User_id int primary key,
Name varchar(100),
);

create table Role(
Role_id int primary key,
Role_name varchar(30),
 

insert into Users(User_id, Name) values(1, 'John');
insert into Users(User_id, Name) values(2, 'Jack');
insert into Users(User_id, Name) values(3, 'Alice');
insert into Users(User_id, Name) values(4, 'Mike');
insert into Users(User_id, Name) values(5, 'Neil');

insert into Role(Role_id, Role_name) values(1, 'User');
insert into Role(Role_id, Role_name) values(2, 'Admin');

create table UserRoleRelations(
User_id int NOT NULL,
Role_id INT NOT NULL,
FOREIGN KEY(User_id) REFERENCES Users(User_id),
FOREIGN KEY (Role_id) REFERENCES Role(Role_id),
)

INSERT INTO UserRoleRelations(User_id, Role_id) VALUES(1,1);
INSERT INTO UserRoleRelations(User_id, Role_id) VALUES(2,1);
INSERT INTO UserRoleRelations(User_id, Role_id) VALUES(3,2);
INSERT INTO UserRoleRelations(User_id, Role_id) VALUES(4,1);
INSERT INTO UserRoleRelations(User_id, Role_id) VALUES(5,2);

SELECT User_id FROM UserRoleRelations WHERE Role_id = 1;
SELECT User_id FROM UserRoleRelations WHERE Role_id = 2;

