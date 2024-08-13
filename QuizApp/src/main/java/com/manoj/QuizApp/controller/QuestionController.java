package com.manoj.QuizApp.controller;

import com.manoj.QuizApp.model.Question;
import com.manoj.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

//@GetMapping("allQuestions")           //Gives all questions from the database
//    public List<Question> getAllQuestions(){
//
//    return questionService.getAllQuestions();
//    }

    @GetMapping("allQuestions")         //Gives status code
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

//    @GetMapping("category/{category}")   //Gives All Questions by category wise
//    public List<Question> getQuestionByCategory(@PathVariable String category){
//    return questionService.getAllQuestionsByCategory(category);
//
//    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){ //Gives Status code
        return questionService.getAllQuestionsByCategory(category);
    }

//    @PostMapping("add")
//    public String addQuestion(@RequestBody Question question){
//   return questionService.addQuestion(question);
//
//    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id){
        String result = questionService.deleteQuestion(id);
        if("success".equals(result)){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found");
        }
    }



}
