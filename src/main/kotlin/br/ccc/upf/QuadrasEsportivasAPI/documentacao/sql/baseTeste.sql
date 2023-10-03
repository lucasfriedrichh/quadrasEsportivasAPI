INSERT INTO `court` (`id`, `description`, `status`) VALUES ('2', 'Teste 2', 'BROKEN');
INSERT INTO `court` (`id`, `description`, `status`) VALUES ('3', 'Teste 3', 'MAINTENANCE');
INSERT INTO `court` (`id`, `description`, `status`) VALUES ('4', 'Teste 4', 'BROKEN');
INSERT INTO `court` (`id`, `description`, `status`) VALUES ('5', 'Teste 5', 'AVAILABLE');
INSERT INTO `court` (`id`, `description`, `status`) VALUES ('6', 'Teste 6', 'MAINTENANCE');
INSERT INTO `court` (`id`, `description`, `status`) VALUES ('7', 'Teste 7', 'BROKEN');
INSERT INTO `court` (`id`, `description`, `status`) VALUES ('8', 'Teste 8', 'AVAILABLE');

INSERT INTO `user` (`id`, `city`, `email`, `name`, `phone`, `role`) VALUES ('4', 'Salvador', 'teste4@example.com', 'Teste4', '(71) 44444-4444', 'USER');
INSERT INTO `user` (`id`, `city`, `email`, `name`, `phone`, `role`) VALUES ('5', 'Recife', 'teste5@example.com', 'Teste5', '(81) 55555-5555', 'USER');
INSERT INTO `user` (`id`, `city`, `email`, `name`, `phone`, `role`) VALUES ('6', 'Fortaleza', 'teste6@example.com', 'Teste6', '(85) 66666-6666', 'USER');
INSERT INTO `user` (`id`, `city`, `email`, `name`, `phone`, `role`) VALUES ('7', 'Curitiba', 'teste7@example.com', 'Teste7', '(41) 77777-7777', 'USER');
INSERT INTO `user` (`id`, `city`, `email`, `name`, `phone`, `role`) VALUES ('8', 'Brasília', 'teste8@example.com', 'Teste8', '(61) 88888-8888', 'USER');
INSERT INTO `user` (`id`, `city`, `email`, `name`, `phone`, `role`) VALUES ('9', 'Porto Alegre', 'teste9@example.com', 'Teste9', '(51) 99999-9999', 'USER');

INSERT INTO `reservation` (`id`, `time`, `user_id`) VALUES ('2', '2023-10-04 11:24:42.000000', '2');
INSERT INTO `reservation` (`id`, `time`, `user_id`) VALUES ('3', '2023-10-05 11:24:42.000000', '3');
INSERT INTO `reservation` (`id`, `time`, `user_id`) VALUES ('4', '2023-10-06 11:24:42.000000', '4');
INSERT INTO `reservation` (`id`, `time`, `user_id`) VALUES ('5', '2023-10-07 11:24:42.000000', '5');
INSERT INTO `reservation` (`id`, `time`, `user_id`) VALUES ('6', '2023-10-09 11:24:42.000000', '6');
INSERT INTO `reservation` (`id`, `time`, `user_id`) VALUES ('7', '2023-10-12 11:24:42.000000', '7');
