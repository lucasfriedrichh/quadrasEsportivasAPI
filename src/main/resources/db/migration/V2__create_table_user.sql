CREATE TABLE `user`(
    `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `description` varchar(225) DEFAULT NULL,
    `status` enum('AVAILABLE', 'MAINTENANCE', 'BROKEN') DEFAULT NULL
);