package com.valberoliveira.demoresttemplate.consultacep;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consulta-cep")
@Service
public class ConsultaCepApi
{
    @SuppressWarnings("null")
    @GetMapping("{cep}")
    public CepResultDto  consultaCep(@PathVariable("cep") String cep)
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CepResultDto> resp = 
        restTemplate
            .getForEntity(
                String.format("https://viacep.com.br/ws/%s/json/", cep), CepResultDto.class);

        return resp.getBody();
    }
    
}
