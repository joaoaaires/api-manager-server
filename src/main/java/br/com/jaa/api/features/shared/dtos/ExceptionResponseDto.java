package br.com.jaa.api.features.shared.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionResponseDto {
    private int status;
    private String message;
    private Object data;
    private String stackTrace;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp timestamp;
}
