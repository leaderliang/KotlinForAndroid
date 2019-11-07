package com.android.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import com.android.kotlin.entity.User
import com.android.kotlin.view.CodeView
import com.android.kotlinbase.utils.CacheUtils
import com.android.kotlinbase.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val usernameKey = "username"
    private val passwordKey = "password"

    // lateinit 晚些初始化的对象
    private lateinit var mEtUsername: EditText
    private lateinit var mEtPassword: EditText
    private lateinit var mEtCode: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var user = User()
//        user.userName = "dev.liang"
//        user.passWord = "123456"
//        user.code = "1207"


        setContentView(R.layout.activity_main)
        mEtUsername = findViewById(R.id.et_username)
        mEtPassword = findViewById(R.id.et_password)
        mEtCode = findViewById(R.id.et_code)

        et_username.setText(CacheUtils.get(usernameKey))
        et_password.setText(CacheUtils.get(passwordKey))

        val btnLogin: Button = findViewById(R.id.btn_login)
        val imgCode: CodeView = findViewById(R.id.code_view)
        btnLogin.setOnClickListener(this)
        imgCode.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        //To change body of created functions use File | Settings | File Templates.
//        TODO("not implemented")

        /*when (v?.id) {
            R.id.btn_login -> {

            }
            R.id.code_view -> {

            }
            else -> {
                Toast.makeText(this, "啦啦啦", Toast.LENGTH_LONG).show()
            }
        }*/

        if (v is CodeView) {
            v.updateCode()
        } else if (v is Button) {
            login()
        }

    }


    private fun login() {
        val username = mEtUsername.text.toString()
        val password = mEtPassword.text.toString()
        val code = mEtCode.text.toString()

        val user = User(username, password, code)
        if (verify(user)) {
            CacheUtils.save(usernameKey, username)
            CacheUtils.save(passwordKey, password)
            // 两种方式跳转
//            startActivity(Intent(this@MainActivity, LessonActivity::class.java))
            startActivity(Intent(this, LessonActivity::class.java))
        }
    }

    private fun verify(user: User): Boolean {
        if (user.userName != null && user.userName!!.length < 4) {
            Utils.toast("用户名不合法")
            return false
        }
        if (user.passWord != null && user.passWord!!.length < 4) {
            Utils.toast("密码不合法")
            return false
        }
        return true
    }


}
