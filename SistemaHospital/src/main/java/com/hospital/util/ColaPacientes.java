package com.hospital.util;

import com.hospital.model.Paciente;
import com.hospital.model.PacienteComparator;

import java.util.PriorityQueue;

public class ColaPacientes {

    private PriorityQueue<Paciente> cola;

    public ColaPacientes() {
        cola = new PriorityQueue<>(new PacienteComparator());
    }

    public void agregarPaciente(Paciente paciente) {
        cola.add(paciente);
    }

    public Paciente atenderPaciente() {
        return cola.poll();
    }

    public PriorityQueue<Paciente> getCola() {
        return cola;
    }
}