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

import co.edu.uniandes.isis2503.nosqljpa.auth.AuthorizationFilter;
import co.edu.uniandes.isis2503.nosqljpa.auth.Secured;
import co.edu.uniandes.isis2503.nosqljpa.interfaces.INivelLogic;
import co.edu.uniandes.isis2503.nosqljpa.interfaces.IAreaLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.NivelLogic;
import co.edu.uniandes.isis2503.nosqljpa.logic.AreaLogic;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.NivelDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.AreaDTO;
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
    
@Path("/niveles")
@Secured({AuthorizationFilter.Role.admin})
@Produces(MediaType.APPLICATION_JSON)
public class NivelService {

    private final INivelLogic nivelLogic;
    private final IAreaLogic areaLogic;

    public NivelService() {
        this.nivelLogic = new NivelLogic();
        this.areaLogic = new AreaLogic();
    }

    @POST
    public NivelDTO add(NivelDTO dto) {
        return nivelLogic.add(dto);
    }

    @POST
    @Path("{code}/areas")
    public AreaDTO addArea(@PathParam("code") String code, AreaDTO dto) {
        NivelDTO nivel = nivelLogic.findCode(code);
        AreaDTO result = areaLogic.add(dto);
        nivel.addRoom(dto.getId());
        nivelLogic.update(nivel);
        return result;
    }

    @PUT
    public NivelDTO update(NivelDTO dto) {
        return nivelLogic.update(dto);
    }

    @GET
    @Path("/{id}")
    public NivelDTO find(@PathParam("id") String id) {
        return nivelLogic.find(id);
    }

    @GET
    public List<NivelDTO> all() {
        return nivelLogic.all();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        try {
            nivelLogic.delete(id);
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity("Sucessful: El Nivel fue eliminado").build();
        } catch (Exception e) {
            Logger.getLogger(NivelService.class).log(Level.WARNING, e.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin", "*").entity("We found errors in your query, please contact the Web Admin.").build();
        }
    }
}
