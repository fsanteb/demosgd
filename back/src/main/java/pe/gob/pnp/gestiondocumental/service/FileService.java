package pe.gob.pnp.gestiondocumental.service;

import java.io.File;
import java.io.IOException;

public interface FileService {
    String getFileBase64(String path) throws IOException;
}
