package br.com.hmv.services.validation.paciente.criacao;

import br.com.hmv.dtos.request.paciente.PacienteInsertRequestDTO;
import br.com.hmv.exceptions.FieldMessage;
import br.com.hmv.repositories.PacienteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Log4j2
public class PacienteInsertValidator implements ConstraintValidator<PacienteInsertValid, PacienteInsertRequestDTO> {

    private PacienteRepository repository;

    @Override
    public void initialize(PacienteInsertValid ann) {
    }

    @Override
    public boolean isValid(PacienteInsertRequestDTO dto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();
        var pacienteValidaEmail = repository.findPacienteByEmail(dto.getEmail());

        if (pacienteValidaEmail != null) {
            list.add(new FieldMessage("email", "Não é possível cadastrar este email, está em uso por outro usuário"));
        }

        var pacienteValidaCpf = repository.findPacienteByCpf(dto.getCpf());
        if (pacienteValidaCpf != null) {
            list.add(new FieldMessage("cpf", "Não é possível cadastrar este cpf, está em uso por outro usuário"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }

        //Retorno booleano (true/false) de acordo com a resposta da pergunta se a lista esta preenchida ou nao
        return list.isEmpty();
    }
}
