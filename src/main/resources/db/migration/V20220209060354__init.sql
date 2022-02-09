CREATE TABLE "public.companies" (
    "id" SERIAL PRIMARY KEY NOT NULL,
    "name" varchar(255) NOT NULL,
    "enabled" smallint NOT NULL,
    "description" TEXT NOT NULL,
    "contacts" TEXT NOT NULL,
    "destination" varchar(255) NOT NULL,
    "logo" varchar(255) NOT NULL,
    "type" varchar(50) NOT NULL,
    "location" TEXT NOT NULL,
    "location_id" bigint NOT NULL,
    "created_at" TIMESTAMP NOT NULL,
    "updated_at" TIMESTAMP NOT NULL
);



CREATE TABLE "public.schedules" (
    "id" SERIAL PRIMARY KEY NOT NULL,
    "name" varchar(255) NOT NULL,
    "employee_id" bigint NOT NULL,
    "template_id" bigint NOT NULL,
    "description" TEXT NOT NULL,
    "enabled" smallint NOT NULL,
    "start_date" TIMESTAMP NOT NULL,
    "end_date" TIMESTAMP NOT NULL,
    "schema" TEXT NOT NULL,
    "created_at" TIMESTAMP NOT NULL,
    "updated_at" TIMESTAMP NOT NULL
);



CREATE TABLE "public.orders" (
     "id" SERIAL PRIMARY KEY NOT NULL,
     "employee_id" bigint NOT NULL,
     "client_id" bigint NOT NULL,
     "service_type_id" bigint NOT NULL,
     "start_time" TIME NOT NULL,
     "is_refused" smallint NOT NULL,
     "user_id" bigint NOT NULL,
     "order_request_id" bigint NOT NULL,
     "created_at" TIMESTAMP NOT NULL,
     "updated_at" TIMESTAMP NOT NULL
);



CREATE TABLE "public.users" (
    "id" SERIAL PRIMARY KEY NOT NULL,
    "name" varchar(255) NOT NULL,
    "login" varchar(255) NOT NULL,
    "email" varchar(255) NOT NULL,
    "password" varchar(500) NOT NULL,
    "salt" varchar(100) NOT NULL,
    "enabled" smallint NOT NULL,
    "phone" varchar(100) NOT NULL,
    "destination" varchar(255) NOT NULL,
    "image" varchar(255) NOT NULL,
    "created_at" TIMESTAMP NOT NULL,
    "updated_at" TIMESTAMP NOT NULL
);



CREATE TABLE "public.roles" (
    "id" SERIAL PRIMARY KEY NOT NULL,
    "name" varchar(255) NOT NULL UNIQUE,
    "enabled" smallint NOT NULL,
    "created_at" TIMESTAMP NOT NULL,
    "updated_at" TIMESTAMP NOT NULL
);



CREATE TABLE "public.schedule_templates" (
     "id" SERIAL PRIMARY KEY NOT NULL,
     "name" varchar(255) NOT NULL,
     "description" TEXT NOT NULL,
     "schema" TEXT NOT NULL,
     "enabled" smallint NOT NULL,
     "created_at" TIMESTAMP NOT NULL,
     "updated_at" TIMESTAMP NOT NULL
);



CREATE TABLE "public.company_employees" (
    "id" SERIAL PRIMARY KEY NOT NULL,
    "company_id" bigint NOT NULL,
    "user_id" bigint NOT NULL,
    "start_date" TIMESTAMP NOT NULL,
    "end_date" TIMESTAMP NOT NULL,
    "post" varchar(255) NOT NULL,
    "name" varchar(255) NOT NULL,
    "destination" varchar(255) NOT NULL,
    "image" varchar(255) NOT NULL,
    "created_at" TIMESTAMP NOT NULL,
    "updated_at" TIMESTAMP NOT NULL
);



CREATE TABLE "public.client_details" (
     "id" SERIAL PRIMARY KEY NOT NULL,
     "name" varchar(255) NOT NULL,
     "phone" varchar(255) NOT NULL,
     "email" varchar(255) NOT NULL,
     "created_at" TIMESTAMP NOT NULL,
     "updated_at" TIMESTAMP NOT NULL
);



CREATE TABLE "public.user_roles" (
     "user_id" bigint NOT NULL,
     "role_id" bigint NOT NULL
);