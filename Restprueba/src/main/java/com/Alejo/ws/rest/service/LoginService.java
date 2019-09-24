package com.Alejo.ws.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.Alejo.ws.rest.vo.UsuarioVo;

@Path("/PruebaAlejo")
public class LoginService {
	
	@POST
	@Path("/validarUsuario")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public UsuarioVo ValidarUsuario(UsuarioVo usuarioVo){
		if (usuarioVo.getUsuario().equals("admin") && usuarioVo.getPass().equals("1111")) {
			usuarioVo.setValidacion(true);
		}                                                                                                                                                                                                                                                                                                  
		return usuarioVo;
		
	}
	
	
	
}
