package com.java.student.mappers;

import com.java.student.domain.StudentDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {

    StudentDTO.Response                            _getStudentList();
    void                                           _updateStudent(StudentDTO.Update request);

}
