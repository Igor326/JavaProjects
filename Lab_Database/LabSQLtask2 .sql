create database db_1;


CREATE TABLE Comments(
Comment_id INT PRIMARY KEY,
Comment_author VARCHAR(40),
Comment_date DATE,
Comment_content VARCHAR(360)
)
insert into Comments(Comment_id, Comment_author, Comment_date,Comment_content) values(1, 'John', '2021-12-02', 'good job');
insert into Comments(Comment_id, Comment_author, Comment_date,Comment_content) values(2, 'Alice', '2021-12-02', 'nice video');
insert into Comments(Comment_id, Comment_author, Comment_date,Comment_content) values(3, 'Masterkiller69', '2021-12-02', 'Boooring');
insert into Comments(Comment_id, Comment_author, Comment_date,Comment_content) values(4, 'Albert', '2021-12-02', 'Good guide');
insert into Comments(Comment_id, Comment_author, Comment_date,Comment_content) values(5, 'Ivan', '2021-12-02', ' it really helped me');
select * from Comments;