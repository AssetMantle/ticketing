-- Create database and user scripts. To be run before evolutions are started.

CREATE USER "ticketing" WITH PASSWORD 'ticketing';

CREATE DATABASE "ticketing" WITH OWNER = "ticketing";

ALTER USER "ticketing" SET SEARCH_PATH = "$user", MASTER, MASTER_TRANSACTION, BLOCKCHAIN, BLOCKCHAIN_TRANSACTION, ANALYTICS, HISTORY, CAMPAIGN;

