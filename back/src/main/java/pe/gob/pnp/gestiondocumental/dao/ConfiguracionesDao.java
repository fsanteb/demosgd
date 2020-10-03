package pe.gob.pnp.gestiondocumental.dao;

import pe.gob.pnp.gestiondocumental.bean.ConfiguracionesBean;

public interface ConfiguracionesDao {
    ConfiguracionesBean findByIdTipoDocumento(Integer documentotipo_id);
    int updateByIdTipoDocumento(int documentotipo_id);
}
