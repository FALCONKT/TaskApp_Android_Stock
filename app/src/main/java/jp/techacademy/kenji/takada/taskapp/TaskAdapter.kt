package jp.techacademy.kenji.takada.taskapp

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

//ListVie関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
//BaseAdapter Class を継承
//→　Method定義　は　自動で　行って　その中に入れ込んでいく
class TaskAdapter(context: Context) : BaseAdapter() {

    //ListVie関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
    //Itemを保持するListをtaskList＝変数名　Propertyで定義　<>は配列の型　ここではClass型
    //Class名はTaskを表す Task Classに後で修正、
    //しかし、先ずははStringClassとする。　Task　Class　を実装するまえに、ListViewの動きを確認するため
    //var mTaskList= mutableListOf<String>()  // 仮！！！！！！！！！！！！！」


    // Realm関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
    //ArrayListの型をTaskClsssに変更
    var mTaskList= mutableListOf<Task>()

    //ListView関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
    //他のxmlのViewを取り扱うための仕組みであるLayoutInflaterをPropertyとして定義
    //要　import
    private val mLayoutInflater: LayoutInflater

    //ListView関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
    //Constructorで　LayoutInflater　を初期化
    //Class名の引数に指定する必要がある
    init {
        // LayoutInflaterのfrom Method
        this.mLayoutInflater = LayoutInflater.from(context)
    }


    //ListVie関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
    //getCount　Method、getItem　Method　で　それぞれの　Size=要素数　と　要素　を返す
    override fun getCount(): Int {
//        要素数　を戻す
        return mTaskList.size
    }

    override fun getItem(position: Int): Any {
//        場所 ＝　要素　を戻す
        return mTaskList[position]


    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    //■　Category関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
    //■  見た目のみ反映用　　ここでの指定が　見た目に反映される
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //ListVie関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
        //convertViewがnullのときはLayoutInflaterを使ってsimple_list_item_2からViewを取得
        //Elvis演算子?:は左辺がnullの時に右辺を返す
        //simple_list_item_2はTitleとSubTitleがあるSell
        //仮で　まずはString型で保持しているmTaskListから文字列を取得しTitleを設定するように実装

        //ListVie関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
        //getViewメソッドの引数であるconvertView、が現在表示しようとしている行がnullかどうか判定を行っている
        //BaseAdapterにViewを再利用して描画する仕組みがあるため
        //TextView　Class型　は　import要
        val view: View = convertView ?: mLayoutInflater.inflate(R.layout.simple_list_item_2, null)

        val textView1 = view.findViewById<TextView>(R.id.text1)
        val textView2 = view.findViewById<TextView>(R.id.text2)


        //ListVie関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
        // 後でTask　Classから情報を取得するように変更する　　その前提設定
        // 仮　String型の内容を仮に出しているだけ
        // textView1.text = mTaskList[position]　

        // Realm関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
        // TaskのTitleと時間をTextViewに設定　　Title
        textView1.text = mTaskList[position].title

        // Realm関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
        // TaskのTitleと時間をTextViewに設定　 時間
        //SimpleDateFormat　Locale　　　それぞれ　import 要
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.JAPANESE)
        val date = mTaskList[position].date
        textView2.text = simpleDateFormat.format(date)



        return view
        }

}
//Class　END
