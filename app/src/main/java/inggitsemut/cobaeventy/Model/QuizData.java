package inggitsemut.cobaeventy.Model;

import java.util.ArrayList;

public class QuizData {
    public static String[][] data = new String[][]{
            {"Mobile Programming"},
            {"PHP"},
            {"Algorithm"}
    };

    public static ArrayList<Quiz> getQuizListData(){
        ArrayList<Quiz> list = new ArrayList<>();
        for (String[] aData : data){
            Quiz quiz = new Quiz();
            quiz.setQuizName(aData[0]);

            list.add(quiz);
        }
        return list;
    }

}
