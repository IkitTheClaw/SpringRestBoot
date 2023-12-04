DROP TABLE IF EXISTS "user";
CREATE TABLE "user" (
    id int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE,
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255)
);
INSERT INTO "user" (name varchar(255),email varchar(255),password varchar(255)) VALUES ('a','a','$2a$12$8RPPfgnyMRwsOQX8sDeDkOug6vPb6veJMMC6s8ncETS4FMWlnakrC')