package com.sistema.sispad.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "TBL_USUARIOS")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_USUARIO")
    private Long codUsuario;

    @Column(name = "TX_NOME")
    private String txNome;

    @Column(name = "ST_STATUS")
    private String stStatus;

}
