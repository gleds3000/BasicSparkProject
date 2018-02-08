package com.exemplo.spark;

import static spark.Spark.*;

/**
 * Hello world!
 * testando o git:
 */
public class App 
{
	public static void main(String[] args) {
	    // Descomente a linha abaixo caso queira que o spark utilize uma porta diferente da padrão (4567).
	    // setPort(8080);

	    // Exemplo de GET simples
	    get("/olamundo", (request, response) -> {
	        return "Olá Mundo GET!";
	    });

	    // Exemplo de POST simples exibindo o corpo da requisição
	    post("/olamundo", (request, response) -> {
	        return "Olá Mundo POST! Corpo: " + request.body();
	    });

	    // Exemplo com parâmetro
	    get("/usuario/:nome", (request, response) -> {
	        return "Nome Informado: " + request.params(":nome");
	    });

	    // Exemplo redirecionando para uma rota
	    get("/redirecionar", (request, response) -> {
	        response.redirect("/olamundo");
	        return null;
	    });

	    // Define o código de status para 401 Unauthorized (Não Autorizado)
	    get("/paginaprivada", (request, response) -> {
	        response.status(401);
	        return "Vocẽ não tem acesso a página solicitada!";
	    });

	    // Exemplo de halt (para imediatamente a requisição de rota ou filtro) com retorno de status 403 Forbidden (Proibido)
	    get("/paginaprotegida", (request, response) -> {
	        halt(403, "Acesso proibido! :(");
	        return null;
	    });
	}
   /* public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }*/
}
