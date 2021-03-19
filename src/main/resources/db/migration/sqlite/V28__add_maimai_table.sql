-- Table: maimai_game_event
CREATE TABLE maimai_game_event (
    id         BIGINT,
    end_date   VARCHAR (255),
    event_id   INTEGER       NOT NULL,
    start_date VARCHAR (255),
    type       INTEGER       NOT NULL,
    PRIMARY KEY (
        id
    )
);

-- Table: maimai_user_data
CREATE TABLE maimai_user_data (
    id                         BIGINT,
    challenge_track_phase      INTEGER       NOT NULL,
    combo_count                INTEGER       NOT NULL,
    event_point                INTEGER       NOT NULL,
    event_watched_date         VARCHAR (255),
    fever_count                INTEGER       NOT NULL,
    first_play_bits            INTEGER       NOT NULL,
    frame_id                   INTEGER       NOT NULL,
    help_count                 INTEGER       NOT NULL,
    highest_rating             INTEGER       NOT NULL,
    icon_id                    INTEGER       NOT NULL,
    last_client_id             VARCHAR (255),
    last_country_code          VARCHAR (255),
    last_data_version          INTEGER       NOT NULL,
    last_login_bonus_day       INTEGER       NOT NULL,
    last_place_id              INTEGER       NOT NULL,
    last_place_name            VARCHAR (255),
    last_play_date             VARCHAR (255),
    last_region_id             INTEGER       NOT NULL,
    last_region_name           VARCHAR (255),
    last_survival_bonus_day    INTEGER       NOT NULL,
    login_bonus_lv             INTEGER       NOT NULL,
    nameplate_id               INTEGER       NOT NULL,
    play_count                 INTEGER       NOT NULL,
    play_sync_count            INTEGER       NOT NULL,
    play_vs_count              INTEGER       NOT NULL,
    player_rating              INTEGER       NOT NULL,
    point                      INTEGER       NOT NULL,
    rank_auth_tail_id          INTEGER       NOT NULL,
    total_advanced_high_score  INTEGER       NOT NULL,
    total_advanced_sync        INTEGER       NOT NULL,
    total_basic_high_score     INTEGER       NOT NULL,
    total_basic_sync           INTEGER       NOT NULL,
    total_easy_high_score      INTEGER       NOT NULL,
    total_easy_sync            INTEGER       NOT NULL,
    total_expert_high_score    INTEGER       NOT NULL,
    total_expert_sync          INTEGER       NOT NULL,
    total_hi_score             INTEGER       NOT NULL,
    total_high_sync            INTEGER       NOT NULL,
    total_lv                   INTEGER       NOT NULL,
    total_master_high_score    INTEGER       NOT NULL,
    total_master_sync          INTEGER       NOT NULL,
    total_point                INTEGER       NOT NULL,
    total_re_master_high_score INTEGER       NOT NULL,
    total_re_master_sync       INTEGER       NOT NULL,
    trophy_id                  INTEGER       NOT NULL,
    user_name                  VARCHAR (255),
    web_limit_date             VARCHAR (255),
    win_count                  INTEGER       NOT NULL,
    aime_card_id               BIGINT REFERENCES sega_card (id),
    PRIMARY KEY (
        id
    )
);

-- Table: maimai_user_activity
CREATE TABLE maimai_user_activity (
    id          BIGINT,
    activity_id INTEGER NOT NULL,
    kind        INTEGER NOT NULL,
    param1      INTEGER NOT NULL,
    param2      INTEGER NOT NULL,
    param3      INTEGER NOT NULL,
    param4      INTEGER NOT NULL,
    sort_number BIGINT  NOT NULL,
    user_id     BIGINT REFERENCES maimai_user_data (id) ON DELETE CASCADE,
    PRIMARY KEY (
        id
    )
);

-- Table: maimai_user_boss
CREATE TABLE maimai_user_boss (
    id                 BIGINT,
    emblem_flag_list   BIGINT  NOT NULL,
    pandora_flag_list0 BIGINT  NOT NULL,
    pandora_flag_list1 BIGINT  NOT NULL,
    pandora_flag_list2 BIGINT  NOT NULL,
    pandora_flag_list3 BIGINT  NOT NULL,
    pandora_flag_list4 BIGINT  NOT NULL,
    pandora_flag_list5 BIGINT  NOT NULL,
    pandora_flag_list6 BIGINT  NOT NULL,
    user_id            BIGINT REFERENCES maimai_user_data (id) ON DELETE CASCADE,
    PRIMARY KEY (
        id
    )
);


