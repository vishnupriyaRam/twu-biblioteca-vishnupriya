package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    List<MenuItem> menuItems;

    public Menu() {
        menuItems = new ArrayList<>();
        createMenu();
    }

    private void createMenu(){
        menuItems.add(MenuItem.LIST_BOOKS);
    }

    void viewMenu(){
        menuItems.forEach(MenuItem::viewItem);
    }
}
