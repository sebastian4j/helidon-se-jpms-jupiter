package com.sebastian.modulos.segundo;

/**
 *
 * @author Sebastian Avila A.
 */
public class Saludo {
  private String mensaje;

  public Saludo() {

  }

  public Saludo(final String txt) {
    mensaje = txt;
  }

  public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }

  @Override
  public String toString() {
    return "Saludo{" + "mensaje=" + mensaje + '}';
  }

  
}
