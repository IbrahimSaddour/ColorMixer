package tn.esprit.colormixer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tn.esprit.colormixer.databinding.ActivityAnswerBinding
import tn.esprit.colormixer.databinding.ActivityQuestionBinding

class AnswerActivity : AppCompatActivity() {

    //TODO 12 Add lateint var for binding
    lateinit var binding:ActivityAnswerBinding

    private var correctColor = "NONE"
    private var name = "NONE"
    private var color1 = "NONE"
    private var color2 = "NONE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO 13 Bind the view and implement setContentView()
        binding = ActivityAnswerBinding.inflate(layoutInflater, null, false)

        setContentView(binding.root)

        //TODO 14 Change the value of correctColor / name / color1 / color2 with the DATA from the INTENT
        val i = intent

        name = i.getStringExtra(NAME).toString()
        color1 = i.getStringExtra(COLOR1).toString()
        color2 = i.getStringExtra(COLOR2).toString()
        correctColor = i.getStringExtra(MIXED_COLOR).toString()

        //TODO 15 Change the txtChoosed with : "You chose $color1 and $color2"
        val string = "You chose $color1 and $color2 !"

        //TODO 16 Implement setOnClickListener on the btnSubmit and call checkAnswer()
        // You must check if only one radio button is selected the navigate to the ResultActivity with the data name and RESULT (FAILED/SUCCESS)

        binding.btnSubmit.setOnClickListener {
            if (binding.radioGroup.checkedRadioButtonId == binding.rbPurple.id)
                checkAnswer()
            if (binding.radioGroup.checkedRadioButtonId == binding.rbGreen.id)
                checkAnswer()
            if (binding.radioGroup.checkedRadioButtonId == binding.rbOrange.id)
                checkAnswer()
        }

    }

    private fun checkAnswer(): Boolean{

        //TODO 17 Check if the answer of the chosen color is correct

        return false
    }
}