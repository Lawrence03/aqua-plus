create table ongeki_user_event_music
(
	id bigint auto_increment
		primary key,
	user_id bigint null,
	event_id int not null,
	type int not null,
	music_id int not null,
	level int not null,
	tech_score_max int not null,
	platinum_score_max int not null,
	tech_record_date text not null,
	is_tech_new_record bit not null,
    constraint ongeki_user_event_music_uq
        unique (user_id, event_id, music_id, level)
);

create table ongeki_user_tech_event
(
	id bigint auto_increment
		primary key,
	user_id bigint null,
	event_id int not null,
	total_tech_score int not null,
	total_platinum_score int not null,
	tech_record_date text not null,
	is_ranking_rewarded bit not null,
	is_total_tech_new_record bit not null,
    constraint ongeki_user_tech_event_uq
        unique (user_id, event_id)
);

