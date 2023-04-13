create database notebook;

use notebook;

create table notes (
    id          bigint auto_increment,
    header      varchar(100) not null,
    body        text not null,
    dateTime    varchar(30),
    primary key(id)
);

# insert into notes values
#     (1,
#      'Приветствие',
#      'Привет, начнем заполнять записную книжку',
#      '2023-04-08 12:56:17'
#      ),
#     (2,
#      'Поход в магазин',
#      'Не забыть купить хлеба и молока',
#      '2023-05-08 13:44:17'
#     ),
#     (3,
#      'Поздравление',
#      'Не забыть поздравить родителей с днем свадьбы',
#      '2023-06-08 11:59:17'
#     );