package com.valberoliveira.demoresttemplate.consultacep;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CepViewController {

    @GetMapping("/visualizar-cep/{cep}")
    public String visualizarCep(@PathVariable String cep, Model model) {
        ConsultaCepApi consultaCepApi = new ConsultaCepApi();
        CepResultDto cepResultDto = consultaCepApi.consultaCep(cep);

        model.addAttribute("cepData", cepResultDto);

        return "cep-view";
    }
}

