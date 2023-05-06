
package com.besysoft.ventas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.besysoft.ventas.TestData.TestData;
import com.besysoft.ventas.exceptions.AlreadyStoredObjectException;
import com.besysoft.ventas.exceptions.ProductNotFoundException;
import com.besysoft.ventas.modelos.*;
import com.besysoft.ventas.negocio.MenusLogicMethods;
import com.besysoft.ventas.utils.ProductFilters;


public class Ventas {
    



    public static void main(String[] args) {

        TestData.initData();
        int a=1;
        int b=3;
        int c=3;
        if(a==b && b==c){
            System.out.println("equilatero");
        }else if(a!=b && a!=c && b!=c){
            System.out.println("escaleno");
        }else{
            System.out.println("isosceles");
        }

            do{
                MenusLogicMethods.mainMenu();
            }while(MenusLogicMethods.salida!=0);
            MenusLogicMethods.sc.close();
          
    }
    
    
    

}
