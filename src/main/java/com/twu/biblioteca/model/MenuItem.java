package com.twu.biblioteca.model;

public enum MenuItem implements MenuController {
    LIST_BOOKS("List available Books"){
        @Override
        public void performOperation(Library library) {

        }
    },
    CHECKOUT("Checkout a book"){
        @Override
        public void performOperation(Library library) {

        }
    },
    RETURN("Return a book"){
        @Override
        public void performOperation(Library library) {

        }
    },
    QUIT("Quit"){
        @Override
        public void performOperation(Library library) {

        }
    },
    INVALID(""){
        @Override
        public void performOperation(Library library) {

        }
    };

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
