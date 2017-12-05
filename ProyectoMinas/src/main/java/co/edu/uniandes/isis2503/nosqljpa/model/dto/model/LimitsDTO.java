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
package co.edu.uniandes.isis2503.nosqljpa.model.dto.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a.garcia13
 */
@XmlRootElement
public class LimitsDTO {
    
    String tipo;
    
    double ValorMax;
    
    double ValorMin;
    
    double VarDiaria;
    
    double LimiteSup;
    
    double LimiteInf;

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setLimiteSup(double LimiteSup) {
        this.LimiteSup = LimiteSup;
    }

    public void setLimiteInf(double LimiteInf) {
        this.LimiteInf = LimiteInf;
    }

    public void setValorMax(double ValorMax) {
        this.ValorMax = ValorMax;
    }

    public void setValorMin(double ValorMin) {
        this.ValorMin = ValorMin;
    }

    public void setVarDiaria(double VarDiaria) {
        this.VarDiaria = VarDiaria;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValorMax() {
        return ValorMax;
    }

    public double getValorMin() {
        return ValorMin;
    }

    public double getVarDiaria() {
        return VarDiaria;
    }

    public double getLimiteSup() {
        return LimiteSup;
    }

    public double getLimiteInf() {
        return LimiteInf;
    }
}
