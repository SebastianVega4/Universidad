package co.edu.uptc.proyectoweb;

import java.util.ArrayList;
import java.util.List;

    public class Afiliado {
        private String id;
        private String nombre;
        private String apellido;
        private List<Disciplina> disciplinas;
        private List<Evento> eventos;

        public Afiliado() {
            disciplinas = new ArrayList<>();
            eventos = new ArrayList<>();
        }

        public Afiliado(String id, String nombre, String apellido, List<Disciplina> disciplinas, List<Evento> eventos) {
            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
            this.disciplinas = disciplinas;
            this.eventos = eventos;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public List<Disciplina> getDisciplinas() {
            return disciplinas;
        }

        public void setDisciplinas(List<Disciplina> disciplinas) {
            this.disciplinas = disciplinas;
        }

        public List<Evento> getEventos() {
            return eventos;
        }

        public void setEventos(List<Evento> eventos) {
            this.eventos = eventos;
        }

        @Override
    public String toString() {
        return "Afiliado{" +
                "id='" + id + '\'' +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
