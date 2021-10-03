package lv.aml.adversemediascreening.core.converters;

import lv.aml.adversemediascreening.core.domain.ResultDecision;
import lv.aml.adversemediascreening.core.dto.ResultDecisionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static lv.aml.adversemediascreening.core.builders.decision.ResultDecisionBuilder.*;
import static lv.aml.adversemediascreening.core.builders.decision.ResultDecisionDTOBuilder.*;

@Component
public class ResultDecisionConverter {

    private final UserConverter userConverter;

    @Autowired
    public ResultDecisionConverter(UserConverter userConverter) {
        this.userConverter = userConverter;
    }

    public ResultDecision convertToEntity(ResultDecisionDTO decisionDTO){
        if(decisionDTO == null){
            return null;
        } else {
            return createResultDecision()
                    .withId(decisionDTO.getId())
                    .withDecision(decisionDTO.getDecision())
                    .withDate(decisionDTO.getDate())
                    .withUser(userConverter.convertToEntity(decisionDTO.getUser()))
                    .build();
        }
    }

    public ResultDecisionDTO convertToDTO(ResultDecision decision){
        if(decision == null){
            return null;
        } else {
            return createResultDecisionDTO()
                    .withId(decision.getId())
                    .withDecision(decision.getDecision())
                    .withDate(decision.getDate())
                    .withUser(userConverter.convertToDTO(decision.getUser()))
                    .build();
        }
    }

    public List<ResultDecision> convertToEntity(List<ResultDecisionDTO> dtos){
        if(dtos != null){
            List<ResultDecision> decisions = new ArrayList<>();
            if(!dtos.isEmpty()){
                for (ResultDecisionDTO dto: dtos){
                    decisions.add(convertToEntity(dto));
                }
            }
            return decisions;
        }
        return null;
    }

    public List<ResultDecisionDTO> convertToDTO(List<ResultDecision> decisions){
        if(decisions != null){
            List<ResultDecisionDTO> dtos = new ArrayList<>();
            if(!decisions.isEmpty()){
                for (ResultDecision decision: decisions){
                    dtos.add(convertToDTO(decision));
                }
            }
            return dtos;
        }
        return null;
    }
}
