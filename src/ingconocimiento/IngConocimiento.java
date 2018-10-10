/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Materia:ingeniería del conocimiento

 */

package ingconocimiento;

import static com.sun.org.apache.xalan.internal.lib.ExsltMath.power;
import ingconocimiento.datos.Archivos;
import java.io.BufferedReader;
import java.io.FileReader;
import static java.lang.Math.sqrt;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static javafx.scene.input.KeyCode.T;
import static jdk.nashorn.internal.objects.NativeString.split;

/**
 *
 * @author fgb
 */
public class IngConocimiento {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s =new Scanner(System.in);
        //try{
            int parametro;
            String direccion;
            String[]cadena=null;            
            System.out.println("ingrese la direccion del archivo de datos:");
            direccion=s.nextLine();            
            String separador;
            //Lectura de datos
            Archivos d=new Archivos();
            int obj=d.datos(direccion);
            System.out.println("el numero de lineas en el archivo son:"+d.datos(direccion));
            System.out.println("ingrese el separador:");
            separador=s.nextLine();
            cadena=d.arreglo(separador, direccion);
            System.out.println("la longitud del arreglo cadena es:"+cadena.length);
            //conversion de cadena a entero            
            System.out.println("ingrese el numero de parametros:");
            parametro=s.nextInt();
            
            Double matriz [][]=new Double [obj][parametro];
            int contador=0;
            try{
                for (int i = 0; i < cadena.length; i++) {
                    for (int j = 0; j < parametro; j++) {
                        matriz[i][j]=Double.parseDouble(cadena[contador]);
                        contador=contador+1;
                    }                                
                }
            }catch(Exception e){
                System.out.println("");
            }            
            
            //impresion de la matriz
            try{
                for (Double[] matriz1 : matriz) {
                    for (Double matriz11 : matriz1) {
                        //System.out.println("valor "+i+" "+j+" = "+matriz[i][j]);
                        System.out.print(matriz11 + " ");
                    }
                    System.out.println("");
                }
            }catch(Exception y){
                System.out.println("error en la impresion de la matriz");
            }
            //calculo de la distancia
            System.out.println("ingresa un nuevo objecto");
            String no=s.next();            
            System.out.println("ingrese el separdor");
            String sepa=s.next();
            System.out.println("ingrese el numero de parametros:");
            int para=s.nextInt();
            String [] nuevo=no.split(sepa);
            Double objeton []=new Double [para];   
            //obtencio del nuevo objeto a clasificar
            for (int i=0;i<nuevo.length;i++) {                
                objeton[i]=Double.valueOf(nuevo[i]);
                    System.out.println("objeto["+i+"]:"+objeton[i]);                
            }
            //calculo de la distancia entre el nuevo objeto y los objetos en la base de datos
            Double distancia[][]=new Double[obj][parametro];
            System.out.println("la potencia de 3 al cuadrado es:"+power(3,2));
            for (int i = 0; i < distancia.length; i++) {
                for (int j = 0; j < 1; j++) {
                    System.out.println("valor de matriz["+i+"]["+j+"]:"+matriz[i][j]);
                    distancia[i][j]=sqrt(power((matriz[i][j]-objeton[0]),2)+power((matriz[i][j+1]-objeton[1]),2));
                    System.out.println("distancia["+i+"]["+j+"]:"+distancia[i][j]);
                }
        }
           // Burbuja
		int intercambios = 0, comparaciones = 0;
		
		Double aux;
		for(int i = 1; i<distancia.length; i++){
			for(int j= distancia.length-1; j>=i; j-- ){
				comparaciones++;
				if (distancia[i-1][j-1]>distancia[i][j]){
					intercambios++;
					aux = distancia[i-1][j-1];
					distancia[i-1][j-1] = distancia[i][j];
					distancia[i][j] = aux;			
				}
			}
		}	
		System.out.println("Numero de intercambios:"+intercambios);
		System.out.println("Numero de comparaciones:"+comparaciones);
		//return arreglo;
	//}
 
            
            
            
            /*
            
            DecimalFormat formato =  new DecimalFormat("#.00");
            Integer fila = d.datos(direccion);//Aqui usariamos el numero de entidades extraidas del documento
            Integer columna = parametro;//Aqui usariamos el numero maximo de caracteristicas de cada entidad
            Integer flag = 0;//Control para valores en la distancia
            Double tmp = Double.valueOf(0);//Almacenamiento temporal para la suma de caracteristicas
            //Double matriz [][] = new Double[fila][columna];
            Double distancia[][] = new Double[fila][fila];
            Double aux[] = new Double[columna];//Almacenamiento temporal de caracteristicas para la operacion de distancia
            for(int i = 0 ; i < fila ; i++){
               for(int j = 0 ; j < columna ; j++){
                    System.out.print(matriz[i][j] + "\t");
                }
                System.out.print("\n");
            }
        
            System.out.println("-----------------------DISTANCIAS------------------------------");
            System.out.println("\n");

            do{
                System.arraycopy(matriz[flag], 0, aux, 0, columna);

                for(int i = 0 ; i < fila ; i++){
                    for(int j = 0 ; j < columna ; j++){
                        tmp = tmp + Math.pow((aux[j] - matriz[i][j]),2);
                    }
                    distancia[flag][i] = Double.parseDouble(formato.format(Math.sqrt(tmp)));//Limitando a dos decimales y convirtiendo a Double
                    tmp = Double.valueOf(0);
                }

                flag++;
            }while(flag < fila);

            for(int i = 0 ; i < fila ; i++){
                for(int j = 0 ; j < fila ; j++){
                    System.out.print(distancia[i][j] + "\t\t");
                }
                System.out.print("\n");
            }           
            */
            
        /*}catch(Exception e){
            System.out.println("el error fue:"+e.getMessage());
        } */    
    }
    

}