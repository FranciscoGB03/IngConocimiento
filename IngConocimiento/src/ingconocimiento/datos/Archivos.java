/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingconocimiento.datos;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author fgb
 */
public class Archivos {
    
    public int datos(String direccion ){
        int numlineas=0;
        try{
            FileReader fr= new FileReader(direccion);
            BufferedReader br=new BufferedReader(fr);                       
            String lectura;
            while((lectura=br.readLine())!=null){                
                System.out.println(lectura);
                numlineas=numlineas+1;
            }                        
        }catch(Exception m){
            System.out.println("el error fue:"+m.getMessage());
        }
        return numlineas;
    }
    /**
     * 
     * @param s separador de la cadena
     * @param direccion direccion del archivo
     * @return 
     */
    public String[] arreglo(String s,String direccion){       
        String[] partes=null;
        try{
            FileReader fr= new FileReader(direccion);
                BufferedReader br=new BufferedReader(fr);                       

                String text;
                String text2="";
                while((text=br.readLine())!=null){
                    text2=text2.concat(text);
                    text2=text2.concat(s);                   
                }
                partes=text2.split(s);                
        }catch(Exception e){
            System.out.println("error:"+e.getMessage());
        }
        return partes;
    }
}
