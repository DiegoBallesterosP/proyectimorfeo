package com.tobigym.proyectgym.dto;

public class InstructorDto {
    private Long id;
    private String nombres;
    private String apellidos;

    // ClienteDto clienteDto;

    public InstructorDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

}
