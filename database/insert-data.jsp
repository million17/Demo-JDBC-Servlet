insert into category(name,code) values ('Thể Thao', 'the-thao');
insert into category(name,code) values ('Thế Giới', 'the-gioi');
insert into category(name,code) value ('Thời Sự', 'thoi-su');
insert into category(name,code) value ('Chính Trị', 'chinh-tri');


insert into news(title,categoryid) value ('Title 1', '1');
insert into news(title,categoryid) value ('Title 2', '1');
insert into news(title,categoryid) value ('Title 3', '2');
insert into news(title,categoryid) value ('Title 4', '1');

INSERT INTO `user` ( `username`, `password`, `fullname`, `status`, `roleid`) VALUES ( 'admin', '1', 'Trieu Ngo Quang', '1', '1');
INSERT INTO `user` ( `username`, `password`, `fullname`, `status`, `roleid`) VALUES ( 'user', '1', 'Trieu Ngo Quang', '1', '2');