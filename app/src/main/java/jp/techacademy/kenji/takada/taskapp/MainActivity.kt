package jp.techacademy.kenji.takada.taskapp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*
import io.realm.RealmChangeListener
import io.realm.Sort

import android.content.Intent
import androidx.appcompat.app.AlertDialog
import android.app.AlarmManager
import android.app.PendingIntent

import com.google.android.material.snackbar.Snackbar

import android.sax.StartElementListener
import java.lang.reflect.Method
import java.util.*

//IntentのExtraのKeyWordに使う文字列EXTRA_TASKを定義　名前は自己のもの
//Package名を含めた文字列をIntentのExtraのKeyとして利用するのは、
//他のApplyのExtraと間違えないようにするため
const val EXTRA_TASK = "jp.techacademy.kenji.takada.taskapp.TASK"



//最初　既存Viewを削除
class MainActivity : AppCompatActivity() {

    // Realm関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
    //import要　Realm
    //RealmClassを保持するmRealmを定義
    private lateinit var mRealm: Realm

    //RealmChangeListener<> は import要
    //mRealmListenerはRealmのDBに追加や削除など変化があった場合に呼ばれるListener
    private val mRealmListener = object : RealmChangeListener<Realm> {
        override fun onChange(element: Realm) {
            reloadListView()
        }
    }


    //ListVie関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
    //TaskAdapter を保持する Property を定義する
    private lateinit var mTaskAdapter: TaskAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener { view ->

        // AlarmManager　関連　＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
        // ListViewで出すときの設定　AlertManager 実装のため非表示
        // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        // .setAction("Action", null).show()

            val intent = Intent(this, InputActivity::class.java)
            startActivity(intent)
        }

        // Realm関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
        // Realmの設定
        // RealmClassのgetDefaultInstanceMethodでObjectを取得
        // mRealmListenerをaddChangeListenerMethodで設定 引数に入れる
        mRealm = Realm.getDefaultInstance()
        mRealm.addChangeListener(mRealmListener)


        //ListVie関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
        //TaskAdapter を生成する
        mTaskAdapter = TaskAdapter(this@MainActivity)


        //ListVie関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
        // ListViewをToupしたときの処理
        listView1.setOnItemClickListener { parent, view, position, id ->

            //入力・編集 関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
            //Intent　inport要
            //入力・編集する画面に遷移させる
            val task = parent.adapter.getItem(position) as Task
            val intent = Intent(this, InputActivity::class.java)
            intent.putExtra(EXTRA_TASK, task.id)
            startActivity(intent)


        }

        //ListVie関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
        // ListViewを長押ししたときの処理
//        入力・編集  受付により大幅改変

        //入力・編集 関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
//        StartElementListenerを長押しした時にTaskを削除する処理も合わせて実装
//        長押しするとAlertDialogを表示し、OKを押したら削除、CANCELを押したら何もしない
        listView1.setOnItemLongClickListener {parent,_,position,_ ->
            //入力・編集 関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
            // Taskを削除する
            val task = parent.adapter.getItem(position) as Task

            //入力・編集 関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
            // DiaLogを表示する
            // AlertDialog　import要
            val builder = AlertDialog.Builder(this)

            builder.setTitle("削除")
            builder.setMessage(task.title + "を削除しますか")

            //入力・編集 関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
            // 選択したセルに該当するタスクと同じIDのものを検索し
            // その結果（RealmResults(型名)）に対して deleteAllFromRealm Methodを使用することで削除
            // 削除する際も追加するときと同様に
            // beginTransaction Method と commitTransaction Metho　で囲む必要がある
            builder.setPositiveButton("OK"){_, _ ->
                val results =
                mRealm.where(Task::class.java).equalTo("id", task.id).findAll()

                mRealm.beginTransaction()
                results.deleteAllFromRealm()
                mRealm.commitTransaction()


                // AlarmManager関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
                // PendingIntent　AlarmManager　import要
                // setMethodの第一引数のRTC_WAKEUPは「UTC時間を指定する。画面Sleeep中でもAlermを発行する」という指定
                // 第二引数でTaskの時間をUTC時間で指定
                val resultIntent = Intent(applicationContext, TaskAlarmReceiver::class.java)
                val resultPendingIntent = PendingIntent.getBroadcast(
                    this,
                    task.id,
                    resultIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT
                )

                // AlarmManagerはActivityのgetSystemServiceメソッドに引数ALARM_SERVICEを与えて取得
                // getSystemService MethodはSystemLevelのServiceを取得する

                // OnItemLongClickListenerの中でDBからTaskを削除するTimingでAlermを解除
                // Setした時と同じIntent、PendingIntentを作成し、AlarmManagerClassのcancelMethodでCansel
                val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
                alarmManager.cancel(resultPendingIntent)


                reloadListView()
            }

            builder.setNegativeButton("CANCEL", null)

            val dialog = builder.create()
            dialog.show()


            true
        }

