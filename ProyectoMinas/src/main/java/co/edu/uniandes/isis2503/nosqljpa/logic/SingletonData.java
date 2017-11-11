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

import co.edu.uniandes.isis2503.nosqljpa.interfaces.ISensorLogic;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.RealTimeDataDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.SensorDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author alejandro
 */
@Singleton
public class SingletonData{
    
    private ISensorLogic sensorLogic;
    
    private final double VVarDiariaGas = 0; //Valor de la variacion diaria del gas.
    
    private final double VVarDiariaTemp = 5.4; //Valor de la variacion diaria de la Temp.
    
    private final double VVarDiariaRuido = 0; //Valor de la variacion diaria del gas.
    
    private final double VVarDiariaLuz = 0; //Valor de la variacion diaria del gas.
    
    //private long LastVarUpdate = 0; //Ultimo momento en que se actualizo el valor de la variacion diaria
    
    private final double ValorMinGas = 0;
    private final double ValorMaxGas = 100;
    
    private final double ValorMinTemp = 21.5;
    private final double ValorMaxTemp = 27.5;
    
    private final double ValorMinRuido = 0;
    private final double ValorMaxRuido = 85;
    
    private final double ValorMinLuz = 100;
    private final double ValorMaxLuz = 2000;

    private double LimiteInfGas;
    private double LimiteSupGas;
    
    private double LimiteInfTemp;
    private double LimiteSupTemp;
    
    private double LimiteInfLuz;
    private double LimiteSupLuz;
    
    private double LimiteInfRuido; 
    private double LimiteSupRuido;
    
    private boolean ready = false;
    
    private long clock;
    
    private String[] sensorzona; 
    private long[] sensortime;
    private ArrayList<AlertaFueraDeRango> aRango;
    private ArrayList<AlertaActuadorIneficiente> aInef;
    private ArrayList<AlertaFueraDeLinea> alertas;
    
    public SingletonData(){
            LimiteInfGas = ValorMinGas - VVarDiariaGas;
            LimiteSupGas = ValorMaxGas + VVarDiariaGas;
            LimiteInfTemp = ValorMinTemp - VVarDiariaTemp;
            LimiteSupTemp = ValorMaxTemp + VVarDiariaTemp;
            LimiteInfLuz = ValorMinLuz - VVarDiariaLuz;
            LimiteSupLuz = ValorMaxLuz + VVarDiariaLuz;
            LimiteInfRuido = ValorMinRuido - VVarDiariaRuido;
            LimiteSupRuido = ValorMaxRuido + VVarDiariaRuido;
            sensortime = new long[5000];
            sensorzona  = new String[5000];
            this.sensorLogic = new SensorLogic();
            cargarSensores();
            alertas = new ArrayList<>();
            aRango = new ArrayList<>();
            aInef = new ArrayList<>();
            clock = System.currentTimeMillis();
            ready = true;
            System.out.println("Initialized at " + new Date());
    }
    
    private void cargarSensores(){
        long tiempoActual = System.currentTimeMillis();
        List<SensorDTO> dtos = sensorLogic.all();
        for(SensorDTO x: dtos){
            int id = Integer.parseInt(x.getId());
            sensorzona[id] = x.getCode();
            sensortime[id] =  tiempoActual;
        }
    }
    
    public void agregarSensor(SensorDTO dto){
        long tiempoActual = System.currentTimeMillis();
        int id = Integer.parseInt(dto.getId());
        sensortime[id] =  tiempoActual;
        sensorzona[id] = dto.getCode();
    }
    
    public void comprobarSensores(){
        long timepoActual = System.currentTimeMillis();
        
        int id = 0;
        for(long x: sensortime){
            if(x+300000<timepoActual){
                alertas.add(new AlertaFueraDeLinea(id,sensorzona[id]));
            }
            id++;
        }
    }
    
    public void ActualizarTiempo(String id, Date fecha){
        long timepoActual = System.currentTimeMillis();
        int idint = Integer.parseInt(id);
        sensortime[idint]= fecha.getTime();
        if(timepoActual>clock+60000){
            comprobarSensores();
            clock=clock+60001;
        }

    }

    public double getLimiteInfGas() {
        return LimiteInfGas;
    }
    
    public double getLimiteSupGas() {
        return LimiteSupGas;
    }

    public double getLimiteInfTemp() {
        return LimiteInfTemp;
    }

    public double getLimiteSupTemp() {
        return LimiteSupTemp;
    }

    public double getLimiteInfLuz() {
        return LimiteInfLuz;
    }

    public double getLimiteSupLuz() {
        return LimiteSupLuz;
    }

    public double getLimiteInfRuido() {
        return LimiteInfRuido;
    }

    public double getLimiteSupRuido() {
        return LimiteSupRuido;
    }
    
    public void agregarAlertaRango(RealTimeDataDTO dto){
        int idint = Integer.parseInt(dto.getIdSensor());
        String zona = sensorzona[idint];
        AlertaFueraDeRango a = buscarAlertas(idint);//aRango.get(idint);
        if(a==null){
            aRango.add(new AlertaFueraDeRango(idint,zona));
        }
        else{
            int n = a.agregarAlerta();
            if (n == -1){
                aInef.add(new AlertaActuadorIneficiente(idint,zona));
                a.reset();
            }
        }
    }

    private AlertaFueraDeRango buscarAlertas(int idint) {
        for(AlertaFueraDeRango x: aRango){
            int idS = Integer.parseInt(x.getIdSensor());
            if(idS==idint){
                return x;
            }
        } 
        return null;
    }
    
}
