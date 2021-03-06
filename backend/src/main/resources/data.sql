INSERT INTO tb_user (name, email, password) VALUES ('Alex Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Bob Brown', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Maria Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);


INSERT INTO tb_course (name, img_uri, img_gray_uri) VALUES ('Bootcamp HTML', 'https://cdn.pixabay.com/photo/2019/12/29/19/40/online-4727942_960_720.jpg', 'https://live.staticflickr.com/2891/11619047474_71850d7f16_b.jpg');


INSERT INTO tb_offer(edition, start_moment, end_moment, course_id) VALUES ('1.0',TIMESTAMP WITH TIME ZONE '2020-11-20T03:00:00Z' , TIMESTAMP WITH TIME ZONE '2021-07-13T20:50:07Z', 1 );
INSERT INTO tb_offer(edition, start_moment, end_moment, course_id) VALUES ('2.0',TIMESTAMP WITH TIME ZONE '2021-12-20T03:00:00Z' , TIMESTAMP WITH TIME ZONE '2022-07-13T20:50:07Z', 1 );

INSERT INTO tb_resource(title, description, position, img_uri, type, offer_id) VALUES ('Trilha HTML', 'trilha principal', 1, 'https://cdn.pixabay.com/photo/2019/12/29/19/40/online-4727942_960_720.jpg', 1, 1);
INSERT INTO tb_resource(title, description, position, img_uri, type, offer_id) VALUES ('Forum', 'tire suas duvidas', 2, 'https://cdn.pixabay.com/photo/2019/12/29/19/40/online-4727942_960_720.jpg', 2, 1);
INSERT INTO tb_resource(title, description, position, img_uri, type, offer_id) VALUES ('Lives', 'Aulas ao vivo', 3, 'https://cdn.pixabay.com/photo/2019/12/29/19/40/online-4727942_960_720.jpg', 0, 1);

INSERT INTO tb_section (title, description, img_uri, position, resource_id, prerequisite_id ) VALUES  ('capitulo 1', 'introducao','https://cdn.pixabay.com/photo/2019/12/29/19/40/online-4727942_960_720.jpg', 1, 1, null );
INSERT INTO tb_section (title, description, img_uri, position, resource_id, prerequisite_id ) VALUES  ('capitulo 2', 'indo','https://cdn.pixabay.com/photo/2019/12/29/19/40/online-4727942_960_720.jpg', 1, 2, 1 );
INSERT INTO tb_section (title, description, img_uri, position, resource_id, prerequisite_id ) VALUES  ('capitulo 3', 'chegando','https://cdn.pixabay.com/photo/2019/12/29/19/40/online-4727942_960_720.jpg', 1, 3, 2 );

INSERT INTO tb_enrollment (user_id, offer_id, enroll_moment, refund_moment, avaliable, only_update) VALUES (1, 1, TIMESTAMP WITH TIME ZONE '2021-06-20T03:00:00Z', null, TRUE, FALSE);
INSERT INTO tb_enrollment (user_id, offer_id, enroll_moment, refund_moment, avaliable, only_update) VALUES (2, 1, TIMESTAMP WITH TIME ZONE '2021-06-20T03:00:00Z', null, TRUE, FALSE);

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Aula-1 cap-1', 1, 1);
INSERT INTO tb_content (id, text_content, video_uri) VALUES (1, '123', 'http');

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Aula-2 cap-1', 2, 1);
INSERT INTO tb_content (id, text_content, video_uri) VALUES (2, '123', 'http');

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Aula-2 cap-1', 3, 1);
INSERT INTO tb_content (id, text_content, video_uri) VALUES (3, '123', 'http');

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Tarefa cap-1', 4, 1);
INSERT INTO tb_task (id, description, question_count, approval_count, weight, due_date) VALUES (4, 'resolve ai', 5, 4, 1.0, TIMESTAMP WITH TIME ZONE '2021-06-26T03:00:00Z' );

INSERT INTO tb_lessons_done (lesson_id, user_id, offer_id) VALUES (1, 1, 1);
INSERT INTO tb_lessons_done (lesson_id, user_id, offer_id) VALUES (2, 1, 1);
INSERT INTO tb_lessons_done (lesson_id, user_id, offer_id) VALUES (3, 1, 1);


INSERT INTO tb_NOTIFICATION (text, moment, read, route, user_id ) VALUES ('Nova oferta', TIMESTAMP WITH TIME ZONE '2021-06-20T03:00:00Z', FALSE, '123', 1 );
INSERT INTO tb_NOTIFICATION (text, moment, read, route,  user_id ) VALUES ('Nova atualiza????o', TIMESTAMP WITH TIME ZONE '2021-07-7T03:00:00Z', FALSE, '123', 1 );
INSERT INTO tb_NOTIFICATION (text, moment, read, route,  user_id ) VALUES ('Nova atualiza????o', TIMESTAMP WITH TIME ZONE '2021-07-7T03:00:00Z', TRUE, '123', 1 );

INSERT INTO tb_deliver (uri, moment, deliver_status, feedback, correct_Count, lesson_id, user_id, offer_id) VALUES ('https://github.com/devsuperior/bds-dslearn', TIMESTAMP WITH TIME ZONE '2020-12-10T10:00:00Z', 0, null, null, 4, 1, 1);

INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('T??tulo do t??pico 1', 'Corpo do t??pico 1', TIMESTAMP WITH TIME ZONE '2020-12-12T13:00:00Z', 1, 1, 1);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('T??tulo do t??pico 2', 'Corpo do t??pico 2', TIMESTAMP WITH TIME ZONE '2020-12-13T13:00:00Z', 2, 1, 1);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('T??tulo do t??pico 3', 'Corpo do t??pico 3', TIMESTAMP WITH TIME ZONE '2020-12-14T13:00:00Z', 2, 1, 1);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('T??tulo do t??pico 4', 'Corpo do t??pico 4', TIMESTAMP WITH TIME ZONE '2020-12-15T13:00:00Z', 1, 1, 2);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('T??tulo do t??pico 5', 'Corpo do t??pico 5', TIMESTAMP WITH TIME ZONE '2020-12-16T13:00:00Z', 1, 1, 2);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('T??tulo do t??pico 6', 'Corpo do t??pico 6', TIMESTAMP WITH TIME ZONE '2020-12-17T13:00:00Z', 2, 1, 3);

INSERT INTO tb_topic_likes (topic_id, user_id) VALUES (1, 2);
INSERT INTO tb_topic_likes (topic_id, user_id) VALUES (2, 1);

INSERT INTO tb_reply (body, moment, topic_id, author_id) VALUES ('Tente reiniciar o computador', TIMESTAMP WITH TIME ZONE '2020-12-15T13:00:00Z', 1, 2);
INSERT INTO tb_reply (body, moment, topic_id, author_id) VALUES ('Deu certo, valeu!', TIMESTAMP WITH TIME ZONE '2020-12-20T13:00:00Z', 1, 1);

INSERT INTO tb_reply_likes (reply_id, user_id) VALUES (1, 1);