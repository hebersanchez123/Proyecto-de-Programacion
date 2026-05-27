package com.hospital.dao;

import com.hospital.database.ConexionDB;
import com.hospital.model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PacienteDAO {

    public void guardarPaciente(Paciente paciente) {

        String sql = """
                INSERT INTO pacientes
                (nombre, edad, dpi, sintomas, prioridad)
                VALUES (?, ?, ?, ?, ?)
                               """;
//la tabla//
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, paciente.getNombre());
            stmt.setInt(2, paciente.getEdad());
            stmt.setString(3, paciente.getDpi());
            stmt.setString(4, paciente.getSintomas());
            stmt.setString(5, paciente.getPrioridad().name());

            stmt.executeUpdate();

            System.out.println("Paciente guardado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}