package jp.techacademy.kenji.takada.taskapp

import android.app.Application
import io.realm.Realm

//Realm関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
//Application を継承している
class TaskApp: Application() {

    //Realm関連＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
    //nCreateMEthodをOverride
    //Realm.init(this)をしてRealmを初期化
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}