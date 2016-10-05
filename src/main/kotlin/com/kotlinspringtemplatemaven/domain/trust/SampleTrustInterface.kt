package com.kotlinspringtemplatemaven.domain.trust

import com.kotlinspringtemplatemaven.domain.dto.EmpDto

/**
 * Created by teradashoutarou on 2016/10/05.
 */
interface SampleTrustInterface {

    fun getAll() :Array<EmpDto>

    fun get( id : Int ): EmpDto

    fun save( empDto : EmpDto )

    fun delete( id : Int )
}