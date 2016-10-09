package com.kotlinspringtemplatemaven.infrastructure.entity.springDB2

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * Created by teradashoutarou on 2016/10/09.
 */
@Entity
@Table(name="User")
class UserEntuty () {
    @Id var id : Int? = null
    var name : String = ""
}