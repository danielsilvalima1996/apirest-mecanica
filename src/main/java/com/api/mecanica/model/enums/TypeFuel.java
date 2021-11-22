package com.api.mecanica.model.enums;

public enum TypeFuel {

    ETHANOL(0), GASOLINE(1), DIESEL(2), FLEX(3), LPG(4), HYBRID(5), ELETRIC(6);

    private int code;

    private TypeFuel(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TypeFuel valueOf(int code) {
        for (TypeFuel value : TypeFuel.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TypeFuel");
    }
}
