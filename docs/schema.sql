CREATE TABLE "public.companies" (
	"id" serial NOT NULL,
	"name" varchar(255) NOT NULL,
	"enabled" smallint(4) NOT NULL,
	"description" TEXT NOT NULL,
	"contacts" TEXT NOT NULL,
	"destination" varchar(255) NOT NULL,
	"logo" varchar(255) NOT NULL,
	"type" varchar(50) NOT NULL,
	"head_post_name" varchar(255) NOT NULL,
	"head_id" bigint NOT NULL,
	"manager_post_name" varchar(255) NOT NULL,
	"manager_id" bigint NOT NULL,
	CONSTRAINT "companies_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
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
	"single_case" smallint(4) NOT NULL,
	"created_at" TIMESTAMP NOT NULL,
	"updated_at" TIMESTAMP NOT NULL,
	CONSTRAINT "schedules_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "public.orders" (

) WITH (
  OIDS=FALSE
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
) WITH (
  OIDS=FALSE
);



CREATE TABLE "public.roles" (
	"id" serial NOT NULL,
	"name" varchar(255) NOT NULL UNIQUE,
	"enabled" smallint(4) NOT NULL,
	"created_at" TIMESTAMP NOT NULL,
	"updated_at" TIMESTAMP NOT NULL,
	CONSTRAINT "roles_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "public.privileges" (
	"id" serial NOT NULL,
	"name" varchar(255) NOT NULL UNIQUE,
	"enabled" smallint(4) NOT NULL,
	"description" varchar(500) NOT NULL UNIQUE,
	"created_at" TIMESTAMP NOT NULL,
	"updated_at" TIMESTAMP NOT NULL,
	CONSTRAINT "privileges_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "public.order_reports" (

) WITH (
  OIDS=FALSE
);



CREATE TABLE "public.messages" (

) WITH (
  OIDS=FALSE
);



CREATE TABLE "public.message_reports" (

) WITH (
  OIDS=FALSE
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
) WITH (
  OIDS=FALSE
);



CREATE TABLE "public.rates" (

) WITH (
  OIDS=FALSE
);



CREATE TABLE "public.user_reviews" (

) WITH (
  OIDS=FALSE
);



CREATE TABLE "public.order_requests" (

) WITH (
  OIDS=FALSE
);



CREATE TABLE "public.company_employees" (
	"company_id" bigint NOT NULL,
	"user_id" bigint NOT NULL,
	"start_date" TIMESTAMP NOT NULL,
	"end_date" TIMESTAMP NOT NULL,
	"post_name" varchar(255) NOT NULL,
	"id" serial(255) NOT NULL,
	CONSTRAINT "company_employees_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "public.activity_logs" (
	"id" serial NOT NULL,
	"source" varchar(255) NOT NULL,
	"description" TEXT NOT NULL,
	"status" varchar(100) NOT NULL,
	"activity_date" TIMESTAMP NOT NULL,
	CONSTRAINT "activity_logs_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "public.client_details" (

) WITH (
  OIDS=FALSE
);



CREATE TABLE "public.promotions" (

) WITH (
  OIDS=FALSE
);



CREATE TABLE "public.client_discounts" (

) WITH (
  OIDS=FALSE
);



CREATE TABLE "public.user_roles" (
	"user_id" bigint NOT NULL,
	"role_id" bigint NOT NULL
) WITH (
  OIDS=FALSE
);



CREATE TABLE "public.role_privileges" (
	"role_id" bigint NOT NULL,
	"privilege_id" bigint NOT NULL
) WITH (
  OIDS=FALSE
);



CREATE TABLE "public.message_transports" (

) WITH (
  OIDS=FALSE
);



ALTER TABLE "companies" ADD CONSTRAINT "companies_fk0" FOREIGN KEY ("head_id") REFERENCES "users"("id");
ALTER TABLE "companies" ADD CONSTRAINT "companies_fk1" FOREIGN KEY ("manager_id") REFERENCES "users"("id");

ALTER TABLE "schedules" ADD CONSTRAINT "schedules_fk0" FOREIGN KEY ("employee_id") REFERENCES "company_employees"("id");
ALTER TABLE "schedules" ADD CONSTRAINT "schedules_fk1" FOREIGN KEY ("template_id") REFERENCES "schedule_templates"("id");












ALTER TABLE "company_employees" ADD CONSTRAINT "company_employees_fk0" FOREIGN KEY ("company_id") REFERENCES "companies"("id");
ALTER TABLE "company_employees" ADD CONSTRAINT "company_employees_fk1" FOREIGN KEY ("user_id") REFERENCES "users"("id");





ALTER TABLE "user_roles" ADD CONSTRAINT "user_roles_fk0" FOREIGN KEY ("user_id") REFERENCES "users"("id");
ALTER TABLE "user_roles" ADD CONSTRAINT "user_roles_fk1" FOREIGN KEY ("role_id") REFERENCES "roles"("id");

ALTER TABLE "role_privileges" ADD CONSTRAINT "role_privileges_fk0" FOREIGN KEY ("role_id") REFERENCES "roles"("id");
ALTER TABLE "role_privileges" ADD CONSTRAINT "role_privileges_fk1" FOREIGN KEY ("privilege_id") REFERENCES "privileges"("id");























