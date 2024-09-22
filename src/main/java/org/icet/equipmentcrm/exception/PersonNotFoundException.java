package org.icet.equipmentcrm.exception;

public class PersonNotFoundException extends RuntimeException{

    public PersonNotFoundException(String message){
        super(message);
    }
}
