import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class Countries(

    @SerializedName("country") val country: String,
    @SerializedName("cases") val cases: Int,
    @SerializedName("countryInfo") val countryInfo: CountryInfo,
    @SerializedName("todayCases") val todayCases: Int,
    @SerializedName("deaths") val deaths: Int,
    @SerializedName("todayDeaths") val todayDeaths: Int,
    @SerializedName("recovered") val recovered: Int,
    @SerializedName("active") val active: Int,
    @SerializedName("critical") val critical: Int,
    @SerializedName("tests") val tests: Int

) : Parcelable