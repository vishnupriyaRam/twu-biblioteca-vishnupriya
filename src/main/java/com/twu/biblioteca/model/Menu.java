package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Menu implements LoginListener{
    List<MenuItem> menuItems;
    Library library;

    public Menu(Library library) {
        this.library = library;
        menuItems = new ArrayList<>();
        createMenu();
        library.setLoginListener(this);
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
        menuItems.add(MenuItem.RETURN);
        menuItems.add(MenuItem.QUIT);
    }

    @Override
    public void loginEvent() {
        menuItems.add(3,MenuItem.VIEW_CHECKED_OUT);
        menuItems.add(6, MenuItem.VIEW_USER_DETAILS);
    }
}
