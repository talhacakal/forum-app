INSERT INTO `user` (`create_date`, `email`, `last_update_date`, `uuid`) VALUES (CURRENT_TIMESTAMP(), 'dev_example@example.com', CURRENT_TIMESTAMP(), '3e42039f-59ab-485a-8739-f0dafd3fcc37');
INSERT INTO `user` (`create_date`, `email`, `last_update_date`, `uuid`) VALUES (CURRENT_TIMESTAMP(), 'admin_example@example.com', CURRENT_TIMESTAMP(), '189d14d4-62a8-4798-add1-9623eb5ca44b');
INSERT INTO `user` (`create_date`, `email`, `last_update_date`, `uuid`) VALUES (CURRENT_TIMESTAMP(), 'user_example@example.com', CURRENT_TIMESTAMP(), 'b6aed89b-c389-4b8e-bba8-e5f64a5f2c50');

INSERT INTO `authentication` (`create_date`, `last_update_date`, `password`, `uuid`) VALUES (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), '$2a$10$5Zm8SaYJpmzm3QXbXo5Gwu252C0o.huqK6JJitYAs9ydAPSwhR686', '3e42039f-59ab-485a-8739-f0dafd3fcc37');
INSERT INTO `authentication` (`create_date`, `last_update_date`, `password`, `uuid`) VALUES (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), '$2a$10$fmGFBa4TdW8A4WEq9eiLQer8KUk0PqetCRGXz1/99ejdTqYFrouWy', '189d14d4-62a8-4798-add1-9623eb5ca44b');
INSERT INTO `authentication` (`create_date`, `last_update_date`, `password`, `uuid`) VALUES (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), '$2a$10$KbU9iEFsxXXlDDbh0/hNieYb9JM2ZnQoVyzdacNNkCpWsIBNaro3a', 'b6aed89b-c389-4b8e-bba8-e5f64a5f2c50');

INSERT INTO `authorization` (`create_date`, `last_update_date`, `uuid`) VALUES (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), '3e42039f-59ab-485a-8739-f0dafd3fcc37');
INSERT INTO `authorization` (`create_date`, `last_update_date`, `uuid`) VALUES (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), '189d14d4-62a8-4798-add1-9623eb5ca44b');
INSERT INTO `authorization` (`create_date`, `last_update_date`, `uuid`) VALUES (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'b6aed89b-c389-4b8e-bba8-e5f64a5f2c50');

INSERT INTO `role` (`create_date`, `last_update_date`, `role`) VALUES (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'ROLE_ADMIN');
INSERT INTO `role` (`create_date`, `last_update_date`, `role`) VALUES (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'ROLE_USER');
INSERT INTO `role` (`create_date`, `last_update_date`, `role`) VALUES (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 'ROLE_DEV');

