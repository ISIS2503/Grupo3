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

import co.edu.uniandes.isis2503.nosqljpa.alertas.ListaLimites;
import co.edu.uniandes.isis2503.nosqljpa.alertas.ListaSensores;
import co.edu.uniandes.isis2503.nosqljpa.alertas.RealTimeData;
import co.edu.uniandes.isis2503.nosqljpa.alertas.Sensor;
import co.edu.uniandes.isis2503.nosqljpa.alertas.SensorConverter;
import co.edu.uniandes.isis2503.nosqljpa.alertas.SensorDTO;
import java.util.ArrayList;
import javax.ejb.EJB;

/**
 *
 * @author a.garcia13
 */
class ManejadorLista {

    @EJB
    ListaSensores lista;
    @EJB
    ListaLimites limites;
    ArrayList<Sensor> sensores;

    public ManejadorLista() {
        lista = new ListaSensores();
        sensores = lista.get();
    }

    void ActualizarSensor(String code, RealTimeData rtd) throws Exception {
        double LimiteInfLuz = limites.getLimiteInfLuz();
        double LimiteInfRuido = limites.getLimiteInfRuido();
        double LimiteInfGas = limites.getLimiteInfGas();
        double LimiteInfTemp = limites.getLimiteInfTemp();
        double LimiteSupLuz = limites.getLimiteSupLuz();
        double LimiteSupRuido = limites.getLimiteSupRuido();
        double LimiteSupGas = limites.getLimiteSupGas();
        double LimiteSupTemp = limites.getLimiteSupTemp();

        Sensor ssne = null;
        for (Sensor x : sensores) {
            if (x.getCode().equals(code)) {
                ssne = x;
                break;
            }
        }

        if (ssne == null) {
            throw new Exception("No existe el sensor");
        }

        if (rtd.getPromCo2() < LimiteInfGas || rtd.getPromCo2() > LimiteSupGas) {
            ssne.alertaRango();
        }
        if (rtd.getPromLuz() < LimiteInfLuz || rtd.getPromLuz() > LimiteSupLuz) {
            ssne.alertaRango();
        }
        if (rtd.getPromSon() < LimiteInfRuido || rtd.getPromSon() > LimiteSupRuido) {
            ssne.alertaRango();
        }
        if (rtd.getPromTemp() < LimiteInfTemp || rtd.getPromTemp() > LimiteSupTemp) {
            ssne.alertaRango();
        }
        ssne.setRtd(rtd);
    }

    SensorDTO add(SensorDTO sensor) {
        SensorConverter c = new SensorConverter();
        Sensor e = c.dtoToEntity(sensor);
        sensores.add(e);
        return sensor;
    }

    Sensor check() {
        Sensor s = null;
        for (Sensor x : sensores) {
            s = x;
            x.checkTime();
        }
        return s;
    }
}
