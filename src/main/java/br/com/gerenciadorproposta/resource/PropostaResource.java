package br.com.gerenciadorproposta.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciadorproposta.model.Proposta;
import br.com.gerenciadorproposta.resource.ApiControllerAdvice.ApiError;
import br.com.gerenciadorproposta.service.PropostaService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("clientes/{idCliente}/propostas")
public class PropostaResource {

    @Autowired
    private PropostaService propostaService;

    @GetMapping
    public List<Proposta> findAll(@PathVariable("idCliente") Long idCliente) {
        return propostaService.findAll(idCliente);
    }

    @GetMapping("/{idProposta}")
    public Proposta findOne(@PathVariable("idCliente") Long idCliente, @PathVariable("idProposta") Long idProposta) {
        return propostaService.findOne(idCliente, idProposta);
    }

    @PostMapping
    @ApiResponses(@ApiResponse(code = 400, message = "Bad request", response = ApiError.class))
    @ResponseStatus(code = HttpStatus.CREATED)
    public Proposta save(@PathVariable("idCliente") Long idCliente, @Valid @RequestBody Proposta proposta) {
        return propostaService.save(idCliente, proposta);
    }

    @PutMapping("/{idProposta}")
    @ApiResponses(@ApiResponse(code = 400, message = "Bad request", response = ApiError.class))
    public Proposta update(@PathVariable("idCliente") Long idCliente, @PathVariable("idProposta") Long idProposta, @Valid @RequestBody Proposta proposta) {
        return propostaService.update(idCliente, idProposta, proposta);
    }

    @DeleteMapping("/{idProposta}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("idCliente") Long idCliente, @PathVariable("idProposta") Long idProposta) {
        propostaService.delete(idCliente, idProposta);
    }
}
