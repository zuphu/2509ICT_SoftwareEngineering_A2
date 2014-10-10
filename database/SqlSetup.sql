drop table if exists customerdetails;
drop table if exists menuitemdetails;
drop table if exists dailyorders;

create table customerdetails (
  id               integer primary key autoincrement,
  phonenumber      varchar(15),
  address          varchar(40) not null,
  creditcardnumber varchar(40)
);

create table menuitemdetails (
  id              integer primary key autoincrement,
  itemname        varchar(15),
  itemdescription varchar(15),
  cost            decimal(2, 2)
);

create table dailyorders (
  id         integer primary key autoincrement,
  orderdate  date not null,
  totalordercost  decimal(2, 2)
);

/*customerdetails*/
insert into customerdetails(id, phonenumber, address, creditcardnumber) values (null,'0421925740','11 Breaker Street', '1234567ABCD');
insert into customerdetails(id, phonenumber, address, creditcardnumber) values (null,'621925747','21 Liverpool Lane', '1324570BACD');

/*menuitemdetails*/
insert into menuitemdetails(id, itemname, itemdescription, cost) values (null,'Pizza','Pizza with cheese.', '7.50');
insert into menuitemdetails(id, itemname, itemdescription, cost) values (null,'Lasanga','Pasta layered with tomato sauce and ground beef.', '9.50');
insert into menuitemdetails(id, itemname, itemdescription, cost) values (null,'Beer','On tap beer.', '4.50');

/*dailyorders*/
insert into dailyorders(id, orderdate, totalordercost) values (null,'2014-10-20', 200.20);

select * from customerdetails;
select * from menuitemdetails;
select * from dailyorders;
