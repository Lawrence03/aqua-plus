create table mai2_game_event
(
	id bigint auto_increment
		primary key,
	end_date varchar(255) null,
	event_id int not null,
	start_date varchar(255) null,
	type int not null
);

create table mai2_user_data
(
	id bigint auto_increment
		primary key,
	chara_slot varchar(255) null,
	combo_count int not null,
	compatible_cm_version varchar(255) null,
	content_bit bigint not null,
	daily_bonus_date varchar(255) null,
	event_watched_date varchar(255) null,
	first_data_version varchar(255) null,
	first_game_id varchar(255) null,
	first_play_date varchar(255) null,
	first_rom_version varchar(255) null,
	grade_rank int not null,
	grade_rating int not null,
	help_count int not null,
	highest_rating int not null,
	icon_id int not null,
	is_net_member int not null,
	last_all_net_id int not null,
	last_client_id varchar(255) null,
	last_country_code varchar(255) null,
	last_data_version varchar(255) null,
	last_game_id varchar(255) null,
	last_login_date varchar(255) null,
	last_place_id int not null,
	last_place_name varchar(255) null,
	last_play_date varchar(255) null,
	last_region_id int not null,
	last_region_name varchar(255) null,
	last_rom_version varchar(255) null,
	music_rating int not null,
	plate_id int not null,
	play_count int not null,
	play_sync_count int not null,
	play_vs_count int not null,
	player_rating int not null,
	select_map_id int not null,
	title_id int not null,
	total_achievement bigint not null,
	total_advanced_achievement bigint not null,
	total_advanced_deluxscore bigint not null,
	total_advanced_sync int not null,
	total_awake int not null,
	total_basic_achievement bigint not null,
	total_basic_deluxscore bigint not null,
	total_basic_sync int not null,
	total_deluxscore bigint not null,
	total_expert_achievement bigint not null,
	total_expert_deluxscore bigint not null,
	total_expert_sync int not null,
	total_master_achievement bigint not null,
	total_master_deluxscore bigint not null,
	total_master_sync int not null,
	total_re_master_achievement bigint not null,
	total_re_master_deluxscore bigint not null,
	total_re_master_sync int not null,
	total_sync int not null,
	user_name varchar(255) null,
	win_count int not null,
	aime_card_id bigint null,
	constraint FKeees2inj4aehl1sw5x0evykfr
		foreign key (aime_card_id) references sega_card (id)
);

create table mai2_user_activity
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
	constraint FKgl3c4jjoswe6kxkjxay8xf3dx
		foreign key (user_id) references mai2_user_data (id)
);

create table mai2_user_character
(
	id bigint auto_increment
		primary key,
	awakening int not null,
	character_id int not null,
	level int not null,
	use_count int not null,
	user_id bigint null,
	constraint FKjvonsuvn00tmqeapoupifx7ar
		foreign key (user_id) references mai2_user_data (id)
);

create table mai2_user_extend
(
	id bigint auto_increment
		primary key,
	category_index int not null,
	encount_map_npc_list varchar(255) null,
	extra_flag int not null,
	music_index int not null,
	select_difficulty_id int not null,
	select_music_id int not null,
	select_result_details bit not null,
	select_score_type int not null,
	selected_card_list varchar(255) null,
	sort_category_setting int not null,
	sort_music_setting int not null,
	user_id bigint null,
	constraint FKbnw50u1k98seis3c1w7fgc2xn
		foreign key (user_id) references mai2_user_data (id)
);

create table mai2_user_favourite
(
	id bigint auto_increment
		primary key,
	item_id_list varchar(255) null,
	item_kind int not null,
	user_id bigint null,
	constraint FK2sugdoa632d2dag26657uefih
		foreign key (user_id) references mai2_user_data (id)
);

create table mai2_user_general_data
(
	id bigint auto_increment
		primary key,
	property_key varchar(255) null,
	property_value varchar(255) null,
	user_id bigint null,
	constraint FK7m0h4bmnua1odwbbneyqtbwus
		foreign key (user_id) references mai2_user_data (id)
);

create table mai2_user_ghost
(
	id bigint auto_increment
		primary key,
	achievement int not null,
	difficulty int not null,
	icon_id int not null,
	music_id int not null,
	name varchar(255) null,
	plate_id int not null,
	play_datetime varchar(255) null,
	rate int not null,
	region_code int not null,
	result_bit_list text null,
	result_num int not null,
	shop_id int not null,
	title_id int not null,
	type_id int not null,
	udemae_rate int not null,
	version int not null
);

create table mai2_user_item
(
	id bigint auto_increment
		primary key,
	is_valid bit not null,
	item_id int not null,
	item_kind int not null,
	stock int not null,
	user_id bigint null,
	constraint FKdahwpb9dtjsl7xhs6pn8s1yhx
		foreign key (user_id) references mai2_user_data (id)
);

