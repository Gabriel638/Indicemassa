package org.Gabriel638.Aula.control;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.Gabriel638.Aula.Form.AtualizaAulaForm;
import org.Gabriel638.Aula.Form.AulaForm;
import org.Gabriel638.Aula.dto.AulaDto;
import org.Gabriel638.Aula.entity.Aula;
import org.Gabriel638.Aula.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso")
public class AulaController {
	@Autowired
	private AulaRepository CursoRepository;
	// Read - Ler
	@GetMapping
	public List<AulaDto> listar(){
		List<Aula> Cursos = CursoRepository.findAll();
		return AulaDto.converter(Cursos);
				
	}
	// Create -- Cadastrar
	@PostMapping
	@Transactional
	public void salvar(@RequestBody AulaForm aulaForm) {
		Aula Curso = aulaForm.converter();
		CursoRepository.save(Curso);
		
		
	}
	// Delete -- Remover/apagar
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<AulaDto> apagar(@PathVariable int id){
		CursoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	//Update -- Atualizar
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AulaDto> atualizar(@PathVariable int id, @RequestBody AtualizaAulaForm aaf){
		Optional<Aula> optional = CursoRepository.findById(id);
		if(optional.isPresent()) {
			aaf.atualizar(id, CursoRepository);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
		
	}
	
}
