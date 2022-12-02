INSERT INTO public.tab_categorias(descricao, nome) VALUES ('legumes, verduras, e frutas', 'horti-fruti');
INSERT INTO public.tab_categorias(descricao, nome) VALUES ('chocolates, bolachas recheadas e bolos', 'doces');
INSERT INTO public.tab_categorias(descricao, nome) VALUES ('produtos de higiene', 'higiene');

INSERT INTO public.tab_produtos(comprado, nome, valor, id_categoria)VALUES (false, 'maça', 5, 1);
INSERT INTO public.tab_produtos(comprado, nome, valor, id_categoria)VALUES (true, 'oreo', 2.75, 2);
INSERT INTO public.tab_produtos(comprado, nome, valor, id_categoria)VALUES (false, 'pasta de dente', 4.99, 3);
INSERT INTO public.tab_produtos(comprado, nome, valor, id_categoria)VALUES (true, 'papel higienico', 8.99, 3);