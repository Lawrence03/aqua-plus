-- splash 1.16: user_option - judge_timing
ALTER TABLE mai2_user_option ADD judge_timing int DEFAULT 20;

ALTER TABLE mai2_user_data ADD class_rank int DEFAULT 0;
ALTER TABLE mai2_user_data ADD course_rank int DEFAULT 0;
ALTER TABLE mai2_user_data ADD last_play_credit int DEFAULT 0;
ALTER TABLE mai2_user_data ADD last_play_mode int DEFAULT 0;
ALTER TABLE mai2_user_data ADD last_selectemoney int DEFAULT 0;
ALTER TABLE mai2_user_data ADD last_select_ticket int DEFAULT 0;
ALTER TABLE mai2_user_data ADD last_select_course int DEFAULT 0;
ALTER TABLE mai2_user_data ADD last_count_course int DEFAULT 0;
ALTER TABLE mai2_user_data ADD daily_course_bonus_date varchar(255) DEFAULT 0;

ALTER TABLE mai2_user_ghost ADD course_rank int DEFAULT 0;
ALTER TABLE mai2_user_ghost ADD class_rank int DEFAULT 0;
ALTER TABLE mai2_user_ghost ADD class_value int DEFAULT 0;

ALTER TABLE mai2_user_udemae ADD class_value int DEFAULT 0;
ALTER TABLE mai2_user_udemae ADD max_class_value int DEFAULT 0;

create table mai2_user_charge
(
	id bigint auto_increment
		primary key,
	charge_id int not null,
	stock int not null,
	purchase_date varchar(255) not null,
	valid_date varchar(255) not null,
	user_id bigint null,
	constraint FK0zh3umazahensh4tm7trjikpy
		foreign key (user_id) references mai2_user_data (id)
);

create table mai2_user_course
(
	id bigint auto_increment
		primary key,
	course_id int not null,
	is_last_clear int not null,
	total_restlife int not null,
	total_achievement int not null,
	total_deluxscore int not null,
	play_count int not null,
	clear_date varchar(255) not null,
	last_play_date varchar(255) not null,
	best_achievement int not null,
	best_achievement_date varchar(255) not null,
	best_deluxscore int not null,
	best_deluxscore_date varchar(255) not null,
	user_id bigint null,
	constraint FK3z11okt0gdubhxrudsee6nq2i
		foreign key (user_id) references mai2_user_data (id)
);