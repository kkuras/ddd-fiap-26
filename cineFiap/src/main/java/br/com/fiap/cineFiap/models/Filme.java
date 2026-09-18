package br.com.fiap.cineFiap.models;

import br.com.fiap.cineFiap.enums.CategoriaFilmeEnum;
import br.com.fiap.cineFiap.enums.ClassificacaoIndicativaEnum;
import br.com.fiap.cineFiap.enums.SimNaoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Filme {
    private Long id;1
    private String nome;2
    private Integer duracao;3
    private int ano;4
    private String cpaa;5
    private String diretor;6
    private String elenco;7
    private String descricao;8
    private double avaliacao;9
    private CategoriaFilmeEnum categoria;10
    private ClassificacaoIndicativaEnum classificacao;11
    private SimNaoEnum emCartaz;12

}
