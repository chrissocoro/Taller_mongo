/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller_mongo;

import clases.Donante;
import clases.donacion;
import clases.tipo;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Taller_mongo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            DB ob = createConnection();
            if (ob != null) {
                // BasicDBObject object = new BasicDBObject();
                //categorias c=new categorias("Asociado 1");
                Donante Dt = new Donante("1128225", "Cristian ocoro", "Cristian.ocoro@uao.edu.co", "calle 80 # 19100");
                LinkedList<tipo> listaT = new LinkedList();
                tipo t = new tipo("escuela",2200);
                listaT.add(t);
                donacion Dn = new donacion("11/08/2018", 30000, listaT);
                

                

                DBCollection collection = ob.getCollection(Dt.getClass().getSimpleName());
                try {
                    collection.insert(Dt);
                } catch (MongoException ex) {
                }
            } else {
                System.out.println("conexión no establecida!!!");
            }
            // System.out.println("CCC " + ob.getName());
        } catch (UnknownHostException ex) {
            Logger.getLogger(Taller_mongo.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        try {
            DB obj = createConnection();
            if (obj != null) {
                // BasicDBObject object = new BasicDBObject();
                //categorias c=new categorias("Asociado 1");
                
                LinkedList<tipo> listaT = new LinkedList();
                tipo t = new tipo("escuela",2200);
                listaT.add(t);
                donacion Dn = new donacion("11/08/2018", 30000, listaT);
                

                

                DBCollection collection = obj.getCollection(Dn.getClass().getSimpleName());
                try {
                    collection.insert(Dn);
                } catch (MongoException ex) {
                }
            } else {
                System.out.println("conexión no establecida!!!");
            }
            // System.out.println("CCC " + ob.getName());
        } catch (UnknownHostException ex) {
            Logger.getLogger(Taller_mongo.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static DB createConnection() throws UnknownHostException {
        MongoClient client = null;

        //String mongoCloudURI = data.getMongoURI();
        //   String mongoCloudURI = data.getMongoURILocal();
        MongoClientURI uri = new MongoClientURI("mongodb+srv://Cristian_ocoro96:Cami1019@cluster0-qjf34.mongodb.net/test?retryWrites=true&w=majority");
        //mongodb+srv://pruebaadmin:<password>@cluster0-tlwaa.mongodb.net/test?retryWrites=true&w=majority
        System.out.println("cadena " + uri.toString());
        client = new MongoClient(uri);

        return client.getDB("Donaciones");
    }
}
