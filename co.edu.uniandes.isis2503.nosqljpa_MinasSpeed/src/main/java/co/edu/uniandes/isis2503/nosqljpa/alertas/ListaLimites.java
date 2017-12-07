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

import java.util.ArrayList;
import javax.ejb.Singleton;

/**
 *
 * @author a.garcia13
 */
@Singleton
public class ListaLimites {
    
    private double VVarDiariaGas; //Valor de la variacion diaria del gas.
    private double VVarDiariaTemp; //Valor de la variacion diaria de la Temp.
    private double VVarDiariaRuido; //Valor de la variacion diaria del gas.
    private double VVarDiariaLuz; //Valor de la variacion diaria del gas.
        
    private double ValorMinGas;
    private double ValorMaxGas;
    
    private double ValorMinTemp;
    private double ValorMaxTemp;
    
    private double ValorMinRuido;
    private double ValorMaxRuido;
    
    private double ValorMinLuz;
    private double ValorMaxLuz;

    private double LimiteInfGas;
    private double LimiteSupGas;
    
    private double LimiteInfTemp;
    private double LimiteSupTemp;
    
    private double LimiteInfLuz;
    private double LimiteSupLuz;
    
    private double LimiteInfRuido; 
    private double LimiteSupRuido;
    
    public ListaLimites(){
        //TODO get al servicio de limites de la BD
    }

    public double getVVarDiariaGas() {
        return VVarDiariaGas;
    }

    public void setVVarDiariaGas(double VVarDiariaGas) {
        this.VVarDiariaGas = VVarDiariaGas;
    }

    public double getVVarDiariaTemp() {
        return VVarDiariaTemp;
    }

    public void setVVarDiariaTemp(double VVarDiariaTemp) {
        this.VVarDiariaTemp = VVarDiariaTemp;
    }

    public double getVVarDiariaRuido() {
        return VVarDiariaRuido;
    }

    public void setVVarDiariaRuido(double VVarDiariaRuido) {
        this.VVarDiariaRuido = VVarDiariaRuido;
    }

    public double getVVarDiariaLuz() {
        return VVarDiariaLuz;
    }

    public void setVVarDiariaLuz(double VVarDiariaLuz) {
        this.VVarDiariaLuz = VVarDiariaLuz;
    }

    public double getValorMinGas() {
        return ValorMinGas;
    }

    public void setValorMinGas(double ValorMinGas) {
        this.ValorMinGas = ValorMinGas;
    }

    public double getValorMaxGas() {
        return ValorMaxGas;
    }

    public void setValorMaxGas(double ValorMaxGas) {
        this.ValorMaxGas = ValorMaxGas;
    }

    public double getValorMinTemp() {
        return ValorMinTemp;
    }

    public void setValorMinTemp(double ValorMinTemp) {
        this.ValorMinTemp = ValorMinTemp;
    }

    public double getValorMaxTemp() {
        return ValorMaxTemp;
    }

    public void setValorMaxTemp(double ValorMaxTemp) {
        this.ValorMaxTemp = ValorMaxTemp;
    }

    public double getValorMinRuido() {
        return ValorMinRuido;
    }

    public void setValorMinRuido(double ValorMinRuido) {
        this.ValorMinRuido = ValorMinRuido;
    }

    public double getValorMaxRuido() {
        return ValorMaxRuido;
    }

    public void setValorMaxRuido(double ValorMaxRuido) {
        this.ValorMaxRuido = ValorMaxRuido;
    }

    public double getValorMinLuz() {
        return ValorMinLuz;
    }

    public void setValorMinLuz(double ValorMinLuz) {
        this.ValorMinLuz = ValorMinLuz;
    }

    public double getValorMaxLuz() {
        return ValorMaxLuz;
    }

    public void setValorMaxLuz(double ValorMaxLuz) {
        this.ValorMaxLuz = ValorMaxLuz;
    }

    public double getLimiteInfGas() {
        return LimiteInfGas;
    }

    public void setLimiteInfGas(double LimiteInfGas) {
        this.LimiteInfGas = LimiteInfGas;
    }

    public double getLimiteSupGas() {
        return LimiteSupGas;
    }

    public void setLimiteSupGas(double LimiteSupGas) {
        this.LimiteSupGas = LimiteSupGas;
    }

    public double getLimiteInfTemp() {
        return LimiteInfTemp;
    }

    public void setLimiteInfTemp(double LimiteInfTemp) {
        this.LimiteInfTemp = LimiteInfTemp;
    }

    public double getLimiteSupTemp() {
        return LimiteSupTemp;
    }

    public void setLimiteSupTemp(double LimiteSupTemp) {
        this.LimiteSupTemp = LimiteSupTemp;
    }

    public double getLimiteInfLuz() {
        return LimiteInfLuz;
    }

    public void setLimiteInfLuz(double LimiteInfLuz) {
        this.LimiteInfLuz = LimiteInfLuz;
    }

    public double getLimiteSupLuz() {
        return LimiteSupLuz;
    }

    public void setLimiteSupLuz(double LimiteSupLuz) {
        this.LimiteSupLuz = LimiteSupLuz;
    }

    public double getLimiteInfRuido() {
        return LimiteInfRuido;
    }

    public void setLimiteInfRuido(double LimiteInfRuido) {
        this.LimiteInfRuido = LimiteInfRuido;
    }

    public double getLimiteSupRuido() {
        return LimiteSupRuido;
    }

    public void setLimiteSupRuido(double LimiteSupRuido) {
        this.LimiteSupRuido = LimiteSupRuido;
    }
    
    

}
