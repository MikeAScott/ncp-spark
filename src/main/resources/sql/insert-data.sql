INSERT INTO user(user_id, username, email, pw) VALUES (1, 'user001','user001@email.com','$2a$10$IHdRfnhNgQesPFD5hrUcMOvyx5RrRcklkpXfs9YX4j1qXvouEeVIa');
INSERT INTO user(user_id, username, email, pw) VALUES (2, 'user002','user002@email.com','$2a$10$NlU0bdBUiegZWZvl6CGpj.wV5YfbDGZ8lYznxWp2NNE4F9cYJJFOe');
INSERT INTO user(user_id, username, email, pw) VALUES (3, 'user003','user003@email.com','$2a$10$gwEVdI6lSDrkIkGLrsHTIOzLEgnT3gDUDYMOfxvOdnoqvGpf275fm');
INSERT INTO user(user_id, username, email, pw) VALUES (4, 'user004','user004@email.com','$2a$10$W2ZJXI00xhL03vwcy2Y/DeZe.BqMf4dUSP5lxEQFAqV.ocbUAYS4m');
INSERT INTO user(user_id, username, email, pw) VALUES (5, 'user005','user005@email.com','$2a$10$Q209gpOY73eZM5/7ix8Hxua/d8cPiV0nhBF.cPgEmtoY.2WN3z/k6');
INSERT INTO user(user_id, username, email, pw) VALUES (6, 'user006','user006@email.com','$2a$10$6njApozqiAlwamwi8oqgF.70eeTpgl4Z4SUpKK72AnIhHd3WXK/ei');
INSERT INTO user(user_id, username, email, pw) VALUES (7, 'user007','user007@email.com','$2a$10$YQifsq3fEABCJNM.ebxlmuJTNSvtJR72jZWHxLoU8A6Lap1QV/WP6');
INSERT INTO user(user_id, username, email, pw) VALUES (8, 'user008','user008@email.com','$2a$10$o0AykWkpgbKak8EyMM/J2.ntdjieJnf6.vgtcQVwnSW6n74YkjQMu');
INSERT INTO user(user_id, username, email, pw) VALUES (9, 'user009','user009@email.com','$2a$10$rbDB/WLckQTAO4St9TpMVOzSlJDrx98r2jgt9crwtsy8hCv7wIZkm');
INSERT INTO user(user_id, username, email, pw) VALUES (10, 'user010','user010@email.com','$2a$10$rXBPyVPkaD5u7MbDckemPutPT/m.8SylMrI3su26aaV0pxP34kDwa');

