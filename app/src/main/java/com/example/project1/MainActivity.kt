package com.example.project1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var expression : String = "0"
    fun add0(view : View){
        if(expression.length == 1 && expression[0] == '0'){
            expression = "0"
        }
        else{
            expression += "0"
        }

        expression_out.text = expression
    }

    fun add1(view : View){
        if(expression.length == 1 && expression[0] == '0'){
            expression = "1"
        }
        else{
            expression += "1"
        }

        expression_out.text = expression
    }

    fun add2(view : View){
        if(expression.length == 1 && expression[0] == '0'){
            expression = "2"
        }
        else{
            expression += "2"
        }

        expression_out.text = expression
    }

    fun add3(view : View){
        if(expression.length == 1 && expression[0] == '0'){
            expression = "3"
        }
        else{
            expression += "3"
        }

        expression_out.text = expression
    }

    fun add4(view : View){
        if(expression.length == 1 && expression[0] == '0'){
            expression = "4"
        }
        else{
            expression += "4"
        }

        expression_out.text = expression
    }

    fun add5(view : View){
        if(expression.length == 1 && expression[0] == '0'){
            expression = "5"
        }
        else{
            expression += "5"
        }

        expression_out.text = expression
    }

    fun add6(view : View){
        if(expression.length == 1 && expression[0] == '0'){
            expression = "6"
        }
        else{
            expression += "6"
        }

        expression_out.text = expression
    }

    fun add7(view : View){
        if(expression.length == 1 && expression[0] == '0'){
            expression = "7"
        }
        else{
            expression += "7"
        }

        expression_out.text = expression
    }

    fun add8(view : View){
        if(expression.length == 1 && expression[0] == '0'){
            expression = "8"
        }
        else{
            expression += "8"
        }

        expression_out.text = expression
    }

    fun add9(view : View){
        if(expression.length == 1 && expression[0] == '0'){
            expression = "9"
        }
        else{
            expression += "9"
        }

        expression_out.text = expression
    }

    fun deleteExp(view : View){
        expression = "0"
        expression_out.text = expression
    }

    fun operSum(view : View){
        if(expression.last() != '+' &&
            expression.last() != '-' &&
            expression.last() != '*' &&
            expression.last() != '/')
            expression += "+"
        expression_out.text = expression
    }

    fun operDif(view : View){
        if(expression.last() != '+' &&
            expression.last() != '-' &&
            expression.last() != '*' &&
            expression.last() != '/')
            expression += "-"
        expression_out.text = expression
    }

    fun operMul(view : View){
        if(expression.last() != '+' &&
            expression.last() != '-' &&
            expression.last() != '*' &&
            expression.last() != '/')
            expression += "*"
        expression_out.text = expression
    }

    fun operDiv(view : View){
        if(expression.last() != '+' &&
            expression.last() != '-' &&
            expression.last() != '*' &&
            expression.last() != '/')
            expression += "/"
        expression_out.text = expression
    }

    private fun pickoutNumber(str : String) : Int{
        var ind : Int = 0

        while(ind < str.length && str[ind] in '0'..'9')
            ++ind

        return str.substring(0, ind).toInt()
    }

    fun countExpression(view: View){
        if(expression.last() == '+' ||
            expression.last() == '-' ||
            expression.last() == '*' ||
            expression.last() == '/')
            return

        val divivdingByZeroError = "Error: dividing by zero"
        val unexpectedBehaviorError = "Error: unexpected behavior"

        var errorCode : Int = 0
        var ind : Int = 0
        var result : Int = pickoutNumber(expression)
        while(ind < expression.length && expression[ind] in '0'..'9')
            ++ind

        while(ind < expression.length && errorCode == 0){
            var ch : Char = expression[ind++]
            var numb : Int = pickoutNumber(expression.substring(ind))

            ind += numb.toString().length + 1

            when(ch){
                '+' -> result += numb
                '-' -> result -= numb
                '*' -> result *= numb
                '/' -> if(numb != 0) result /= numb else errorCode = 1
                else -> errorCode = 2
            }
        }

        expression_out.text = when(errorCode){
            1 -> divivdingByZeroError
            2 -> unexpectedBehaviorError
            else -> result.toString()
        }
        expression = when(errorCode){
            1 -> "0"
            2 -> "0"
            else -> result.toString()
        }
    }
}
