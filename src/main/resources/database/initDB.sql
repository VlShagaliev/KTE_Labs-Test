create table if not exists doctors
(
			id 				serial 						primary key,
			suuid 			UUID,
			FIO 			varchar(80)					NOT NULL,
			post 			varchar(80)					NOT NULL,
			department 		varchar(80)					NOT NULL
);

create table if not exists patients
(
			id 				serial 						primary key,
			suuid 			UUID,
			FIO 			varchar(80) 				NOT NULL,
			birthdate 		date						NOT NULL
);

create table if not exists tickets
(
			id 				serial						primary key,
			id_doctor 		int							REFERENCES doctors (id) NOT NULL,
			id_patient 		int							REFERENCES patients (id) NOT NULL,
			time_of_receipt timestamp with time zone	NOT NULL
);
drop table tickets;
drop table doctors;
drop table patients;