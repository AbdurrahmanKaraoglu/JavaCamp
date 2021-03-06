-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE public.candidates
(
    id integer NOT NULL,
    first_name character varying(35) NOT NULL,
    last_name character varying(35) NOT NULL,
    identity_number character varying(11) NOT NULL,
    birth_year character varying(4) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.cities
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483646 CACHE 1 ),
    city_name character varying(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.education_informations
(
    id integer NOT NULL,
    resume_id integer NOT NULL,
    school_name character varying(320) NOT NULL,
    school_department character varying(320) NOT NULL,
    started_date date NOT NULL,
    ended_date date,
    creation_date date NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.employees
(
    id integer NOT NULL,
    first_name character varying(35) NOT NULL,
    last_name character varying(35) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.employer_confirms
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483646 CACHE 1 ),
    employee_id integer,
    is_confirmed boolean,
    confirm_date date,
    employer_id integer,
    PRIMARY KEY (id)
);

CREATE TABLE public.employers
(
    id integer NOT NULL,
    company_name character varying(255) NOT NULL,
    web_address character varying(50) NOT NULL,
    phone_number character varying(12) NOT NULL,
    employer_confirm boolean,
    PRIMARY KEY (id)
);

CREATE TABLE public.foreign_language_knowledges
(
    id integer NOT NULL,
    resume_id integer NOT NULL,
    foreign_language_name character varying(255) NOT NULL,
    foreign_language_level character(1) NOT NULL,
    creation_date date NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_posting_forms
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483646 CACHE 1 ),
    employer_id integer NOT NULL,
    job_position_id integer NOT NULL,
    job_description character varying(255) NOT NULL,
    city_id integer NOT NULL,
    minimum_salary integer,
    maximum_salary integer,
    number_of_open_positions integer NOT NULL,
    release_date date NOT NULL,
    application_deadline date,
    active boolean NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_titles
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483646 CACHE 1 ),
    title character varying(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.programming_languages_or_technologies
(
    id integer NOT NULL,
    resume_id integer NOT NULL,
    programming_or_technology_name character varying(255) NOT NULL,
    creation_date date NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.resumes
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483646 CACHE 1 ),
    candidate_id integer NOT NULL,
    github_address character varying(320),
    linkedin_address character varying(320),
    photo_address character varying(320),
    cover_letter character varying(320),
    creation_date date NOT NULL,
    date_of_update date,
    active boolean,
    PRIMARY KEY (id)
);

CREATE TABLE public.users
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483646 CACHE 1 ),
    email character varying(320) NOT NULL,
    password character varying(25) NOT NULL,
    verify boolean,
    PRIMARY KEY (id)
);

CREATE TABLE public.verification_codes
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483646 CACHE 1 ),
    code character varying(38) NOT NULL,
    is_confirmed boolean NOT NULL,
    created_date date,
    user_id integer,
    confirmed_date date,
    PRIMARY KEY (id)
);

CREATE TABLE public.work_experiences
(
    id integer NOT NULL,
    resume_id integer NOT NULL,
    company_name character varying(255) NOT NULL,
    job_title_id integer NOT NULL,
    started_date date NOT NULL,
    ended_date date,
    creation_date date NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public.candidates
    ADD FOREIGN KEY (id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.education_informations
    ADD FOREIGN KEY (resume_id)
    REFERENCES public.resumes (id)
    NOT VALID;


ALTER TABLE public.employees
    ADD FOREIGN KEY (id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.employer_confirms
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (id)
    NOT VALID;


ALTER TABLE public.employer_confirms
    ADD FOREIGN KEY (employee_id)
    REFERENCES public.employees (id)
    NOT VALID;


ALTER TABLE public.employers
    ADD FOREIGN KEY (id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.foreign_language_knowledges
    ADD FOREIGN KEY (resume_id)
    REFERENCES public.resumes (id)
    NOT VALID;


ALTER TABLE public.job_posting_forms
    ADD FOREIGN KEY (city_id)
    REFERENCES public.cities (id)
    NOT VALID;


ALTER TABLE public.job_posting_forms
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (id)
    NOT VALID;


ALTER TABLE public.job_posting_forms
    ADD FOREIGN KEY (job_position_id)
    REFERENCES public.job_titles (id)
    NOT VALID;


ALTER TABLE public.programming_languages_or_technologies
    ADD FOREIGN KEY (resume_id)
    REFERENCES public.resumes (id)
    NOT VALID;


ALTER TABLE public.resumes
    ADD FOREIGN KEY (candidate_id)
    REFERENCES public.candidates (id)
    NOT VALID;


ALTER TABLE public.verification_codes
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.work_experiences
    ADD FOREIGN KEY (job_title_id)
    REFERENCES public.job_titles (id)
    NOT VALID;


ALTER TABLE public.work_experiences
    ADD FOREIGN KEY (resume_id)
    REFERENCES public.resumes (id)
    NOT VALID;

END;