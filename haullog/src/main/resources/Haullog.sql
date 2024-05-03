-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE IF NOT EXISTS public.users
(
    email text COLLATE pg_catalog."default" NOT NULL,
    password text COLLATE pg_catalog."default" NOT NULL,
    first_name text COLLATE pg_catalog."default",
    last_name text COLLATE pg_catalog."default",
    company_name text COLLATE pg_catalog."default",
    CONSTRAINT user_pkey PRIMARY KEY (email)
)

TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to postgres;

INSERT INTO users VALUES('admin@email.com', 'admin123');

CREATE TYPE "Truck_Activity" AS ENUM (
  'Active',
  'Inactive',
  'Maintenance',
  'Unfixable'
);

CREATE TYPE "Status_Shipment" AS ENUM (
  'Delivered',
  'In Transit',
  'Pending',
  'Incomplete',
  'Payment Pending'
);

-- CREATE TYPE "Employee_type" AS ENUM (
--   'Manager',
--   'Driver',
--   'Admin'
-- );

CREATE TABLE "Trucks" (
  "truck_id" number PRIMARY KEY,
  "truck_brand" string NOT NULL,
  "truck_model" string NOT NULL,
  "truck_load" number,
  "purchase_date" date,
  "activity_status" Truck_Activity
);

CREATE TABLE "Shipments" (
  "shipment_id" number PRIMARY KEY,
  -- "customer_id" number,
  -- "driver_id" number,
  "truck_id" number FOREIGN KEY,
  "shipment_cost" number,
  "shipment_date" date,
  -- "shipment_created" date,
  "shipment_status" Status_Shipment,
  "shipment_source" string,
  "shipment_dest" string,
  -- "creator_id" number
);

CREATE TABLE "Expenses" (
  "expense_id" number PRIMARY KEY,
  "reporter_id" number,
  "employee_id" number,
  "truck_id" number
);

-- CREATE TABLE "Customers" (
--   "customer_id" number PRIMARY KEY,
--   "customer_name" string,
--   "customer_company" string,
--   "customer_phone" string,
--   "customer_mail" string,
--   "customer_address" string
-- );

-- CREATE TABLE "Employees" (
--   "employee_id" number PRIMARY KEY,
--   "first_name" string,
--   "last_name" string,
--   "approval_status" bool,
--   "supervisor_id" number,
--   "employee_type" Employee_type
-- );

ALTER TABLE "Shipments" ADD FOREIGN KEY ("truck_id") REFERENCES "Trucks" ("truck_id");

ALTER TABLE "Expenses" ADD FOREIGN KEY ("truck_id") REFERENCES "Trucks" ("truck_id");

ALTER TABLE "Shipments" ADD FOREIGN KEY ("customer_id") REFERENCES "Customers" ("customer_id");

ALTER TABLE "Shipments" ADD FOREIGN KEY ("driver_id") REFERENCES "Employees" ("employee_id");

ALTER TABLE "Shipments" ADD FOREIGN KEY ("creator_id") REFERENCES "Employees" ("employee_id");

ALTER TABLE "Expenses" ADD FOREIGN KEY ("employee_id") REFERENCES "Employees" ("employee_id");

ALTER TABLE "Expenses" ADD FOREIGN KEY ("reporter_id") REFERENCES "Employees" ("employee_id");

ALTER TABLE "Employees" ADD FOREIGN KEY ("employee_id") REFERENCES "Employees" ("supervisor_id");
