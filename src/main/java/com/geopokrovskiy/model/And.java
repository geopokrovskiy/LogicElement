package com.geopokrovskiy.model;

public class And extends LogicElement{

    /**
     * parameter constructor
     * @param n
     */
    public And(int n){
        super(n);
    }

   /* @Override
    protected LogicElement newInstance(int n){
        return new Or(n);
    }*/

    @Override
    protected boolean operation(boolean a, boolean b) {
        return a && b;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
