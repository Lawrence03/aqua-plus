alter table mai2_user_data add column `chara_lock_slot` varchar(255) null;
alter table mai2_user_data add column `partner_id` integer not null default 1;

create table mai2_user_login_bonus (
    id  integer,
    bonus_id integer not null,
    is_complete boolean not null,
    is_current boolean not null,
    point integer not null,
    user_id bigint references mai2_user_data (id) ON DELETE CASCADE,
    primary key (id)
)