INSERT INTO follower(follower_id, followee_id) VALUES (1, 2);
INSERT INTO follower(follower_id, followee_id) VALUES (1, 7);
INSERT INTO follower(follower_id, followee_id) VALUES (1, 10);
INSERT INTO follower(follower_id, followee_id) VALUES (1, 9);
INSERT INTO follower(follower_id, followee_id) VALUES (1, 5);
INSERT INTO follower(follower_id, followee_id) VALUES (2, 2);
INSERT INTO follower(follower_id, followee_id) VALUES (2, 5);
INSERT INTO follower(follower_id, followee_id) VALUES (2, 3);
INSERT INTO follower(follower_id, followee_id) VALUES (2, 6);
INSERT INTO follower(follower_id, followee_id) VALUES (2, 10);
INSERT INTO follower(follower_id, followee_id) VALUES (3, 7);
INSERT INTO follower(follower_id, followee_id) VALUES (3, 6);
INSERT INTO follower(follower_id, followee_id) VALUES (3, 8);
INSERT INTO follower(follower_id, followee_id) VALUES (3, 9);
INSERT INTO follower(follower_id, followee_id) VALUES (3, 4);
INSERT INTO follower(follower_id, followee_id) VALUES (4, 10);
INSERT INTO follower(follower_id, followee_id) VALUES (4, 6);
INSERT INTO follower(follower_id, followee_id) VALUES (4, 8);
INSERT INTO follower(follower_id, followee_id) VALUES (4, 2);
INSERT INTO follower(follower_id, followee_id) VALUES (4, 7);
INSERT INTO follower(follower_id, followee_id) VALUES (5, 7);
INSERT INTO follower(follower_id, followee_id) VALUES (5, 1);
INSERT INTO follower(follower_id, followee_id) VALUES (5, 10);
INSERT INTO follower(follower_id, followee_id) VALUES (5, 6);
INSERT INTO follower(follower_id, followee_id) VALUES (5, 2);
INSERT INTO follower(follower_id, followee_id) VALUES (6, 10);
INSERT INTO follower(follower_id, followee_id) VALUES (6, 1);
INSERT INTO follower(follower_id, followee_id) VALUES (6, 7);
INSERT INTO follower(follower_id, followee_id) VALUES (6, 3);
INSERT INTO follower(follower_id, followee_id) VALUES (6, 5);
INSERT INTO follower(follower_id, followee_id) VALUES (7, 8);
INSERT INTO follower(follower_id, followee_id) VALUES (7, 5);
INSERT INTO follower(follower_id, followee_id) VALUES (7, 4);
INSERT INTO follower(follower_id, followee_id) VALUES (7, 2);
INSERT INTO follower(follower_id, followee_id) VALUES (7, 10);
INSERT INTO follower(follower_id, followee_id) VALUES (8, 6);
INSERT INTO follower(follower_id, followee_id) VALUES (8, 1);
INSERT INTO follower(follower_id, followee_id) VALUES (8, 9);
INSERT INTO follower(follower_id, followee_id) VALUES (8, 2);
INSERT INTO follower(follower_id, followee_id) VALUES (8, 4);
INSERT INTO follower(follower_id, followee_id) VALUES (9, 7);
INSERT INTO follower(follower_id, followee_id) VALUES (9, 6);
INSERT INTO follower(follower_id, followee_id) VALUES (9, 3);
INSERT INTO follower(follower_id, followee_id) VALUES (9, 8);
INSERT INTO follower(follower_id, followee_id) VALUES (9, 4);
INSERT INTO follower(follower_id, followee_id) VALUES (10, 1);
INSERT INTO follower(follower_id, followee_id) VALUES (10, 8);
INSERT INTO follower(follower_id, followee_id) VALUES (10, 7);
INSERT INTO follower(follower_id, followee_id) VALUES (10, 9);
INSERT INTO follower(follower_id, followee_id) VALUES (10, 6);

INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-01-15 02:00:22');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-10-25 10:09:55');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-07-14 09:46:28');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-01-15 11:35:07');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-02-04 04:19:45');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-06-01 10:06:41');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-03-14 00:56:15');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-11-25 02:21:53');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-09-14 10:25:10');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-01-24 09:34:26');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-03-23 01:34:21');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-05-26 08:48:54');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-06-20 01:11:53');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-12-27 10:35:02');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-09-17 05:13:19');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-02-03 07:57:41');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-08-22 07:28:03');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-09-18 11:50:56');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-09-02 06:50:52');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-04-08 07:46:14');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-09-25 04:57:35');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-07-03 07:20:54');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-08-05 06:05:47');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-09-24 07:42:56');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-10-05 07:15:57');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-03-08 05:03:54');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-03-27 02:11:38');
INSERT INTO message(author_id, text, pub_date) VALUES (1, 'This is a message written by user user001', TIMESTAMP '2014-12-28 05:40:12');
INSERT INTO message(author_id, text, pub_date) VALUES (2, 'This is a message written by user user002', TIMESTAMP '2014-08-19 10:37:18');
INSERT INTO message(author_id, text, pub_date) VALUES (2, 'This is a message written by user user002', TIMESTAMP '2014-05-12 03:12:57');
INSERT INTO message(author_id, text, pub_date) VALUES (2, 'This is a message written by user user002', TIMESTAMP '2014-07-04 04:58:14');
INSERT INTO message(author_id, text, pub_date) VALUES (2, 'This is a message written by user user002', TIMESTAMP '2014-11-11 09:30:49');
INSERT INTO message(author_id, text, pub_date) VALUES (2, 'This is a message written by user user002', TIMESTAMP '2014-07-13 10:25:45');
INSERT INTO message(author_id, text, pub_date) VALUES (2, 'This is a message written by user user002', TIMESTAMP '2014-12-21 02:25:36');
INSERT INTO message(author_id, text, pub_date) VALUES (2, 'This is a message written by user user002', TIMESTAMP '2014-08-26 08:08:13');
INSERT INTO message(author_id, text, pub_date) VALUES (2, 'This is a message written by user user002', TIMESTAMP '2014-11-16 09:43:33');
INSERT INTO message(author_id, text, pub_date) VALUES (2, 'This is a message written by user user002', TIMESTAMP '2014-05-18 06:37:31');
INSERT INTO message(author_id, text, pub_date) VALUES (2, 'This is a message written by user user002', TIMESTAMP '2014-05-21 09:38:17');
INSERT INTO message(author_id, text, pub_date) VALUES (2, 'This is a message written by user user002', TIMESTAMP '2014-04-10 07:46:15');
INSERT INTO message(author_id, text, pub_date) VALUES (2, 'This is a message written by user user002', TIMESTAMP '2014-06-17 06:29:11');
INSERT INTO message(author_id, text, pub_date) VALUES (3, 'This is a message written by user user003', TIMESTAMP '2014-06-13 03:56:46');
INSERT INTO message(author_id, text, pub_date) VALUES (3, 'This is a message written by user user003', TIMESTAMP '2014-01-26 03:12:01');
INSERT INTO message(author_id, text, pub_date) VALUES (3, 'This is a message written by user user003', TIMESTAMP '2014-02-23 03:22:53');
INSERT INTO message(author_id, text, pub_date) VALUES (3, 'This is a message written by user user003', TIMESTAMP '2014-02-02 11:02:13');
INSERT INTO message(author_id, text, pub_date) VALUES (3, 'This is a message written by user user003', TIMESTAMP '2014-09-10 03:17:12');
INSERT INTO message(author_id, text, pub_date) VALUES (3, 'This is a message written by user user003', TIMESTAMP '2014-07-09 03:45:12');
INSERT INTO message(author_id, text, pub_date) VALUES (3, 'This is a message written by user user003', TIMESTAMP '2014-04-23 07:04:08');
INSERT INTO message(author_id, text, pub_date) VALUES (3, 'This is a message written by user user003', TIMESTAMP '2014-02-21 07:53:49');
INSERT INTO message(author_id, text, pub_date) VALUES (3, 'This is a message written by user user003', TIMESTAMP '2014-02-10 00:00:40');
INSERT INTO message(author_id, text, pub_date) VALUES (3, 'This is a message written by user user003', TIMESTAMP '2014-02-06 02:45:31');
INSERT INTO message(author_id, text, pub_date) VALUES (3, 'This is a message written by user user003', TIMESTAMP '2014-02-12 00:08:10');
INSERT INTO message(author_id, text, pub_date) VALUES (4, 'This is a message written by user user004', TIMESTAMP '2014-08-21 10:55:35');
INSERT INTO message(author_id, text, pub_date) VALUES (4, 'This is a message written by user user004', TIMESTAMP '2014-08-02 00:58:50');
INSERT INTO message(author_id, text, pub_date) VALUES (4, 'This is a message written by user user004', TIMESTAMP '2014-06-25 03:26:41');
INSERT INTO message(author_id, text, pub_date) VALUES (4, 'This is a message written by user user004', TIMESTAMP '2014-12-11 09:50:29');
INSERT INTO message(author_id, text, pub_date) VALUES (4, 'This is a message written by user user004', TIMESTAMP '2014-04-21 11:02:25');
INSERT INTO message(author_id, text, pub_date) VALUES (4, 'This is a message written by user user004', TIMESTAMP '2014-11-12 08:18:46');
INSERT INTO message(author_id, text, pub_date) VALUES (4, 'This is a message written by user user004', TIMESTAMP '2014-01-23 00:45:00');
INSERT INTO message(author_id, text, pub_date) VALUES (4, 'This is a message written by user user004', TIMESTAMP '2014-03-24 01:38:09');
INSERT INTO message(author_id, text, pub_date) VALUES (4, 'This is a message written by user user004', TIMESTAMP '2014-07-14 04:51:39');
INSERT INTO message(author_id, text, pub_date) VALUES (4, 'This is a message written by user user004', TIMESTAMP '2014-09-10 01:17:39');
INSERT INTO message(author_id, text, pub_date) VALUES (5, 'This is a message written by user user005', TIMESTAMP '2014-10-21 11:32:11');
INSERT INTO message(author_id, text, pub_date) VALUES (5, 'This is a message written by user user005', TIMESTAMP '2014-02-05 06:27:24');
INSERT INTO message(author_id, text, pub_date) VALUES (5, 'This is a message written by user user005', TIMESTAMP '2014-08-07 07:16:01');
INSERT INTO message(author_id, text, pub_date) VALUES (5, 'This is a message written by user user005', TIMESTAMP '2014-03-07 11:30:50');
INSERT INTO message(author_id, text, pub_date) VALUES (5, 'This is a message written by user user005', TIMESTAMP '2014-07-28 10:52:55');
INSERT INTO message(author_id, text, pub_date) VALUES (5, 'This is a message written by user user005', TIMESTAMP '2014-01-18 04:23:18');
INSERT INTO message(author_id, text, pub_date) VALUES (5, 'This is a message written by user user005', TIMESTAMP '2014-04-12 04:21:18');
INSERT INTO message(author_id, text, pub_date) VALUES (5, 'This is a message written by user user005', TIMESTAMP '2014-01-20 00:14:19');
INSERT INTO message(author_id, text, pub_date) VALUES (5, 'This is a message written by user user005', TIMESTAMP '2014-09-29 02:27:42');
INSERT INTO message(author_id, text, pub_date) VALUES (5, 'This is a message written by user user005', TIMESTAMP '2014-02-27 11:26:00');
INSERT INTO message(author_id, text, pub_date) VALUES (5, 'This is a message written by user user005', TIMESTAMP '2014-09-29 10:56:07');
INSERT INTO message(author_id, text, pub_date) VALUES (5, 'This is a message written by user user005', TIMESTAMP '2014-05-24 09:06:23');
INSERT INTO message(author_id, text, pub_date) VALUES (5, 'This is a message written by user user005', TIMESTAMP '2014-11-03 07:08:46');
INSERT INTO message(author_id, text, pub_date) VALUES (5, 'This is a message written by user user005', TIMESTAMP '2014-09-14 11:41:08');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-11-08 04:45:23');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-10-09 08:26:06');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-06-03 10:55:13');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-01-08 08:41:26');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-05-19 09:26:37');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-08-04 11:51:36');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-02-28 06:05:19');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-04-14 04:20:29');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-10-22 09:10:20');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-04-10 01:10:37');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-08-08 11:40:24');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-12-05 04:56:09');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-04-26 07:43:06');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-11-13 04:02:08');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-08-23 08:19:18');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-11-07 11:51:05');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-05-04 05:47:35');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-11-26 06:16:48');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-12-16 07:08:16');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-02-13 00:08:39');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-10-19 06:36:37');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-04-14 08:45:37');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-08-28 07:20:53');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-10-16 01:03:19');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-02-24 04:06:18');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-10-10 10:23:02');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-03-23 01:26:38');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-08-01 06:45:51');
INSERT INTO message(author_id, text, pub_date) VALUES (6, 'This is a message written by user user006', TIMESTAMP '2014-02-05 03:55:38');
INSERT INTO message(author_id, text, pub_date) VALUES (7, 'This is a message written by user user007', TIMESTAMP '2014-07-23 08:38:17');
INSERT INTO message(author_id, text, pub_date) VALUES (7, 'This is a message written by user user007', TIMESTAMP '2014-07-30 06:52:07');
INSERT INTO message(author_id, text, pub_date) VALUES (7, 'This is a message written by user user007', TIMESTAMP '2014-08-21 06:46:51');
INSERT INTO message(author_id, text, pub_date) VALUES (7, 'This is a message written by user user007', TIMESTAMP '2014-03-23 06:23:45');
INSERT INTO message(author_id, text, pub_date) VALUES (7, 'This is a message written by user user007', TIMESTAMP '2014-01-23 06:46:32');
INSERT INTO message(author_id, text, pub_date) VALUES (7, 'This is a message written by user user007', TIMESTAMP '2014-01-30 04:09:52');
INSERT INTO message(author_id, text, pub_date) VALUES (7, 'This is a message written by user user007', TIMESTAMP '2014-01-12 06:57:34');
INSERT INTO message(author_id, text, pub_date) VALUES (7, 'This is a message written by user user007', TIMESTAMP '2014-02-11 06:53:55');
INSERT INTO message(author_id, text, pub_date) VALUES (7, 'This is a message written by user user007', TIMESTAMP '2014-06-18 02:36:45');
INSERT INTO message(author_id, text, pub_date) VALUES (7, 'This is a message written by user user007', TIMESTAMP '2014-04-19 09:03:08');
INSERT INTO message(author_id, text, pub_date) VALUES (7, 'This is a message written by user user007', TIMESTAMP '2014-09-03 11:30:56');
INSERT INTO message(author_id, text, pub_date) VALUES (7, 'This is a message written by user user007', TIMESTAMP '2014-08-21 07:43:49');
INSERT INTO message(author_id, text, pub_date) VALUES (7, 'This is a message written by user user007', TIMESTAMP '2014-10-30 08:13:37');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-08-04 03:00:07');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-03-06 02:50:03');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-07-21 04:09:22');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-03-17 10:29:06');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-02-20 02:41:32');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-11-19 00:14:32');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-04-05 08:31:48');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-03-10 04:53:48');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-05-09 00:24:40');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-07-21 03:18:13');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-04-15 04:56:24');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-03-16 11:06:11');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-04-02 11:18:19');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-05-11 00:27:53');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-12-30 05:29:05');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-10-28 07:46:25');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-04-12 04:50:30');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-06-09 06:43:23');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-11-21 01:33:33');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-12-11 05:39:41');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-01-06 06:30:25');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-02-15 10:51:45');
INSERT INTO message(author_id, text, pub_date) VALUES (8, 'This is a message written by user user008', TIMESTAMP '2014-02-07 08:06:45');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-11-27 01:49:43');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-08-14 06:18:54');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-07-18 08:53:53');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-10-08 08:25:00');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-09-14 10:50:49');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-11-19 00:17:12');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-08-18 00:57:12');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-09-06 06:38:22');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-09-04 02:18:44');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-11-07 10:10:21');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-07-27 00:15:16');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-10-28 09:55:54');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-01-05 09:41:37');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-04-05 06:07:37');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-09-18 02:53:48');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-06-21 07:36:41');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-10-08 02:09:44');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-05-27 07:34:28');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-03-14 03:43:14');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-08-09 03:50:55');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-07-15 02:58:33');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-09-17 09:29:27');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-08-20 10:43:30');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-12-05 03:10:19');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-06-26 08:51:45');
INSERT INTO message(author_id, text, pub_date) VALUES (9, 'This is a message written by user user009', TIMESTAMP '2014-11-06 08:58:00');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-07-14 07:57:53');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-04-24 07:35:30');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-10-19 02:52:57');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-09-27 04:15:55');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-04-15 00:22:19');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-09-05 03:28:15');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-08-07 01:01:00');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-10-19 09:40:00');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-03-10 11:35:46');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-11-25 04:20:31');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-03-12 03:55:58');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-08-03 04:27:00');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-11-11 10:23:41');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-02-14 11:20:13');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-01-20 00:29:25');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-05-05 01:15:49');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-02-18 10:20:00');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-05-30 09:26:19');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-06-28 08:24:55');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-11-16 02:01:35');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-12-21 06:10:28');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-02-01 06:39:10');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-04-26 07:05:25');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-08-13 03:15:56');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-02-17 11:28:02');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-03-01 11:07:31');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-10-16 09:40:11');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-07-10 08:38:31');
INSERT INTO message(author_id, text, pub_date) VALUES (10, 'This is a message written by user user010', TIMESTAMP '2014-01-04 11:56:22');