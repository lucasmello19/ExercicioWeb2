# Exercicios Web 2
Projeto Feito com `Java` usando `Netbeans` e como banco `Mysql`.

## Pré-requisitos
Para preparar seu banco rode esse script sql nele:

```
create database Login;
use Login;
#drop table tb_usuario;
create table tb_usuario (id_usuario int primary key auto_increment NOT NULL, login_usuario varchar(50), senha_usuario varchar(50), nome_usuario varchar(100));
select * from tb_usuario;

insert into tb_usuario value (0, 'lucas', '123', 'Lucas');
insert into tb_usuario value (0, 'jorge', '123', 'Jorge');
insert into tb_usuario value (0, 'joao', '123', 'Joao');
```
