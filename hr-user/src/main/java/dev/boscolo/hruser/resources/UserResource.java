package dev.boscolo.hruser.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dev.boscolo.hruser.dto.UserDTO;
import dev.boscolo.hruser.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping(value = "{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id){
		UserDTO userDTO = service.findById(id);
		return ResponseEntity.ok().body(userDTO);
	}
	
	@GetMapping(value = "/email")
	public ResponseEntity<UserDTO> findByEmail(@RequestParam String email){
		UserDTO userDTO = service.findByEmail(email);
		return ResponseEntity.ok().body(userDTO);
	}
}