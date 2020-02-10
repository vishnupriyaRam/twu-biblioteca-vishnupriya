package com.twu.biblioteca.model;

public enum MenuItem {
    LIST_BOOKS("1. List available Books"),
    CHECKOUT("2. Checkout a book"),
    RETURN("3. Return a book"),
    QUIT("4. Quit");

    private String menuItem;

    MenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    @Override
    public String toString() {
        return menuItem;
    }

    public void viewItem() {
        System.out.println(menuItem);
    }

}
