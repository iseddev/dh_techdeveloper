package com.dh.banco.service;

// ===== MANEJADOR =====
public abstract class EmpleadoBanco {

    protected EmpleadoBanco sigEmpleadoBanco;

    public abstract void procesarSolicitud(Integer monto);

    public EmpleadoBanco setSigEmpleadoBanco(EmpleadoBanco sigEmpleadoBanco) {
        this.sigEmpleadoBanco = sigEmpleadoBanco;
        return this;
    }
}
