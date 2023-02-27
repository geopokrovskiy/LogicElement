package com.geopokrovskiy.util;

import com.geopokrovskiy.model.And;
import com.geopokrovskiy.model.LogicElement;
import com.geopokrovskiy.model.Or;
import com.geopokrovskiy.model.Xor;

public class Elements {

    /**
     * Simple Factory
     * @param operation
     * @return
     */
    public static LogicElement newInstance(LogicOperation operation, int n) throws IllegalArgumentException{
        if(operation == LogicOperation.OR){
            return new Or(n);
        }
        else if(operation == LogicOperation.AND){
            return new And(n);
        }
        else if(operation == LogicOperation.XOR){
            return new Xor(n);
        }
        else return null;
    }
}
