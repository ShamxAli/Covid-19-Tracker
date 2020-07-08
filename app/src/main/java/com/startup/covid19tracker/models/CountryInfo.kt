import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class CountryInfo(
    @SerializedName("flag") val flag: String
) : Parcelable