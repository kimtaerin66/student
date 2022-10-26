package com.java.student.controller;

import com.java.student.domain.ResponseVO;
import com.java.student.domain.StudentDTO;
import com.java.student.service.StudentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

// @API          - 클래스를 Swagger 리소스 대상으로 표시
// @ApiOperation - 요청 url에 매핑된 api에 대한 설명
// @ApiParam     - 요청 Parameter에 대한 설명 및 필수여부, 예제값 설정
// @ApiResponse  - 응답에 대한 설명
// MediaType     - request와 response에 MediaType을 지정해 원하는 타입만 거를수있다.


@Api(tags = {"[/student] 학생정보 API"})
@RestController
@RequestMapping("/api/student") //localhost:8080/api/student
public class StudentController {

    @Autowired
    private StudentService studentService;

//==========================================================================================================
//      학생 정보 조회
//==========================================================================================================
    @Transactional(timeout = 3)
    @ApiOperation(httpMethod = "GET", value = "학생 정보 조회", response = ResponseVO.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "result", response = ResponseVO.class)
    })
    @GetMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getStudent() {
        ResponseVO res = new ResponseVO();

        try {

            res = studentService._getStudentList();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
    }


//==========================================================================================================
//      학생 정보 수정
//==========================================================================================================
    @Transactional(timeout = 3)
    @ApiOperation(httpMethod = "PUT", value = "학생 정보 수정", response = ResponseVO.class)
    @GetMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateStudent(@ApiParam(value = "학생 DTO", required = true)
                                                @RequestBody StudentDTO.Update param) {
        ResponseVO res = new ResponseVO();

        try {
            res = studentService._updateStudent(param);
        } catch (Exception e) {
            res.setExceptionMessage("error");
        }
        return new ResponseEntity(res, HttpStatus.OK);
    }
}





