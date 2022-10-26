package com.java.student.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.validation.constraints.NotBlank;


public class StudentDTO {

    @Data
    @ApiModel(value = "Response", description = "학생 조회")
    public static class Response {
        @ApiModelProperty(value = "학생 id", required = false)
        private int id;
        @ApiModelProperty(value = "학생 이름", required = false)
        private String name;
        @ApiModelProperty(value = "수학점수", required = false)
        private int math;
        @ApiModelProperty(value = "국어점수", required = false)
        private int korean;
        @ApiModelProperty(value = "영어점수", required = false)
        private int english;
        @ApiModelProperty(value = "국사점수", required = false)
        private int history;
        @ApiModelProperty(value = "평균", required = false)
        private int avg;
        @ApiModelProperty(value = "총점", required = false)
        private int sum;

    }


    @Data
    @ApiModel(value = "Search", description = "검색")
    public static class Search {
        @ApiParam(value = "검색 구분( id,name,subject )", required = false)
        private String searchType;
        @ApiParam(value = "검색명", required = false)
        private String searchName;
    }

    @Data
    @ApiModel(value = "Update", description = "학생 정보 수정")
    public static class Update{
        @ApiModelProperty(notes = "아이디", required = true, example = "1")
        @NotBlank(message = "id 는 필수 입력 항목입니다.")
        private int id;

        @ApiModelProperty(notes = "이름", required = true, example = "김태린")
        private String name;

        @ApiModelProperty(notes = "수학점수", required = true, example = "90")
        private int math;
        @ApiModelProperty(notes = "국어점수", required = true, example = "85")
        private int korean;
        @ApiModelProperty(notes = "영어점수", required = true, example = "80")
        private int english;
        @ApiModelProperty(notes = "국사점수", required = true, example = "90")
        private int history;
        @ApiModelProperty(notes = "평균", required = true, example = "86.25")
        private int avg;
        @ApiModelProperty(notes = "총점", required = true, example = "345")
        private int sum;
    }

}
