CREATE TABLE mai2_game_event
(
	id INTEGER,
	end_date varchar(255) null,
	event_id INTEGER NOT NULL,
	start_date varchar(255) null,
	type INTEGER NOT NULL,
    PRIMARY KEY (
        id
    )
);

CREATE TABLE mai2_user_data
(
	id INTEGER,
	chara_slot varchar(255) null,
	combo_count INTEGER NOT NULL,
	compatible_cm_version varchar(255) null,
	content_bit bigINTEGER NOT NULL,
	daily_bonus_date varchar(255) null,
	event_watched_date varchar(255) null,
	first_data_version varchar(255) null,
	first_game_id varchar(255) null,
	first_play_date varchar(255) null,
	first_rom_version varchar(255) null,
	grade_rank INTEGER NOT NULL,
	grade_rating INTEGER NOT NULL,
	help_count INTEGER NOT NULL,
	highest_rating INTEGER NOT NULL,
	icon_id INTEGER NOT NULL,
	is_net_member INTEGER NOT NULL,
	last_all_net_id INTEGER NOT NULL,
	last_client_id varchar(255) null,
	last_country_code varchar(255) null,
	last_data_version varchar(255) null,
	last_game_id varchar(255) null,
	last_login_date varchar(255) null,
	last_place_id INTEGER NOT NULL,
	last_place_name varchar(255) null,
	last_play_date varchar(255) null,
	last_region_id INTEGER NOT NULL,
	last_region_name varchar(255) null,
	last_rom_version varchar(255) null,
	music_rating INTEGER NOT NULL,
	plate_id INTEGER NOT NULL,
	play_count INTEGER NOT NULL,
	play_sync_count INTEGER NOT NULL,
	play_vs_count INTEGER NOT NULL,
	player_rating INTEGER NOT NULL,
	select_map_id INTEGER NOT NULL,
	title_id INTEGER NOT NULL,
	total_achievement bigINTEGER NOT NULL,
	total_advanced_achievement bigINTEGER NOT NULL,
	total_advanced_deluxscore bigINTEGER NOT NULL,
	total_advanced_sync INTEGER NOT NULL,
	total_awake INTEGER NOT NULL,
	total_basic_achievement bigINTEGER NOT NULL,
	total_basic_deluxscore bigINTEGER NOT NULL,
	total_basic_sync INTEGER NOT NULL,
	total_deluxscore bigINTEGER NOT NULL,
	total_expert_achievement bigINTEGER NOT NULL,
	total_expert_deluxscore bigINTEGER NOT NULL,
	total_expert_sync INTEGER NOT NULL,
	total_master_achievement bigINTEGER NOT NULL,
	total_master_deluxscore bigINTEGER NOT NULL,
	total_master_sync INTEGER NOT NULL,
	total_re_master_achievement bigINTEGER NOT NULL,
	total_re_master_deluxscore bigINTEGER NOT NULL,
	total_re_master_sync INTEGER NOT NULL,
	total_sync INTEGER NOT NULL,
	user_name varchar(255) null,
	win_count INTEGER NOT NULL,
	aime_card_id bigint references sega_card (id),
    PRIMARY KEY (
        id
    )
);

CREATE TABLE mai2_user_activity
(
	id INTEGER,
	activity_id INTEGER NOT NULL,
	kind INTEGER NOT NULL,
	param1 INTEGER NOT NULL,
	param2 INTEGER NOT NULL,
	param3 INTEGER NOT NULL,
	param4 INTEGER NOT NULL,
	sort_number bigINTEGER NOT NULL,
    user_id bigint references mai2_user_data (id) ON DELETE CASCADE,
    PRIMARY KEY (
         id
    )
);

CREATE TABLE mai2_user_character
(
	id INTEGER,
	awakening INTEGER NOT NULL,
	character_id INTEGER NOT NULL,
	level INTEGER NOT NULL,
	use_count INTEGER NOT NULL,
    user_id bigint references mai2_user_data (id) ON DELETE CASCADE,
    PRIMARY KEY (
         id
    )
);

CREATE TABLE mai2_user_extend
(
	id INTEGER,
	category_index INTEGER NOT NULL,
	encount_map_npc_list varchar(255) null,
	extra_flag INTEGER NOT NULL,
	music_index INTEGER NOT NULL,
	select_difficulty_id INTEGER NOT NULL,
	select_music_id INTEGER NOT NULL,
	select_result_details bit not null,
	select_score_type INTEGER NOT NULL,
	selected_card_list varchar(255) null,
	sort_category_setting INTEGER NOT NULL,
	sort_music_setting INTEGER NOT NULL,
    user_id bigint references mai2_user_data (id) ON DELETE CASCADE,
    PRIMARY KEY (
         id
    )
);

