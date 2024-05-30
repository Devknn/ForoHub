alter table topicos add column estado tinyint;
update topicos set estado = 1;
alter table topicos modify estado tinyint not null;