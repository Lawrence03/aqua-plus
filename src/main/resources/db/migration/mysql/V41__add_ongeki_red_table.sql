create table ongeki_game_tech_music
(
	id bigint auto_increment
		primary key,
	event_id int not null,
	music_id int not null,
	level int not null,
    constraint ongeki_game_tech_music_uq
        unique (event_id, music_id)
);

ALTER TABLE `ongeki_user_data`
    ADD COLUMN `medal_count` int(11) DEFAULT 0,
    ADD COLUMN `character_voice_no` int(11) DEFAULT 0,
    ADD COLUMN `cm_event_watched_date` text;

ALTER TABLE `ongeki_user_option`
    ADD COLUMN `platinum_break_disp` int(11) DEFAULT 0,
    ADD COLUMN `judge_critical_break` int(11) DEFAULT 0;

ALTER TABLE `ongeki_user_character`
    ADD COLUMN `costume_id` int(11) DEFAULT 0;

ALTER TABLE `ongeki_user_data`
    ADD COLUMN `last_update_date` text;
