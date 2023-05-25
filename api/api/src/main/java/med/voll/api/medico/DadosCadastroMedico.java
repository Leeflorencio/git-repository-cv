package med.voll.api.medico;

import med.voll.api.endereco.DadosEndereco;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record DadosCadastroMedico(

        @NotBlank  //verifica se não é nulo nem vazio
        String nome,
        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}") //expressão regular para verificar o padrao crm- \\d é digitos - de 4 a 6 digitos
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid //valida os objetos dentro do atributo
        DadosEndereco endereco) {
    //DTO
}
