/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.myorg.commod;

import org.myorg.myapi.acEvent;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author jab7b7
 */
@ServiceProvider(service=acEvent.class)
public class comIndiceGen implements acEvent{

    @Override
    public String process(String s) {
        return s.toUpperCase();
    }
    
}
