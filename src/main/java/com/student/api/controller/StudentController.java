package com.student.api.controller;

import com.student.api.domain.ResponseVO;
import com.student.api.domain.StudentDTO;
import com.student.api.service.StudentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;

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
    private StudentService _studentService;

    //==========================================================================================================
//      학생 정보 조회 (csv파일)
//==========================================================================================================
    @ApiOperation(httpMethod = "GET", value = "학생 정보 조회", response = ResponseVO.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "result", response = ResponseVO.class)
    })
    @GetMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> _getStudentList() throws IOException {
        ResponseVO res = null;

        res = _studentService._getStudentList();

        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    //==========================================================================================================
//      학생 정보 조회 (DB)
//==========================================================================================================
    @ApiOperation(httpMethod = "GET", value = "학생 정보 조회", response = ResponseVO.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "result", response = ResponseVO.class)
    })
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> _getStudent() {
        ResponseVO res = null;

        res = _studentService._getStudent();

        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    //==========================================================================================================
//      학생 정보 수정
//==========================================================================================================
    @ApiOperation(httpMethod = "PUT", value = "학생 정보 수정", response = ResponseVO.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "success", response = ResponseVO.class)
    })
    @PutMapping(value = "/update",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> _updateStudent(@ApiParam(value = "학생 DTO", required = true)
                                                     @Valid @RequestBody StudentDTO.Update params) {
        ResponseVO res = new ResponseVO();

        try{
            res = _studentService._updateStudent(params);
        } catch (Exception e) {
            res.setMessage("정보 수정 실패");
            //throw new RuntimeException(e);
        }


        return new ResponseEntity(res, HttpStatus.OK);
    }


    //==========================================================================================================
//      학생 정보 상세 조회
//==========================================================================================================
    @ApiOperation(httpMethod = "GET", value = "학생 정보 상세 조회", response = ResponseVO.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "result", response = ResponseVO.class)
    })
    @GetMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> _getStudent(@ApiParam(value = "id", required = true)
                                              @RequestParam int id) {
        ResponseVO res =  new ResponseVO();
        try {
            res = _studentService._getStudentDetail(id);
            res.setCode(200);
        } catch (Exception e) {
            res = new ResponseVO();
            res.setErrorCode(400);
        }


        return new ResponseEntity<>(res, HttpStatus.OK);
    }


}


