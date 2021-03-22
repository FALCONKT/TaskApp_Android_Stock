package jp.techacademy.kenji.takada.taskapp

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

import java.io.Serializable
//Realm関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
//import java.io.Serializable
//のみ手動で行う！！！！！


//Realm関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
//生成したObjectをSerializeできるように。
//Serializable　は　interface
//Dataを丸ごとFileに保存したり、TaskAppでいうと別のActivityに渡すことができるようにすること

//open修飾子　は　Realm　が内部的にTaskを継承したClassを作成して利用するため指定する
open class Task : RealmObject(), Serializable {
    var title: String = ""      // Title
    var contents: String = ""   // 内容
    var date: Date = Date()     // 日時

    //■　Category関連　＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
//    var category:String = "" // Category=分野

    // idをPrimaryKeyとして設定
    @PrimaryKey
    var id: Int = 0
}





