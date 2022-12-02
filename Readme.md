Este é um sistema criado para a LAB Supermarket poder controlar suas vendas.

Cada protudo so pode ter uma categora, mas uma categoria pode ter varios produtos cadastrados.
lembre-se de ao cadastrar uma nova categoria, verificar se ela ja nao existe, pois categorias repetidas nao serao criadas.
para adicionar uma nova categoria, usamos o metodo post, da seguinte forma:
{
  "nome": "",
  "descricao": ""
}

para adicionar um novo produto, fazemos da seguinte forma:
{
  "nome": "",
  "valor":",
  "comprado": true || false
  "categoria": {
    "id": ""
  }
}


obs.: para saber se um produto foi comprado ou nao, verificamos se o estado de "comprado" é true, se for, é porque o produto foi comprado, se for false, é porque nao foi comprado

comprado === true => foi comprado
comprado === false => nao foi comprado

quando quiser editar algum produto:
{
    "nome": "",
    "valor": ,
    "comprado": true || false
    "categoria": {
        "id": 1
        }
}

quando quiser editar alguma categoria:
{
  "id": "",
  "nome": "",
  "descricao": ""
}