-- liquibase formatted sql

-- changeset dhaval:pokemon-table
CREATE TABLE pokemon(
    id BIGINT auto_increment NOT NULL,
    name varchar(100) NOT NULL,
    CONSTRAINT pokemon_name_unique UNIQUE KEY (name),
    CONSTRAINT pokemon_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;

--changeset dhaval:add-image-url-column
ALTER table pokemon add column imageUrl varchar(200)

--changeset dhaval:add-power-column
ALTER table pokemon add column power varchar(100)

--changeset dhaval:remove-power-column
ALTER TABLE pokemon DROP COLUMN power;

--changeset dhaval:add-power-table
CREATE TABLE power (
	id bigint auto_increment NOT NULL,
	power varchar(100) NOT NULL,
	CONSTRAINT NewTable_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_swedish_ci;

--changeset dhaval:rename-power-table-power-column
alter table power rename column power to name

--changeset dhaval:add-power-entries
insert into power (name) values ("grass"), ("electric"), ("bug"), ("fire")

--changeset dhaval:add-power-column-pokemon
ALTER table pokemon add column power bigint

--changeset dhaval:add-foreign-key-of-power
ALTER TABLE pokemon ADD CONSTRAINT pokemon_FK FOREIGN KEY (power) REFERENCES pokemon.power(id);
