DROP TABLE `plot_data` IF EXISTS;
 CREATE TABLE `plot_data` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `plot_area` bigint DEFAULT NULL,
  `plot_location` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `irrigation_id` bigint DEFAULT NULL,
  `is_Active` tinyint DEFAULT '0',
  `time_of_last_irrigation` time DEFAULT NULL,
  `irrigattion_required` tinyint DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_irrigation_id` (`irrigation_id`),
  CONSTRAINT `FK_irrigation_id` FOREIGN KEY (`irrigation_id`) REFERENCES `irrigation_period_details` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
