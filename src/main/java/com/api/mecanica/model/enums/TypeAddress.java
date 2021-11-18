package com.api.mecanica.model.enums;

public enum TypeAddress {

    RESIDENCIAL(1), COMERCIAL(2);

    private int code;

    private TypeAddress(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TypeAddress valueOf(int code) {
        for (TypeAddress value : TypeAddress.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TypeAddress");
    }
}
