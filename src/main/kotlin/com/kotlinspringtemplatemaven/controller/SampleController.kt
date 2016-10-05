package com.kotlinspringtemplatemaven.controller

import com.kotlinspringtemplatemaven.domain.dto.EmpDto
import com.kotlinspringtemplatemaven.domain.vo.EmpVo
import org.springframework.web.bind.annotation.*

/**
 * Created by teradashoutarou on 2016/10/05.
 */
@RestController
@RequestMapping("/api")
open class SampleController {

    @ResponseBody
    // Kotlinで通信方式を設定する場合には、arrayOfが必要
    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun getAll(): Array<EmpDto> {
        val empDto = EmpDto( "test", 1 )
        val empDtos = arrayOf( empDto )
        return empDtos
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = arrayOf(RequestMethod.GET))
    fun get( @PathVariable id : Int) : EmpDto {
        return EmpDto("name", id)
    }

    @ResponseBody
    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun post( @RequestBody id :Int ) : EmpDto {
        return  EmpDto("name", id)
    }

    @ResponseBody
    @RequestMapping( value = "/save", method = arrayOf(RequestMethod.POST))
    fun post( @RequestBody empVo : EmpVo ) {

    }

    @ResponseBody
    @RequestMapping( value = "/save", method = arrayOf(RequestMethod.PUT) )
    fun put( @RequestBody empVo : EmpVo ) {

    }

    @ResponseBody
    @RequestMapping( value = "{id}", method = arrayOf(RequestMethod.DELETE) )
    fun delete( @PathVariable id: Int ) {

    }
}