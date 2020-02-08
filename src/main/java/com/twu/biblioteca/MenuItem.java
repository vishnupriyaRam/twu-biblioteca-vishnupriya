package com.twu.biblioteca;

public enum MenuItem {
    LIST_BOOKS("1. List available Books"),
    CHECKOUT("2. Checkout a book"),
    RETURN("3. Return a book"),
    QUIT("4. Quit");

    private String menuItem;

    MenuItem(String menuItems) {
        this.menuItem = menuItems;
    }

    @Override
    public String toString() {
        return menuItem;
    }

    public void viewItem(){
        System.out.println(menuItem);
    }

}
