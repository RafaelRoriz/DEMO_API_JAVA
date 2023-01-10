package com.example.demo.acoes.dados;

import com.example.demo.acoes.dto.acoesDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class dadosAcoes {
    private static final Map<Long, acoesDTO> acoes = new HashMap<>();

    public acoesDTO criar(acoesDTO acoesDTO){
        Long proximoId = acoes.keySet().size() + 1L;

        acoesDTO.setId(proximoId);

        acoes.put(proximoId, acoesDTO);
        return acoesDTO;
    }

    public acoesDTO editar (acoesDTO acoesDTO, Long acoesId){
        acoes.put(acoesId, acoesDTO);
        return acoesDTO;
    }

    public acoesDTO consuID (Long acoesId){
        return acoes.get(acoesId);
    }

    public List<acoesDTO> consuTodos(){
        return new ArrayList<>(acoes.values());
    }

    public String apagar ( Long acoesId){
        acoes.remove(acoesId);
        return "DELETED";
    }
}
