package com.ryanandvinicius.bomsomapp.menulateral;



import com.ryanandvinicius.bomsomapp.R;

import java.util.ArrayList;
import java.util.List;

public class MenuNec {

    public static final int HOME = 0;
    public static final int LAPTOP = 1;
    public static final int CLIENT = 2;
    public static final int FUNCIO = 3;
    public static final int PROJECT = 4;
    public static final int LOC = 5;


    public static List<ItensDoMenu> getMenuList() {

        List<ItensDoMenu> list = new ArrayList<>();
        list.add(new ItensDoMenu(R.drawable.ic_baseline_home_24, HOME, true));
        list.add(new ItensDoMenu(R.drawable.ic_baseline_laptop_24, LAPTOP, false));
        list.add(new ItensDoMenu(R.drawable.ic_baseline_assignment_ind_24, CLIENT, false));
        list.add(new ItensDoMenu(R.drawable.ic_baseline_business_center_24, FUNCIO, false));
        list.add(new ItensDoMenu(R.drawable.ic_baseline_build_24, PROJECT, false));
        list.add(new ItensDoMenu(R.drawable.ic_baseline_location_on_24, LOC, false));



        return list;
    }
}

