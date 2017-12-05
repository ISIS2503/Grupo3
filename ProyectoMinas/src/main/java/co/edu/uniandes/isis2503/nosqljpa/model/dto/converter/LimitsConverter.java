/*
 * The MIT License
 *
 * Copyright 2017 Universidad De Los Andes - Departamento de Ingeniería de Sistemas.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package co.edu.uniandes.isis2503.nosqljpa.model.dto.converter;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.ILimitsConverter;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.LimitsDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.LimitsEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a.garcia13
 */
public class LimitsConverter implements ILimitsConverter{
    
    public static ILimitsConverter CONVERTER = new LimitsConverter();

    public LimitsConverter(){
        
    }

    @Override
    public LimitsDTO entityToDto(LimitsEntity entity) {
        LimitsDTO dto = new LimitsDTO();
        dto.setTipo(entity.getTipo());
        dto.setValorMax(entity.getValorMax());
        dto.setValorMin(entity.getValorMin());
        dto.setVarDiaria(entity.getVarDiaria());
        dto.setLimiteInf(entity.getLimiteInf());
        dto.setLimiteSup(entity.getLimiteSup());
        return dto;
    }

    @Override
    public LimitsEntity dtoToEntity(LimitsDTO dto) {
        LimitsEntity entity = new LimitsEntity();
        entity.setTipo(dto.getTipo());
        entity.setValorMax(dto.getValorMax());
        entity.setValorMin(dto.getValorMin());
        entity.setVarDiaria(dto.getVarDiaria());
        entity.setLimiteInf(dto.getLimiteInf());
        entity.setLimiteSup(dto.getLimiteSup());
        return entity;
    }

    @Override
    public List<LimitsDTO> listEntitiesToListDTOs(List<LimitsEntity> entities) {
        ArrayList<LimitsDTO> dtos = new ArrayList<>();
        for (LimitsEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Override
    public List<LimitsEntity> listDTOsToListEntities(List<LimitsDTO> dtos) {
        ArrayList<LimitsEntity> entities = new ArrayList<>();
        for (LimitsDTO dto : dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }
}
