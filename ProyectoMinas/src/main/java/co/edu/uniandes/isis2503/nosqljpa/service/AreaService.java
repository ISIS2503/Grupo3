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
package co.edu.uniandes.isis2503.nosqljpa.service;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IConsolidatedDataLogic;
import co.edu.uniandes.isis2503.nosqljpa.interfaces.IAreaLogic;
import co.edu.uniandes.isis2503.nosqljpa.interfaces.ISensorLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.ConsolidatedDataLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.AreaLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.SensorLogic;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.ConsolidatedDataDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.AreaDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.SensorDTO;
import com.sun.istack.logging.Logger;
import java.util.List;
import java.util.logging.Level;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author a.garcia13
 */
@Path("/areas")
@Produces(MediaType.APPLICATION_JSON)
public class AreaService {
    private final IAreaLogic areaLogic;
    private final IConsolidatedDataLogic consolidateddataLogic;
    private final ISensorLogic sensorLogic;

    public AreaService() {
        this.areaLogic = new AreaLogic();
        this.consolidateddataLogic = new ConsolidatedDataLogic();
        this.sensorLogic = new SensorLogic();
    }

    @POST
    public AreaDTO add(AreaDTO dto) {
        return areaLogic.add(dto);
    }

    @POST
    @Path("{code}/consolidateddata")
    public ConsolidatedDataDTO addConsolidatedData(@PathParam("code") String code, ConsolidatedDataDTO dto) {
        AreaDTO room = areaLogic.findCode(code);
        //Find the id of the measurement associated with the first sensor on the room
        dto.setMeasurementID(sensorLogic.find(room.getSensors().get(0)).getMeasurements().get(0));
        dto.setRoomID(room.getId());
        ConsolidatedDataDTO result = consolidateddataLogic.add(dto);
        room.addConsolidatedData(dto.getId());
        areaLogic.update(room);
        return result;
    }
    
    @GET
    @Path("{code}/consolidateddata")
    public List<ConsolidatedDataDTO> getConsolidatedData(@PathParam("code") String code) {
        AreaDTO room = areaLogic.findCode(code);
        return consolidateddataLogic.findByRoomId(room.getId());
    }
    
    @POST
    @Path("{code}/sensors")
    public SensorDTO addSensor(@PathParam("code") String code, SensorDTO dto) {
        AreaDTO room = areaLogic.findCode(code);
        SensorDTO result = sensorLogic.add(dto);
        room.addSensor(dto.getId());
        areaLogic.update(room);
        return result;
    }

    @PUT
    public AreaDTO update(AreaDTO dto) {
        return areaLogic.update(dto);
    }

    @GET
    @Path("/{id}")
    public AreaDTO find(@PathParam("id") String id) {
        return areaLogic.find(id);
    }

    @GET
    public List<AreaDTO> all() {
        return areaLogic.all();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        try {
            areaLogic.delete(id);
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity("Sucessful: Room was deleted").build();
        } catch (Exception e) {
            Logger.getLogger(AreaService.class).log(Level.WARNING, e.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin", "*").entity("We found errors in your query, please contact the Web Admin.").build();
        }
    }    
}