INSERT INTO `profile` (`name`, `last_name`, `personal_info`, `birth`, `location`, `uuid`, `create_date`, `last_update_date`) VALUES ('Dev', 'User', 'Dev user Profile Info', '03/29/2023', 'Turkey', '3e42039f-59ab-485a-8739-f0dafd3fcc37', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `profile` (`name`, `last_name`, `personal_info`, `birth`, `location`, `uuid`, `create_date`, `last_update_date`) VALUES ('Admin', 'User', 'Admin user Profile Info', '03/29/2023', 'Turkey', '189d14d4-62a8-4798-add1-9623eb5ca44b', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `profile` (`name`, `last_name`, `personal_info`, `birth`, `location`, `uuid`, `create_date`, `last_update_date`) VALUES ('User', 'User', 'User user Profile Info', '03/29/2023', 'Turkey', 'b6aed89b-c389-4b8e-bba8-e5f64a5f2c50', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO `entry` (`content`, `openfcomment`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('Dev Comment 1 - Content', true, 'f597e0dc-802d-420c-bbc4-73e995ce6891', '3e42039f-59ab-485a-8739-f0dafd3fcc37', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `entry` (`content`, `openfcomment`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('Dev Comment 2 - Content', true, 'f3fdd6d5-7672-4f86-b02f-17263bbb2f95', '3e42039f-59ab-485a-8739-f0dafd3fcc37', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `entry` (`content`, `openfcomment`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('Dev Comment 3 - Content', false, '88b3cdac-1e68-4b94-be80-95de9ae8dfea', '3e42039f-59ab-485a-8739-f0dafd3fcc37', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `entry` (`content`, `openfcomment`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('Dev Comment 4 - Content', false, '2267a1e0-c226-420a-82bf-82ac0c44c1a0', '3e42039f-59ab-485a-8739-f0dafd3fcc37', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO `entry` (`content`, `openfcomment`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('Admin Comment 1 - Content', true, 'b4320b3a-0e1d-4c0b-a1eb-85198d7a3252', '189d14d4-62a8-4798-add1-9623eb5ca44b', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `entry` (`content`, `openfcomment`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('Admin Comment 2 - Content', true, '8ec850a5-6cd4-4068-bc2a-50ae3d11affe', '189d14d4-62a8-4798-add1-9623eb5ca44b', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `entry` (`content`, `openfcomment`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('Admin Comment 3 - Content', true, '55bed485-0188-481f-ba0d-042f3b81b7a8', '189d14d4-62a8-4798-add1-9623eb5ca44b', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `entry` (`content`, `openfcomment`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('Admin Comment 4 - Content', false, '381a4db7-d638-4a94-a4a1-dd41b6a66741', '189d14d4-62a8-4798-add1-9623eb5ca44b', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `entry` (`content`, `openfcomment`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('Admin Comment 5 - Content', false, '91053118-e6e9-4dbd-9c33-c04d8897707b', '189d14d4-62a8-4798-add1-9623eb5ca44b', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO `entry` (`content`, `openfcomment`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('User Comment 1 - Content', true, '1621fbf2-baf3-44f2-9c12-6f576fcc8663', 'b6aed89b-c389-4b8e-bba8-e5f64a5f2c50', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `entry` (`content`, `openfcomment`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('User Comment 2 - Content', true, 'cdb60472-4c00-40d7-8aa5-d534b7662e1e', 'b6aed89b-c389-4b8e-bba8-e5f64a5f2c50', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `entry` (`content`, `openfcomment`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('User Comment 3 - Content', true, 'd3e4c297-c05d-4c55-9e6d-17d424096ab4', 'b6aed89b-c389-4b8e-bba8-e5f64a5f2c50', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `entry` (`content`, `openfcomment`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('User Comment 4 - Content', true, 'd5556d45-a5f7-4bcb-8381-c89948f34c45', 'b6aed89b-c389-4b8e-bba8-e5f64a5f2c50', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `entry` (`content`, `openfcomment`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('User Comment 5 - Content', true, '3a0f28f3-c0de-43f7-94fe-e98ced2174b7', 'b6aed89b-c389-4b8e-bba8-e5f64a5f2c50', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `entry` (`content`, `openfcomment`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('User Comment 6 - Content', true, 'ec3b047c-8922-485f-abce-fdf9916ba4b6', 'b6aed89b-c389-4b8e-bba8-e5f64a5f2c50', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `entry` (`content`, `openfcomment`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('User Comment 7 - Content', false, '35bd5104-0996-46c2-8b86-c11fb8640b6b', 'b6aed89b-c389-4b8e-bba8-e5f64a5f2c50', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `entry` (`content`, `openfcomment`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('User Comment 8 - Content', false, '8fa409a5-2032-4147-9bd8-62c77eb37a14', 'b6aed89b-c389-4b8e-bba8-e5f64a5f2c50', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('5e09cf3c-15e8-4deb-9291-d55181c88ea7', 'Dev Comment 1 - comment dev', 'f597e0dc-802d-420c-bbc4-73e995ce6891', '3e42039f-59ab-485a-8739-f0dafd3fcc37', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('c5692861-3814-4a71-8bda-e8facfe62c8a', 'Dev Comment 1 - comment admin', 'f597e0dc-802d-420c-bbc4-73e995ce6891', '189d14d4-62a8-4798-add1-9623eb5ca44b', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('42352867-aa93-4f7a-ab2f-8504c207dbbb', 'Dev Comment 1 - comment user', 'f597e0dc-802d-420c-bbc4-73e995ce6891', 'b6aed89b-c389-4b8e-bba8-e5f64a5f2c50', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('aa12a55e-ce8d-4a27-8dd4-76a20486696e', 'Dev Comment 2 - comment dev', 'f3fdd6d5-7672-4f86-b02f-17263bbb2f95', '3e42039f-59ab-485a-8739-f0dafd3fcc37', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('9de9908e-2359-4ac8-b409-d3192dccef82', 'Dev Comment 2 - comment admin', 'f3fdd6d5-7672-4f86-b02f-17263bbb2f95', '189d14d4-62a8-4798-add1-9623eb5ca44b', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('8da7f8e1-eb66-4d76-87eb-24cd53933d28', 'Dev Comment 3 - comment admin', '88b3cdac-1e68-4b94-be80-95de9ae8dfea', '189d14d4-62a8-4798-add1-9623eb5ca44b', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('a97abdc8-60ed-4a28-875d-df0374362579', 'Dev Comment 3 - comment user', '88b3cdac-1e68-4b94-be80-95de9ae8dfea', 'b6aed89b-c389-4b8e-bba8-e5f64a5f2c50', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('a791df5b-1030-4ba6-9f63-ecdbc6df43ba', 'Admin Comment 1 - comment dev', 'b4320b3a-0e1d-4c0b-a1eb-85198d7a3252', '3e42039f-59ab-485a-8739-f0dafd3fcc37', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('f47f3d7e-a154-4e04-bc42-c69d46f4bc09', 'Admin Comment 1 - comment admin', 'b4320b3a-0e1d-4c0b-a1eb-85198d7a3252', '189d14d4-62a8-4798-add1-9623eb5ca44b', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('9374669c-547b-47fa-bad5-ebed9537940f', 'Admin Comment 1 - comment user', 'b4320b3a-0e1d-4c0b-a1eb-85198d7a3252', 'b6aed89b-c389-4b8e-bba8-e5f64a5f2c50', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('10ce330c-da78-4862-a386-b7a95952937b', 'Admin Comment 1 - comment dev', '8ec850a5-6cd4-4068-bc2a-50ae3d11affe', '3e42039f-59ab-485a-8739-f0dafd3fcc37', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('e79726df-114f-4bf7-b6f8-54c6cb867763', 'Admin Comment 1 - comment admin', '8ec850a5-6cd4-4068-bc2a-50ae3d11affe', '189d14d4-62a8-4798-add1-9623eb5ca44b', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('e944a3b3-990c-4273-a033-bb2401efe2d1', 'Admin Comment 1 - comment user', '8ec850a5-6cd4-4068-bc2a-50ae3d11affe', 'b6aed89b-c389-4b8e-bba8-e5f64a5f2c50', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('ce38e8ca-b46d-477f-b7a7-19b74ce897b7', 'Admin Comment 1 - comment dev', '381a4db7-d638-4a94-a4a1-dd41b6a66741', '3e42039f-59ab-485a-8739-f0dafd3fcc37', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('84829dc0-72e7-4c65-b048-8c26dc3e5b44', 'Admin Comment 1 - comment admin', '381a4db7-d638-4a94-a4a1-dd41b6a66741', '189d14d4-62a8-4798-add1-9623eb5ca44b', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('3783d8f0-b03e-4e6f-b6bc-63b9ca2fdab8', 'Admin Comment 1 - comment user', '381a4db7-d638-4a94-a4a1-dd41b6a66741', 'b6aed89b-c389-4b8e-bba8-e5f64a5f2c50', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('3647c333-5b75-4dc6-9618-347cde5fbe88', 'Admin Comment 1 - comment dev', '1621fbf2-baf3-44f2-9c12-6f576fcc8663', '3e42039f-59ab-485a-8739-f0dafd3fcc37', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('9f00b33b-a83a-4b6d-879b-c1abc6d85905', 'Admin Comment 1 - comment admin', '1621fbf2-baf3-44f2-9c12-6f576fcc8663', '189d14d4-62a8-4798-add1-9623eb5ca44b', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('75c8fae3-2dc8-4336-9bce-fed96d952bbd', 'Admin Comment 1 - comment user', '1621fbf2-baf3-44f2-9c12-6f576fcc8663', 'b6aed89b-c389-4b8e-bba8-e5f64a5f2c50', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('0cb74c5f-c6df-4305-9896-9caca55bf5f4', 'Admin Comment 1 - comment dev', 'd3e4c297-c05d-4c55-9e6d-17d424096ab4', '3e42039f-59ab-485a-8739-f0dafd3fcc37', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('8a3a2918-997e-4d2d-88fb-a5f88ec43c73', 'Admin Comment 1 - comment admin', 'd3e4c297-c05d-4c55-9e6d-17d424096ab4', '189d14d4-62a8-4798-add1-9623eb5ca44b', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('d06506e1-6978-4656-89fd-97768278dc80', 'Admin Comment 1 - comment user', 'd3e4c297-c05d-4c55-9e6d-17d424096ab4', 'b6aed89b-c389-4b8e-bba8-e5f64a5f2c50', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('3d6acf8d-4d1a-46aa-9e96-a675d8948324', 'Admin Comment 1 - comment dev', '35bd5104-0996-46c2-8b86-c11fb8640b6b', '3e42039f-59ab-485a-8739-f0dafd3fcc37', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('8d8f1d63-65a0-4ac8-9948-507cc1e8cfad', 'Admin Comment 1 - comment admin', '35bd5104-0996-46c2-8b86-c11fb8640b6b', '189d14d4-62a8-4798-add1-9623eb5ca44b', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('4ac99c58-74cc-4dea-9e68-5ddc76220d88', 'Admin Comment 1 - comment user', '35bd5104-0996-46c2-8b86-c11fb8640b6b', 'b6aed89b-c389-4b8e-bba8-e5f64a5f2c50', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('002cb7bf-204d-490e-9f80-dbf0865f5a13', 'Admin Comment 1 - comment admin', '8fa409a5-2032-4147-9bd8-62c77eb37a14', '189d14d4-62a8-4798-add1-9623eb5ca44b', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `comment` (`cid`, `content`, `eid`, `uuid`, `create_date`, `last_update_date`) VALUES ('17f4930a-83a6-44c7-a082-0be416ba4fe7', 'Admin Comment 1 - comment user', '8fa409a5-2032-4147-9bd8-62c77eb37a14', 'b6aed89b-c389-4b8e-bba8-e5f64a5f2c50', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO `user_roles` (`auth_id`, `id`) VALUES ('1', '2');
INSERT INTO `user_roles` (`auth_id`, `id`) VALUES ('1', '1');
INSERT INTO `user_roles` (`auth_id`, `id`) VALUES ('3', '2');
INSERT INTO `user_roles` (`auth_id`, `id`) VALUES ('1', '3');
INSERT INTO `user_roles` (`auth_id`, `id`) VALUES ('2', '1');
INSERT INTO `user_roles` (`auth_id`, `id`) VALUES ('2', '2');
