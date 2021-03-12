insert into todo(id, username,description,target_date,is_done)
values(10001, 'in28minutes', 'Learn JPA', sysdate(), false);

insert into todo(id, username,description,target_date,is_done)
values(10002, 'in28minutes', 'Learn Data JPA', sysdate(), false);

insert into todo(id, username,description,target_date,is_done)
values(10003, 'in28minutes', 'Learn Microservices', sysdate(), false);


insert into student(studentID,name,dob,email,address)
values(1,'in28minutes','1990-01-01','in28minutes@gmail.com', '6544 Palisades Dr');

insert into student(studentID,name,dob,email,address)
values(2,'yixin','1993-01-20','yixin@gmail.com', 'Lee Hway');

insert into course(courseID,name,description,available_semster,credit)
values(14326,'Java101','Basic Java course','Spring','3');

insert into course(courseID,name,description,available_semster,credit)
values(23451,'Angular101','Basic Angular course', 'Spring','3');

insert into course(courseID,name,description,available_semster,credit)
values(13236,'Dancing','Happy dancing class','Summer','3');

insert into course(courseID,name,description,available_semster,credit)
values(13756,'Singing','Happy Singing class','Winter','3');

insert into course(courseID,name,description,available_semster,credit)
values(13514,'Drawing','Happy drawing class','Summer','3');

insert into course(courseID,name,description,available_semster,credit)
values(13526,'Java102','Java class 102','Fall','3');

insert into registration(courseID, studentID, semester, status, register_date, target_date)
values(14326,1,'Spring', 'False',sysdate(), '2021-12-31');

insert into registration(courseID, studentID, semester, status, register_date, target_date)
values(23451,1,'Spring', 'False',sysdate(), '2021-12-31');

insert into registration(courseID, studentID, semester, status, register_date, target_date)
values(23451,2,'Spring', 'False',sysdate(), '2021-12-31');



