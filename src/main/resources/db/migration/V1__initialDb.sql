create table faculties
(
	id bigint auto_increment
		primary key,
	address varchar(255) null,
	created_at datetime(6) null,
	dean varchar(255) null,
	modified_at datetime(6) null,
	name varchar(255) null,
	phone varchar(255) null,
	short_name varchar(255) null
);

create table departments
(
	id bigint auto_increment
		primary key,
	created_at datetime(6) null,
	head varchar(255) null,
	modified_at datetime(6) null,
	name varchar(255) null,
	short_name varchar(255) null,
	faculty_id bigint null,
	constraint FK6xpnvjcfa3l9gnqqb3x8v28iv
		foreign key (faculty_id) references faculties (id)
);

create table specializations
(
	id bigint auto_increment
		primary key,
	created_at datetime(6) null,
	modified_at datetime(6) null,
	name varchar(255) null,
	number varchar(255) null,
	department_id bigint not null,
	constraint FKmbosp83ckb8d8yjponpvhmbp8
		foreign key (department_id) references departments (id)
);

create table groupss
(
	id bigint auto_increment
		primary key,
	amount int not null,
	created_at datetime(6) null,
	modified_at datetime(6) null,
	number varchar(255) null,
	specialization_id bigint not null,
	constraint FKtooaqkgqkpydj4fmibo9wxhoq
		foreign key (specialization_id) references specializations (id)
);

create table students
(
	id bigint auto_increment
		primary key,
	created_at datetime(6) null,
	date_of_birth date null,
	modified_at datetime(6) null,
	name varchar(255) null,
	number varchar(255) null,
	group_id bigint not null,
	constraint FKrtbxoxbesmnn224r4xed4uvln
		foreign key (group_id) references groupss (id)
);

create table journal
(
	id bigint auto_increment
		primary key,
	created_at datetime(6) null,
	modified_at datetime(6) null,
	value int not null,
	conduct_id bigint not null,
	student_id bigint not null,
	constraint FKni7rxdat1y2jo6pfnunt6w2nn
		foreign key (conduct_id) references students (id),
	constraint FKr1mxppo54xtt3h5idp3b270ls
		foreign key (student_id) references students (id)
);

create table subjects
(
	id bigint auto_increment
		primary key,
	created_at datetime(6) null,
	modified_at datetime(6) null,
	name varchar(255) null
);

create table schedule
(
	id bigint auto_increment
		primary key,
	created_at datetime(6) null,
	day int not null,
	modified_at datetime(6) null,
	time int not null,
	type varchar(255) null,
	group_id bigint not null,
	subject_id bigint not null,
	constraint FK4cppgdstbqff01mprfb1ecfqn
		foreign key (group_id) references groupss (id),
	constraint FK5yrbco7c1qrljdaq59ogqen9o
		foreign key (subject_id) references subjects (id)
);

create table conduct
(
	id bigint auto_increment
		primary key,
	conducted bit not null,
	created_at datetime(6) null,
	date date null,
	modified_at datetime(6) null,
	schedule_id bigint not null,
	constraint FK80g32ssxta2jbqbs134dcvf4a
		foreign key (schedule_id) references schedule (id)
);

create table teachers
(
	id bigint auto_increment
		primary key,
	created_at datetime(6) null,
	date_of_birth date null,
	modified_at datetime(6) null,
	name varchar(255) null,
	position varchar(255) null,
	department_id bigint not null,
	constraint FKrgr03njnvpwuktc0mntf8t6o0
		foreign key (department_id) references departments (id)
);

create table teachers_subjects
(
	teacher_id bigint not null,
	subject_id bigint not null,
	primary key (teacher_id, subject_id),
	constraint FK60390cxlor02x2h4wra2gge2b
		foreign key (subject_id) references subjects (id),
	constraint FKncdyxoidjk44jwkexcltr87ay
		foreign key (teacher_id) references teachers (id)
);