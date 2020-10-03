package pe.gob.pnp.gestiondocumental.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.pnp.gestiondocumental.bean.DocumentoTiposBean;
import pe.gob.pnp.gestiondocumental.bean.UsuariosBean;
import pe.gob.pnp.gestiondocumental.dto.ResponseDTO;
import pe.gob.pnp.gestiondocumental.service.UsuariosService;
import pe.gob.pnp.gestiondocumental.util.MensajeResponse;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("usuarios")
@Api(value = "Administración de usuarios")
public class UsuariosController {

    @Autowired
    UsuariosService usuariosService;

    @GetMapping(value ="/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<List<UsuariosBean>> listar(){
        ResponseDTO response = new ResponseDTO();
        List<UsuariosBean> lista = usuariosService.listar();
        response.setCodigo(MensajeResponse.MSG_200.getCodigo());
        response.setMensaje(MensajeResponse.MSG_200.getMensaje());
        response.setData(lista);
        return response;
    }
}
