package com.kotlin.practice.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kotlin.practice.R
import com.kotlin.practice.databinding.ActivityCoroutinePracticeBinding
import kotlinx.coroutines.*
import kotlin.coroutines.*

class CoroutinePracticeActivity : AppCompatActivity() , CoroutineScope by MainScope(){
    /*在 Kotlin 中有几种方法可以做到这一点您可以通过属性接收名称 - KClass.qualifiedName
    val name = AClass::class.qualifiedName;
    或通过Class.getName

    val name = AClass::class.java.getName();
    或者你可以试试Class.name

    val name = AClass::class.java.name;
    或 Class.canonicalName

    var name = AClass::class.java.canonicalName as String*/

    private lateinit var mBinding: ActivityCoroutinePracticeBinding

    val TAG_QUALIFIEDNAME: String? = CoroutinePracticeActivity::class.qualifiedName // com.kotlin.practice.coroutine.CoroutinePracticeActivity
    val TAG: String = CoroutinePracticeActivity::class.java.simpleName // CoroutinePracticeActivity
    val TAG_NAME: String = CoroutinePracticeActivity::class.java.name // com.kotlin.practice.coroutine.CoroutinePracticeActivity
    val TAG_TYPENAME = CoroutinePracticeActivity::class.java.typeName // com.kotlin.practice.coroutine.CoroutinePracticeActivity
    val TAG_CANONICALNAME = CoroutinePracticeActivity::class.java.canonicalName // com.kotlin.practice.coroutine.CoroutinePracticeActivity

    // MainScope() 源代码写法属于工厂模式
    private val mainscope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCoroutinePracticeBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_coroutine_practice)
        setContentView(mBinding.root)

        // 协程体 使用的是（import kotlin.coroutines.*）
        val continuation = suspend {
            5
        }.createCoroutine(object : Continuation<Int> {
            override val context: CoroutineContext = EmptyCoroutineContext

            override fun resumeWith(result: Result<Int>) {
                Log.d(TAG, "coroutine end $result")
            }

        })
        // 执行协程体
        continuation.resume(Unit)

        // 代码实例
        mBinding.btTest.also {
            it.setOnClickListener {
                GlobalScope.launch(Dispatchers.Main) {
                    val user = withContext(Dispatchers.IO){
                        // 请求网络数据
//                        retrofitServiceApi.getUserInfo("")
                    }
                    // 更新 view
//                    mBinding.tvTest.text = user.username
                }
            }
        }

//        使用 mainscope
        mainscope.launch {
            // 使用场景一：
            // val user =  retrofitServiceApi.getUserInfo("params")
            // 更新 view
            //mBinding.tvTest.text = user.username

            // 使用场景二：
            // withContext(Dispatchers.IO) 用来切换到 IO 调度器上，启动一个协程
            val user = withContext(Dispatchers.IO){
             /* 请求网络数据*/
            // (如果 retrofit 中封装的网络接口调用是 suspend 函数的话，就会自动创建一个 IO 调度器的协程)，
            // 如此处是挂起函数，则就可以不用再调用 withContext(Dispatchers.IO) 了

//                retrofitServiceApi.getUserInfo("params")
            }
            // 更新 view
            //mBinding.tvTest.text = user.username

            /*通过延迟执行一个 挂起函数  测试协程取消 抛出异常*/
            /*try {
                delay(10000)
            }catch (e:Exception){
                e.printStackTrace()
            }*/
        }


        launch {

        }





    }

    /**
     * mainscope 取消的话，他里面执行的协程就都会被取消掉,如果在任务还没有执行完毕时候执行取消操作，则会抛出类似异常：
        {kotlinx.coroutines.JobCancellctionException：Job was cancelled;job = SupervisorJobImpl{}cancelling}@45456}
     */
    override fun onDestroy() {
        super.onDestroy()

        mainscope.cancel()

    }

}