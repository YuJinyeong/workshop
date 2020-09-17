create database ssafyweb;

use ssafyweb;

-- DROP TABLE `guestbook`;

CREATE TABLE `guestbook` (
	`articleno`   int PRIMARY KEY auto_increment ,
	`username`    VARCHAR(20) NULL,
	`subject`     VARCHAR(100) NULL,
	`content`     VARCHAR(2000) NULL,
	`regtime`    TIMESTAMP   NOT NULL DEFAULT current_timestamp
);