package com.java.student.service;

import com.java.student.domain.ResponseVO;
import com.java.student.domain.Student;
import com.java.student.domain.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    public ResponseVO _getStudentList() throws IOException {
        ResponseVO responseVO = new ResponseVO();

        //csv 파일 읽기
        List stuList = StudentService.readCSV("D:/study/Java/studentScore.csv");

        if (stuList == null || stuList.size() == 0) {
            responseVO.setCode(8000);
            responseVO.setMessage("No Data");
        }
        responseVO.setCode(200);
        responseVO.setResult(stuList);
        responseVO.setMessage("Success");

        return responseVO;
    }

    public ResponseVO _updateStudent(StudentDTO.Update request) {
        ResponseVO responseVO = new ResponseVO();

        //id, 과목별 성적 확인
        if(request.getId() < 1 || request.getId() > 30){
            responseVO.setCode(8001);
            responseVO.setMessage("id 값을 확인해주세요.");
        }else if(request.getEnglish() > 100 || request.getHistory() > 100 ||
        request.getAvg()>100 || request.getKorean()>100 || request.getMath() > 100){
            responseVO.setCode(8002);
            responseVO.setMessage("과목별 최대 점수는 100점입니다.");
        }



        return responseVO;
    }


    //CSV 파일 읽기
    public static List<Student> readCSV(String fileName) throws IOException {
        List<Student> csvList = new ArrayList<Student>(); //Student가 list로 있는 상태.
        File fileCsv = new File(fileName);
        BufferedReader br = null;

        String line = "";

        try {
            br = new BufferedReader(new FileReader(fileCsv));
            br.readLine();
            while ((line = br.readLine()) != null) { // 데이터가 없을때까지 한줄씩 읽어오기.
                String[] lineArr = line.split(","); // 한줄씩 읽어온것은 콤마로 나눔.
                Student item = new Student(Integer.parseInt(lineArr[0]), lineArr[1], Integer.parseInt(lineArr[2]), Integer.parseInt(lineArr[3]), Integer.parseInt(lineArr[4]), Integer.parseInt(lineArr[5]), Integer.parseInt(lineArr[6]));
                if (lineArr != null) {
                    csvList.add(item);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
        return csvList;
    }

}
