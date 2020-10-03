package pe.gob.pnp.gestiondocumental.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.pnp.gestiondocumental.bean.UsuariosBean;
import pe.gob.pnp.gestiondocumental.dao.UsuariosDao;
import pe.gob.pnp.gestiondocumental.service.UsuariosService;

import java.util.List;

@Service
@Transactional
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    UsuariosDao usuariosDao;

    @Override
    public List<UsuariosBean> listar() {
        return usuariosDao.listar();
    }
}
