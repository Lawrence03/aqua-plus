
ALTER TABLE mai2_user_data ADD player_old_rating int DEFAULT 0;
ALTER TABLE mai2_user_data ADD player_new_rating int DEFAULT 0;

create table mai2_user_friend_season_ranking
(
	id bigint auto_increment
		primary key,
	season_id int not null,
	point int not null,
	rank int not null,
	reward_get int not null,
	user_name varchar(255) not null,
	record_date varchar(255) not null,
	user_id bigint null,
	constraint FK71xtz1u79cukltbwlbctlzfrb
		foreign key (user_id) references mai2_user_data (id)
);
