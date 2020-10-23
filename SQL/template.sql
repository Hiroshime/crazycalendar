/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  LROSSATO
 * Created: Oct 23, 2020
 */


CREATE DATABASE crazycalendar;

USE crazycalendar;

CREATE TABLE tb_accgroup(
id INT NOT NULL AUTO_INCREMENT,
dt_creation TIMESTAMP,
name VARCHAR(10) NOT NULL
);

CREATE TABLE tb_user(
id INT NOT NULL AUTO_INCREMENT,
dt_creation TIMESTAMP,
name VARCHAR(10) NOT NULL,
phone VARCHAR(14),
e-mail VARCHAR(25),
weight DOUBLE,
heigth DOUBLE,
id_accgroup
);

CREATE TABLE tb_profile(
id INT NOT NULL AUTO_INCREMENT,
dt_creation TIMESTAMP,


CREATE TABLE tb_route(
id INT NOT NULL AUTO_INCREMENT,
dt_creation TIMESTAMP,
name VARCHAR(10) NOT NULL,
picture VARCHAR(40),
profile,
type
);

CREATE TABLE tb_trainning(
id INT NOT NULL AUTO_INCREMENT,
dt_creation TIMESTAMP,
dt_schedule,
status VARCHAR(10) NOT NULL,
owner,
id_sport
);

CREATE TABLE tb_trainning_user(
id INT NOT NULL AUTO_INCREMENT,
id_trainning TIMESTAMP,
id_user,
status VARCHAR(10) NOT NULL
);

CREATE TABLE tb_sport(
id INT NOT NULL AUTO_INCREMENT,
dt_creation TIMESTAMP,
name VARCHAR(10) NOT NULL
);

