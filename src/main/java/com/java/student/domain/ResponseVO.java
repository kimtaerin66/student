package com.java.student.domain;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel
public class ResponseVO {


    @ApiModelProperty(value = "서버 에러코드", example = "XXXX" )
    private Integer     code;
    @ApiModelProperty(value = "서버 기본 에러메시지", example = "기본 에러 메시지")
    private String      message;
    @ApiModelProperty(value = "서버 상세 에러메시지", example = "예외처리 메시지")
    private String      exceptionMessage;
    @ApiModelProperty(value = "서버 리턴 시간", example = "yyyy-MM-ddThh:mm:ss" )
    private LocalDateTime serverTime;

    private Object      result;


    public ResponseVO(){
        this.code = 200;
        this.message = "";
        this.exceptionMessage = "";
        this.serverTime = LocalDateTime.now();
    }

    //ERROR
    public void setErrorCode(Integer code, String message){
        this.code= code;
        this.message = message;
    }

    public String _toJson() throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }
}
