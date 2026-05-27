package com.hospital.model;

import java.util.Comparator;

public class PacienteComparator implements Comparator<Paciente> {

    @Override
    public int compare(Paciente p1, Paciente p2) {

        int prioridadComparacion =
                p1.getPrioridad().compareTo(p2.getPrioridad());

        if (prioridadComparacion != 0) {
            return prioridadComparacion;
        }

        return p1.getHoraIngreso()
                .compareTo(p2.getHoraIngreso());
    }
}