-- product_management database
create table if not exists product_management.category (
	id varchar(36) not null,
    name varchar(50),
    description varchar(100),
    constraint category_pk primary key (id)
);

create table if not exists product_management.product (
	id varchar(36) not null,
    name varchar(50),
	amount int,
    price float,
	cate_id varchar(36),
    constraint product_pk primary key (id),
    constraint product_fk foreign key (cate_id) references category(id)
);

insert into product_management.category values
('cate01', 'Mobile', 'Smart Mobile'),
('cate02', 'Laptop', 'Powerful Laptop');

insert into product_management.product values
('pro01', 'Samsung Galaxy', 10, 100.0, 'cate01'),
('pro02', 'iPhone X', 15, 200.0, 'cate01'),
('pro03', 'Dell Latitude 5490', 5, 350.0, 'cate02');