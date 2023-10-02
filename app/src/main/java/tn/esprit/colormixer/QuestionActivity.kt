package tn.esprit.colormixer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.google.android.material.snackbar.Snackbar
import tn.esprit.colormixer.databinding.ActivityQuestionBinding

//TODO 2 Add string constant val here for RED / BLUE / YELLOW / PURPLE / GREEN / ORANGE
    const val RED = "RED"
    const val BLUE = "BLUE"
    const val YELLOW = "YELLOW"
    const val PURPLE = "PURPLE"
    const val GREEN = "GREEN"
    const val ORANGE = "ORANGE"

//TODO 3 Add string constant val here for NAME / MIXED_COLOR / COLOR1 / COLOR2 / RESULT / SUCCESS / FAILED

    const val NAME = "NAME"
    const val MIXED_COLOR = "MIXED_COLOR"
    const val COLOR1 = "COLOR1"
    const val COLOR2 = "COLOR2"
    const val RESULT = "RESULT"
    const val SUCCESS = "SUCCESS"
    const val FAILED = "FAILED"


class QuestionActivity : AppCompatActivity() {

    //TODO 4 Add lateint var for binding

    lateinit var binding: ActivityQuestionBinding

    //TODO 5 Add var for colorMixed / color1 / color2 / name

    var colorMixed = "none"
    var color1 = "COLOR1"
    var color2 = "COLOR2"
    var name = "NAME"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO 6 Bind the view and implement setContentView()

        binding = ActivityQuestionBinding.inflate(layoutInflater, null, false)

        setContentView(binding.root)

        //TODO 7 Implement setOnClickListener on the button Mix and call mixColor()
        binding.btnMix.setOnClickListener {
            mixColor()
        }

    }

    private fun mixColor(){

        //TODO 8 Check if the input for FullName. IF it's empty show a snackbar with the message : You must enter your name !
        var userName = binding.tfFullName.text.toString()
        if (userName.isEmpty())
            Snackbar.make(binding.root, "You must enter your name !", Snackbar.LENGTH_LONG)

        //TODO 9 Check if Only 2 colors are selected then change the value of  colorMixed / color1 / color2
        if (binding.cbRed.isChecked && binding.cbBlue.isChecked){
            color1 = BLUE
            color2 = RED
            colorMixed = PURPLE
        }
        else if (binding.cbBlue.isChecked && binding.cbYellow.isChecked){
            color1 = BLUE
            color2 = YELLOW
            colorMixed = GREEN
        }
        else{
            color1 = YELLOW
            color2 = RED
            colorMixed = ORANGE
        }

        //TODO 10 Change the value of name with the input
        name = userName

        //TODO 11 Create an Intent to AnswerActivity and add all of the values name / colorMixed / color1 / color2 Then start the Activity
        val intent = Intent(this,AnswerActivity::class.java)

        intent.apply {
            putExtra(NAME,name)
            putExtra(COLOR1,color1)
            putExtra(COLOR2,color2)
            putExtra(MIXED_COLOR,colorMixed)
        }

        startActivity(intent)
    }
}