create table mai2_user_map
(
	id bigint auto_increment
		primary key,
	distance int not null,
	is_clear bit not null,
	is_complete bit not null,
	is_lock bit not null,
	map_id int not null,
	user_id bigint null,
	constraint FKqytbbko4dmkfo99ih2yj1umji
		foreign key (user_id) references mai2_user_data (id)
);

create table mai2_user_music_detail
(
	id bigint auto_increment
		primary key,
	achievement int not null,
	combo_status int not null,
	deluxscore_max int not null,
	level int not null,
	music_id int not null,
	play_count int not null,
	score_rank int not null,
	sync_status int not null,
	user_id bigint null,
	constraint FK1trv4aytlmckl69fs9nje9rlk
		foreign key (user_id) references mai2_user_data (id)
);

create table mai2_user_option
(
	id bigint auto_increment
		primary key,
	adjust_timing int not null,
	ans_volume int not null,
	break_se int not null,
	break_volume int not null,
	brightness int not null,
	critical_se int not null,
	disp_bar int not null,
	disp_center int not null,
	disp_chain int not null,
	disp_judge int not null,
	disp_judge_pos int not null,
	disp_judge_touch_pos int not null,
	disp_rate int not null,
	ex_se int not null,
	ex_volume int not null,
	head_phone_volume int not null,
	hold_design int not null,
	matching int not null,
	mirror_mode int not null,
	note_size int not null,
	note_speed int not null,
	option_kind int not null,
	outline_design int not null,
	slide_design int not null,
	slide_se int not null,
	slide_size int not null,
	slide_speed int not null,
	slide_volume int not null,
	sort_music int not null,
	sort_tab int not null,
	star_rotate int not null,
	star_type int not null,
	submonitor_achive int not null,
	submonitor_animation int not null,
	submonitor_appeal int not null,
	tap_design int not null,
	tap_hold_volume int not null,
	touch_effect int not null,
	touch_hold_volume int not null,
	touch_size int not null,
	touch_speed int not null,
	track_skip int not null,
	user_id bigint null,
	constraint FKam0vqvqjeblt31js729uv0o1w
		foreign key (user_id) references mai2_user_data (id)
);

create table mai2_user_udemae
(
	id bigint auto_increment
		primary key,
	lose_num int not null,
	max_lose_num int not null,
	max_win_num int not null,
	npc_lose_num int not null,
	npc_max_lose_num int not null,
	npc_max_win_num int not null,
	npc_total_lose_num int not null,
	npc_total_win_num int not null,
	npc_win_num int not null,
	rate int not null,
	total_lose_num int not null,
	total_win_num int not null,
	win_num int not null,
	user_id bigint null,
	constraint FK7yqxvyxnquawv9g6p25ergc16
		foreign key (user_id) references mai2_user_data (id)
);

create table mai2_user_playlog
(
	id bigint auto_increment
		primary key,
	achievement int not null,
	after_delux_rating int not null,
	after_grade int not null,
	after_grade_rank int not null,
	after_rating int not null,
	before_delux_rating int not null,
	before_grade int not null,
	before_rating int not null,
	break_critical_perfect int not null,
	break_good int not null,
	break_great int not null,
	break_miss int not null,
	break_perfect int not null,
	character_awakening1 int not null,
	character_awakening2 int not null,
	character_awakening3 int not null,
	character_awakening4 int not null,
	character_awakening5 int not null,
	character_id1 int not null,
	character_id2 int not null,
	character_id3 int not null,
	character_id4 int not null,
	character_id5 int not null,
	character_level1 int not null,
	character_level2 int not null,
	character_level3 int not null,
	character_level4 int not null,
	character_level5 int not null,
	combo_status int not null,
	deluxscore int not null,
	fast_count int not null,
	hold_critical_perfect int not null,
	hold_good int not null,
	hold_great int not null,
	hold_miss int not null,
	hold_perfect int not null,
	is_achieve_new_record bit not null,
	is_break bit not null,
	is_clear bit not null,
	is_critical_disp bit not null,
	is_deluxscore_new_record bit not null,
	is_event_mode bit not null,
	is_fast_late_disp bit not null,
	is_freedom_mode bit not null,
	is_hold bit not null,
	is_new_free bit not null,
	is_play_tutorial bit not null,
	is_slide bit not null,
	is_tap bit not null,
	is_touch bit not null,
	late_count int not null,
	level int not null,
	login_date bigint not null,
	max_combo int not null,
	max_sync int not null,
	music_id int not null,
	place_name varchar(255) null,
	played_music_level1 int not null,
	played_music_level2 int not null,
	played_music_level3 int not null,
	played_user_id1 bigint not null,
	played_user_id2 bigint not null,
	played_user_id3 bigint not null,
	played_user_name1 varchar(255) null,
	played_user_name2 varchar(255) null,
	played_user_name3 varchar(255) null,
	player_num int not null,
	score_rank int not null,
	slide_critical_perfect int not null,
	slide_good int not null,
	slide_great int not null,
	slide_miss int not null,
	slide_perfect int not null,
	sync_status int not null,
	tap_critical_perfect int not null,
	tap_good int not null,
	tap_great int not null,
	tap_miss int not null,
	tap_perfect int not null,
	total_combo int not null,
	total_sync int not null,
	touch_critical_perfect int not null,
	touch_good int not null,
	touch_great int not null,
	touch_miss int not null,
	touch_perfect int not null,
	track_no int not null,
	type int not null,
	user_play_date varchar(255) null,
	vs_mode int not null,
	vs_rank int not null,
	vs_status int not null,
	vs_user_achievement int not null,
	vs_user_grade_rank int not null,
	vs_user_name varchar(255) null,
	vs_user_rating int not null,
	user_id bigint null,
	constraint FK6jpabt0m6ostflvagr9es07g3
		foreign key (user_id) references mai2_user_data (id)
);



INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (1, '2029-01-01 23:59:59.0', 1, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (2, '2029-01-01 23:59:59.0', 191101, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (3, '2029-01-01 23:59:59.0', 19110121, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (4, '2029-01-01 23:59:59.0', 19110122, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (5, '2029-01-01 23:59:59.0', 19110131, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (6, '2029-01-01 23:59:59.0', 19110132, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (7, '2029-01-01 23:59:59.0', 19110141, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (8, '2029-01-01 23:59:59.0', 19110161, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (9, '2029-01-01 23:59:59.0', 19110171, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (10, '2029-01-01 23:59:59.0', 19110181, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (11, '2029-01-01 23:59:59.0', 19110191, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (12, '2029-01-01 23:59:59.0', 191102, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (13, '2029-01-01 23:59:59.0', 191103, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (14, '2029-01-01 23:59:59.0', 191104, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (15, '2029-01-01 23:59:59.0', 191105, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (16, '2029-01-01 23:59:59.0', 191106, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (17, '2029-01-01 23:59:59.0', 19121321, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (18, '2029-01-01 23:59:59.0', 19121341, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (19, '2029-01-01 23:59:59.0', 19121391, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (20, '2029-01-01 23:59:59.0', 19122021, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (21, '2029-01-01 23:59:59.0', 19122031, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (22, '2029-01-01 23:59:59.0', 20011021, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (23, '2029-01-01 23:59:59.0', 20012321, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (24, '2029-01-01 23:59:59.0', 20012331, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (25, '2029-01-01 23:59:59.0', 20020721, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (26, '2029-01-01 23:59:59.0', 20020722, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (27, '2029-01-01 23:59:59.0', 20020741, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (28, '2029-01-01 23:59:59.0', 20022021, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (29, '2029-01-01 23:59:59.0', 20022031, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (30, '2029-01-01 23:59:59.0', 20030621, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (31, '2029-01-01 23:59:59.0', 20030622, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (32, '2029-01-01 23:59:59.0', 20030641, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (33, '2029-01-01 23:59:59.0', 20032021, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (34, '2029-01-01 23:59:59.0', 20041021, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (35, '2029-01-01 23:59:59.0', 20041022, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (36, '2029-01-01 23:59:59.0', 20041041, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (37, '2029-01-01 23:59:59.0', 20042421, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (38, '2029-01-01 23:59:59.0', 20050821, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (39, '2029-01-01 23:59:59.0', 20050841, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (40, '2029-01-01 23:59:59.0', 20052221, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (41, '2029-01-01 23:59:59.0', 191201, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (42, '2029-01-01 23:59:59.0', 191202, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (43, '2029-01-01 23:59:59.0', 191211, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (44, '2029-01-01 23:59:59.0', 200101, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (45, '2029-01-01 23:59:59.0', 200111, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (46, '2029-01-01 23:59:59.0', 200201, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (47, '2029-01-01 23:59:59.0', 200202, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (48, '2029-01-01 23:59:59.0', 200211, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (49, '2029-01-01 23:59:59.0', 200301, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (50, '2029-01-01 23:59:59.0', 200302, '2005-01-01 00:00:00.0', 0);
INSERT INTO mai2_game_event (id, end_date, event_id, start_date, type) VALUES (51, '2029-01-01 23:59:59.0', 200311, '2005-01-01 00:00:00.0', 0);