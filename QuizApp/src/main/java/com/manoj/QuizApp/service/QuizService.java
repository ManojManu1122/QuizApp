package com.manoj.QuizApp.service;

import com.manoj.QuizApp.dao.QuestionDao;
import com.manoj.QuizApp.model.Question;
import com.manoj.QuizApp.dao.QuizDao;
import com.manoj.QuizApp.model.QuestionWrapper;
import com.manoj.QuizApp.model.Quiz;
import com.manoj.QuizApp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;




    public ResponseEntity<String> createQuiz(String category, int numQ , String title){

        Quiz quiz = new Quiz();
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ);
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for(Question q:questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestion_title(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUser.add(qw);
        }
         return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromTable = quiz.get().getQuestions();
        int right = 0;
        int i = 0;


        for(Response response: responses){
            if(response.getResponse().equals(questionsFromTable.get(i).getRight_answer())){
                right++;
            }
            i++;


        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
