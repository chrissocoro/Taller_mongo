/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import com.mongodb.BasicDBObject;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author User
 */
public class tipo extends BasicDBObject {

    protected final String TIPO = "tipo";
    protected final String VALORDONACION = "valordonacion";
    private boolean partial;

    public tipo(boolean partial) {
        this.partial = partial;
    }

    public tipo(String tipo, double valordonacion) {

        this.put(TIPO, tipo);
        this.put(VALORDONACION, valordonacion);
        this.markAsPartialObject();
    }

    

    
    @Override
    public void markAsPartialObject() {
        Set<String> set = keySet();
        set.remove("_id");

        Set<String> setThis = new HashSet<String>();
        setThis.add(TIPO);
        setThis.add(VALORDONACION);
        
        partial = !set.equals(setThis);
    }
    
    
    public String getTIPO() {
        return this.getString(TIPO);
    }

    public void setTIPO(String tipo) {
        this.put(TIPO, tipo);
    }

    public String getVALORDONACION() {
        return this.getString(VALORDONACION);
    }

    public void setVALORDONACION(double valordonacion) {
        this.put(VALORDONACION, valordonacion);
}

    @Override
    public String toString() {
        return "tipo{" + "TIPO=" + TIPO + ", VALORDONACION=" + VALORDONACION + '}';
    }







}
