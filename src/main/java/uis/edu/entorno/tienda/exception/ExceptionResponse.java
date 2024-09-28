package uis.edu.entorno.tienda.exception;

import java.util.Date;

public class ExceptionResponse {
    private Date timetamp;
    private String mensaje;
    private String detalles;
    public ExceptionResponse() {
    }
    public ExceptionResponse(Date timetamp, String mensaje, String detalles) {
        this.timetamp = timetamp;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }
    public Date getTimetamp() {
        return timetamp;
    }
    public void setTimetamp(Date timetamp) {
        this.timetamp = timetamp;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public String getDetalles() {
        return detalles;
    }
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
}
