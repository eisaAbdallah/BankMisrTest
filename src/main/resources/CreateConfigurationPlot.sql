DROP TABLE `irrigation_period_details` IF EXISTS;

CREATE TABLE `irrigation_period_details` (
  `id` bigint NOT NULL,
  `water_amount` int DEFAULT NULL,
  `time_slot` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
