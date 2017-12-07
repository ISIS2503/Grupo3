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

/**
 *
 * @author a.garcia13
 */
public class Sensor {
    
    private String id;
    private String code;
    private RealTimeData rtd;
    
    private SensorState current;
    
    public Sensor(String id, String code, RealTimeData rtd){
        current = new SensorNormal(id, code, rtd);
    }
    
    public void setCurrent(SensorState s){
        current = s;
    }
    
    public String getId() {
        return current.getCode();
    }

    public void setId(String id) {
        current.setId(id);
    }

    public String getCode() {
        return current.getCode();
    }

    public void setCode(String code) {
        current.setCode(code);
    }

    public RealTimeData getRtd() {
        return current.getRtd();
    }

    public void setRtd(RealTimeData rtd) {
        current.setRtd(rtd);
    }    

    public int checkTime(){
        long t = System.currentTimeMillis() - current.getRtd().getSamplingTime().getTime();
        if (t > 300000) {
            current = new SensorFueraDeLinea(current.getId(), current.getCode(), current.getRtd());
            return 1;
        } else {
            return 0;
        }
    }
    
    public String getState(){
        return current.getState();
    }

    public void alertaRango() {
        if(current.getState().equals("Fuera de Rango")){
            if(current.getContador()==6){
                current = new SensorActuadorIneficiente(current.getId(), current.getCode(), current.getRtd());
            }
        }
        else current = new SensorFueraDeRango(current.getId(), current.getCode(), current.getRtd());
    }
    
}
