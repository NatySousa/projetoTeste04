#language: pt
#encoding: iso-8859-1

Funcionalidade: Cadastrar tipo de contratação
	como um usuário habilitado do sistema
	eu quero cadastrar o tipo de contratação dos funcionários
	para que eu possa gerenciar funcionários
	
	Esquema do Cenário: Cadastro de tipo de contratação com sucesso
	Realizar o cadastro de tipo de contratação para um funcionário com sucesso.
	
	Dado Acessar a página de cadastro de tipo de contratação
	E Selecionar o funcionário <funcionario>
	E Selecionar o tipo de contratação <tipocontratacao>
	Quando Confirmar a realização do cadastro
	Então Sistema exibe a mensagem "Dados atualizados com sucesso"
	
	Exemplos:
	| funcionario             | tipocontratacao   | 
	| "Ana Paula dos Santos"  | "Estagio"         |
	| "Carlos Alberto Souza"  | "CLT"             |
	| "Eduardo Souza"         | "Pessoa Jurídica" |
	
	Cenário: Validação de campos obrigatórios
	Todos os campos são obrigatórios para o cadastro do tipo de contratação.
	
	Dado Acessar a página de cadastro de tipo de contratação
	Quando Confirmar a realização do cadastro
	Então Sistema informa que a seleção do funcionário é obrigatória
	E Sistema informa que a seleção do tipo de contratação é obrigatória

