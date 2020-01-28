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
('title3', 'body3');