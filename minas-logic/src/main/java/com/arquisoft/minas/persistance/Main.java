/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arquisoft.minas.persistance;

import java.util.List;

/**
 *
 * @author alejandro
 */
public class Main {
    public static void main(String[] args)
    {
        Persistance p = new Persistance();
        List l = p.findAll();
        System.out.println(l);
    }
}
