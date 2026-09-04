insert into TBL_CONTATO (ID_CONTATO, NOME_CONTATO, CELULAR_CONTATO, EMAIL_CONTATO, INSTAGRAM, TIPO)
values(1, 'Flavio', '1195959595', 'email@email', null, null)



select * from TBL_CONTATO;
select * from TBL_CONTATO where id_contato = 1;




Create table endereco_agenda(
codigo numeric(4) primary Key n ot null,
logradouro varchar2(60),
cep varchar2 (8) not null,
bairro varchar2 (20),
cidade varchar2 (30),
estado varchar2 (20),
uf varchar2 (2),
numero varchar2(10),
complemento varchar2(50)
);


alter table tbl_contato add código numeric(4) references endereco_agenda(codigo);

