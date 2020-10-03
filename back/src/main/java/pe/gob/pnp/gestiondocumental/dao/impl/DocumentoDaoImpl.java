package pe.gob.pnp.gestiondocumental.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.gob.pnp.gestiondocumental.bean.DocumentoBean;
import pe.gob.pnp.gestiondocumental.dao.DocumentoDao;
import pe.gob.pnp.gestiondocumental.dto.DocumentoFilterRequestDto;
import pe.gob.pnp.gestiondocumental.dto.DocumentoFilterResponseDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DocumentoDaoImpl implements DocumentoDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int registrar(DocumentoBean bean) {
        int retorno = 0;
        StringBuilder sql = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        sql.append(" INSERT INTO `gesdoc`.`documentos`(id, numero_siglas, asunto, archivo,documentotipo_id) ");
        sql.append(" VALUES (:id, :numero_siglas, :asunto, :archivo,:documentotipo_id) ");
        params.put("id", bean.getId());
        params.put("numero_siglas", bean.getNumero_siglas());
        params.put("asunto", bean.getAsunto());
        params.put("archivo", bean.getArchivo());
        params.put("documentotipo_id", bean.getDocumentotipo_id());
        retorno = namedParameterJdbcTemplate.update(sql.toString(), params);
        return retorno;
    }

    @Override
    public List<DocumentoFilterResponseDto> buscar(DocumentoFilterRequestDto dto) {
        List<DocumentoFilterResponseDto> lista;
        StringBuilder sql = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        sql.append(" SELECT DISTINCT documentos.id idDocumento, ");
        sql.append("    (SELECT dt1.descripcion FROM gesdoc.documentotipos dt1 WHERE id= documentos.documentotipo_id) tipoDocumentoDesc, ");
        sql.append("    documentos.asunto, ");
        sql.append("    documentos.numero_siglas siglas, ");
        sql.append("    documentos.archivo ");
        sql.append(" FROM gesdoc.documentos documentos ");
        sql.append(" INNER JOIN gesdoc.documentos_usuarios docusu ON docusu.documento_id = documentos.id ");
        sql.append(" INNER JOIN gesdoc.usuarios usu ON usu.id = docusu.usuario_id ");
        sql.append(" WHERE 1=1 ");

        if(dto.getIdTipoDocumento()!=null){
            sql.append(" AND documentos.documentotipo_id = :documentotipo_id ");
            params.put("documentotipo_id", dto.getIdTipoDocumento());
        }
        if(dto.getDni()!=null) {
            sql.append(" AND usu.dni = :dni ");
            params.put("dni", dto.getDni());
        }
        if(dto.getSiglas()!=null) {
            sql.append(" AND documentos.numero_siglas like :numero_siglas ");
            params.put("numero_siglas", "%"+dto.getSiglas()+"%");
        }
        if(dto.getUsuario()!=null) {
            sql.append(" AND (usu.nombres like :usuario OR usu.apellidos like :usuario)");
            params.put("usuario", "%"+dto.getUsuario()+"%");
        }
        if(dto.getAsunto()!=null) {
            sql.append(" AND documentos.asunto like :asunto ");
            params.put("asunto", "%"+dto.getAsunto()+"%");
        }

        try {
            lista = namedParameterJdbcTemplate.query(sql.toString(), params, BeanPropertyRowMapper.newInstance(DocumentoFilterResponseDto.class));
        }catch(EmptyResultDataAccessException emp){
            lista = null;
        }
        return lista;
    }

    @Override
    public DocumentoBean detalleDocumento(Integer idDocumento) {
        DocumentoBean resultado;
        StringBuilder sql = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        sql.append(" SELECT id, ");
        sql.append("    numero_siglas, ");
        sql.append("    asunto, ");
        sql.append("    archivo, ");
        sql.append("    documentotipo_id ");
        sql.append(" FROM documentos ");
        sql.append(" WHERE id= :id ");
        params.put("id", idDocumento);
        try {
            resultado = namedParameterJdbcTemplate.queryForObject(sql.toString(), params, BeanPropertyRowMapper.newInstance(DocumentoBean.class));
        }catch(EmptyResultDataAccessException emp){
            resultado = null;
        }
        return resultado;
    }

    @Override
    public int deleteDocumento(Integer idDocumento) {
        StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM gesdoc.documentos where id=?; ");
        sql.append(" DELETE FROM gesdoc.documentos_usuarios where documento_id = ?; ");
        int rowsUpdate = jdbcTemplate.update(sql.toString(),idDocumento);
        return rowsUpdate;
    }

    @Override
    public int deleteDocumentoUsuario(Integer idDocumento) {
        StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM gesdoc.documentos_usuarios where documento_id = ?; ");
        int rowsUpdate = jdbcTemplate.update(sql.toString(),idDocumento);
        return rowsUpdate;
    }
}
