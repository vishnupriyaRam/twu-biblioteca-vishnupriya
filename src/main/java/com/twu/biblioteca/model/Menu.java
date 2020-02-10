package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Menu {
    List<MenuItem> menuItems;

    public Menu() {
        menuItems = new ArrayList<>();
        createMenu();
    }

    public String viewMenu() {
        StringJoiner list = new StringJoiner("\n");
        menuItems.forEach(menuItem -> {
                    int index = menuItems.indexOf(menuItem) + 1;
                    list.add(index + ". " + menuItem.viewItem());
                }
        );
        return list.toString();
    }

    private void createMenu() {
        menuItems.add(MenuItem.LIST_BOOKS);
        menuItems.add(MenuItem.CHECKOUT);
        menuItems.add(MenuItem.RETURN);
        menuItems.add(MenuItem.QUIT);
    }
}
