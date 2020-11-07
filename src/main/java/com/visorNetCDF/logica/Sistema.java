package com.visorNetCDF.logica;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.visorNetCDF.persistencia.VariableDTO;

/**
 * Clase principal logica, centraliza funciones para tratamiento de archivo
 */
@Service
public class Sistema {

	@Autowired
	private LecturaArchivo lecturaArchivo;

	public Respuesta<List<VariableDTO>> leerArchivo(MultipartFile file) {
		Respuesta<List<VariableDTO>> respuesta = new Respuesta<>();
		try {
			if (file.isEmpty()) {
				respuesta.setError(true);
				respuesta.setMensaje("error, archivo vacio");
				return respuesta;
			}
			byte[] bytes = file.getBytes();
			Path path = Paths.get(file.getOriginalFilename());
			Files.write(path, bytes);
			respuesta = lecturaArchivo.leerArchivo(file.getOriginalFilename());
		} catch (Exception e) {
			respuesta.setError(true);
			respuesta.setMensaje(e.getMessage());
		}
		return respuesta;
	}

}