CREATE TABLE mai2_user_favourite
(
	id INTEGER,
	item_id_list varchar(255) null,
	item_kind INTEGER NOT NULL,
    user_id bigint references mai2_user_data (id) ON DELETE CASCADE,
    PRIMARY KEY (
         id
    )
);

CREATE TABLE mai2_user_general_data
(
	id INTEGER,
	property_key varchar(255) null,
	property_value varchar(255) null,
    user_id bigint references mai2_user_data (id) ON DELETE CASCADE,
    PRIMARY KEY (
         id
    )
);

CREATE TABLE mai2_user_ghost
(
	id INTEGER,
	achievement INTEGER NOT NULL,
	difficulty INTEGER NOT NULL,
	icon_id INTEGER NOT NULL,
	music_id INTEGER NOT NULL,
	name varchar(255) null,
	plate_id INTEGER NOT NULL,
	play_datetime varchar(255) null,
	rate INTEGER NOT NULL,
	region_code INTEGER NOT NULL,
	result_bit_list text null,
	result_num INTEGER NOT NULL,
	shop_id INTEGER NOT NULL,
	title_id INTEGER NOT NULL,
	type_id INTEGER NOT NULL,
	udemae_rate INTEGER NOT NULL,
	version INTEGER NOT NULL,
    PRIMARY KEY (
     id
    )
);

CREATE TABLE mai2_user_item
(
	id INTEGER,
	is_valid bit not null,
	item_id INTEGER NOT NULL,
	item_kind INTEGER NOT NULL,
	stock INTEGER NOT NULL,
    user_id bigint references mai2_user_data (id) ON DELETE CASCADE,
    PRIMARY KEY (
         id
    )
);

CREATE TABLE mai2_user_map
(
	id INTEGER,
	distance INTEGER NOT NULL,
	is_clear bit not null,
	is_complete bit not null,
	is_lock bit not null,
	map_id INTEGER NOT NULL,
    user_id bigint references mai2_user_data (id) ON DELETE CASCADE,
    PRIMARY KEY (
         id
    )
);

CREATE TABLE mai2_user_music_detail
(
	id INTEGER,
	achievement INTEGER NOT NULL,
	combo_status INTEGER NOT NULL,
	deluxscore_max INTEGER NOT NULL,
	level INTEGER NOT NULL,
	music_id INTEGER NOT NULL,
	play_count INTEGER NOT NULL,
	score_rank INTEGER NOT NULL,
	sync_status INTEGER NOT NULL,
    user_id bigint references mai2_user_data (id) ON DELETE CASCADE,
    PRIMARY KEY (
         id
    )
);

CREATE TABLE mai2_user_option
(
	id INTEGER,
	adjust_timing INTEGER NOT NULL,
	ans_volume INTEGER NOT NULL,
	break_se INTEGER NOT NULL,
	break_volume INTEGER NOT NULL,
	brightness INTEGER NOT NULL,
	critical_se INTEGER NOT NULL,
	disp_bar INTEGER NOT NULL,
	disp_center INTEGER NOT NULL,
	disp_chain INTEGER NOT NULL,
	disp_judge INTEGER NOT NULL,
	disp_judge_pos INTEGER NOT NULL,
	disp_judge_touch_pos INTEGER NOT NULL,
	disp_rate INTEGER NOT NULL,
	ex_se INTEGER NOT NULL,
	ex_volume INTEGER NOT NULL,
	head_phone_volume INTEGER NOT NULL,
	hold_design INTEGER NOT NULL,
	matching INTEGER NOT NULL,
	mirror_mode INTEGER NOT NULL,
	note_size INTEGER NOT NULL,
	note_speed INTEGER NOT NULL,
	option_kind INTEGER NOT NULL,
	outline_design INTEGER NOT NULL,
	slide_design INTEGER NOT NULL,
	slide_se INTEGER NOT NULL,
	slide_size INTEGER NOT NULL,
	slide_speed INTEGER NOT NULL,
	slide_volume INTEGER NOT NULL,
	sort_music INTEGER NOT NULL,
	sort_tab INTEGER NOT NULL,
	star_rotate INTEGER NOT NULL,
	star_type INTEGER NOT NULL,
	submonitor_achive INTEGER NOT NULL,
	submonitor_animation INTEGER NOT NULL,
	submonitor_appeal INTEGER NOT NULL,
	tap_design INTEGER NOT NULL,
	tap_hold_volume INTEGER NOT NULL,
	touch_effect INTEGER NOT NULL,
	touch_hold_volume INTEGER NOT NULL,
	touch_size INTEGER NOT NULL,
	touch_speed INTEGER NOT NULL,
	track_skip INTEGER NOT NULL,
    user_id bigint references mai2_user_data (id) ON DELETE CASCADE,
    PRIMARY KEY (
         id
    )
);

