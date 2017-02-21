package com.ken.quizapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ken.quizapp.fragments.AnswerFragment;
import com.ken.quizapp.fragments.QuestionFragment;
import com.ken.quizapp.models.Question;

import java.util.ArrayList;
import java.util.List;

public class PlayActivity extends FragmentActivity //implements View.OnClickListener
{

    /**
     * Lista que contendra las preguntas del quiz
     */
    private List<Question> questions = new ArrayList<>();
    private QuestionFragment questionFragment;

    /**
     * el page widget
     *
     */
    ViewPager pager = null;

    /**
     * el adaptador que provee al view pager de las vistas.
     */
    MyFragmentPagerAdapter pagerAdapter;

    private int questionPosition;

    //la variable que llevara los resultados de las preguntas contestadas
    private int[] correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_play);

        Bundle extras = getIntent().getExtras();
        /**
         * Inicializa las vistas
         */
        initViews();


        String texto = extras.getString("nombre");
        TextView nombre = (TextView) findViewById(R.id.nombre);
        nombre.setText(texto);

        // Instanseamos el ViewPager
        this.pager = (ViewPager) this.findViewById(R.id.pager);

        // creamos un adaptador con el fragmento que mostramos
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(
                getSupportFragmentManager());


        /**
         * Incializamos las preguntas
         */
        initQuestions();

        //agregamos las preguntas al fragmento
        for(Question question: questions)
        {
            adapter.addFragment(new QuestionFragment(question.getTitle()));
        }

        this.pager.setAdapter(adapter);


/*
        //Creamos el fragment con el que iniciará mi Activity y le asignamos la pregunta inicial.
        questionFragment = new QuestionFragment(questions.get(questionPosition).getTitle());
        correctAnswer = new int[questions.size()];
        //Ponemos nuestro fragmento en el FrameLayout
        changeFragment(questionFragment);
*/
    }

    /**
     * Inicializamos la lista de preguntas con sus respuestas correctas
     */
    private void initQuestions() {

        questions.add(new Question("¿En Java un arreglo tiene un tamaño definido?", 1));
        questions.add(new Question("¿Un árbol binario puede tener mas de dos hijos?", 0));
        questions.add(new Question("¿Git es un sistema de control de versiones?", 1));
        questions.add(new Question("¿Java no es un lenguaje tipado?", 0));
        questions.add(new Question("¿RelativeLayout organiza sus elementos uno después de otro?", 0));

    }

    /**
     * Metodo útilizado para configurar todas  las vistas de mi layout
     */
    private void initViews() {
        View view = findViewById(R.id.quiz_img_arrow_right);
        //view.setOnClickListener(this);

        View view2 = findViewById(R.id.quiz_img_arrow_left);
        //view2.setOnClickListener(this);

    }

    private int score ()
    {
        int score=0;
        for(int answer : correctAnswer)
        {
            score+=answer;
        }

        return score;
    }
/*
    @Override
    public void onClick(View view) {

        int respuesta = questionFragment.respuesta;
        switch (view.getId())
        {
            case R.id.quiz_img_arrow_right:
                //Obtenemos la respuesta del puntaje

                //Válidamos que halla escogido alguna respuesta

                if (respuesta != -1) {

                    //Verificamos que la posición
                    if (respuesta == questions.get(questionPosition).getAnswer()) {
                        correctAnswer[questionPosition]=1;
                    }else{
                        correctAnswer[questionPosition]=0;
                    }


                    questionPosition++;

                   // questionFragment = new QuestionFragment(questions.get(questionPosition).getTitle());
                    //changeFragment(questionFragment);
                    this.pager.setCurrentItem(this.pager.getCurrentItem() + 1);
                }


                /**
                 * Verificamos si vamos en la última posición de nuestra
                 * lista de preguntas , si es el caso mostramos el puntaje
                 * de otro modo avanzamos a la siguiente pregunta
                 */
    /*
                if (questionPosition == questions.size() - 1) {


                    //Mostramos el puntaje
                    AnswerFragment answerFragment = new AnswerFragment("Tu puntaje es : " + score() + " de " + questions.size());
                    changeFragment(answerFragment);

                }
                break;

            case R.id.quiz_img_arrow_left:
                if(questionPosition > 0)
                {

                    questionPosition--;
                    //questionFragment = new QuestionFragment(questions.get(questionPosition).getTitle());
                    //changeFragment(questionFragment);
                    this.pager.setCurrentItem(this.pager.getCurrentItem() - 1);

                }
                break;
        }





    }
*/
/*
    public void changeFragment(Fragment fragment) {
        /**
         *Obtengo el FragmentManaget que me ayuda con las transacciones
         *que necesite hacer con mis fragmentos
         */
      /*  FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
          .replace(R.id.pager, fragment)
            .commit();
    }
*/
    @Override
    public void onBackPressed() {

        // Return to previous page when we press back button
        if (this.pager.getCurrentItem() == 0)
            super.onBackPressed();
        else
            this.pager.setCurrentItem(this.pager.getCurrentItem() - 1);

    }

}
