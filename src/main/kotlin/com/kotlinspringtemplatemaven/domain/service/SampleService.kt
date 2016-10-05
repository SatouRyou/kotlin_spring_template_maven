package com.kotlinspringtemplatemaven.domain.service

import com.kotlinspringtemplatemaven.domain.dto.EmpDto
import com.kotlinspringtemplatemaven.domain.trust.SampleTrustInterface
import com.kotlinspringtemplatemaven.domain.vo.EmpVo
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

/**
 * Created by teradashoutarou on 2016/10/05.
 */
@Service
@Component
class SampleService {

    @Autowired
    private lateinit var sampleTrust : SampleTrustInterface

    fun getAll() : Array<EmpDto> {
        return this.sampleTrust.getAll();
    }

    fun get( id :Int ) : EmpDto {
        return this.get( id );
    }

    fun save( empVo : EmpVo ) {
        val empDto = EmpDto()
        BeanUtils.copyProperties(empDto,empVo)
        this.sampleTrust.save( empDto )
    }

    fun delete( id :Int ) {
        sampleTrust.delete( id )
    }
}