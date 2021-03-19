ALTER TABLE mai2_user_playlog ADD COLUMN `playlog_id` BIGINT NOT NULL DEFAULT 0;
ALTER TABLE mai2_user_playlog ADD COLUMN `version` BIGINT NOT NULL DEFAULT 0;
ALTER TABLE mai2_user_playlog ADD COLUMN `is_photo_upload` BOOLEAN NOT NULL DEFAULT false;

CREATE TABLE mai2_user_photo_log
(
    id         bigint auto_increment
        primary key,
    place_id  int          not null,
    upload_date      varchar(255) null,
    playlog_id bigint not null,
    track_no   int          null,
	user_id bigint null,
	constraint FKdahthb9dtjsl7xhb5pn8s1yhx
		foreign key (user_id) references mai2_user_data (id)
);

CREATE TABLE mai2_user_portrait
(
    id         bigint auto_increment
        primary key,
    user_id  int          not null,
    div_number  int          not null,
    div_length  int          not null,
    div_data      TEXT null,
    place_id  int          not null,
    client_id  VARCHAR(255)  null,
    upload_date  VARCHAR(255)  null,
    file_name  VARCHAR(255)  null
);

CREATE TABLE mai2_user_session
(
    id         bigint auto_increment
        primary key,
    start_date      varchar(255) null,
	user_id bigint null,
	constraint FKbnmwpb9dtjsl7xh3dpn8s1yhx
		foreign key (user_id) references mai2_user_data (id)
);