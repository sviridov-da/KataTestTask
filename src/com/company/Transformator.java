package com.company;

public abstract class Transformator {
    protected String source;
    protected int result;
    protected Types type;
    public Transformator(String str) throws Exception {
        source = str;
        result = 0;
        transform(source);
    }
    abstract boolean canTransform() throws Exception;
    public int transform(String str) throws Exception {
        canTransform();
        return result;
    }

    public int getResult() {
        return result;
    }

    public Types getType(){
        return type;
    }
}
