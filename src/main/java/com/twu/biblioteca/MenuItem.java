package com.twu.biblioteca;

public enum MenuItem {
    LIST_BOOKS("1. List available Books \n"), QUIT("2. Quit\n");

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
