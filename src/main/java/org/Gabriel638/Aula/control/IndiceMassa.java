package org.Gabriel638.Aula.control;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class IndiceMassa {
    @GetMapping(value = "/indicemassa")
    public String getIndiceMassa(@RequestParam float peso, @RequestParam float altura) {
        float imc = peso / (altura * altura);
        if (imc < 18.5) {
            return "****" + imc + "**** Voce esta abaixo do peso, isso é um risco elevado a sua saude";
        } else if (imc >= 18.5 && imc <= 24.99) {
            return "****" + imc + "**** Voce esta no peso ideal continue assim, o risco a sua saude é inexistente";
        } else if (imc >= 25 && imc <= 29.99) {
            return "****" + imc + "**** Voce esta com excesso de peso, o risco a sua saude é elevado";
        } else if (imc >= 30 && imc <= 34.99) {
            return "****" + imc + "**** Voce esta com obesidade grau 1, o risco a sua saude é muito elevado";
        } else if (imc >= 35 && imc <= 39.99) {
            return "****" + imc + "**** Voce esta com obesidade grau 2, o risco a sua saude é muitissimo elevado";
        } else {
            return "****" + imc + "**** Voce esta com obesidade grau 3, o risco a sua saude é extremamente elevado, sendo considerado com obesidade morbida";
        }
    }
}
