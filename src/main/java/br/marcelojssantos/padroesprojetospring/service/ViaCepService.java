package br.marcelojssantos.padroesprojetospring.service;

import br.marcelojssantos.padroesprojetospring.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "http://viacep.com.br/ws")
public interface ViaCepService {

//    @RequestMapping(method = RequestMethod.GET, value = "{cep}/json/") <-- faz a mesma coisa que a de baixo
    @GetMapping("{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);
}
