package ${pPackage}.${serviceName}.${serviceImplName};

import java.util.List;
import ${pPackage}.${pojoName}.<#list table.name?split('_') as s>${s?cap_first}</#list>;
import ${pPackage}.${serviceName}.<#list table.name?split('_') as s>${s?cap_first}</#list>Service;
import ${pPackage}.${daoName}.<#list table.name?split('_') as s>${s?cap_first}</#list>Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author ${author}
* @version 1.0
* @description: 用于实现<#list table.name?split('_') as s>${s?cap_first}</#list>Service接口中的函数
* @date ${.now?date}
*/
@Service
public class <#list table.name?split('_') as s>${s?cap_first}</#list>ServiceImpl implements <#list table.name?split('_') as s>${s?cap_first}</#list>Service {
    @Autowired
    <#list table.name?split('_') as s>${s?cap_first}</#list>Mapper <#list table.name?split('_') as s><#if s_index=0>${s?lower_case}<#else>${s?cap_first}</#if></#list>Mapper;

    /**
     * @return 以列表形式返回实体类对象
     * @description 查询所有数据
     * @author ${author}
     * @date ${.now?date}
     */
    @Override
    public ${returnValue} list<#list table.name?split('_') as s>${s?cap_first}</#list>(){
        List<<#list table.name?split('_') as s>${s?cap_first}</#list>> data = <#list table.name?split('_') as s><#if s_index=0>${s?lower_case}<#else>${s?cap_first}</#if></#list>Mapper.list<#list table.name?split('_') as s>${s?cap_first}</#list>();
        return ${successFunction}(data);
    }

    /**
     * @param ${table.key?lower_case} 主键id
     * @return 实体类对象
     * @description 根据id获取单条数据
     * @author ${author}
     * @date ${.now?date}
     */
    @Override
    public ${returnValue}  get<#list table.name?split('_') as s>${s?cap_first}</#list>By${table.key?cap_first}(${keyType} ${table.key?lower_case}){
        <#list table.name?split('_') as s>${s?cap_first}</#list> data =  <#list table.name?split('_') as s><#if s_index=0>${s?lower_case}<#else>${s?cap_first}</#if></#list>Mapper.get<#list table.name?split('_') as s>${s?cap_first}</#list>By${table.key?cap_first}(${table.key?lower_case});
        return ${successFunction}(data);
    }

    /**
     * @param page 页数
     * @param limit 每页限制数据量
     * @return 以列表形式返回实体类对象
     * @description 分页查询数据
     * @author ${author}
     * @date ${.now?date}
     */
    @Override
    public ${returnValue}  list<#list table.name?split('_') as s>${s?cap_first}</#list>ByPage(int page, int limit){
        int first = (page - 1) * limit;
        int second = limit;
        List<<#list table.name?split('_') as s>${s?cap_first}</#list>> data = <#list table.name?split('_') as s><#if s_index=0>${s?lower_case}<#else>${s?cap_first}</#if></#list>Mapper.list<#list table.name?split('_') as s>${s?cap_first}</#list>ByPage(first,second);
        return ${successFunction}(data);
    }

    /**
     * @param <#list table.name?split('_') as s><#if s_index=0>${s?lower_case}<#else>${s?cap_first}</#if></#list> 要添加的实体类
     * @return 大于等于1则插入成功
     * @description 插入数据
     * @author ${author}
     * @date ${.now?date}
     */
    @Override
    public ${returnValue} insert<#list table.name?split('_') as s>${s?cap_first}</#list>(<#list table.name?split('_') as s>${s?cap_first}</#list> <#list table.name?split('_') as s><#if s_index=0>${s?lower_case}<#else>${s?cap_first}</#if></#list>){
        if( <#list table.name?split('_') as s><#if s_index=0>${s?lower_case}<#else>${s?cap_first}</#if></#list>Mapper.insert<#list table.name?split('_') as s>${s?cap_first}</#list>(<#list table.name?split('_') as s><#if s_index=0>${s?lower_case}<#else>${s?cap_first}</#if></#list>) >= 1 ){
            return ${successFunction}("添加成功");
        }else{
            return ${successFunction}("添加失败");
        }
    }

    /**
     * @param <#list table.name?split('_') as s><#if s_index=0>${s?lower_case}<#else>${s?cap_first}</#if></#list> 要修改的实体类
     * @return 大于等于1则修改成功
     * @description 根据id修改数据
     * @author ${author}
     * @date ${.now?date}
     */
    @Override
    public ${returnValue} update<#list table.name?split('_') as s>${s?cap_first}</#list>By${table.key?cap_first}(<#list table.name?split('_') as s>${s?cap_first}</#list> <#list table.name?split('_') as s><#if s_index=0>${s?lower_case}<#else>${s?cap_first}</#if></#list>){
        if( <#list table.name?split('_') as s><#if s_index=0>${s?lower_case}<#else>${s?cap_first}</#if></#list>Mapper.update<#list table.name?split('_') as s>${s?cap_first}</#list>By${table.key?cap_first}(<#list table.name?split('_') as s><#if s_index=0>${s?lower_case}<#else>${s?cap_first}</#if></#list>) >= 1){
            return ${successFunction}("修改成功");
        }else{
            return ${successFunction}("修改失败");
        }
    }

    /**
     * @param ${table.key?lower_case} 主键id
     * @return 大于等于1则删除成功
     * @description 根据id删除数据
     * @author ${author}
     * @date ${.now?date}
     */
    @Override
    public ${returnValue} delete<#list table.name?split('_') as s>${s?cap_first}</#list>By${table.key?cap_first}(${keyType} ${table.key?lower_case}){
        if( <#list table.name?split('_') as s><#if s_index=0>${s?lower_case}<#else>${s?cap_first}</#if></#list>Mapper.delete<#list table.name?split('_') as s>${s?cap_first}</#list>By${table.key?cap_first}(${table.key?lower_case}) >= 1){
            return ${successFunction}("删除成功");
        }else{
            return ${successFunction}("删除失败");
        }
    }
}