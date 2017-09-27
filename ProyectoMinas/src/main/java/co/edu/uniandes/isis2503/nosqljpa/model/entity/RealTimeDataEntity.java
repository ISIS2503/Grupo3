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
package co.edu.uniandes.isis2503.nosqljpa.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author ca.mendoza968
 */
@Entity
@Table(name = "REALTIMEDATA")
public class RealTimeDataEntity implements Serializable {

    @Id
    private String id;

    @Temporal(TemporalType.DATE)
    private Date samplingTime;

    private double promTemp;
    private double promCo2;
    private double promSon;
    private double promLuz;
    

    private String idSensor;

    public RealTimeDataEntity() {
    }

    public RealTimeDataEntity(String id, Date date, double promTemp,double promCo2,double promSon,double promLuz, String idSensor) {
        this.id = id;
        this.samplingTime = date;
        this.promTemp = promTemp;
        this.promCo2  = promCo2;
        this.promSon  = promSon;
        this.promLuz  = promLuz;
        this.idSensor = idSensor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getSamplingTime() {
        return samplingTime;
    }

    public void setSamplingTime(Date samplingTime) {
        this.samplingTime = samplingTime;
    }

    public double getPromTemp() {
        return promTemp;
    }

    public void setPromTemp(double promTemp) {
        this.promTemp = promTemp;
    }

    public double getPromCo2() {
        return promCo2;
    }

    public void setPromCo2(double promCo2) {
        this.promCo2 = promCo2;
    }

    public double getPromSon() {
        return promSon;
    }

    public void setPromSon(double promSon) {
        this.promSon = promSon;
    }

    public double getPromLuz() {
        return promLuz;
    }

    public void setPromLuz(double promLuz) {
        this.promLuz = promLuz;
    }


    public String getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(String idSensor) {
        this.idSensor = idSensor;
    }
}
