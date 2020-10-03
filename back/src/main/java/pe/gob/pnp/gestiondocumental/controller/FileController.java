package pe.gob.pnp.gestiondocumental.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.gob.pnp.gestiondocumental.dto.ResponseDTO;
import pe.gob.pnp.gestiondocumental.service.FileService;
import pe.gob.pnp.gestiondocumental.util.MensajeResponse;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("file")
@Api(value = "Administrar Archivos")
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping(value ="/{path}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseDTO<String> calcularSigla(@PathVariable("path") String path) throws IOException {
        ResponseDTO response = new ResponseDTO();
        response.setCodigo(MensajeResponse.MSG_200.getCodigo());
        response.setMensaje(MensajeResponse.MSG_200.getMensaje());
        response.setData(fileService.getFileBase64(path));
        return response;
    }
}
