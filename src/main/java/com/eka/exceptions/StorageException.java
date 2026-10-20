package com.eka.exceptions;

import java.io.IOException;

public class StorageException extends Exception {

    public StorageException() {
        super();
    }

    public StorageException(String s, IOException e) {
        super(s, e);
    }

    public StorageException(String s) {
        super(s);
    }
}
