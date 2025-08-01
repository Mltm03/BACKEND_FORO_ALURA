-- V1__CREATE_TABLES.sql
-- Script inicial de creación de tablas para la aplicación del foro



create table users(
    id bigint not null auto_increment,
    email varchar(255) not null unique,
    name varchar(255) not null,
    password varchar(255) not null,
    primary key(id)
);

create table courses(

    id bigint not null auto_increment,
    category varchar(100) not null,
    name varchar(255) not null,
    primary key(id)
);


create table topics(

    id bigint not null auto_increment,
    creation_date datetime(6) not null,
    message varchar(255) not null,
    status char(100) not null,
    title varchar(255) not null,
    author_id  bigint not null,
    course_id  bigint not null,
    primary key(id),
    foreign key (author_id) references users(id),
    foreign key (course_id) references courses(id)

);

create table responses (
    id bigint not null auto_increment,
    created_at datetime(6) not null,
    message varchar(255) not null,
    topic_id bigint not null,
    author_id  bigint not null,
    solution char(100) not null,
    primary key(id),
    foreign key (topic_id) references topics(id) on delete cascade,
    foreign key (author_id) references users(id) on delete cascade
);






-- CREATE TABLE `users` (
--   `id` bigint NOT NULL AUTO_INCREMENT,
--   `email` varchar(255) DEFAULT NULL,
--   `name` varchar(255) DEFAULT NULL,
--   `password` varchar(255) DEFAULT NULL,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- CREATE TABLE `courses` (
--   `id` bigint NOT NULL AUTO_INCREMENT,
--   `category` tinyint DEFAULT NULL,
--   `name` varchar(255) DEFAULT NULL,
--   PRIMARY KEY (`id`),
--   CONSTRAINT `courses_chk_1` CHECK ((`category` between 0 and 3))
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- CREATE TABLE `topics` (
--   `id` bigint NOT NULL AUTO_INCREMENT,
--   `creation_date` datetime(6) DEFAULT NULL,
--   `message` varchar(255) DEFAULT NULL,
--   `status` bit(1) DEFAULT NULL,
--   `title` varchar(255) DEFAULT NULL,
--   `author_id` bigint DEFAULT NULL,
--   `course_id` bigint DEFAULT NULL,
--   PRIMARY KEY (`id`),
--   KEY `FK7xkxef4fwbjec06isf4ims4gr` (`author_id`),
--   KEY `FKhn8u5k2hlwgftn6xkk7i2vh1o` (`course_id`),
--   CONSTRAINT `FK7xkxef4fwbjec06isf4ims4gr` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`),
--   CONSTRAINT `FKhn8u5k2hlwgftn6xkk7i2vh1o` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- CREATE TABLE `responses` (
--   `id` bigint NOT NULL AUTO_INCREMENT,
--   `created_at` datetime(6) DEFAULT NULL,
--   `message` varchar(255) DEFAULT NULL,
--   `solution` bit(1) DEFAULT NULL,
--   `author_id` bigint DEFAULT NULL,
--   `topic_id` bigint DEFAULT NULL,
--   PRIMARY KEY (`id`),
--   UNIQUE KEY `UK6vflx1l6vn19023ot23c0cyae` (`author_id`),
--   KEY `FKcq8yjnjc97r334orn3tic7rgs` (`topic_id`),
--   CONSTRAINT `FKcq8yjnjc97r334orn3tic7rgs` FOREIGN KEY (`topic_id`) REFERENCES `topics` (`id`),
--   CONSTRAINT `FKmcwx6rn2uuqhd1pjsbem3l2ll` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
