/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import com.mongodb.BasicDBObject;
import com.sun.org.apache.xerces.internal.impl.dv.xs.DateTimeDV;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author User
 */
public class donacion extends BasicDBObject {

    protected final String FECHADONACION = "fechadonacion";
    protected final String VALORTOTAL = "valortotal";
    protected final String TIPODEDONACION = "tipodedonaciones";

    private boolean partial;

    public donacion() {
    }
    
    

    public donacion(boolean partial) {
        this.partial = partial;
    }

    public donacion(String fechadonacion, double valortotal, LinkedList<tipo> tipodedonaciones) {
        this.put(FECHADONACION, fechadonacion);
        this.put(VALORTOTAL, valortotal);
        this.put(TIPODEDONACION, tipodedonaciones);
        this.markAsPartialObject();
    }
    
    @Override
    public void markAsPartialObject() {
        Set<String> set = keySet();
        set.remove("_id");

        Set<String> setThis = new HashSet<String>();
        setThis.add(FECHADONACION);
        setThis.add(VALORTOTAL);
        setThis.add(TIPODEDONACION);
        

        partial = !set.equals(setThis);
    }

    public boolean isPartial() {
        return partial;
    }

    public void setPartial(boolean partial) {
        this.partial = partial;
    }

    public String getFECHADONACION() {
        return this.FECHADONACION;
    }
    
     public void setFECHADONACION(String fechadonacion) {
        this.put(FECHADONACION,fechadonacion);
    }

    public String getVALORTOTAL() {
        return VALORTOTAL;
    }
    
     public void setVALORTOTAL(double valortotal) {
        this.put(VALORTOTAL,valortotal );
    }

    public String getTIPODEDONACION() {
        return TIPODEDONACION;
    }
     public void setTIPODEDONACION(LinkedList<tipo>tipodedonaciones) {
        this.put(VALORTOTAL,tipodedonaciones);
    }

    @Override
    public String toString() {
        return "donacion{" + "FECHADONACION=" + FECHADONACION + ", VALORTOTAL=" + VALORTOTAL + ", TIPODEDONACION=" + TIPODEDONACION +  '}';
    }
    
     
    

}
