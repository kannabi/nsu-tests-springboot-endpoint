CREATE SEQUENCE public.hibernate_sequence;
CREATE TABLE customer (
  id TEXT PRIMARY KEY,
  first_name TEXT NOT NULL,
  last_name TEXT NOT NULL,
  login TEXT NOT NULL,
  pass TEXT NOT NULL,
  balance INT NOT NULL DEFAULT 0
);

CREATE TABLE plan (
  id TEXT PRIMARY KEY,
  name TEXT NOT NULL,
  details TEXT NOT NULL,
  fee INT NOT NULL DEFAULT 0
);

CREATE TABLE subscription (
  id TEXT PRIMARY KEY,
  customer_id TEXT NOT NULL REFERENCES customer(id),
  plan_id TEXT NOT NULL REFERENCES plan(id)
);