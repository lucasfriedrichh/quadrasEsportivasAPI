CREATE TABLE `user`(
    `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `city` varchar(255) DEFAULT NULL,
    `name` varchar(255) NOT NULL,
    `phone` varchar(255) DEFAULT NULL
);