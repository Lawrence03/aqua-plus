alter table mai2_user_data add column `chara_lock_slot` varchar(255) null;
alter table mai2_user_data add column `partner_id` integer not null default 1;

create table mai2_user_login_bonus (
    id bigint auto_increment primary key,
    bonus_id integer not null,
    is_complete bit not null,
    is_current bit not null,
    point integer not null,
    user_id bigint,
    constraint FKomf8tgjucdvdgfidlrfegldu9
    foreign key (user_id)
    references mai2_user_data (id)
)