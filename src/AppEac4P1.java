////////////////////////////////////////////
//   Autor: Pedro Antonio Ruiz Martínez   //
//   Periodo : 3                          //
//   APP: Verema                          //
////////////////////////////////////////////

public class AppEac4P1 {
        
    // CONSTANTES //
    public static final int MAX_ALMACENAJE = 25000;
    // FIN CONSTANTES //
    
    // CODIFICACIÓN VERIFICACIÓN FACILITADA POR EL INSTITUTO //
    String mVarietat[] = {"Ull de llebre","Garnatxa","Xarel·lo","Macabeu","Parellada"};
    int mQuantitat[]={0,0,0,0,0};
    int quantitatTotalRaim = 0;
    int[][] dadesVerificacio = {{2,250, 250},
                                {0,400, 400},
                                {2, 0, 250},
                                {1, 570, 570},
                                {3, 350, 350},
                                {1, 870, 1440},
                                {0, 685, 1085},
                                {2, 880, 1130},
                                {3, 836, 1186},
                                {4, 173, 173},
                                {3, 485, 1671},
                                {4, 648, 821},
                                {0,464, 1549},
                                {2, 583, 1713},
                                {4, 467, 1288},
                                {1, 513, 1953},
                                {2, 927, 2640},
                                {4, 219, 1507},
                                {2, 282, 2922},
                                {0, 953, 2502},
                                {3, 257, 1928},
                                {0, 377, 2879},
                                {4, 693, 2200},
                                {1, 277, 2230},
                                {0,135, 3014},
                                {3, 829, 2757},
                                {4, 920, 3120},
                                {2,481,3403},
                                {1,949,3179},
                                {4,970,4090},    
                                {3,998,3755},    
                                {1,981,4160}, 
                                {2,999,4402},    
                                {3,999,4754},    
                                {4,999,5089},    
                                {0,999,4013},    
                                {1,999,5159},    
                                {2,999,5401},    
                                {3,999,4754},    
                                {3,583,5337}};  
    
    //Método principal -> creamos objeto y apuntamos al método 'inici()'
    public static void main(String[] args) 
    {
        AppEac4P1 prg = new AppEac4P1();
        prg.inici();        
    }
    
    //Método ejecución programa
    private void inici(){
        
        boolean error=false;        
        
        entradaRaim("raïm negre",  100);
        for(int i=0; i<mQuantitat.length; i++){
           if(mQuantitat[i]>0){
                error = true;
                mQuantitat[0]=0;
           }
        }
        if(error){
            System.out.println("Error a l’entrada");
        }else{
            System.out.println("Entrada correcta");
        }

        for(int i=0; i<dadesVerificacio.length ; i++){
            String nomRaim =  mVarietat[dadesVerificacio[i][0]];
            entradaRaim(nomRaim,  dadesVerificacio[i][1]);
            
            if( mQuantitat[dadesVerificacio[i][0]]== dadesVerificacio[i][2]){
                    System.out.println("Entrada correcta");
            }else{
                   System.out.println("Error a l’entrada");
            }
        }       

    }    
    // FIN CODIFICACIÓN VERIFICACIÓN FACILITA POR INSTITUTO //
     
    //Método -> Verifica si hay sufiente espacio y existe variedad(posicioVarietat()) 
    private void entradaRaim(String varietat, int quantitat){
                
        // VERIFICAMOS SI HAY ESPACIO //        
        quantitatTotalRaim = quantitat; //Almacenamos en 'quantitatTotalRaim' cantidad seleccionada (quantitat)  
        
        //Sumamos a 'quantitatTotalRaim' la cantidad total de KG almacenada en 'mQuantitat[]'
        for(int i = 0; i < mQuantitat.length; i++)
        {
            quantitatTotalRaim += mQuantitat[i];
        }      
        // FIN VERIFICACIÓN //
                
        //Si cantidad total es <= 25000 verificaremos si existe varidad seleccionada        
        if((quantitatTotalRaim) <= MAX_ALMACENAJE)
        {
            int posicion = posicioVarietat(varietat); //almacena 'return posicioVarietat()'
            //Si exite varidad, aumentamos kg (quantitat) en la posición que devuelve 'posicion'
            if(posicion != -1)
            {
                mQuantitat[posicion] += quantitat;                
            }else //Si no se encuentra variedad mostramos mensaje de error.
            {
                System.out.println("No se encuentra la variedad. ");                
            }
        }else //Si se supera la cantidad máxima (25000) mostramos mensaje error.
        {  
            System.out.println("\nSuperada cantidad máxima (" + MAX_ALMACENAJE + "kg):");
            System.out.printf("%s\n%-20s%-20s%-20s\n%s\n%-20d%-20d%-20d\n\n",
                              "----------------------------------------------",                              
                              "Cant ALMA","Cant Entrada","SUMA",       
                              "----------------------------------------------",
                              (quantitatTotalRaim - quantitat),quantitat, quantitatTotalRaim);
        }  
        
    }
    
    //Método verificación varidad
    private int posicioVarietat(String varietat){      
                
        //Recorremos 'mVarietat' para ver si hay coincidencia
        for(int i = 0; i < mVarietat.length; i++)
        {
            //Si hay coincidencia, retornamos valor 'i' (posición)
            if(mVarietat[i].equals(varietat))
            {
               return i;
            }
        }
        return -1; //Si no hay coincidencia retornamos '-1'
        
    }           

    
}