/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import com.mongodb.BasicDBObject;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author User
 */
public class Donante extends BasicDBObject {

    protected final String ID = "id";
    protected final String NOMBRE = "nombre";
    protected final String CORREO = "correo";
    protected final String DIRECCION = "direccion";
    private boolean partial;

    public Donante() {
    }
    
    

    public Donante(boolean partial) {
        this.partial = partial;
    }

    public Donante(String id, String nombre, String correo, String direccion) {

        this.put(ID, id);
        this.put(NOMBRE, nombre);
        this.put(CORREO, correo);
        this.put(DIRECCION, direccion);
        this.markAsPartialObject();

    }

    @Override
    public void markAsPartialObject() {
        Set<String> set = keySet();
        set.remove("_id");

        Set<String> setThis = new HashSet<String>();
        setThis.add(ID);
        setThis.add(NOMBRE);
        setThis.add(CORREO);
        setThis.add(DIRECCION);

        partial = !set.equals(setThis);
    }

    public String getID() {
        return this.getString(ID);
    }

    public void setID(String id) {
        this.put(ID, id);
    }

    public String getNombre() {
        return this.getString(NOMBRE);
    }

    public void setNombre(String nombre) {
        this.put(NOMBRE, nombre);
    }

    public String getCORREO() {
        return this.getString(CORREO);
    }

    public void setCORREO(String correo) {
        this.put(CORREO, correo);
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String direccion) {
        this.put(DIRECCION, direccion);
    }

    public boolean isPartialObject() {
        return partial;
    }

    public void setPartial(boolean partial) {
        this.partial = partial;
    }

    @Override
    public String toString() {
        return "Donante{" + "ID=" + ID + ", NOMBRE=" + NOMBRE + ", CORREO=" + CORREO + ", DIRECCION=" + DIRECCION + '}';
    }
    
    

}
