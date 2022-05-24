
CREATE TABLE `account` (
    `accountNumber` int NOT NULL,
    `amount` double NOT NULL,
    `forename` varchar(255) DEFAULT NULL,
    `lastname` varchar(255) DEFAULT NULL,
    `pin` int NOT NULL,
    PRIMARY KEY (`accountNumber`)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;