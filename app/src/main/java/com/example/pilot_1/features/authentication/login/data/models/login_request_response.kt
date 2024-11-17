package com.example.pilot_1.features.authentication.login.data.models
import com.google.gson.annotations.SerializedName

data class LoginRequestResponse(
    val data: Data,
    @SerializedName("status_code")
    val statusCode: Long,
    val meta: Any?,
)

data class Data(
    val id: Long,
    val username: String,
    val email: String,
    val mobile: String,
    @SerializedName("country_id")
    val countryId: Any?,
    val status: Long,
    val created: String,
    @SerializedName("temp_id")
    val tempId: String,
    val image: String,
    val currency: Any?,
    @SerializedName("added_by")
    val addedBy: String,
    @SerializedName("verify_code")
    val verifyCode: Any?,
    @SerializedName("passed_by_pass")
    val passedByPass: Long,
    @SerializedName("is_admin")
    val isAdmin: Long,
    @SerializedName("check_pledge")
    val checkPledge: Long,
    @SerializedName("verification_code")
    val verificationCode: Any?,
    @SerializedName("country_code")
    val countryCode: Any?,
    val message: Any?,
    @SerializedName("access_token")
    val accessToken: String,
)
