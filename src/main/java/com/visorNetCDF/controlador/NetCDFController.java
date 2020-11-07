package com.visorNetCDF.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.visorNetCDF.logica.Respuesta;
import com.visorNetCDF.logica.Sistema;
import com.visorNetCDF.persistencia.VariableDTO;

@RestController
@RequestMapping("/netCDF")
public class NetCDFController {

	@Autowired
	private Sistema sistema;

	@PostMapping("/leerArchivo")
	public ResponseEntity<Respuesta<List<VariableDTO>>> leerArchivo(@RequestParam("file") MultipartFile file) {
		Respuesta<List<VariableDTO>> respuesta = new Respuesta<>();
		respuesta = sistema.leerArchivo(file);
		if (respuesta.isError()) {
			return new ResponseEntity<Respuesta<List<VariableDTO>>>(respuesta, HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<Respuesta<List<VariableDTO>>>(respuesta, HttpStatus.OK);
	}
}
