package br.org.serratec.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.serratec.backend.exception.EmailException;
import br.org.serratec.backend.model.Usuario;
import br.org.serratec.backend.repository.UsuarioRepository;
import br.org.serratec.dto.UsuarioDTO;
import br.org.serratec.dto.UsuarioInserirDTO;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public List<UsuarioDTO> listar(){
		List<UsuarioDTO> usuariosDTOs = new ArrayList<UsuarioDTO>();
		List<Usuario> usuarios = usuarioRepository.findAll();
		for (Usuario usuario : usuarios) {
			UsuarioDTO dto = new UsuarioDTO(usuario);
			usuariosDTOs.add(dto);
		}
		return usuariosDTOs;
	}
	

	public UsuarioDTO inserir (UsuarioInserirDTO usuarioInserirDTO) throws EmailException {
		Usuario u = usuarioRepository.findByEmail(usuarioInserirDTO.getEmail());
		if(u != null) {
			throw new EmailException("Email existente ! Insira outro");
		}
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioInserirDTO.getNome());
		usuario.setEmail(usuarioInserirDTO.getEmail());
		usuario.setPerfil("Usuário Padrão");
		usuario.setSenha(bCryptPasswordEncoder.encode(usuarioInserirDTO.getSenha()));
		usuario =  usuarioRepository.save(usuario);
		return new UsuarioDTO(usuario);
		
		
	}
	
}
