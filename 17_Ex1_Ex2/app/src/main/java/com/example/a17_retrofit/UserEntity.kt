package com.example.a17_retrofit

import com.google.gson.annotations.SerializedName

class UserEntity {
    class AddressEntity {
        @SerializedName("street")
        var street: String = ""

        @SerializedName("suite")
        var suite: String = ""

        @SerializedName("city")
        var city: String = ""

        @SerializedName("zipcode")
        var zipcode: String = ""

        @SerializedName("geo")
        var geo: GeoEntity? = null
    }

    class GeoEntity {
        @SerializedName("lat")
        var lat: String = ""

        @SerializedName("lng")
        var lng: String = ""
    }

    class CompanyEntity {
        @SerializedName("name")
        var name: String = ""

        @SerializedName("catchPhrase")
        var catchPhrase: String = ""

        @SerializedName("bs")
        var bs: String = ""
    }

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("name")
    var name: String = ""

    @SerializedName("username")
    var username: String = ""

    @SerializedName("email")
    var email: String = ""

    @SerializedName("address")
    var address: AddressEntity? = null

    @SerializedName("phone")
    var phone: String = ""

    @SerializedName("website")
    var website: String = ""

    @SerializedName("company")
    var company: CompanyEntity? = null
}