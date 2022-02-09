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
                                    "updated_at" TIMESTAMP NOT NULL,
                                    CONSTRAINT "companies_pk" PRIMARY KEY ("id")
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
                                    "updated_at" TIMESTAMP NOT NULL,
                                    CONSTRAINT "schedules_pk" PRIMARY KEY ("id")
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
                                 "updated_at" TIMESTAMP NOT NULL,
                                 CONSTRAINT "orders_pk" PRIMARY KEY ("id")
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
                                "updated_at" TIMESTAMP NOT NULL,
                                CONSTRAINT "users_pk" PRIMARY KEY ("id")
);



CREATE TABLE "public.roles" (
                                "id" SERIAL PRIMARY KEY NOT NULL,
                                "name" varchar(255) NOT NULL UNIQUE,
                                "enabled" smallint NOT NULL,
                                "created_at" TIMESTAMP NOT NULL,
                                "updated_at" TIMESTAMP NOT NULL,
                                CONSTRAINT "roles_pk" PRIMARY KEY ("id")
);



CREATE TABLE "public.schedule_templates" (
                                             "id" SERIAL PRIMARY KEY NOT NULL,
                                             "name" varchar(255) NOT NULL,
                                             "description" TEXT NOT NULL,
                                             "schema" TEXT NOT NULL,
                                             "enabled" smallint NOT NULL,
                                             "created_at" TIMESTAMP NOT NULL,
                                             "updated_at" TIMESTAMP NOT NULL,
                                             CONSTRAINT "schedule_templates_pk" PRIMARY KEY ("id")
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
                                            "updated_at" TIMESTAMP NOT NULL,
                                            CONSTRAINT "company_employees_pk" PRIMARY KEY ("id")
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

ALTER TABLE "public.schedules" ADD CONSTRAINT "schedules_fk0" FOREIGN KEY ("employee_id") REFERENCES "public.company_employees"("id");
ALTER TABLE "public.schedules" ADD CONSTRAINT "schedules_fk1" FOREIGN KEY ("template_id") REFERENCES "public.schedule_templates"("id");

ALTER TABLE "public.orders" ADD CONSTRAINT "orders_fk0" FOREIGN KEY ("employee_id") REFERENCES "public.company_employees"("id");
ALTER TABLE "public.orders" ADD CONSTRAINT "orders_fk1" FOREIGN KEY ("client_id") REFERENCES "public.client_details"("id");
ALTER TABLE "public.orders" ADD CONSTRAINT "orders_fk3" FOREIGN KEY ("user_id") REFERENCES "public.users"("id");

ALTER TABLE "public.company_employees" ADD CONSTRAINT "company_employees_fk0" FOREIGN KEY ("company_id") REFERENCES "public.companies"("id");
ALTER TABLE "public.company_employees" ADD CONSTRAINT "company_employees_fk1" FOREIGN KEY ("user_id") REFERENCES "public.users"("id");


ALTER TABLE "public.user_roles" ADD CONSTRAINT "user_roles_fk0" FOREIGN KEY ("user_id") REFERENCES "public.users"("id");
ALTER TABLE "public.user_roles" ADD CONSTRAINT "user_roles_fk1" FOREIGN KEY ("role_id") REFERENCES "public.roles"("id");