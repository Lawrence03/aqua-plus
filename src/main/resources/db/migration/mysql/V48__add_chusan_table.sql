create table if not exists c3_user_data
(
    id                               bigint auto_increment primary key,
    player_id                        bigint null,
    access_code                      text   not null,
    user_name                        text   not null,
    level                            int    not null,
    reincarnation_num                int    not null,
    exp                              int    not null,
    point                            int    not null,
    total_point                      int    not null,
    play_count                       int    not null,
    multi_play_count                 int    not null,
    player_rating                    int    not null,
    highest_rating                   int    not null,
    nameplate_id                     int    not null,
    frame_id                         int    not null,
    character_id                     int    not null,
    trophy_id                        int    not null,
    played_tutorial_bit              int    not null,
    first_tutorial_cancel_num        int    not null,
    master_tutorial_cancel_num       int    not null,
    total_map_num                    int    not null,
    total_hi_score                   int    not null,
    total_basic_high_score           int    not null,
    total_advanced_high_score        int    not null,
    total_expert_high_score          int    not null,
    total_master_high_score          int    not null,
    total_ultima_high_score          int    not null,
    event_watched_date               text   not null,
    friend_count                     int    not null,
    first_game_id                    text   not null,
    first_rom_version                text   not null,
    first_data_version               text   not null,
    first_play_date                  text   not null,
    last_game_id                     text   not null,
    last_rom_version                 text   not null,
    last_data_version                text   not null,
    last_play_date                   text   not null,
    last_place_id                    int    not null,
    last_place_name                  text   not null,
    last_region_id                   int    not null,
    last_region_name                 text   not null,
    last_all_net_id                  int    not null,
    last_client_id                   text   not null,
    last_country_code                text   not null,
    user_name_ex                     text   not null,
    compatible_cm_version            text   not null,
    medal                            int    not null,
    map_icon_id                      int    not null,
    voice_id                         int    not null,
    avatar_wear                      int    not null,
    avatar_head                      int    not null,
    avatar_face                      int    not null,
    avatar_skin                      int    not null,
    avatar_item                      int    not null,
    avatar_front                     int    not null,
    avatar_back                      int    not null,
    class_emblem_base                int    not null,
    class_emblem_medal               int    not null,
    stocked_grid_count               int    not null,
    ex_map_loop_count                int    not null,
    net_battle_play_count            int    not null,
    net_battle_win_count             int    not null,
    net_battle_lose_count            int    not null,
    net_battle_consecutive_win_count int    not null,
    chara_illust_id                  int    not null,
    skill_id                         int    not null,
    over_power_point                 int    not null,
    over_power_rate                  int    not null,
    over_power_lower_rank            int    not null,
    avatar_point                     int    not null,
    battle_rank_id                   int    not null,
    battle_rank_point                int    not null,
    elite_rank_point                 int    not null,
    net_battle1st_count              int    not null,
    net_battle2nd_count              int    not null,
    net_battle3rd_count              int    not null,
    net_battle4th_count              int    not null,
    net_battle_correction            int    not null,
    net_battle_err_cnt               int    not null,
    net_battle_host_err_cnt          int    not null,
    battle_reward_status             int    not null,
    battle_reward_index              int    not null,
    battle_reward_count              int    not null,
    ext1                             int    not null,
    ext2                             int    not null,
    ext3                             int    not null,
    ext4                             int    not null,
    ext5                             int    not null,
    ext6                             int    not null,
    ext7                             int    not null,
    ext8                             int    not null,
    ext9                             int    not null,
    ext10                            int    not null,
    ext_str1                         text   not null,
    ext_str2                         text   not null,
    ext_long1                        int    not null,
    ext_long2                        int    not null,
    rank_up_challenge_results        text   not null,
    foreign key (player_id) references sega_card (id)
);

create table if not exists c3_user_game_option
(
    id                      bigint auto_increment primary key,
    profile_id              bigint null,
    bg_info                 int    not null,
    field_color             int    not null,
    guide_sound             int    not null,
    sound_effect            int    not null,
    guide_line              int    not null,
    speed                   int    not null,
    option_set              int    not null,
    matching                int    not null,
    judge_pos               int    not null,
    rating                  int    not null,
    judge_critical          int    not null,
    judge_justice           int    not null,
    judge_attack            int    not null,
    headphone               int    not null,
    player_level            int    not null,
    success_tap             int    not null,
    success_ex_tap          int    not null,
    success_slide_hold      int    not null,
    success_air             int    not null,
    success_flick           int    not null,
    success_skill           int    not null,
    success_tap_timbre      int    not null,
    privacy                 int    not null,
    mirror_fumen            int    not null,
    select_music_filter_lv  int    not null,
    sort_music_filter_lv    int    not null,
    sort_music_genre        int    not null,
    category_detail         int    not null,
    judge_timing_offset     int    not null,
    play_timing_offset      int    not null,
    field_wall_position     int    not null,
    result_voice_short      int    not null,
    notes_thickness         int    not null,
    judge_append_se         int    not null,
    track_skip              int    not null,
    hard_judge              int    not null,
    speed_120               int    not null,
    field_wall_position_120 int    not null,
    play_timing_offset_120  int    not null,
    judge_timing_offset_120 int    not null,
    ext1                    int    not null,
    ext2                    int    not null,
    ext3                    int    not null,
    ext4                    int    not null,
    ext5                    int    not null,
    ext6                    int    not null,
    ext7                    int    not null,
    ext8                    int    not null,
    ext9                    int    not null,
    ext10                   int    not null,
    foreign key (profile_id) references c3_user_data (id)
);

