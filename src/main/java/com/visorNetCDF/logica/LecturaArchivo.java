package com.visorNetCDF.logica;

import org.springframework.stereotype.Service;

import com.visorNetCDF.persistencia.VariableDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ucar.ma2.Array;
import ucar.nc2.Dimension;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;

/**
 * Clase lectura archivo netCDF mediante libreria externa
 */
@Service
public class LecturaArchivo {

    private List<VariableDTO> variables;
       
    /**
     * Metodo que lee el archivo mediante NetcdfFile.open
     * @param filename nombre del archivo a leer
     * @return Respuesta
     */
	public Respuesta<List<VariableDTO>> leerArchivo(String filename) {
        NetcdfFile ncfile;
        Respuesta<List<VariableDTO>> respuesta = new Respuesta<>();
        try {
            ncfile = NetcdfFile.open(filename);
            List<Variable> variables = ncfile.getVariables();
            respuesta.setDatos(variableToVariablesDTO(variables));
        } catch (IOException ex) {
            respuesta.setError(true);
            respuesta.setMensaje("error al leer el archivo");
        } 
        return respuesta;
    }
    
    /**
     * Metodo para convertir variables libreria a variableDTO
     * @param variables
     * @return Lista VariableDTO
     */
    public List<VariableDTO> variableToVariablesDTO(List<Variable> variables) throws IOException{
        List<VariableDTO> variablesDTO = new ArrayList<>();
        for (Variable var : variables) {
            VariableDTO varDTO = new VariableDTO(var.getFullName(), var.getDataType().toString(), var.getDescription(), 
                    obtenerDimensiones(var.getDimensions()), obtenerForma(var.getShape()), var.getUnitsString());
            Array data = var.read();
            varDTO.setValores(data.toString());
            varDTO.setAtributos(var.toString());
            varDTO.setGrupo(var.getGroup().getGroups().toString());
            variablesDTO.add(varDTO);
        }
        return variablesDTO;
    }
    
 /**
     * metodo para obtener dimensiones
     * @param d lista de dimensiones
     * @return String
     */
    public String obtenerDimensiones(List<Dimension> d) {
        String cadena = "";
        if (!d.isEmpty()) {
            for (Dimension dim : d) {
                if (cadena.isEmpty()) {
                    cadena += dim.getFullName();
                } else {
                    cadena += "," + dim.getFullName();
                }
            }
        }
        return cadena;
    }
    
    /**
     * Metodo para obtener formas
     * @param f formas
     * @return String
     */
    public String obtenerForma(int[] f) {
        String cadena = "";
        if (f.length > 0) {
            for (int i : f) {
                if (cadena.isEmpty()) {
                    cadena += i;
                } else {
                    cadena += "," + i;
                }
            }
        }
        return cadena;
    }

    /**
     * retorna lista de variables del archivo leido
     * @return lista Variables
     */
    public List<VariableDTO> getVariables() {
        return variables;
    }
}
