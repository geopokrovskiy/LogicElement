package com.geopokrovskiy.model;

public class Xor extends LogicElement {

    /**
     * parameter constructor
     * @param n
     */
    public Xor(int n){
        super(n);
    }

   /* @Override
    protected LogicElement newInstance(int n){
        return new Xor(n);
    }
*/
    @Override
    protected boolean operation(boolean a, boolean b) {
        return a ^ b;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
