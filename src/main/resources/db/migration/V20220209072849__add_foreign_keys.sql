ALTER TABLE "public.schedules" ADD CONSTRAINT "schedules_fk0" FOREIGN KEY ("employee_id") REFERENCES "public.company_employees"("id");
ALTER TABLE "public.schedules" ADD CONSTRAINT "schedules_fk1" FOREIGN KEY ("template_id") REFERENCES "public.schedule_templates"("id");

ALTER TABLE "public.orders" ADD CONSTRAINT "orders_fk0" FOREIGN KEY ("employee_id") REFERENCES "public.company_employees"("id");
ALTER TABLE "public.orders" ADD CONSTRAINT "orders_fk1" FOREIGN KEY ("client_id") REFERENCES "public.client_details"("id");
ALTER TABLE "public.orders" ADD CONSTRAINT "orders_fk3" FOREIGN KEY ("user_id") REFERENCES "public.users"("id");

ALTER TABLE "public.company_employees" ADD CONSTRAINT "company_employees_fk0" FOREIGN KEY ("company_id") REFERENCES "public.companies"("id");
ALTER TABLE "public.company_employees" ADD CONSTRAINT "company_employees_fk1" FOREIGN KEY ("user_id") REFERENCES "public.users"("id");


ALTER TABLE "public.user_roles" ADD CONSTRAINT "user_roles_fk0" FOREIGN KEY ("user_id") REFERENCES "public.users"("id");
ALTER TABLE "public.user_roles" ADD CONSTRAINT "user_roles_fk1" FOREIGN KEY ("role_id") REFERENCES "public.roles"("id");