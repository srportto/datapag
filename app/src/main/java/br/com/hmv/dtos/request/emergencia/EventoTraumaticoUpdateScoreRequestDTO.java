package br.com.hmv.dtos.request.emergencia;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoTraumaticoUpdateScoreRequestDTO {
    private static final long serialVersionUID = 1L;

    @JsonProperty("score")
    private Integer score;

}
