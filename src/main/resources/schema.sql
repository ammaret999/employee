CREATE TABLE IF NOT EXISTS public.department(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    department_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT department_pkey PRIMARY KEY (id),
    CONSTRAINT department_department_name_key UNIQUE (department_name)
);

CREATE TABLE IF NOT EXISTS public.gender(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    code character varying COLLATE pg_catalog."default" NOT NULL,
    gender character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT gender_pkey PRIMARY KEY (id),
    CONSTRAINT gender_gender_key UNIQUE (gender)
);

CREATE TABLE IF NOT EXISTS public.position(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    position_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    salary_min integer NOT NULL,
    salary_max integer NOT NULL,
    CONSTRAINT position_pkey PRIMARY KEY (id),
    CONSTRAINT position_position_name_key UNIQUE (position_name)
);

CREATE TABLE IF NOT EXISTS public.title_name(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    title_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT title_name_pkey PRIMARY KEY (id),
    CONSTRAINT title_name_title_name_key UNIQUE (title_name)
);

CREATE TABLE IF NOT EXISTS public.level(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    level character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT level_pkey PRIMARY KEY (id),
    CONSTRAINT level_level_key UNIQUE (level)
);

CREATE TABLE IF NOT EXISTS public.employee(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    title_name integer NOT NULL,
    first_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    nick_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    birthday date NOT NULL,
    gender integer NOT NULL,
    slack_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    phone_number integer NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    start_date date NOT NULL,
    end_date date,
    status boolean NOT NULL,
    department integer NOT NULL,
    position integer NOT NULL,
    image character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT employee_pkey PRIMARY KEY (id),
    CONSTRAINT employee_department_fkey FOREIGN KEY (department)
        REFERENCES public.department (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT employee_gender_fkey FOREIGN KEY (gender)
        REFERENCES public.gender (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT employee_position_fkey FOREIGN KEY (position)
        REFERENCES public.position (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT employee_title_name_fkey FOREIGN KEY (title_name)
        REFERENCES public.title_name (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE IF NOT EXISTS public.education_history(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    employee_id integer NOT NULL,
    level_id integer NOT NULL,
    institution character varying(255) COLLATE pg_catalog."default" NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT education_history_pkey PRIMARY KEY (id),
    CONSTRAINT education_employee FOREIGN KEY (employee_id)
        REFERENCES public.employee (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT education_level FOREIGN KEY (level_id)
        REFERENCES public.level (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE IF NOT EXISTS public.certificate(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    employee_id integer NOT NULL,
    topic character varying(255) COLLATE pg_catalog."default" NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT certificate_pkey PRIMARY KEY (id),
    CONSTRAINT certificate_employee FOREIGN KEY (employee_id)
        REFERENCES public.employee (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE IF NOT EXISTS public.work_history(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    employee_id integer NOT NULL,
    company_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    start_work date NOT NULL,
    end_work date NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT work_history_pkey PRIMARY KEY (id),
    CONSTRAINT work_history_employee FOREIGN KEY (employee_id)
        REFERENCES public.employee (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);