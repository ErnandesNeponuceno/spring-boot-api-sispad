package com.sistema.sispad.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {

    private Long codUsuario;

    @NotBlank
    private String txNome;

    @NotBlank
    private String stStatus;

}
