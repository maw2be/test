DROP TABLE IF EXISTS userdevice;

CREATE TABLE userdevice (
  serial varchar PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) DEFAULT NULL
);