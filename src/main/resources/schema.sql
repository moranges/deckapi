drop table deck if exists;
drop table card if exists;

create table deck
(
   id varchar(8) not null,
   cards_used integer not null,
   PRIMARY KEY(id)
);

create table card
(
   code varchar(3) not null,
   PRIMARY KEY(code)
);

insert into card (code) values('S1');
insert into card (code) values('S2');
insert into card (code) values('S3');
insert into card (code) values('S4');
insert into card (code) values('S5');
insert into card (code) values('S6');
insert into card (code) values('S7');
insert into card (code) values('S8');
insert into card (code) values('S9');
insert into card (code) values('S10');
insert into card (code) values('S11');
insert into card (code) values('S12');
insert into card (code) values('S13');

insert into card (code) values('H1');
insert into card (code) values('H2');
insert into card (code) values('H3');
insert into card (code) values('H4');
insert into card (code) values('H5');
insert into card (code) values('H6');
insert into card (code) values('H7');
insert into card (code) values('H8');
insert into card (code) values('H9');
insert into card (code) values('H10');
insert into card (code) values('H11');
insert into card (code) values('H12');
insert into card (code) values('H13');

insert into card (code) values('D1');
insert into card (code) values('D2');
insert into card (code) values('D3');
insert into card (code) values('D4');
insert into card (code) values('D5');
insert into card (code) values('D6');
insert into card (code) values('D7');
insert into card (code) values('D8');
insert into card (code) values('D9');
insert into card (code) values('D10');
insert into card (code) values('D11');
insert into card (code) values('D12');
insert into card (code) values('D13');
 
insert into card (code) values('C1');
insert into card (code) values('C2');
insert into card (code) values('C3');
insert into card (code) values('C4');
insert into card (code) values('C5');
insert into card (code) values('C6');
insert into card (code) values('C7');
insert into card (code) values('C8');
insert into card (code) values('C9');
insert into card (code) values('C10');
insert into card (code) values('C11');
insert into card (code) values('C12');
insert into card (code) values('C13');


create table deck_card
(
	id integer not null AUTO_INCREMENT,
	deck_id varchar(8) not null,
	card_order integer not null,
	card_code varchar(3) not null,
	PRIMARY KEY(id),
	FOREIGN KEY(deck_id) REFERENCES deck(id),
	FOREIGN KEY(card_code) REFERENCES card(code)
);