#language: pt
#encoding: iso-8859-1

Funcionalidade: Cadastrar tipo de contrata��o
	como um usu�rio habilitado do sistema
	eu quero cadastrar o tipo de contrata��o dos funcion�rios
	para que eu possa gerenciar funcion�rios
	
	Esquema do Cen�rio: Cadastro de tipo de contrata��o com sucesso
	Realizar o cadastro de tipo de contrata��o para um funcion�rio com sucesso.
	
	Dado Acessar a p�gina de cadastro de tipo de contrata��o
	E Selecionar o funcion�rio <funcionario>
	E Selecionar o tipo de contrata��o <tipocontratacao>
	Quando Confirmar a realiza��o do cadastro
	Ent�o Sistema exibe a mensagem "Dados atualizados com sucesso"
	
	Exemplos:
	| funcionario             | tipocontratacao   | 
	| "Ana Paula dos Santos"  | "Estagio"         |
	| "Carlos Alberto Souza"  | "CLT"             |
	| "Eduardo Souza"         | "Pessoa Jur�dica" |
	
	Cen�rio: Valida��o de campos obrigat�rios
	Todos os campos s�o obrigat�rios para o cadastro do tipo de contrata��o.
	
	Dado Acessar a p�gina de cadastro de tipo de contrata��o
	Quando Confirmar a realiza��o do cadastro
	Ent�o Sistema informa que a sele��o do funcion�rio � obrigat�ria
	E Sistema informa que a sele��o do tipo de contrata��o � obrigat�ria

