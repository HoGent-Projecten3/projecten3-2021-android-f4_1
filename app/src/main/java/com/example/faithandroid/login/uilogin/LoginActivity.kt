package com.example.faithandroid.login.uilogin

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.faithandroid.HomeFragment
import com.example.faithandroid.MainActivity
import com.example.faithandroid.R
import com.example.faithandroid.login.LoginFragment
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.login.view.*
import org.koin.android.ext.android.inject
import javax.xml.parsers.DocumentBuilderFactory.newInstance
import javax.xml.transform.TransformerFactory.newInstance


class LoginActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginViewModel : LoginViewModel by inject()
        setContentView(R.layout.login)

        val username = findViewById<EditText>(R.id.txtemail)
        val password = findViewById<EditText>(R.id.txtwachtwoord)
        val login = findViewById<Button>(R.id.login_button)
        val loading = findViewById<ProgressBar>(R.id.loading)




        loginViewModel.loginFormState.observe(this@LoginActivity, Observer {
            val loginState = it ?: return@Observer

            // disable login button unless both username / password is valid
            login.isEnabled = loginState.isDataValid

            if (loginState.usernameError != null) {
                username.error = getString(loginState.usernameError)
            }
            if (loginState.passwordError != null) {
                password.error = getString(loginState.passwordError)
            }
        })

        loginViewModel.loginResult.observe(this@LoginActivity, Observer {
            val loginResult = it ?: return@Observer

            loading.visibility = View.GONE
            if (loginResult.error != null) {
                showLoginFailed(loginResult.error)
            }
            if (loginResult.success != null) {
                updateUiWithUser(loginResult.success)
            }

            var intent: Intent = Intent()
            intent.putExtra("loggedInUser", loginResult.success?.displayName)
            intent.putExtra("token", loginResult.success?.token)


            setResult(Activity.RESULT_OK, intent)

            //Complete and destroy login activity once successful
            finish()
        })



        username.afterTextChanged {
            loginViewModel.loginDataChanged(
                    username.text.toString(),
                    password.text.toString()
            )
        }

        password.apply {
            afterTextChanged {
                loginViewModel.loginDataChanged(
                        username.text.toString(),
                        password.text.toString()
                )
            }

            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        loginViewModel.login(
                                username.text.toString(),
                                password.text.toString()
                        )
                }
                false
            }


          login.setOnClickListener {
            try{
                loading.visibility = View.VISIBLE
                Log.i("aaaaaa",username.text.toString() + " "  + password.text.toString())
                loginViewModel.login(username.text.toString(), password.text.toString())
                AppPreferences.username = username.text.toString()
               //  supportFragmentManager.findFragmentById(R.id.action_loginFragment_to_homeFragment) as LoginFragment
             //  this.findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }
            catch (e: Exception ){

            }
          }


        }

      /*  val taskIntent =  Intent(this, HomeFragment::class.java)
        startActivity(taskIntent)*/
    }


   override fun onBackPressed() {
        finishAffinity()
    }


    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome)
        val displayName = model.displayName
        // TODO : initiate successful logged in experience
        Toast.makeText(
                applicationContext,
                "$welcome $displayName",
                Toast.LENGTH_LONG
        ).show()
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }

}



/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}