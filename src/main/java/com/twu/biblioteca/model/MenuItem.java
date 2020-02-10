package com.twu.biblioteca.model;

public enum MenuItem {
    LIST_BOOKS("List available Books"),
    CHECKOUT("Checkout a book"),
    RETURN("Return a book"),
    QUIT("Quit"),
    INVALID("");

    private String menuItem;

    MenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    @Override
    public String toString() {
        return menuItem;
    }

    public String viewItem() {
        return menuItem;
    }

}
