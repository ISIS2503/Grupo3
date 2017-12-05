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
package co.edu.uniandes.isis2503.nosqljpa.logic;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.ILimitsLogic;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.LimitsConverter.CONVERTER;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.LimitsDTO;
import co.edu.uniandes.isis2503.nosqljpa.persistence.LimitsPersistence;
import java.util.List;

/**
 *
 * @author a.garcia13
 */
public class LimitsLogic implements ILimitsLogic {

    private final LimitsPersistence persistence;
   // @EJB
    //private SingletonData singleton;

    public LimitsLogic() {
        this.persistence = new LimitsPersistence();
        //this.singleton = new SingletonData();
    }

    @Override
    public LimitsDTO add(LimitsDTO dto) {
        LimitsDTO limit = find(dto.getTipo());
        if(limit==null){
            LimitsDTO result = CONVERTER.entityToDto(persistence.add(CONVERTER.dtoToEntity(dto)));
            return result;
        }
       // singleton.agregarSensor(result);
        return limit;
    }

    @Override
    public LimitsDTO update(LimitsDTO dto) {
        LimitsDTO result = CONVERTER.entityToDto(persistence.update(CONVERTER.dtoToEntity(dto)));
        return result;
    }

    @Override
    public LimitsDTO find(String tipo) {
        return CONVERTER.entityToDto(persistence.find(tipo));
    }

    @Override
    public List<LimitsDTO> all() {
        return CONVERTER.listEntitiesToListDTOs(persistence.all());
    }

    @Override
    public Boolean delete(String id) {
        return persistence.delete(id);
    } 
    
}
