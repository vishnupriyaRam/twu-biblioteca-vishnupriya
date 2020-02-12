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

    public String getMenu() {
        StringJoiner list = new StringJoiner("\n");
        for (int index = 0; index < menuItems.size(); index++)
            list.add(index + 1 + ". " + menuItems.get(index).viewItem());

        return list.toString();
    }

    private void createMenu() {
        menuItems.add(MenuItem.LIST_BOOKS);
        menuItems.add(MenuItem.LIST_MOVIES);
        menuItems.add(MenuItem.CHECKOUT_BOOK);
        menuItems.add(MenuItem.CHECKOUT_MOVIE);
        menuItems.add(MenuItem.VIEW_CHECKED_OUT);
        menuItems.add(MenuItem.RETURN);
        menuItems.add(MenuItem.QUIT);
    }
}