-- Table: maimai_user_character
CREATE TABLE maimai_user_character (
    id           BIGINT,
    character_id INTEGER NOT NULL,
    level        INTEGER NOT NULL,
    point        INTEGER NOT NULL,
    user_id      BIGINT REFERENCES maimai_user_data (id) ON DELETE CASCADE,
    PRIMARY KEY (
        id
    )
);




-- Table: maimai_user_general_data
CREATE TABLE maimai_user_general_data (
    id             BIGINT,
    property_key   VARCHAR (255),
    property_value VARCHAR (255),
    user_id        BIGINT REFERENCES maimai_user_data (id) ON DELETE CASCADE,
    PRIMARY KEY (
        id
    )
);


-- Table: maimai_user_item
CREATE TABLE maimai_user_item (
    id        BIGINT,
    item_id   INTEGER NOT NULL,
    item_kind INTEGER NOT NULL,
    stock     INTEGER NOT NULL,
    user_id   BIGINT REFERENCES maimai_user_data (id) ON DELETE CASCADE,
    PRIMARY KEY (
        id
    )
);


-- Table: maimai_user_music_detail
CREATE TABLE maimai_user_music_detail (
    id                  BIGINT,
    achievement         INTEGER NOT NULL,
    full_combo          INTEGER NOT NULL,
    is_all_perfect      BOOLEAN NOT NULL,
    is_all_perfect_plus INTEGER NOT NULL,
    level               INTEGER NOT NULL,
    max_fever           INTEGER NOT NULL,
    music_id            INTEGER NOT NULL,
    play_count          INTEGER NOT NULL,
    score_max           INTEGER NOT NULL,
    sync_rate_max       INTEGER NOT NULL,
    user_id             BIGINT REFERENCES maimai_user_data (id) ON DELETE CASCADE,
    PRIMARY KEY (
        id
    )
);


-- Table: maimai_user_option
CREATE TABLE maimai_user_option (
    id                    BIGINT,
    adjust_timing         INTEGER NOT NULL,
    ans_vol               INTEGER NOT NULL,
    appeal_flame          INTEGER NOT NULL,
    bg_info               INTEGER NOT NULL,
    break_se              INTEGER NOT NULL,
    break_se_vol          INTEGER NOT NULL,
    brightness            INTEGER NOT NULL,
    disp_judge            INTEGER NOT NULL,
    disp_timing           INTEGER NOT NULL,
    dmg_vol               INTEGER NOT NULL,
    filter_all_perfect    INTEGER NOT NULL,
    filter_difficulty     INTEGER NOT NULL,
    filter_full_combo     INTEGER NOT NULL,
    filter_full_sync      INTEGER NOT NULL,
    filter_genre          INTEGER NOT NULL,
    filter_level          INTEGER NOT NULL,
    filter_max_fever      INTEGER NOT NULL,
    filter_rank           INTEGER NOT NULL,
    filter_re_master      INTEGER NOT NULL,
    filter_rec            INTEGER NOT NULL,
    filter_version        INTEGER NOT NULL,
    final_select_category INTEGER NOT NULL,
    final_select_id       INTEGER NOT NULL,
    guide_speed           INTEGER NOT NULL,
    hard_judge            INTEGER NOT NULL,
    is_fever_disp         INTEGER NOT NULL,
    is_star_rot           INTEGER NOT NULL,
    is_tag_jump           INTEGER NOT NULL,
    is_upper_disp         INTEGER NOT NULL,
    judge_pos             INTEGER NOT NULL,
    mirror_mode           INTEGER NOT NULL,
    note_vol              INTEGER NOT NULL,
    option_mode           INTEGER NOT NULL,
    rating_guard          INTEGER NOT NULL,
    select_chara          INTEGER NOT NULL,
    simple_option_param   INTEGER NOT NULL,
    slide_se              INTEGER NOT NULL,
    slide_se_vol          INTEGER NOT NULL,
    sort_type             INTEGER NOT NULL,
    soud_effect           INTEGER NOT NULL,
    timing_pos            INTEGER NOT NULL,
    track_skip            INTEGER NOT NULL,
    user_id               BIGINT REFERENCES maimai_user_data (id) ON DELETE CASCADE,
    PRIMARY KEY (
        id
    )
);


