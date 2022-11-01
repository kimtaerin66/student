package com.student.api.mappers;

import com.student.api.domain.StudentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface StudentMapper {

    //학생 정보 조회
    List<StudentDTO.Response>                      _getDBStudentList();

     StudentDTO.Response                           _getDBStudentDetail(int id);

    //학생 정보 변경
    void                                           _setDBStudentUpdate(StudentDTO.Update request);

}