CREATE TABLE mai2_user_udemae
(
	id INTEGER,
	lose_num INTEGER NOT NULL,
	max_lose_num INTEGER NOT NULL,
	max_win_num INTEGER NOT NULL,
	npc_lose_num INTEGER NOT NULL,
	npc_max_lose_num INTEGER NOT NULL,
	npc_max_win_num INTEGER NOT NULL,
	npc_total_lose_num INTEGER NOT NULL,
	npc_total_win_num INTEGER NOT NULL,
	npc_win_num INTEGER NOT NULL,
	rate INTEGER NOT NULL,
	total_lose_num INTEGER NOT NULL,
	total_win_num INTEGER NOT NULL,
	win_num INTEGER NOT NULL,
    user_id bigint references mai2_user_data (id) ON DELETE CASCADE,
    PRIMARY KEY (
         id
    )
);

CREATE TABLE mai2_user_playlog
(
	id INTEGER,
	achievement INTEGER NOT NULL,
	after_delux_rating INTEGER NOT NULL,
	after_grade INTEGER NOT NULL,
	after_grade_rank INTEGER NOT NULL,
	after_rating INTEGER NOT NULL,
	before_delux_rating INTEGER NOT NULL,
	before_grade INTEGER NOT NULL,
	before_rating INTEGER NOT NULL,
	break_critical_perfect INTEGER NOT NULL,
	break_good INTEGER NOT NULL,
	break_great INTEGER NOT NULL,
	break_miss INTEGER NOT NULL,
	break_perfect INTEGER NOT NULL,
	character_awakening1 INTEGER NOT NULL,
	character_awakening2 INTEGER NOT NULL,
	character_awakening3 INTEGER NOT NULL,
	character_awakening4 INTEGER NOT NULL,
	character_awakening5 INTEGER NOT NULL,
	character_id1 INTEGER NOT NULL,
	character_id2 INTEGER NOT NULL,
	character_id3 INTEGER NOT NULL,
	character_id4 INTEGER NOT NULL,
	character_id5 INTEGER NOT NULL,
	character_level1 INTEGER NOT NULL,
	character_level2 INTEGER NOT NULL,
	character_level3 INTEGER NOT NULL,
	character_level4 INTEGER NOT NULL,
	character_level5 INTEGER NOT NULL,
	combo_status INTEGER NOT NULL,
	deluxscore INTEGER NOT NULL,
	fast_count INTEGER NOT NULL,
	hold_critical_perfect INTEGER NOT NULL,
	hold_good INTEGER NOT NULL,
	hold_great INTEGER NOT NULL,
	hold_miss INTEGER NOT NULL,
	hold_perfect INTEGER NOT NULL,
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
	late_count INTEGER NOT NULL,
	level INTEGER NOT NULL,
	login_date bigINTEGER NOT NULL,
	max_combo INTEGER NOT NULL,
	max_sync INTEGER NOT NULL,
	music_id INTEGER NOT NULL,
	place_name varchar(255) null,
	played_music_level1 INTEGER NOT NULL,
	played_music_level2 INTEGER NOT NULL,
	played_music_level3 INTEGER NOT NULL,
	played_user_id1 bigINTEGER NOT NULL,
	played_user_id2 bigINTEGER NOT NULL,
	played_user_id3 bigINTEGER NOT NULL,
	played_user_name1 varchar(255) null,
	played_user_name2 varchar(255) null,
	played_user_name3 varchar(255) null,
	player_num INTEGER NOT NULL,
	score_rank INTEGER NOT NULL,
	slide_critical_perfect INTEGER NOT NULL,
	slide_good INTEGER NOT NULL,
	slide_great INTEGER NOT NULL,
	slide_miss INTEGER NOT NULL,
	slide_perfect INTEGER NOT NULL,
	sync_status INTEGER NOT NULL,
	tap_critical_perfect INTEGER NOT NULL,
	tap_good INTEGER NOT NULL,
	tap_great INTEGER NOT NULL,
	tap_miss INTEGER NOT NULL,
	tap_perfect INTEGER NOT NULL,
	total_combo INTEGER NOT NULL,
	total_sync INTEGER NOT NULL,
	touch_critical_perfect INTEGER NOT NULL,
	touch_good INTEGER NOT NULL,
	touch_great INTEGER NOT NULL,
	touch_miss INTEGER NOT NULL,
	touch_perfect INTEGER NOT NULL,
	track_no INTEGER NOT NULL,
	type INTEGER NOT NULL,
	user_play_date varchar(255) null,
	vs_mode INTEGER NOT NULL,
	vs_rank INTEGER NOT NULL,
	vs_status INTEGER NOT NULL,
	vs_user_achievement INTEGER NOT NULL,
	vs_user_grade_rank INTEGER NOT NULL,
	vs_user_name varchar(255) null,
	vs_user_rating INTEGER NOT NULL,
    user_id bigint references mai2_user_data (id) ON DELETE CASCADE,
    PRIMARY KEY (
         id
    )
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