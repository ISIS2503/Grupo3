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

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IAreaConverter;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.AreaDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.AreaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ca.mendoza968
 */
public class AreaConverter implements IAreaConverter {

    public static IAreaConverter CONVERTER = new AreaConverter();

    public AreaConverter() {
    }

    @Override
    public AreaDTO entityToDto(AreaEntity entity) {
        AreaDTO dto = new AreaDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setConsolidatedData(entity.getConsolidatedData());
        dto.setSensors(entity.getSensors());
        return dto;
    }

    @Override
    public AreaEntity dtoToEntity(AreaDTO dto) {
        AreaEntity entity = new AreaEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setSensors(dto.getSensors());
        entity.setConsolidatedData(dto.getConsolidatedData());
        return entity;
    }

    @Override
    public List<AreaDTO> listEntitiesToListDTOs(List<AreaEntity> entities) {
        ArrayList<AreaDTO> dtos = new ArrayList<>();
        for (AreaEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Override
    public List<AreaEntity> listDTOsToListEntities(List<AreaDTO> dtos) {
        ArrayList<AreaEntity> entities = new ArrayList<>();
        for (AreaDTO dto : dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }

}
