insert into doctors (FIO, department, post) values ('Попов Павел Петрович', 'Отделение Онкологии', 'онколог');
insert into doctors (FIO, department, post) values ('Зубарев Михаил Петрович', 'Терапевтическое отделение', 'терапевт');
insert into doctors (FIO, department, post) values ('Корнилов Алекей Алексеевич', 'Отоларингологическое отделение', 'отоларинголог');
insert into doctors (FIO, department, post) values ('Пушкин Павел Федорович', 'Отделение педиатрии', 'педиатр');
insert into doctors (FIO, department, post) values ('Королев Андрей Николаевич', 'Офтальмологическое', 'офтальмолог');
insert into doctors (FIO, department, post) values ('Лебедев Никита Андреевич', 'Отделение диетологии', 'диетолог');
insert into doctors (FIO, department, post) values ('Сутулов Александр Михайлович', 'Стоматологическое отделение', 'стоматолог');


insert into patients (FIO, birthdate) values ('Дураничев Егор Игоревич', '1987-09-20');
insert into patients (FIO, birthdate) values ('Поздеев Алексей Николаевич', '1980-05-26');
insert into patients (FIO, birthdate) values ('Пестов Игорь Леонидович', '1995-02-21');
insert into patients (FIO, birthdate) values ('Коноплев Андрей Павлович', '1998-07-07');
insert into patients (FIO, birthdate) values ('Русаков Геннадий Валерьевич', '1978-10-12');


insert into tickets (id_doctor, id_patient, time_of_receipt, duration_in_minutes) values (3,4,'2024-02-10 12:10', 10)
