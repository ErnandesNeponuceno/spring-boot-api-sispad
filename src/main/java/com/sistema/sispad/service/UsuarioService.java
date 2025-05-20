package com.sistema.sispad.service;

import com.sistema.sispad.dto.UsuarioDTO;
import com.sistema.sispad.exceptions.BusinessException;
import com.sistema.sispad.model.Usuario;
import com.sistema.sispad.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Builder
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioDTO> listarTodos() {
        List<Usuario> usuarios = repository.findAll();
        return usuarios.stream()
                .map(this::convertToDTO)
                .toList();
    }

    public UsuarioDTO listarPorId(Long id){
            Usuario usuario = repository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));
            return convertToDTO(usuario);
    }

    public UsuarioDTO incluir(UsuarioDTO dto) {
        if (repository.existsByTxNome(dto.getTxNome())) {
            throw new BusinessException("Existe outro usuário com o mesmo nome!");
        }
        validarDados(dto);
        Usuario usuario = convertToEntity(dto);
        Usuario usuarioSalvo = repository.save(usuario);
        return convertToDTO(usuarioSalvo);
    }

    public UsuarioDTO atualizar(Long id, UsuarioDTO dto) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));

        if (repository.existsByTxNome(dto.getTxNome()) && !usuario.getTxNome().equals(dto.getTxNome())) {
            throw new BusinessException("Existe outro usuário com o mesmo nome!");
        }

        validarDados(dto);

        usuario.setTxNome(dto.getTxNome());
        usuario.setStStatus(dto.getStStatus());
        Usuario usuarioAtualizado = repository.save(usuario);
        return convertToDTO(usuarioAtualizado);
    }

    public void deletar(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));
        try {
            repository.delete(usuario);
        } catch (DataIntegrityViolationException ex) {
            throw new BusinessException("Não foi possível excluir o usuário.");
        }
    }

    private void validarDados (UsuarioDTO dto){
        if (dto.getTxNome() == null || dto.getTxNome().isEmpty() ) {
            throw new BusinessException("Nome não pode ser nulo ou vazio!");
        }
    }

    private UsuarioDTO convertToDTO(Usuario usuario) {
        return UsuarioDTO.builder()
                .codUsuario(usuario.getCodUsuario())
                .txNome(usuario.getTxNome())
                .stStatus(usuario.getStStatus())
                .build();
    }

    private Usuario convertToEntity(UsuarioDTO dto) {
        return Usuario.builder()
                .codUsuario(dto.getCodUsuario())
                .txNome(dto.getTxNome())
                .stStatus(dto.getStStatus())
                .build();
    }
}
