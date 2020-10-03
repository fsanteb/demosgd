package pe.gob.pnp.gestiondocumental.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class ConfiguracionesBean implements Serializable {
    @JsonIgnore
    private int id;
    private Integer numero;
    private String siglas;
    private Integer numero_longitud;
    private Integer documentotipo_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public Integer getNumero_longitud() {
        return numero_longitud;
    }

    public void setNumero_longitud(Integer numero_longitud) {
        this.numero_longitud = numero_longitud;
    }

    public Integer getDocumentotipo_id() {
        return documentotipo_id;
    }

    public void setDocumentotipo_id(Integer documentotipo_id) {
        this.documentotipo_id = documentotipo_id;
    }
}
