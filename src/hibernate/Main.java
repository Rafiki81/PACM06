package hibernate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	fileOutputStream();
    }

    private static void fileOutputStream() {

        Modulo programacionA = new Modulo();
        programacionA.setCodigo("01");
        programacionA.setId(1);
        programacionA.setNombre("Programacion A");

        Modulo basesDatos = new Modulo();
        basesDatos.setNombre("Bases de Datos");
        basesDatos.setId(02);
        basesDatos.setCodigo("02");

        Profesor profesor1 = new Profesor();
        profesor1.setId(01);
        profesor1.setNombre("Juan");
        profesor1.setSexo("Masculino");

        Alumno alumno1 = new Alumno();
        alumno1.setEdad(23);
        alumno1.setNacionalidad("Española");
        alumno1.setNombre("Pedro");
        alumno1.setId(01);
        alumno1.setSexo("Masculino");
        List<Modulo> modulos = new ArrayList<>();
        modulos.add(programacionA);
        modulos.add(basesDatos);
        alumno1.setModulos(modulos);

        File ficheroAlumno = new File("FicherosSalida/alumno");
        try {
            FileOutputStream file = new FileOutputStream(ficheroAlumno, true);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(file);
            objectOutputStream.writeObject(alumno1);
        } catch (IOException ex) {
            System.out.println("No se ha podido escribir en el fichero");
        }

        File ficheroModulo = new File("FicherosSalida/modulo");
        try {
            FileOutputStream file = new FileOutputStream(ficheroModulo, true);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(file);
            objectOutputStream.writeObject(basesDatos);
        } catch (IOException ex) {
            System.out.println("No se ha podido escribir en el fichero");
        }

        File ficheroProfesor = new File("FicherosSalida/profesor");
        try {
            FileOutputStream file = new FileOutputStream(ficheroProfesor, true);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(file);
            objectOutputStream.writeObject(profesor1);
        } catch (IOException ex) {
            System.out.println("No se ha podido escribir en el fichero");
        }
    }

}
