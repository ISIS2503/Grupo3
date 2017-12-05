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

import co.edu.uniandes.isis2503.nosqljpa.interfaces.INivelConverter;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.NivelDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.NivelEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ca.mendoza968
 */
public class NivelConverter implements INivelConverter {

    public static INivelConverter CONVERTER = new NivelConverter();

    public NivelConverter() {
    }

    @Override
    public NivelDTO entityToDto(NivelEntity entity) {
        NivelDTO dto = new NivelDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setRooms(entity.getRooms());
        return dto;
    }

    @Override
    public NivelEntity dtoToEntity(NivelDTO dto) {
        NivelEntity entity = new NivelEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setRooms(dto.getRooms());
        return entity;
    }

    @Override
    public List<NivelDTO> listEntitiesToListDTOs(List<NivelEntity> entities) {
        ArrayList<NivelDTO> dtos = new ArrayList<>();
        for (NivelEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Override
    public List<NivelEntity> listDTOsToListEntities(List<NivelDTO> dtos) {
        ArrayList<NivelEntity> entities = new ArrayList<>();
        for (NivelDTO dto : dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }
}
