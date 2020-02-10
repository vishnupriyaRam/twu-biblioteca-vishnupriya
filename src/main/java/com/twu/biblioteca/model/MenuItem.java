package com.twu.biblioteca.model;

public enum MenuItem implements MenuController {
    LIST_BOOKS("List available Books") {
        @Override
        public void performOperation(Library library) {
            library.view();
        }
    },
    CHECKOUT("Checkout a book") {
        @Override
        public void performOperation(Library library) {
//            String bookToBeCheckedOut = getBook(in, "Enter book to checkout: ");
//        System.out.println(library.checkout(bookToBeCheckedOut).getMessage());
//            System.out.println(library.checkout(bookToBeCheckedOut));
        }
    },
    RETURN("Return a book") {
        @Override
        public void performOperation(Library library) {
//            String bookToBeReturned = getBook(in, "Enter book to be returned: ");
//        System.out.println(library.returnBook(bookToBeReturned).getMessage());
//            System.out.println(library.returnBook(bookToBeReturned));
        }
    },
    QUIT("Quit") {
        @Override
        public void performOperation(Library library) {
            System.out.println("Thanks for using the application");
            System.exit(0);
        }
    },
    INVALID("\n") {
        @Override
        public void performOperation(Library library) {
            System.out.println("Please select a valid option!");
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
