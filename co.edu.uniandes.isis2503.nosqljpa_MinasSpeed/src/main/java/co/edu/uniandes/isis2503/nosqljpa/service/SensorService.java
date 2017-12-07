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

import co.edu.uniandes.isis2503.nosqljpa.alertas.RealTimeData;
import co.edu.uniandes.isis2503.nosqljpa.alertas.Sensor;
import co.edu.uniandes.isis2503.nosqljpa.alertas.SensorDTO;
import co.edu.uniandes.isis2503.nosqljpa.auth.AuthorizationFilter.Role;
import co.edu.uniandes.isis2503.nosqljpa.auth.Secured;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sensors")
@Secured({Role.admin})
@Produces(MediaType.APPLICATION_JSON)
public class SensorService {
    private final ManejadorLista manejador;

    public SensorService() {
        this.manejador = new ManejadorLista();
    }

    @POST
    public SensorDTO add(SensorDTO sensor) {
        return manejador.add(sensor);
    }

    @POST
    @Path("/{code}/realtimedata")
    public RealTimeData addRealTimeData(@PathParam("code") String code, RealTimeData rtd) {
        try {
            manejador.ActualizarSensor(code, rtd);
        } catch (Exception ex) {
            Logger.getLogger(SensorService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rtd;
    }
    
    @GET
    @Path("/checkState")
    public Sensor check(){
        return manejador.check();
    }
}
