package com.example.mati.aplicacion17;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mati on 20/10/16.
 */

public class DatosTarea {

    static List TAREAS = new ArrayList<Tarea>();

    static{
        TAREAS.add(new Tarea("Burger","Long chiken",R.drawable.ic_long_chicken,"5€","http://www.burgerking.es/menu-item/long-chicken"));
        TAREAS.add(new Tarea("Burger","Crispy Chicken",R.drawable.ic_crispy_chicken,"3€","http://www.burgerking.es/menu-item/crispy-chicken%C2%AE"));
        TAREAS.add(new Tarea("Pizza","Steak House",R.drawable.ic_steak_house,"9€","http://www.telepizza.es/producto/pizzas/pizza-steak-house-999990005044316"));
    }
}
