create table maimai_game_event
(
	id bigint auto_increment
		primary key,
	end_date varchar(255) null,
	event_id int not null,
	start_date varchar(255) null,
	type int not null
);

create table maimai_user_data
(
	id bigint auto_increment
		primary key,
	challenge_track_phase int not null,
	combo_count int not null,
	event_point int not null,
	event_watched_date varchar(255) null,
	fever_count int not null,
	first_play_bits int not null,
	frame_id int not null,
	help_count int not null,
	highest_rating int not null,
	icon_id int not null,
	last_client_id varchar(255) null,
	last_country_code varchar(255) null,
	last_data_version int not null,
	last_login_bonus_day int not null,
	last_place_id int not null,
	last_place_name varchar(255) null,
	last_play_date varchar(255) null,
	last_region_id int not null,
	last_region_name varchar(255) null,
	last_survival_bonus_day int not null,
	login_bonus_lv int not null,
	nameplate_id int not null,
	play_count int not null,
	play_sync_count int not null,
	play_vs_count int not null,
	player_rating int not null,
	point int not null,
	rank_auth_tail_id int not null,
	total_advanced_high_score int not null,
	total_advanced_sync int not null,
	total_basic_high_score int not null,
	total_basic_sync int not null,
	total_easy_high_score int not null,
	total_easy_sync int not null,
	total_expert_high_score int not null,
	total_expert_sync int not null,
	total_hi_score int not null,
	total_high_sync int not null,
	total_lv int not null,
	total_master_high_score int not null,
	total_master_sync int not null,
	total_point int not null,
	total_re_master_high_score int not null,
	total_re_master_sync int not null,
	trophy_id int not null,
	user_name varchar(255) null,
	web_limit_date varchar(255) null,
	win_count int not null,
	aime_card_id bigint null,
	constraint FKm7wtt6742a7lnpsbvxtk2pkxj
		foreign key (aime_card_id) references sega_card (id)
);

create table maimai_user_activity
(
	id bigint auto_increment
		primary key,
	activity_id int not null,
	kind int not null,
	param1 int not null,
	param2 int not null,
	param3 int not null,
	param4 int not null,
	sort_number bigint not null,
	user_id bigint null,
	constraint FK1slyt111h8m3pkvp67nh6cq4f
		foreign key (user_id) references maimai_user_data (id)
);

create table maimai_user_boss
(
	id bigint auto_increment
		primary key,
	emblem_flag_list bigint not null,
	pandora_flag_list0 bigint not null,
	pandora_flag_list1 bigint not null,
	pandora_flag_list2 bigint not null,
	pandora_flag_list3 bigint not null,
	pandora_flag_list4 bigint not null,
	pandora_flag_list5 bigint not null,
	pandora_flag_list6 bigint not null,
	user_id bigint null,
	constraint FKyyl9l2hpsf9scdi0vu48i4uo
		foreign key (user_id) references maimai_user_data (id)
);

create table maimai_user_character
(
	id bigint auto_increment
		primary key,
	character_id int not null,
	level int not null,
	point int not null,
	user_id bigint null,
	constraint FKnpktuaib0wg0rfopcqmp6xsxq
		foreign key (user_id) references maimai_user_data (id)
);

create table maimai_user_general_data
(
	id bigint auto_increment
		primary key,
	property_key varchar(255) null,
	property_value text null,
	user_id bigint null,
	constraint FKn8uxwqcng96dqsv05tpvq6en6
		foreign key (user_id) references maimai_user_data (id)
);

create table maimai_user_item
(
	id bigint auto_increment
		primary key,
	item_id int not null,
	item_kind int not null,
	stock int not null,
	user_id bigint null,
	constraint FK78o1t4n3bx96888dgvgyiqi97
		foreign key (user_id) references maimai_user_data (id)
);

create table maimai_user_music_detail
(
	id bigint auto_increment
		primary key,
	achievement int not null,
	full_combo int not null,
	is_all_perfect bit not null,
	is_all_perfect_plus int not null,
	level int not null,
	max_fever int not null,
	music_id int not null,
	play_count int not null,
	score_max int not null,
	sync_rate_max int not null,
	user_id bigint null,
	constraint FKi0serv52ls8x4dnlngxnenoe2
		foreign key (user_id) references maimai_user_data (id)
);

