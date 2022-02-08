CREATE TABLE "public.companies" (
	"id" serial NOT NULL,
	"name" varchar(255) NOT NULL,
	"enabled" smallint(4) NOT NULL,
	"description" TEXT NOT NULL,
	"contacts" TEXT NOT NULL,
	"destination" varchar(255) NOT NULL,
	"logo" varchar(255) NOT NULL,
	"type" varchar(50) NOT NULL,
	"location" TEXT NOT NULL,
	"location_id" bigint NOT NULL,
	"created_at" TIMESTAMP NOT NULL,
	"updated_at" TIMESTAMP NOT NULL,
	CONSTRAINT "companies_pk" PRIMARY KEY ("id")
);



CREATE TABLE "public.schedules" (
	"id" serial NOT NULL,
	"name" varchar(255) NOT NULL,
	"employee_id" bigint NOT NULL,
	"template_id" bigint NOT NULL,
	"description" TEXT NOT NULL,
	"enabled" smallint(4) NOT NULL,
	"start_date" TIMESTAMP NOT NULL,
	"end_date" TIMESTAMP NOT NULL,
	"schema" TEXT NOT NULL,
	"created_at" TIMESTAMP NOT NULL,
	"updated_at" TIMESTAMP NOT NULL,
	CONSTRAINT "schedules_pk" PRIMARY KEY ("id")
);



CREATE TABLE "public.orders" (
	"id" serial NOT NULL,
	"employee_id" bigint NOT NULL,
	"client_id" bigint NOT NULL,
	"service_type_id" bigint NOT NULL,
	"start_time" TIME NOT NULL,
	"is_refused" smallint(4) NOT NULL,
	"created_at" TIMESTAMP NOT NULL,
	"updated_at" TIMESTAMP NOT NULL,
	"user_id" bigint NOT NULL,
	"order_request_id" bigint NOT NULL,
	CONSTRAINT "orders_pk" PRIMARY KEY ("id")
);



CREATE TABLE "public.users" (
	"id" serial NOT NULL,
	"name" varchar(255) NOT NULL,
	"login" varchar(255) NOT NULL,
	"email" varchar(255) NOT NULL,
	"password" varchar(500) NOT NULL,
	"salt" varchar(100) NOT NULL,
	"enabled" smallint(4) NOT NULL,
	"phone" varchar(100) NOT NULL,
	"created_at" TIMESTAMP NOT NULL,
	"updated_at" TIMESTAMP NOT NULL,
	"destination" varchar(255) NOT NULL,
	"image" varchar(255) NOT NULL,
	CONSTRAINT "users_pk" PRIMARY KEY ("id")
);



CREATE TABLE "public.roles" (
	"id" serial NOT NULL,
	"name" varchar(255) NOT NULL UNIQUE,
	"enabled" smallint(4) NOT NULL,
	"created_at" TIMESTAMP NOT NULL,
	"updated_at" TIMESTAMP NOT NULL,
	CONSTRAINT "roles_pk" PRIMARY KEY ("id")
);



CREATE TABLE "public.schedule_templates" (
	"id" serial NOT NULL,
	"name" varchar(255) NOT NULL,
	"description" TEXT NOT NULL,
	"schema" TEXT NOT NULL,
	"enabled" smallint(4) NOT NULL,
	"created_at" TIMESTAMP NOT NULL,
	"updated_at" TIMESTAMP NOT NULL,
	CONSTRAINT "schedule_templates_pk" PRIMARY KEY ("id")
);



CREATE TABLE "public.company_employees" (
	"company_id" bigint NOT NULL,
	"user_id" bigint NOT NULL,
	"start_date" TIMESTAMP NOT NULL,
	"end_date" TIMESTAMP NOT NULL,
	"post" varchar(255) NOT NULL,
	"id" serial(255) NOT NULL,
	"name" varchar(255) NOT NULL,
	"destination" varchar(255) NOT NULL,
	"image" varchar(255) NOT NULL,
	CONSTRAINT "company_employees_pk" PRIMARY KEY ("id")
);



CREATE TABLE "public.client_details" (
	"id" bigint NOT NULL,
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



ALTER TABLE "companies" ADD CONSTRAINT "companies_fk0" FOREIGN KEY ("location_id") REFERENCES "locations"("id");

ALTER TABLE "schedules" ADD CONSTRAINT "schedules_fk0" FOREIGN KEY ("employee_id") REFERENCES "company_employees"("id");
ALTER TABLE "schedules" ADD CONSTRAINT "schedules_fk1" FOREIGN KEY ("template_id") REFERENCES "schedule_templates"("id");

ALTER TABLE "orders" ADD CONSTRAINT "orders_fk0" FOREIGN KEY ("employee_id") REFERENCES "company_employees"("id");
ALTER TABLE "orders" ADD CONSTRAINT "orders_fk1" FOREIGN KEY ("client_id") REFERENCES "client_details"("id");
ALTER TABLE "orders" ADD CONSTRAINT "orders_fk2" FOREIGN KEY ("service_type_id") REFERENCES "service_types"("id");
ALTER TABLE "orders" ADD CONSTRAINT "orders_fk3" FOREIGN KEY ("user_id") REFERENCES "users"("id");
ALTER TABLE "orders" ADD CONSTRAINT "orders_fk4" FOREIGN KEY ("order_request_id") REFERENCES "order_requests"("id");




ALTER TABLE "company_employees" ADD CONSTRAINT "company_employees_fk0" FOREIGN KEY ("company_id") REFERENCES "companies"("id");
ALTER TABLE "company_employees" ADD CONSTRAINT "company_employees_fk1" FOREIGN KEY ("user_id") REFERENCES "users"("id");


ALTER TABLE "user_roles" ADD CONSTRAINT "user_roles_fk0" FOREIGN KEY ("user_id") REFERENCES "users"("id");
ALTER TABLE "user_roles" ADD CONSTRAINT "user_roles_fk1" FOREIGN KEY ("role_id") REFERENCES "roles"("id");










