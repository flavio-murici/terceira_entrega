# terceira_entrega
Terceira entrega do projeto Recode Turismo em JSP e MVC.
<h1>Codigo para criação do BD para teste.</h1>
create database recode;<br>

use recode;<br>

create table usuarios(<br>

id int not null auto_increment primary key, <br>
nome varchar(40),<br>
cpf varchar(11),<br>
email varchar(50),<br>
telefone varchar(12),<br>
login varchar(20),<br>
senha varchar(20))<br>


select * from usuarios<br>

