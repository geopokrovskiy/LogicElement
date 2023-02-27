package com.geopokrovskiy.util;

import com.geopokrovskiy.model.LogicElement;
import com.geopokrovskiy.model.Xor;

public class XorFactory implements ElementFactory1{

    @Override
    public LogicElement newInstance(int n) {
        return new Xor(n);
    }
}
