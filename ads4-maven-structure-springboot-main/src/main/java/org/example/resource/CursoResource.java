package org.example.resource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IResource;
import org.example.model.Curso;
import org.example.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j //nos ajuda a escrever log no projeto
@RestController //inicida que é uma camada para api
@RequestMapping("api/v1/curso")
@Tag(name = "curso", description = "documentação do resource curso")
public class CursoResource implements IResource<Curso, Integer> {

    @Autowired //faz a injeção de dependência
    private CursoService cursoService;

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
            summary = "Cadastrar um curso",
            description = "Método responsável para cadastra um curso no sistema",
            tags = {"curso"})
    @ApiResponses({
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "405", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "407", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "401", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "415", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "501", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "502", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "503", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "504", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),

            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
    })
    @Override
    public Curso create(@RequestBody Curso entity) {

        log.info("Cadastro do curso");
        log.debug("Informações do curso: {}", entity);

        return cursoService.create(entity);
    }

    /**
     * Método para consultar T baseado no identificador N informado
     *
     * @param id
     * @return
     */
    @GetMapping(
            value = "/{id}", //http://localhost:8080/api/v1/curso/1
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(
            summary = "Recupera um curso baseado em um identificador",
            description = "Método responsável para recuperar um aluno no sistema baseado no identificador",
            tags = {"curso"})
    @ApiResponses({
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "405", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "407", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "401", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "415", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "501", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "502", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "503", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "504", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),

            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "304", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
    })
    @Override
    public Curso get(@PathVariable("id") Integer id) {
        return cursoService.get(id);
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
            summary = "Recupera uma lista de cursos",
            description = "Método responsável para recuperar uma lista de cursos",
            tags = {"curso"})
    @ApiResponses({
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "405", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "407", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "401", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "415", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "501", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "502", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "503", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "504", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),

            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "206", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "304", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "416", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    @Override
    public List<Curso> get() {
        return cursoService.get();
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
            description = "Método responsável para atualizar todos os dados de um curso.",
            tags = {"curso"})
    @ApiResponses({
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "405", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "407", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "401", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "415", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "501", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "502", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "503", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "504", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),

            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "204", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "409", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })

    @Override
    public Curso update(@PathVariable Integer id, @RequestBody Curso entity) {
        return cursoService.update(id, entity);
    }

    /**
     * Deleta um registro com base no identificador N(id)
     *
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    @Operation(
            summary = "Delete um curso com base no identificador.",
            description = "Método responsável para deletar um curso com base no identificador.",
            tags = {"curso"})
    @ApiResponses({
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "405", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "407", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "401", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "415", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "501", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "502", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "503", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "504", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),

            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "202", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "204", content = {@Content(schema = @Schema(implementation = Curso.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
    })
    @Override
    public void delete(@PathVariable Integer id) {
        cursoService.delete(id);
    }
}
