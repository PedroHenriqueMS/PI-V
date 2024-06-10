-- Table: public.tb_cliente

-- DROP TABLE IF EXISTS public.tb_cliente;

CREATE TABLE IF NOT EXISTS public.tb_cliente
(
    id integer NOT NULL DEFAULT nextval('tb_cliente_id_seq'::regclass),
    nome character varying(255) COLLATE pg_catalog."default" NOT NULL,
    cpf_cnpj character varying(20) COLLATE pg_catalog."default" NOT NULL,
    telefone character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT tb_cliente_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tb_cliente
    OWNER to postgres;

-- Table: public.tb_produto

-- DROP TABLE IF EXISTS public.tb_produto;

CREATE TABLE IF NOT EXISTS public.tb_produto
(
    id integer NOT NULL DEFAULT nextval('tb_produto_id_seq'::regclass),
    nome character varying(255) COLLATE pg_catalog."default" NOT NULL,
    descricao text COLLATE pg_catalog."default",
    preco numeric(10,2) NOT NULL,
    CONSTRAINT tb_produto_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tb_produto
    OWNER to postgres;

-- Table: public.tb_usuario

-- DROP TABLE IF EXISTS public.tb_usuario;

CREATE TABLE IF NOT EXISTS public.tb_usuario
(
    id integer NOT NULL DEFAULT nextval('tb_usuario_id_seq'::regclass),
    nome character varying(255) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    senha character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT tb_usuario_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tb_usuario
    OWNER to postgres;
