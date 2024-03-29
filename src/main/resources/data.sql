INSERT INTO public.department(department_name,code)
    VALUES ('Programmer','D-1') ON CONFLICT (department_name) do nothing;

INSERT INTO public.gender(gender,code)
    VALUES ('Male','G-1') ON CONFLICT (gender) do nothing;

INSERT INTO public.position(position_name,salary_min,salary_max,code)
    VALUES ('DEV',20000,60000,'P-1') ON CONFLICT (position_name) do nothing;

INSERT INTO public.title_name(title_name,code)
    VALUES ('MR.','TN-1') ON CONFLICT (title_name) do nothing;

INSERT INTO public.level(level,code)
    VALUES ('University','L-1') ON CONFLICT (level) do nothing;