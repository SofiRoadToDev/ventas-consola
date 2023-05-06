
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

            do{
                MenusLogicMethods.mainMenu();
            }while(MenusLogicMethods.salida!=0);
            MenusLogicMethods.sc.close();
          
    }
    
    
    

}
