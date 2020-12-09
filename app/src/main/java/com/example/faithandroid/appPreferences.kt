import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.faithandroid.models.Avatar
import com.example.faithandroid.network.FaithApiService
import retrofit2.Retrofit


object AppPreferences {
    private var sharedPreferences: SharedPreferences? = null

    // TODO step 1: call `AppPreferences.setup(applicationContext)` in your MainActivity's `onCreate` method
    fun setup(context: Context) {
        // TODO step 2: set your app name here
        sharedPreferences = context.getSharedPreferences("grow.sharedprefs", MODE_PRIVATE)
    }

    // TODO step 4: replace these example attributes with your stored values
    var username: String?
        get() = Key.USERNAME.getString()
        set(value) = if(value.equals("")){
            Key.USERNAME.remove()
        }else {
            Key.USERNAME.setString(value)
        }
    var token: String?
        get() = Key.TOKEN.getString()
        set(value) = if(value.equals("")){
           Key.TOKEN.remove()
        }else{
            Key.TOKEN.setString(value)
        }

    var darkMode: Boolean?
        get() = Key.DARKMODE.getBoolean()
        set(value) = Key.DARKMODE.setBoolean(value)

    var spotifyToken: String?
        get() = Key.SPOTIFYTOKEN.getString()
        set(value) = Key.SPOTIFYTOKEN.setString(value)

    var currentPerson: Int?
        get() = Key.CURRENTPERSON.getInt()
        set(value) = Key.CURRENTPERSON.setInt(value)

    var currentHair: Int?
        get() = Key.CURRENTHAIR.getInt()
        set(value) = Key.CURRENTHAIR.setInt(value)

    var currentEyes: Int?
        get() = Key.CURRENTEYES.getInt()
        set(value) = Key.CURRENTEYES.setInt(value)

    var currentSkin: Int?
        get() = Key.CURRENTSKIN.getInt()
        set(value) = Key.CURRENTSKIN.setInt(value)

    var currentBody: Int?
        get() = Key.CURRENTBODY.getInt()
        set(value) = Key.CURRENTBODY.setInt(value)

    private enum class Key {

        USERNAME, TOKEN, SPOTIFYTOKEN, DARKMODE,
        CURRENTPERSON, CURRENTHAIR, CURRENTEYES, CURRENTSKIN, CURRENTBODY; // TODO step 3: replace these cases with your stored values keys

        fun getBoolean(): Boolean? = if (sharedPreferences!!.contains(name)) sharedPreferences!!.getBoolean(name, false) else null
        fun getFloat(): Float? = if (sharedPreferences!!.contains(name)) sharedPreferences!!.getFloat(name, 0f) else null
        fun getInt(): Int? = if (sharedPreferences!!.contains(name)) sharedPreferences!!.getInt(name, 0) else null
        fun getLong(): Long? = if (sharedPreferences!!.contains(name)) sharedPreferences!!.getLong(name, 0) else null
        fun getString(): String? = if (sharedPreferences!!.contains(name)) sharedPreferences!!.getString(name, "") else null

        fun setBoolean(value: Boolean?) = value?.let { sharedPreferences!!.edit { putBoolean(name, value) } } ?: remove()
        fun setFloat(value: Float?) = value?.let { sharedPreferences!!.edit { putFloat(name, value) } } ?: remove()
        fun setInt(value: Int?) = value?.let { sharedPreferences!!.edit { putInt(name, value) } } ?: remove()
        fun setLong(value: Long?) = value?.let { sharedPreferences!!.edit { putLong(name, value) } } ?: remove()
        fun setString(value: String?) = value?.let { sharedPreferences!!.edit { putString(name, value) } } ?: remove()

        fun remove() = sharedPreferences!!.edit { remove(name) }
    }
}