package com.student.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;


public class StudentDTO {

    @Data
    public static class CommonData {
        @ApiModelProperty(value = "학생 이름", required = false)
        private String name;
        @ApiModelProperty(value = "국어점수", required = false)
        private int korean;
        @ApiModelProperty(value = "수학점수", required = false)
        private int math;
        @ApiModelProperty(value = "영어점수", required = false)
        private int english;
        @ApiModelProperty(value = "국사점수", required = false)
        private int history;
        @ApiModelProperty(value = "평균", required = false)
        private double avg;
        @ApiModelProperty(value = "총점", required = false)
        private int sum;
    }
    @Data
    @ApiModel(value = "Response", description = "학생 조회")
    public static class Response extends CommonData{
        @ApiModelProperty(value = "학생 id", required = true)
        private int id;
    }

    @Data
    @ApiModel(value = "Request", description = "학생 추가")
    public static class Request extends CommonData{
        @ApiModelProperty(value = "학생 id", required = true, example = "1")
        private int id;
    }


    @Data
    @EqualsAndHashCode(callSuper=false)
    @ApiModel(value = "Update", description = "학생 정보 수정")
    public static class Update extends CommonData{

        @ApiModelProperty(value = "학생 id", required = true, example = "1")
        private int id;
    }


}