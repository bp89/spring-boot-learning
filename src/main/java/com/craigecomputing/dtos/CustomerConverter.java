package com.craigecomputing.dtos;

import java.beans.PropertyEditorSupport;

public class CustomerConverter extends PropertyEditorSupport {

    public void setAsText(final String text) throws IllegalArgumentException {
        setValue(Customer.getContentType(text));
    }
}