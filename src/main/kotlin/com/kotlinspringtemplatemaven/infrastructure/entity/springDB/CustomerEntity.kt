package com.kotlinspringtemplatemaven.infrastructure.entity.springDB

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * Created by teradashoutarou on 2016/10/09.
 */
@Entity
@Table(name="Customer")
class CustomerEntity () {
    @Id var id : Int? = null
    var name : String = ""
    var sex : String = ""
    var age : Int = 0
}