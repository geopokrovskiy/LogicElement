package com.geopokrovskiy.util;

import com.geopokrovskiy.model.And;
import com.geopokrovskiy.model.LogicElement;

public class AndFactory implements ElementFactory1{

    @Override
    public LogicElement newInstance(int n){
        return new And(n);
    }
}
