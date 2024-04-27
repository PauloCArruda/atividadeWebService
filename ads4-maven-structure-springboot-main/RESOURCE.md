#Aula 08-04 SENAI

## Inserir dependência
```xml
    <!-- https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui -->
    <dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
      <version>2.2.0</version>
    </dependency>
```

### Exemplo de uso da documentação

```java
package org.example.resource;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IResource;
import org.example.model.Aluno;
import org.example.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j //nos ajuda a escrever log no projeto
@RestController //inicida que é uma camada para api
@RequestMapping("api/v1/aluno")
@Tag(name = "aluno", description = "documentação do resource aluno")
public class AlunoResource implements IResource<Aluno, Integer> {

  @Autowired //faz a injeção de dependência
  private AlunoService alunoService;

  /**
   * Mètodo para criar T
   *
   * @param entity
   * @return
   */
  @PostMapping(
          consumes = {MediaType.APPLICATION_JSON_VALUE,
                  MediaType.APPLICATION_XML_VALUE},
          produces = {MediaType.APPLICATION_JSON_VALUE}
  )
  @Operation(
          summary = "Cria um aluno",
          description = "Método responsável para criar um aluno no sistema",
          tags = {"aluno"})
  @ApiResponses({
          @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Aluno.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
          @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
          @ApiResponse(responseCode = "304", content = { @Content(schema = @Schema()) }),
          @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
          @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
  @Override
  public Aluno create(@RequestBody Aluno entity) {

    log.info("Cadastro do aluno iniciado");
    log.debug("Informações do aluno: {}", entity);

    return alunoService.create(entity);
  }

  /**
   * Método para consultar T baseado no identificador N informado
   *
   * @param id
   * @return
   */
  @GetMapping(
          value = "/{id}", //http://localhost:8080/api/v1/aluno/1
          produces = {MediaType.APPLICATION_JSON_VALUE})
  @Operation(
          summary = "Recupera um aluno baseado em um identificador",
          description = "Método responsável para recuperar um aluno no sistema baseado no identificador",
          tags = {"aluno"})
  @ApiResponses({
          @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Aluno.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
          @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
          @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
          @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
  @Override
  public Aluno get(@PathVariable("id") Integer id) {
    return alunoService.get(id);
  }

  /**
   * Retorna uma lista de T
   *
   * @return
   */
  @GetMapping(
          produces = {MediaType.APPLICATION_JSON_VALUE}
  )
  @Operation(
          summary = "Recupera uma lista de alunos",
          description = "Método responsável para recuperar uma lista de alunos",
          tags = {"aluno"})
  @ApiResponses({
          @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Aluno.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
          @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
          @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
          @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
  @Override
  public List<Aluno> get() {
    return alunoService.get();
  }

  /**
   * Iremos passar N(id) para buscar o registro e T(entity) para atualizar o objeto;
   *
   * @param id
   * @param entity
   * @return
   */
  @PutMapping(
          value = "/{id}",
          consumes = {MediaType.APPLICATION_JSON_VALUE},
          produces = {MediaType.APPLICATION_JSON_VALUE}
  )
  @Operation(
          summary = "Atualiza todos os dados de um aluno",
          description = "Método responsável para atualizar todos os dados de um aluno.",
          tags = {"aluno"})
  @ApiResponses({
          @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Aluno.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
          @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
          @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
          @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
  @Override
  public Aluno update(@PathVariable Integer id, @RequestBody Aluno entity) {
    return alunoService.update(id, entity);
  }

  /**
   * Deleta um registro com base no identificador N(id)
   *
   * @param id
   */
  @DeleteMapping(value = "/{id}")
  @Operation(
          summary = "Delete um aluno com base no identificador.",
          description = "Método responsável para deletar um aluno com base no identificador.",
          tags = {"aluno"})
  @ApiResponses({
          @ApiResponse(responseCode = "206", content = { @Content(schema = @Schema(implementation = Aluno.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
          @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
          @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
          @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
  @Override
  public void delete(@PathVariable Integer id) {
    alunoService.delete(id);
  }
}

```

##Status HTTP por verbos

