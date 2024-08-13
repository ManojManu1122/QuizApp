package com.manoj.QuizApp.service;

import com.manoj.QuizApp.model.Question;
import com.manoj.QuizApp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

//    public List<Question> getAllQuestions(){
//
//        return questionDao.findAll();
//
//    }

    public ResponseEntity<List<Question>> getAllQuestions(){            //Gives the status code along with Questions

        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(questionDao.findAll(), HttpStatus.BAD_REQUEST);
    }


//    public List<Question> getAllQuestionsByCategory(String category) {
//        return questionDao.findByCategory(category);
//    }

    public ResponseEntity<List<Question>> getAllQuestionsByCategory(String category){
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.BAD_REQUEST);
    }

//    public String addQuestion(Question question) {
//        questionDao.save(question);
//        return "success";
//    }

    public ResponseEntity<String> addQuestion(Question question){
       try {
           questionDao.save(question);
           return new ResponseEntity<>("success", HttpStatus.CREATED);
       }
       catch (Exception e){
           e.printStackTrace();
       }
        return new ResponseEntity<>("Failed to add", HttpStatus.BAD_GATEWAY);
    }

    public String deleteQuestion(Integer id){
        if(questionDao.existsById(id)) {
            questionDao.deleteById(id);
            return "success";
        }
        else{
            return "failure";
        }
    }
}
