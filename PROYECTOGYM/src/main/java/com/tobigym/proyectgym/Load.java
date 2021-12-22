package com.tobigym.proyectgym;

import com.tobigym.proyectgym.models.Cliente;
import com.tobigym.proyectgym.models.Instructor;
import com.tobigym.proyectgym.models.Role;
import com.tobigym.proyectgym.models.Servicio;
import com.tobigym.proyectgym.models.Usuariojwt;
import com.tobigym.proyectgym.repository.RoleRepository;
import com.tobigym.proyectgym.repository.UsuarioRepository;
import com.tobigym.proyectgym.service.ClienteService;
import com.tobigym.proyectgym.service.InstructorService;
import com.tobigym.proyectgym.service.ServicioService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
class Load {

    @Bean
    CommandLineRunner client(ClienteService clienteService, InstructorService instructorService,
            ServicioService servicioService) {
        return arg -> {
            System.out.println("Probando la capa de servicios primera vez");

            // instructores //
            Instructor instructor1 = new Instructor();
            instructor1.setNombres("Alvaro");
            instructor1.setApellidos("Monsalve");
            instructor1.getClientes();
            instructorService.save(instructor1);

            Instructor instructor2 = new Instructor();
            instructor2.setNombres("Diego");
            instructor2.setApellidos("Pulido");
            instructorService.save(instructor2);

            // servicios //

            Servicio a = new Servicio();
            a.setPrecio((double) 750000);
            a.setPeriodo("Anual");
            servicioService.save(a);

            Servicio s = new Servicio();
            s.setPrecio((double) 500000);
            s.setPeriodo("Semestre");
            servicioService.save(s);

            Servicio t = new Servicio();
            t.setPrecio((double) 250000);
            t.setPeriodo("Trimestre");
            servicioService.save(t);

            Servicio m = new Servicio();
            m.setPrecio((double) 70000);
            m.setPeriodo("Mensual");
            servicioService.save(m);

            // clientes //

            Cliente c1 = new Cliente();
            c1.setNombres("pepe");
            c1.setApellidos("Rodriguez");
            c1.setCedula((long) 1027456878);
            c1.setEdad("21 años");
            c1.setGenero("Hombre");
            c1.setInstructor(instructor1);
            c1.setServicio(a);
            clienteService.save(c1);

            // cliente
            Cliente c2 = new Cliente();
            c2.setNombres("Sara");
            c2.setApellidos("Montaña");
            c2.setCedula((long) 1032547896);
            c2.setEdad("25 años");
            c2.setGenero("Mujer");
            c2.setInstructor(instructor2);
            c2.setServicio(s);
            clienteService.save(c2);

            Cliente c3 = new Cliente();
            c3.setNombres("Stefany");
            c3.setApellidos("Casas");
            c3.setCedula((long) 9954789);
            c3.setEdad("47 años");
            c3.setGenero("Mujer");
            c3.setInstructor(instructor2);
            c3.setServicio(t);
            clienteService.save(c3);
        };

    }

    //////////////////////////////////////////// ----------------------------------------------------------------/////////////////////////////

    @Bean
    CommandLineRunner initDatabase(UsuarioRepository userRepository, RoleRepository roleRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        return args -> {

            Role adminRole = new Role();
            adminRole.setName("ADMIN");
            roleRepository.save(adminRole);

            Role secunRole = new Role();
            secunRole.setName("SECUN");
            roleRepository.save(secunRole);

            Usuariojwt admin = new Usuariojwt();
            admin.setUsuario("admin");
            admin.setPassword(bCryptPasswordEncoder.encode("12345"));
            admin.setRol(adminRole);
            userRepository.save(admin);

            Usuariojwt secun = new Usuariojwt();
            secun.setUsuario("secun");
            secun.setPassword(bCryptPasswordEncoder.encode("12345"));
            secun.setRol(secunRole);
            userRepository.save(secun);

        };
    }
}
