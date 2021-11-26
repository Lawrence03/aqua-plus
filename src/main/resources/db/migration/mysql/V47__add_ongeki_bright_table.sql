-- left over from 1.25
ALTER TABLE `ongeki_user_character`
    ADD COLUMN `attachment_id` int(11) DEFAULT 0;

ALTER TABLE `ongeki_user_data`
    ADD COLUMN `best_battle_point` int(11) DEFAULT 0,
    ADD COLUMN `over_damage_battle_point` int(11) DEFAULT 0,
    ADD COLUMN `rival_score_category_setting` int(11) DEFAULT 0,
    ADD COLUMN `last_emoney_brand` int(11) DEFAULT 0;

ALTER TABLE `ongeki_user_option`
    ADD COLUMN `judge_adjustment` int(11) DEFAULT 0,
    ADD COLUMN `stealth_field` int(11) DEFAULT 0,
    ADD COLUMN `color_wall_bright` int(11) DEFAULT 3;


