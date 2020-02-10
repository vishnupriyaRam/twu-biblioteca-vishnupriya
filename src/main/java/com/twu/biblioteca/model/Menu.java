package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

//Todo Menu items not getting displayed in app

public class Menu {
    List<MenuItem> menuItems;

    public Menu() {
        menuItems = new ArrayList<>();
        createMenu();
    }

    public String viewMenu() {
        StringJoiner list = new StringJoiner("\n");
        for (int index = 0; index < menuItems.size(); index++)
            list.add(index + 1 + ". " + menuItems.get(index).viewItem());

        return list.toString();
    }

    private void createMenu() {
        menuItems.add(MenuItem.LIST_BOOKS);
        menuItems.add(MenuItem.CHECKOUT);
        menuItems.add(MenuItem.RETURN);
        menuItems.add(MenuItem.QUIT);
    }
}