create table maimai_user_option
(
	id bigint auto_increment
		primary key,
	adjust_timing int not null,
	ans_vol int not null,
	appeal_flame int not null,
	bg_info int not null,
	break_se int not null,
	break_se_vol int not null,
	brightness int not null,
	disp_judge int not null,
	disp_timing int not null,
	dmg_vol int not null,
	filter_all_perfect int not null,
	filter_difficulty int not null,
	filter_full_combo int not null,
	filter_full_sync int not null,
	filter_genre int not null,
	filter_level int not null,
	filter_max_fever int not null,
	filter_rank int not null,
	filter_re_master int not null,
	filter_rec int not null,
	filter_version int not null,
	final_select_category int not null,
	final_select_id int not null,
	guide_speed int not null,
	hard_judge int not null,
	is_fever_disp int not null,
	is_star_rot int not null,
	is_tag_jump int not null,
	is_upper_disp int not null,
	judge_pos int not null,
	mirror_mode int not null,
	note_vol int not null,
	option_mode int not null,
	rating_guard int not null,
	select_chara int not null,
	simple_option_param int not null,
	slide_se int not null,
	slide_se_vol int not null,
	sort_type int not null,
	soud_effect int not null,
	timing_pos int not null,
	track_skip int not null,
	user_id bigint null,
	constraint FKgf0cpopptvya82s8mj406fpot
		foreign key (user_id) references maimai_user_data (id)
);

create table maimai_user_playlog
(
	id bigint auto_increment
		primary key,
	achievement int not null,
	break_bad int not null,
	break_good int not null,
	break_great int not null,
	break_perfect int not null,
	break_score int not null,
	challenge_life int not null,
	challenge_remain int not null,
	country varchar(255) null,
	event_id int not null,
	full_combo int not null,
	game_mode int not null,
	hold_bad int not null,
	hold_good int not null,
	hold_great int not null,
	hold_perfect int not null,
	hold_score int not null,
	is_all_perfect bit not null,
	is_all_perfect_plus int not null,
	is_challenge_track bit not null,
	is_free_to_play bit not null,
	is_high_score bit not null,
	is_track_skip bit not null,
	level int not null,
	max_combo int not null,
	max_fever int not null,
	music_id int not null,
	order_id int not null,
	place_id int not null,
	place_name varchar(255) null,
	play_date varchar(255) null,
	played_music_level1 int not null,
	played_music_level2 int not null,
	played_music_level3 int not null,
	played_user_id1 bigint not null,
	played_user_id2 bigint not null,
	played_user_id3 bigint not null,
	played_user_name1 varchar(255) null,
	played_user_name2 varchar(255) null,
	played_user_name3 varchar(255) null,
	player_rating int not null,
	region_id int not null,
	rival_num int not null,
	score int not null,
	slide_bad int not null,
	slide_good int not null,
	slide_great int not null,
	slide_perfect int not null,
	slide_score int not null,
	sort_number bigint not null,
	sync_rate int not null,
	tap_bad int not null,
	tap_good int not null,
	tap_great int not null,
	tap_perfect int not null,
	tap_score int not null,
	track int not null,
	user_play_date varchar(255) null,
	vs_win int not null,
	user_id bigint null,
	constraint FK8wwroomy1dbdube88ym4rirp
		foreign key (user_id) references maimai_user_data (id)
);

create table maimai_user_present_event
(
	id bigint auto_increment
		primary key,
	point int not null,
	present_count int not null,
	present_event_id int not null,
	rate int not null,
	user_id bigint null,
	constraint FK662nxt52xnmf1ai8415o7phnc
		foreign key (user_id) references maimai_user_data (id)
);

create table maimai_user_survival
(
	id bigint auto_increment
		primary key,
	is_clear bit not null,
	is_no_damage bit not null,
	survival_id int not null,
	total_achieve int not null,
	total_score int not null,
	user_id bigint null,
	constraint FK73wots53hgxo1cww3tfr8dh61
		foreign key (user_id) references maimai_user_data (id)
);

create table maimai_user_web_option
(
	id bigint auto_increment
		primary key,
	disp_home_ranker int not null,
	disp_judge_style int not null,
	disp_rank int not null,
	disp_rate int not null,
	disp_total_lv int not null,
	is_net_member bit not null,
	user_id bigint null,
	constraint FKn1keedu2fw9i6n6ek38nwkei5
		foreign key (user_id) references maimai_user_data (id)
);

