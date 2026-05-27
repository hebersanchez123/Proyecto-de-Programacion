package com.hospital.controller;

import com.hospital.dao.PacienteDAO;
import com.hospital.model.Paciente;
import com.hospital.model.Prioridad;
import com.hospital.util.ColaPacientes;

public class PacienteController {

    private ColaPacientes cola;
    private PacienteDAO dao;

    public PacienteController() {
        cola = new ColaPacientes();
        dao = new PacienteDAO();
    }

    public void registrarPaciente(String nombre,
                                  int edad,
                                  String dpi,
                                  String sintomas,
                                  Prioridad prioridad) {

        Paciente paciente = new Paciente(
                nombre,
                edad,
                dpi,
                sintomas,
                prioridad
        );

        cola.agregarPaciente(paciente);

        dao.guardarPaciente(paciente);
    }

    public Paciente atenderPaciente() {
        return cola.atenderPaciente();
    }

    public ColaPacientes getCola() {
        return cola;
    }
}