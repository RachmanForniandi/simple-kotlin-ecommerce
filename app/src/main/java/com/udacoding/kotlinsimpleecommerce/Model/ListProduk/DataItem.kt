package com.udacoding.kotlinsimpleecommerce.Model.ListProduk

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("harga")
	val harga: String? = null,

	@field:SerializedName("jenis")
	val jenis: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("stok")
	val stok: String? = null,

	@field:SerializedName("promo")
	val promo: String? = null,

	@field:SerializedName("gambar")
	val gambar: String? = null
)