### Status globais
* 400 - geralmente erro de negócio
* 405 - método não permitido (ht)
* 407 - proxy
* 401 - não autorizado
* 403 - acesso negado
* 415 - 415 (tipo de mídia não suportado)
* 500 Erro interno do servidor
* 501 Não Implementado
* 502 Bad Gateway
* 503 serviço indisponível
* 504 Tempo limite do gateway


### POST
* 201 (Created) SHOULD
* 200 (OK) or 204 (No Content)
* 303 (See Other) - redirecionamento

### GET
https://www.rfc-editor.org/rfc/rfc9110.html#name-get
* 200 - OK - Encontrei alguma coisa
*  304 (Not Modified)  - Range é ignorado quando um GET condicional resultaria em uma resposta 304 (Não Modificada) .
* 206 (Partial Content) - , o servidor DEVE enviar uma resposta 206 (Conteúdo Parcial) com conteúdo contendo uma ou mais representações parciais que correspondam às especificações de intervalo satisfatórias solicitadas.
* 416 (Range Not Satisfiable) response. - Range fora do intervalo

###PUT
Atualiza registro. Se não encontrar registro para atualizar, cria.
* 200 (OK) or a 204 (No Content)
*  201 (Created)  - se não encontrar recurso para atualização, é criado um novo recurso.
* 409 Conflict - O código de status 409 (Conflito) indica que a solicitação não pôde ser concluída devido a um conflito com o estado atual do recurso de destino. Este código é usado em situações em que o usuário pode resolver o conflito e reenviar a solicitação. O servidor DEVE gerar conteúdo que inclua informações suficientes para que um usuário reconheça a origem do conflito.

### DELETE
* status 202 (Aceito) se a ação provavelmente será bem-sucedida, mas ainda não foi decretada,
* status 204 (Sem conteúdo) se a ação foi decretada e nenhuma informação adicional deve ser fornecida, ou
* status 200 (OK) se a ação tiver sido executada e a mensagem de resposta incluir uma representação que descreve o status.

### OPTIONS
* O método OPTIONS solicita informações sobre as opções de comunicação disponíveis para o recurso de destino, no servidor de origem ou em um intermediário interveniente. Este método permite que um cliente determine as opções e/ou requisitos associados a um recurso, ou as capacidades de um servidor, sem implicar uma ação de recurso.
* Resumindo: traz os métodos permitidos que a API responde.

### PATCH
https://www.rfc-editor.org/rfc/rfc5789
* status 204 (Sem conteúdo) é usado, porque a resposta não carrega um corpo de carga útil.
* Uma 200 (OK) resposta poderia conter um corpo de carga útil.
* 400 (solicitação incorreta) - Documento de patch malformado - O conteúdo do arquivo contém erros.
* 415 (tipo de mídia não suportado) - Documento de patch não suportado. Indica que o recurso enviado não é suportado. Exemplo: enviar json para API quando ela espera xml.
* resposta 422 (Entidade não processável) - O código de status 422 (Entidade Não Processável) significa que o servidor entende o tipo de conteúdo da entidade solicitada (portanto, um
  415 (código de status de tipo de mídia não suportado) é inadequado) e o
  a sintaxe da entidade de solicitação está correta (portanto, um 400 (Bad Request)
  o código de status é inadequado), mas não foi possível processar o código de status contido
  instruções. Por exemplo, esta condição de erro pode ocorrer se um XML
  o corpo da solicitação contém informações bem formadas (ou seja, sintaticamente corretas), mas
  instruções XML semanticamente erradas.

Requisição PATCH:

```http
PATCH /api/users/123 HTTP/1.1
Host: example.com
Content-Type: application/json
Content-Length: 26

{
    "name": "Jo"
}
```
Resposta 422 (Unprocessable Entity):

```http
HTTP/1.1 422 Unprocessable Entity
Content-Type: application/json
Content-Length: 76

{
    "error": "Unprocessable Entity",
    "message": "O nome fornecido é muito curto, deve ter pelo menos 3 caracteres"
}
```
Neste exemplo, a requisição PATCH está tentando atualizar o nome do usuário com um nome muito curto. O servidor reconhece o tipo de conteúdo e a sintaxe da entidade solicitada (ou seja, a requisição está em JSON e bem formada), mas não pode processar a instrução contida (porque o nome é muito curto). Assim, o servidor responde com um código de status 422 e uma mensagem explicativa indicando o motivo da falha.