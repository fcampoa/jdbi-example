use pos;
create table if not exists Product(
id int not null primary key auto_increment,
name varchar(100),
price decimal(18,2),
brand varchar(100),
barcode varchar(100) not null
);
create table if not exists Person(
id int not null primary key auto_increment,
name varchar(100),
lastname varchar(100),
email varchar(100),
dni varchar(100) not null
);