package com.example.demo.acoes.API;

import com.example.demo.acoes.dados.dadosAcoes;
import com.example.demo.acoes.dto.acoesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/acoes", produces = MediaType.APPLICATION_JSON_VALUE)
public class acoesAPI {
    @Autowired

    private dadosAcoes dadosAcoes;

    @PostMapping
    @ResponseBody
    public acoesDTO criar(acoesDTO acoesDTO){
        return dadosAcoes.criar(acoesDTO);
    }

    @PutMapping("/{acoesId}")
    @ResponseBody
    public  acoesDTO editar(@PathVariable("acoesId")Long acoesId,
                            @RequestBody acoesDTO acoesDTO){
        return dadosAcoes.editar(acoesDTO, acoesId);
    }

    @GetMapping
    @ResponseBody
    public List<acoesDTO> consuTodos(){
        return dadosAcoes.consuTodos();
    }

    @DeleteMapping("/{acoesId}")
    @ResponseBody
    public String apagar (@PathVariable("acoesId") Long acoesId){
        return dadosAcoes.apagar(acoesId);
    }

}
