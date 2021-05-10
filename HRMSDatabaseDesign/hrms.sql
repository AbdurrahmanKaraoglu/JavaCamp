-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE public."EmployerVerification"
(
    "Id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 1000000000 CACHE 1 ),
    "EmployerId" integer NOT NULL,
    "PersonnelVerification" boolean NOT NULL,
    PRIMARY KEY ("Id")
);

CREATE TABLE public."Employers"
(
    "UserId" integer NOT NULL,
    "CompanyName" text NOT NULL,
    "Website" text NOT NULL,
    "Phone" text NOT NULL,
    PRIMARY KEY ("UserId")
);

CREATE TABLE public."JobPositions"
(
    "Id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 1000000000 CACHE 1 ),
    "Position" character varying(50) NOT NULL,
    PRIMARY KEY ("Id")
);

CREATE TABLE public."JobSeekerVerification"
(
    "Id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 1000000000 CACHE 1 ),
    "JobSeekerId" integer NOT NULL,
    "MernisVerification" boolean NOT NULL,
    PRIMARY KEY ("Id")
);

CREATE TABLE public."JobSeekers"
(
    "UserId" integer NOT NULL,
    "Name" character varying(50) NOT NULL,
    "Surname" character varying(50) NOT NULL,
    "IdentificationNumber" character varying(11) NOT NULL,
    "YearOfBirth" date NOT NULL,
    PRIMARY KEY ("UserId")
);

CREATE TABLE public."SystemPersonnel"
(
    "UserId" integer NOT NULL,
    "Name" character varying(50) NOT NULL,
    "Surname" character varying(50) NOT NULL,
    PRIMARY KEY ("UserId")
);

CREATE TABLE public."UserVerification"
(
    "Id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 1000000000 CACHE 1 ),
    "UserId" integer NOT NULL,
    "EmailVerification" boolean NOT NULL,
    PRIMARY KEY ("Id")
);

CREATE TABLE public."Users"
(
    "Id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 1000000000 CACHE 1 ),
    "UserId" integer NOT NULL,
    "PositionId" integer NOT NULL,
    "Email" text NOT NULL,
    "Password" text NOT NULL,
    PRIMARY KEY ("Id")
);

ALTER TABLE public."Employers"
    ADD FOREIGN KEY ("UserId")
    REFERENCES public."EmployerVerification" ("EmployerId")
    NOT VALID;


ALTER TABLE public."JobSeekers"
    ADD FOREIGN KEY ("UserId")
    REFERENCES public."JobSeekerVerification" ("JobSeekerId")
    NOT VALID;


ALTER TABLE public."Users"
    ADD FOREIGN KEY ("Id")
    REFERENCES public."Employers" ("UserId")
    NOT VALID;


ALTER TABLE public."Users"
    ADD FOREIGN KEY ("PositionId")
    REFERENCES public."JobPositions" ("Id")
    NOT VALID;


ALTER TABLE public."Users"
    ADD FOREIGN KEY ("Id")
    REFERENCES public."JobSeekers" ("UserId")
    NOT VALID;


ALTER TABLE public."Users"
    ADD FOREIGN KEY ("Id")
    REFERENCES public."SystemPersonnel" ("UserId")
    NOT VALID;


ALTER TABLE public."Users"
    ADD FOREIGN KEY ("Id")
    REFERENCES public."UserVerification" ("UserId")
    NOT VALID;

END;