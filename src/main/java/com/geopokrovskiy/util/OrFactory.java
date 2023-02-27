package com.geopokrovskiy.util;

import com.geopokrovskiy.model.LogicElement;
import com.geopokrovskiy.model.Or;

public class OrFactory implements ElementFactory1{

    @Override
    public LogicElement newInstance(int n) {
        return new Or(n);
    }
}