        // Realm関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
        //Aplly起動時に表示Test用のTaskを作成する　Method使用　　あくまでTest用
        //  addTaskForTest()

        //ListVie関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
        //reloadListView Method を使用する
        // Realm関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
        // ListVie　を非表示にしたとき　Realm関連で使用
        reloadListView()

    }
    //onCreate Method END

    //ListVie関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
    //reloadListView Method では Adapter に Data を設定しなおしたあとに、
    //notifyDataSetChanged MEthod を使用することで Data が変わったことを伝えて List を再描画
    //notifyDataSetChanged Method　を使用する

    // Realm関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
    //RealmのDBで変更があった場合に呼び出されるreloadListViewMethod　の中身を追加修正
    private fun reloadListView() {

        //ListVie関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
        // 後で Task Class に変更する  あくまで仮
        // val taskList = mutableListOf("aaa", "bbb", "ccc")
        // mTaskAdapter.mTaskList = taskList
        // listView1.adapter = mTaskAdapter
        // mTaskAdapter.notifyDataSetChanged()

        // Realm関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
        // RealmDBから、「すべてのDataを取得して新しい日時順に並べた結果」を取得
        // Sort　import要
        // sortで"date"（日時）を Sort.DESCENDING（降順）で並べ替えた結果を返している
        // mRealm.copyFromRealm(taskRealmResults) で複製してAdapterに渡す
        // RealmのDBから取得した内容をAdapterなど別の場所で使う場合は、直接渡すのではなく、
        // このように複製して渡す必要がある　
        // mTaskAdapter.mTaskList　この時点では　まだ　代入　が通らない!!
        // 　Task　Class型で  わたってこないため  TaskAdapter.kt　Class 修正要

        val taskRealmResults
                = mRealm.where(Task::class.java).findAll().sort("date", Sort.DESCENDING)

        // 上記の結果を、TaskListとしてSetする
        mTaskAdapter.mTaskList = mRealm.copyFromRealm(taskRealmResults)

        // TaskのListView用のAdapterに渡す
        listView1.adapter = mTaskAdapter

        // 表示を更新するために、AdapterにDataが変更されたことを知らせる
        mTaskAdapter.notifyDataSetChanged()

    }


    // Realm関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
    // onDestroyMethodをOverrideしてRealmClassのcloseMethodを使用する
    // getDefaultInstanceMethodで取得したRealmClassのObjectはcloseMEてょｄで終了させる必要がある
    override fun onDestroy() {
        super.onDestroy()
        mRealm.close()
    }


    // Realm関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
    // Date()　import要
    // あくまで　Test用
    //    private fun addTaskForTest() {
    //        val task = Task()
    //        task.title = "作業"
    //        task.contents = "プログラムを書いてPUSHする"
    //        task.date = Date()
    //        task.id = 0
    //        mRealm.beginTransaction()
    //        mRealm.copyToRealmOrUpdate(task)
    //        mRealm.commitTransaction()
    //    }

}
//Class　END