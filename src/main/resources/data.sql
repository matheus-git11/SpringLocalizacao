 create table tb_cidade(
    id_cidade bigint not null primary key,
    nome varchar(50) not null,
    qtd_habitantes bigint
 );

 insert into tb_cidade
            (id_cidade,nome,qtd_habitantes)
 values
    (1, 'Sao Paulo' , 12396732),
    (2,'Rio de Janeiro',13940233),
    (3,'Recife',11340233),
    (4,'Salvador',70343209),
    (5,'Belo Horizonte',113421633),
    (6,'Porto Alegre',320312811),
    (7,'Natal',533421633),
    (8,'Porto Velho',358312811),
    (9,'Brasilia',668323811),
    (10,'Fortaleza',432312811);