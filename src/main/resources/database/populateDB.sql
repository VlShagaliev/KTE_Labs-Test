insert into doctors (uuid, FIO, department, post) values (35, 'Попов Павел Петрович', 'Отделение Онкологии', 'онколог');
insert into doctors (uuid, FIO, department, post) values (28, 'Зубарев Михаил Петрович', 'Терапевтическое отделение', 'терапевт');
insert into doctors (uuid, FIO, department, post) values (27, 'Корнилов Алекей Алексеевич', 'Отоларингологическое отделение ', 'отоларинголог');
insert into doctors (uuid, FIO, department, post) values (36, 'Пушкин Павел Федорович', 'Отделение педиатрии', 'педиатр');
insert into doctors (uuid, FIO, department, post) values (19, 'Королев Андрей Николаевич', 'Офтальмологическое', 'офтальмолог');
insert into doctors (uuid, FIO, department, post) values (1, 'Лебедев Никита Андреевич', 'Отделение диетологии', 'диетолог');
insert into doctors (uuid, FIO, department, post) values (5, 'Сутулов Александр Михайлович', 'Стоматологическое отделение', 'стоматолог');


insert into patients (uuid, FIO, birthdate) values (22, 'Дураничев Егор Игоревич', '1987-09-20');
insert into patients (uuid, FIO, birthdate) values (25, 'Поздеев Алексей Николаевич', '1980-05-26');
insert into patients (uuid, FIO, birthdate) values (10, 'Пестов Игорь Леонидович', '1995-02-21');
insert into patients (uuid, FIO, birthdate) values (15, 'Коноплев Андрей Павлович', '1998-07-07');
insert into patients (uuid, FIO, birthdate) values (5, 'Русаков Геннадий Валерьевич', '1978-10-12');


insert into tickets (id_doctor, id_patient, time_of_receipt) values (1,1,'2024-02-10 12:10')


select * from doctors;
select * from patients;