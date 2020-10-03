package pe.gob.pnp.gestiondocumental.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.gob.pnp.gestiondocumental.bean.UsuariosBean;
import pe.gob.pnp.gestiondocumental.dao.UsuariosDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UsuariosDaoImpl implements UsuariosDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<UsuariosBean> listar() {
        List<UsuariosBean> lista;
        StringBuilder sql = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        sql.append(" SELECT `usuarios`.`id`, ");
        sql.append(" `usuarios`.`dni`, ");
        sql.append(" `usuarios`.`nombres`, ");
        sql.append(" `usuarios`.`apellidos`, ");
        sql.append(" `usuarios`.`email` ");
        sql.append(" FROM `gesdoc`.`usuarios`; ");
        try {
            lista = namedParameterJdbcTemplate.query(sql.toString(), params, BeanPropertyRowMapper.newInstance(UsuariosBean.class));
        }catch(EmptyResultDataAccessException emp){
            lista = null;
        }
        return lista;
    }

    @Override
    public List<UsuariosBean> usuariosXDocumento(Integer id) {
        List<UsuariosBean> lista;
        StringBuilder sql = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        sql.append(" SELECT ");
        sql.append("    usu.id, ");
        sql.append("    usu.dni, ");
        sql.append("    usu.nombres, ");
        sql.append("    usu.apellidos, ");
        sql.append("    usu.email ");
        sql.append(" FROM gesdoc.usuarios usu ");
        sql.append(" INNER JOIN gesdoc.documentos_usuarios docusu ON docusu.usuario_id = usu.id   ");
        sql.append(" WHERE docusu.documento_id = :documento_id ");
        params.put("documento_id", id);
        try {
            lista = namedParameterJdbcTemplate.query(sql.toString(), params, BeanPropertyRowMapper.newInstance(UsuariosBean.class));
        }catch(EmptyResultDataAccessException emp){
            lista = null;
        }
        return lista;
    }
}
