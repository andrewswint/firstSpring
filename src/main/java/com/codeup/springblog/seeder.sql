drop database spring_blog_db;

USE spring_blog_db;
INSERT INTO dogs (age, name, reside_state)
VALUES
(2, 'Chuck', 'TX'),
(5, 'Fred', 'OH'),
(3, 'Bud', 'TN'),
(10, 'Bailey', 'AL'),
(11, 'Lexie', 'TX'),
(1, 'Snickers', 'TX'),
(6, 'Red', 'FL'),
(8, 'Barney', 'CA'),
(12, 'Bowser', 'TX');

SHOW CREATE TABLE dogs;

USE spring_blog_db;
INSERT INTO posts (title, body)
VALUES
('title1', 'body1'),
('title2', 'body2'),
('title3', 'body3'),
('cats', 'information about cats');


truncate post_details;
INSERT INTO post_details (is_awesome, history_of_post, topic_description, post_id)
VALUES
(false, 'this is test 1 history', 'this is the topic of test 1', 1),
(true, 'this is test 2 history', 'this is the topic of test 2', 3);

truncate images;
INSERT  INTO images (image_title, url, post_id) VALUES
('this is a cat', 'https://resize.hswstatic.com/w_907/gif/bobcat-2.jpg', 4),
('this is the second', 'https://www.nwf.org/-/media/NEW-WEBSITE/Shared-Folder/Wildlife/Mammals/mammal_mountain-lion_shutterstock_600x300.ashx', 4),
('this is the third', 'https://science.sciencemag.org/content/sci/359/6380/1110/F1.large.jpg', 4);