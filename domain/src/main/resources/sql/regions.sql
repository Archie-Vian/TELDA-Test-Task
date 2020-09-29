CREATE TABLE IF NOT EXISTS `regions`(
`id` INTEGER AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(100) unique not null,
`code` NUMBER(3) unique not null

);
