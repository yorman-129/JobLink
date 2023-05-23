package com.example.backend.configuration;

import java.util.HashMap;

public class StatusMessages {
    private StatusMessages() {

    }

    public static final HashMap<String, String> EMAIL_NOT_REGISTERED = new HashMap<>() {{
        put("error", "El email no está registrado.");
    }};
    public static final HashMap<String, String> INVALID_STUDENT_BODY = new HashMap<>() {{
        put("error", "El cuerpo del usuario es inválido");
    }};

    public static final HashMap<String, String> LOGIN_SUCCESS = new HashMap<>() {{
        put("message", " Success");
    }};

    public static final HashMap<String, String> INVALID_EMAIL = new HashMap<>() {{
        put("message", " Email inválido");
    }};




}