create table if not exists c3_user_activity
(
    id          bigint auto_increment primary key,
    profile_id  bigint null,
    kind        int    not null,
    activity_id int    not null,
    sort_number int    not null,
    param1      int    not null,
    param2      int    not null,
    param3      int    not null,
    param4      int    not null,
    constraint c3_user_activity_uq unique (
                                           profile_id,
                                           kind,
                                           activity_id
        ),
    foreign key (profile_id) references c3_user_data (id)
);

create table if not exists c3_user_character
(
    id             bigint auto_increment primary key,
    profile_id     bigint null,
    character_id   int    not null,
    play_count     int    not null,
    level          int    not null,
    friendship_exp int    not null,
    is_valid       text   not null,
    is_new_mark    text   not null,
    ex_max_lv      int    not null,
    assign_illust  int    not null,
    param1         int    not null,
    param2         int    not null,
    constraint c3_user_character_uq unique (profile_id, character_id),
    foreign key (profile_id) references c3_user_data (id)
);

create table if not exists c3_user_course
(
    id             bigint auto_increment primary key,
    profile_id     bigint null,
    course_id      int    not null,
    class_id       int    not null,
    play_count     int    not null,
    theory_count   int    not null,
    score_max      int    not null,
    is_full_combo  text   not null,
    is_all_justice text   not null,
    is_success     text   not null,
    score_rank     int    not null,
    event_id       int    not null,
    last_play_date text   not null,
    param1         int    not null,
    param2         int    not null,
    param3         int    not null,
    param4         int    not null,
    order_id       int    not null,
    player_rating  int    not null,
    is_clear       text   not null,
    constraint c3_user_course_uq unique (profile_id, course_id),
    foreign key (profile_id) references c3_user_data (id)
);

create table if not exists c3_user_duel_list
(
    id             bigint auto_increment primary key,
    profile_id     bigint  null,
    duel_id        int     not null,
    progress       int     not null,
    point          int     not null,
    is_clear       boolean not null,
    last_play_date text    not null,
    param1         int     not null,
    param2         int     not null,
    param3         int     not null,
    param4         int     not null,
    constraint c3_user_duel_list_uq unique (profile_id, duel_id),
    foreign key (profile_id) references c3_user_data (id)
);

create table if not exists c3_user_item
(
    id         bigint auto_increment primary key,
    profile_id bigint null,
    item_kind  int    not null,
    item_id    int    not null,
    stock      int    not null,
    is_valid   text   not null,
    constraint c3_user_item_uq unique (profile_id, item_kind, item_id),
    foreign key (profile_id) references c3_user_data (id)
);

create table if not exists c3_user_map_area
(
    id                bigint auto_increment primary key,
    profile_id        bigint null,
    map_area_id       int    not null,
    position          int    not null,
    is_clear          text   not null,
    rate              int    not null,
    status_count      int    not null,
    remain_grid_count text   not null,
    is_locked         text   not null,
    constraint c3_user_map_area_uq unique (profile_id, map_area_id),
    foreign key (profile_id) references c3_user_data (id)
);

create table if not exists c3_user_music
(
    id              bigint auto_increment primary key,
    profile_id      bigint null,
    music_id        int    not null,
    level           int    not null,
    play_count      int    not null,
    score_max       int    not null,
    miss_count      int    not null,
    max_combo_count int    not null,
    is_full_combo   text   not null,
    is_all_justice  text   not null,
    is_success      text   not null,
    full_chain      int    not null,
    max_chain       int    not null,
    score_rank      int    not null,
    is_lock         text   not null,
    theory_count    int    not null,
    ext1            int    not null,
    constraint c3_user_music_uq unique (profile_id, music_id, level),
    foreign key (profile_id) references c3_user_data (id)
);

