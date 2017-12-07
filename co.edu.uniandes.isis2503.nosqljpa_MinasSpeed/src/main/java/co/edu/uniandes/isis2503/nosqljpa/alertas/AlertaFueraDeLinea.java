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
package co.edu.uniandes.isis2503.nosqljpa.alertas;

import co.edu.uniandes.isis2503.nosqljpa.alertas.ConnectionPoolCorreos;
import co.edu.uniandes.isis2503.nosqljpa.alertas.Correo;
import javax.ejb.EJB;
import javax.mail.Session;
import jflex.Out;

/**
 *
 * @author alejandro
 */
class AlertaFueraDeLinea {
    
    private String idSensor;
    
    private String mensaje;
    
    private Long tiempo;
    
    @EJB
    ConnectionPoolCorreos correos = new ConnectionPoolCorreos();

    public AlertaFueraDeLinea(String idSensor) {
        tiempo = System.currentTimeMillis();
        this.idSensor = idSensor;
        mensaje = "el sensor con id: "+idSensor+" se encuentra fuera de linea ";
        System.out.println(mensaje);
        enviarCorreo();
    }
    
    public Long getTiempo() {
        return tiempo;
    }

    public String getIdSensor() {
        return ""+idSensor;
    }

    public String getMensaje() {
        return mensaje;
    }    

    private void enviarCorreo() {
        Session s = correos.checkOut();
        Correo c =new Correo(mensaje,s);
        correos.checkIn(s);
    }
}
