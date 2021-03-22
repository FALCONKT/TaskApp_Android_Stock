package jp.techacademy.kenji.takada.taskapp

import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.appcompat.widget.Toolbar
import android.view.View

import io.realm.Realm
import kotlinx.android.synthetic.main.content_input.*
import java.util.*


class InputActivity : AppCompatActivity() {


    //Propertyの定義
    //Taskの日時を保持するmYear、mMonth、mDay、mHour、mMinute
    //TaskClassのObject

    private var mYear = 0
    private var mMonth = 0
    private var mDay = 0
    private var mHour = 0
    private var mMinute = 0
    private var mTask: Task? = null


    //日付を設定するButtonのListener
    //    View   DatePickerDialog　　date_button　import
    //    日付をユーザに入力させる
    //    DatePickerDialog を使用
    //    mYear、mMonth、mDayを引数に与えて生成
    //    onDateSeod　Methods　それらの値を入力された日付で更新
    //    その際にmDateButtonのTextも新しい日付で更新　　おそらく見た目のxml
    private val mOnDateClickListener = View.OnClickListener {
        val datePickerDialog = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                mYear = year
                mMonth = month
                mDay = dayOfMonth
                val dateString = mYear.toString() + "/" + String.format("%02d", mMonth + 1) + "/" + String.format("%02d", mDay)
                date_button.text = dateString
            }, mYear, mMonth, mDay)
        datePickerDialog.show()
    }


    //時間を設定するButtonのListener
    //TimePickerDialog　　import要
    //時間をUserに入力させる
    //TimePickerDialog を使用する
    //その際にmTimeButtonのTextも新しい日付で更新
    //mHour、mMinuteを引数に与えて生成
    private val mOnTimeClickListener = View.OnClickListener {
        val timePickerDialog = TimePickerDialog(this,
            TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                mHour = hour
                mMinute = minute
                val timeString = String.format("%02d", mHour) + ":" + String.format("%02d", mMinute)
                times_button.text = timeString
            }, mHour, mMinute, false)
        timePickerDialog.show()
    }


    //決定ButtonのListener
    //決定ButtonをCliskしたとき
    //addTask MethodでRealmに保存/更新したあと、
    //finish Methodを呼び出すことでInputActivityを閉じて前の画面
    private val mOnDoneClickListener = View.OnClickListener {
        addTask()
        finish()
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        // ActionBarを設定する
        // Toolbar import要
        // 先ずActionBarの設定
        // setSupportActionBarMethodにより、toolBarをActionBarとして使えるように設定
        //setDisplayHomeAsUpEnabledMethodで、ActionBarに戻るButtonを表示
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }


        // UI部品の設定
        date_button.setOnClickListener(mOnDateClickListener)
        times_button.setOnClickListener(mOnTimeClickListener)
        done_button.setOnClickListener(mOnDoneClickListener)


        // realm import要
        // Class（各ktFile）の垣根を超えて、Taskを渡す　
        // Intentによって Taskのidを渡す（putExtra()）、
        // あるいは受け取る（getIntExtra()）

        // 受け取る方から実装
        // val taskId = intent.getIntExtra(EXTRA_TASK, -1) によって
        // EXTRA_TASK からTaskのidを取り出す EXTRA_TASK が無いと　第二引数が行く

        // EXTRA_TASKからTaskのidを取得して、 idからTaskのインスタンスを取得する
        val intent = intent
        val taskId = intent.getIntExtra(EXTRA_TASK, -1)
        val realm = Realm.getDefaultInstance()

        //Taskのidが taskId のものが検索され、findFirst() によって最初に見つかったインスタンスが返され、
        //mTask へ代入される
        //taskId に -1 が入っていると、検索に引っかからず、 mTask には null が代入される
        //addTaskで指定している、idが必ず0以上というApllyの仕様を利用している
        mTask = realm.where(Task::class.java).equalTo("id", taskId).findFirst()
        realm.close()


        //EXTRA_TASK が設定されていない、すなわち taskId が -1 になる場合とは
        //Taskを新規作成する場合のこと　！！！！
        //mTask == nullの場合　
        // EXTRA_TASK は渡されないので taskId に -1 が代入され、 mTask には null が代入される
        // また mTask がnullであれば、暦から、現在時刻をmYear、mMonth、mDay、mHour、mMinutに設定
        //elseの場合
        //MainActivityから EXTRA_TASK が渡ってきた場合は更新のため、渡ってきたタスクの時間を設定します。
        //合わせて、mTitleEditにタイトル、mContentEditに内容を設定し、
        //mDateButtonに日付、mTimeButtonに時間をそれぞれ文字列に変換して設定
        if (mTask == null) {
            // 新規作成の場合
            val calendar = Calendar.getInstance()
            mYear = calendar.get(Calendar.YEAR)
            mMonth = calendar.get(Calendar.MONTH)
            mDay = calendar.get(Calendar.DAY_OF_MONTH)
            mHour = calendar.get(Calendar.HOUR_OF_DAY)
            mMinute = calendar.get(Calendar.MINUTE)
        } else {
            // 更新の場合
            title_edit_text.setText(mTask!!.title)
            content_edit_text.setText(mTask!!.contents)

            // ■Category関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
            // 更新も出来るように設定
//            category_edit_text.setText(mTask!!.category)

            val calendar = Calendar.getInstance()
            calendar.time = mTask!!.date
            mYear = calendar.get(Calendar.YEAR)
            mMonth = calendar.get(Calendar.MONTH)
            mDay = calendar.get(Calendar.DAY_OF_MONTH)
            mHour = calendar.get(Calendar.HOUR_OF_DAY)
            mMinute = calendar.get(Calendar.MINUTE)

            val dateString = mYear.toString() + "/" + String.format("%02d", mMonth + 1) + "/" + String.format("%02d", mDay)
            val timeString = String.format("%02d", mHour) + ":" + String.format("%02d", mMinute)

            date_button.text = dateString
            times_button.text = timeString
        }
    }
    //    onCreate() END



    // GregorianCalendar　　import要
    // 先ずRealmObjectを取得

    // RealmでDataを追加、削除など変更を行う場合はbeginTransactionMethodを使用し、
    // 削除等の処理、そして最後にcommitTransactionMethodを使用する

    // データの保存・更新はcopyToRealmOrUpdateMethodを使用する。
    // 引数で与えたObjectが存在していれば更新、なければ追加を行うMethodです。
    // 最後にcloseMethodを使用する
    private fun addTask() {
        val realm = Realm.getDefaultInstance()

        //RealmでDataを追加、削除など変更を行う場合 必須
        realm.beginTransaction()

        if (mTask == null) {
            // 新規作成の場合
            mTask = Task()

            val taskRealmResults = realm.where(Task::class.java).findAll()

            val identifier: Int =
                if (taskRealmResults.max("id") != null) {
                    taskRealmResults.max("id")!!.toInt() + 1
                } else {
                    0
                }
            mTask!!.id = identifier
        }

        val title = title_edit_text.text.toString()
        val content = content_edit_text.text.toString()

        // ■　Category関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
        // ■　Categoryの入力値を追加
//        val category = category_edit_text.text.toString()

        mTask!!.title = title
        mTask!!.contents = content

        // ■　Category関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
        // ■　Categoryの入力値を追加
//        mTask!!.category = category

        val calendar = GregorianCalendar(mYear, mMonth, mDay, mHour, mMinute)
        val date = calendar.time
        mTask!!.date = date

        realm.copyToRealmOrUpdate(mTask!!)

        //RealmでDataを追加、削除など変更を行う場合 必須
        realm.commitTransaction()

        realm.close()

        // PendingIntent　関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
        //  Intent　PendingIntent　import要
        //　askAlarmReceiverを起動するIntentを作成　そのExtraにTaskを設定
        // TaskAlarmReceiverがBroadCastを受け取った後、
        // TaskのTitle等を表示する通知を発行するためにTaskの情報が必要になるため
        val resultIntent = Intent(applicationContext, TaskAlarmReceiver::class.java)

        resultIntent.putExtra(EXTRA_TASK, mTask!!.id)

        // PendingIntent　関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
        // PendingIntentを作成。第2引数にTaskのIDを指定。
        // Taskを削除する際に指定したAlermも合わせて削除する必要があるため
        // Alermを削除しないと、Taskを削除したにもかかわらず通知を表示してしまうことになるため

        // PendingIntent.FLAG_UPDATE_CURRENTは既存のPendingIntentがあれば、
        // それはそのままでextraのDatだけ置き換えるDataだけ置き換える
        val resultPendingIntent = PendingIntent.getBroadcast(
            this,
            mTask!!.id,
            resultIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        // PendingIntent　関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
        // AlarmManagerに時間などの引数を与えている　
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, resultPendingIntent)

    }
    //addTask　END


}
//Class END