create table if not exists c3_user_playlog
(
    id                  bigint auto_increment primary key,
    profile_id          bigint null,
    rom_version         text   not null,
    order_id            int    not null,
    sort_number         int    not null,
    place_id            int    not null,
    play_date           text   not null,
    user_play_date      text   not null,
    music_id            int    not null,
    level               int    not null,
    custom_id           int    not null,
    played_user_id1     int    not null,
    played_user_id2     int    not null,
    played_user_id3     int    not null,
    played_user_name1   text   not null,
    played_user_name2   text   not null,
    played_user_name3   text   not null,
    played_music_level1 int    not null,
    played_music_level2 int    not null,
    played_music_level3 int    not null,
    played_custom1      int    not null,
    played_custom2      int    not null,
    played_custom3      int    not null,
    track               int    not null,
    score               int    not null,
    rank                int    not null,
    max_combo           int    not null,
    max_chain           int    not null,
    rate_tap            int    not null,
    rate_hold           int    not null,
    rate_slide          int    not null,
    rate_air            int    not null,
    rate_flick          int    not null,
    judge_guilty        int    not null,
    judge_attack        int    not null,
    judge_justice       int    not null,
    judge_critical      int    not null,
    judge_heaven        int    not null,
    event_id            int    not null,
    player_rating       int    not null,
    is_new_record       text   not null,
    is_full_combo       text   not null,
    full_chain_kind     int    not null,
    is_all_justice      text   not null,
    is_continue         text   not null,
    is_free_to_play     text   not null,
    character_id        int    not null,
    chara_illust_id     int    not null,
    skill_id            int    not null,
    play_kind           int    not null,
    is_clear            text   not null,
    skill_level         int    not null,
    skill_effect        int    not null,
    place_name          text   not null,
    common_id           int    not null,
    foreign key (profile_id) references c3_user_data (id)
);

create table if not exists c3_user_charge
(
    id            bigint auto_increment primary key,
    profile_id    bigint null,
    charge_id     int    not null,
    stock         int    not null,
    purchase_date text   not null,
    valid_date    text   not null,
    param1        int    not null,
    param2        int    not null,
    param_date    text   not null,
    constraint c3_user_charge_uq unique (profile_id, charge_id),
    foreign key (profile_id) references c3_user_data (id)
);

create table if not exists c3_user_recent_rating
(
    id               bigint auto_increment primary key,
    profile_id       bigint null,
    sort_order       int    not null,
    music_id         int    not null,
    difficult_id     int    not null,
    rom_version_code int    not null,
    score            int    not null,
    constraint c3_user_recent_rating_uq unique (profile_id, sort_order),
    foreign key (profile_id) references c3_user_data (id)
);

create table if not exists c3_user_region
(
    id         int    NOT NULL,
    profile_id bigint NULL,
    region_id  int    NOT NULL,
    play_count int,
    created    text   NOT NULL,
    primary key (id),
    foreign key (profile_id) references c3_user_data (id),
    constraint c3_user_region_uq unique (profile_id, region_id)
);

create table if not exists c3_user_general_data
(
    id             bigint auto_increment primary key,
    profile_id     bigint       null,
    property_key   varchar(255) not null,
    property_value text         not null,
    constraint c3_user_general_data_uq unique (profile_id, property_key),
    foreign key (profile_id) references c3_user_data (id)
);

create table if not exists c3_game_charge
(
    id              bigint auto_increment primary key,
    charge_id       int  not null,
    end_date        text not null,
    order_id        int  not null,
    price           int  not null,
    sale_end_date   text not null,
    sale_price      text not null,
    sale_start_date text not null,
    start_date      text not null
);

insert ignore into c3_game_charge (id, charge_id, end_date, order_id, price, sale_end_date, sale_price, sale_start_date,
                                   start_date)
values (1, 2080, '2077-01-01 00:00:00.000000', 0, 1, '2077-01-01 00:00:00.000000', 1, '2021-01-01 00:00:00.000000',
        '2021-01-01 00:00:00.000000');
insert ignore into c3_game_charge (id, charge_id, end_date, order_id, price, sale_end_date, sale_price, sale_start_date,
                                   start_date)
values (2, 2230, '2077-01-01 00:00:00.000000', 1, 1, '2077-01-01 00:00:00.000000', 1, '2021-01-01 00:00:00.000000',
        '2021-01-01 00:00:00.000000');
insert ignore into c3_game_charge (id, charge_id, end_date, order_id, price, sale_end_date, sale_price, sale_start_date,
                                   start_date)
values (3, 2410, '2077-01-01 00:00:00.000000', 2, 1, '2077-01-01 00:00:00.000000', 1, '2021-01-01 00:00:00.000000',
        '2021-01-01 00:00:00.000000');

create table if not exists c3_game_event
(
    id         bigint auto_increment primary key,
    end_date   text not null,
    start_date text not null,
    type       int  not null,
    enable     text not null
);

create table if not exists c3_game_message
(
    id         bigint auto_increment primary key,
    end_date   text null,
    message    text null,
    start_date text null,
    type       int  not null
);

create table if not exists c3_user_team
(
    id         bigint auto_increment primary key,
    profile_id bigint null,
    team_name  text   null,
    foreign key (profile_id) references c3_user_data (id)
);

DELIMITER //
CREATE TRIGGER c3_user_region_update
    AFTER UPDATE
    ON c3_user_data
    FOR EACH ROW
BEGIN
    INSERT IGNORE INTO c3_user_region (id, profile_id, region_id, play_count, created)
    VALUES (abs(rand()), NEW.id, NEW.last_region_id, 0, date_format(now(), '%Y-%m-%d %H:%i:%m'));
    UPDATE c3_user_region set play_count = play_count + 1 WHERE profile_id = NEW.id AND region_id = NEW.last_region_id;
END;
//
DELIMITER ;
