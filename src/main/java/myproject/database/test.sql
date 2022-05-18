--does not work ...

CREATE TABLE `account` (
 `accountNumber` int,
 `amount` double DEFAULT NULL,
 `forename` varchar(255) DEFAULT NULL,
 `lastname` varchar(255) DEFAULT NULL,
 `pin` int DEFAULT NULL,

  PRIMARY KEY (`accountNumber`)
)
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;