
INSERT INTO leagues (id, name, champion_id) VALUES (1,'Tennis Table League 2021',NULL);

INSERT INTO participants (id, name, email) VALUES (1,'Mostafa','mostafabayomui@gmail.com');
INSERT INTO participants (id, name, email) VALUES (2,'Ahmed Elsaid','ahmedelsaid@gmail.com');
INSERT INTO participants (id, name, email) VALUES (3,'Hossam Ali','hossamali@gmail.com');
INSERT INTO participants (id, name, email) VALUES (4,'Wael Ibrahim','waelibrahim@gmail.com');
INSERT INTO participants (id, name, email) VALUES (5,'Tamer ahmed','tamerahmed@gmail.com');
INSERT INTO participants (id, name, email) VALUES (6,'Walid Ahmed','walidahmed@gmail.com');
INSERT INTO participants (id, name, email) VALUES (7,'Hala Huessien','halahuessien@gmail.com');
INSERT INTO participants (id, name, email) VALUES (8,'sara Ali','saraali@gmail.com');
INSERT INTO participants (id, name, email) VALUES (9,'Asser Abdelsalam','asser@gmail.com');
INSERT INTO participants (id, name, email) VALUES (10,'hatem nagiub','hatemnaguib@gmail.com');
INSERT INTO participants (id, name, email) VALUES (11,'samy youssef','sammyyoussef@gmail.com');


INSERT INTO leagues_participants (id, participant_id, league_id) VALUES (2,1,1);
INSERT INTO leagues_participants (id, participant_id, league_id) VALUES (3,2,1);
INSERT INTO leagues_participants (id, participant_id, league_id) VALUES (4,3,1);
INSERT INTO leagues_participants (id, participant_id, league_id) VALUES (5,4,1);
INSERT INTO leagues_participants (id, participant_id, league_id) VALUES (6,5,1);
INSERT INTO leagues_participants (id, participant_id, league_id) VALUES (12,6,1);
INSERT INTO leagues_participants (id, participant_id, league_id) VALUES (13,7,1);
INSERT INTO leagues_participants (id, participant_id, league_id) VALUES (14,8,1);
INSERT INTO leagues_participants (id, participant_id, league_id) VALUES (15,9,1);
INSERT INTO leagues_participants (id, participant_id, league_id) VALUES (16,10,1);
INSERT INTO leagues_participants (id, participant_id, league_id) VALUES (17,11,1);


INSERT INTO matches (id, first_participant_id, second_participant_id, round_no, winner_id, result, match_date, league_id) VALUES (60,1,6,1,1,'6-1','2022-01-16',1);
INSERT INTO matches (id, first_participant_id, second_participant_id, round_no, winner_id, result, match_date, league_id) VALUES (61,2,3,1,NULL,NULL,'2022-01-16',1);
INSERT INTO matches (id, first_participant_id, second_participant_id, round_no, winner_id, result, match_date, league_id) VALUES (62,4,9,1,NULL,NULL,'2022-01-16',1);
INSERT INTO matches (id, first_participant_id, second_participant_id, round_no, winner_id, result, match_date, league_id) VALUES (63,5,7,1,NULL,NULL,'2022-01-17',1);
INSERT INTO matches (id, first_participant_id, second_participant_id, round_no, winner_id, result, match_date, league_id) VALUES (64,8,10,1,NULL,NULL,'2022-01-17',1);
INSERT INTO matches (id, first_participant_id, second_participant_id, round_no, winner_id, result, match_date, league_id) VALUES (65,11,NULL,2,NULL,NULL,'2022-01-17',1);

