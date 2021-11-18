package com.api.mecanica.model.enums;

public enum TypePhone {

    RESIDENCIAL(0), COMERCIAL(1), CELULAR(2), RECADO(3);

    private int code;

    private TypePhone(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TypePhone valueOf(int code) {
        for (TypePhone value : TypePhone.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TypePhone");
    }
}
