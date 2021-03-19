ALTER TABLE mai2_user_data ADD date_time BIGINT DEFAULT 0;
ALTER TABLE mai2_user_extend ADD extend_content_bit BIGINT DEFAULT 0;
ALTER TABLE mai2_user_extend ADD is_photo_agree BOOLEAN DEFAULT false;
ALTER TABLE mai2_user_extend ADD is_goto_code_read BOOLEAN DEFAULT false;
