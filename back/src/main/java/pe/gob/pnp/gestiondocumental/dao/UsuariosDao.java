package pe.gob.pnp.gestiondocumental.dao;

import pe.gob.pnp.gestiondocumental.bean.UsuariosBean;

import java.util.List;

public interface UsuariosDao {
    List<UsuariosBean> listar();
    List<UsuariosBean> usuariosXDocumento(Integer id);
}