-- Table: maimai_user_playlog
CREATE TABLE maimai_user_playlog (
    id                  BIGINT,
    achievement         INTEGER       NOT NULL,
    break_bad           INTEGER       NOT NULL,
    break_good          INTEGER       NOT NULL,
    break_great         INTEGER       NOT NULL,
    break_perfect       INTEGER       NOT NULL,
    break_score         INTEGER       NOT NULL,
    challenge_life      INTEGER       NOT NULL,
    challenge_remain    INTEGER       NOT NULL,
    country             VARCHAR (255),
    event_id            INTEGER       NOT NULL,
    full_combo          INTEGER       NOT NULL,
    game_mode           INTEGER       NOT NULL,
    hold_bad            INTEGER       NOT NULL,
    hold_good           INTEGER       NOT NULL,
    hold_great          INTEGER       NOT NULL,
    hold_perfect        INTEGER       NOT NULL,
    hold_score          INTEGER       NOT NULL,
    is_all_perfect      BOOLEAN       NOT NULL,
    is_all_perfect_plus INTEGER       NOT NULL,
    is_challenge_track  BOOLEAN       NOT NULL,
    is_free_to_play     BOOLEAN       NOT NULL,
    is_high_score       BOOLEAN       NOT NULL,
    is_track_skip       BOOLEAN       NOT NULL,
    level               INTEGER       NOT NULL,
    max_combo           INTEGER       NOT NULL,
    max_fever           INTEGER       NOT NULL,
    music_id            INTEGER       NOT NULL,
    order_id            INTEGER       NOT NULL,
    place_id            INTEGER       NOT NULL,
    place_name          VARCHAR (255),
    play_date           VARCHAR (255),
    played_music_level1 INTEGER       NOT NULL,
    played_music_level2 INTEGER       NOT NULL,
    played_music_level3 INTEGER       NOT NULL,
    played_user_id1     BIGINT        NOT NULL,
    played_user_id2     BIGINT        NOT NULL,
    played_user_id3     BIGINT        NOT NULL,
    played_user_name1   VARCHAR (255),
    played_user_name2   VARCHAR (255),
    played_user_name3   VARCHAR (255),
    player_rating       INTEGER       NOT NULL,
    region_id           INTEGER       NOT NULL,
    rival_num           INTEGER       NOT NULL,
    score               INTEGER       NOT NULL,
    slide_bad           INTEGER       NOT NULL,
    slide_good          INTEGER       NOT NULL,
    slide_great         INTEGER       NOT NULL,
    slide_perfect       INTEGER       NOT NULL,
    slide_score         INTEGER       NOT NULL,
    sort_number         BIGINT        NOT NULL,
    sync_rate           INTEGER       NOT NULL,
    tap_bad             INTEGER       NOT NULL,
    tap_good            INTEGER       NOT NULL,
    tap_great           INTEGER       NOT NULL,
    tap_perfect         INTEGER       NOT NULL,
    tap_score           INTEGER       NOT NULL,
    track               INTEGER       NOT NULL,
    user_play_date      VARCHAR (255),
    vs_win              INTEGER       NOT NULL,
    user_id             BIGINT REFERENCES maimai_user_data (id) ON DELETE CASCADE,
    PRIMARY KEY (
        id
    )
);


-- Table: maimai_user_present_event
CREATE TABLE maimai_user_present_event (
    id               BIGINT,
    point            INTEGER NOT NULL,
    present_count    INTEGER NOT NULL,
    present_event_id INTEGER NOT NULL,
    rate             INTEGER NOT NULL,
    user_id          BIGINT REFERENCES maimai_user_data (id) ON DELETE CASCADE,
    PRIMARY KEY (
        id
    )
);


-- Table: maimai_user_survival
CREATE TABLE maimai_user_survival (
    id            BIGINT,
    is_clear      BOOLEAN NOT NULL,
    is_no_damage  BOOLEAN NOT NULL,
    survival_id   INTEGER NOT NULL,
    total_achieve INTEGER NOT NULL,
    total_score   INTEGER NOT NULL,
    user_id       BIGINT REFERENCES maimai_user_data (id) ON DELETE CASCADE,
    PRIMARY KEY (
        id
    )
);


-- Table: maimai_user_web_option
CREATE TABLE maimai_user_web_option (
    id               BIGINT,
    disp_home_ranker INTEGER NOT NULL,
    disp_judge_style INTEGER NOT NULL,
    disp_rank        INTEGER NOT NULL,
    disp_rate        INTEGER NOT NULL,
    disp_total_lv    INTEGER NOT NULL,
    is_net_member    BOOLEAN NOT NULL,
    user_id          BIGINT REFERENCES maimai_user_data (id) ON DELETE CASCADE,
    PRIMARY KEY (
        id
    )
);